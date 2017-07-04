import java.util.*;

/**
 *
 * @author Reinaldo
 */
public class Login extends javax.swing.JFrame {
   
    private static List<Gerente> gerentes;
    private static List<VendedorS> vendedoresSenior;
    private static List<VendedorJr> vendedoresJunior;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Foghette");

        jLabel2.setText("Usuario");

        userField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Senha");

        loginButton.setText("Entrar");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userField)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        //Logar
        String user, password;
        user = userField.getText().toString();
        password = String.valueOf(passwordField.getPassword()); 
        List<Funcionario> f = new ArrayList<Funcionario>();
        for(Funcionario p : gerentes)
            f.add(p);
        for(Funcionario p : vendedoresSenior)
            f.add(p);
        for(Funcionario p : vendedoresJunior)
            f.add(p);
        
        //Checar se eh gerente
        for(Gerente gerente : gerentes){                  
            if(gerente.getUsuario().equals(user) && gerente.getSenha().equals(password)){
                //Instancia o formulario do gerente
                MainGerente main = new MainGerente(f);
                //Passa os funcionarios carregados para não carregar de novo
                main.setGerentes(gerentes);
                main.setVendedoresS(vendedoresSenior);
                main.setVendedoresJr(vendedoresJunior);
                //Passa o usuario que foi logado
                main.setUsuario(gerente);
                //Começa o formulario principal
                main.setVisible(true);
                //Termina esse formulario
                this.setVisible(false);
            }
        }
        
        //Checar se eh vendedor
        for(VendedorS vendedorSenior : vendedoresSenior){                  
            if(vendedorSenior.getUsuario().equals(user) && vendedorSenior.getSenha().equals(password)){
                //Instancia o formulario do vendedor
                MainGerente main = new MainGerente(f);
                //Passa os funcionarios carregados para não carregar de novo
                main.setGerentes(gerentes);
                main.setVendedoresS(vendedoresSenior);
                main.setVendedoresJr(vendedoresJunior);
                //Passa o usuario que foi logado
                main.setUsuario(vendedorSenior);
                //Começa o formulario principal
                main.setVisible(true);
                //Termina esse formulario
                this.setVisible(false);
            }
        }
        
        //Checar se eh vendedor
        for(VendedorJr vendedorJunior : vendedoresJunior){                  
            if(vendedorJunior.getUsuario().equals(user) && vendedorJunior.getSenha().equals(password)){
                //Instancia o formulario do vendedor
                MainGerente main = new MainGerente(f);
                //Passa os funcionarios carregados para não carregar de novo
                main.setGerentes(gerentes);
                main.setVendedoresS(vendedoresSenior);
                main.setVendedoresJr(vendedoresJunior);
                //Passa o usuario que foi logado
                main.setUsuario(vendedorJunior);
                //Começa o formulario principal
                main.setVisible(true);
                //Termina esse formulario
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //Carregar funcionarios do arquivo
        FilesIO gerenteFile = new FilesIO(Dados.GERENTES_PATH);
        gerentes = gerenteFile.read();
        FilesIO seniorFile = new FilesIO(Dados.SENIORS_PATH);
        vendedoresSenior = seniorFile.read();
        FilesIO juniorFile = new FilesIO(Dados.JUNIORS_PATH);
        vendedoresJunior = juniorFile.read();
        //Apontar o ponteiro de gerente responsavel pro gerente correto
        for(VendedorJr junior : vendedoresJunior)
            if(!junior.atualizaGerente(gerentes))
                System.out.println("GERENTE RESPONSAVEL DE " + junior.getNome().toUpperCase() + " NAO ENCONTRADO!");
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
