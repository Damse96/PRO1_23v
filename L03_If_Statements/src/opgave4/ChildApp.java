package opgave4;


import java.util.SortedMap;

public class ChildApp {

    //Metoden skal returenre en tekststreng der beskriver hvilken institution et barn skal gå i, afhængig af barnets alder.
//     Reglerne for dette kan ses på opgavedsedlen

    public static String institution(int age) {
        String Institution = "";
        if (age == 0){
            Institution = " Home";
        } else if (age == 1 || age == 2){
            Institution = " nursery";
        } else if (3 <= age && age <= 5){
            Institution = " Kindergarten";
        } else if (6 <= age && age <= 16){
            Institution = " School";
        } else if (17 <= age){
            Institution = " Out of school";
        }
        return Institution;
    }


    // Metoden skal returenre en tekststreng der beskriver hvilket gymnastikhold et barn skal gå på, afhængig af barnets alder og køn.
    // Reglerne for dette kan ses på opgavedsedlen
    //
    public static String team(boolean isBoy, int age) {
        String result = "";
        if (isBoy == true && age < 8){
            result = "Young Cubs";
        } else if (isBoy == true && age >= 8){
            result = "Cool Boys";
        } else if (isBoy == false && age < 8){
            result = "Tumbling Girls";
        } else if (isBoy == false && age >= 8){
            result = "Springy Girls";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Et barn på 5 skal i" + institution(5) );
       System.out.println("Et dreng på 8 skal i " + team(true, 8));
    }
}

