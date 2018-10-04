package org.dev4u.hv.guia3_ejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MensajeActivity extends AppCompatActivity {
    //declaracion de variables
    private EditText txtEntrada;
    private Button btnEnviar;
    private ArrayList<Mensaje> mensajesArraylist;
    private AdaptadorMensaje adaptadorMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        //inicializando variables
        txtEntrada   = (EditText) findViewById(R.id.txtEntrada);
        btnEnviar  = (Button) findViewById(R.id.btnEnviar);

        mensajesArraylist = new ArrayList<>();

        adaptadorMensaje = new AdaptadorMensaje(this, mensajesArraylist);

        ListView listView = (ListView) findViewById(R.id.lstMensaje);
        //seteando el adaptador al listview
        listView.setAdapter(adaptadorMensaje);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                Mensaje msj = new Mensaje(c.getTime().toString(), txtEntrada.getText().toString());
                mensajesArraylist.add(msj);
                adaptadorMensaje.notifyDataSetChanged();
            }
        });
    }
}
