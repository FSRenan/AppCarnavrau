/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcarnavrau;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcelo
 */
public class Distancia {

    private final String key;

    Distancia(String key) {
        this.key = key;
    }

    public String calcDistancia(String dInicial, String dFinal) throws Exception {

        GeoApiContext context = new GeoApiContext().setApiKey(key);
        String[] origem = {dInicial}; // origem da viagem, pode ser um endereço completo ou apenas o nome de uma cidade.
        String[] destino = {dFinal}; // destino da viagem, mesma coisa da origem.

        DistanceMatrixApiRequest request = DistanceMatrixApi.getDistanceMatrix(context, origem, destino);
        DistanceMatrix results = request.await();// faz a requisição no Google Maps e recupera a resposta  

        String dist = results.rows[0].elements[0].distance + "";

        dist = dist.replaceAll("[a-z]", "");

        return dist;// Mostra a distância entre a origem e o destino

    }

    public String calcTempo(String dInicial, String dFinal) throws Exception {

        GeoApiContext context = new GeoApiContext().setApiKey(key);
        String[] origem = {dInicial}; // origem da viagem, pode ser um endereço completo ou apenas o nome de uma cidade.
        String[] destino = {dFinal}; // destino da viagem, mesma coisa da origem.

        DistanceMatrixApiRequest request = DistanceMatrixApi.getDistanceMatrix(context, origem, destino);
        DistanceMatrix results = request.await();// faz a requisição no Google Maps e recupera a resposta     

        return results.rows[0].elements[0].duration + "";  // Mostra a distância entre a origem e o destino

    }

}
