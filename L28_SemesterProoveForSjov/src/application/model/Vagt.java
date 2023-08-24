package application.model;

public class Vagt {
    private int timer;

    private Job job;

    private Frivillig frivillig;

    public Vagt(int timer, Job job) {
        this.timer = timer;
        this.job = job;
    }

    public int getTimer() {
        return timer;
    }

    public Job getJob() {
        return job;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void setJob(Job job) {
        this.job = job;
    }

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

}
