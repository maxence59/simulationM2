//Roussel maxence
// Serrano florian

public class Demande {

    private int id_res;

    //private String type;

    private int dateArrivéMax;

    private int dateDepart;

    //private int prix;
    private String origine;
    private String destination;
    private int volume;

    private int prio;// 1 si la demande est prioritaire sinon 0

    public Demande(int id_res, int dateArrivéMax, int dateDepart, String origine, String destination, int volume,int p) {
        this.id_res = id_res;
        this.dateArrivéMax = dateArrivéMax;
        this.dateDepart = dateDepart;
        this.origine = origine;
        this.destination = destination;
        this.volume = volume;
        this.prio=p;
    }


    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public int getDateArrivéMax() {
        return dateArrivéMax;
    }

    public void setDateArrivéMax(int dateArrivéMax) {
        this.dateArrivéMax = dateArrivéMax;
    }

    public int getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(int dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }

    @Override
    public String toString() {
        return "Demande{" +
                "id_res=" + id_res +
                ", dateArrivéMax=" + dateArrivéMax +
                ", dateDepart=" + dateDepart +
                ", origine='" + origine + '\'' +
                ", destination='" + destination + '\'' +
                ", volume=" + volume +
                '}';
    }
}
