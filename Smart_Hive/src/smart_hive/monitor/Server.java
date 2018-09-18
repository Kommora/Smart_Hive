package smart_hive.monitor;

import smart_hive.hive.Hive;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Monitor {

    private int port;
    private Map<Integer, List<Hive>> clients;//depois mudarmos para object

    public Monitor(){}

    public Monitor(int port){
        this.port = port;
    }

    public void conectar(){
        try {
            ServerSocket server = new ServerSocket(port);
            clients = new HashMap<>();
            //List<Hive> hs = new ArrayList<>();
            //clients.put(-1, new ArrayList<Hive>());

            while (!false){
                System.out.println("esperando");
                Socket con = server.accept();
                Scanner scan = new Scanner(con.getInputStream());
                if(scan.nextLine().equals("0") ){
                    System.out.println("Hive");
                    System.out.println("Hive Conectado");

                    int idClient = scan.nextInt();
                    Hive hiveAux = new Hive(con.getInputStream(), con.getOutputStream());
                    hiveAux.setIdClient(idClient);

                    if(clients.containsKey(idClient)){
                        clients.get(idClient).add(hiveAux);

                    }else{
                        //fazer depois
                    }

                    HiveController htm = new HiveController(hiveAux,this);
                    new Thread(htm).start();

                }else{
                    System.out.println("Cliente");
                    System.out.println("Esperando idClient");
                    int idClient = scan.nextInt();

                    if(!clients.containsKey(idClient)){
                        clients.put(idClient, new ArrayList<Hive>());
                        Hive hiveFake = new Hive(con.getInputStream(), con.getOutputStream());
                        clients.get(idClient).add(hiveFake);
                    }else{

                        //Tratar depois

                    }


                }


            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addHiveToClient(Hive v){

    }

    public void removeHiveOfClient(){

    }

    public void sendToClient(int idClient, String msg){
        PrintStream outPut= new PrintStream(clients.get(idClient).get(0).getSaida());
        outPut.println(msg);
    }

    public static void main(String Args[]){
        Monitor s = new Monitor(6969);
        s.conectar();
    }

}
