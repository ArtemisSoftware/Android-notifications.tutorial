package com.titan.notifications.tutorial.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.titan.notifications.tutorial.R;

public class NotificationsActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);

        ((Button) findViewById(R.id.btn_sendOnChannel1)).setOnClickListener(btn_sendOnChannel1_OnClickListener);
        ((Button) findViewById(R.id.btn_sendOnChannel2)).setOnClickListener(btn_sendOnChannel2_OnClickListener);
    }


    Button.OnClickListener btn_sendOnChannel1_OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            String title = editTextTitle.getText().toString();
            String message = editTextMessage.getText().toString();

            Notification notification = new NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_1_ID)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .build();

            notificationManager.notify(1, notification);
        }
    };


    Button.OnClickListener btn_sendOnChannel2_OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            String title = editTextTitle.getText().toString();
            String message = editTextMessage.getText().toString();

            Notification notification = new NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_2_ID)
                    .setSmallIcon(R.drawable.ic_two)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .build();

            notificationManager.notify(2, notification);
        }
    };
}
