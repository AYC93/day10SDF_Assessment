package sdfday10_assessment_t1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class Client {
    private Client() {
    }

    public static void main(String[] args) throws IOException{

        String name = "Ang Yi Ci";
        String email = "ycang1993@gmail.com";

        String msgRec = "";
        Socket soc = new Socket("localhost", 5000);

        try {
            while (true) {

                InputStream is = soc.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                ObjectInputStream ois = new ObjectInputStream(bis);

                // working
                msgRec = ois.readUTF();
                System.out.println("List of numbers: " + msgRec);

                msgRec = (String)msgRec;
                
                // working
                List<String> list = new LinkedList<>();
                list.add(msgRec);

                String numStr = list.get(0);
                List<String> numStrArr = Arrays.asList(numStr.split(","));
                List<Double> numArr = new ArrayList<>();
                
                for(int i = 0; i < numStrArr.size(); i++){
                    numArr.add(Double.parseDouble(numStrArr.get(i)));
                }
                System.out.println("numArr: " + numArr);

                // sum
                double sum = 0;

                for (int i = 0; i < numArr.size(); i++) {
                    sum += numArr.get(i);
                    i++;
                }
                System.out.println("Sum = " + sum);

                //mean
                float mean = 0;

                mean = (float) (sum / (numArr.size()));
                System.out.println("Mean = " + mean);

                // std deviation
                float stdDev = 0;
                for (double k : numArr){
                    stdDev += Math.pow((k - mean), 2);
                }
                
                stdDev = (float) (Math.sqrt(stdDev/numArr.size()));
                System.out.println("Std Dev = " + stdDev);

                OutputStream os = soc.getOutputStream();
                BufferedOutputStream bos = new BufferedOutputStream(os);
                ObjectOutputStream oos = new ObjectOutputStream(bos);

                oos.writeUTF(name);
                oos.writeUTF(email);
                oos.writeFloat(mean);
                oos.writeFloat(stdDev);

                oos.flush();
                
                oos.close();
                bos.close();
                os.close();

                ois.close();
                bis.close();
                is.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
            soc.close();
        }
    }
}