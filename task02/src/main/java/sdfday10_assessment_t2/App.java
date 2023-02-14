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
            System.out.println(fileList);
        } 

        // file names of all 4 txt, checked and working
        String file1 = fileList.get(0);
        String file2 = fileList.get(1);
        String file3 = fileList.get(2);
        String file4 = fileList.get(3);

        String sent = "";


        //file 1
        fileName = file1;

        File fileFin = new File(dirName, fileName);
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

        Map<String,Integer> uniqSentString = new HashMap<String>();

        for (int j=0; j <wordList.size();j++){
            int count;
            String shortStr = wordList.get(j) + " " + wordList.get(j+1);
            uniqSentString.add(shortStr);
            for (int k = 0; k<uniqSentString.size(); k++){
                if(!uniqSentString..equals(shortStr)){
                    count++;
                }
            }
        }
    }
    
