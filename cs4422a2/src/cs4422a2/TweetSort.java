/*
 * This contains the algorithm for sorting an ArrayList of Tweets
*/
package cs4422a2;

import java.util.ArrayList;

/**
 *
 * @author Joseph Cherneske
 */
public class TweetSort {
    //the tweet arraylist local to the tweetsort
    ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    
    //arraylist sort method, input a tweet arraylist, sort by specified parameter
    //sortby is the specified field
    void sort(ArrayList<Tweet> twts, int sortby){
        //check if twts is empty
        if (twts.isEmpty()) return;
        
        //call the quicksort method and sort the arraylist
        quickSort(twts,0,twts.size()-1, sortby);
    }
    
    //recursive quickSort method
    void quickSort(ArrayList<Tweet> twts,int low,int high, int sortby){
        int i = low;
        int j = high;
        
        Tweet pivot = twts.get(low + (high - low)/2);
        
        while(i<=j){
            while(twts.get(i).data[sortby].compareTo(pivot.data[sortby])<0){
                i++;
            }
            
            while(twts.get(j).data[sortby].compareTo(pivot.data[sortby])>0){
                j--;
            }
            
            if(i<=j){
                exchangeTweets(twts,i,j);
                i++;
                j--;
            }
        }
        
        if(low<j){
            quickSort(twts,low,j,sortby);
        }
        
        if(i<high){
            quickSort(twts,i,high,sortby);
        }
    }
    
    void exchangeTweets(ArrayList<Tweet> twts,int i, int j){
        Tweet temp = new Tweet(twts.get(i));
        
        //set j from i
        twts.get(j).TweetCopy(twts.get(i));
        
        //set j from temp
        temp.TweetCopy(twts.get(j));
    }
}
