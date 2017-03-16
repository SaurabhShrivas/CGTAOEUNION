package saurabh.cse.nitrr;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;




public class Fragment2 extends Fragment {

    private EditText name, phone, dist, post;
    private Button register;
    private RequestQueue requestQueue;
    private static final String URL = "http://saurabhshrivas6.esy.es/user_control.php"; //http://saurabhshrivas6.esy.es/show.php
    private StringRequest request;

    public Fragment2() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_fragment2, container, false);


        name = (EditText) v.findViewById(R.id.etname);
        phone = (EditText) v.findViewById(R.id.etph);

        dist = (EditText) v.findViewById(R.id.etdist);

        post = (EditText) v.findViewById(R.id.etpost);
        register = (Button) v.findViewById(R.id.btRegister);


        requestQueue = Volley.newRequestQueue(getActivity());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog loading;
                loading = ProgressDialog.show(getActivity(), "Please Wait...", null, true, true);


                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.names().get(0).equals("success")) {
                                loading.dismiss();
                                Toast.makeText(getContext(), "SUCCESS " + jsonObject.getString("success"), Toast.LENGTH_SHORT).show();

                                Toast.makeText(getContext(), "SUCCESSFULLY REGISTERED ", Toast.LENGTH_SHORT).show();

                            } else {
                                loading.dismiss();
                                Toast.makeText(getContext(), "Error" + jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                                phone.setText("");

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> hashMap = new HashMap<String, String>();
                        hashMap.put("name", name.getText().toString());
                        hashMap.put("phone", phone.getText().toString());
                        hashMap.put("district", dist.getText().toString());
                        hashMap.put("post", post.getText().toString());

                        return hashMap;
                    }
                };

                requestQueue.add(request);
            }
        });



        return v;
    }


}


