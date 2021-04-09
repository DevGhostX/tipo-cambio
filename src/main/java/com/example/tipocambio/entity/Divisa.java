package com.example.tipocambio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "divisa")
public class Divisa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String origen;
    private String destino;
    private double tasa;

}
