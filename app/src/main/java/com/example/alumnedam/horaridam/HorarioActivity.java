package com.example.alumnedam.horaridam;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Calendar;

/**
 * Created by ALUMNEDAM on 20/12/2016.
 */

public class HorarioActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_main);
        
        SharedPreferences prefs = getSharedPreferences("HorariDAM", Context.MODE_PRIVATE);
        
        String fons = prefs.getString("fons", "Blanc");
        String grup = prefs.getString("grup", "A1");




        canviarFons(fons);
        ferSelect(grup);
    }


    /**
     * Cambiem el color del fons segons el spinner del layout
     * @param colorFons
     */
    public void canviarFons(String colorFons) {
        LinearLayout result = (LinearLayout)findViewById(R.id.result_activity);
        switch (colorFons) {
            case "Blanc":
                result.setBackgroundColor(Color.WHITE);
                break;
            case "Gris":
                result.setBackgroundColor(Color.GRAY);
                break;
            case "Groc":
                result.setBackgroundColor(Color.YELLOW);
                break;

        }
    }


    /**
     * Recollim tots els valors que necesitem per fer les SELECTS i les executem recollint el que
     * necessitem.
     * @param grup
     */
    public void ferSelect(String grup) {
        int hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minut = Calendar.getInstance().get(Calendar.MINUTE);
        int segon = Calendar.getInstance().get(Calendar.SECOND);

        int dia = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        int diaSetmana = dia - 1;
        
        HorarioBD sql = new HorarioBD(this, "HorarioBD", null, 1);
        
        db = sql.getWritableDatabase();
        
        if (db != null) {
            Cursor c = db.rawQuery("SELECT cod_asignatura, hora_inicio, hora_fin FROM Horario WHERE ('" + hora + ":" + minut + ":" + segon + "' BETWEEN hora_inicio AND hora_fin) AND grupo = '" + grup + "' AND dia = '" + diaSetmana + "'", null);
            if (c.moveToFirst()) {
                do {
                    String codAsignatura = c.getString(0);
                    String hora_inici = c.getString(1);
                    String hora_fi = c.getString(2);
                    String nomAsignatura = asignatura(codAsignatura);
                    String codProfesor = codProfessor(codAsignatura);
                    String nomProfesor = nomProfessor(codProfesor);

                    if (codAsignatura == ""){

                        TextView tvCodAsign = (TextView) findViewById(R.id.tvCodAsignatura);
                        tvCodAsign.setText("No tens classe!!");

                    }else {
                        TextView tvNomAsign = (TextView) findViewById(R.id.tvNomAsignatura);
                        tvNomAsign.setText(nomAsignatura);

                        TextView tvCodAsign = (TextView) findViewById(R.id.tvCodAsignatura);
                        tvCodAsign.setText(codAsignatura);

                        TextView tvNomProf = (TextView) findViewById(R.id.tvNomProfesor);
                        tvNomProf.setText(nomProfesor);

                        TextView tvHoraInici = (TextView) findViewById(R.id.tvHoraInici);
                        tvHoraInici.setText(hora_inici);

                        TextView tvHoraFi = (TextView) findViewById(R.id.tvHoraFi);
                        tvHoraFi.setText(hora_fi);
                    }
                } while (c.moveToNext());
            }
        }
    }

    /**
     * En aquest metode es fa la select del nom de l'asignatura
     * @param codAsignatura
     * @return nom de l'assignatura
     */
    public String asignatura(String codAsignatura) {
        String nom = "";
        Cursor c = db.rawQuery("SELECT nombre FROM Asignatura WHERE '" + codAsignatura + "' LIKE cod_asignatura", null);
        if (c.moveToFirst()) {
            do {
                nom = c.getString(0);
            } while (c.moveToNext());
        }
        return nom;
    }


    /**
     * En aquest metode es fa la select del codi del profesor
     * @param cod_asignatura
     * @return codi del profesor
     */
    public String codProfessor(String cod_asignatura) {
        String cod = "";
        Cursor c = db.rawQuery("SELECT cod_profesor FROM Asignatura WHERE '" + cod_asignatura + "' LIKE cod_asignatura", null);
        if (c.moveToFirst()) {
            do {
                cod = c.getString(0);
            } while (c.moveToNext());
        }
        return cod;
    }

    /**
     * En aquest metode es fa la select del nom del profesor
     * @param codProfessor
     * @return nom del profesor
     */
    public String nomProfessor(String codProfessor) {
        String nom = "";
        Cursor c = db.rawQuery("SELECT nombre FROM Profesor WHERE '" + codProfessor + "' LIKE cod_profesor", null);
        if (c.moveToFirst()) {
            do {
                nom = c.getString(0);
            } while (c.moveToNext());
        }
        return nom;
    }
}

