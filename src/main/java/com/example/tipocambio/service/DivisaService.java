package com.example.tipocambio.service;

import com.example.tipocambio.entity.Divisa;

public interface DivisaService {

    Divisa getTC(String origen, String destino);

}
