package com.sadho.denisson.fiscalizarmanaus.controller;

import com.sadho.denisson.fiscalizarmanaus.activities.IViewMainAct;
import com.sadho.denisson.fiscalizarmanaus.util.TipoOcorrencia;

/**
 * Created by Herber on 21/05/2016.
 */
public class ControllerActMain {

    private IViewMainAct mView;

    public ControllerActMain(final IViewMainAct view) {
        mView = view;
    }

    public void adicionaOcorrenciaPontoOnibus() {
        adicionaNovaOcorrencia(TipoOcorrencia.PONTO_ONIBUS);
    }

    private void adicionaNovaOcorrencia(final TipoOcorrencia tipoOcorrencia) {
        // inicia a nova activity de adicao de uma nova ocorrencia
        mView.iniciarAdicionarOcorrencia(tipoOcorrencia);
    }

}
