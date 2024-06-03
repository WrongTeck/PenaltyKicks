package it.edu.fermimn.penaltykicks;

public class ThreadGoal extends Thread {

    private GraficaGioco gc;

    public ThreadGoal(GraficaGioco gc) {
        this.gc = gc;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Ignored
        }
        gc.inizializzaPalla();
    }
}
