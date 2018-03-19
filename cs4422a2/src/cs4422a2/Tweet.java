/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4422a2;

/**
 *
 * @author shock
 */
public class Tweet {
    String index,text,favorited,favoriteCount,replyToSN,created,truncated,replayToSID,id,replyToUID,statusSource,screenName,retweetCount,isRetweet,retweeted,longitude,latitude;

    
    
    public Tweet(String index, String text, String favorited, String favoriteCount, String replyToSN, String created, String truncated, String replayToSID, String id, String replyToUID, String statusSource, String screenName, String retweetCount, String isRetweet, String retweeted, String longitude, String latitude) {
        this.index          = index;
        this.text           = text;
        this.favorited      = favorited;
        this.favoriteCount  = favoriteCount;
        this.replyToSN      = replyToSN;
        this.created        = created;
        this.truncated      = truncated;
        this.replayToSID    = replayToSID;
        this.id             = id;
        this.replyToUID     = replyToUID;
        this.statusSource   = statusSource;
        this.screenName     = screenName;
        this.retweetCount   = retweetCount;
        this.isRetweet      = isRetweet;
        this.retweeted      = retweeted;
        this.longitude      = longitude;
        this.latitude       = latitude;
    }
    
     //Constructor for setting values from another tweet function used to duplicate the contents of the tweet
    public Tweet(Tweet copyFrom){
        this.index        = copyFrom.index;
        this.text         = copyFrom.text;
        this.favorited    = copyFrom.favorited;
        this.favoriteCount= copyFrom.favoriteCount;
        this.replyToSN    = copyFrom.replyToSN;
        this.created      = copyFrom.created;
        this.truncated    = copyFrom.truncated;
        this.replayToSID  = copyFrom.replayToSID;
        this.id           = copyFrom.id;
        this.replyToUID   = copyFrom.replyToUID;
        this.statusSource = copyFrom.statusSource;
        this.screenName   = copyFrom.screenName;
        this.retweetCount = copyFrom.retweetCount;
        this.isRetweet    = copyFrom.isRetweet;
        this.retweeted    = copyFrom.retweeted;
        this.longitude    = copyFrom.longitude;
        this.latitude     = copyFrom.latitude;
    }
    
    //TweetCopy function used to duplicate the contents of the tweet
    public void TweetCopy(Tweet copyTo){
        copyTo.index        = this.index;
        copyTo.text         = this.text;
        copyTo.favorited    = this.favorited;
        copyTo.favoriteCount= this.favoriteCount;
        copyTo.replyToSN    = this.replyToSN;
        copyTo.created      = this.created;
        copyTo.truncated    = this.truncated;
        copyTo.replayToSID  = this.replayToSID;
        copyTo.id           = this.id;
        copyTo.replyToUID   = this.replyToUID;
        copyTo.statusSource = this.statusSource;
        copyTo.screenName   = this.screenName;
        copyTo.retweetCount = this.retweetCount;
        copyTo.isRetweet    = this.isRetweet;
        copyTo.retweeted    = this.retweeted;
        copyTo.longitude    = this.longitude;
        copyTo.latitude     = this.latitude;
    }
    
    
    
}
