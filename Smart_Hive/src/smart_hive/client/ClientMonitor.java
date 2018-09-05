package smart_hive.client;

import java.util.Scanner;

/*
Classe para Receber mensagens do servidor
-- Pode ser implmentado como uma thread da classe clientMonitor
*/

@SuppressWarnings(value = {"all"})
public class ClientMonitor implements Runnable{
	
	private Client c;
	
	public void run() {
		try {
			Scanner scan = new Scanner(c.getIn());
			//taca um dowhile aqui depois, talvez, quem sabe, se pá quiça xesqueldeledaledeledeledoly vrau fon eoq hi
			while (scan.hasNextLine()) {
				String mensagem = scan.nextLine();
				System.out.println("ei chefia deu certo");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
