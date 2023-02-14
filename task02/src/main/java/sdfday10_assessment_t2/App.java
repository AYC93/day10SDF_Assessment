package sdfday10_assessment_t2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public final class App {
    private App() {
    }
    public static String dirName = "seuss";
    public static String fileName = "";

    public static void main(String[] args) throws FileNotFoundException, IOException {
          
        File fileInt = new File(dirName);
        File[] fileArr = fileInt.listFiles();

        List<String> wordList = new ArrayList<String>();
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
                        wordList.add(wordArr[i]);
                    }
                }     
                br.close();
                System.out.println(wordList);

            // List<String,Integer> uniqSentString = new ArrayList<String>();

            // for (int j=0; j <wordList.size();j++){
            //     int count;
            //     String shortStr = wordList.get(j) + " " + wordList.get(j+1);
            //     uniqSentString.add(shortStr);
            //     for (int k = 0; k < uniqSentString.size(); k++){
            //         if(uniqSentString[k].matches(shortStr)){
            //             count++;
            //             System.out.println(count);
            //         }
            //     }
            // }
    }
}
}
    
