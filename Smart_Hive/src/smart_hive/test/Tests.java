package smart_hive.test;

import org.junit.jupiter.api.Test;
import smart_hive.client.Client;
import smart_hive.client.ReceiveHives;
import smart_hive.hive.Hive;
import smart_hive.hive.HiveToServer;
import smart_hive.monitor.Server;

import static org.junit.jupiter.api.Assertions.fail;


public class Tests{

    @Test
    public void verifyMsg(){
        String s = "1;2;3;4;5;6;7;8";
        try {
            Client c = new Client();
            c.toString(s);
        } catch (Exception e) {
            fail("Exceção esperada");
        }
    }

    @Test
    public void connectionHive(){
        try {
            HiveToServer v = new HiveToServer();
            v.send(new Hive(1,1));
        }catch (Exception e){
            fail("Exceção esperada");
        }
    }

    @Test
    public void connectionClient(){
        try {
            ReceiveHives c = new ReceiveHives();
            c.send(1);
        }catch (Exception e){
            fail("Exceção esperada");
        }
    }

    @Test
    public void connectionSameClient(){
        try {
//            Thread t1 = new Thread(new ThreadTestServer(new Server(6969)));
            Thread t1 = new Thread(new ThreadTestServer(Server.getInstance(6969)));
            Thread t2 = new Thread(new ThreadTestClient(new ReceiveHives()));
            t1.start();
            t2.start();
            t2.start();
        }catch (Exception e){
            fail("Exceção esperada");
        }
    }

    @Test
    public void createSameServer(){
        try {
//            Thread t1 = new Thread(new ThreadTestServer(new Server(6969)));
            Thread t1 = new Thread(new ThreadTestServer(Server.getInstance(6969)));
            t1.start();
            t1.start();
        }catch (Exception e){
            fail("Exceção esperada");
        }
    }


}
