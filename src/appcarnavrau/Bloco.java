/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcarnavrau;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cleide
 */
public class Bloco implements Comparable<Bloco>{

    private String nome;
    private String nomeRua;
    private String km;
    private String tempo;
    private String cidade;
    private String dia;
    private Distancia dist = new Distancia("AIzaSyB8hLA0u4PfXBhBV10yCORsBXvGAszNhlU");

    public Bloco() {
    }

    public Bloco(String nome, String nomeRua, String endOrigem, String cidade, String dia) {
        this.nome = nome;
        this.nomeRua = nomeRua;
        this.cidade = cidade;
        this.dia = dia;
        try {
            this.km = dist.calcDistancia(endOrigem, nomeRua);
            this.tempo = dist.calcTempo(endOrigem, nomeRua);
        } catch (Exception ex) {

        }

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
//
    
    @Override
    public int compareTo(Bloco bloco) {
        double distancia1 = Double.parseDouble(this.km);
        double distancia2 = Double.parseDouble(bloco.getKm());
          if (distancia1 < distancia2) {
            return -1;
        }
        if (distancia1 > distancia2) {
            return 1;
        }
        return 0;
        //To change body of generated methods, choose Tools | Templates.
    }

}
