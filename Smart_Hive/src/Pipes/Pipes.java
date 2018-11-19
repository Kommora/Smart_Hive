package Pipes;

public abstract class Pipes {

	private String nomePipe;

	public String getId() {
		return nomePipe;
	}

	public void setId(String nomePipe) {
		this.nomePipe = nomePipe;
	}	

	public abstract String doAction(String in);


}
