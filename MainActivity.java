package com.example.androidmuseum;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import android.os.Bundle;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button moma = findViewById(R.id.MomaButton);
        Button amnh = findViewById(R.id.HistoryButton);
        Button srgm = findViewById(R.id.GugButton);
        Button metr = findViewById(R.id.MetroButton);

        moma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Hey", Toast.LENGTH_SHORT).show();
                openMOMAPage();
            }
        });

        amnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        srgm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        metr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


       /* num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        add = findViewById(R.id.button);
        result = findViewById(R.id.result);d*/
    }

    public void openMOMAPage() {
        Intent intent = new Intent(this, Moma.class);
        startActivity(intent);
    }



    /*public void addition(View view)
    {
        int sum = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
        result.setText(String.valueOf(sum));
    }*/







    /*public void geWebsite(View view)
    {
        startActivity(new Intent(getIntent().ACTION_VIEW, Uri.parse("http://rutgers.edu")));
    }*/
}
