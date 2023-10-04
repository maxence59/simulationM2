import java.util.List;
import java.util.Map;

public class Service {
    private int ID;
    private String nom;
    private Terminal origine;
    private Terminal destination;
    private int capaciteMax;
    private int nbContainers;
    private int duree;
    private Map<Terminal,Integer> etapes;

    public Service(int ID, String nom, Terminal origine, Terminal destination, int capaciteMax, int nbContainers, int duree/*, Map<Terminal, Integer> etapes*/) {
        this.ID = ID;
        this.nom = nom;
        this.origine = origine;
        this.destination = destination;
        this.capaciteMax = capaciteMax;
        this.nbContainers = nbContainers;
        this.duree = duree;
        /*this.etapes = etapes;*/
    }

    public void setNbContainers(int nbContainers) {
        this.nbContainers = nbContainers;
    }

    public int getDuree() {
        return duree;
    }
}
