package com.firedevelopment.internetnotifier;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.media.RingtoneManager;
import java.util.Random;

public class NotificationHelper {
    private static final String CHANNEL_ID = "internet_notifier_channel";
    private static final String[] messages = {
        "🌐 Internet Connected! ✅\n📱 You’re online—stay connected!",
        "🚀 Internet is LIVE! ⚡\n💬 Time to chat, stream & explore!",
        "👋 Hello! You’re online! ✅\n📲 Don’t miss a thing—surf away!",
        "🌟 Connection Active! 💡\n📚 Learn, play, or scroll—make the most!",
        "⚡ You’re Online! 🌐\n📱 Enjoy seamless connectivity!"
    };

    public static void sendRandomOnlineNotification(Context context) {
        createNotificationChannel(context);
        Random rand = new Random();
        int index = rand.nextInt(messages.length);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("Internet Notifier")
                .setContentText(messages[index])
                .setSmallIcon(R.drawable.ic_notification)
                .setVibrate(new long[]{0, 500, 100, 500})
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(rand.nextInt(), builder.build());
    }

    private static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Internet Notifier";
            String description = "Channel for Internet Notifier";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}