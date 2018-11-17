package smart_hive.hive;

import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Random;

public class Hive {

    private double weight, in_temper, ex_temper; // parametros que armazenam informacoes sobre a colmeia, respectivamente, peso, temperatura interior e temperatura exterior
    private String location; // armazena a localizacao da colmeia
    private LocalDateTime moment; // armazena a hora
    private InputStream entrada, inputClient; // variaveis de comunicacao com o servidor
    private OutputStream saida; 
    private int idClient; // id do dono da colmeia
    
    //Construtor somente com dados da colmeia
    public Hive(double weight, double in_temper, double ex_temper, String location, LocalDateTime moment) {
        setWeight(weight);
        setIn_temper(in_temper);
        setEx_temper(ex_temper);
        setLocation(location);
        setMoment(moment);
    }
    
    //contrutor com variaveis de comunicacao
    public Hive(InputStream entrada, OutputStream saida) {
        setEntrada(entrada);
        setSaida(saida);
    }
    
    //contrutor utilizando aleatoriedade, afim de simular os sensores
    public Hive() {
        setWeight((new Random().nextInt(100)+1) + 300);
        setIn_temper((new Random().nextInt(10)+1) + 30);
        setEx_temper((new Random().nextInt(10)+1) + 35);
        setLocation("");
        setMoment(LocalDateTime.now());
    }
    
    //contrutor aleatorio ja incluido o dono da colmeia
    public Hive(int idClient){
        setIdClient(idClient);
        setWeight((new Random().nextInt(100)+1) + 300);
        setIn_temper((new Random().nextInt(10)+1) + 30);
        setEx_temper((new Random().nextInt(10)+1) + 35);
        setLocation("");
        setMoment(LocalDateTime.now());
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getIn_temper() {
        return in_temper;
    }

    public void setIn_temper(double in_temper) {
        this.in_temper = in_temper;
    }

    public double getEx_temper() {
        return ex_temper;
    }

    public void setEx_temper(double ex_temper) {
        this.ex_temper = ex_temper;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient){
        this.idClient = idClient;
    }

    public InputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(InputStream entrada) {
        this.entrada = entrada;
    }

    public OutputStream getSaida() {
        return saida;
    }

    public void setSaida(OutputStream saida) {
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "Hive{" +
                "weight=" + weight +
                ", in_temper=" + in_temper +
                ", ex_temper=" + ex_temper +
                ", location='" + location + '\'' +
                ", moment=" + moment +
                ", id=" + idClient +
                '}';
    }

    public String toJson(){
        return "{\"weight\":"+weight+
                ",\"in_temper\":"+in_temper+
                ",\"ex_temper\":"+ex_temper+
                ",\"location\":\""+location+
                "\",\"moment\":\""+moment+
                "\",\"idClient\":"+idClient+"}";
    }
    
    //funcao de aleatoriedade afim de simular alteracoes do mundo real em sensores
    public void randAll(){
        this.weight = (new Random().nextInt(100)+1) + 300;
        this.in_temper = (new Random().nextInt(10)+1) + 30;
        this.ex_temper = (new Random().nextInt(10)+1) + 35;
        this.location = "";
        this.moment = LocalDateTime.now();
    }
}
