package com.example.trabajoprimermomento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {

    ArrayList<Pueblo> listAcciones = new ArrayList<>();
    RecyclerView listado;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listado = findViewById(R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        crearLista();
    }

    public void cambiarIdioma(String lenguaje)
    {
        Locale idioma = new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration configurationTelefono = getResources().getConfiguration();
        configurationTelefono.locale = idioma;
        getBaseContext().getResources().updateConfiguration(configurationTelefono, getBaseContext().getResources().getDisplayMetrics());
    }


    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);

        return (true);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        switch (id)
        {
            case (R.id.opcion1):

                Intent intent = new Intent(Home.this, Acercade.class);
                startActivity(intent);

            break;
            case (R.id.opcion2):

                cambiarIdioma("en");
                Intent intent2 = new Intent(Home.this, Home.class);
                startActivity(intent2);

            break;
            case (R.id.opcion3):
                cambiarIdioma("es");
                Intent intent3 = new Intent(Home.this, Home.class);
                startActivity(intent3);
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void crearLista( )
    {
        db.collection("tarjetas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String nombre, desc, foto;
                                nombre = document.get("nombre").toString();
                                desc = document.get("desc").toString();
                                foto = document.get("foto").toString();

                                listAcciones.add(new Pueblo(nombre, desc, foto));
                                ListaAdaptador listaAdaptador = new ListaAdaptador(listAcciones);
                                listado.setAdapter(listaAdaptador);
                            }
                        }
                        else
                            {
                                Toast.makeText(Home.this, "Error al intentar consultar los datos.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}