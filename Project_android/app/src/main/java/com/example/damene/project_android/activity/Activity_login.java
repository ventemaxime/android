package com.example.damene.project_android.activity;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.damene.project_android.R;
import com.example.damene.project_android.common.Joueur;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class Activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button auth = findViewById(R.id.button);
        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText login = findViewById(R.id.editText2);
                EditText mdp = findViewById(R.id.editText3);
                String log = login.getText().toString();
                String mp = mdp.getText().toString();
                if(log.equals("momo") && mp.equals("momo")) {
                    Intent intent = new Intent(getApplicationContext(), FriendsActivity.class);
                    intent.putExtra("login", log);
                    intent.putExtra("mdp", mp);
                    startActivity(intent);
                } else {
                    Toast.makeText(Activity_login.this, "Identifiant ou Mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
