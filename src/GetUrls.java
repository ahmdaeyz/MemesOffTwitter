import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.Map;

public class GetUrls {

    public static void main(String[] args) throws Exception {
        DownloadIMG dl = new DownloadIMG();
        ElemDuplicate elm = new ElemDuplicate();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("***********************")
                .setOAuthConsumerSecret("**********************************************")
                .setOAuthAccessToken("***************************************")
                .setOAuthAccessTokenSecret("******************************");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        ResponseList<Status> statues = twitter.getUserTimeline("theMemesBot");
        System.out.println("Downloading...");
        for(Status s : statues){
            MediaEntity[] medias = s.getMediaEntities();
            for(MediaEntity m : medias){
                dl.downloadIMG(m.getMediaURL());
            }
        }
        elm.elemDuplictate();
    }
}
