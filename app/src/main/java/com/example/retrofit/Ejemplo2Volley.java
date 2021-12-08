package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Ejemplo2Volley extends AppCompatActivity {
    TextView textView;
    //Todas las solicitudes q se añadan se agregan a esta clase
    RequestQueue requestQueue;
    private static final String URL="https://gorest.co.in/public/v1/users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo2_volley);

        requestQueue= Volley.newRequestQueue(this);
        initUI();
        //llamamos al otro método
        strinRequest();
    }
    private void initUI(){
        textView=findViewById(R.id.text_view_result2);
    }

    private void strinRequest(){
        StringRequest request=new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //añadimos_todo
                        textView.setText(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(request);
    }

}