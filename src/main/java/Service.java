//Roussel maxence
// Serrano florian

import java.util.HashMap;
import java.util.Map;

public class Service {
    private int ID;
    private String nom;
    private Terminal origine;
    private Terminal destination;
    private int capaciteMax;
    private int nbContainers;

    private int dateDepart;
    private int dateArrive;
    private Map<Terminal,Integer> etapes;

    private int nb_d;//nombre de demande accepter dans ce service

    public Service(int ID, String nom, Terminal origine, Terminal destination, int capaciteMax, int nbContainers,int date, int dateD) {
        this.ID = ID;
        this.nom = nom;
        this.origine = origine;
        this.destination = destination;
        this.capaciteMax = capaciteMax;
        this.nbContainers = nbContainers;
        this.dateArrive = dateD;
        this.dateDepart=date;
        etapes = new HashMap<>();
        nb_d=0;
    }

    public void setNbContainers(int nbContainers) {
        this.nbContainers = nbContainers;
    }

    public int getDateArrive() {
        return dateArrive;
    }

    public void ajoutEtape (Terminal t,int temps){
        etapes.put(t,temps);
    }

    public int Depart(String nomT){//retourne la date du depart d'un terminal
        if (origine.getNom().equals(nomT)){//si le terminal est l'origine la date est celle du depart du service
            return dateDepart;
        }
        else {
            for (Map.Entry<Terminal, Integer> entry : etapes.entrySet()) {
                if (entry.getKey().getNom().equals(nomT)){//si le terminal est une etape la date est celle du depart du l'etape
                    return entry.getValue();
                }
            }
        }
        return -1;
    }

    public int Arrive(String nomT){//retourne la date du d'arrevée d'un terminal
        if (destination.getNom().equals(nomT)){
            return dateArrive;
        }
        else {
            for (Map.Entry<Terminal, Integer> entry : etapes.entrySet()) {
                if (entry.getKey().getNom().equals(nomT)){
                    return entry.getValue();
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Service{" +
                "ID=" + ID +
                ", nom='" + nom + '\'' +
                ", origine=" + origine +
                ", destination=" + destination +
                ", capaciteMax=" + capaciteMax +
                ", nbContainers=" + nbContainers +
                ", duree=" + dateArrive +
                ", etapes=" + etapes +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Terminal getOrigine() {
        return origine;
    }

    public void setOrigine(Terminal origine) {
        this.origine = origine;
    }

    public Terminal getDestination() {
        return destination;
    }

    public void setDestination(Terminal destination) {
        this.destination = destination;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public int getNbContainers() {
        return nbContainers;
    }

    public void setDateArrive(int dateArrive) {
        this.dateArrive = dateArrive;
    }

    public Map<Terminal, Integer> getEtapes() {
        return etapes;
    }

    public void setEtapes(Map<Terminal, Integer> etapes) {
        this.etapes = etapes;
    }

    public int getNb_d() {
        return nb_d;
    }

    public void setNb_d(int nb_d) {
        this.nb_d = nb_d;
    }
}
