package smart_hive.monitor;

public class MainServer {

    public static void main(String[] args) {
//        Server s = new Server(6969);
//        s.conectar();

        Server s = Server.getInstance(6969);
        s.conectar();
    }
}
