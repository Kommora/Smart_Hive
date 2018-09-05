package smart_hive.monitor;

import smart_hive.hive.Hive;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monitor {

    private int port;
    private Map<Integer, List<Hive>> clients;

    public Monitor(){}

    public Monitor(int port){
        this.port = port;
    }

    public void conectar(){
        try {
            ServerSocket server = new ServerSocket(port);
            clients = new HashMap<>();

            while (!false){
                System.out.println("esperando");
                Socket con = server.accept();
                System.out.println("conectado");
                Hive v = new Hive(con.getInputStream(),con.getOutputStream());
                HiveController htm = new HiveController(v,this);
                new Thread(htm).start();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addHiveToClient(Hive v){

    }

    public void removeHiveOfClient(){

    }

    public static void main(String Args[]){
        Monitor s = new Monitor(6969);
        s.conectar();
    }

}
