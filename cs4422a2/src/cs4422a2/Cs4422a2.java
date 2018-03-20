/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4422a2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//opencsv parser
import com.opencsv.CSVReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import org.apache.commons.lang3.ObjectUtils;

/**
 *
 * @author shock
 */
public class Cs4422a2 {

    /**
     * @param args the command line arguments
     */
    
    //Global Variables
    static int currUser;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
            CSVReader reader = new CSVReader(new FileReader("C:\\docTweet.csv"), ',');
            
            ArrayList<Tweet> tweets = new ArrayList<Tweet>();
            
            
            String[] record = null;
            
            while((record = reader.readNext())!=null){
                Tweet tw = new Tweet(record[0],record[1],record[2],record[3],
                                     record[4],record[5],record[6],record[7],
                                     record[8],record[9],record[10],record[11],
                                     record[12],record[13],record[14],record[15],
                                     record[16]);
                tweets.add(tw);
            }
            
            //For assignment second part, create an arraylist of arraylists for
            //the top 5 user's tweets
            ArrayList<User> users = new ArrayList<User>();
            
            /* My crappy CSV parser which didn't work :(
            String tweetFile = "C:\\docTweet.csv";
            BufferedReader br = null;
            String line = "";
            String delimiter = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
            
            //tweets ArrayList, will hold all the tweets and be operated on
            ArrayList<String[]> tweets = new ArrayList<String[]>();
            
            try{
            br = new BufferedReader(new FileReader(tweetFile));
            
            //count the columns
            int count = 0;
            
            while((line = br.readLine()) != null){
            //tweet string array, will hold our current tweet row being built
            ArrayList<String> tweet = new ArrayList<String>();
            
            tweet.addAll(Arrays.asList(line.split(delimiter)));
            
            //check if we have a complete tweet row, if not get another line to finish it
            while(tweet.size()<17){
            line = br.readLine();
            while(line.equals("")){
            line = br.readLine();
            }
            tweet.addAll(Arrays.asList(line.split(delimiter)));
            }
            
            //now that we have a full row, convert it to String array and pump it into the the tweets ArrayList
            tweets.add(tweet.toArray(new String[17]));
            }
            } catch (FileNotFoundException e){
            e.printStackTrace();
            } catch (IOException e){
            e.printStackTrace();
            } finally {
            if (br != null){
            try{
            br.close();
            }catch (IOException e){
            e.printStackTrace();
            }
            }
            }
            
            for(String[] str: tweets){
            System.out.println(str[0] + " " + str[11]);
            }
            */
            
            //output the screen names read in
            for(Tweet tw: tweets){
                System.out.print(tw.data[11]+" ");
            }
            
            
            //Quicksort the Array of tweets by screen name
            
            TweetSort ts = new TweetSort();
            
            ts.sort(tweets, 11);
            
            System.out.println("Sorted:");
            for(Tweet tw: tweets){
                System.out.print(tw.data[11]+" ");
            }
            
            //now that it's sorted, count and record the occurrences of screenames
            
            ArrayList<String[]> counted = new ArrayList<String[]>();
            
            //set the initial name we are couting
            String currentName = tweets.get(0).data[11];
            int currentCount = 1;
            
            for(int i=1; i<tweets.size(); i++){
                if(!tweets.get(i).data[11].equals(currentName)){
                    counted.add(new String[]{currentName,Integer.toString(currentCount)});
                    currentName = tweets.get(i).data[11];
                    currentCount = 1;
                }
                currentCount++;
            }
            
            //find the top 5
            
            System.out.println("\n\nTop 5 Tweeters\n"
                                 + "==============");
            
            for(int i=1; i<=5; i++){
                String name = "N/A";
                int count=0,total=0;
                
                Iterator<String[]> itr = counted.iterator();
                
                while(itr.hasNext()&&total<5){
                    String[] str = itr.next();
                    //check if the current count is larger, if so, set the current largest and remove from list
                    if(Integer.parseInt(str[1]) > count){
                        name = str[0];
                        count = Integer.parseInt(str[1]);
                        itr.remove();
                    }
                }
                System.out.println("Number " + i + ": " + name + " " + count);
                
                //Now stuff for second part of assignment
                //Go through the list and fetch all the tweets of the current user,
                //pushing them into the top 5 user arraylists
                
                ArrayList<Tweet> temptweets = new ArrayList<Tweet>();
                
                for(Tweet tw: tweets){
                    if(tw.data[11].equals(name)){
                        temptweets.add(tw);
                    }
                }
                
                users.add(new User(temptweets));
            }
        
