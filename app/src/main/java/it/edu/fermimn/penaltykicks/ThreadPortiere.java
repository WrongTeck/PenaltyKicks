package it.edu.fermimn.penaltykicks;

import java.util.Random;

public class ThreadPortiere extends Thread {
    @Override
    public void run() {
        super.run();
        int x=10;
        Posizioni pos = Posizioni.getInstance();
        while(true){
            try {
                sleep(1000/24);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            pos.relativePortiere(x);
            pos.refresh();

           if(pos.touchingBorder()== 1){
               x=-x;
           }

            if(pos.touchingBorder()== -1){
                x=-x;
            }





        }


    }

}
