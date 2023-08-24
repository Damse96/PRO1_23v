package opgave4;


import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        TrainingPlan trainingPlanA = new TrainingPlan('A', 16,10);
        TrainingPlan trainingPlanB = new TrainingPlan('B',10,6);


        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer s1 = trainingPlanA.createSwimmer("Jan", 1994, lapTimes, "AGF");


        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer s2 = trainingPlanA.createSwimmer("Bo", 1995, lapTimes, "Lyseng");



        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer s3 = trainingPlanA.createSwimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");
        

        for (Swimmer s : trainingPlanA.getSwimmers()) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
        }

        trainingPlanA.removeSwimmer(s1);

        for (Swimmer s : trainingPlanA.getSwimmers()) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
        }


    }
    
}
