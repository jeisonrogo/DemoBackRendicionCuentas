package com.demo.accion.demorendicioncuentas.repository;

import com.demo.accion.demorendicioncuentas.entities.AdmResultadosRendicionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmResultadosRendicionRepo extends JpaRepository<AdmResultadosRendicionEntity, Long> {
}
