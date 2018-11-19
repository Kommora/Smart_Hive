package smart_hive.test;

import smart_hive.monitor.Server;

public class ThreadTestServer implements Runnable {

    Server server;

    public ThreadTestServer(Server server) {
        this.server = server;
    }

    public void run(){

        server.conectar();

    }
}
