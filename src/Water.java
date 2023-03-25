import org.w3c.dom.ls.LSOutput;

public class Water extends Drank {

    private int formaat;


    public Water() {
        this.formaat = 2;
    }

    public Water(String formaat) {

        if(formaat.equals("klein")){
            this.formaat = 1;
            //System.out.println("groot");
        }

        if(formaat.equals("normaal")){
            this.formaat = 2;
            // System.out.println("normaal");
        }

        if(formaat.equals("groot")){
            this.formaat = 3;
            // System.out.println("groot");
        }

        if (!("klein".equals(formaat) || "normaal".equals(formaat) || "groot".equals(formaat))) {
            System.out.println("Hebben we niet!");
            this.formaat = 1;
        }

    }

    @Override
    public String toString() {
        return getOmschrijving() + " " + "(" + getPrijs() + ")";
    }

    @Override
    double getPrijs() {
        return 0.0;
    }

    @Override
    String getOmschrijving() {

        String terug = "";

        if(this.formaat == 1){
            terug =  "klein";
        }

        if(this.formaat == 2){
            terug = "normaal";
        }

        if(this.formaat == 3){
            terug =  "groot";
        }

        return "een " + terug + " glas water" ;
    }
}
