package com.sadho.denisson.fiscalizarmanaus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.sadho.denisson.fiscalizarmanaus.R;
import com.sadho.denisson.fiscalizarmanaus.controller.ControllerActMain;
import com.sadho.denisson.fiscalizarmanaus.holder.HolderActMain;
import com.sadho.denisson.fiscalizarmanaus.util.Constantes;
import com.sadho.denisson.fiscalizarmanaus.util.TipoOcorrencia;

public class ActMain extends AppCompatActivity implements IViewMainAct {

    private HolderActMain mHolder;
    private ControllerActMain mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Fiscalizar Manaus");

        initialize();
        initializeActions();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initialize() {
        mHolder = new HolderActMain(this);
        mController = new ControllerActMain(this);
    }

    private void initializeActions() {
        if (mHolder != null) {
            mHolder.getIBBusStop().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    iniciarAdicionarOcorrencia(TipoOcorrencia.PONTO_ONIBUS);
                }
            });
        }
    }

    @Override
    public void iniciarAdicionarOcorrencia(final TipoOcorrencia tipoOcorrencia) {
        final Intent itDetail = new Intent(this, ActNovaOcorrencia.class);
        itDetail.putExtra(Constantes.TIPO, tipoOcorrencia);
        this.startActivity(itDetail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_update) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
