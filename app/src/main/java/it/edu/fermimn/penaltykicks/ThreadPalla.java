package it.edu.fermimn.penaltykicks;

import android.util.Log;

public class ThreadPalla extends Thread{
     private int startX, startY, stopX, stopY;
     private Posizioni pos = Posizioni.getInstance();
     private int maxHeight = pos.getPortaY() +400;

     private int deltaX, deltaY;

     public ThreadPalla(int startX,int startY,int stopX,int stopY){
          this.startX = startX;
          this.startY = startY;
          this.stopX = stopX;
          this.stopY = stopY;
          deltaX = stopX-startX;
          deltaY = stopY-startY;
          }

     @Override
     public void run() {

          Log.d("", "partenza thread");
          Log.d("", "" + maxHeight);
          Log.d("", "" + pos.getPallaY());
          double factor = 0.1;
          while (pos.getPallaY() > maxHeight) {
               try {
                    Thread.sleep(50);
               } catch (InterruptedException e) {
                    // Void
               }

               /*
                    paint.setColor(Color.RED);
                    canvas.drawOval(endX,endY, endX+50,endY+50,paint);


                    canvas.drawLine(pos.getPallaX()+imgPalla.getWidth()/2,pos.getPallaY()+imgPorta.getHeight()/4,endX+20,endY+20,paint);
                    deltaY=endY-pos.getPallaY();
                    deltaX=endX-pos.getPallaX();

                    canvas.drawBitmap(imgPalla,(int)(pos.getPallaX()+deltaX*0.5),(int)(pos.getPallaY()+deltaY*0.5),paint);
                */
               pos.setPallaX((int) (pos.getPallaX() + deltaX * factor));
               pos.setPallaY((int) (pos.getPallaY() + deltaY * factor));

               Log.d("", "muovo palla");

               factor += 0.1;

               pos.refresh();

          }
     }

          private boolean isToccata(int posPallaX,int posPallay){
               if (posPallaX<=pos.getPortaX()&&posPallaX<=pos.getPallaX()+10) {
                    return true;
               }
               return false;
          }

          // TODO: Controllo se la palla è in porta e non è toccata dal portiere


     }



