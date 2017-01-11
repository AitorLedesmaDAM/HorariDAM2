package com.example.alumnedam.horaridam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ALUMNEDAM on 30/11/2016.
 */

public class HorarioBD extends SQLiteOpenHelper {

    String sqlCreateHorario = "CREATE TABLE Horario (id_horario INTEGER, grupo TEXT, cod_asignatura TEXT, hora_inicio TEXT, hora_fin TEXT, dia INTEGER)";
    String sqlCreateAsignatura = "CREATE TABLE Asignatura ( cod_asignatura TEXT, nombre TEXT, cod_profesor INTEGER)";
    String sqlCreateProfesor = "CREATE TABLE Profesor ( cod_profesor INTEGER , nombre TEXT)";

    public HorarioBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateHorario);
        db.execSQL(sqlCreateAsignatura);
        db.execSQL(sqlCreateProfesor);


        db.execSQL("INSERT INTO Profesor (cod_profesor, nombre) VALUES (1, 'Jorge Rubio')");
        db.execSQL("INSERT INTO Profesor (cod_profesor, nombre) VALUES (2, 'Josefa González')");
        db.execSQL("INSERT INTO Profesor (cod_profesor, nombre) VALUES (3, 'Jose A. Leo')");
        db.execSQL("INSERT INTO Profesor (cod_profesor, nombre) VALUES (4, 'Lluis Perpiñà')");
        db.execSQL("INSERT INTO Profesor (cod_profesor, nombre) VALUES (5, 'Marta Planas')");

        db.execSQL("INSERT INTO Asignatura (cod_asignatura, nombre, cod_profesor) VALUES ('M05/M02/M06', 'Entorns de desenvolupament/Bases de dades/Accés a dades', 1)");
        db.execSQL("INSERT INTO Asignatura (cod_asignatura, nombre, cod_profesor) VALUES ('M03', 'Programació bàsica', 2)");
        db.execSQL("INSERT INTO Asignatura (cod_asignatura, nombre, cod_profesor) VALUES ('M07', 'Desenvolupament de interficíes', 3)");
        db.execSQL("INSERT INTO Asignatura (cod_asignatura, nombre, cod_profesor) VALUES ('M08', 'Programació multimèdia i dispositius mòbils', 4)");
        db.execSQL("INSERT INTO Asignatura (cod_asignatura, nombre, cod_profesor) VALUES ('M09', 'Programació de serveis i processos', 1)");
        db.execSQL("INSERT INTO Asignatura (cod_asignatura, nombre, cod_profesor) VALUES ('M10', 'Sistemes de gestió empresarial', 5)");
        db.execSQL("INSERT INTO Asignatura (cod_asignatura, nombre, cod_profesor) VALUES ('M11', 'Tutoria', 2)");


        //SUBGRUPO A2
        //LUNES
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M07', '15:00:01', '18:00:00', 1)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M11', '18:20:01', '19:20:00', 1)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M03', '19:20:01', '21:20:00', 1)");

        //MARTES
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M08', '15:00:01', '17:00:00', 2)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M10', '17:00:01', '18:00:00', 2)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M10', '18:20:01', '19:20:00', 2)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M05/M02/M06', '19:20:01', '21:20:00', 2)");

        //MIERCOLES
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M05/M02/M06', '16:00:00', '17:00:00', 3)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M08', '17:00:01', '18:00:00', 3)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M08', '18:20:01', '19:20:00', 3)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M09', '19:20:01', '20:20:00', 3)");

        //JUEVES
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M03', '16:00:01', '18:00:00', 4)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M05/M02/M06', '18:20', '21:20:00', 4)");

        //VIERNES
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M10', '15:00:01', '17:00:00', 5)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M09', '17:00:01', '18:00:00', 5)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M09', '18:20:01', '19:20:00', 5)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (2, 'A2', 'M05/M02/M06', '19:20', '21:20:00', 5)");

        //SUBGRUPO A1
        //Asignatura M03 Programacion
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M03', '15:00:01', '17:00:00', 2)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M03', '19:20:01', '21:20:00', 3)");

        //Asignatura M07 Interficies
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M07', '15:00:01', '18:00:00', 1)");

        //Asignatura M10 ERP's
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M10', '17:00:00', '17:59:59', 2)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M10', '18:20:00', '18:19:59', 2)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M10', '15:00:00', '17:59:59', 5)");

        //Asignatura M11 Tutoria
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M11', '18:20:00', '19:20:59', 1)");

        //Asignatura M05/M02/M06  Entorns desenvolupamen/ Base dades / Acces dades
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M05/M02/M06', '19:20:00', '21:19:59', 2)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M05/M02/M06', '16:00:00', '16:59:59', 3)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M05/M02/M06', '18:20:00', '21:20:00', 4)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M05/M02/M06', '19:20:00', '21:20:00', 5)");

        //Asignatura M09 Porgramacio de serveis i procesos
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M09', '17:00:00', '17:59:59', 3)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M09', '18:20:00', '19:19:59', 3)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M09', '15:00:00', '15:59:59', 4)");

        //Asignatura M08 Android
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M08', '16:00:00', '17:59:59', 4)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M08', '17:00:00', '17:59:59', 5)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) VALUES (1, 'A1', 'M08', '18:20:00', '19:19:59', 5)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int versionNueva) {

       /* //Se elimina la versi�n anterior de la tabla
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Horario");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Asignatura");
       // sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Profesor");
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Alumno");

        //Se crea la nueva versión de la tabla
        sqLiteDatabase.execSQL(sqlCreateHorario);
        sqLiteDatabase.execSQL(sqlCreateAsignatura);
      //  sqLiteDatabase.execSQL(sqlCreateProfesor); */
    }
}
