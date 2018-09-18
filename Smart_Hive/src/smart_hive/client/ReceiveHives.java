package smart_hive.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
-- Classe para mandar comandos para o servidor
 */
public class ClientController {

    public static void main(String[] args){

        try {
            Client c = new Client();
//            System.out.println(c.toJson());
            Socket client = new Socket("localhost",6969);
            PrintStream outPut = new PrintStream(client.getOutputStream());

            /*Indetificador de cliente*/outPut.println(1);
            /*Id do cliente*/outPut.println(2);

            Scanner scan = new Scanner(client.getInputStream());

            while (scan.hasNextLine()){
                String aux = scan.nextLine();
                System.out.println(aux);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
