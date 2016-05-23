package com.sadho.denisson.fiscalizarmanaus.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;
import com.sadho.denisson.fiscalizarmanaus.util.TipoOcorrencia;

import java.io.Serializable;

public class Ocorrencia extends SugarRecord implements Serializable, Parcelable {

    private String opcaoOcorrencia;
    private String enderecoReferencia;
    private String descricao;
    private String urlImagem;
    private String latitude;
    private String longitude;

    public Ocorrencia(){
    }

    public Ocorrencia(final Parcel in) {
        setId(in.readLong());
        opcaoOcorrencia = in.readString();
        enderecoReferencia = in.readString();
        descricao = in.readString();
        urlImagem = in.readString();
        latitude = in.readString();
        longitude = in.readString();
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeLong(getId());
        dest.writeString(opcaoOcorrencia);
        dest.writeString(enderecoReferencia);
        dest.writeString(descricao);
        dest.writeString(urlImagem);
        dest.writeString(latitude);
        dest.writeString(longitude);
    }

    public static final Creator<Ocorrencia> CREATOR = new Creator<Ocorrencia>() {
        @Override
        public Ocorrencia createFromParcel(final Parcel source) {
            return new Ocorrencia(source);
        }

        @Override
        public Ocorrencia[] newArray(int size) {
            return new Ocorrencia[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getOpcaoOcorrencia() {
        return opcaoOcorrencia;
    }

    public void setOpcaoOcorrencia(String opcaoOcorrencia) {
        this.opcaoOcorrencia = opcaoOcorrencia;
    }

    public String getEnderecoReferencia() {
        return enderecoReferencia;
    }

    public void setEnderecoReferencia(String enderecoReferencia) {
        this.enderecoReferencia = enderecoReferencia;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
