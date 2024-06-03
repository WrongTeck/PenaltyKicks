package it.edu.fermimn.penaltykicks;

public class ThreadPalla extends Thread{
     private Posizioni pos = Posizioni.getInstance();
     private int maxHeight = pos.getPortaY() +400;

     private GraficaGioco gc;

     private int deltaX, deltaY;

     public ThreadPalla(GraficaGioco gc, int startX,int startY,int stopX,int stopY){
          deltaX = stopX-startX;
          deltaY = stopY-startY;
          this.gc = gc;
     }

     @Override
     public void run() {
          double factor = 0.1;
          while (pos.getPallaY() > maxHeight) {
               try {
                    Thread.sleep(50);
               } catch (InterruptedException e) {
                    // Void
               }

               pos.setPallaX((int) (pos.getPallaX() + deltaX * factor));
               pos.setPallaY((int) (pos.getPallaY() + deltaY * factor));

               factor += 0.1;

               pos.refresh();

          }

          if(pos.ballIsInGoal()) {
               if(!pos.ballIsTouchedByPortiere()) {
                    MainActivity.addGoal();
               }
          }
          new ThreadGoal(this.gc).start();
     }

}