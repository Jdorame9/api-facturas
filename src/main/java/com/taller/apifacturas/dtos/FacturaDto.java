package com.taller.apifacturas.dtos;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacturaDto implements Serializable{
    private int idfactura;
    private int idcliente;
    private int idempleado;
    private int total;
    private Date fechafactura;
    private short statuscancelada;
}
