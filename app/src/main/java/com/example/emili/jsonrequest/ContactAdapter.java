package com.example.emili.jsonrequest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by emili on 30/06/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<Contact> contacts;
    Context context;
    LayoutInflater inflater;
    int taille;

    public ContactAdapter(Context context , List<Contact> contacts){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.contacts = contacts;



    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.contacts, parent, false);
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyHolder viewHolder = (MyHolder) holder;
        Contact c = contacts.get(position);
        viewHolder.name.setText(c.getName());


    }

    @Override
    public int getItemCount() {
        taille = contacts.size();
        return taille;
    }



    class MyHolder extends RecyclerView.ViewHolder{
        TextView name;

        public MyHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);

        }


    }

}
