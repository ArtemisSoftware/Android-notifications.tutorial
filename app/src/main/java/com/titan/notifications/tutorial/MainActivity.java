package com.titan.notifications.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.titan.notifications.tutorial.notifications.NotificationsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.btn_notificacao)).setOnClickListener(btn_notificacao_OnClickListener);
    }


    Button.OnClickListener btn_notificacao_OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent browserIntent = new Intent(getApplicationContext(), NotificationsActivity.class);
            startActivity(browserIntent);
        }
    };

}
