package com.enoqueleal.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.enoqueleal.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por auxiliar a activity FormularioActivity.
 * Created by enoque.santos on 27/10/2016.
 */

public class AlunoDao extends SQLiteOpenHelper{

    public AlunoDao(Context context) {
        super(context, "Agenda", null, 1);
    }

    /**
     * Método é executado quando a app é inicializada e é responsável por criar a tabeka alunos
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Alunos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, sobrenome TEXT);";
        db.execSQL(sql);
    }

    /**
     * Método será executado se a app estiver em uma nova versão e é responsável por excluir a tabela existente
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Alunos";
        db.execSQL(sql);
        onCreate(db);
    }

    /**
     * Método responsável por conectar ao SQLite e realizar a persistencia
     * @param aluno
     */
    public void insere(Aluno aluno)  {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosDoAluno(aluno);
        db.insert("Alunos", null, dados );
    }

    /**
     * Método responsável por conectar ao SQLite e realizar uma busca dos registros armazenados
     * @return
     */
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

    /**
     * Método responsável por conectar ao SQLite e realizar delete de dados
     * @param aluno
     */
    public void deleta(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {aluno.getId().toString()};
        db.delete("Alunos", "id = ?", params);
    }

    /**
     * Método responsável por conectar ao SQLite e realizar update nos de dados
     * @param aluno
     */
    public void altera(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosDoAluno(aluno);
        String[] params = {aluno.getId().toString()};
        db.update("Alunos", dados, "id = ?", params);
    }

    /**
     * Método responsável por settar dados do aluno em um ContentValues
     * @param aluno
     * @return
     */
    @NonNull
    private ContentValues pegaDadosDoAluno(Aluno aluno) {
        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("sobrenome", aluno.getSobrenome());
        return dados;
    }
}
