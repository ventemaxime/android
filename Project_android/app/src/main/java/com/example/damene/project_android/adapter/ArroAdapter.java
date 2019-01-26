package com.example.damene.project_android.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.damene.project_android.common.Arrondissement;
import com.example.damene.project_android.R;


public class ArroAdapter extends BaseAdapter {

    private final Context mContext;
    private final Arrondissement[] arro;

    public ArroAdapter(Context context, Arrondissement[] arro) {
        this.mContext = context;
        this.arro = arro;
    }




    @Override
    public int getCount() {
        return arro.length;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }


   // @Override
   // public View getView(int position, View convertView, ViewGroup parent) {
     //   TextView dummyTextView = new TextView(mContext);
       // dummyTextView.setText(String.valueOf(position));
       /// return dummyTextView;
    //}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1
        final Arrondissement ar = arro [position];

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_arro, null);
        }

        // 3
        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_book_name);

        // 4
        imageView.setImageResource(ar.getImageResource());
        nameTextView.setText(mContext.getString(ar.getName()));

        return convertView;
    }
}
