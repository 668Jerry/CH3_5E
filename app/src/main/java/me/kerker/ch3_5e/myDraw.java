package me.kerker.ch3_5e;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by lololol on 18/Dec/14.
 */
public class myDraw extends View {
    private Paint paint = new Paint();

    public myDraw(Context context)
    {
        super(context);
        setBackgroundColor(Color.RED);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        canvas.drawText("Hello!", 0, 100, paint);

    }

}
