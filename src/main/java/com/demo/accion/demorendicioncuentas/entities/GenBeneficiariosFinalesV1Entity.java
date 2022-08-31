package com.demo.accion.demorendicioncuentas.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "GEN_BENEFICIARIOS_FINALES_V1", schema = "ACCION", catalog = "")
public class GenBeneficiariosFinalesV1Entity {
    private String nitPersonaJuridica;
    private Long tipoIdentificacionBenef;
    private String identificacionBenef;
    private Long paisExpIdentificacion;
    private String apellido1Benef;
    private String apellido2Benef;
    private String nombre1Benef;
    private String nombre2Benef;
    private Time fechaNacimiento;
    private Long paisNacimientoBenef;
    private Long paisNacionalidadBenef;
    private Long paisResidenciaBenef;
    private Long dptoNotificacionBenef;
    private Long municNotificacionBenef;
    private String direccionNotifBenef;
    private String codigoPostalNotifBenef;
    private Time fechaRegistro;
    private byte[] guid;
    private long id;

    @Id
    @Column(name = "NIT_PERSONA_JURIDICA", nullable = false, length = 20)
    public String getNitPersonaJuridica() {
        return nitPersonaJuridica;
    }

    public void setNitPersonaJuridica(String nitPersonaJuridica) {
        this.nitPersonaJuridica = nitPersonaJuridica;
    }

    @Basic
    @Column(name = "TIPO_IDENTIFICACION_BENEF", nullable = true, precision = 0)
    public Long getTipoIdentificacionBenef() {
        return tipoIdentificacionBenef;
    }

    public void setTipoIdentificacionBenef(Long tipoIdentificacionBenef) {
        this.tipoIdentificacionBenef = tipoIdentificacionBenef;
    }

    @Basic
    @Column(name = "IDENTIFICACION_BENEF", nullable = true, length = 20)
    public String getIdentificacionBenef() {
        return identificacionBenef;
    }

    public void setIdentificacionBenef(String identificacionBenef) {
        this.identificacionBenef = identificacionBenef;
    }

    @Basic
    @Column(name = "PAIS_EXP_IDENTIFICACION", nullable = true, precision = 0)
    public Long getPaisExpIdentificacion() {
        return paisExpIdentificacion;
    }

    public void setPaisExpIdentificacion(Long paisExpIdentificacion) {
        this.paisExpIdentificacion = paisExpIdentificacion;
    }

    @Basic
    @Column(name = "APELLIDO_1_BENEF", nullable = true, length = 20)
    public String getApellido1Benef() {
        return apellido1Benef;
    }

    public void setApellido1Benef(String apellido1Benef) {
        this.apellido1Benef = apellido1Benef;
    }

    @Basic
    @Column(name = "APELLIDO_2_BENEF", nullable = true, length = 20)
    public String getApellido2Benef() {
        return apellido2Benef;
    }

    public void setApellido2Benef(String apellido2Benef) {
        this.apellido2Benef = apellido2Benef;
    }

    @Basic
    @Column(name = "NOMBRE_1_BENEF", nullable = true, length = 20)
    public String getNombre1Benef() {
        return nombre1Benef;
    }

    public void setNombre1Benef(String nombre1Benef) {
        this.nombre1Benef = nombre1Benef;
    }

    @Basic
    @Column(name = "NOMBRE_2_BENEF", nullable = true, length = 20)
    public String getNombre2Benef() {
        return nombre2Benef;
    }

    public void setNombre2Benef(String nombre2Benef) {
        this.nombre2Benef = nombre2Benef;
    }

