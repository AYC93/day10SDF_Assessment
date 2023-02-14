package sdfday10_assessment_t2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public FileReader(File file) {
    }

    public List<String> readFile(String dirName) throws IOException{
        
        File file = new File(dirName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        List<String> wordList = new ArrayList<String>();

        String word = "";

        while((word = br.readLine())!=null){
            String strippedWord = word.replaceAll("[^a-zA-Z ]", "").toLowerCase();
            wordList.add(strippedWord);
        }

        br.close();

        return wordList;
    }

    public static int wordCount(){
        
    }
}
