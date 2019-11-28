package com.eiv.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eiv.enums.SistemaAmortizacionEnum;

@Entity
@Table(name = "lineas")
public class LineaEntity {

    @Id
    @Column(name = "linea_id")
    private Long id;
    
    @Column(name = "nombre", length = 200)
    private String nombre;
    
    @Column(name = "tasa_min")
    private BigDecimal tasaMin;
    
    @Column(name = "tasa_max")
    private BigDecimal tasaMax;
    
    @Column(name = "cuotas_min")
    private Integer cuotasMin;
    
    @Column(name = "cuotas_max")
    private Integer cuotasMax;
    
    @Column(name = "capital_min")
    private BigDecimal capitalMin;
    
    @Column(name = "capital_max")
    private BigDecimal capitalMax;
    
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta ;
    
    @Column(name = "sistema_amortizacion")
    private SistemaAmortizacionEnum sistemaAmortizacion;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "usuario_tipo_documento_id",
                referencedColumnName = "id_tipodocumento"),
        @JoinColumn(name = "usuario_numero_documento", 
                referencedColumnName = "numero_documento")
        })
    private UsuarioEntity usuario ;

    public LineaEntity() { }
    
    public LineaEntity(Long id, UsuarioEntity usuario, String nombre, 
            BigDecimal tasaMin, BigDecimal tasaMax, Integer cuotasMin, Integer cuotasMax, 
            BigDecimal capitalMin, BigDecimal capitalMax, LocalDate fechaAlta, 
            SistemaAmortizacionEnum sistemaAmortizacion) {
        super();
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.tasaMin = tasaMin;
        this.tasaMax = tasaMax;
        this.cuotasMin = cuotasMin;
        this.cuotasMax = cuotasMax;
        this.capitalMin = capitalMin;
        this.capitalMax = capitalMax;
        this.fechaAlta = fechaAlta;
        this.sistemaAmortizacion = sistemaAmortizacion;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getTasaMin() {
        return tasaMin;
    }

    public void setTasaMin(BigDecimal tasaMin) {
        this.tasaMin = tasaMin;
    }

    public BigDecimal getTasaMax() {
        return tasaMax;
    }

    public void setTasaMax(BigDecimal tasaMax) {
        this.tasaMax = tasaMax;
    }

    public Integer getCuotasMin() {
        return cuotasMin;
    }

    public void setCuotasMin(Integer cuotasMin) {
        this.cuotasMin = cuotasMin;
    }

    public Integer getCuotasMax() {
        return cuotasMax;
    }

    public void setCuotasMax(Integer cuotasMax) {
        this.cuotasMax = cuotasMax;
    }

    public BigDecimal getCapitalMin() {
        return capitalMin;
    }

    public void setCapitalMin(BigDecimal capitalMin) {
        this.capitalMin = capitalMin;
    }

    public BigDecimal getCapitalMax() {
        return capitalMax;
    }

    public void setCapitalMax(BigDecimal capitalMax) {
        this.capitalMax = capitalMax;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    public SistemaAmortizacionEnum getSistemaAmortizacion() {
        return sistemaAmortizacion;
    }

    public void setSistemaAmortizacion(SistemaAmortizacionEnum sistemaAmortizacion) {
        this.sistemaAmortizacion = sistemaAmortizacion;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((capitalMax == null) ? 0 : capitalMax.hashCode());
        result = prime * result + ((capitalMin == null) ? 0 : capitalMin.hashCode());
        result = prime * result + ((cuotasMax == null) ? 0 : cuotasMax.hashCode());
        result = prime * result + ((cuotasMin == null) ? 0 : cuotasMin.hashCode());
        result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((sistemaAmortizacion == null) ? 0 : sistemaAmortizacion.hashCode());
        result = prime * result + ((tasaMax == null) ? 0 : tasaMax.hashCode());
        result = prime * result + ((tasaMin == null) ? 0 : tasaMin.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        return result;
    }

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
        LineaEntity other = (LineaEntity) obj;
        if (capitalMax == null) {
            if (other.capitalMax != null) {
                return false;
            }
        } else if (!capitalMax.equals(other.capitalMax)) {
            return false;
        }
        if (capitalMin == null) {
            if (other.capitalMin != null) {
                return false;
            }
        } else if (!capitalMin.equals(other.capitalMin)) {
            return false;
        }
        if (cuotasMax == null) {
            if (other.cuotasMax != null) {
                return false;
            }
        } else if (!cuotasMax.equals(other.cuotasMax)) {
            return false;
        }
        if (cuotasMin == null) {
            if (other.cuotasMin != null) {
                return false;
            }
        } else if (!cuotasMin.equals(other.cuotasMin)) {
            return false;
        }
        if (fechaAlta == null) {
            if (other.fechaAlta != null) {
                return false;
            }
        } else if (!fechaAlta.equals(other.fechaAlta)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (nombre == null) {
            if (other.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(other.nombre)) {
            return false;
        }
        if (sistemaAmortizacion != other.sistemaAmortizacion) {
            return false;
        }
        if (tasaMax == null) {
            if (other.tasaMax != null) {
                return false;
            }
        } else if (!tasaMax.equals(other.tasaMax)) {
            return false;
        }
        if (tasaMin == null) {
            if (other.tasaMin != null) {
                return false;
            }
        } else if (!tasaMin.equals(other.tasaMin)) {
            return false;
        }
        if (usuario == null) {
            if (other.usuario != null) {
                return false;
            }
        } else if (!usuario.equals(other.usuario)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "LineaEntity [id=" + id + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta 
                + ", usuario=" + usuario + "]";
    }
    
    
}
