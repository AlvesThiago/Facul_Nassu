package com.projeto.shopshoes.util;
import android.content.Context;
import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import java.util.*;
public class Util {

    public static void setImageViewBgColor( Context context, ImageView imageView ) {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

        int initPixelPosition = Util.convertDpToPixel( context.getResources(), 2.1F );
        int pixel = bitmap.getPixel( initPixelPosition, initPixelPosition );

        GradientDrawable bgShape = (GradientDrawable) imageView.getBackground().getCurrent();
        bgShape.setColor( pixel );
    }
    public static int convertDpToPixel( Resources resources, float dp ) {
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ( metrics.densityDpi / 160F );
        return Math.round(px);
    }

    public static String codeBuyGenerator() {
        Random random = new Random();
        String code = "";

        for( int i = 0; i <= 18; i++ ){
            code += String.valueOf( random.nextInt( 10 ) );
        }
        return code;
    }

    public static String getImageSource( Context context, int image ) {
        return "android.resource://" + context.getPackageName() + "/" + image;
    }

    @BindingAdapter(value = {"app:context", "app:src"}, requireAll = true)
    public static final void setConfImage(ImageView iv, Context context, int image) {
        iv.setImageResource(image);
        Util.setImageViewBgColor(context, iv);
    }
}
