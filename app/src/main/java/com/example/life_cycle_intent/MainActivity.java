package com.example.life_cycle_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
/*
* while launching app - create,start,resume
* while going background and going next screen - pause,stop,
* again get back from background  and come back from current screen- restart,start,resume
* while close the app - pause,stop ,destroy
* while changing orientation- pause,stop ,destroy,create, start,resume
*
* */


    //manifest- essential information about your android app to android os-meta data about of app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //intent- communication bt diff components, ask to perform some task
        //explicit intents- within own app - specify target components
        //implicit intents- use other apps to perform actions
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        Button button=findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondScreen();
            }
        });

        Button button1=findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage();
            }
        });
    }

//explicit intent
    public void goToSecondScreen(){
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
//implicit intent
    public void openWebPage(){
        Uri webPage= Uri.parse("https://www.google.com");
        Intent intent=new Intent(Intent.ACTION_VIEW,webPage);
        startActivity(intent);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}