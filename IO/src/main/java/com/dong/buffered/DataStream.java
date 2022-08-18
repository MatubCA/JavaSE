package com.dong.buffered;/*
 * ClassName: com.dong.buffered.DataStream
 * date: 2022/8/14 11:22
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.*;

public class DataStream {

    public static void dataStream(){
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream("E:\\Desktop\\a.txt"));
            out.writeUTF("回收山河已入秋");
            out.writeBoolean(true);
            out.writeInt(88);
            System.out.println("写文件成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void dataStreamTo(){
        DataInputStream in = null;
        try {
            in = new DataInputStream(new FileInputStream("E:\\Desktop\\a.txt"));
            System.out.println(in.readUTF());
           /* System.out.println(in.readBoolean());
            System.out.println(in.readInt());*/

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
