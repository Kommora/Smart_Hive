package smart_hive.test;

import smart_hive.hive.Hive;
import smart_hive.hive.HiveToServer;

import static junit.framework.TestCase.fail;

public class ThreadTestHive implements Runnable {

    HiveToServer hive;

    public ThreadTestHive(HiveToServer hive) {
        this.hive = hive;
    }

    @Override
    public void run() {

        try {
            hive.send(new Hive(1,1));
        } catch (Exception e) {
            fail("Excecao esperada");
        }

    }
}
