package com.titan.notifications.tutorial.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.titan.notifications.tutorial.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    private MediaSessionCompat mediaSession;

    static List<Message> MESSAGES = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        notificationManager = NotificationManagerCompat.from(this);

        mediaSession = new MediaSessionCompat(this, "tag");

        MESSAGES.add(new Message("My Fair Lady", "Jim"));
        MESSAGES.add(new Message("Great movie", null));
        MESSAGES.add(new Message("Wait Until Dark", "Jim"));

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);

        ((Button) findViewById(R.id.btn_sendOnChannel1)).setOnClickListener(btn_sendOnChannel1_OnClickListener);
        ((Button) findViewById(R.id.btn_sendOnChannel2)).setOnClickListener(btn_sendOnChannel2_OnClickListener);
        ((Button) findViewById(R.id.btn_sendOnChannel3)).setOnClickListener(btn_sendOnChannel3_OnClickListener);
        ((Button) findViewById(R.id.btn_sendOnChannel4)).setOnClickListener(btn_sendOnChannel4_OnClickListener);

        ((Button) findViewById(R.id.btn_sendOnChannel6)).setOnClickListener(btn_sendOnChannel6_OnClickListener);
        ((Button) findViewById(R.id.btn_sendOnChannel7)).setOnClickListener(btn_sendOnChannel7_OnClickListener);
    }


    Button.OnClickListener btn_sendOnChannel1_OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            String title = editTextTitle.getText().toString();
            String message = editTextMessage.getText().toString();

            Intent activityIntent = new Intent(getApplicationContext(), NotificationsActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, activityIntent, 0);

            Intent broadcastIntent = new Intent(getApplicationContext(), NotificationReceiver.class);
            broadcastIntent.putExtra("toastMessage", message);
            PendingIntent actionIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.audrey_hepburn);

            Notification notification = new NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_1_ID)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setLargeIcon(largeIcon)
                    .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(getString(R.string.audrey_hepburn))
                        .setBigContentTitle("Audrey Hepburn Bio")
                        .setSummaryText("Atriz"))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setColor(Color.BLUE)
                    .setContentIntent(contentIntent)
                    .setAutoCancel(true)
                    .setOnlyAlertOnce(true)
                    .addAction(R.mipmap.ic_launcher, "Toast", actionIntent)
                    .build();

            notificationManager.notify(1, notification);
        }
    };


    Button.OnClickListener btn_sendOnChannel2_OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            String title = editTextTitle.getText().toString();
            String message = editTextMessage.getText().toString();

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.audrey_hepburn_2);

            Notification notification = new NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_2_ID)
                    .setSmallIcon(R.drawable.ic_two)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Luca Dotti")
                        .addLine("Sean Hepburn Ferrer")
                        .setBigContentTitle("Audrey Hepburn filhos")
                        .setSummaryText("Familia"))
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .build();

            notificationManager.notify(2, notification);
        }
    };



    Button.OnClickListener btn_sendOnChannel3_OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            String title = editTextTitle.getText().toString();
            String message = editTextMessage.getText().toString();

            Intent activityIntent = new Intent(getApplicationContext(), NotificationsActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, activityIntent, 0);

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.audrey_hepburn_2);

            Notification notification = new NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_3_ID)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setLargeIcon(picture)
                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(picture)
                            .bigLargeIcon(null))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setContentIntent(contentIntent)
                    .setAutoCancel(true)
                    .setOnlyAlertOnce(true)
                    .build();

            notificationManager.notify(3, notification);
        }
    };


    Button.OnClickListener btn_sendOnChannel4_OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            String title = editTextTitle.getText().toString();
            String message = editTextMessage.getText().toString();

            Bitmap artwork = BitmapFactory.decodeResource(getResources(), R.drawable.audrey_hepburn);

            Notification notification = new NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_4_ID)
                    .setSmallIcon(R.drawable.ic_two)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setLargeIcon(artwork)
                    .addAction(R.drawable.ic_dislike, "Dislike", null)
                    .addAction(R.drawable.ic_previous, "Previous", null)
                    .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(0,1)
                        .setMediaSession(mediaSession.getSessionToken()))
                    .setSubText("My artwork")
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .build();

            notificationManager.notify(4, notification);
        }
    };



    public void sendOnChannel5(View v) {
        sendChannel5Notification(this);
    }

    public static void sendChannel5Notification(Context context) {
        Intent activityIntent = new Intent(context, NotificationsActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, activityIntent, 0);

        RemoteInput remoteInput = new RemoteInput.Builder("key_text_reply")
                .setLabel("Your answer...")
                .build();

        Intent replyIntent;
        PendingIntent replyPendingIntent = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            replyIntent = new Intent(context, DirectReplyReceiver.class);
            replyPendingIntent = PendingIntent.getBroadcast(context,
                    0, replyIntent, 0);
        } else {
            //start chat activity instead (PendingIntent.getActivity)
            //cancel notification with notificationManagerCompat.cancel(id)
        }

        NotificationCompat.Action replyAction = new NotificationCompat.Action.Builder(
                R.drawable.ic_reply,
                "Reply",
                replyPendingIntent
        ).addRemoteInput(remoteInput).build();

        NotificationCompat.MessagingStyle messagingStyle =
                new NotificationCompat.MessagingStyle("Me");
        messagingStyle.setConversationTitle("Group Chat");

        for (Message chatMessage : MESSAGES) {
            NotificationCompat.MessagingStyle.Message notificationMessage =
                    new NotificationCompat.MessagingStyle.Message(
                            chatMessage.getText(),
                            chatMessage.getTimestamp(),
                            chatMessage.getSender()
                    );
            messagingStyle.addMessage(notificationMessage);
        }

        Notification notification = new NotificationCompat.Builder(context, App.CHANNEL_5_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setStyle(messagingStyle)
                .addAction(replyAction)
                .setColor(Color.BLUE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(5, notification);
    }



    Button.OnClickListener btn_sendOnChannel6_OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            final int progressMax = 100;

            final NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_6_ID)
                    .setSmallIcon(R.drawable.ic_two)
                    .setContentTitle("Download")
                    .setContentText("Download in progress...")
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .setOngoing(true)
                    .setOnlyAlertOnce(true)
                    .setProgress(progressMax, 0, true);

            notificationManager.notify(6, notification.build());

            new Thread(new Runnable() {
                @Override
                public void run() {

                    SystemClock.sleep(2000);
                    for (int progress = 0; progress <= progressMax; progress += 20) {
                        //notification.setProgress(progressMax, progress, false);
                        //notificationManager.notify(6, notification.build());
                        SystemClock.sleep(1000);
                    }

                    notification.setContentText("Download finished")
                            .setProgress(0, 0, false)
                            .setOngoing(false);
                    notificationManager.notify(6, notification.build());

                }
            }).start();
        }
    };


    Button.OnClickListener btn_sendOnChannel7_OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            String title1 = "Title 1";
            String message1 = "Message 1";
            String title2 = "Title 2";
            String message2 = "Message 2";

             Notification notification1 = new NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_7_ID)
                    .setSmallIcon(R.drawable.ic_two)
                    .setContentTitle(title1)
                    .setContentText(message1)
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                     .setGroup("example_group")
                    .build();

            Notification notification2 = new NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_7_ID)
                    .setSmallIcon(R.drawable.ic_two)
                    .setContentTitle(title2)
                    .setContentText(message2)
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .setGroup("example_group")
                    .build();


            Notification summaryNotification = new NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_7_ID)
                    .setSmallIcon(R.drawable.ic_reply)
                    .setStyle(new NotificationCompat.InboxStyle()
                        .addLine(title2 + " "+ message2)
                        .addLine(title1 + " "+ message1)
                        .setBigContentTitle("2 new messages")
                        .setSummaryText("user@example.com"))
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .setGroup("example_group")
                    .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_CHILDREN)
                    .setGroupSummary(true)
                    .build();


            SystemClock.sleep(2000);
            notificationManager.notify(2, notification1);
            SystemClock.sleep(2000);
            notificationManager.notify(3, notification2);
            SystemClock.sleep(2000);
            notificationManager.notify(7, summaryNotification);

        }
    };


}
