/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcarnavrau;

import java.util.ArrayList;

/**
 *
 * @author cleide
 */
public class Blocos {

    private String nome;
    private String nomeRua;
    private String km;
    private String tempo;

    public Blocos() {
    }

    public Blocos(String nome, String nomeRua, String km, String tempo) {
        this.nome = nome;
        this.nomeRua = nomeRua;
        this.km = km;
        this.tempo = tempo;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
