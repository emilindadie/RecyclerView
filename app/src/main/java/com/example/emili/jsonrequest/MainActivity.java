package com.example.emili.jsonrequest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Contact contact;
    ContactAdapter contactAdapter;
    String url;
    List<Contact> ma_liste;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        button = (Button) findViewById(R.id.activité2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        url = "http://api.androidhive.info/contacts/";
        makeHttpRequest(url);
    }

    private void makeHttpRequest(String url)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        //afficher le resultat d'une requete sous forme de chaine de caractères
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        handleResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        queue.add(stringRequest);
    }

    private void handleResponse(String response) {


        try{
            JSONObject object = new JSONObject(response);
            JSONArray contacts = object.getJSONArray("contacts");

            ma_liste = new ArrayList<Contact>();
            for(int i = 0; i < contacts.length(); i++){


                JSONObject jsonObject = contacts.getJSONObject(i);

                Contact c = new Contact();
                String nom = jsonObject.getString("name");
                c.setName(nom);


                ma_liste.add(c);


            }

            contactAdapter = new ContactAdapter(this, ma_liste);
            recyclerView.setAdapter(contactAdapter);


        }catch (JSONException j){


        }
    }
}
