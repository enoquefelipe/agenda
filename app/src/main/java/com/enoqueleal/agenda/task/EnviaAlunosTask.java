package com.enoqueleal.agenda.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.enoqueleal.agenda.client.WebClient;
import com.enoqueleal.agenda.converter.AlunoConverter;
import com.enoqueleal.agenda.dao.AlunoDao;
import com.enoqueleal.agenda.model.Aluno;

import java.util.List;

/**
 * Created by enoque.santos on 11/12/2016.
 */

public class EnviaAlunosTask extends AsyncTask<Void, Void, String> {
    private Context context;
    private ProgressDialog dialog;

    /**
     *
     * @param context
     */
    public EnviaAlunosTask(Context context) {
        this.context = context;
    }

    /**
     *
     * @param params
     * @return
     */
    @Override
    protected String doInBackground(Void... params) {
        AlunoDao dao = new AlunoDao(context);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        AlunoConverter conversor = new AlunoConverter();
        String json = conversor.converteParaJSON(alunos);

        WebClient client = new WebClient();
        String resposta = client.post(json);

        return resposta;
    }

    /**
     *
     */
    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde", "Enviando alunos...");
    }

    /**
     *
     * @param resposta
     */
    @Override
    protected void onPostExecute(String resposta) {
        dialog.dismiss();
        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
    }
}
