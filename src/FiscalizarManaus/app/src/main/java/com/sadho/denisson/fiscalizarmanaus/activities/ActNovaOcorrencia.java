package com.sadho.denisson.fiscalizarmanaus.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;

import com.sadho.denisson.fiscalizarmanaus.R;
import com.sadho.denisson.fiscalizarmanaus.holder.HolderNovaOcorrencia;

import java.util.ArrayList;
import java.util.List;

public class ActNovaOcorrencia extends AppCompatActivity implements IViewNovaOcorrencia {

    private HolderNovaOcorrencia mHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_nova_ocorrencia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialize();
        initializeActions();
    }

    private void initialize() {
        mHolder = new HolderNovaOcorrencia(this);

        final List<String> opcoes = new ArrayList<>();
        opcoes.add("Sem cobertura");
        opcoes.add("Cobertura quebrada");
        opcoes.add("Sem iluminação");

        final  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opcoes);
        final ArrayAdapter<String> spinnerAdapter = arrayAdapter;
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        mHolder.getSpOpcao().setAdapter(spinnerAdapter);
    }

    private void initializeActions() {
        if (mHolder != null) {
            mHolder.getBtnProximo().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO
                    if (!TextUtils.isEmpty(mHolder.getEtEnderecoReferencia().getText())
                            && !TextUtils.isEmpty(mHolder.getEtSituacao().getText())) {
                        mHolder.getSpOpcao().setEnabled(false);
                        mHolder.getIbFoto().setEnabled(false);
                        mHolder.getEtEnderecoReferencia().setEnabled(false);
                        mHolder.getEtSituacao().setEnabled(false);

                        mHolder.getRlDadosGps().setVisibility(View.VISIBLE);
                        mHolder.getRlInfoBasica().setVisibility(View.GONE);

                        mHolder.getBtnVoltar().setVisibility(View.VISIBLE);
                        mHolder.getBtnSalvar().setVisibility(View.VISIBLE);
                        mHolder.getBtnProximo().setVisibility(View.GONE);
                    } else {
                        Snackbar.make(v, "Todos os campos são obrigatórios", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
            });

            mHolder.getBtnVoltar().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mHolder.getSpOpcao().setEnabled(true);
                    mHolder.getIbFoto().setEnabled(true);
                    mHolder.getEtEnderecoReferencia().setEnabled(true);
                    mHolder.getEtSituacao().setEnabled(true);

                    mHolder.getRlDadosGps().setVisibility(View.GONE);
                    mHolder.getRlInfoBasica().setVisibility(View.VISIBLE);

                    mHolder.getBtnVoltar().setVisibility(View.GONE);
                    mHolder.getBtnSalvar().setVisibility(View.GONE);
                    mHolder.getBtnProximo().setVisibility(View.VISIBLE);
                }
            });
        }
    }
}
