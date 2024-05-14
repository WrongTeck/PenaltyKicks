package it.edu.fermimn.penaltykicks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.Transliterator;
import android.view.View;

public class Posizioni {
    private static Posizioni instance = null;

    private int portiereX, portiereY;
    private int portaX, portaY;
    private int pallaX, pallaY;
    private View view;

    private final int ALTEZZA_PALLA = 200;

    private Bitmap imgPorta,
        imgPortiere,
        imgPalla;

    private int
            screenX,
            screenY;

    private Posizioni() {

    }

    public static Posizioni getInstance() {
        if(Posizioni.instance == null)
            Posizioni.instance = new Posizioni();
        return Posizioni.instance;
    }

    public void setViewInstance(View v) {
        this.view = v;
        this.imgPorta = BitmapFactory.decodeResource(view.getResources(), R.drawable.porta_sprite);
        this.imgPortiere = BitmapFactory.decodeResource(view.getResources(), R.drawable.portiere_sprite1);
        this.imgPalla = BitmapFactory.decodeResource(view.getResources(), R.drawable.ball_sprite );
        screenX = v.getResources().getDisplayMetrics().widthPixels;
        screenY = v.getResources().getDisplayMetrics().heightPixels;
        portaX = screenX/2 - imgPorta.getWidth()/2;
        portaY = 100;
        portiereX = screenX/2 - imgPortiere.getWidth()/2;
        portiereY = imgPorta.getHeight() - imgPortiere.getHeight() + portaY;
        pallaX = screenX/2 - imgPalla.getWidth()/2;
        pallaY = screenY - ALTEZZA_PALLA;
    }

    public void refresh() {
        this.view.invalidate();
    }

    public void relativePortiere(int x) {
        x += portiereX;
        int minPorta = portaX + 20;
        int maxPorta = portaX + imgPorta.getWidth() - 20 - imgPortiere.getWidth();
        if(minPorta > x)
            x = minPorta;
        else if(maxPorta < x)
            x = maxPorta;
        portiereX = x;
    }

    public int getPortiereX() {
        return portiereX;
    }

    public int getPortiereY() {
        return portiereY;
    }

    public int getPortaX() {
        return portaX;
    }

    public int getPortaY() {
        return portaY;
    }

    public int getPallaX() {
        return pallaX;
    }

    public int getPallaY() {
        return pallaY;
    }

    public boolean ballIsTouchedByPortiere() {
        return false;
    }
}
