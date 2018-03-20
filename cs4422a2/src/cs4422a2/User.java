/*
 * User class, the storage unit of one of the tweets of the top five Twitter
 * users! Includes methods for searching, sorting, adding, deleting etc.
 */
package cs4422a2;

import java.util.ArrayList;

/**
 *
 * @author shock
 */
public class User {
    public ArrayList<Tweet> tweets;
    public String screenName;
    //constructor takes an arraylist of tweets as it's arguement
    User(ArrayList<Tweet> twts){
        tweets = new ArrayList<Tweet>(twts);
        screenName = tweets.get(0).data[11];
    }
    
    //sorting function, sorts the tweets by a designated field 0-16
    public void sort(int sortby){
        TweetSort ts = new TweetSort();
        ts.sort(tweets, sortby);
    }
    
    //search function, returns an arraylist with items containing the search terms
    public ArrayList<Tweet> search(String searchfor, int searchby){
        ArrayList<Tweet> results = new ArrayList<Tweet>();
        
        for(Tweet tw: tweets){
            if(tw.data[searchby].contains(searchfor)){
                results.add(tw);
            }
        }
        
        return results;
    }
    
    //add new tweet
    public void add(Tweet tweet){
        this.tweets.add(tweet);
    }
    
    //delete a tweet by index
    public void delete(int index){
        this.tweets.remove(index);
    }
}
