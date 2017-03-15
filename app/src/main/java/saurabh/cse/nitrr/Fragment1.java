package saurabh.cse.nitrr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;




public class Fragment1 extends Fragment {

    public Fragment1() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_fragment1, container, false);

        Button b1 = (Button) v.findViewById(R.id.b1);
        CardView b3 = (CardView) v.findViewById(R.id.cardAbout);
        Button b2 = (Button) v.findViewById(R.id.b2);
        Button b5 = (Button) v.findViewById(R.id.b5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Intent ourintent = new Intent(getActivity(), Class.forName("saurabh.cse.nitrr.Prantadhyakshya"));
                    startActivity(ourintent);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Intent ourintent = new Intent(getActivity(), Class.forName("saurabh.cse.nitrr.Leadership.Leadership"));
                    startActivity(ourintent);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Intent ourintent = new Intent(getActivity(), Class.forName("saurabh.cse.nitrr.About"));
                    startActivity(ourintent);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Intent ourintent = new Intent(getActivity(), Class.forName("saurabh.cse.nitrr.Links"));
                    startActivity(ourintent);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });


        return v;
    }


}
