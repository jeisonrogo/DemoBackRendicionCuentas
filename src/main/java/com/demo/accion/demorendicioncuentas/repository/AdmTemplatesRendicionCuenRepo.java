package com.demo.accion.demorendicioncuentas.repository;

import com.demo.accion.demorendicioncuentas.entities.AdmTemplatesRendicionCuenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmTemplatesRendicionCuenRepo extends JpaRepository<AdmTemplatesRendicionCuenEntity, Long> {
}
