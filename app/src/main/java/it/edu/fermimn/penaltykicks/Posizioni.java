package it.edu.fermimn.penaltykicks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.Transliterator;

public class Posizioni {
    private static Posizioni instance = null;

    private int portiereX, portiereY;
    private int portaX, portaY;
    private int pallaX, pallaY;

    private final int ALTEZZA_PALLA = 100;

    private final Bitmap imgPorta = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.porta_sprite),
        imgPortiere = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.portiere_sprite1),
        imgPalla = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.ball_sprite );

    private final int
            screenX = Resources.getSystem().getDisplayMetrics().widthPixels,
            screenY = Resources.getSystem().getDisplayMetrics().heightPixels;

    private Posizioni() {
        portaX = screenX/2 - imgPorta.getWidth()/2;
        portaY = 20;
        portiereX = screenX/2 - imgPortiere.getWidth()/2;
        portaY = imgPorta.getHeight() - imgPortiere.getHeight();
        pallaX = screenX/2 - imgPalla.getWidth()/2;
        pallaY = screenY - ALTEZZA_PALLA;
    }

    public static Posizioni getInstance() {
        if(Posizioni.instance == null)
            Posizioni.instance = new Posizioni();
        return Posizioni.instance;
    }

    public void relativePortiere(int x) {
        x += portiereX;
        int minPorta = portaX + 20;
        int maxPorta = portaY + imgPorta.getWidth() - 20 - imgPortiere.getWidth();
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
