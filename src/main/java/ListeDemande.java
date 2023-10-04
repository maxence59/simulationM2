import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListeDemande {

    private ArrayList<Demande> liste;

    public ListeDemande() {
        liste=new ArrayList<>();
    }

    public void gen_liste (){
        String cheminFichier = "/resources/demande.txt";

        try (FileReader fr = new FileReader(cheminFichier)) {
            int caractere;
            while ((caractere = fr.read()) != -1) {
                System.out.print((char) caractere);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
