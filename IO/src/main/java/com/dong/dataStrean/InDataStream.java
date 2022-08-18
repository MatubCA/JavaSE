package com.dong.dataStrean;/*
 * ClassName: com.dong.dataStrean.InDataStream
 * date: 2022/8/14 12:05
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InDataStream {

    public static void DataStreamIn(){
        DataInputStream in = null;
        try {
            in = new DataInputStream(new FileInputStream("a.txt"));
            while(in.available() > 0){
                System.out.println(in.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
