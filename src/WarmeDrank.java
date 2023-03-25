public class WarmeDrank extends Drank {
    private boolean isThee;
    private boolean melk;
    private boolean suiker;

    public WarmeDrank(boolean isThee, boolean melk, boolean suiker) {
        this.isThee = isThee;
        this.melk = melk;
        this.suiker = suiker;
    }

    @Override
    double getPrijs() {

        double prijs = 2.0;

        if (this.isThee) {
            prijs = 1.0;
        }

        if (this.melk) {
            prijs += 0.5;
        }

        if (this.suiker) {
            prijs += 0.25;
        }

        return prijs;
    }

    @Override
    String getOmschrijving() {

        String drank = "";

        if (this.isThee) {
            drank = "thee";
        } else {
            drank = "koffie";
        }


        if (this.melk && this.suiker) {
            return drank + " met melk en suiker";
        } else if (this.melk) {
            return drank + " met melk";
        } else if (this.suiker) {
            return drank + " met suiker";
        } else {
            return drank;
        }
    }

    @Override
    public String toString() {

        String description = getOmschrijving();
        double price = getPrijs();
        return description + " (" + price + ")";
    }




}
