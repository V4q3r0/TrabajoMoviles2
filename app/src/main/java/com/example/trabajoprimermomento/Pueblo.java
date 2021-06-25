package com.example.trabajoprimermomento;

import java.io.Serializable;

public class Pueblo implements Serializable {

    String texto, desc, imagen;

    public Pueblo(String texto, String desc, String imagen) {
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
