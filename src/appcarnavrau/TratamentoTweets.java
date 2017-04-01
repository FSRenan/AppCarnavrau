/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcarnavrau;

import java.net.URL;
import java.util.ArrayList;
import twitter4j.MediaEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;

/**
 *
 * @author taciano
 */
public class TratamentoTweets {

    public void pesquisarTag(twitter4j.Twitter twitter, String tag, ArrayList<URL> urls, int num) {
        Query query = new Query("filter:images" + tag);

        try {

            int numberOfTweets = num;
            ArrayList<Status> tweets = new ArrayList<Status>();
        
            
            query.setCount(numberOfTweets);
               
               
            QueryResult result = twitter.search(query);

         
                tweets.addAll(result.getTweets());
                for (Status status : tweets) {
                    MediaEntity[] media = status.getMediaEntities(); //get the media entities from the status
                    for (MediaEntity m : media) { //search trough your entities
                     
                        URL url = new URL(m.getMediaURL());

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
