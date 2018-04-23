package com.example.jessica.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class Main extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button volu = (Button) findViewById(R.id.vol);

        volu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //setContentView(R.layout.activity_main);
                Intent it = new Intent(Main.this, MainActivity.class);
                startActivity(it);
            }
        });

    }

}
