package sdfday10_assessment_t2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class App {
    private App() {
    }
    public static String dirName = "seuss";
    public static String fileName = "";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        dirName = args[0];

        File fileInt = new File(dirName);
        File[] fileArr = fileInt.listFiles();

        Map<String, Integer> wordList = new HashMap<String, Integer>();
        List<String> fileList = new ArrayList<String>();

        for (int i = 0; i < fileArr.length; i++){
            fileList.add(fileArr[i].getName());
        } 
        
        System.out.println(fileList);

        List<String> fileNameList = new ArrayList<String>();

        for (int i = 0; i < fileList.size(); i ++){
            fileNameList.add(fileList.get(i));
        }

        String sent = "";

        for (int j = 0; j < fileNameList.size(); j++){
            fileName = fileNameList.get(j);
            File fileFin = new File(dirName, fileName);
            System.out.println("\r");
            System.out.println(fileFin);
            FileReader fr = new FileReader(fileFin);
            BufferedReader br = new BufferedReader(fr);

            // strip all punctuations
            while((sent = br.readLine())!= null){
                    String strippedSent = sent.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                    String[] wordArr = strippedSent.split("\\s+");
                    for (int i = 0; i < wordArr.length; i++){
                        wordList.put(wordArr[i], i);
                    }
                }     
                br.close();
                System.out.println(wordList);

                // wordList as an array

            Set<String> uniqSentString = new HashSet<>();

            for (j =0; j < wordList.size() ; j++){
                String shortStr = wordList.get(j) + " " + wordList.get(j+1);
                uniqSentString.put(shortStr, j);
                for (int k = 0; k < uniqSentString.size(); k++){
            //         if(uniqSentString.get(k).equals(shortStr)){
            //             count++;
            //             System.out.println(count);
            //         }
            //     }
            // }
    }
}}

    
