package appcarnavrau;

import com.restfb.types.Url;
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
import javax.swing.JOptionPane;
import twitter4j.MediaEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.Collections;
import twitter4j.conf.ConfigurationBuilder;

public class Feed extends javax.swing.JFrame {

    //Atributos da classe
    private DadosUsuario dados;
    private String endereco;
    private PesquisaBlocos pb;  

    //Construtores
    public Feed() {

    }

    public Feed(DadosUsuario dados, String endereco) throws Exception {
        this.dados = dados;
        this.endereco = endereco;
        initComponents();

        //Inicia processo paralelo de pesquisa das imagens do twitter
        new Thread(t1).start();
        pb = new PesquisaBlocos(endereco);
            
        verificaBlocosProximos();
    }
    public void verificaBlocosProximos(){
        Bloco bcProx[] = pb.blocosProximos();
        
        txtBloco1.setText(bcProx[0].getNome());
        txtBloco2.setText(bcProx[1].getNome());
        txtBloco3.setText(bcProx[2].getNome());
        
    }
    //Execução paralela de atualizar imagens do twitter
    private Runnable t1 = new Runnable() {
        public void run() {
            ArrayList<URL> urls = new ArrayList();
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
            //Declaraçao de objeto tratamento tweets
            TratamentoTweets trata = new TratamentoTweets();
            //Adiciona ao array urls das imagens relacionadas as tags
            trata.pesquisarTag(twitter, "#CarnavalSP", urls, 1000);
            System.out.println(urls.size());
            trata.pesquisarTag(twitter, "#Carnavrau", urls, 1000);
            System.out.println(urls.size());
            trata.pesquisarTag(twitter, "#Carnaval", urls, 1000);
            System.out.println(urls.size());
            trata.pesquisarTag(twitter, "#CarnavalRJ", urls, 1000);
            System.out.println(urls.size());

            //Exibe as urls no Array
            System.out.println("\n-----URLS NO ARRAY!");
            for (URL url : urls) {
                System.out.println(url);
            }
            System.out.println("-----ArrayAcabou: " + urls.size());

            //________________________
            boolean atualizar = true;
            //Atualizar as fotos nos labels
            while (atualizar) {
                //Randomiza as urls
                Collections.shuffle(urls);
                int i = 0;
                try {
                    while (urls.get(i) != null) {

                        lblFOTO4.setIcon(ajustarImagem(urls.get(i), lblFOTO4));

                        i++;
                        lblFOTO3.setIcon(ajustarImagem(urls.get(i), lblFOTO4));

                        i++;
                        lblFOTO2.setIcon(ajustarImagem(urls.get(i), lblFOTO4));

                        i++;
                        lblFOTO1.setIcon(ajustarImagem(urls.get(i), lblFOTO4));

                        i++;

                        //Aguarda 5 segundos para atualizar
                        try {
                            for (int k = 10; k >= 0; k--) {
                                Thread.sleep(1000);
                                lblCont.setText(k + "s");
                            }
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {

                        }
                    }

                } catch (Exception e) {

                }
            }

        }
    };

    private ImageIcon ajustarImagem(URL local, javax.swing.JLabel label) {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPainel = new javax.swing.JPanel();
        lblFOTO2 = new javax.swing.JLabel();
        lblFOTO3 = new javax.swing.JLabel();
        lblFOTO4 = new javax.swing.JLabel();
        lblFOTO1 = new javax.swing.JLabel();
        btnGame = new javax.swing.JButton();
        btnPesquisaBlocos = new javax.swing.JButton();
        txtBloco1 = new javax.swing.JTextField();
        txtBloco2 = new javax.swing.JTextField();
        txtBloco3 = new javax.swing.JTextField();
        lblInformacao = new javax.swing.JLabel();
        lblCont = new javax.swing.JLabel();
        lblQUADROFOTOS = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 153));
        setPreferredSize(new java.awt.Dimension(435, 670));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPainel.setBackground(new java.awt.Color(255, 255, 255));
        jPainel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPainel.add(lblFOTO2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 210, 200));
        jPainel.add(lblFOTO3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 210, 210));
        jPainel.add(lblFOTO4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 200, 200));
        jPainel.add(lblFOTO1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 210, 200));

        btnGame.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/button_game.png"))); // NOI18N
        btnGame.setToolTipText("");
        btnGame.setPreferredSize(new java.awt.Dimension(114, 42));
        btnGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameActionPerformed(evt);
            }
        });
        jPainel.add(btnGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 118, 46));

        btnPesquisaBlocos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisaBlocos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/button_pesquisar-blocos.png"))); // NOI18N
        btnPesquisaBlocos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaBlocosActionPerformed(evt);
            }
        });
        jPainel.add(btnPesquisaBlocos, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 30, 257, 46));

        txtBloco1.setEditable(false);
        txtBloco1.setBackground(new java.awt.Color(0, 0, 0));
        txtBloco1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBloco1.setForeground(new java.awt.Color(255, 255, 255));
        txtBloco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBloco1ActionPerformed(evt);
            }
        });
        jPainel.add(txtBloco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 410, 30));

        txtBloco2.setEditable(false);
        txtBloco2.setBackground(new java.awt.Color(0, 0, 0));
        txtBloco2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBloco2.setForeground(new java.awt.Color(255, 255, 255));
        jPainel.add(txtBloco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 410, 30));

        txtBloco3.setEditable(false);
        txtBloco3.setBackground(new java.awt.Color(0, 0, 0));
        txtBloco3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBloco3.setForeground(new java.awt.Color(255, 255, 255));
        jPainel.add(txtBloco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 410, 30));

        lblInformacao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblInformacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/prox.png"))); // NOI18N
        jPainel.add(lblInformacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 400, -1));

        lblCont.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCont.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCont.setText("10s");
        jPainel.add(lblCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, 40));

        lblQUADROFOTOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/stock-vector-poster-with-paper-frame-colored-dust-confetti-balls-and-serpentine-ribbon-and-empty-space-for-584318125.jpg"))); // NOI18N
        jPainel.add(lblQUADROFOTOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, 430));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/background.png"))); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lblQUADROFOTOS, org.jdesktop.beansbinding.ELProperty.create("${background}"), lblFundo, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        jPainel.add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 670));

        getContentPane().add(jPainel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 429, -1));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBloco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBloco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBloco1ActionPerformed

    private void btnPesquisaBlocosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaBlocosActionPerformed
        try {
            pb.setVisible(true);
            
        } catch (Exception ex) {
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
            //System.err.println("Erro imagem perfil!");
        }
        new Game("FotoPerfil.jpg").setVisible(true);        
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
    private javax.swing.JPanel jPainel;
    private javax.swing.JLabel lblCont;
    private javax.swing.JLabel lblFOTO1;
    private javax.swing.JLabel lblFOTO2;
    private javax.swing.JLabel lblFOTO3;
    private javax.swing.JLabel lblFOTO4;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblInformacao;
    private javax.swing.JLabel lblQUADROFOTOS;
    private javax.swing.JTextField txtBloco1;
    private javax.swing.JTextField txtBloco2;
    private javax.swing.JTextField txtBloco3;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
