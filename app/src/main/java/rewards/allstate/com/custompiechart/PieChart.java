package rewards.allstate.com.custompiechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

/*
 * Created by ofaro on 3/10/2015.
 */
public class PieChart extends View {
    float start=0;
    int width;
    int[] data;
    int cx,cy;
    int numberOfparts;//it tells many data or item will be placed in chart
    private int[] color;

    public PieChart(Context context, int numOfItems,int[] data,int[] color) {
        super(context);
        setFocusable(true);
        this.numberOfparts=numOfItems;
        this.data=data;
        this.color=color;
       }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(0);
        p.setStyle(Paint.Style.FILL);
        float[] scaledValues = scale();

        RectF rectF = new RectF(0,0,getWidth(),getWidth());

        p.setColor(Color.BLACK);
        for(int i=0;i<numberOfparts;i++){
            p.setColor(color[i]);
            p.setStyle(Paint.Style.FILL);

            canvas.drawArc(rectF,start,scaledValues[i],true,p);
            start=start+scaledValues[i];
        }

        Paint cenPaint=new Paint();
        int radius=getWidth()/2-100;
        cenPaint.setStyle(Paint.Style.FILL);
        cenPaint.setColor(Color.BLACK);
        cx=cy=getWidth()/2;
        canvas.drawCircle(cx,cy,radius,cenPaint);
    }
    private float[] scale() {
        float[] scaledValues = new float[this.data.length];
        float total = getTotal(); //Total all values supplied to the chart
        for (int i = 0; i < this.data.length; i++) {
            scaledValues[i] = (this.data[i] / total) * 360; //Scale each value
        }
        return scaledValues;
    }

    private float getTotal() {
        float total = 0;
        for (float val : this.data)
            total += val;
        return total;
    }


}