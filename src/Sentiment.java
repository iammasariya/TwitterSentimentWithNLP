import NLP.NLP;
import Tweet.TweetManager;

import java.util.List;

/**
 * Created by pmasariya on 6/17/2016.
 */
public class Sentiment {
    public static void main(String[] args){
        String topic = "IndvsAus";
        List<String> tweets = TweetManager.getTweets(topic);
        NLP.init();
        for(String tweet : tweets) {
            System.out.println(tweet + " : " + NLP.findSentiment(tweet));
        }
    }
}
