/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package sistemaestacionamentoifsul.view;

import java.awt.Frame;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Modelo;
import model.Pessoa;
import model.TipoVeiculo;
import model.Veiculo;
import model.VeiculoOficial;
import model.VinculoPessoa;
import sistemaestacionamentoifsul.dao.PersistenciaJPA;

/**
 *
 * @author 20231PF.CC0021
 */
public class TelaCadastroVeiculo extends javax.swing.JDialog {
    private Veiculo veiculo;
    PersistenciaJPA jpa;
    
    

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        txtPlaca.setText(veiculo.getPlaca());
        txtCor.setText(veiculo.getCor());
        cmbTipoVeiculo.setSelectedItem(veiculo.getTipoVeiculo());
        cmbProprietario.setSelectedItem(veiculo.getProprietario());
        cmbModelo.setSelectedItem(veiculo.getModelo());  
    }
    
    

    /**
     * Creates new form TelaCadastroPessoa
     */
    public TelaCadastroVeiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jpa = new PersistenciaJPA();
        carregarTiposVeiculos();
        carregarProprietarios();
        carregarModelos();
    }
    
    
    public void carregarTiposVeiculos(){
        cmbTipoVeiculo.removeAllItems();
        for(TipoVeiculo item: TipoVeiculo.values()){
            cmbTipoVeiculo.addItem(item);
        }
    }
    
    public void carregarProprietarios(){
        cmbProprietario.removeAllItems();
        jpa.conexaoAberta();
        
        List<Pessoa> proprietarios = jpa.getPessoas();
        for (Pessoa item : proprietarios) {
            cmbProprietario.addItem(item);
        }
        
        jpa.fecharConexao();
    }
    
    public void carregarModelos(){
        cmbModelo.removeAllItems();
        jpa.conexaoAberta();
        List<Modelo> modelos = jpa.getModelos();
        for (Modelo item : modelos) {
            cmbModelo.addItem(item);
        }
        
        jpa.fecharConexao();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastroPessoa = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        lblCor = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbTipoVeiculo = new javax.swing.JComboBox<>();
        lblTipoVeiculo = new javax.swing.JLabel();
        lblProprietario = new javax.swing.JLabel();
        cmbProprietario = new javax.swing.JComboBox<>();
        cmbModelo = new javax.swing.JComboBox<>();
        lblModelo = new javax.swing.JLabel();
        lblVeiculoOficial = new javax.swing.JLabel();
        cbVeiculoOficial = new javax.swing.JCheckBox();
        txtChassi = new javax.swing.JTextField();
        lblChassi = new javax.swing.JLabel();
        txtRenavan = new javax.swing.JTextField();
        lblRenavan = new javax.swing.JLabel();
        btnAdicionarModelo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCadastroPessoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCadastroPessoa.setText("Cadastro de Pessoa:");

        lblPlaca.setText("Placa:");

        lblCor.setText("Cor:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTipoVeiculo.setText("Tipo:");

        lblProprietario.setText("Proprietario:");

        lblModelo.setText("Modelo:");

        lblVeiculoOficial.setText("Oficial:");

        cbVeiculoOficial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVeiculoOficialActionPerformed(evt);
            }
        });

        txtChassi.setEnabled(false);

        lblChassi.setText("Chassi:");

        txtRenavan.setEnabled(false);

        lblRenavan.setText("Renavan:");

        btnAdicionarModelo.setText("+");
        btnAdicionarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarModeloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlaca)
                            .addComponent(lblCor)
                            .addComponent(lblTipoVeiculo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbTipoVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPlaca)
                            .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblCadastroPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVeiculoOficial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbVeiculoOficial))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblChassi)
                            .addGap(18, 18, 18)
                            .addComponent(txtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblModelo)
                            .addGap(18, 18, 18)
                            .addComponent(cmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnAdicionarModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblProprietario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblRenavan)
                            .addGap(18, 18, 18)
                            .addComponent(txtRenavan))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCadastroPessoa)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlaca)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipoVeiculo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProprietario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo)
                    .addComponent(btnAdicionarModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVeiculoOficial)
                    .addComponent(cbVeiculoOficial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChassi)
                    .addComponent(txtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRenavan)
                    .addComponent(txtRenavan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(veiculo == null) {
            if (cbVeiculoOficial.isSelected()) {
            veiculo = new VeiculoOficial();
            } else {
                veiculo = new Veiculo();
            }
        }
        
        veiculo.setPlaca(txtPlaca.getText());
        veiculo.setCor(txtCor.getText());
        veiculo.setTipoVeiculo((TipoVeiculo) cmbTipoVeiculo.getSelectedItem());
        veiculo.setProprietario((Pessoa) cmbProprietario.getSelectedItem());
        veiculo.setModelo((Modelo) cmbModelo.getSelectedItem());
        
        //        Se for um veículo oficial
        if (cbVeiculoOficial.isSelected()) {
            VeiculoOficial veiculoOficial = (VeiculoOficial) veiculo;
            veiculoOficial.setChassi(txtChassi.getText());
            veiculoOficial.setRenavan(txtRenavan.getText());
    }
        
        jpa.conexaoAberta();
        try {
            jpa.persist(veiculo);
        } catch (Exception e) {
            Logger.getLogger(TelaVeiculo.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Erro ao persistir veiculo: "+veiculo+" \n Erro: "+e);
        }
        jpa.fecharConexao();
        dispose();
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbVeiculoOficialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVeiculoOficialActionPerformed
        boolean isOficial = cbVeiculoOficial.isSelected();
    
        txtChassi.setEnabled(isOficial);
        txtRenavan.setEnabled(isOficial);

        if (!isOficial) {
            txtChassi.setText("");
            txtRenavan.setText("");
        }
    }//GEN-LAST:event_cbVeiculoOficialActionPerformed

    private void btnAdicionarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarModeloActionPerformed
        TelaCadastroModelo telaCadastroModelo = new TelaCadastroModelo((Frame) this.getParent(), true);
        telaCadastroModelo.setVisible(true);
        
        carregarModelos();
    }//GEN-LAST:event_btnAdicionarModeloActionPerformed

    
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
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroVeiculo dialog = new TelaCadastroVeiculo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarModelo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbVeiculoOficial;
    private javax.swing.JComboBox<Modelo> cmbModelo;
    private javax.swing.JComboBox<Pessoa> cmbProprietario;
    private javax.swing.JComboBox<TipoVeiculo> cmbTipoVeiculo;
    private javax.swing.JLabel lblCadastroPessoa;
    private javax.swing.JLabel lblChassi;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblProprietario;
    private javax.swing.JLabel lblRenavan;
    private javax.swing.JLabel lblTipoVeiculo;
    private javax.swing.JLabel lblVeiculoOficial;
    private javax.swing.JTextField txtChassi;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtRenavan;
    // End of variables declaration//GEN-END:variables
}
