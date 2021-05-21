package com.example.trabajoprimermomento;

import java.io.Serializable;

public class Pueblo implements Serializable {

    String texto, desc;
    int imagen;

    public Pueblo(String texto, String desc, int imagen) {
        this.texto = texto;
        this.desc = desc;
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
