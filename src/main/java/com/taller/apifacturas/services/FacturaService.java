package com.taller.apifacturas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taller.apifacturas.dtos.FacturaDto;
import com.taller.apifacturas.entities.FacturaEntity;
import com.taller.apifacturas.mappers.FacturasMappers;
import com.taller.apifacturas.repositories.FacturaRepository;

@Service
public class FacturaService {
    
    @Autowired FacturasMappers facturasMappers;

    @Autowired FacturaRepository facturaRepository;

    private static final Log logger = LogFactory.getLog(FacturaService.class);

    public FacturaDto findFactura (int idfactura) {
        try {
            var factura = facturaRepository.findFactura(idfactura);
            return facturasMappers.getFacturaDto(factura, FacturaDto.class);
        } catch (Exception ex) {
            logger.error(ex, ex);
        }
        return null;
    }

    public List<FacturaDto> findFacturas() {
        var empleados = facturaRepository.findFacturas();
        return facturasMappers.getListDto(empleados, FacturaDto.class);
    }

    public String insertFactura(FacturaDto facturaDto) {
        FacturaEntity facturaEntity = new FacturaEntity();
        try {
            facturaEntity = facturasMappers.getFacturaEntity(facturaEntity, facturaDto);
            facturaRepository.insertFactura(facturaEntity);
            return "Factura Registrada";
        } catch (Exception ex) {
            logger.error(ex, ex);
        }
        return null;
    }

    public String cancelFactura(FacturaDto facturaDto) {
        try {
            var facturas = facturaRepository.findFacturas();
            var factura = facturas.stream().filter(x -> x.getIdfactura() == facturaDto.getIdfactura()).collect(Collectors.toList()).get(0);
            factura = facturasMappers.getFacturaEntity(factura, facturaDto);
            facturaRepository.cancelFactura(factura);
            return "Factura Cancelada";
        } catch (Exception ex) {
            logger.error(ex, ex);
        }
        return null;
    }
}
