package com.sadho.denisson.fiscalizarmanaus.activities;

import android.content.Context;
import android.view.View;

import com.sadho.denisson.fiscalizarmanaus.util.TipoOcorrencia;

/**
 * Created by Herber on 21/05/2016.
 */
public interface IViewMainAct extends IViewActivity {

    void iniciarAdicionarOcorrencia(final TipoOcorrencia tipoOcorrencia);

}
