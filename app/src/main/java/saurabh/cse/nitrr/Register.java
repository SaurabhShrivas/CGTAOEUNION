package saurabh.cse.nitrr;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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


public class Register extends AppCompatActivity {

    private EditText name,phone,dist,post;
    private Button register;
    private RequestQueue requestQueue;
    private static final String URL = "http://saurabhshrivas6.esy.es/user_control.php";
    private StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar1= (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        toolbar1.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




        name = (EditText) findViewById(R.id.etname);
        phone = (EditText) findViewById(R.id.etph);

        dist = (EditText) findViewById(R.id.etdist);

        post = (EditText) findViewById(R.id.etpost);
        register = (Button) findViewById(R.id.btRegister);


        requestQueue = Volley.newRequestQueue(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog loading;
                loading = ProgressDialog.show(Register.this, "Please Wait...",null,true,true);


                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject.names().get(0).equals("success"))
                            {
                                loading.dismiss();
                                Toast.makeText(getApplicationContext(),"SUCCESS "+jsonObject.getString("success"),Toast.LENGTH_SHORT).show();

                                Toast.makeText(getApplicationContext(),"SUCCESSFULLY REGISTERED ",Toast.LENGTH_SHORT).show();

                            }else {
                                loading.dismiss();
                                Toast.makeText(getApplicationContext(), "Error" +jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
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
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> hashMap = new HashMap<String, String>();
                        hashMap.put("name",name.getText().toString());
                        hashMap.put("phone",phone.getText().toString());
                        hashMap.put("district",dist.getText().toString());
                        hashMap.put("post",post.getText().toString());

                        return hashMap;
                    }
                };

                requestQueue.add(request);
            }
        });
    }
}












