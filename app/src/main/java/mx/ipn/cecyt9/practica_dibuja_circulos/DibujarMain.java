package mx.ipn.cecyt9.practica_dibuja_circulos;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.view.MotionEvent;
import android.view.View;

public class DibujarMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);

        SpecialView miVista = new SpecialView(this);
        setContentView(miVista);
    }



    class SpecialView extends View {
        float x = 50;
        float y = 50;
        String accion = "Accion";
        String texto = "Evento";
        Path Conjunto = new Path();

        public SpecialView(Context context) {

            super(context);
        }

        @Override
        protected void onDraw(Canvas Pizarra) {
            //canvas.drawColor(Color.rgb(255, 255, 150));
            Pizarra.drawColor(Color.WHITE); // color de fondo
            Paint pincel = new Paint();
            pincel.setStyle(Paint.Style.STROKE);
            pincel.setStrokeWidth(3);
            pincel.setColor(Color.GREEN);

            if (accion == "down") {
                Conjunto.moveTo(x, y);
                Conjunto.addCircle(x,y,6, Direction.CCW);
            }
            if (accion == "move") {
                Conjunto.addCircle(x,y,6, Direction.CCW);
            }
            Pizarra.drawPath(Conjunto, pincel);

            pincel.setColor(Color.BLUE);
            pincel.setTextSize(20);
            pincel.setStrokeWidth(2);
            Pizarra.drawText(texto, 100, 130, pincel); Pizarra.drawText("x = " + x +
                    "  y = " + y, 100, 50, pincel);
            //canvas.drawc
        }

        @Override
        public boolean onTouchEvent(MotionEvent evento) {

            x = evento.getX();
            y = evento.getY();

            if (evento.getAction() == MotionEvent.ACTION_DOWN) {
                accion = "down";
                texto = "Action Down";
            }

            if (evento.getAction() == MotionEvent.ACTION_UP) {
                texto = "Action Up";
            }

            if (evento.getAction() == MotionEvent.ACTION_MOVE) {
                accion = "move";
                texto = "Action Move";
            }
            invalidate();
            return true;
        }
    }

}
