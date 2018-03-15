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
import org.apache.commons.lang3.ObjectUtils;

/**
 *
 * @author shock
 */
public class Cs4422a2 {

    /**
     * @param args the command line arguments
     */
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
            System.out.println(tweets);
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
    }
    
}
