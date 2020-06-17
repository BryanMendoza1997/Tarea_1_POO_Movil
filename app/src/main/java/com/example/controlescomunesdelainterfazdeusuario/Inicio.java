package com.example.controlescomunesdelainterfazdeusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    private TextView nombre,fecha,genero,telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        nombre=(TextView)findViewById(R.id.tv_nombre);
        fecha=(TextView)findViewById(R.id.tv_fecha);
        genero=(TextView)findViewById(R.id.tv_genero);
        telefono=(TextView)findViewById(R.id.tv_telefono);
        String nom=getIntent().getStringExtra("Nombre");
        String fech=getIntent().getStringExtra("Fecha");
        String gene=getIntent().getStringExtra("Genero");
        String tele=getIntent().getStringExtra("Telefono");
        nombre.setText("Nombre: "+nom);
        fecha.setText("Fecha de Nacimiento: "+fech);
        genero.setText("Género: "+gene);
        telefono.setText("Teléfono: "+tele);
    }
    public void regresar(View view){
        Intent envio = new Intent(this, MainActivity.class);
        startActivity(envio);
    }
}