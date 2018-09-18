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
            Scanner scan = new Scanner(hive.getEntrada());
            while (scan.hasNextLine()){
                String aux = scan.nextLine();
                server.sendToClient(hive.getIdClient(), aux);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
