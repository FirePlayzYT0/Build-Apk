package com.firedevelopment.internetnotifier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkReceiver extends BroadcastReceiver {
    private static boolean wasOnline = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isOnline = activeNetwork != null && activeNetwork.isConnected();

        if (isOnline && !wasOnline) {
            NotificationHelper.sendRandomOnlineNotification(context);
            wasOnline = true;
        } else if (!isOnline && wasOnline) {
            OfflineChecker.startOfflineCheck(context);
            wasOnline = false;
        }
    }
}