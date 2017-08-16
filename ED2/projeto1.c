
#include<stdio.h>
#include<time.h>

#include"util.h"

#define MAX_READY_SIZE 5
#define MAX_QUANTUM_SIZE 20

int main(int argc, char *args[]){
    //Variavel para todos os usos
    int x;

    //Preparar a "aleatoriade"
    srand(time(NULL));

    //Gerar ids validos
    for(x = 0; x < 65536; x++)
        idDisponiveis[x] = x;

    //Filas
    PROC *jobs = NULL, *ready = NULL, *device = NULL;
    PCB *PCBT = NULL, *pcb = NULL;


    //Loop principal
    for (;;) {
        /*
            Flags
            0x01 -> Interrupção
            0x02 -> Encerrado
        */
        char f = 0;

        puts("1");

        //ALEATORIEDADES
        //Adicionar um processo
        if(rand()%60000 < 60000-queueSize(jobs)){
            PROC *novo = (PROC*)malloc(sizeof(PROC));
            //Criar instruções
            unsigned char pointer = 0;
            do{
                unsigned char teste = rand()%256;
                if(teste < 250)
                    novo->text[pointer] = teste;
                else if(teste < 253)
                    novo->text[pointer] = 0xFD;
                else
                    novo->text[pointer] = 0xFF;
                pointer++;
            }while(novo->text[pointer-1] != 0xFF && pointer < 255);
            if(pointer == 255)
                novo->text[pointer] = 0xFF;
            //Atribuir id valido
            novo->id = getId();
            //Prencher PCB
            novo->pcb.id = novo->id;
            novo->pcb.PS = 0;
            novo->pcb.PC = 0;
            novo->pcb.T = 0;
            novo->pcb.p = NULL;
            //O novo programa ainda não tem próximo
            novo->p = NULL;

            //Adicionar na fila de trabalhos
            jobs = queueAdd(jobs, novo);
        }

        puts("2");

        //A fila de programas prontos não está cheia
        if(queueSize(ready) < MAX_READY_SIZE){
            //Adicionar trabalho da fila de espera a fila de programas prontos
            PROC *aux = jobs;
            aux->p = NULL;
            jobs = queueRemove(jobs);
            pcb = addPCB(pcb, aux->pcb);
            if(ready != NULL)
                ready = queueAdd(ready, aux);
            else{
                ready = aux;
                ready->p = aux;
            }
        }

        puts("3");


        char quantum = 0;
        if(queueSize(ready) > 0){
            //RODAR
            //Ir para o próximo ready
            ready = ready->p;
            //Pegar mover PCBT para o PCB relacionado ao processo rodando agora
            PCBT = getPCB(pcb, ready->id);
            printf("%p\n", PCBT);
            //Executar as instruções do processo a menos que, o seu quantum tenha se esgotado ou suas instruções tenham acabado
            while (quantum < 20 && ready->text[PCBT->PC] != 0xFF){
                puts("A");
                //Aumenta a posição do contador de programa
                PCBT->PC++;
                puts("B");
                //Aumenta o tempo de execução do programa
                PCBT->T++;
                puts("C");
                //Aumenta o quantum do programa
                quantum++;
                puts("D");
                //Copiar o PCBT de volta pro PCB no processo
                ready->pcb = *PCBT;
                ready->pcb.p = NULL;
                puts("E");
                //Interrupção
                if(ready->text[PCBT->PC] == 0xFD){
                    //Setar flag
                    f |= 0x01;
                    //Adicionar o processo atual a fila de dispositivos
                    PROC *aux = ready;
                    ready = queueRemove(ready);
                    device = queueAdd(device, aux);
                    //Remover o PCB associado da PCBT
                    pcb = purgePCB(PCBT, pcb);
                    break;
                }
                puts("D");
            }

            //Verificar se o processo foi encerrado (Caso ele não tenha ido pra fila de dispositivos)
            if(!(f & 0x01) && (ready->text[PCBT->PC] == 0xFF || ready->text[PCBT->PC + 1] == 0xFF)){
                //Setar flag
                f |= 0x02;
                //Eliminar processo
                ready = queuePurge(ready);
            }

        }

        puts("4");

        //Printar os dados da rodada
        puts("Dados:");
        printf("Quantum utilizado: %d\n", quantum);
        printf("Processos na fila de jobs: %d\n", queueSize(jobs));
        printf("Processos na fila de prontos: %d\n", queueSize(ready));
        printf("Processos na fila de dispositivos: %d\n", queueSize(device));
        if(f & 0x01)
            puts("Processo interrompido.");
        if(f & 0x02)
            puts("Processo concluido.");

        system("pause");
    }
}
