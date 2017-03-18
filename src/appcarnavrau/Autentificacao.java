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

    private WebDriver cr = new ChromeDriver();
    private String domain;
    private String appId;
    private DadosUsuario dados;

    public Autentificacao(String domain, String appId) {
        this.domain = domain;
        this.appId = appId;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    public DadosUsuario login() {
        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user"
                + "_agent&client_id=" + appId + "&redirect_uri=" + domain + "&scope= ";

        cr.get(authUrl);
        //Auto login-----------------------------------------------
        try{
            WebElement usuario = cr.findElement(By.name("email"));
            WebElement senha = cr.findElement(By.name("pass"));
          
            usuario.sendKeys("551144424268");
            senha.sendKeys("uam@1533");
            
     
  
    
            
          
        }
        //---------------------------------------------------------
        catch(Exception e){
            System.err.println("Deu ruim!"); 
        }
        String accessToken;
        while (true) {
            
        
            if (!cr.getCurrentUrl().contains("facebook.com")) {
                String url = cr.getCurrentUrl();
                accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");

                FacebookClient fbClient = new DefaultFacebookClient(accessToken);
                User user = fbClient.fetchObject("me", User.class, Parameter.with("fields", "id,name,gender,email,birthday,picture"));
                System.out.println(accessToken);
                
                setDados(new DadosUsuario(user.getName(),user.getGender(),user.getBirthday(),user.getPicture()));
               
                cr.quit();

                return dados;
            }
        }
    }
    
    public DadosUsuario getDados() {
        return dados;
    }

    public void setDados(DadosUsuario dados) {
        this.dados = dados;
    }
}