    @Basic
    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    public Time getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Time fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "PAIS_NACIMIENTO_BENEF", nullable = true, precision = 0)
    public Long getPaisNacimientoBenef() {
        return paisNacimientoBenef;
    }

    public void setPaisNacimientoBenef(Long paisNacimientoBenef) {
        this.paisNacimientoBenef = paisNacimientoBenef;
    }

    @Basic
    @Column(name = "PAIS_NACIONALIDAD_BENEF", nullable = true, precision = 0)
    public Long getPaisNacionalidadBenef() {
        return paisNacionalidadBenef;
    }

    public void setPaisNacionalidadBenef(Long paisNacionalidadBenef) {
        this.paisNacionalidadBenef = paisNacionalidadBenef;
    }

    @Basic
    @Column(name = "PAIS_RESIDENCIA_BENEF", nullable = true, precision = 0)
    public Long getPaisResidenciaBenef() {
        return paisResidenciaBenef;
    }

    public void setPaisResidenciaBenef(Long paisResidenciaBenef) {
        this.paisResidenciaBenef = paisResidenciaBenef;
    }

    @Basic
    @Column(name = "DPTO_NOTIFICACION_BENEF", nullable = true, precision = 0)
    public Long getDptoNotificacionBenef() {
        return dptoNotificacionBenef;
    }

    public void setDptoNotificacionBenef(Long dptoNotificacionBenef) {
        this.dptoNotificacionBenef = dptoNotificacionBenef;
    }

    @Basic
    @Column(name = "MUNIC_NOTIFICACION_BENEF", nullable = true, precision = 0)
    public Long getMunicNotificacionBenef() {
        return municNotificacionBenef;
    }

    public void setMunicNotificacionBenef(Long municNotificacionBenef) {
        this.municNotificacionBenef = municNotificacionBenef;
    }

    @Basic
    @Column(name = "DIRECCION_NOTIF_BENEF", nullable = true, length = 250)
    public String getDireccionNotifBenef() {
        return direccionNotifBenef;
    }

    public void setDireccionNotifBenef(String direccionNotifBenef) {
        this.direccionNotifBenef = direccionNotifBenef;
    }

    @Basic
    @Column(name = "CODIGO_POSTAL_NOTIF_BENEF", nullable = true, length = 10)
    public String getCodigoPostalNotifBenef() {
        return codigoPostalNotifBenef;
    }

    public void setCodigoPostalNotifBenef(String codigoPostalNotifBenef) {
        this.codigoPostalNotifBenef = codigoPostalNotifBenef;
    }

    @Basic
    @Column(name = "FECHA_REGISTRO", nullable = true)
    public Time getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Time fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Basic
    @Column(name = "GUID", nullable = false)
    public byte[] getGuid() {
        return guid;
    }

    public void setGuid(byte[] guid) {
        this.guid = guid;
    }

    @Basic
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenBeneficiariosFinalesV1Entity that = (GenBeneficiariosFinalesV1Entity) o;
        return id == that.id && Objects.equals(nitPersonaJuridica, that.nitPersonaJuridica) && Objects.equals(tipoIdentificacionBenef, that.tipoIdentificacionBenef) && Objects.equals(identificacionBenef, that.identificacionBenef) && Objects.equals(paisExpIdentificacion, that.paisExpIdentificacion) && Objects.equals(apellido1Benef, that.apellido1Benef) && Objects.equals(apellido2Benef, that.apellido2Benef) && Objects.equals(nombre1Benef, that.nombre1Benef) && Objects.equals(nombre2Benef, that.nombre2Benef) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(paisNacimientoBenef, that.paisNacimientoBenef) && Objects.equals(paisNacionalidadBenef, that.paisNacionalidadBenef) && Objects.equals(paisResidenciaBenef, that.paisResidenciaBenef) && Objects.equals(dptoNotificacionBenef, that.dptoNotificacionBenef) && Objects.equals(municNotificacionBenef, that.municNotificacionBenef) && Objects.equals(direccionNotifBenef, that.direccionNotifBenef) && Objects.equals(codigoPostalNotifBenef, that.codigoPostalNotifBenef) && Objects.equals(fechaRegistro, that.fechaRegistro) && Arrays.equals(guid, that.guid);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nitPersonaJuridica, tipoIdentificacionBenef, identificacionBenef, paisExpIdentificacion, apellido1Benef, apellido2Benef, nombre1Benef, nombre2Benef, fechaNacimiento, paisNacimientoBenef, paisNacionalidadBenef, paisResidenciaBenef, dptoNotificacionBenef, municNotificacionBenef, direccionNotifBenef, codigoPostalNotifBenef, fechaRegistro, id);
        result = 31 * result + Arrays.hashCode(guid);
        return result;
    }
}
