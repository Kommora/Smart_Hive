package smart_hive.client;

import java.io.InputStream;
import java.io.OutputStream;

public class Client {
	
	private String nome;
	private int idClient;
	private InputStream in;
	private OutputStream out;
	
	public Client(String nome, int id) {
		this.nome = nome;
		this.idClient = id;
	}

	public Client(int idClient, InputStream in, OutputStream out) {
		this.idClient = idClient;
		this.in = in;
		this.out = out;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public InputStream getIn() {
		return in;
	}

	public void setIn(InputStream in) {
		this.in = in;
	}

	public OutputStream getOut() {
		return out;
	}

	public void setOut(OutputStream out) {
		this.out = out;
	}
	
}
