package com.enoqueleal.agenda.helper;


import android.widget.EditText;

import com.enoqueleal.agenda.R;
import com.enoqueleal.agenda.activity.FormularioActivity;
import com.enoqueleal.agenda.model.Aluno;

/**
 * Classe responsável por auxiliar a activity FormularioActivity.
 * Created by enoque.santos on 27/10/2016.
 */

public class FormularioHelper {

    private Aluno aluno;
    private EditText campoNome;
    private EditText campoSobrenome;

    /**
     *
     * @param activity
     */
    public FormularioHelper(FormularioActivity activity){
        campoNome =      (EditText) activity.findViewById(R.id.formulario_nome);
        campoSobrenome = (EditText) activity.findViewById(R.id.formulario_sobrenome);
        aluno = new Aluno();
    }

    /**
     * Método responsável por settar os valores dos campos no objeto correspondente
     * @return
     */
    public Aluno pegaAluno() {
        aluno.setNome(campoNome.getText().toString());
        aluno.setSobrenome(campoSobrenome.getText().toString());
        return aluno;
    }

    /**
     * Método responsável por settar os valores do objeto nos campos correspondentes
     * @param aluno
     */
    public void preencheFormulario(Aluno aluno)  {
        campoNome.setText(aluno.getNome());
        campoSobrenome.setText(aluno.getSobrenome());
        this.aluno = aluno;
    }
}
