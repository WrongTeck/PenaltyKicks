package it.edu.fermimn.penaltykicks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class GraficaGioco extends View {

    int xpalla, ypalla, xportiere, yportiere;

    private Paint paint;
    private Bitmap imgPalla;
    private Bitmap imgPortiere;
    private Bitmap imgPorta;

    private void inizializza() {
        paint = new Paint();  // possiamo pensare all'oggetto paint come al "pennello" che ci server per disegnare
        imgPorta = BitmapFactory.decodeResource(getResources(), R.drawable.porta_sprite);
        imgPortiere = BitmapFactory.decodeResource(getResources(), R.drawable.portiere_sprite1);
        imgPalla = BitmapFactory.decodeResource(getResources(), R.drawable.ball_sprite );
    }

    public GraficaGioco(Context context) {
        super(context);
        inizializza();
    }

    public GraficaGioco(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        inizializza();
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

        canvas.drawBitmap(imgPorta,100,50,paint);
        canvas.drawBitmap(imgPalla,450,1700,paint);
        canvas.drawBitmap(imgPortiere,400,100,paint);

    }
}
