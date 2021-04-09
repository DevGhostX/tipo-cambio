package com.example.tipocambio.api;

import com.example.tipocambio.entity.Divisa;
import com.example.tipocambio.service.DivisaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TipoCambio {

    private final DivisaService divisaService;

    public TipoCambio(DivisaService divisaService) {
        this.divisaService = divisaService;
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> cambioDivisa(@RequestParam("monto") double monto,
                                                         @RequestParam("origen") String origen,
                                                         @RequestParam("destino") String destino) {
        try {
            Map<String, String> body = new HashMap<>();
            Divisa divisa = divisaService.getTC(origen, destino);
            double tc = divisa.getTasa();
            double montoFin = monto * tc;
            body.put("monto", String.valueOf(monto));
            body.put("monto_final", String.valueOf(montoFin));
            body.put("origen", divisa.getOrigen());
            body.put("destino", divisa.getDestino());
            body.put("tipo_cambio", String.valueOf(tc));
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
