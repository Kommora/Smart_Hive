package smart_hive.client;

/*
Classe Objeto Cliente
 */

import java.io.InputStream;
import java.io.OutputStream;

public class Client {

    private int idClient;// id unico do cliente utilizado para determinar propriedade sobre as colmeias
    private InputStream inputStream; // vari�vel por onde o cliente receber� as informa��es de suas colm�ias
    private OutputStream outputStream; // vari�vel que estabelecer� contato com servidor e enviar� dados requisitados pelo servidor

    //Contrutor vazio
    public Client(){

    }

    //Construtor com campos
    public Client(int idClient, InputStream input, OutputStream output){
        setIdClient(idClient);
        setInputStream(input);
        setOutputStream(output);
    }


    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    //Convertendo json para string
    public String jsonToString(String json){
        String jsonString = json.substring(1,json.length()-1).replaceAll(",","\n").replaceAll("\"","");
        return jsonString;
    }

}

