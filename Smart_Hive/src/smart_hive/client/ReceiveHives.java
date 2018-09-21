package smart_hive.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
-- Classe para mandar comandos para o servidor
 */

public class ReceiveHives {

    public static void main(String[] args){

        try {
            Client c = new Client();
//          System.out.println(c.toJson());
            // inicia um socket pro cliente na porta 6969
            Socket client = new Socket("localhost",6969);
            // cria conexao com o output do cliente
            PrintStream outPut = new PrintStream(client.getOutputStream());

            /*Indetificador de cliente*/outPut.println(1);
            /*Id do cliente*/outPut.println(2);

            //recebe a resposta do servidor
            Scanner scan = new Scanner(client.getInputStream());

            //recebe as informacoes da colmeia
            while (scan.hasNextLine()){
                String aux = scan.nextLine();
                System.out.println(aux);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
