package appcarnavrau;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autentificacao {

    private final WebDriver cr = new ChromeDriver();
    private final String domain;
    private final String appId;
    private DadosUsuario dados;

    //Construtor da Autentificação que pega como parâmetro domínio e o id da aplicação
    public Autentificacao(String domain, String appId) {
        this.domain = domain;
        this.appId = appId;

        //Seta a propriedade do sistema para abrir o Chrome
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    //Método para fazer login com o Facebook e autentificação, retorna os dados do usuário
    public DadosUsuario login() {

        //URL para ser inicializada no Chrome
        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user"
                + "_agent&client_id=" + appId + "&redirect_uri=" + domain + "&scope= ";

        //Abre o Chrome com a URL de login do Facebook
        cr.get(authUrl);

        //Auto login-----------------------------------------------
        try {
            WebElement usuario = cr.findElement(By.name("email"));
            WebElement senha = cr.findElement(By.name("pass"));
            WebElement logar = cr.findElement(By.name("login"));

            usuario.sendKeys("551144424268");
            senha.sendKeys("uam@1533");

            logar.click();
        } catch (Exception e) {
            System.err.println("Deu ruim!");
        }
        //---------------------------------------------------------
        //Variável para armazenar o access Token do usuário
        String accessToken;

        //While para verificar quando o usuário da login
        while (true) {
            //If que verifica quando a URL é redirecionada para o domínio 
            if (!cr.getCurrentUrl().contains("facebook.com")) {

                String url = cr.getCurrentUrl();
                //Expressão regular que verifica o access Token na URL do domínio
                accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");

                //Objeto fbClient que pega como parâmetro o access Token
                FacebookClient fbClient = new DefaultFacebookClient(accessToken);

                //Objeto user que tem como parâmetros as informações necessárias
                User user = fbClient.fetchObject("me", User.class, Parameter.with("fields", "id,name,gender,email,birthday,picture"));

                System.out.println(accessToken);

                //Seta os dados do usuário com as informações recebidas do usuário
                setDados(new DadosUsuario(user.getName(), user.getGender(), user.getBirthday(), user.getPicture()));

                //Fecha o Chrome
                cr.quit();

                return dados;
            }
        }
    }

    //Get dos dados do usuário
    public DadosUsuario getDados() {
        return dados;
    }

    //Set dos dados do usuário
    public void setDados(DadosUsuario dados) {
        this.dados = dados;
    }
}
