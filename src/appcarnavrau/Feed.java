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
    }
    public ImageIcon MostrarImagem(URL local) {
        //Cria um imagem icon a partir do local selecionado
        ImageIcon img = new ImageIcon(local);
        //Transforma o ImageIcon para Image para conseguir redimensionar     
        Image minhaImagem = img.getImage();
        //Redimenciona imagem do tamanho do Jlabel
        Image newImg = minhaImagem.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
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
        lblFeed = new javax.swing.JLabel();
        lblMensagem = new javax.swing.JLabel();
        btnGame = new javax.swing.JButton();
        btnPesquisaBlocos = new javax.swing.JButton();
        txtBloco1 = new javax.swing.JTextField();
        txtBloco2 = new javax.swing.JTextField();
        txtBloco3 = new javax.swing.JTextField();
        lblInformacao = new javax.swing.JLabel();
        btnSobre = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 153));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(null);

        lblIconeTempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/sol.png"))); // NOI18N
        lblIconeTempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblIconeTempoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblIconeTempoMouseExited(evt);
            }
        });
        jPanel1.add(lblIconeTempo);
        lblIconeTempo.setBounds(390, 0, 50, 50);

        lblTemperatura.setText("30º");
        jPanel1.add(lblTemperatura);
        lblTemperatura.setBounds(410, 60, 17, 18);

        lblFeed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 6));
        jPanel1.add(lblFeed);
        lblFeed.setBounds(10, 247, 420, 422);

        lblMensagem.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblMensagemPropertyChange(evt);
            }
        });
        jPanel1.add(lblMensagem);
        lblMensagem.setBounds(200, 80, 230, 30);

        btnGame.setText("Game");
        btnGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameActionPerformed(evt);
            }
        });
        jPanel1.add(btnGame);
        btnGame.setBounds(20, 10, 120, 30);

        btnPesquisaBlocos.setText("Pesquisa de Blocos");
        btnPesquisaBlocos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaBlocosActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisaBlocos);
        btnPesquisaBlocos.setBounds(150, 10, 123, 30);

        txtBloco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBloco1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtBloco1);
        txtBloco1.setBounds(10, 120, 410, 30);
        jPanel1.add(txtBloco2);
        txtBloco2.setBounds(10, 160, 410, 30);
        jPanel1.add(txtBloco3);
        txtBloco3.setBounds(10, 200, 410, 30);

        lblInformacao.setText("BLOCOS MAIS PROXIMOS DE VOCE:");
        jPanel1.add(lblInformacao);
        lblInformacao.setBounds(20, 90, 290, 14);

        btnSobre.setText("Sobre");
        jPanel1.add(btnSobre);
        btnSobre.setBounds(280, 10, 61, 30);

        lblFundo.setText("jLabel1");
        jPanel1.add(lblFundo);
        lblFundo.setBounds(0, 0, 440, 680);

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 280, 160, 170);

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(240, 474, 160, 180);

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 480, 170, 160);

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 290, 160, 150);

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

        Query query = new Query("filter:images" + "#carnaval");

        try {
            QueryResult result = twitter.search(query);
            int j = 0;
            for (Status status : result.getTweets()) {
                MediaEntity[] media = status.getMediaEntities(); //get the media entities from the status
                for (MediaEntity m : media) { //search trough your entities
                    System.out.println(m.getMediaURL()); //get your url!
                    URL url = new URL(m.getMediaURL());

                        if (j == 0) {
                            jLabel2.setIcon(MostrarImagem(url));
                            System.out.println(url);

                        }
                       
                        if (j == 1) {
                            jLabel1.setIcon(MostrarImagem(url));
                            System.out.println(url);

                        }
                        if (j == 2) {
                            jLabel3.setIcon(MostrarImagem(url));

                        }
                        if (j == 3) {
                            jLabel4.setIcon(MostrarImagem(url));

                        }
                        j++;
                }
            }
        } catch (TwitterException ex) {
            Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
        }


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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFeed;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblIconeTempo;
    private javax.swing.JLabel lblInformacao;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblTemperatura;
    private javax.swing.JTextField txtBloco1;
    private javax.swing.JTextField txtBloco2;
    private javax.swing.JTextField txtBloco3;
    // End of variables declaration//GEN-END:variables
}
