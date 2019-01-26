package com.example.damene.project_android.activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.damene.project_android.common.Question;
import com.example.damene.project_android.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by damene1 on 14/12/2018.
 */

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Bundle bundle = getIntent().getExtras();

        //Récupération de la question
        Question q = null;
        try {
            q = getQuestions().get(bundle.getInt("position"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TextView question = findViewById(R.id.textView12);
        question.setText(q.getQuestion());

        //Récupération de toutes les réponses
        ArrayList<String> liste = q.getMauvaisesReponses();
        liste.add(q.getReponse());
        Collections.shuffle(liste);

        //Récupération des boutons
        final Button repA = findViewById(R.id.button2);
        final Button repB = findViewById(R.id.button3);
        final Button repC = findViewById(R.id.button4);
        final Button repD = findViewById(R.id.button5);
        //Mise en place des réponses
        repA.setText(liste.get(0));
        repB.setText(liste.get(1));
        repC.setText(liste.get(2));
        repD.setText(liste.get(3));

        //Préparation d'une liste de bouton pour éviter la redondance
        final ArrayList<Button> reponses = new ArrayList<>();
        reponses.add(repA);
        reponses.add(repB);
        reponses.add(repC);
        reponses.add(repD);

        //Mise en place de l'horloge
        final Integer[] seconde = new Integer[1];
        final Question finalQ = q;
        final CountDownTimer timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                ProgressBar time = findViewById(R.id.progressBar2);
                TextView horloge = findViewById(R.id.textView2);
                seconde[0] = ((int) l/1000);
                time.setProgress(seconde[0] *100/30);
                horloge.setText(seconde[0].toString());
            }

            @Override
            public void onFinish() {
                TextView text = findViewById(R.id.textView9);
                for(Button a: reponses){
                    if(a.getText().equals(finalQ.getReponse())){
                        a.setBackgroundColor(Color.GREEN);
                    }
                }
            }
        };

        //Mise en place du listener pour chaque bouton
        for(final Button rep : reponses) {
            rep.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(rep.getText().equals(finalQ.getReponse())){
                        timer.cancel();
                        rep.setBackgroundColor(Color.GREEN);
                        TextView score = findViewById(R.id.textView10);
                        String sc = (String) score.getText();
                        Integer i = ((Integer.parseInt(sc)+1* seconde[0])/2)+1;
                        score.setText(i.toString());
                    } else {
                        rep.setBackgroundColor(Color.RED);
                        for(Button a: reponses){
                            if(a.getText().equals(finalQ.getReponse())){
                                a.setBackgroundColor(Color.GREEN);
                                timer.cancel();
                            }
                        }
                    }
                }
            });
        }
        timer.start();
    }

    public ArrayList<Question> getQuestions() throws JSONException {

        ArrayList<Question> questions = new ArrayList<Question>();

            // On récupère le JSON complet
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset(this.getApplicationContext()));
            // On récupère le tableau d'objets qui nous concernent
            JSONArray array = new JSONArray(jsonObject.getString("results"));
            // Pour tous les objets on récupère les infos
            for (int i = 0; i < array.length(); i++) {
                // On récupère un objet JSON du tableau
                JSONObject obj = new JSONObject(array.getString(i));
                ArrayList<String> mauvaises = new ArrayList<>();
                mauvaises.add(obj.getString("rep1"));
                mauvaises.add(obj.getString("rep2"));
                mauvaises.add(obj.getString("rep3"));
                Question q = new Question(obj.getString("question"), obj.getString("correct_answer"), mauvaises);
                // On fait le lien Personne - Objet JSON
                // On ajoute la personne à la liste
                questions.add(q);
            }

        // On retourne la liste des personnes
        return questions;
    }

    private static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("quiz.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}