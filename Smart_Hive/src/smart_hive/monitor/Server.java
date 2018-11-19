package smart_hive.monitor;

import smart_hive.client.Client;
import smart_hive.hive.Hive;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {

    private int port; // porta onde o servidos sera hospedado
    private Map<Integer, List<Object>> clients;// mapeia cada cliente conectado a uma lista com suas colmeias

    public Server(){}

    public Server(int port){
        this.port = port;
    }

    public void handShake(Socket socket) throws Exception {

        Scanner inPut = new Scanner(socket.getInputStream());
        PrintStream outPut = new PrintStream(socket.getOutputStream());

        while (inPut.hasNextLine()){
            String[] aux = inPut.nextLine().split(",");

            switch (aux[0]){
                case "0":
                    if(clients.containsKey(Integer.parseInt(aux[1]))){

                        Hive hive = new Hive(Integer.parseInt(aux[1]),Integer.parseInt(aux[2]));
                        clients.get(Integer.parseInt(aux[1])).add(hive);

                        outPut.println("0");
                        ThreadHiveToClient htm = new ThreadHiveToClient(hive, socket, this);

                        Thread thread = new Thread(htm);
                        thread.start();

                        System.out.println("Colmeia Recebida");
                        break;
                    }
                    socket.close();
                    throw new Exception();
                case "1":
                    if(!clients.containsKey(Integer.parseInt(aux[1]))){

                        ArrayList<Object> newHiveList  = new ArrayList<>();
                        Client client = new Client(Integer.parseInt(aux[1]), socket.getInputStream(), socket.getOutputStream());

                        newHiveList.add(client);
                        clients.put(Integer.parseInt(aux[0]), newHiveList);

                        outPut.println("1");
                        ThreadHiveToClient htm = new ThreadHiveToClient(client, socket, this);
                        Thread thread = new Thread(htm);
                        thread.start();
                        System.out.println("Cliente Recebido");
                        break;
                    }
                    outPut.println(0);
                    socket.close();
                    throw new Exception();
                default:
                    socket.close();
                    throw new Exception();
            }
            break;
        }
    }
    
    //Metodo que iniciar o servidor
    public void conectar(){
        try{

        	//cria um servidor na porta escolhida
            ServerSocket server = new ServerSocket(port);
            clients = new HashMap<>();
            while (!server.isClosed()){

                try {
                    System.out.println("esperando");

                    //aceitando conexoes
                    Socket con = server.accept();

                    handShake(con);
                }catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("Errado");
                    continue;
                }

            }
        }catch (Exception e){
            System.out.println("Erre no servidor");
        }
    }


    public void sendToClient(int idClient, String msg){
        PrintStream outPut= new PrintStream(((Client) clients.get(idClient).get(0)).getOutputStream());
        outPut.println(msg);
    }

    public static void main(String Args[]){
//        Server s = new Server(6969);
//        s.conectar();
    }

}
