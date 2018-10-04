package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorMensaje extends ArrayAdapter <Mensaje>{

    public AdaptadorMensaje(Context context, ArrayList<Mensaje> objets) {

        super(context,0, objets);

    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obteniendo el dato
        Mensaje mensaje = getItem(position);
        //TODO inicializando el layout correspondiente al item (Mensaje)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje, parent, false);
        }
        TextView lblFecha = (TextView) convertView.findViewById(R.id.lblFecha);
        TextView lblMensaje = (TextView) convertView.findViewById(R.id.lblMensaje);
        // mostrar los datos
        lblMensaje.setText(mensaje.Mensaje);
        lblFecha.setText(mensaje.Fecha);
        // Return la convertView ya con los datos
        return convertView;
    }
}
