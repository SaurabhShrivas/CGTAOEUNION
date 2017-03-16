package saurabh.cse.nitrr.Leadership;
        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.TextView;

        import com.android.volley.toolbox.ImageLoader;
        import com.android.volley.toolbox.NetworkImageView;

        import java.util.ArrayList;

        import saurabh.cse.nitrr.Gallery.FullScreenImage;
        import saurabh.cse.nitrr.R;

public class LcardAdapter extends RecyclerView.Adapter<LcardAdapter.ViewHolder> {


    //Imageloader to load image
    private ImageLoader imageLoader;
    private Context context;

    int lastPosition = -1;

    //List to store all leaders
    ArrayList<LContent> ourleaders;

    //Constructor of this class
    public LcardAdapter(ArrayList<LContent> ourleaders, Context context){
        super();
        //Getting all leaders
        this.ourleaders = ourleaders;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leadership_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //Getting the particular item from the list
        final LContent lContent =  ourleaders.get(position);

        //Loading image from url
        imageLoader = LCustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(lContent.getImageUrl(), ImageLoader.getImageListener(holder.imageView, R.drawable.image, android.R.drawable.ic_dialog_alert));

        //Showing data on the views
        holder.imageView.setImageUrl(lContent.getImageUrl(), imageLoader);
        holder.textViewId.setText(lContent.getId());
        holder.textViewName.setText(lContent.getName());
        holder.textViewPost.setText(lContent.getPost());


        holder.imageView.setOnClickListener(new  View.OnClickListener()
        {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(context,FullScreenImage.class);
                intent.putExtra("imageUrl", lContent.getImageUrl());
                intent.putExtra("id", lContent.getId());
                context.startActivity(intent);



            }
        });







//////////////////this is for animation/////////////////////

        if(position >lastPosition) {

            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.up_from_bottom);
            holder.itemView.startAnimation(animation);
            lastPosition = position;

        }

 //////////////////////////////////////////////////////////////

    }

    @Override
    public int getItemCount() {
        return ourleaders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        //Views
        public NetworkImageView imageView;
        public TextView textViewId;
        public TextView textViewName;
        public TextView textViewPost;

        //Initializing Views
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (NetworkImageView) itemView.findViewById(R.id.imageViewLeaders);
            textViewId = (TextView) itemView.findViewById(R.id.textViewId);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewPost = (TextView) itemView.findViewById(R.id.textViewPost);

        }
    }


}
