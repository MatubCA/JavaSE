package com.dong.dataStrean;/*
 * ClassName: com.dong.dataStrean.InDataStream
 * date: 2022/8/14 11:58
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutDataStream {

    public static void dataStreamOut(){
        DataOutputStream outputStream = null;
        try {
            outputStream = new DataOutputStream(new FileOutputStream("a.txt"));
            for (int i = 0; i < 10; i++) {
                outputStream.writeInt(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
