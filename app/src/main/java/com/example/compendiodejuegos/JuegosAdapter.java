package com.example.compendiodejuegos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

public class JuegosAdapter extends ArrayAdapter <imagenes> {
    private imagenes[]objects;
    private Context context;
    private int resource;

    public JuegosAdapter(Context context, int resource, imagenes[] objects){
        super(context, resource, objects);
        this.objects=objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView = ((Activity)context).getLayoutInflater().inflate(resource,parent,false);
        }
        ImageView imgRes;
        imgRes=convertView.findViewById(R.id.imgRes);
        imgRes.setImageResource(objects [position].getImagen());
        Picasso.get().load(objects[position].getImagen()).resize(255,255).into(imgRes);
        /*convertView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, CapturarNuevo.class);

                context.startActivity(intent);
            }
        });*/

        return convertView;
    }
}
