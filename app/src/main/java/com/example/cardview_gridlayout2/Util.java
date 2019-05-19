package com.example.cardview_gridlayout2;

import android.content.Context;
import android.os.Build;

import java.text.DecimalFormat;

public class Util {
    public static int convertDpToPx(Context ctx, float dp) {
        float d = ctx.getResources().getDisplayMetrics().density;
        return (int) (d * dp);
    }

    public static final int getColor(Context context, int id){
        if(Build.VERSION.SDK_INT>=23) {
            return context.getColor(id);
        } else{
            return context.getResources().getColor(id);
        }
    }

    public static String toNumFormat(int num){
        DecimalFormat df = new DecimalFormat("#, ###");
        return df.format(num);
    }
}
