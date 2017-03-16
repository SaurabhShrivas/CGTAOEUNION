package saurabh.cse.nitrr;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Prantadhyakshya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prantadhyakshya);

        final ImageView iv = (ImageView) findViewById(R.id.imagepresident);








        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Picasso.with(getApplication())
                        .load(R.drawable.president)
                        .resize(500, 500) // resizes the image to these dimensions (in pixel). does not respect aspect ratio
                        .into(iv);





                Toast.makeText(Prantadhyakshya.this, "Please check internet connection ", Toast.LENGTH_SHORT).show();



            }
        });




        Toolbar toolbar1= (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        toolbar1.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Button call = (Button) findViewById(R.id.btcall);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String uri = "tel:7224010631";
                    Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
                    if (ActivityCompat.checkSelfPermission(Prantadhyakshya.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
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