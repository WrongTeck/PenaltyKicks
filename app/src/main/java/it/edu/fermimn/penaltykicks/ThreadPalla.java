package it.edu.fermimn.penaltykicks;

public class ThreadPalla extends Thread{

     private int startX, startY, stopX, stopY;
     private Posizioni pos = Posizioni.getInstance();

     private ThreadPalla(int startX,int startY,int stopX,int stopY){
          this.startX = startX;
          this.startY = startY;
          this.stopX = stopX;
          int maxHeight = pos.getPortaY() + 300;
          this.stopY = Math.min(stopY, maxHeight);
          }

     @Override
     public void run() {




     }


}
