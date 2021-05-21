package com.example.trabajoprimermomento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ArrayList<Pueblo> listAcciones = new ArrayList<>();
    RecyclerView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listado = findViewById(R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        crearLista();
        ListaAdaptador adaptador = new ListaAdaptador(listAcciones);
        listado.setAdapter(adaptador);
    }

    private void crearLista()
    {
        listAcciones.add(new Pueblo("Cascada de Popales", "Cascada de Popales, ubicadas en la vereda Santa Teresa, es un lugar divertido que cuenta con un nacimiento de agua", R.drawable.cascada));
        listAcciones.add(new Pueblo("Cristo Milagroso", "Cristo Milagroso, ubicado en la vereda Corcovado, desde allí tenemos una gran vista directa al pueblo.", R.drawable.cristo));
        listAcciones.add(new Pueblo("Hotel campestre Nazaret", "Hotel campestre Nazaret, se realizan caminatas ecológicas, cabalgatas, platos típicos de la región.", R.drawable.hotel));
        listAcciones.add(new Pueblo("Cerro Morrogacho", "Caminata al cerro Morrogacho, en la cual se avista una gran cantidad de naimales, desde allí se obserca diversidad de paisajes.", R.drawable.morrogacho));
        listAcciones.add(new Pueblo("Caminata Ermita", "Caminata hacia la Ermita, ubicada en la vereda Corcovado conozca nuestra diversidad de flores, plantas, arboles, aves, etc...", R.drawable.ermita));
    }
}