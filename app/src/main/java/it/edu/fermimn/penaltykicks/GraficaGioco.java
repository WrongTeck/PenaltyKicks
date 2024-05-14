package it.edu.fermimn.penaltykicks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class GraficaGioco extends View {

    int xpalla, ypalla, xportiere, yportipere;

    private Paint paint;
    private Bitmap imgPalla;
    private Bitmap imgPortiere;
    private Bitmap imgPorta;

    private RectF oval;

    private void inizializza() {
        paint = new Paint();  // possiamo pensare all'oggetto paint come al "pennello" che ci server per disegnare
        imgPorta = BitmapFactory.decodeResource(getResources(), R.drawable.porta_sprite);
        imgPortiere = BitmapFactory.decodeResource(getResources(), R.drawable.portiere_sprite1);
        imgPalla = BitmapFactory.decodeResource(getResources(), R.drawable.ball_sprite );
        Posizioni pos = Posizioni.getInstance();
        pos.setViewInstance(this);

        oval = new RectF(pos.getOvaleXStart(), pos.getOvaleYStart(), pos.getOvaleXStop(), pos.getOvaleYStop());
    }

    public GraficaGioco(Context context) {
        super(context);
        inizializza();
    }

    public GraficaGioco(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        inizializza();
        setBackgroundColor(Color.rgb(00,160,00));
    }

    public GraficaGioco(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inizializza();
    }

    public GraficaGioco(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inizializza();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        Posizioni pos = Posizioni.getInstance();

        int h = getHeight();
        int w = getWidth();

        paint.setColor(Color.WHITE);  // imposto il colore del pennello
        paint.setStrokeWidth(10); // spessore del pennello

        canvas.drawLine(0, pos.getPortaY() + imgPorta.getHeight() - 5, w, pos.getPortaY() + imgPorta.getHeight() - 5, paint);
        canvas.drawOval(oval,paint);


        canvas.drawBitmap(imgPorta,pos.getPortaX(),pos.getPortaY(),paint);
        canvas.drawBitmap(imgPalla,pos.getPallaX(),pos.getPallaY(),paint);
        canvas.drawBitmap(imgPortiere,pos.getPortiereX(),pos.getPortiereY(),paint);

    }
}
