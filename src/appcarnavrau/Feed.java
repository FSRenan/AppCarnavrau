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
        btnSobre = new javax.swing.JButton();
        lblCont = new javax.swing.JLabel();
        lblQUADROFOTOS = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 153));
        setResizable(false);

        jPainel.setBackground(new java.awt.Color(255, 255, 255));

        btnGame.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGame.setText("Game");
        btnGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameActionPerformed(evt);
            }
        });

        btnPesquisaBlocos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisaBlocos.setText("Pesquisa de Blocos");
        btnPesquisaBlocos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaBlocosActionPerformed(evt);
            }
        });

        txtBloco1.setEditable(false);
        txtBloco1.setBackground(new java.awt.Color(0, 0, 0));
        txtBloco1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBloco1.setForeground(new java.awt.Color(255, 255, 255));
        txtBloco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBloco1ActionPerformed(evt);
            }
        });

        txtBloco2.setEditable(false);
        txtBloco2.setBackground(new java.awt.Color(0, 0, 0));
        txtBloco2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBloco2.setForeground(new java.awt.Color(255, 255, 255));

        txtBloco3.setEditable(false);
        txtBloco3.setBackground(new java.awt.Color(0, 0, 0));
        txtBloco3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBloco3.setForeground(new java.awt.Color(255, 255, 255));

        lblInformacao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblInformacao.setText("BLOCOS MAIS PROXIMOS DE VOCE:");

        btnSobre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSobre.setText("Sobre");

        lblCont.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCont.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCont.setText("10s");

        lblQUADROFOTOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcarnavrau/stock-vector-poster-with-paper-frame-colored-dust-confetti-balls-and-serpentine-ribbon-and-empty-space-for-584318125.jpg"))); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lblQUADROFOTOS, org.jdesktop.beansbinding.ELProperty.create("${background}"), lblFundo, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPainelLayout = new javax.swing.GroupLayout(jPainel);
        jPainel.setLayout(jPainelLayout);
        jPainelLayout.setHorizontalGroup(
            jPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelLayout.createSequentialGroup()
                .addGroup(jPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPainelLayout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(lblCont))
                    .addGroup(jPainelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnGame, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnPesquisaBlocos)
                        .addGap(33, 33, 33)
                        .addComponent(btnSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPainelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPainelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txtBloco1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPainelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txtBloco2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPainelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txtBloco3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPainelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPainelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblFOTO3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lblFOTO2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPainelLayout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(lblFOTO4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPainelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblFOTO1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblQUADROFOTOS)))
                    .addComponent(lblFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPainelLayout.setVerticalGroup(
            jPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelLayout.createSequentialGroup()
                .addComponent(lblCont, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGame, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaBlocos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(lblInformacao)
                .addGap(10, 10, 10)
                .addComponent(txtBloco1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtBloco2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtBloco3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPainelLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(lblFOTO3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPainelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblFOTO2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPainelLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(lblFOTO4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPainelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblFOTO1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblQUADROFOTOS, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(lblFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainel, javax.swing.GroupLayout.PREFERRED_SIZE, 490, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

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
            // this.setVisible(false);
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
