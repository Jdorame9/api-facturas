package com.taller.apifacturas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taller.apifacturas.dtos.FacturaDto;
import com.taller.apifacturas.services.FacturaService;

@RestController
@RequestMapping("facturas")
public class FacturaController {
    
    @Autowired FacturaService facturaService;

    @GetMapping (value = "/{idfactura}")
    @ResponseBody
    public FacturaDto getFactura(
        @PathVariable("idfactura") int idfactura
    ) {
        return facturaService.findFactura(idfactura);
    }

    @GetMapping
    @ResponseBody
    public List<FacturaDto> getFacturas() {
        return facturaService.findFacturas();
    }

    @PostMapping
    @ResponseBody
    public String insertFactura(
        @RequestBody FacturaDto facturaDto
    ) {
        return facturaService.insertFactura(facturaDto);
    }

    @PutMapping
    @ResponseBody
    public String cancelFactura(
        @RequestBody FacturaDto facturaDto
    ) {
        return facturaService.cancelFactura(facturaDto);
    }
}
