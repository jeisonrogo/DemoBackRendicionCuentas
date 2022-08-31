package com.demo.accion.demorendicioncuentas.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ADM_TEMPLATES_RENDICION_CUEN", schema = "ACCION", catalog = "")
public class AdmTemplatesRendicionCuenEntity {
    private long idPlantilla;
    private String nombrePlatilla;
    private String descripcion;
    private String plantilla;
    private String usuario;
    private Timestamp fechaModificacion;

    @Id
    @Column(name = "ID_PLANTILLA", nullable = false, precision = 0)
    public long getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(long idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    @Basic
    @Column(name = "NOMBRE_PLATILLA", nullable = true, length = 500)
    public String getNombrePlatilla() {
        return nombrePlatilla;
    }

    public void setNombrePlatilla(String nombrePlatilla) {
        this.nombrePlatilla = nombrePlatilla;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 500)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "PLANTILLA", nullable = true)
    public String getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(String plantilla) {
        this.plantilla = plantilla;
    }

    @Basic
    @Column(name = "USUARIO", nullable = true, length = 3)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "FECHA_MODIFICACION", nullable = true)
    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdmTemplatesRendicionCuenEntity that = (AdmTemplatesRendicionCuenEntity) o;
        return idPlantilla == that.idPlantilla && Objects.equals(nombrePlatilla, that.nombrePlatilla) && Objects.equals(descripcion, that.descripcion) && Objects.equals(plantilla, that.plantilla) && Objects.equals(usuario, that.usuario) && Objects.equals(fechaModificacion, that.fechaModificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlantilla, nombrePlatilla, descripcion, plantilla, usuario, fechaModificacion);
    }
}
