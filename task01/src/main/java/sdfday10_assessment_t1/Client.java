package sdfday10_assessment_t1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class Client {
    private Client() {
    }

    public static void main(String[] args) throws IOException {
        
        String name = "Ang Yi Ci";
        String email = "ycang1993@gmail.com";

        String msgSent = "", input = "", msgRec = "";
        Socket soc = new Socket("localhost", 5000);
        Console cons = System.console();

        try{
            while(true){
                
                InputStream is = soc.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                ObjectInputStream ois = new ObjectInputStream(bis);

                msgRec = ois.readUTF();
                System.out.println("List of numbers: " + msgRec);
            
                numArr = msgRec.split(",");

                // for (int i =0; i < numStr.length; i++){
                //     numStr.get(i);
                // }

                OutputStream os = soc.getOutputStream();
                BufferedOutputStream bos = new BufferedOutputStream(os);
                ObjectOutputStream oos = new ObjectOutputStream(bos);

        

    }} catch(IOException e){
        e.printStackTrace();
        soc.close();
    }
} 
    }