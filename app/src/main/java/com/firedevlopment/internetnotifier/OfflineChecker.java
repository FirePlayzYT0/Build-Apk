package com.firedevelopment.internetnotifier;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class OfflineChecker {
    public static void startOfflineCheck(Context context) {
        new Thread(() -> {
            while (!isNetworkAvailable(context)) {
                try { Thread.sleep(2000); } catch (InterruptedException e) {}
            }
            NotificationHelper.sendRandomOnlineNotification(context);
        }).start();
    }

    private static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}