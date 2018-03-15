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
        this.index = index;
        this.text = text;
        this.favorited = favorited;
        this.favoriteCount = favoriteCount;
        this.replyToSN = replyToSN;
        this.created = created;
        this.truncated = truncated;
        this.replayToSID = replayToSID;
        this.id = id;
        this.replyToUID = replyToUID;
        this.statusSource = statusSource;
        this.screenName = screenName;
        this.retweetCount = retweetCount;
        this.isRetweet = isRetweet;
        this.retweeted = retweeted;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    
    
}
