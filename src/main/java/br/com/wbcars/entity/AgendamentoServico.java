package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.envers.Audited;

import jakarta.persistence.*;

@Entity
@Table(name = "agendamento_servico")
@SequenceGenerator(name = "agendamento_servico_seq", sequenceName = "agendamento_servico_seq", initialValue = 1, allocationSize = 1)
@Audited
public class AgendamentoServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendamento_servico_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private LocalDateTime diaAgendamento;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    

    public AgendamentoServico() {}

    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }
    
    public Cliente getCliente() { 
    	return cliente; 
    }
    
    public void setCliente(Cliente cliente) { 
    	this.cliente = cliente; 
    }
    
    public LocalDateTime getDiaAgendamento() { 
    	return diaAgendamento; 
    }
    
    public void setDiaAgendamento(LocalDateTime diaAgendamento) { 
    	this.diaAgendamento = diaAgendamento;
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
		AgendamentoServico other = (AgendamentoServico) obj;
		return Objects.equals(id, other.id);
	}

	@Override
    public String toString() {
    return "AgendamentoServico{" +
        "id=" + id +
        ", cliente=" + (cliente != null ? cliente.getNome() : null) +
        ", diaAgendamento=" + diaAgendamento +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
