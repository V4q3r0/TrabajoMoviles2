package com.example.trabajoprimermomento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Pueblo pueblo;
    ImageView imagen;
    TextView texto, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.imagenVista);
        texto = findViewById(R.id.nombreAccion);
        desc = findViewById(R.id.descripcion);

        pueblo = (Pueblo) getIntent().getSerializableExtra("datosPueblo");

        imagen.setImageResource(pueblo.getImagen());
        texto.setText(pueblo.getTexto());
        desc.setText(pueblo.getDesc());
    }
}