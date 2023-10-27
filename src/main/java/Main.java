//Roussel maxence
// Serrano florian

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    /*public static Itineraire cherchItineraire(Demande d, ArrayList<Itineraire> lI){
        for (Itineraire i : lI) {
            if(i.getOrigine() == d.getOrigine()){
                if(i.getDestination() == d.getDestination()){
                    return i;
                }
            }
        }
        return null;
    }*/

    /*public void mainOld() {//test valeur random
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
        /*
        System.out.println("t\t\t\tdépart\tarrivée\tdurée\ttype");

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

                System.out.println(finDuree.get(0)+"\t"+"\t"+"\t"+"\t"+"Arrivée");
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

                System.out.println(t+"\t"+d.getOrigine().getNom()+"\t\t"+d.getDestination().getNom()+"\t\t"+i.sommeDuree()+"\t"+"Départ");
            }
        }
    }*/

    //
    // savoir si une demande a son origine et sa destination existante dans la liste des service
    public static Service stExiste(List<Service> ls, Demande d){
        boolean o; boolean de;
        for(Service s : ls) {
            o = false; de = false;
            if (s.getOrigine().getNom().equals(d.getOrigine())){
                o=true;
            }
            for (Map.Entry<Terminal, Integer> entry : s.getEtapes().entrySet()) {
                if (!o &&  entry.getKey().getNom().equals(d.getOrigine())) {
                    o = true;
                }
                if (o && entry.getKey().getNom().equals(d.getDestination())) {
                    de = true;
                }
                if (o && de) {
                    break;
                }
            }
            if (!de && s.getDestination().getNom().equals(d.getDestination()) ){
                de = true;
            }
            if (o && de){
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        //on genere la liste des demande a partir d'un fichier
        ListeDemande listeTest=new ListeDemande();
        listeTest.gen_liste();
        listeTest.tri();//on trie la liste par priorité
        System.out.println(listeTest);

        //on creer un service avec 4 terminal
        Terminal t1 = new Terminal("1");
        Terminal t2 = new Terminal("2");
        Terminal t3 = new Terminal("3");
        Terminal t4 = new Terminal("4");

        //on creer un service
        Service s1 =new Service(1,"s1",t1,t4,100,0,4,12);
        s1.ajoutEtape(t2,7);
        s1.ajoutEtape(t3,11);
        System.out.println(s1.toString());

        //on creer une liste de service
        ArrayList<Service> LService =new ArrayList<>();
        LService.add(s1);

        //creation fichier resultat
        FileWriter fw = new FileWriter("src/main/resources/resultat.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        //variable informative
        int nb_urg=0;//nombre de conteneur urgente
        int nb_r=0;//nombre de refus
        int nb_a=0;//nombre de conteneur accepté
        int nb_urg_a=0;//nombre de conteneur urgente accepté
        double taux_accept=0;//taux de conteneur accepté
        int d_tot=listeTest.getListe().size();//nb de demande total


        //debut simulation
        //System.out.println(stExiste(LService,listeTest.getListe().get(2)));//test fonction
        int n=0; Service sTrouve;
        while (n != listeTest.getListe().size()){
            if (listeTest.getListe().get(n).getPrio()==1){//si la demande est prioritaire
                nb_urg++;
            }
            sTrouve = stExiste(LService,listeTest.getListe().get(n));
            if (sTrouve != null){//si les terminal sont deservie
                if (listeTest.getListe().get(n).getDateDepart() <= sTrouve.Depart(listeTest.getListe().get(n).getOrigine())){// si il arrive avant le départ
                    if (listeTest.getListe().get(n).getDateArrivéMax() >= sTrouve.Arrive(listeTest.getListe().get(n).getDestination()) && sTrouve.Arrive(listeTest.getListe().get(n).getDestination())!=-1){//si il arrive avant le tps d'arrivee max de la demande
                        if (sTrouve.getNbContainers()+listeTest.getListe().get(n).getVolume()<=sTrouve.getCapaciteMax()){//si il reste assez de place
                            for (Service s:LService) {//on parcourt la liste des service
                                if (s.getID()==sTrouve.getID()){//si c notre service avec les condition rempli
                                    s.setNbContainers(sTrouve.getNbContainers()+listeTest.getListe().get(n).getVolume());//on ajoute la demande au service
                                    System.out.println("Demande : "+listeTest.getListe().get(n).getId_res()+" acceptée dans le service" +
                                            s.getID());
                                    s.setNb_d(s.getNb_d()+1);
                                    if (listeTest.getListe().get(n).getPrio()==1){//si la demande est prioritaire
                                        nb_urg_a++;
                                    }
                                    nb_a++;
                                }
                            }
                        }
                    }
                }
            }

            n++;
        }
        nb_r=d_tot-nb_a;

        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        taux_accept=(double)nb_a/d_tot;



        bw.write("Fservices\tSeed\tnb_acc\tnb_ref\tnb_acc_seed\tnbr_urgent\tnbr_urg_acc\ttaux_accept\tcapacite\tcapacite_rest");
        for (Service s:LService) {//on parcourt la liste des service pour donner le resultat de chaque service
            bw.newLine();
            bw.write(s.getNom()+"\t\t\t"+s.getID()+"\t\t"+nb_a+"\t\t"+nb_r+"\t\t"+s.getNb_d()+"\t\t\t"+nb_urg+"\t\t\t"+nb_urg_a+"\t\t\t"
                    +decimalFormat.format(taux_accept)+"\t\t\t"+s.getNbContainers()+"\t\t\t"+(s.getCapaciteMax()-s.getNbContainers()));

        }
        bw.close();
    }

}
