package smart_hive.hive;

import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Random;

public class Hive {

    private double weight, in_temper, ex_temper; // parametros que armazenam informacoes sobre a colmeia, respectivamente, peso, temperatura interior e temperatura exterior
    private String location; // armazena a localizacao da colmeia
    private LocalDateTime moment; // armazena a hora
    private int idClient; // id do dono da colmeia
    private int idHive;
    
    //Construtor somente com dados da colmeia
    public Hive(double weight, double in_temper, double ex_temper, String location, LocalDateTime moment, int idClient, int idHive) {
        this.weight = weight;
        this.in_temper = in_temper;
        this.ex_temper = ex_temper;
        this.location = location;
        this.moment = moment;
        this.idClient = idClient;
        this.idHive = idHive;
    }

    //contrutor utilizando aleatoriedade, afim de simular os sensores
    public Hive() { }
    
    //contrutor aleatorio ja incluido o dono da colmeia
    public Hive(int idClient, int idHive){
        setIdClient(idClient);
        setIdHive(idHive);
        setWeight((new Random().nextInt(100)+1) + 300);
        setIn_temper((new Random().nextInt(10)+1) + 30);
        setEx_temper((new Random().nextInt(10)+1) + 35);
        setLocation("-5.145030,-38.092607");
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

    public int getIdHive() {
        return idHive;
    }

    public void setIdHive(int idHive) {
        this.idHive = idHive;
    }

    @Override
    public String toString() {
        return "Hive{" +"\n"+
                "weight=" + weight +"\n"+
                "\t, in_temper=" + in_temper +"\n"+
                "\t, ex_temper=" + ex_temper +"\n"+
                "\t, location='" + location + '\'' +"\n"+
                "\t, moment=" + moment +"\n"+
                "\t, id=" + idClient +"\n"+
                '}';
    }

    public String toSend(){
        return idHive+";"+weight+";"+in_temper+";"+ex_temper+";"+location+";"+moment+";"+idClient;
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
