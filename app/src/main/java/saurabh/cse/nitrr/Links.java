package saurabh.cse.nitrr;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Links extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);



        Toolbar toolbar1= (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        toolbar1.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Button b= (Button) findViewById(R.id.button);
        Button b2= (Button) findViewById(R.id.button2);
        Button b3= (Button) findViewById(R.id.button3);
        Button b4= (Button) findViewById(R.id.button4);
        Button b5= (Button) findViewById(R.id.button5);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://cg.nic.in/gadonline");
                Intent i1 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://cgdemo.nic.in/schooleducation");
                Intent i1 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://cgfinance.nic.in");
                Intent i1 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i1);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://revenue.cg.nic.in");
                Intent i1 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i1);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.google.com");
                Intent i1 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i1);
            }
        });
    }
}
