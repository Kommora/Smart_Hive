package smart_hive.hive;

import java.io.*;
import java.net.Socket;

public class HiveToServer {

    public static void main(String[] args){

        try {
        	// cria uma nova colmeia
            Hive v = new Hive();
            System.out.println(v.toJson());
            
            //cria um socket para a colmeia se comunicar com o servidor
            Socket hive = new Socket("localhost",6969);
            
            // cria uma conexão com o output da colmeia para enviar dados para o servidor
            PrintStream outPut = new PrintStream(hive.getOutputStream());
            
            //loop infinito para enviar dados sobre a colmeia para o servidor
            while (true) {
                /*Indetificador da colmeia*/outPut.println(0);
                /*Id do cliente*/outPut.println(2);
                
                //envia os dados atuais da colmeia para o servidor
                outPut.println(v.toJson());
                //periodo de espera para nao floodar o servidor
                Thread.sleep(5000);
                //randomiza os dados atuais da colmeia com intuito de simular alterações do mundo real
                v.randAll();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
