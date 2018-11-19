package smart_hive.hive;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HiveToServer{


    public HiveToServer() {
    }

    public boolean handShake(Socket socket, int idClient, int idHive) throws Exception {

        Scanner inPut = new Scanner(socket.getInputStream());
        PrintStream outPut = new PrintStream(socket.getOutputStream());

        outPut.println("0,"+idClient+","+idHive);

        while (socket.isConnected() && inPut.hasNextLine()){
            String aux = inPut.nextLine();

            if (aux.equals("0")){
                return true;
            }
            throw new Exception();
        }
        throw new Exception();

    }

    public void send(Hive hive) throws Exception{
        try {

            //cria um socket para a colmeia se comunicar com o servidor
            Socket socket = new Socket("localhost",6969);

            //Handshake para conectar
            if(handShake(socket, hive.getIdClient(), hive.getIdHive())){
                System.out.println("Enviar mensagens");

                PrintStream outPut = new PrintStream(socket.getOutputStream());
                //laço para enviar mensagens
                while (!socket.isClosed()){
                    outPut.println(hive.toSend());
                    Thread.sleep(5000);
                }

            }else {
                throw new Exception();
            }

        } catch (IOException e) {
            System.out.println("Conexão recusada");
            throw new Exception();
        } catch (InterruptedException e) {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Handshake não foi possivel");
            throw new Exception();
        }
    }

    public static void main(String[] args) throws Exception {
        HiveToServer v = new HiveToServer();
        v.send(new Hive(1,1));
    }
}
