package com.titan.notifications.tutorial.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.titan.notifications.tutorial.R;

public class NotificationsActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    private MediaSessionCompat mediaSession;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        notificationManager = NotificationManagerCompat.from(this);

        mediaSession = new MediaSessionCompat(this, "tag");

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);

        ((Button) findViewById(R.id.btn_sendOnChannel1)).setOnClickListener(btn_sendOnChannel1_OnClickListener);
        ((Button) findViewById(R.id.btn_sendOnChannel2)).setOnClickListener(btn_sendOnChannel2_OnClickListener);
        ((Button) findViewById(R.id.btn_sendOnChannel3)).setOnClickListener(btn_sendOnChannel3_OnClickListener);
        ((Button) findViewById(R.id.btn_sendOnChannel4)).setOnClickListener(btn_sendOnChannel4_OnClickListener);
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

            notificationManager.notify(1, notification);
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

            notificationManager.notify(2, notification);
        }
    };
}
