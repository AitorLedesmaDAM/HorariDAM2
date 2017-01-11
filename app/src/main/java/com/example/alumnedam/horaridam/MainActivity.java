package com.example.alumnedam.horaridam;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnAceptar) {
            Intent i = new Intent(this, HorarioActivity.class);


            Spinner spGrup = (Spinner) findViewById(R.id.spinnerGrup);
            Spinner spFons = (Spinner) findViewById(R.id.spinnerFons);
            EditText etNom = (EditText) findViewById(R.id.etNom);

            SharedPreferences prefs = getSharedPreferences("HorariDAM", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.putString("grup", spGrup.getSelectedItem().toString());
            editor.putString("fons", spFons.getSelectedItem().toString());
            editor.putString("nom", etNom.getText().toString());

            editor.commit();
            startActivity(i);
        }
    }
}
