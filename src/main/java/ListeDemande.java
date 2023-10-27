import java.io.*;
import java.util.ArrayList;

public class ListeDemande {

    private ArrayList<Demande> liste;

    public ListeDemande() {
        liste=new ArrayList<>();
    }

    public void tri(){// trie la liste (les conteneur prioritaire sont placer avant les autre )
        ArrayList<Demande> Newliste=new ArrayList<>();
        for (Demande dp:liste){
            if (dp.getPrio()==1){
                Newliste.add(dp);
            }
        }
        for (Demande d:liste){
            if (d.getPrio()==0){
                Newliste.add(d);
            }
        }
        this.liste=Newliste;
    }
    public void gen_liste () throws IOException {//fonction qui genere une liste de demande a partir d'un fichier

        FileInputStream inputStream = new FileInputStream(new File("src/main/resources/demande.txt"));
        InputStreamReader fr = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader br = new BufferedReader(fr);


        String ligne;
        br.readLine();
        while ((ligne = br.readLine()) != null) {
            ligne = ligne.replace("     "," ");
            ligne = ligne.replace("    "," ");
            ligne = ligne.replace("   "," ");
            ligne = ligne.replace("  "," ");
            String[] valeurs = ligne.split(" ");

            int id = Integer.parseInt(valeurs[0]);
            int vol=Integer.parseInt(valeurs[3]);
            int dis=Integer.parseInt(valeurs[4]);
            int dl=Integer.parseInt(valeurs[5]);
            int p=Integer.parseInt(valeurs[6]);
            liste.add(new Demande(id,dl,dis,valeurs[1],valeurs[2],vol,p));

        }
        // Fermer le lecteur
        br.close();

    }

    public ArrayList<Demande> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Demande> liste) {
        this.liste = liste;
    }

    @Override
    public String toString() {
        String r = "";
        for (Demande d:liste){
            r= r+"\n" + d.toString();
        }
        return r;
    }
}
