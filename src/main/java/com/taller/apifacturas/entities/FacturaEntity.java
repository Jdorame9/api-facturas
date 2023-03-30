package com.taller.apifacturas.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "facturas")
public class FacturaEntity {
    @Id
    @Column(name = "idfactura")
    private int idfactura;
    @Column(name = "idcliente")
    private int idcliente;
    @Column(name = "idempleado")
    private int idempleado;
    @Column(name = "total")
    private int total;
    @Column(name = "fechafactura")
    private Date fechafactura;
    @Column(name = "statuscancelada")
    private short statuscancelada;
}
