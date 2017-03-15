package saurabh.cse.nitrr;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Contacts extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        Toolbar toolbar1= (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        toolbar1.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Button call1 = (Button) findViewById(R.id.btcall1);
        Button call2 = (Button) findViewById(R.id.btcall2);
        Button call3 = (Button) findViewById(R.id.btcall3);
        Button call4 = (Button) findViewById(R.id.btcall4);
        Button call5 = (Button) findViewById(R.id.btcall5);
        Button call6 = (Button) findViewById(R.id.btcall6);

        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String uri = "tel:7224010631";
                    Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
                    if (ActivityCompat.checkSelfPermission(Contacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    startActivity(callintent);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Your Call Has Failed", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String uri = "tel:9407665892";
                    Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
                    if (ActivityCompat.checkSelfPermission(Contacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    startActivity(callintent);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Your Call Has Failed", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String uri = "tel:9926149567";
                    Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
                    if (ActivityCompat.checkSelfPermission(Contacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    startActivity(callintent);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Your Call Has Failed", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        call4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String uri = "tel:8959828705";
                    Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
                    if (ActivityCompat.checkSelfPermission(Contacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    startActivity(callintent);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Your Call Has Failed", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        call5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String uri = "tel:9406263832";
                    Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
                    if (ActivityCompat.checkSelfPermission(Contacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    startActivity(callintent);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Your Call Has Failed", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        call6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String uri = "tel:9827954483";
                    Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
                    if (ActivityCompat.checkSelfPermission(Contacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    startActivity(callintent);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Your Call Has Failed", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
