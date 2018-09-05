package smart_hive.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
-- Classe para mandar comandos para o servidor
 */
@SuppressWarnings(value = {"all"})
public class ClientController {
	
	public static void main(String[] args) {
		Client cliente = new Client("Fudido", 69);
		
		try {
			Socket con = new Socket("localhost", 6969);
			PrintStream out = new PrintStream(con.getOutputStream());
			out.println("69");
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
