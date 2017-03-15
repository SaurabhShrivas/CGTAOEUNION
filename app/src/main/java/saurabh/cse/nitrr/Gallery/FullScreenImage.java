package saurabh.cse.nitrr.Gallery;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import saurabh.cse.nitrr.CustomVolleyRequest;
import saurabh.cse.nitrr.R;


public class FullScreenImage extends AppCompatActivity {
    ImageView fullscreenImageView;
    TextView tvid, tvid2;
    private Context context;
    GalleryContent galleryContent;
    private NetworkImageView imageView;

    private ImageLoader imageLoader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);
        Toolbar toolbar1= (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        toolbar1.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        fullscreenImageView = (NetworkImageView) findViewById(R.id.fullScreenImageView);

        tvid = (TextView) findViewById(R.id.tvid);

        tvid2 = (TextView) findViewById(R.id.tvid2);

        tvid.setText("Id:" + getIntent().getStringExtra("id"));
        tvid2.setText("image:" + getIntent().getStringExtra("imageUrl"));



        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(getIntent().getStringExtra("imageUrl"), ImageLoader.getImageListener(fullscreenImageView, R.drawable.image, android.R.drawable.ic_dialog_alert));

        //Showing data on the views
      //  galleryContent.setImageUrl(getIntent().getStringExtra("imageUrl"));









       // Picasso.with(context)
         //       .load(getIntent().getStringExtra("imageUrl"))
           //     .resize(width,height).into(fullscreenImageView);


    }

/*
    private void loadImage() {
        String url = getIntent().getStringExtra("imageUrl").trim();


        imageLoader = CustomVolleyRequest.getInstance(this.getApplicationContext())
                .getImageLoader();
        imageLoader.get(url, ImageLoader.getImageListener(fullscreenImageView,
                R.drawable.image, android.R.drawable
                        .ic_dialog_alert));
        //     fullscreenImageView.setImageUrl(url, imageLoader);
    }

*/

}
