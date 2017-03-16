package saurabh.cse.nitrr.Gallery;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

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
        fullscreenImageView= (ImageView) findViewById(R.id.fullScreenImageView);


        Picasso.with(getApplicationContext()).load(getIntent().getStringExtra("imageUrl")).into(fullscreenImageView);





        //fullscreenImageView = (ImageView) findViewById(R.id.fullScreenImageView);

      //  imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
       // imageLoader.get(getIntent().getStringExtra("imageUrl"), ImageLoader.getImageListener(fullscreenImageView, R.drawable.image, android.R.drawable.ic_dialog_alert));

        //Showing data on the views
      //  galleryContent.setImageUrl(getIntent().getStringExtra("imageUrl"));

       // Picasso.with(context)
         //       .load(getIntent().getStringExtra("imageUrl"))
           //     .resize(width,height).into(fullscreenImageView);


    }



    //adding below  code in the on create will work fine as well
    //       new DownloadImageTask((ImageView) findViewById(R.id.fullScreenImageView))
    //             .execute(getIntent().getExtras().getString("imageUrl"));


/*


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

*/



}
