package com.example.damene.project_android.common;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Joueur implements Parcelable {

    private String pseudo;
    private Boolean online;
    private ArrayList<Ami> amis;

    public Joueur(String pseudo, Boolean online){
        this.pseudo = pseudo;
        this.online = online;
        this.amis = new ArrayList<>();
    }

    public String getPseudo() {
        return pseudo;
    }


    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public ArrayList<Ami> getAmis() {
        return amis;
    }

    public void setAmis(ArrayList<Ami> amis) {
        this.amis = amis;
    }

    public void ajoutAmis(Ami j){
        this.amis.add(j);
    }

    public Ami getAmi(int position){
        return this.amis.get(position);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {

    }
}
