package com.enoqueleal.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.enoqueleal.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enoque.santos on 27/10/2016.
 */

public class AlunoDao extends SQLiteOpenHelper{

    public AlunoDao(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Alunos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, sobrenome TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Alunos";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Aluno aluno)  {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("sobrenome", aluno.getSobrenome());
        db.insert("Alunos", null, dados );
    }

    public List<Aluno> buscaAlunos()  {
        String sql = "SELECT * FROM Alunos;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Aluno> alunos = new ArrayList<Aluno>();
        while (c.moveToNext()) {
            Aluno aluno = new Aluno();
            aluno.setId(c.getLong(c.getColumnIndex("id")));
            aluno.setNome(c.getString(c.getColumnIndex("nome")));
            aluno.setSobrenome(c.getString(c.getColumnIndex("sobrenome")));
            alunos.add(aluno);
        }
        c.close();
        return alunos;
    }


    public void deleta(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params;
        params = new String[]{String.valueOf((aluno.getId()))};
        db.delete("Alunos", "id = ?", params);
    }

}