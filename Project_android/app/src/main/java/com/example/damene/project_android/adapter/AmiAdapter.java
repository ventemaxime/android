package com.example.damene.project_android.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.damene.project_android.R;
import com.example.damene.project_android.common.Ami;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class AmiAdapter extends ArrayAdapter<Ami> {

    public AmiAdapter(Context context, ArrayList<Ami> amis) {
        super(context, R.layout.adapter_ami, amis);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        final ViewGroup vg = parent;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.adapter_ami, null);
        }

        final Ami a = getItem(position);


        TextView pseudo = (TextView) row.findViewById(R.id.textView3);
        pseudo.setText(a.getJoueur().getPseudo());


        ImageView online = (ImageView) row.findViewById(R.id.imageView5);
        if(a.getJoueur().getOnline()){
            online.setImageResource(android.R.drawable.presence_online);
        } else {
            online.setImageResource(android.R.drawable.presence_offline);
        }

        TextView score = row.findViewById(R.id.textView5);
        score.setText(a.getMyScore() + " - " + a.getHisScore());

        return (row);
    }
}
