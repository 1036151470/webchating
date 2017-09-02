package com.helloblog;

import java.io.Serializable;

public class Pojo implements Serializable{
    private String adress;
    private String context;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "adress='" + adress + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
