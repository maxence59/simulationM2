//Roussel maxence
// Serrano florian

public class Terminal {
    String nom;

    public Terminal(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
