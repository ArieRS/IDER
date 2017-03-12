package jti46.ider;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;

/**
 * Created by alhamdulillah on 3/12/17.
 */

public class Global {
    public static void showDialogError(Context ctx, String msg, String title) {
        new AlertDialog.Builder(ctx)
                .setIcon(android.R.drawable.ic_dialog_alert).setTitle(title)
                .setMessage(msg)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                }).create().show();
    }
    public static void showDialogSuccess(Context ctx, String msg, String title) {
        new AlertDialog.Builder(ctx).setTitle(title).setMessage(msg)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                }).create().show();
    }
    public static boolean checkConnection(Context ctx) {
        boolean connect = false;
        TelephonyManager tm = (TelephonyManager) ctx
                .getSystemService(Context.TELEPHONY_SERVICE);
        String networkOperator = tm.getNetworkOperatorName();
        final ConnectivityManager connMgr = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo wifi = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final NetworkInfo mobile = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        final int statusSim = tm.getSimState();

        if (statusSim != TelephonyManager.SIM_STATE_ABSENT) {
            if (wifi.isConnected() || mobile.isConnected()
                    || !networkOperator.equals("")) {
                connect = true;
            }
        } else {
            if (wifi.isConnected() || mobile.isConnected()
                    || !networkOperator.equals("")) {
                connect = true;
            }
        }
        return connect;
    }
    public static ProgressDialog showProgressDialog(Context context,
                                                    String title, String message) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setIndeterminate(true);
        dialog.setInverseBackgroundForced(false);
        dialog.setCancelable(true);
        dialog.setTitle(title);
        dialog.setMessage(message);

        return dialog;
    }
}
