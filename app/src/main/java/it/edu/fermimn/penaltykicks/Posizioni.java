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

    private int ovaleXStart;

    public int getOvaleXStart() {
        return ovaleXStart;
    }

    public int getOvaleYStart() {
        return ovaleYStart;
    }

    public int getOvaleXStop() {
        return ovaleXStop;
    }

    public int getOvaleYStop() {
        return ovaleYStop;
    }

    private int ovaleYStart;
    private int ovaleXStop;
    private int ovaleYStop;
    private View view;

    public int getALTEZZA_PALLA() {
        return ALTEZZA_PALLA;
    }

    private final int ALTEZZA_PALLA = 150;

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
        pallaY = screenY - imgPalla.getHeight() - ALTEZZA_PALLA;
        ovaleXStart = screenX/2 - 100;
        ovaleXStop = screenX/2 + 100;
        ovaleYStart = screenY - imgPalla.getHeight() + ALTEZZA_PALLA/2 - 90;
        ovaleYStop = screenY - imgPalla.getHeight() + ALTEZZA_PALLA/2 + 10;
    }

    public void setViewInstanceForBall(View v){
        this.view = v;
        this.imgPalla = BitmapFactory.decodeResource(view.getResources(), R.drawable.ball_sprite );
        pallaX = screenX/2 - imgPalla.getWidth()/2;
        pallaY = screenY - imgPalla.getHeight() - ALTEZZA_PALLA;
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

    public int touchingBorder() {
        if(portiereX == portaX + 20)
            return - 1;
        if(portiereX == portaX + imgPorta.getWidth() - 20 - imgPortiere.getWidth())
            return 1;
        return 0;
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

    public void setPallaY(int y) {
        this.pallaY = y;
    }

    public void setPallaX(int x) {
        this.pallaX = x;
    }

    public boolean ballIsTouchedByPortiere() {
        return false;
    }
}
