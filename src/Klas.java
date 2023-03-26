import javax.print.Doc;
import java.util.ArrayList;

public class Klas {

    private String naam;
    private ArrayList<Persoon> personenLijst;
    Persoon docent;



    public Klas(String naam) {

        if(naam.length() >= 3 && ! naam.equals("###") && ! naam.equals(null) ){
            this.naam = naam;
        }else{
            this.naam = "klas???";
        }

        this.personenLijst = new ArrayList<Persoon>();
    }



    public Persoon getDocent(){
        return docent;
    }



    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {

        if(naam.length() >= 3 && ! naam.equals("###") && ! naam.equals(null) ){
            this.naam = naam;
        }

    }

    public void print(){

        System.out.println("==== Klas: " + getNaam() + " ====");
        for(int i = 0; i<personenLijst.size();i++){
            System.out.println("* " + personenLijst.get(i));
        }

    }

    public void voegToe(String naam, String studentnummer, int blij){


        Persoon a = new Student(naam, blij, studentnummer);
        personenLijst.add(a);

    }

    public void voegToe(Persoon persoon){


        if (persoon instanceof Docent) {

            if (docent == null) {
                docent = persoon;
                personenLijst.add(persoon);
            }
        }

        docent = persoon;
        personenLijst.add(persoon);

    }


    public void maakBlij(int hoeveelheid){

        for(int i = 0; i<personenLijst.size(); i++){
            personenLijst.get(i).maakBlij(hoeveelheid);
        }

    }

    public boolean maakBlij(String naam, int hoeveelheid){

        for (Persoon persoon : personenLijst) {

            if (persoon.getNaam().equals(naam)){
                persoon.maakBlij(hoeveelheid);
                return true;
            }

        }


        return false;

    }

    public ArrayList<Persoon> getPersonenLijst() {
        return personenLijst;
    }

    public static void main(String[] args) {



    }

    @Override
    public String toString() {
        return this.naam;
    }
}
