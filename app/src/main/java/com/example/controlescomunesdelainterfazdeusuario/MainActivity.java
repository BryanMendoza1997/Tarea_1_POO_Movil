package com.example.controlescomunesdelainterfazdeusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.DatePicker;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private EditText nombre,fecha,telefono;
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    private RadioButton masculino,femenino;
    static final int DATE_ID = 1;
    //Creamos el objeto tipo calendario
    Calendar C = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=(EditText)findViewById(R.id.txt_nombre);
        fecha=(EditText)findViewById(R.id.txt_fechana);
        telefono=(EditText)findViewById(R.id.txt_telefono);
        masculino=(RadioButton)findViewById(R.id.rb_masculino);
        femenino=(RadioButton)findViewById(R.id.rb_femenino);
    }
    //Mostramos la ventana de dialogo al momento de darle click al EditText
    public void LlamarFecha (View view){
        showDialog(DATE_ID);
    }
    public void enviar(View view){

        if(nombre.getText().toString().trim().length() > 2 && fecha.getText().toString().trim().length() > 5 &&(masculino.isChecked() == true || femenino.isChecked() == true)) {
            String genero = "";
            if (masculino.isChecked() == true) {
                genero = "Masculino";
            } else if (femenino.isChecked() == true) {
                genero = "Femenino";
            }
            Intent envio = new Intent(this, Inicio.class);
            envio.putExtra("Nombre", nombre.getText().toString());
            envio.putExtra("Fecha", fecha.getText().toString());
            envio.putExtra("Genero", genero);
            envio.putExtra("Telefono", telefono.getText().toString());
            startActivity(envio);
        } else{
              Toast.makeText(this,"Complete todos los campos correctamente para poder continuar...",Toast.LENGTH_SHORT).show();
        }
    }
//Coloca la fecha en el EditText
    private void colocar_fecha() {
        fecha.setText( mDayIni + "-" + (mMonthIni + 1) + "-" + mYearIni+" ");
    }


//Captura los datos al momento de darle en ok
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    colocar_fecha();

                }

            };


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);
        }
        return null;
    }
}