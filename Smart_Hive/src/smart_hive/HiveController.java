package smart_hive;

import java.util.Scanner;

public class HiveController implements Runnable{

    private Hive hive;
    private Monitor monitor;

    public HiveController(Hive hive, Monitor monitor) {
        this.hive = hive;
        this.monitor = monitor;
    }

    public void run(){
        try {
            Scanner scan = new Scanner(hive.getEntrada());
            while (scan.hasNextLine()){
                String aux = scan.nextLine();
                String lista[] = aux.split(",");
                System.out.println(lista);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
