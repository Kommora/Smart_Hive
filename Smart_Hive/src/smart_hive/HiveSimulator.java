package smart_hive;

import java.io.*;
import java.net.Socket;

public class HiveSimulator {

    public static void main(String[] args){

        try {

            Hive v = new Hive();
            System.out.println(v.toJson());
            Socket hive = new Socket("localhost",6969);
            PrintStream outPut = new PrintStream(hive.getOutputStream());
            while (true) {
                outPut.println(v.toJson());
                Thread.sleep(5000);
                v.randAll();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
