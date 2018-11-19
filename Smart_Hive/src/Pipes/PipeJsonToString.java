package Pipes;

public class PipeJsonToString extends Pipes{

	private String nomePipe;

	public PipeJsonToString() {

	}

	@Override
	public String doAction(String json) {
		 String jsonString = json.substring(1,json.length()-1).replaceAll(",","\n").replaceAll("\"","");
		 return jsonString;
	}

}
