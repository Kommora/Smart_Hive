package smart_hive.monitor;

import smart_hive.hive.Hive;
import java.util.Scanner;

public class HiveController implements Runnable{

    private Hive hive;
    public Monitor monitor;

    public HiveController(Hive hive, Monitor monitor) {
        this.hive = hive;
        this.monitor = monitor;
    }

    public void run(){
        try {
            Scanner scan = new Scanner(hive.getEntrada());
            while (scan.hasNextLine()){
                String aux = scan.nextLine();
                System.out.println(aux);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
