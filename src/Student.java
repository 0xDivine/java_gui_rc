public class Student extends Persoon {

    private String studentnummer;

    public Student(String naam, int blij, String studentnummer) {
        super(naam, blij);
        this.studentnummer = studentnummer;

    }


    public Student(String naam, String studentnummer) {
        super(naam, 50);
        this.studentnummer = studentnummer;

    }
    @Override
    public String getBeschrijving() {
        return this.studentnummer;
    }

    @Override
    public String getSmiley() {

        String temp = " ";

        if(getBlij() <= 25){
            temp = ":-(";
        } else if (getBlij() > 25 && getBlij() <= 50) {
            temp = ":-I";

        } else if (getBlij() > 50 && getBlij() <= 75) {
            temp = ":-)";

        }else if(getBlij() > 75){
            temp = ":-D";
        }

        return temp;

    }


    public static void main(String[] args) {

        Student s1 = new Student("Anna","s1185185");
        System.out.println(s1);

        Student s2 = new Student("Nico", 95, "S1186193");
        System.out.println(s2);

    }




}
