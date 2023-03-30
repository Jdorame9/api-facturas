package com.taller.apifacturas.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.taller.apifacturas.entities.FacturaEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
public class FacturaRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    public FacturaEntity findFactura(int idfactura) {
        return entityManager.find(FacturaEntity.class, idfactura);
    }

    public List<FacturaEntity> findFacturas() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FacturaEntity> criteriaQuery = criteriaBuilder.createQuery(FacturaEntity.class);
        Root<FacturaEntity> from = criteriaQuery.from(FacturaEntity.class);

        criteriaQuery.select(from);

        TypedQuery<FacturaEntity> type = entityManager.createQuery(criteriaQuery);

        return type.getResultList();
    }

    @Transactional
    public void insertFactura(FacturaEntity facturaEntity) {
        entityManager.persist(facturaEntity);
    }

    @Transactional
    public void cancelFactura(FacturaEntity facturaEntity) {
        entityManager.merge(facturaEntity);
    }
}
