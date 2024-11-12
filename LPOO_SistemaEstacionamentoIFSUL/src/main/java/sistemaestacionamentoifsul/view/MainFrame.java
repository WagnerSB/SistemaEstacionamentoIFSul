/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemaestacionamentoifsul.view;

/**
 *
 * @author 20231PF.CC0021
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        miPessoa = new javax.swing.JMenuItem();
        miVeiculo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miEntradaVeiculo = new javax.swing.JMenuItem();
        miSaidaVeiculo = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        miSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuCadastro.setText("Cadastro");

        miPessoa.setText("Pessoa");
        miPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPessoaActionPerformed(evt);
            }
        });
        menuCadastro.add(miPessoa);

        miVeiculo.setText("Veiculo");
        miVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVeiculoActionPerformed(evt);
            }
        });
        menuCadastro.add(miVeiculo);

        jMenuBar1.add(menuCadastro);

        jMenu2.setText("Movimentacoes");

        miEntradaVeiculo.setText("Entrada");
        miEntradaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEntradaVeiculoActionPerformed(evt);
            }
        });
        jMenu2.add(miEntradaVeiculo);

        miSaidaVeiculo.setText("Saida");
        jMenu2.add(miSaidaVeiculo);

        jMenuBar1.add(jMenu2);

        menuAjuda.setText("Ajuda");

        miSobre.setText("Sobre");
        miSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(miSobre);

        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPessoaActionPerformed
        TelaPessoa telaPessoa = new TelaPessoa();
        telaPessoa.setVisible(true);
    }//GEN-LAST:event_miPessoaActionPerformed

    private void miVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miVeiculoActionPerformed

    private void miEntradaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEntradaVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miEntradaVeiculoActionPerformed

    private void miSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSobreActionPerformed
        TelaSobre telaSobre = new  TelaSobre(this, rootPaneCheckingEnabled);
        telaSobre.setVisible(true);
    }//GEN-LAST:event_miSobreActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem miEntradaVeiculo;
    private javax.swing.JMenuItem miPessoa;
    private javax.swing.JMenuItem miSaidaVeiculo;
    private javax.swing.JMenuItem miSobre;
    private javax.swing.JMenuItem miVeiculo;
    // End of variables declaration//GEN-END:variables
}
