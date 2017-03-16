package saurabh.cse.nitrr.Gallery;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import saurabh.cse.nitrr.CustomVolleyRequest;
import saurabh.cse.nitrr.R;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    //Imageloader to load image
    private ImageLoader imageLoader;
    private Context context;
    int lastPosition = -1;




    //List to store all gallerycontents
    ArrayList<GalleryContent> galleryContents;



    //Constructor of this class
    public CardAdapter(ArrayList<GalleryContent> galleryContents, Context context){
        super();
        //Getting all gallerycontents
        this.galleryContents = galleryContents;
        this.context = context;
    }

    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallerypic, parent, false);
        ViewHolder viewHolder = new ViewHolder(v,context, galleryContents);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //Getting the particular item from the list
        final GalleryContent galleryContent =  galleryContents.get(position);

        //Loading image from url
        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(galleryContent.getImageUrl(), ImageLoader.getImageListener(holder.imageView, R.drawable.image, android.R.drawable.ic_dialog_alert));

        //Showing data on the views
        holder.imageView.setImageUrl(galleryContent.getImageUrl(), imageLoader);
        holder.textViewId.setText(galleryContent.getId());



        holder.imageView.setOnClickListener(new  View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

           //     Toast.makeText(v.getContext(), "OnClick :" + galleryContents.get(position), Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(context,FullScreenImage.class);
                intent.putExtra("imageUrl", galleryContent.getImageUrl());
                intent.putExtra("id", galleryContent.getId());
                context.startActivity(intent);


            /*

                  WindowManager windowmanager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
                DisplayMetrics dimension = new DisplayMetrics();
                windowmanager.getDefaultDisplay().getMetrics(dimension);
                final int height = dimension.heightPixels;

                ValueAnimator anim = ValueAnimator.ofInt(holder.imageView.getMeasuredHeightAndState(),height);
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int val = (Integer) valueAnimator.getAnimatedValue();
                        ViewGroup.LayoutParams layoutParams = holder.imageView.getLayoutParams();
                        layoutParams.height = val;
                        holder.imageView.setLayoutParams(layoutParams);
                    }
                });
                anim.start();









             */
            }
        });


        if(position >lastPosition) {

            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.up_from_bottom);
            holder.itemView.startAnimation(animation);
            lastPosition = position;

        }
    }

    @Override
    public int getItemCount() {
        return galleryContents.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        //Views
        public NetworkImageView imageView;
        public TextView textViewId;
        ArrayList<GalleryContent> galleryContents =new ArrayList<>();

        Context context;
        //Initializing Views


        public ViewHolder(View itemView,Context context,ArrayList<GalleryContent> galleryContents) {
            super(itemView);
            this.galleryContents = galleryContents;
            this.context=context;
           // itemView.setOnClickListener(this);
            imageView = (NetworkImageView) itemView.findViewById(R.id.imageViewHero);
            textViewId = (TextView) itemView.findViewById(R.id.textViewId);


        }


/*        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "OnClick :" , Toast.LENGTH_SHORT).show();


            int position=getAdapterPosition();
            GalleryContent galleryContent=this.galleryContents.get(position);
            Intent intent=new Intent(context,FullScreenImage.class);
            intent.putExtra("imageUrl",galleryContent.getImageUrl());
            intent.putExtra("id",galleryContent.getId());

            this.context.startActivity(intent);
        }*/


    }

}