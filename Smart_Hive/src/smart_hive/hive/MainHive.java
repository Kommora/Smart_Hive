package smart_hive.hive;

public class MainHive {

    public static void main(String[] args) {
        HiveToServer hive = new HiveToServer();
        try {
            hive.executaHiveToServer(new Hive(1,1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