            //initialize current user for menu
            currUser = 0;
            
            
            //now lets set up for input from the console
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            
            while(true){
                System.out.println("\nMain Menu\n"
                         + "=========\n"
                + "Current user: " + users.get(currUser).screenName
                + "\n1.) Select user"
                + "\n2.) Search for tweet"
                + "\n3.) Add tweet"
                + "\n4.) Delete tweet"
                + "\n5.) Quit\nChoice:");
                
                String choice = br.readLine();
                
                if(Integer.parseInt(choice)<1 || Integer.parseInt(choice)>5){
                    
                }
                
                int index = 0;
                
                switch(Integer.parseInt(choice)){
                    
                    case 1: //select a new user to work with
                        System.out.println("\nUsers:");
                        
                        for (User user : users) {
                            System.out.println(index+" " + user.screenName);
                            index++;
                        }
                        System.out.println("Select a user " + 0 + "->" + (index-1) + ":");
                        
                        currUser = Integer.parseInt(br.readLine());
                        
                        continue;
                    case 2: //Search for tweet
                        System.out.println("\nSearch for tweet\n"
                                + "-----------"
                                + "\nFields:"
                                + "\n0. index"
                                + "\n1. text"
                                + "\n2. favorited"
                                + "\n3. favoriteCount"
                                + "\n4. replyToSN"
                                + "\n5. created"
                                + "\n6. truncated"
                                + "\n7. replayToSID"
                                + "\n8. id"
                                + "\n9. replyToUID"
                                + "\n10. statusSource"
                                + "\n11. screenName"
                                + "\n12. retweetCount"
                                + "\n13. isRetweet"
                                + "\n14. retweeted"
                                + "\n15. longitude"
                                + "\n16. latitude"
                                + "\nSelect a field to search by:");
                        int searchby = Integer.parseInt(br.readLine());
                        
                        System.out.println("\nSearch for what: (blank to show all)");
                        
                        index = 0;
                        
                        for(Tweet tw: users.get(currUser).search(br.readLine(), searchby)){
                            System.out.print(index++);
                            for(String str: tw.data){
                                System.out.print(" " + str);
                            }
                            System.out.println();
                        }
                        continue;
                    case 3:
                        System.out.println("\nAdd a new tweet:\n");
                        String newData[] = new String[17];
                        
                        System.out.println("Fields are"
                                + "\n0. index (Tweet)"
                                + "\n1. text"
                                + " 2. favorited"
                                + " 3. favoriteCount"
                                + "\n4. replyToSN"
                                + " 5. created"
                                + " 6. truncated"
                                + "\n7. replayToSID"
                                + " 8. id"
                                + " 9. replyToUID"
                                + "\n10. statusSource"
                                + " 11. screenName"
                                + " 12. retweetCount"
                                + "\n13. isRetweet"
                                + " 14. retweeted"
                                + " 15. longitude"
                                + " 16. latitude");
                        index = 0;
                        for(String str: newData){
                            System.out.println((index++) + " ");
                            str = br.readLine();
                        }
                        
                        users.get(currUser).add(new Tweet(newData[0],newData[1],newData[2],newData[3],newData[4],newData[5],newData[6],newData[7],newData[8],newData[9],newData[10],users.get(currUser).screenName,newData[12],newData[13],newData[14],newData[15],newData[16]));
                        
                        continue;
                    case 4:// delete tweet
                        System.out.println("\nDelete a tweet\n-----\nwhat's the index?:");
                        users.get(currUser).delete(Integer.parseInt(br.readLine()));
                        continue;
                    case 5://sort tweets
                        System.out.println("Fields are"
                                + "\n0. index (Tweet)"
                                + "\n1. text"
                                + " 2. favorited"
                                + " 3. favoriteCount"
                                + "\n4. replyToSN"
                                + " 5. created"
                                + " 6. truncated"
                                + "\n7. replayToSID"
                                + " 8. id"
                                + " 9. replyToUID"
                                + "\n10. statusSource"
                                + " 11. screenName"
                                + " 12. retweetCount"
                                + "\n13. isRetweet"
                                + " 14. retweeted"
                                + " 15. longitude"
                                + " 16. latitude\n\nSort by which field?");
                        users.get(currUser).sort(Integer.parseInt(br.readLine()));
                        System.out.println("Sorted.");
                        continue;
                    case 6:
                        System.out.println("Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option!");
                }
                
            }
            
            
    }
    
    public static void menu(){
        
        
        
    }
    
}
