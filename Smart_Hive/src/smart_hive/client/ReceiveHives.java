package smart_hive.client;

import smart_hive.view.ClientView;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/*
-- Classe para mandar comandos para o servidor
 */

public class ReceiveHives {

    private static boolean auxGlobal = false;
    private static ArrayList<Observer> observers = new ArrayList<>();

    public void atualizaObservers(){
        for (Observer o: observers) {
            o.update();
        }
    }

    public void executaReceiveHive(int idC){
        int idClientAux = idC;
        String[] infoAux = new String[6];
        String[] infoMain = new String[6];

        try {
            Client c = new Client();
            ClientView clientView = null;
//            System.out.println(c.toJson());
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
                while (scan.hasNextLine()) {
                    String aux = scan.nextLine();
                    if(aux.length() < 6) continue;
                    System.out.println(aux);

                    //Separa os valores recebidos na string Json de informações da colméia
//                    infoAux = aux.split(",");
                    infoAux = aux.split(";");
                    System.out.println("InfoAux: " + infoAux.length);


                    //Verificação simples para saber se é a primeira interação
                    if (auxGlobal == false) {
                        //Preenche o vetor da forma como ele deve ser exibido
//                        infoMain[0] = infoAux[5];
//                        for (int i = 0; i < infoMain.length - 1; i++) {
//                            infoMain[i + 1] = infoAux[i];
//                        }
                        for (int i = 0; i < infoMain.length; i++) {
                            infoMain[i] = infoAux[i];
                        }
                        //Manipula a variavel que verifica se é uma primeira interação ou não
                        auxGlobal = true;
                        clientView = new ClientView(infoMain, null);
                        //ClientView clientView = new ClientView(infoMain, this);
                        observers.add(clientView);
                        //Instancia a view, com o vetor preenchido
                        //clientView.main(infoMain);
                        clientView.abrirView();

                    } else {
                        //Preenche o vetor da forma como ele deve ser exibido
                        //ta dando erro de nullPointer aqui
                        infoMain[0] = infoAux[5];
//                        for (int i = 0; i < infoMain.length - 1; i++) {
//                            infoMain[i + 1] = infoAux[i];
//                        }
                        for (int i = 0; i < infoMain.length; i++) {
                            infoMain[i] = infoAux[i];
                        }
                        clientView.atualizaInfo(infoMain);
                        this.atualizaObservers();

                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
//        ReceiveHives c = new ReceiveHives();
//        c.send(1);
    }

}
