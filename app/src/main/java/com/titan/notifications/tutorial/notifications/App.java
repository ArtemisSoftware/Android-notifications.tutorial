package com.titan.notifications.tutorial.notifications;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";
    public static final String CHANNEL_3_ID = "channel3";
    public static final String CHANNEL_4_ID = "channel4";
    public static final String CHANNEL_5_ID = "channel5";
    public static final String CHANNEL_6_ID = "channel6";
    public static final String CHANNEL_7_ID = "channel7";

    public static final String GROUP_1_ID = "group1";
    public static final String GROUP_2_ID = "group2";

    public static final String CHANNEL_THREE_ID = "channelThree";
    public static final String CHANNEL_FOUR_ID = "channelFour";


    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannelGroup group1 = new NotificationChannelGroup(GROUP_1_ID, "Group 1");
            NotificationChannelGroup group2 = new NotificationChannelGroup(GROUP_2_ID, "Group 2");


            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is Channel 1");
            channel1.setGroup(GROUP_1_ID);

            NotificationChannel channel2 = new NotificationChannel(CHANNEL_2_ID, "Channel 2", NotificationManager.IMPORTANCE_LOW);
            channel2.setDescription("This is Channel 2");
            channel2.setGroup(GROUP_1_ID);


            NotificationChannel channelThree = new NotificationChannel(CHANNEL_THREE_ID, "Channel Three", NotificationManager.IMPORTANCE_HIGH);
            channelThree.setDescription("This is Channel three");
            channelThree.setGroup(GROUP_2_ID);

            NotificationChannel channelFour = new NotificationChannel(CHANNEL_FOUR_ID, "Channel Four", NotificationManager.IMPORTANCE_LOW);
            channelFour.setDescription("This is Channel four");




            NotificationChannel channel3 = new NotificationChannel(CHANNEL_3_ID, "Channel 3", NotificationManager.IMPORTANCE_HIGH);
            channel3.setDescription("This is Channel 3");

            NotificationChannel channel4 = new NotificationChannel(CHANNEL_4_ID, "Channel 4", NotificationManager.IMPORTANCE_LOW);
            channel4.setDescription("This is Channel 4");

            NotificationChannel channel5 = new NotificationChannel(CHANNEL_5_ID, "Channel 5", NotificationManager.IMPORTANCE_HIGH);
            channel5.setDescription("This is Channel 5");

            NotificationChannel channel6 = new NotificationChannel(CHANNEL_6_ID, "Channel 6", NotificationManager.IMPORTANCE_LOW);
            channel6.setDescription("This is Channel 6");

            NotificationChannel channel7 = new NotificationChannel(CHANNEL_7_ID, "Channel 7", NotificationManager.IMPORTANCE_LOW);
            channel7.setDescription("This is Channel 7");





            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannelGroup(group1);
            manager.createNotificationChannelGroup(group2);

            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);


            manager.createNotificationChannel(channelThree);
            manager.createNotificationChannel(channelFour);

            manager.createNotificationChannel(channel3);
            manager.createNotificationChannel(channel4);
            manager.createNotificationChannel(channel5);

            manager.createNotificationChannel(channel6);
            manager.createNotificationChannel(channel7);
        }
    }

}
