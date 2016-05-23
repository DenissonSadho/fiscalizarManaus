package com.sadho.denisson.fiscalizarmanaus.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.sadho.denisson.fiscalizarmanaus.R;
import com.sadho.denisson.fiscalizarmanaus.holder.HolderNovaOcorrencia;
import com.sadho.denisson.fiscalizarmanaus.model.Ocorrencia;
import com.sadho.denisson.fiscalizarmanaus.util.MediaStoreUtil;

import java.util.ArrayList;
import java.util.List;

public class ActNovaOcorrencia extends AppCompatActivity implements IViewNovaOcorrencia {

    private static final int REQUEST_CAPTURE_IMG = 100;

    private HolderNovaOcorrencia mHolder;
    private Ocorrencia mOcorrencia;
    private Uri fileUri;

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
        mOcorrencia = new Ocorrencia();

        final List<String> opcoes = new ArrayList<>();
        opcoes.add("Sem cobertura");
        opcoes.add("Cobertura quebrada");
        opcoes.add("Sem iluminação");

        final  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opcoes);
        final ArrayAdapter<String> spinnerAdapter = arrayAdapter;
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        mHolder.getSpOpcao().setAdapter(spinnerAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAPTURE_IMG &&
                data != null && data.getExtras() != null &&
                data.getExtras().get("data") != null) {
            int w = mHolder.getIbFoto().getWidth();
            int h = mHolder.getIbFoto().getHeight();

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            bitmap = Bitmap.createScaledBitmap(bitmap, w, h, true);
            mHolder.getIbFoto().setImageBitmap(bitmap);
        }
    }

    private void initializeActions() {
        if (mHolder != null) {
            mHolder.getSpOpcao().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (mOcorrencia == null) {
                        mOcorrencia = new Ocorrencia();
                    }
                    mOcorrencia.setOpcaoOcorrencia(parent.getItemAtPosition(position).toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            mHolder.getBtnProximo().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!TextUtils.isEmpty(mHolder.getEtEnderecoReferencia().getText())
                            && !TextUtils.isEmpty(mHolder.getEtSituacao().getText())) {

                        mOcorrencia.setEnderecoReferencia(mHolder.getEtEnderecoReferencia().getText().toString());
                        mOcorrencia.setDescricao(mHolder.getEtSituacao().getText().toString());

                        mHolder.getTvLblOpcao().setText(mOcorrencia.getOpcaoOcorrencia());
                        mHolder.getTvEndereco().setText(mOcorrencia.getEnderecoReferencia());
                        mHolder.getTvDescricao().setText(mOcorrencia.getDescricao());

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

            mHolder.getIbFoto().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //
                    final Intent mCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    fileUri = MediaStoreUtil.getOutputMediaFileUri(MediaStoreUtil.MEDIA_TYPE_IMAGE);

                    startActivityForResult(mCamera, REQUEST_CAPTURE_IMG);

                }
            });

            mHolder.getBtnSalvar().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //
                }
            });
        }
    }
}
