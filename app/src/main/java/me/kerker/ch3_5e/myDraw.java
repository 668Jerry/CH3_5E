package me.kerker.ch3_5e;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by lololol on 18/Dec/14.
 */
public class myDraw extends View
        implements GestureDetector.OnGestureListener
{
    private Paint paint = new Paint();
    private ArrayList<PointF> alpfPoints = new ArrayList<PointF>();
    private GestureDetector gesturedector;
    private ArrayList<String> alsStatus = new ArrayList<String>();
    private String keycode = "";

    public myDraw(Context context)
    {
        super(context);
        setBackgroundColor(Color.RED);
        setFocusable(true);
        gesturedector = new GestureDetector(context, this);
        setFocusableInTouchMode(true);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        canvas.drawText("Hello!", 0, 100, paint);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(20);

        for (int i = 0; i < alpfPoints.size(); i++) {
            canvas.drawCircle(alpfPoints.get(i).x, alpfPoints.get(i).y, 3, paint);
            System.out.println("i: " + i);
        }

        for (int i = 0; i < Math.min(10, alsStatus.size()); i++)
        {
            canvas.drawText(alsStatus.get(i), 0, 40 + i * 20, paint);
        }

        canvas.drawText(keycode, 0, 300, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        gesturedector.onTouchEvent(e);
        int iAction = e.getAction();
        int iTouchCount = e.getPointerCount();
        if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
//            System.out.println("if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {");
            alpfPoints.add(new PointF(e.getX(), e.getY()));
            invalidate();
        } else if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
//            System.out.println("if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {");
        } else if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_MOVE) {
//            System.out.println("if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_MOVE) {");
        } else if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_DOWN) {
//            System.out.println("if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_DOWN) {");
        } else if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_UP) {
//            System.out.println("if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_UP) {");
        } else if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_CANCEL) {
//            System.out.println("if ((iAction & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_CANCEL) {");
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e)
    {
        alsStatus.add(0, "LongPress");
        invalidate();
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float fPointX, float fPointY) {
        alsStatus.add(0, "onScroll fPointX = " + fPointX + "; fPointY = " + fPointY);
        invalidate();
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float fPointX, float fPointY) {
        alsStatus.add(0, "onFling fPointX = " + fPointX + "; fPointY = " + fPointY);
        invalidate();
        return false;
    }

    public boolean onShowPress(MotionEvent e1, MotionEvent e2, float fPointX, float fPointY) {
        alsStatus.add(0, "onShowPress fPointX = " + fPointX + "; fPointY = " + fPointY);
        invalidate();
        return false;
    }

    public boolean onDown(MotionEvent e1, MotionEvent e2, float fPointX, float fPointY) {
        alsStatus.add(0, "onDown fPointX = " + fPointX + "; fPointY = " + fPointY);
        invalidate();
        return false;
    }

    public boolean onSingleTapUp(MotionEvent e1, MotionEvent e2, float fPointX, float fPointY) {
        alsStatus.add(0, "onSingleTapUp fPointX = " + fPointX + "; fPointY = " + fPointY);
        invalidate();
        return false;
    }

    @Override
    public boolean onKeyDown(int iKeyCode, KeyEvent e)
    {
        switch (iKeyCode) {
            case KeyEvent.KEYCODE_BACK:
                keycode = "[BACK]:";
                break;
            case KeyEvent.KEYCODE_MENU:
                keycode = "[MENU]:";
                break;
            default:
                keycode = "[" + keycode + "]";
        }
        invalidate();

        if (iKeyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
            alertDialog.setTitle("Notice");
            alertDialog.setMessage("Go!");
            alertDialog.setPositiveButton("OK", null);
            alertDialog.show();
        } else if (iKeyCode == KeyEvent.KEYCODE_MENU) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
            alertDialog.setTitle("Notice");
            alertDialog.setMessage("Are you ready?");
            alertDialog.setPositiveButton("NO", null);
            alertDialog.setNegativeButton("YES", null);
            alertDialog.show();
        }

        return true;
    }

    @Override
    public boolean onKeyUp(int iKeyCode, KeyEvent e)
    {
        keycode = "";
        invalidate();

        return true;
    }
}
