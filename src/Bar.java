import java.util.ArrayList;

public class Bar {



    private int aantalOpgehaaldeGlaze;
    private ArrayList<Drank> drankenOpTafel;
    private double totaleInkomsten;

    public Bar() {
        drankenOpTafel = new ArrayList<Drank>();
    }

    public void toevoegen(Drank d){

        int count = drankenOpTafel.size();

        if(count < 5){
            drankenOpTafel.add(d);
            totaleInkomsten += d.getPrijs();
        } else {
            for(Drank e: drankenOpTafel){
                aantalOpgehaaldeGlaze++;
            }
            drankenOpTafel.clear();
            drankenOpTafel.add(d);
        }



    }

    public void toevoegen(Drank d, boolean maakleeg){

        if(maakleeg){

            for(Drank e: drankenOpTafel){
                aantalOpgehaaldeGlaze++;
            }
            drankenOpTafel.clear();
        }

        drankenOpTafel.add(d);
        totaleInkomsten += d.getPrijs();

    }

    public void print(){
        System.out.println("aantalOpgehaaldeglazen = " + this.aantalOpgehaaldeGlaze);
        System.out.println("totaleInkomsten = " + this.totaleInkomsten);

        int count = 0;

        for(Drank e: drankenOpTafel){

            count++;
            System.out.println(count + "e " + e);

        }


    }

    public int zoekDrank(String txt) {

        for(int i =0; i< drankenOpTafel.size(); i++){
            if(drankenOpTafel.get(i).getOmschrijving().equals(txt))
                return i + 1;
        }

        return 0;
    }


    public static void main(String[] args) {

    }



}