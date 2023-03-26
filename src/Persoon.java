import java.awt.*;

public abstract class Persoon {

    private String naam;
    private int blij;

    public Persoon(String naam, int blij) {
        this.naam = naam;
        this.blij = blij;
    }


    public int getBlij() {
        return this.blij;
    }


    public String getNaam() {
        return naam;
    }


    public void maakBlij(int waarde){


        if(this.blij < 0){
            this.blij = 0;
        }

        if(this.blij > 100){
            this.blij = 100;
        }

        this.blij += waarde;
    }

    public Color getKleur() {

        Color color = Color.red;

        if(this.blij <= 25){
            color = Color.red;
        } else if (this.blij > 25 && this.blij <= 50) {
            color = Color.orange;

        } else if (this.blij > 50 && this.blij <= 75) {
                color = Color.yellow;

        } else if (this.blij > 75) {
            color = Color.green;

        }

        return color;
    }

    public abstract String getBeschrijving();
    public abstract String getSmiley();

    @Override
    public String toString() {

        if(this instanceof Docent){

            return getNaam() + " (Docent)         " + getBlij() + "  "+ getSmiley();
        }else{
            return getNaam() + " (" + getBeschrijving() + ")  "+ getBlij() +"     "+ getSmiley();
        }



    }


}
