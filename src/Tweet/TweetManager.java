package Tweet;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pmasariya on 6/17/2016.
 */
public class TweetManager {
    public static ArrayList<String> getTweets(String Topic)
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey("SP75mV575zYsqMdhYGkoSv80G");
        cb.setOAuthConsumerSecret("G09a3KQKwcBrAx9rUZiCSr8tmpEZikbM6IWwvYaCMkY2SRnR6o");
        cb.setOAuthAccessToken("2332288692-m6nT4n4XQ2Hv1CPpB5x2wyDzhfkZDfeHFQXoMFR");
        cb.setOAuthAccessTokenSecret("xjt6SW1DlJXjC773bWKUuqj2g8c6pk8NwpDYWfy2gWE1M");
        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        ArrayList<String> tweetList = new ArrayList<String>();
        try{
            Query query = new Query(Topic);
            QueryResult result;
            do{
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets)
                {
                    tweetList.add(tweet.getText());
                }
            }while ((query = result.nextQuery()) != null);
        }catch (TwitterException ex)
        {
            ex.printStackTrace();
            System.out.println("Failed to search tweets: " + ex.getMessage());
        }
        return tweetList;
    }
}