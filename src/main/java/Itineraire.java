import java.util.List;

public class Itineraire {
    private Terminal origine;
    private Terminal destination;
    private List<Service> services;

    public Itineraire(Terminal origine, Terminal destination, List<Service> services) {
        this.origine = origine;
        this.destination = destination;
        this.services = services;
    }

    /*public float sommeDuree() {
        float sommeD = 0;
        for (Service s : services) {
            sommeD += (float)s.getDuree();
        }
        return sommeD;
    }*/

    public Terminal getOrigine() {
        return origine;
    }

    public Terminal getDestination() {
        return destination;
    }
}
