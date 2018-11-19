package smart_hive.client;

public class MainClient {

    public static void main(String[] args) {

        ReceiveHives client = new ReceiveHives();
        client.executaReceiveHive(1);
//        try {
//            client.send(1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
