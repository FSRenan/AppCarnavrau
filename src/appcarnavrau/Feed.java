package appcarnavrau;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import twitter4j.MediaEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Feed extends javax.swing.JFrame {

    //Atributos da classe
    private DadosUsuario dados;

    //Construtores
    public Feed() {

    }

    public Feed(DadosUsuario dados) {
        this.dados = dados;
        initComponents();
            //Faz autentificação para conexão com o twitter
        ConfigurationBuilder cf = new ConfigurationBuilder();
        //Faz a autentificação com os tokens de acesso
        cf.setDebugEnabled(true)
                .setOAuthConsumerKey("RBGiXtHUXPuhRhvc5PxHaV9bq")
                .setOAuthConsumerSecret("Ue9921E7uvzKdklJnmksrNO8n3kDnddxDfMlmXIW76qhxnqeBg")
                .setOAuthAccessToken("842735810021613573-0Gi12yk5ZEJ8XZCdsqea3VQPZa3DzkW")
                .setOAuthAccessTokenSecret("EzYLeI890fIp3sg7eYhAzc3hpGHMDzjZ9CaJCcyXKEaSX");

        
        TwitterFactory tf = new TwitterFactory(cf.build());
        twitter4j.Twitter twitter = tf.getInstance();
        //Filtras imagens com a hashtag
        Query query = new Query("filter:images" + "#g1");

        try {
            QueryResult result = twitter.search(query);
            int j = 0;
            for (Status status : result.getTweets()) {
                MediaEntity[] media = status.getMediaEntities(); //get the media entities from the status
                for (MediaEntity m : media) { //search trough your entities
                 System.out.println(m.getMediaURL()); //get your url!
                    URL url = new URL(m.getMediaURL());
                    if (j == 0) {
                        lblFOTO4.setIcon(MostrarImagem(url,lblFOTO4));
                        System.out.println(url);
                    }
                    if (j == 1) {
                        lblFOTO2.setIcon(MostrarImagem(url,lblFOTO4));
                        System.out.println(url);
                    }
                    if (j == 2) {
                        lblFOTO3.setIcon(MostrarImagem(url,lblFOTO4));
                    }
                    if (j == 3) {
                        lblFOTO1.setIcon(MostrarImagem(url,lblFOTO4));
                    }
                    j++;
                }
            }
        } catch (TwitterException ex) {
            Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    public ImageIcon MostrarImagem(URL local,javax.swing.JLabel label) {
        //Cria um imagem icon a partir do local selecionado
        ImageIcon img = new ImageIcon(local);
        //Transforma o ImageIcon para Image para conseguir redimensionar     
        Image minhaImagem = img.getImage();
        //Redimenciona imagem do tamanho do Jlabel
        Image newImg = minhaImagem.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        //Cria um image icon com imagem redimencionada pro tamanho do Jlabel
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIconeTempo = new javax.swing.JLabel();
        lblTemperatura = new javax.swing.JLabel();
        lblMensagem = new javax.swing.JLabel();
        btnGame = new javax.swing.JButton();
        btnPesquisaBlocos = new javax.swing.JButton();
        txtBloco1 = new javax.swing.JTextField();
        txtBloco2 = new javax.swing.JTextField();
        txtBloco3 = new javax.swing.JTextField();
        lblInformacao = new javax.swing.JLabel();
        btnSobre = new javax.swing.JButton();
        lblQUADROFOTOS = new javax.swing.JLabel();
        lblFOTO1 = new javax.swing.JLabel();
        lblFOTO2 = new javax.swing.JLabel();
        lblFOTO3 = new javax.swing.JLabel();
        lblFOTO4 = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 153));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        lblIconeTempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/sol.png"))); // NOI18N
        lblIconeTempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblIconeTempoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblIconeTempoMouseExited(evt);
            }
        });

        lblTemperatura.setText("30º");

        lblMensagem.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblMensagemPropertyChange(evt);
            }
        });

        btnGame.setText("Game");
        btnGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameActionPerformed(evt);
            }
        });

        btnPesquisaBlocos.setText("Pesquisa de Blocos");
        btnPesquisaBlocos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaBlocosActionPerformed(evt);
            }
        });

        txtBloco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBloco1ActionPerformed(evt);
            }
        });

        lblInformacao.setText("BLOCOS MAIS PROXIMOS DE VOCE:");

        btnSobre.setText("Sobre");

        lblQUADROFOTOS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 6));

        lblFOTO2.setText("jLabel1");

        lblFOTO3.setText("jLabel3");

        lblFOTO4.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(lblTemperatura))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtBloco3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(lblFOTO2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(lblFOTO4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtBloco2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnGame, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtBloco1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(btnSobre))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(lblIconeTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lblFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblQUADROFOTOS, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblFOTO1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(btnPesquisaBlocos))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblFOTO3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(txtBloco3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblFOTO2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblFOTO4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(txtBloco2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblInformacao))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnGame, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(txtBloco1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lblIconeTempo)
            .addComponent(lblFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(lblQUADROFOTOS, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(lblFOTO1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnPesquisaBlocos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(lblFOTO3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblMensagemPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblMensagemPropertyChange

    }//GEN-LAST:event_lblMensagemPropertyChange

    private void lblIconeTempoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconeTempoMouseEntered
        lblMensagem.setText("Sol");
    }//GEN-LAST:event_lblIconeTempoMouseEntered

    private void lblIconeTempoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconeTempoMouseExited
        lblMensagem.setText("");
    }//GEN-LAST:event_lblIconeTempoMouseExited

    private void txtBloco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBloco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBloco1ActionPerformed

    private void btnPesquisaBlocosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaBlocosActionPerformed
    


    }//GEN-LAST:event_btnPesquisaBlocosActionPerformed

    private void btnGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameActionPerformed
        //Código a ser usado no frame do jogo para receber a imagem de perfil através da URL
        //Cria objeto do tipo File
        File foto = new File("FotoPerfil.jpg");
        //Objeto que contém o arquivo da url
        try (InputStream in = new URL(dados.getFoto().getUrl()).openStream()) {

            //Copia a foto da url para o arquivo FotoPerfil.jpg na pasta do projeto
            Files.copy(in, Paths.get(foto.getAbsolutePath()));

            //Apaga a foto da pasta do projeto ao finalizar a execução da aplicação
            foto.deleteOnExit();

            System.out.println("Sucesso!");
        } catch (IOException e) {
            System.err.println("Erro imagem perfil!");
        }
    }//GEN-LAST:event_btnGameActionPerformed
//-----------------------------------------------------------

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Feed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Feed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Feed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Feed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Feed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGame;
    private javax.swing.JButton btnPesquisaBlocos;
    private javax.swing.JButton btnSobre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFOTO1;
    private javax.swing.JLabel lblFOTO2;
    private javax.swing.JLabel lblFOTO3;
    private javax.swing.JLabel lblFOTO4;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblIconeTempo;
    private javax.swing.JLabel lblInformacao;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblQUADROFOTOS;
    private javax.swing.JLabel lblTemperatura;
    private javax.swing.JTextField txtBloco1;
    private javax.swing.JTextField txtBloco2;
    private javax.swing.JTextField txtBloco3;
    // End of variables declaration//GEN-END:variables
}
