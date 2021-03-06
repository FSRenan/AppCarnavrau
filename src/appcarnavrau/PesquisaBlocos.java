/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcarnavrau;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class PesquisaBlocos extends javax.swing.JFrame {

    private ArrayList<Bloco> blocos = new ArrayList();
    private String endereco;
    private Bloco bcProximos[] = new Bloco[3];

    public PesquisaBlocos() {

    }

    //Adicionar construtor com endereco 
    public PesquisaBlocos(String endereco) throws Exception {
        initComponents();
        //Receberá do construtor o endereco da tela de login
        atualizarArray(endereco);
        txtEndereco.setText(endereco);

    }

    public void atualizarArray(String endereco) throws Exception {
        blocos.clear();
        //Adicionando blocos e suas informações ao Array 
        blocos.add(new Bloco("Casa Comigo", "Avenida Faria Lima", endereco, "São Paulo", "03 de Março"));
        blocos.add(new Bloco("Ma-que-bloco", "Rua Maria Borba, 86", endereco, "São Paulo", "03 de Março"));
        blocos.add(new Bloco("Bloco da Catuaba", "Rua Augusta, São Paulo", endereco, "São Paulo", "04 de Março"));
        blocos.add(new Bloco("Bloco da Ponte Torta", "Vianelo, Jundiaí", endereco, "Jundiaí", "05 de Março"));

        //
    }

    public Bloco[] blocosProximos() {

        Collections.sort(blocos);
        for (int i = 0; i < 3; i++) {
            if (blocos.get(i) != null) {
                bcProximos[i] = blocos.get(i);
            }
        }
        return bcProximos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbBlocos = new javax.swing.JComboBox<>();
        cbDia = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox<>();
        txtEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nomeB = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblDist = new javax.swing.JLabel();
        lblTempo = new javax.swing.JLabel();
        lblBloco = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setPreferredSize(new java.awt.Dimension(435, 670));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/button_pesquisar.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 170, 46));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/button_voltar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 570, 123, 46));

        cbBlocos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbBlocos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informe o Bloco" }));
        cbBlocos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBlocosActionPerformed(evt);
            }
        });
        jPanel1.add(cbBlocos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, 30));

        cbDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "03 de Março", "04 de Março", "05 de Março" }));
        cbDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDiaActionPerformed(evt);
            }
        });
        jPanel1.add(cbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/ender.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        cbCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informe a Cidade", "São Paulo", "Jundiaí" }));
        cbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCidadeActionPerformed(evt);
            }
        });
        jPanel1.add(cbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 150, 30));

        txtEndereco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEndereco.setForeground(new java.awt.Color(204, 204, 204));
        txtEndereco.setText("Digite o endereço");
        txtEndereco.setToolTipText("");
        txtEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEnderecoMouseClicked(evt);
            }
        });
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });
        jPanel1.add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 340, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/cidade.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        jPanel1.add(nomeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/bloco.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/bloco.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/tempo.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/dista.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/dia.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/magnifier-tool-on-earth-globe_icon-icons.com_56919.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 60, 100));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/info.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        lblDist.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jPanel1.add(lblDist, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

        lblTempo.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jPanel1.add(lblTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, 20));

        lblBloco.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jPanel1.add(lblBloco, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/Theatre_Mask_icon-icons.com_54130.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/drunkleprechaun_patrick_10580.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 250, 190));

        lblFundo.setText("jLabel8");
        jPanel1.add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 430, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEnderecoMouseClicked

        txtEndereco.setText("");
        txtEndereco.setForeground(Color.BLACK);

    }//GEN-LAST:event_txtEnderecoMouseClicked

    private void cbBlocosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBlocosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBlocosActionPerformed

    //Método para usar no botão de pesquisa
    private void blocoSelecionado(String bloco) {

        if (cbBlocos.getSelectedItem().equals(bloco)) {
            //Percorre array para localizar o bloco
            for (Bloco bc : blocos) {
                System.out.println(bc.getNome());
                if (bc.getNome().equals(bloco)) {
                    lblBloco.setText(bc.getNome());
                    lblDist.setText(bc.getKm() + "");
                    lblTempo.setText(bc.getTempo());
                }
            }
        }
    }
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        endereco = txtEndereco.getText();
        try {
            atualizarArray(endereco);
        } catch (Exception ex) {
        }
        blocoSelecionado(cbBlocos.getSelectedItem().toString());
//            JOptionPane.showMessageDialog(null, "Digite um "
//                                 + "endereço válido.", "ALERTA!", JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cbDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiaActionPerformed
        cbBlocos.removeAllItems();
        cbCidade.setSelectedItem("Informe a Cidade");

        cbBlocos.addItem("Informe o Bloco");
    }//GEN-LAST:event_cbDiaActionPerformed

    private void cbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCidadeActionPerformed

        cbBlocos.removeAllItems();
        cbBlocos.addItem("Informe o Bloco");
        //Percorre Array e verifica quais blocos tem a cidade e o dia selecionados
        for (Bloco bc : blocos) {
            if (cbCidade.getSelectedItem().equals(bc.getCidade()) && cbDia.getSelectedItem().equals(bc.getDia())) {
                cbBlocos.addItem(bc.getNome().toString());
            }
        }

    }//GEN-LAST:event_cbCidadeActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed

    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {            
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisaBlocos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaBlocos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaBlocos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaBlocos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PesquisaBlocos().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(PesquisaBlocos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cbBlocos;
    private javax.swing.JComboBox<String> cbCidade;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBloco;
    private javax.swing.JLabel lblDist;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JLabel nomeB;
    private javax.swing.JTextField txtEndereco;
    // End of variables declaration//GEN-END:variables
}
