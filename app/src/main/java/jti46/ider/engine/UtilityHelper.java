package jti46.ider.engine;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.util.Date;

/**
 * Created by yunhasnawa on 14/11/16.
 */

public class UtilityHelper
{
    public static void showAlert(Context context, String title, String message)
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(message);
        dialogBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialogBuilder.show();
    }

    public static String dateNow()
    {
        Date now = new Date();

        String strNow = now.toString();

        return strNow;
    }

    public static void logi(String message)
    {
        Log.i("IDER", message);
    }

    public static void loge(String message)
    {
        Log.e("IDER", message);
    }
}
