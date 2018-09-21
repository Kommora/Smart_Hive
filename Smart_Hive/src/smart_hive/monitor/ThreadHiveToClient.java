package smart_hive.monitor;

import smart_hive.hive.Hive;
import java.util.Scanner;

public class ThreadHiveToClient implements Runnable{
	
    private Hive hive;
    private Server server;
     
    public ThreadHiveToClient(Hive hive, Server server) {
        this.hive = hive;
        this.server = server;
    }

    public void run(){
        try {
        	// cria um leitor a partir da input da colmeia
            Scanner scan = new Scanner(hive.getEntrada());
            
            // recebe todos os dados da colmeia e envia pro cliente
            while (scan.hasNextLine()){
                String aux = scan.nextLine();
                server.sendToClient(hive.getIdClient(), aux);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
