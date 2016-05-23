package com.sadho.denisson.fiscalizarmanaus.holder;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.sadho.denisson.fiscalizarmanaus.R;
import com.sadho.denisson.fiscalizarmanaus.activities.IViewNovaOcorrencia;

/**
 * Created by Herber on 21/05/2016.
 */
public class HolderNovaOcorrencia {

    private EditText etEnderecoReferencia;
    private EditText etSituacao;
    private Spinner spOpcao;
    private ImageButton ibFoto;
    private Button btnProximo;
    private Button btnVoltar;
    private Button btnSalvar;
    private RelativeLayout rlInfoBasica;
    private RelativeLayout rlDadosGps;
    private TextView tvLblOpcao;
    private TextView tvEndereco;
    private TextView tvDescricao;

    private IViewNovaOcorrencia mView;

    public HolderNovaOcorrencia(final IViewNovaOcorrencia view) {
        mView = view;
        initialize();
    }

    private void initialize() {
        etEnderecoReferencia = (EditText) mView.findViewById(R.id.et_endereco_referencia);
        etSituacao = (EditText) mView.findViewById(R.id.et_situacao);
        spOpcao = (Spinner) mView.findViewById(R.id.sp_opcao);
        ibFoto = (ImageButton) mView.findViewById(R.id.ib_foto);
        btnProximo = (Button) mView.findViewById(R.id.btn_next);
        btnVoltar = (Button) mView.findViewById(R.id.btn_back);
        btnSalvar = (Button) mView.findViewById(R.id.btn_save);
        tvLblOpcao = (TextView) mView.findViewById(R.id.tv_lbl_opcao);
        tvEndereco = (TextView) mView.findViewById(R.id.tv_endereco_referencia);
        tvDescricao = (TextView) mView.findViewById(R.id.tv_descricao);

        rlInfoBasica = (RelativeLayout) mView.findViewById(R.id.rl_basics_info);
        rlDadosGps = (RelativeLayout) mView.findViewById(R.id.rl_gps_info);

        rlInfoBasica.setVisibility(View.VISIBLE);
        rlDadosGps.setVisibility(View.GONE);
    }

    public EditText getEtEnderecoReferencia() {
        return etEnderecoReferencia;
    }

    public EditText getEtSituacao() {
        return etSituacao;
    }

    public Spinner getSpOpcao() {
        return spOpcao;
    }

    public ImageButton getIbFoto() {
        return ibFoto;
    }

    public Button getBtnProximo() {
        return btnProximo;
    }

    public Button getBtnVoltar() {
        return btnVoltar;
    }

    public RelativeLayout getRlInfoBasica() {
        return rlInfoBasica;
    }

    public RelativeLayout getRlDadosGps() {
        return rlDadosGps;
    }

    public Button getBtnSalvar() {
        return btnSalvar;
    }

    public TextView getTvLblOpcao() {
        return tvLblOpcao;
    }

    public TextView getTvEndereco() {
        return tvEndereco;
    }

    public TextView getTvDescricao() {
        return tvDescricao;
    }
}
