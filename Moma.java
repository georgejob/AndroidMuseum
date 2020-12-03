package com.example.androidmuseum;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Moma extends AppCompatActivity {

    int[] ticketCount = {0, 1, 2, 3, 4, 5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moma);

        Toast.makeText(Moma.this, "Maximum of 5 tickets for each!", Toast.LENGTH_SHORT).show();
    }

    public void geWebsite(View view)
    {
        startActivity(new Intent(getIntent().ACTION_VIEW, Uri.parse("http://rutgers.edu")));
    }
}
