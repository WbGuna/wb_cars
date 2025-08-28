package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "relatorio_financeiro_detalhado")
@SequenceGenerator(name = "relatorio_financeiro_detalhado_seq", sequenceName = "relatorio_financeiro_detalhado_seq", initialValue = 1, allocationSize = 1)
@Audited
public class RelatorioFinanceiroDetalhado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relatorio_financeiro_detalhado_seq")
    private Long id;

    @OneToMany
    @JoinColumn(name = "relatorio_financeiro_detalhado_id")
    private List<OrdemServico> ordensServico;

    @OneToMany
    @JoinColumn(name = "relatorio_financeiro_detalhado_id")
    private List<ContaPagar> contasPagar;

    private Double valorTotalEntrada;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    
    public RelatorioFinanceiroDetalhado() {}
    
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public List<OrdemServico> getOrdensServico() { 
        return ordensServico; 
    }
    
    public void setOrdensServico(List<OrdemServico> ordensServico) { 
        this.ordensServico = ordensServico; 
    }
    
    public List<ContaPagar> getContasPagar() { 
        return contasPagar; 
    }
    
    public void setContasPagar(List<ContaPagar> contasPagar) { 
        this.contasPagar = contasPagar; 
    }
    
    public Double getValorTotalEntrada() { 
        return valorTotalEntrada; 
    }
    
    public void setValorTotalEntrada(Double valorTotalEntrada) { 
        this.valorTotalEntrada = valorTotalEntrada; 
    }
    
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
		RelatorioFinanceiroDetalhado other = (RelatorioFinanceiroDetalhado) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "RelatorioFinanceiroDetalhado{" +
        "id=" + id +
        ", ordensServico=" + (ordensServico != null ? ordensServico.size() : 0) +
        ", contasPagar=" + (contasPagar != null ? contasPagar.size() : 0) +
        ", valorTotalEntrada=" + valorTotalEntrada +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
