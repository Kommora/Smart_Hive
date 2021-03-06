package smart_hive.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
-- Classe para mandar comandos para o servidor
 */

public class ReceiveHives {

    public void send(int idClient) throws Exception {
        try {
            Client c = new Client();
            c.setIdClient(idClient);
            // inicia um socket pro cliente na porta 6969
            Socket client = new Socket("localhost",6969);
            // cria conexao com o output do cliente
            PrintStream outPut = new PrintStream(client.getOutputStream());

            /*Indetificador de cliente*/outPut.println("1," + c.getIdClient());

            //recebe a resposta do servidor
            Scanner scan = new Scanner(client.getInputStream());

            if (scan.nextLine().equals("1")){
                System.out.println("Receber mensagens");
                //recebe as informacoes da colmeia
                while (scan.hasNextLine()){
                    String aux = scan.nextLine();
                    System.out.println(aux);
                }
            }else {
                throw new Exception();
            }


        } catch (Exception e) {
            throw new Exception();
        }

    }

    public static void main(String[] args) throws Exception {
        ReceiveHives c = new ReceiveHives();
        c.send(1);
    }

}
