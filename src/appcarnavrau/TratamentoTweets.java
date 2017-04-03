
package appcarnavrau;

import java.net.URL;
import java.util.ArrayList;
import twitter4j.MediaEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;


public class TratamentoTweets {

    //Metodo que adc o no array as urls
    public void pesquisarTag(twitter4j.Twitter twitter, String tag, ArrayList<URL> urls, int num) {
        Query query = new Query("filter:images" + tag);

        try {
            //numero de tweets solicitados
            int numberOfTweets = num;
            ArrayList<Status> tweets = new ArrayList<Status>();
            query.setCount(numberOfTweets);
            QueryResult result = twitter.search(query);
            //Filtras os tweets e pega apenas url de midias
            tweets.addAll(result.getTweets());
                for (Status status : tweets) {
                    MediaEntity[] media = status.getMediaEntities(); //get the media entities from the status
                    for (MediaEntity m : media) { //search trough your entities
                        URL url = new URL(m.getMediaURL());
                        //Verifica no array se ja existe a url
                        if (!urls.contains(url)) {
                            urls.add(url);
                            System.out.println(url);
                                  
                        }
                    }
                }
      
          
        }
        catch(Exception e){
          
        }
    }
}
