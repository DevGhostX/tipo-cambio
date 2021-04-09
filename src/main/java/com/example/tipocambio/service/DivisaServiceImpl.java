package com.example.tipocambio.service;

import com.example.tipocambio.entity.Divisa;
import com.example.tipocambio.repository.DivisaRepository;
import org.springframework.stereotype.Service;

@Service
public class DivisaServiceImpl implements DivisaService{

    private final DivisaRepository divisaRepository;

    public DivisaServiceImpl(DivisaRepository divisaRepository) {
        this.divisaRepository = divisaRepository;
    }

    @Override
    public Divisa getTC(String origen, String destino) {
        return divisaRepository.findByOrigenAndDestino(origen, destino);
    }

}
