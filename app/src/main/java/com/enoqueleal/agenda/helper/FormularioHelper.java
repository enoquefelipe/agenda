package com.enoqueleal.agenda.helper;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;

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
    private EditText campoSite;
    private ImageView campoFoto;

    /**
     *
     * @param activity
     */
    public FormularioHelper(FormularioActivity activity){
        campoNome =         (EditText) activity.findViewById(R.id.formulario_nome);
        campoSobrenome =    (EditText) activity.findViewById(R.id.formulario_sobrenome);
        campoSite =         (EditText) activity.findViewById(R.id.formulario_site);
        campoFoto =         (ImageView) activity.findViewById(R.id.formulario_foto);
        aluno = new Aluno();
    }

    /**
     * Método responsável por settar os valores dos campos no objeto correspondente
     * @return
     */
    public Aluno pegaAluno() {
        aluno.setNome(campoNome.getText().toString());
        aluno.setSobrenome(campoSobrenome.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setCaminhoFoto((String)campoFoto.getTag());
        return aluno;
    }

    /**
     * Método responsável por settar os valores do objeto nos campos correspondentes
     * @param aluno
     */
    public void preencheFormulario(Aluno aluno)  {
        campoNome.setText(aluno.getNome());
        campoSobrenome.setText(aluno.getSobrenome());
        campoSite.setText(aluno.getSite());
        carregaImagem(aluno.getCaminhoFoto());
        this.aluno = aluno;
    }

    public void carregaImagem(String caminhoFoto) {
        if (caminhoFoto != null){
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
            campoFoto.setImageBitmap(bitmapReduzido);
            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
            campoFoto.setTag(caminhoFoto);
        }
    }
}
