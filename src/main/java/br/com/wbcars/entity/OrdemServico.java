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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordem_servico")
@SequenceGenerator(name = "ordem_servico_seq", sequenceName = "ordem_servico_seq", initialValue = 1, allocationSize = 1)
@Audited
public class OrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordem_servico_seq")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "atendente_id")
    private Funcionario atendente;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private String descricao;
    
    private Double valor;
    
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

    @ManyToMany
    @JoinTable(
        name = "ordem_servico_pecas",
        joinColumns = @JoinColumn(name = "ordem_servico_id"),
        inverseJoinColumns = @JoinColumn(name = "controle_estoque_id")
    )
    private List<ControleEstoque> pecas;

    public OrdemServico() {}

    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
       
    public Funcionario getAtendente() { 
        return atendente; 
    }
    
    public void setAtendente(Funcionario atendente) { 
        this.atendente = atendente; 
    }
    
    public Cliente getCliente() { 
        return cliente; 
    }
    
    public void setCliente(Cliente cliente) { 
        this.cliente = cliente; 
    }
    
    public String getDescricao() { 
        return descricao; 
    }
    
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }
    
    public Double getValor() { 
        return valor; 
    }
    
    public void setValor(Double valor) { 
        this.valor = valor; 
    }
    
    public List<ControleEstoque> getPecas() { 
        return pecas; 
    }
    
    public void setPecas(List<ControleEstoque> pecas) { 
        this.pecas = pecas; 
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
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "OrdemServico{" +
        "id=" + id +
        ", atendente=" + (atendente != null ? atendente.getNome() : null) +
        ", cliente=" + (cliente != null ? cliente.getNome() : null) +
        ", descricao='" + descricao + '\'' +
        ", valor=" + valor +
        ", pecas=" + (pecas != null ? pecas.size() : 0) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
