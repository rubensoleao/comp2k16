#include<stdio.h>
#include"str.h"

void sub(char *a, char *b, char *c){
	int pos = slocate(a, b);
	printf("pos = %i\n", pos);
	while(pos != -1){
		sremove(a, pos, slen(c));
		printf("%s\n", a);
		sinsert(a, c, pos);
		pos = slocate(a, b);
	}
}

int main(){
	char a[100], b[100], c[100];
	printf("Digite uma frase:");
	scanf("%[^\n]%*c", a);
	printf("Digite a palavra a ser substituida:");
	scanf("%[^\n]%*c", b);
	printf("Digite a palavra substituta:");
	scanf("%[^\n]%*c", c);
	
	sub(a, b, c);

	printf("%s\n", a);

	return 0;
}
