/*
 * This contains the algorithm for sorting
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
    void sort(ArrayList<Tweet> twts){
        //check if twts is empty
        if (twts.isEmpty()) return;
        
        //make a temporary copy of the original arraylist
        ArrayList<Tweet> tempArray = new ArrayList<Tweet>(twts);
        
        //call the quicksort method and sort the arraylist
        quickSort(tempArray,0,twts.size()-1);
    }
    
    //recursive quickSort method
    void quickSort(ArrayList<Tweet> twts,int low,int high){
        int i = low;
        int j = high;
        
        Tweet pivot = twts.get(low + (high - low)/2);
        
        while(i<=j){
            while(twts.get(i).screenName.compareTo(pivot.screenName)<0){
                i++;
            }
            
            while(twts.get(j).screenName.compareTo(pivot.screenName)>0){
                j--;
            }
            
            if(i<=j){
                exchangeTweets(twts,i,j);
                i++;
                j--;
            }
        }
        
        if(low<j){
            quickSort(twts,low,j);
        }
        
        if(i<high){
            quickSort(twts,i,high);
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
