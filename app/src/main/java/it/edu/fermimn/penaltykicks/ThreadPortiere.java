package it.edu.fermimn.penaltykicks;

import java.util.Random;

public class ThreadPortiere extends Thread {
    @Override
    public void run() {

        int nuovaX=new Random().nextInt(401);

        Posizioni.getInstance().relativePortiere(10);

        super.run();
    }

    //invalidate
}
