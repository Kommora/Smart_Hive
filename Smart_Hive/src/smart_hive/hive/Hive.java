package smart_hive.hive;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;

public class Hive implements Serializable {

    private double weight, in_temper, ex_temper;
    private String location;
    private LocalDateTime moment;
    private final int idClient= new Random().nextInt(10000);
    private InputStream entrada, inputClient;
    private OutputStream saida;

    public Hive(double weight, double in_temper, double ex_temper, String location, LocalDateTime moment) {
        this.weight = weight;
        this.in_temper = in_temper;
        this.ex_temper = ex_temper;
        this.location = location;
        this.moment = moment;
    }

    public Hive(InputStream entrada, OutputStream saida) {
        this.entrada = entrada;
        this.saida = saida;
    }

    public Hive() {
        this.weight = (new Random().nextInt(100)+1) + 300;
        this.in_temper = (new Random().nextInt(10)+1) + 30;
        this.ex_temper = (new Random().nextInt(10)+1) + 35;
        this.location = "";
        this.moment = LocalDateTime.now();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setWeight() {
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

    public final int getIdClient() {
        return idClient;
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

    public void randAll(){
        this.weight = (new Random().nextInt(100)+1) + 300;
        this.in_temper = (new Random().nextInt(10)+1) + 30;
        this.ex_temper = (new Random().nextInt(10)+1) + 35;
        this.location = "";
        this.moment = LocalDateTime.now();
    }
}
