package com.demo.accion.demorendicioncuentas.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ADM_RESULTADOS_RENDICION", schema = "ACCION", catalog = "")
@SequenceGenerator(name="SEQ_RESULTADOS_ID", sequenceName="seq_resutados_rendicion", schema = "ACCION", allocationSize = 1)
public class AdmResultadosRendicionEntity {
    private long idRendicion;
    private String nombreArchivo;
    private String codigoNegocio;
    private Long idPlantilla;
    private String plantillaResultado;
    private String usuario;
    private Timestamp fechaModificacion;

    public AdmResultadosRendicionEntity(String nombreArchivo, String codigoNegocio, Long idPlantilla, String plantillaResultado, String usuario, Timestamp fechaModificacion) {
        this.nombreArchivo = nombreArchivo;
        this.codigoNegocio = codigoNegocio;
        this.idPlantilla = idPlantilla;
        this.plantillaResultado = plantillaResultado;
        this.usuario = usuario;
        this.fechaModificacion = fechaModificacion;
    }

    public AdmResultadosRendicionEntity() {
    }

    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_RESULTADOS_ID")
    @Id
    @Column(name = "ID_RENDICION", nullable = false, precision = 0)
    public long getIdRendicion() {
        return idRendicion;
    }

    public void setIdRendicion(long idRendicion) {
        this.idRendicion = idRendicion;
    }

    @Basic
    @Column(name = "NOMBRE_ARCHIVO", nullable = true, length = 500)
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Basic
    @Column(name = "CODIGO_NEGOCIO", nullable = true, length = 500)
    public String getCodigoNegocio() {
        return codigoNegocio;
    }

    public void setCodigoNegocio(String codigoNegocio) {
        this.codigoNegocio = codigoNegocio;
    }

    @Basic
    @Column(name = "ID_PLANTILLA", nullable = true, precision = 0)
    public Long getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(Long idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    @Basic
    @Column(name = "PLANTILLA_RESULTADO", nullable = true)
    public String getPlantillaResultado() {
        return plantillaResultado;
    }

    public void setPlantillaResultado(String plantillaResultado) {
        this.plantillaResultado = plantillaResultado;
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
        AdmResultadosRendicionEntity that = (AdmResultadosRendicionEntity) o;
        return idRendicion == that.idRendicion && Objects.equals(nombreArchivo, that.nombreArchivo) && Objects.equals(codigoNegocio, that.codigoNegocio) && Objects.equals(idPlantilla, that.idPlantilla) && Objects.equals(plantillaResultado, that.plantillaResultado) && Objects.equals(usuario, that.usuario) && Objects.equals(fechaModificacion, that.fechaModificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRendicion, nombreArchivo, codigoNegocio, idPlantilla, plantillaResultado, usuario, fechaModificacion);
    }
}
