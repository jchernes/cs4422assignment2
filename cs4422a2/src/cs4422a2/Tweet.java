/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4422a2;

import java.util.Arrays;

/**
 *
 * @author shock
 */
public class Tweet {
    //added this to access data by index!
    // {index,text,favorited,favoriteCount,replyToSN,created,truncated,replayToSID,id,replyToUID,statusSource,screenName,retweetCount,isRetweet,retweeted,longitude,latitude};
    String data[] = new String[17];
    
    
    
    public Tweet(String index, String text, String favorited, String favoriteCount, String replyToSN, String created, String truncated, String replayToSID, String id, String replyToUID, String statusSource, String screenName, String retweetCount, String isRetweet, String retweeted, String longitude, String latitude) {
        this.data[0]  = index;
        this.data[1]  = text;
        this.data[2]  = favorited;
        this.data[3]  = favoriteCount;
        this.data[4]  = replyToSN;
        this.data[5]  = created;
        this.data[6]  = truncated;
        this.data[7]  = replayToSID;
        this.data[8]  = id;
        this.data[9]  = replyToUID;
        this.data[10] = statusSource;
        this.data[11] = screenName;
        this.data[12] = retweetCount;
        this.data[13] = isRetweet;
        this.data[14] = retweeted;
        this.data[15] = longitude;
        this.data[16] = latitude;
    }
    
     //Constructor for setting values from another tweet function used to duplicate the contents of the tweet
    public Tweet(Tweet copyFrom){
        this.data  = Arrays.copyOf(copyFrom.data, copyFrom.data.length);
    }
    
    //TweetCopy function used to duplicate the contents of the tweet
    public void TweetCopy(Tweet copyTo){
        copyTo.data = Arrays.copyOf(this.data, this.data.length);
    }
    
    
    
}
