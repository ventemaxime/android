package com.example.damene.project_android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.damene.project_android.R;
import com.example.damene.project_android.adapter.AmiAdapter;
import com.example.damene.project_android.common.Ami;
import com.example.damene.project_android.common.Joueur;
import com.example.damene.project_android.common.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        final Joueur j = new Joueur("momo", true);
        Joueur j1 = new Joueur("Max", true);
        Joueur j2 = new Joueur("Michel", false);
        int [] scores = new int[2];
        scores[0] = 0;
        scores[1] = 0;
        Ami a1 = new Ami(j1,scores);
        Ami a2 = new Ami(j2, scores);
        j.ajoutAmis(a1);
        j.ajoutAmis(a2);

        ListView liste = findViewById(R.id.listeami);
        AmiAdapter adapt = new AmiAdapter(getApplicationContext(), j.getAmis());
        liste.setAdapter(adapt);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(FriendsActivity.this, Activity_arro.class);
                intent.putExtra("joueur", (Parcelable) j);
                startActivity(intent);
            }
        });

    }
}
