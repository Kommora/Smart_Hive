package smart_hive.client;

/*
Classe Objeto Cliente
 */

import java.io.InputStream;
import java.io.OutputStream;

public class Client {

    private int idClient;// id unico do cliente utilizado para determinar propriedade sobre as colmeias
    private InputStream inputStream; // variavel por onde o cliente recebera as informacoes de suas colmeias
    private OutputStream outputStream; // variavel que estabelecer contato com servidor e enviar dados requisitados pelo servidor

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

    public String toString(String s) throws Exception {
        String[] aux = s.split(";");
        if (aux.length != 8){
            throw new Exception();
        }
        return "Hive{" +"\n"+
                "weight=" + aux[1] +"\n"+
                "\t, in_temper=" + aux[2]+"\n"+
                "\t, ex_temper=" + aux[3]+"\n"+
                "\t, location='" + aux[4]+ '\'' +"\n"+
                "\t, moment=" + aux[5] +"\n"+
                "\t, id=" + aux[0] +"\n"+
                '}';
    }

}

