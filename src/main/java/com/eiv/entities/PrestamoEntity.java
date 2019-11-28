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

@Entity
@Table(name = "prestamos")
public class PrestamoEntity {

    @Id
    @Column(name = "prestamo_id")
    private Long id;
    
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;
    
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "usuario_tipo_documento_id",
                referencedColumnName = "id_tipodocumento"),
        @JoinColumn(name = "usuario_numero_documento", 
                referencedColumnName = "numero_documento")
        })
    private UsuarioEntity usuario;
    
    @Column(name = "tea")
    private BigDecimal tea;
    
    @Column(name = "tea_modulo")
    private BigDecimal teaModulo;
    
    @Column(name = "capital_prestado")
    private BigDecimal capitalPrestado;
    
    @Column(name = "total_intereses")
    private BigDecimal totalIntereses;
    
    public PrestamoEntity(Long id, UsuarioEntity usuario, LocalDate fechaAlta, 
            BigDecimal tea, BigDecimal teaModulo, BigDecimal capitalPrestado,
            BigDecimal totalIntereses) {
        super();
        this.id = id;
        this.fechaAlta = fechaAlta;
        this.usuario = usuario;
        this.tea = tea;
        this.teaModulo = teaModulo;
        this.capitalPrestado = capitalPrestado;
        this.totalIntereses = totalIntereses;
    }

    public PrestamoEntity() { }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getTea() {
        return tea;
    }

    public void setTea(BigDecimal tea) {
        this.tea = tea;
    }

    public BigDecimal getTeaModulo() {
        return teaModulo;
    }

    public void setTeaModulo(BigDecimal teaModulo) {
        this.teaModulo = teaModulo;
    }

    public BigDecimal getCapitalPrestado() {
        return capitalPrestado;
    }

    public void setCapitalPrestado(BigDecimal capitalPrestado) {
        this.capitalPrestado = capitalPrestado;
    }

    public BigDecimal getTotalIntereses() {
        return totalIntereses;
    }

    public void setTotalIntereses(BigDecimal totalIntereses) {
        this.totalIntereses = totalIntereses;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((capitalPrestado == null) ? 0 : capitalPrestado.hashCode());
        result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((tea == null) ? 0 : tea.hashCode());
        result = prime * result + ((teaModulo == null) ? 0 : teaModulo.hashCode());
        result = prime * result + ((totalIntereses == null) ? 0 : totalIntereses.hashCode());
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
        PrestamoEntity other = (PrestamoEntity) obj;
        if (capitalPrestado == null) {
            if (other.capitalPrestado != null) {
                return false;
            }
        } else if (!capitalPrestado.equals(other.capitalPrestado)) {
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
        if (usuario == null) {
            if (other.usuario != null) {
                return false;
            }
        } else if (!usuario.equals(other.usuario)) {
            return false;
        }
        if (tea == null) {
            if (other.tea != null) {
                return false;
            }
        } else if (!tea.equals(other.tea)) {
            return false;
        }
        if (teaModulo == null) {
            if (other.teaModulo != null) {
                return false;
            }
        } else if (!teaModulo.equals(other.teaModulo)) {
            return false;
        }
        if (totalIntereses == null) {
            if (other.totalIntereses != null) {
                return false;
            }
        } else if (!totalIntereses.equals(other.totalIntereses)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrestamoEntity [id=" + id + ", fechaAlta=" + fechaAlta + ", usuario=" + usuario 
                + ", tea=" + tea + ", teaModulo=" + teaModulo + ", capitalPrestado=" 
                + capitalPrestado + ", totalIntereses=" + totalIntereses + "]";
    }

}
