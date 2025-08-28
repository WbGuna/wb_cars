package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.envers.Audited;

import jakarta.persistence.*;

@Entity
@Table(name = "relatorio_financeiro")
@SequenceGenerator(name = "relatorio_financeiro_seq", sequenceName = "relatorio_financeiro_seq", initialValue = 1, allocationSize = 1)
@Audited
public class RelatorioFinanceiro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relatorio_financeiro_seq")
    private Long id;

    private Double totalVendas;
    
    private Double totalOrcamentos;
    
    private Double totalGastos;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    
    public LocalDateTime getDataCadastro() { 
        return dataCadastro; 
    }
    
    public void setDataCadastro(LocalDateTime dataCadastro) { 
        this.dataCadastro = dataCadastro; 
    }
    
    public LocalDateTime getDataAlteracao() { 
        return dataAlteracao; 
    }
    
    public void setDataAlteracao(LocalDateTime dataAlteracao) { 
        this.dataAlteracao = dataAlteracao; 
    }

    public RelatorioFinanceiro() {}

    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public Double getTotalVendas() { 
        return totalVendas; 
    }
    
    public void setTotalVendas(Double totalVendas) { 
        this.totalVendas = totalVendas; 
    }
    
    public Double getTotalOrcamentos() { 
        return totalOrcamentos; 
    }
    
    public void setTotalOrcamentos(Double totalOrcamentos) { 
        this.totalOrcamentos = totalOrcamentos; 
    }
    
    public Double getTotalGastos() { 
        return totalGastos; 
    }
    
    public void setTotalGastos(Double totalGastos) { 
        this.totalGastos = totalGastos; 
    }

    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelatorioFinanceiro other = (RelatorioFinanceiro) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "RelatorioFinanceiro{" +
        "id=" + id +
        ", totalVendas=" + totalVendas +
        ", totalOrcamentos=" + totalOrcamentos +
        ", totalGastos=" + totalGastos +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
