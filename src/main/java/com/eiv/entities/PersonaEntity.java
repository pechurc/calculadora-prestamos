package com.eiv.entities;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eiv.enums.GeneroEnum;

@Entity
@Table(name = "personas")
public class PersonaEntity {

    @EmbeddedId
    private PersonaPkEntity id;
    
    @Column(name = "numero_documento", nullable = false, insertable = false, updatable = false)
    private Long numeroDocumento;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipodocumento", referencedColumnName = "id_tipodocumento", 
    insertable = false, updatable = false)
    private TipoDocumentoEntity tipoDocumento;
    
    @Column(name = "nombre_apellido", length = 400, nullable = false, unique = true)
    private String nombreApellido;
    
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    
    @Column(name = "correo_electronico", length = 300)
    private String correoElectronico;
    
    @Column(name = "es_argentino", nullable = false)
    private Boolean esArgentino;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_localidad", referencedColumnName = "id_localidad", nullable = false)
    private LocalidadEntity localidad;
    
    @Column(name = "codigo_postal", nullable = false, length = 10)
    private String codigoPostal;
    
    @Column(name = "genero", nullable = false)
    private GeneroEnum genero;
    
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name = "foto_cara")
    private Byte[] fotoCara;
    
    public PersonaEntity() { }

    
    
    public PersonaEntity(PersonaPkEntity id, Long numeroDocumento, 
            TipoDocumentoEntity tipoDocumento, String nombreApellido, LocalDate fechaNacimiento,
            String correoElectronico, Boolean esArgentino,  LocalidadEntity localidad, 
            String codigoPostal, GeneroEnum genero, Byte[] fotoCara) {
        super();
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombreApellido = nombreApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.esArgentino = esArgentino;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.genero = genero;
        this.fotoCara = fotoCara;
    }



    public PersonaPkEntity getId() {
        return id;
    }

    public void setId(PersonaPkEntity id) {
        this.id = id;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Boolean getEsArgentino() {
        return esArgentino;
    }

    public void setEsArgentino(Boolean esArgentino) {
        this.esArgentino = esArgentino;
    }

    public LocalidadEntity getLocalidad() {
        return localidad;
    }

    public void setLocalidad(LocalidadEntity localidad) {
        this.localidad = localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public Byte[] getFotoCara() {
        return fotoCara;
    }

    public void setFotoCara(Byte[] fotoCara) {
        this.fotoCara = fotoCara;
    }
    
    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PersonaEntity other = (PersonaEntity) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (nombreApellido == null) {
            if (other.nombreApellido != null) {
                return false;
            }
        } else if (!nombreApellido.equals(other.nombreApellido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonaEntity [id=" + id + ", nombreApellido=" + nombreApellido + "]";
    }
    
    
}
