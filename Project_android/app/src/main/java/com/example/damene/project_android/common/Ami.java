package com.example.damene.project_android.common;

public class Ami {
    private Joueur joueur;
    private int[] scores;

    public Ami(Joueur joueur, int[] scores){
        this.joueur = joueur;
        this.scores = scores;
    }

    public Joueur getJoueur(){
        return this.joueur;
    }

    public int getMyScore(){
        return this.scores[0];
    }

    public int getHisScore(){
        return this.scores[1];
    }
}
