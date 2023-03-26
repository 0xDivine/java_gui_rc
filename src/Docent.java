public class Docent extends Persoon{



    public Docent(String naam) {
        super(naam, 100);
    }


    @Override
    public String getBeschrijving() {
        return "Docent";
    }

    @Override
    public String getSmiley() {
        return ":-P";
    }

    public static void main(String[] args) {
        Docent x = new Docent("Jan");
        System.out.println(x);
    }



}
