package smart_hive.test;

import smart_hive.client.ReceiveHives;

import static junit.framework.TestCase.fail;

public class ThreadTestClient implements Runnable {

    ReceiveHives hives;

    public ThreadTestClient(ReceiveHives hives) {
        this.hives = hives;
    }

    @Override
    public void run() {

        try {
            hives.send(1);
        } catch (Exception e) {
            fail("Excecao esperada");
        }

    }
}
