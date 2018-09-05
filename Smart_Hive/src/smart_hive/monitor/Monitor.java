package smart_hive.monitor;

import smart_hive.client.Client;
import smart_hive.client.ClientMonitor;
import smart_hive.hive.Hive;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings(value = {"all"})
public class Monitor {

    private int port;
    private Map<Integer, List<Hive>> clients;

    public Monitor(int port){
        this.port = port;
    }

    public void conectar(){
        try {
            ServerSocket server = new ServerSocket(port);
            clients = new HashMap<>();
            Scanner scan;
            HashMap<Integer, List<Object>> hashClientHive = new HashMap<>();  
            //taca um dowhile aqui depois, talvez, quem sabe, se pá quiça xesqueldeledaledeledeledoly vrau fon eoq hi
            while (!false){
                System.out.println("esperando");
                Socket con = server.accept();
                System.out.println("conectado");
                scan = new Scanner(con.getInputStream());
                if(scan.nextLine().equals("69")) {
                	String auxIdClient = scan.nextLine();//espera por id do cliente
                	Client client = new Client(Integer.parseInt(auxIdClient), con.getInputStream(), con.getOutputStream());
                	List<Object> hiveList = new ArrayList<>();
                	hiveList.add(client);
                	hashClientHive.put(client.getIdClient(), hiveList);

                }else {
                	String aux = scan.nextLine();//espera por id do cliente
                	Hive v = new Hive(con.getInputStream(),con.getOutputStream());
                    HiveController htm = new HiveController(v,this);
                    new Thread(htm).start();
                    
                }
                
                scan.close();
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
