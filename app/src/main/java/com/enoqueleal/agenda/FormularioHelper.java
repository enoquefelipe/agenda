package com.enoqueleal.agenda;


import android.widget.EditText;
import com.enoqueleal.agenda.modelo.Aluno;

/**
 * Created by enoque.santos on 27/10/2016.
 */

public class FormularioHelper {

    private EditText campoNome;
    private EditText campoSobrenome;

    public FormularioHelper(FormularioActivity activity){
        campoNome =      (EditText) activity.findViewById(R.id.formulario_nome);
        campoSobrenome = (EditText) activity.findViewById(R.id.formulario_sobrenome);
    }

    public Aluno pegaAluno() {
        Aluno aluno = new Aluno ();
        aluno.setNome(campoNome.getText().toString());
        aluno.setSobrenome(campoSobrenome.getText().toString());
        return aluno;
    }
}
