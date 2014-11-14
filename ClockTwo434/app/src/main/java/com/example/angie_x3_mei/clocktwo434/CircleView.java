package com.example.angie_x3_mei.clocktwo434;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;
import java.util.TimeZone;

public class CircleView extends View {

    private Paint circlePaint = new Paint();

    TimeZone t = TimeZone.getTimeZone("EST");
    Calendar c = Calendar.getInstance(t);
    int seconds = c.get(Calendar.SECOND);
    int hour = c.get(Calendar.HOUR);
    int minutes = c.get(Calendar.MINUTE);

    public CircleView(Context context) {

        super(context);
        init(null, 0); // Read all attribute;
    }

    public CircleView(Context context, AttributeSet attrs) {

        super(context, attrs);
        init(attrs, 0); // Read all attribute;
    }

    public CircleView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        init(attrs, defStyle); // Read all attribute;
    }

    private void init(AttributeSet attrs, int defStyle)
    {
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        seconds++;
        if (seconds > 59){
            minutes++;
            seconds = 0;
        }
        if (minutes > 59){
            minutes = 0;
            hour++;
        }
        if (hour > 12){
            hour = 1;
        }

        float smallR = getWidth()/2-50;
        float radius = getWidth()/20 + seconds;

        if (hour == 0){ // hour 0
            circlePaint.setARGB(minutes*4+19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, 3*Math.PI/2), findSin(smallR, 3*Math.PI/2),radius,circlePaint);
            defaultCircles(canvas, 0);
        }else if (hour == 1) { //hour 1
            circlePaint.setARGB(minutes*4+19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, 5*Math.PI/3), findSin(smallR, 5*Math.PI/3), radius, circlePaint);
            defaultCircles(canvas, 1);
        }else if (hour == 2){ // hour 2
            circlePaint.setARGB(minutes*4+19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, 11*Math.PI/6), findSin(smallR, 11*Math.PI/6), radius,circlePaint);
            defaultCircles(canvas, 2);
        }else if (hour == 3){ // hour 3
            circlePaint.setARGB(minutes*4+19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, 0.0), findSin(smallR, 0.0), radius,circlePaint);
            defaultCircles(canvas, 3);
        }else if (hour == 4){ // hour 4
            circlePaint.setARGB(minutes*4+19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, Math.PI/6), findSin(smallR, Math.PI/6),radius,circlePaint);
            defaultCircles(canvas, 4);
        }else if (hour == 5){ // hour 5
            circlePaint.setARGB(minutes*4+19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, Math.PI/3), findSin(smallR, Math.PI/3),radius,circlePaint);
            defaultCircles(canvas, 5);
        }else if (hour == 6){ // hour 6
            circlePaint.setARGB(minutes*4+19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, Math.PI/2), findSin(smallR, Math.PI/2),radius,circlePaint);
            defaultCircles(canvas,6);
        }else if (hour == 7) { // hour 7
            circlePaint.setARGB(minutes * 4 + 19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, 2 * Math.PI / 3), findSin(smallR, 2 * Math.PI / 3), radius, circlePaint);
            defaultCircles(canvas, 7);
        }else if (hour == 8) { // hour 8
            circlePaint.setARGB(minutes*4+19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, 5*Math.PI/6), findSin(smallR, 5*Math.PI/6), radius, circlePaint);
            defaultCircles(canvas, 8);
        }else if (hour == 9){ // hour 9
            circlePaint.setARGB(minutes*4+19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, Math.PI), findSin(smallR, Math.PI),radius,circlePaint);
            defaultCircles(canvas,9);
        }else if (hour == 10) { // hour 10
            circlePaint.setARGB(minutes*4+19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, 7*Math.PI/6), findSin(smallR, 7*Math.PI/6), radius, circlePaint);
            defaultCircles(canvas, 10);
        }else if (hour == 11) { // hour 11
            circlePaint.setARGB(minutes*4+19, 255, 0, 0);
            canvas.drawCircle(findCos(smallR, 4*Math.PI/3), findSin(smallR, 4*Math.PI/3), radius, circlePaint);
            defaultCircles(canvas, 11);
        }
    }
        // Move canvas down and right 1 pixel.
       // canvas.drawLine(0,0,getWidth(),getHeight(),circlePaint);


    protected void defaultCircles(Canvas canvas, int hour){
       float normR = getWidth()/20;
       float smallR = getWidth()/2-50;

       if (hour != 0 && 0 < hour) {
           circlePaint.setColor(Color.BLACK);
           canvas.drawCircle(findCos(smallR, 3*Math.PI/2), findSin(smallR, 3*Math.PI/2), normR, circlePaint); // hour 0
       }
       else if (0 != hour) {
           circlePaint.setColor(Color.LTGRAY);
           canvas.drawCircle(findCos(smallR, Math.PI/2), findSin(smallR, Math.PI/2), normR, circlePaint);
       }

        if (hour != 1 && 1 < hour) {
            circlePaint.setColor(Color.BLACK);
            canvas.drawCircle(findCos(smallR, 5*Math.PI/3), findSin(smallR, 5*Math.PI/3), normR, circlePaint); //hour 1
        }
        else if (hour != 1) {
            circlePaint.setColor(Color.LTGRAY);
            canvas.drawCircle(findCos(smallR, 5*Math.PI/3), findSin(smallR, 5*Math.PI/3), normR, circlePaint);
        }


        if (hour != 2 && 2 < hour) {
            circlePaint.setColor(Color.BLACK);
            canvas.drawCircle(findCos(smallR, 11*Math.PI/6), findSin(smallR, 11*Math.PI/6), normR, circlePaint); // hour 2
        }
        else if (hour != 2) {
            circlePaint.setColor(Color.LTGRAY);
            canvas.drawCircle(findCos(smallR, 11*Math.PI/6), findSin(smallR, 11*Math.PI/6), normR, circlePaint);
        }

        if (hour != 3 && 3 < hour) {
            circlePaint.setColor(Color.BLACK);
            canvas.drawCircle(findCos(smallR, 0.0), findSin(smallR, 0.0), normR, circlePaint); // hour 3
        }
        else if (hour != 3) {
            circlePaint.setColor(Color.LTGRAY);
            canvas.drawCircle(findCos(smallR, 0.0), findSin(smallR, 0.0), normR, circlePaint);
        }

        if (hour != 4 && 4 < hour) {
            circlePaint.setColor(Color.BLACK);
            canvas.drawCircle(findCos(smallR, Math.PI/6), findSin(smallR, Math.PI/6), normR, circlePaint); // hour 4
        }
        else if (hour != 4) {
            circlePaint.setColor(Color.LTGRAY);
            canvas.drawCircle(findCos(smallR, Math.PI/6), findSin(smallR, Math.PI/6), normR, circlePaint);
        }

        if (hour != 5 && 5 < hour) {
            circlePaint.setColor(Color.BLACK);
            canvas.drawCircle(findCos(smallR, Math.PI/3), findSin(smallR, Math.PI/3), normR, circlePaint); // hour 5
        }
        else if (hour != 5) {
            circlePaint.setColor(Color.LTGRAY);
            canvas.drawCircle(findCos(smallR, Math.PI/3), findSin(smallR, Math.PI/3), normR, circlePaint);
        }

        if (hour != 6 && 6 < hour) {
            circlePaint.setColor(Color.BLACK);
            canvas.drawCircle(findCos(smallR, Math.PI/2), findSin(smallR, Math.PI/2), normR, circlePaint); // hour 6
        }
        else if (6 != hour) {
            circlePaint.setColor(Color.LTGRAY);
            canvas.drawCircle(findCos(smallR, Math.PI/2), findSin(smallR, Math.PI/2), normR, circlePaint);
        }

        if (hour != 7 && 7 < hour) {
            circlePaint.setColor(Color.BLACK);
            canvas.drawCircle(findCos(smallR, 2*Math.PI/3), findSin(smallR, 2*Math.PI/3), normR, circlePaint); // hour 7
        }
        else if (hour != 7) {
            circlePaint.setColor(Color.LTGRAY);
            canvas.drawCircle(findCos(smallR, 2*Math.PI/3), findSin(smallR, 2*Math.PI/3), normR, circlePaint);
        }


        if (hour != 8 && 8 < hour) {
            circlePaint.setColor(Color.BLACK);
            canvas.drawCircle(findCos(smallR, 5*Math.PI/6), findSin(smallR, 5*Math.PI/6), normR, circlePaint); // hour 8
        }
        else if (hour != 8) {
            circlePaint.setColor(Color.LTGRAY);
            canvas.drawCircle(findCos(smallR, 5*Math.PI/6), findSin(smallR, 5*Math.PI/6), normR, circlePaint);
        }


        if (hour != 9 && 9 < hour) {
            circlePaint.setColor(Color.BLACK);
            canvas.drawCircle(findCos(smallR, Math.PI), findSin(smallR, Math.PI), normR, circlePaint); // hour 9
        }
        else if (hour != 9) {
            circlePaint.setColor(Color.LTGRAY);
            canvas.drawCircle(findCos(smallR, Math.PI), findSin(smallR, Math.PI), normR, circlePaint);
        }


        if (hour != 10 && 10 < hour) {
            circlePaint.setColor(Color.BLACK);
            canvas.drawCircle(findCos(smallR, 7*Math.PI/6), findSin(smallR, 7*Math.PI/6), normR, circlePaint); // hour 10
        }
        else if (hour != 10) {
            circlePaint.setColor(Color.LTGRAY);
            canvas.drawCircle(findCos(smallR, 7*Math.PI/6), findSin(smallR, 7*Math.PI/6), normR, circlePaint);
        }


       if (hour != 11 && 11 < hour) {
           circlePaint.setColor(Color.BLACK);
           canvas.drawCircle(findCos(smallR, 4*Math.PI/3), findSin(smallR, 4*Math.PI/3), normR, circlePaint); // hour 11
       }
       else if (hour != 11) {
           circlePaint.setColor(Color.LTGRAY);
           canvas.drawCircle(findCos(smallR, 4*Math.PI/3), findSin(smallR, 4*Math.PI/3), normR, circlePaint);
       }
    }

    protected float findCos(Float radius, Double degree){
        double cosD= radius*Math.cos(degree);
        float cosF = (float) cosD;
        return cosF + getWidth()/2;
    }

    protected float findSin(Float radius, Double degree){
        double sinD = radius*Math.sin(degree);
        float sinF= (float) sinD;
        return sinF + getHeight()/2;
    }
}