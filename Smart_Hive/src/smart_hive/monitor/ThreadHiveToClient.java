package smart_hive.monitor;

import smart_hive.client.Client;
import smart_hive.hive.Hive;

import java.net.Socket;
import java.util.Scanner;

public class ThreadHiveToClient implements Runnable{

    private Hive hive;
    private Client client;
    private Socket con;
    private Server server;

    public ThreadHiveToClient(Object obj, Socket con, Server server) {
        if(obj instanceof  Hive){
            this.hive = (Hive) obj;
        }else {
            this.client = (Client) obj;
        }
        this.con = con;
        this.server = server;
    }

    public void run(){
        try {
        	// cria um leitor a partir da input da colmeia
            Scanner scan = new Scanner(con.getInputStream());

            // recebe todos os dados da colmeia e envia pro cliente
            while (scan.hasNextLine()){
                String aux = scan.nextLine();

                if(client == null){
                    server.sendToClient(hive.getIdClient(), aux);
                }

            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
