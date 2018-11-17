package smart_hive.monitor;

import smart_hive.hive.Hive;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {

    private int port; // porta onde o servidos sera hospedado
    private Map<Integer, List<Hive>> clients;// mapeia cada cliente conectado a uma lista com suas colmeias

    public Server(){}

    public Server(int port){
        this.port = port;
    }
    
    //Metodo que iniciar o servidor
    public void conectar(){
        try {
        	//cria um servidor na porta escolhida
            ServerSocket server = new ServerSocket(port);
            clients = new HashMap<>();
            //List<Hive> hs = new ArrayList<>();
            //clients.put(-1, new ArrayList<Hive>());

            while (!false){
                System.out.println("esperando");
                //aceitando conexoes
                Socket con = server.accept();
                // leitor para verificar o que foi recebido
                Scanner scan = new Scanner(con.getInputStream());
                //colmeias enviam um sinal com 0 para se diferenciarem dos clientes
                if(scan.nextLine().equals("0") ){
                    System.out.println("Hive");
                    System.out.println("Hive Conectado");
                    
                    // salva o id do dono da colmeia
                    int idClient = scan.nextInt();
                    //cria uma comeia com os sockets do servidor, para receber e enviar dados para o mesmo 
                    Hive hiveAux = new Hive(con.getInputStream(), con.getOutputStream());
                    hiveAux.setIdClient(idClient);

                    //verifica se o cliente ja estava cadastrado no map com outras colmeias
                    if(clients.containsKey(idClient)){
                        clients.get(idClient).add(hiveAux);

                    }else{
                        //fazer depois
                    }
                    // inicia uma thread com a colmeia e o servidor, para que ela possa executar as proprias tarefas enquanto o servidor volta a ouvir as solicitacoes
                    ThreadHiveToClient htm = new ThreadHiveToClient(hiveAux,this);
                    new Thread(htm).start();

                }else{
                    System.out.println("Cliente");
                    System.out.println("Esperando idClient");
                    // recebendo o id do cliente
                    int idClient = scan.nextInt();
                    
                    // verifica se o cliente est� cadastrado no map com outras colmeias
                    if(!clients.containsKey(idClient)){
                    	//adiciona o cliente caso o mesmo nao esjeta no map
                        clients.put(idClient, new ArrayList<Hive>());
                        
                     // inicia uma thread com o cliente e o servidor, para que ela possa executar as proprias tarefas enquanto o servidor volta a ouvir as solicitacoes
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
        Server s = new Server(6969);
        s.conectar();
    }

}
