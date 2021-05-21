package com.example.trabajoprimermomento;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdaptador extends RecyclerView.Adapter<ListaAdaptador.viewHolder> {

    ArrayList<Pueblo> listaDatos;

    public ListaAdaptador(ArrayList<Pueblo> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public ListaAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaListaItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new viewHolder(vistaListaItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdaptador.viewHolder holder, int position) {
        holder.actualizarDatos(listaDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombreAccion;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenLista);
            nombreAccion = itemView.findViewById(R.id.nameAction);
        }

        public void actualizarDatos(final Pueblo pueblo)
        {
            imagen.setImageResource(pueblo.getImagen());
            nombreAccion.setText(pueblo.getTexto());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MainActivity.class);
                    intent.putExtra("datosPueblo", pueblo);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

}
