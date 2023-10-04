import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static Itineraire cherchItineraire(Demande d, ArrayList<Itineraire> lI){
        for (Itineraire i : lI) {
            if(i.getOrigine() == d.getOrigine()){
                if(i.getDestination() == d.getDestination()){
                    return i;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Terminal Terminal1 = new Terminal("T1");
        Terminal Terminal2 = new Terminal("T2");
        ArrayList<Terminal> lT = new ArrayList<>();
        lT.add(Terminal1); lT.add(Terminal2);

        Service unService = new Service(0,"A",Terminal1,Terminal2,50,0,10);
        ArrayList<Service> lServices = new ArrayList<>();
        lServices.add(unService);

        Itineraire unItineraire = new Itineraire(Terminal1,Terminal2,lServices);
        Itineraire unItineraire2 = new Itineraire(Terminal2,Terminal1,lServices);
        ArrayList<Itineraire> lItineraires = new ArrayList<>();
        lItineraires.add(unItineraire); lItineraires.add(unItineraire2);

        /*
        Demande uneDemande = new Demande(T1,T2,20);
        ArrayList<Demande> lDemandes = new ArrayList<>();
        lDemandes.add(uneDemande);
        */

        System.out.println("t\t\tdépart\tarrivée\tdurée\ttype");

        float t = 0;
        float tmax = 50;
        Random random = new Random();
        int n = lT.size();
        int T1 = -1; int T2 = -1;
        Demande d = new Demande();
        ArrayList<Float> finDuree = new ArrayList<Float>();

        while(t < tmax || !finDuree.isEmpty()){
            t += random.nextFloat(10);

            while(!finDuree.isEmpty() && (t > finDuree.get(0) || t > tmax)){
                //événement de fin de service

                System.out.println(finDuree.get(0) + " fin de durée");
                finDuree.remove(0);
            }

            if(t < tmax) {
                T1 = random.nextInt(n);
                T2 = random.nextInt(n);
                while (T1 == T2) {
                    T2 = random.nextInt(n);
                }

                d.setOrigine(lT.get(T1));
                d.setDestination(lT.get(T2));
                d.setVolume(random.nextInt(50));

                Itineraire i = cherchItineraire(d, lItineraires);

                finDuree.add(t + i.sommeDuree());

                System.out.println(t);
            }
        }
    }
}
