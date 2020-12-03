package com.example.androidmuseum;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.app.ActionBar;
import android.view.MenuItem;
import android.view.Menu;
import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;

public class Srgm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {




    Spinner spin;
    Spinner spin2;
    Spinner spin3;
    String[] ticketCount = {"0", "1", "2", "3", "4", "5"};

    EditText ticketEditText;
    EditText taxEditText;
    EditText totalEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srgm);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ticket Price Calculator");

        Toast.makeText(Srgm.this, "Maximum of 5 tickets for each!", Toast.LENGTH_SHORT).show();

        ticketEditText = (EditText) findViewById(R.id.ticketPrice);
        taxEditText = (EditText) findViewById(R.id.salesTax);
        totalEditText = (EditText) findViewById(R.id.ticketTotal);

        spin = (Spinner) findViewById(R.id.adultSpinner);
        spin.setOnItemSelectedListener(this);

        spin2 = (Spinner) findViewById(R.id.seniorSpinner);
        spin.setOnItemSelectedListener(this);

        spin3 = (Spinner) findViewById(R.id.childSpinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,ticketCount);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin2.setAdapter(aa);
        spin3.setAdapter(aa);

        Button calc = findViewById(R.id.calculatePrice);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePrice();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        //Toast.makeText(getApplicationContext(), ticketCount[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    public void getWebsite(View view)
    {
        startActivity(new Intent(getIntent().ACTION_VIEW, Uri.parse("https://www.guggenheim.org/")));
    }

    public void calculatePrice() {
        int adultTotal = Integer.valueOf(spin.getSelectedItem().toString()) * 25;
        int seniorTotal = Integer.valueOf(spin2.getSelectedItem().toString()) * 18;
        int studentTotal = Integer.valueOf(spin3.getSelectedItem().toString()) * 18;
        int ticketPrice = adultTotal + seniorTotal + studentTotal;
        ticketEditText.setText("ticket price: $" + Integer.toString(ticketPrice));

        DecimalFormat df = new DecimalFormat("#.00");
        double taxAmount = ticketPrice * 0.08875;
        taxEditText.setText("sales tax: $" + String.format( "%.2f", taxAmount));

        totalEditText.setText("ticket total: $" + String.format( "%.2f", ticketPrice + taxAmount));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
