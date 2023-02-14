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


    public static void main(String[] args) throws FileNotFoundException, IOException {
        String dirName;
        
        
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

        System.out.println(wordList);
    }
}
