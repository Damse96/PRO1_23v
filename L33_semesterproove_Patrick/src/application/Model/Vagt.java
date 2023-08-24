package application.Model;

public class Vagt {
    // attributes
    private int timer;

    // double composition: --> 1 Job
    private Job job;
    // double association: --> 1 Frivillig
    private Frivillig frivillig;

    // constructor for Vagt
    public Vagt(int timer, Job job, Frivillig frivillig) {
        this.timer = timer;
        this.job = job; // double composition (visibility)
        this.frivillig = frivillig;
    }

    // attribute --> timer (GET)
    public int getTimer() {
        return timer;
    }

    // double composition: --> 1 Job (GET)
    public Job getJob() {
        return job;
    }

    // double association: --> 1 Frivillig (GET)
    public Frivillig getFrivillig() {
        return frivillig;
    }

    // double association: --> 1 Frivillig (SET)
    public void setFrivillig(Frivillig frivillig) {
        if (this.frivillig != frivillig) {
            Frivillig oldFrivillig = this.frivillig;
            if (oldFrivillig != null) {
                oldFrivillig.removeVagt(this);
            }
            this.frivillig = frivillig;
            if (frivillig != null) {
                frivillig.addVagt(this);
            }
        }
    }

    @Override
    public String toString() {
        return timer + " timer på " + job;
    }
}
