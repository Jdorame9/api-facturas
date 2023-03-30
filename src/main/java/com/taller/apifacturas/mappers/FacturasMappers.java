package com.taller.apifacturas.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taller.apifacturas.dtos.FacturaDto;
import com.taller.apifacturas.entities.FacturaEntity;

@Component
public class FacturasMappers {
    
    public <T> List<T> getListDto(Iterable<?> listFacturaEntity, Class<T> instanceClass) {
        List<T> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Object item : listFacturaEntity) {
            T entry = item instanceof List<?> ? 
            instanceClass.cast(item) : mapper.convertValue(item, instanceClass);

            list.add(entry);
        }
        return list;
    }

    public FacturaDto getFacturaDto(FacturaEntity factura, Class<FacturaDto> instanceClass) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(factura, instanceClass);
    }

    public FacturaEntity getFacturaEntity(FacturaEntity facturaEntity, FacturaDto facturaDto) {
        ObjectMapper mapper = new ObjectMapper();
        facturaEntity = mapper.convertValue(facturaDto, FacturaEntity.class);
        return facturaEntity;
    }
}
