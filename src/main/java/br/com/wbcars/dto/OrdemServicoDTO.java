
package br.com.wbcars.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class OrdemServicoDTO implements Serializable {

	private static final long serialVersionUID = -9173594545345680738L;
	
	private Long id;
    
    private FuncionarioDTO atendente;

    private ClienteDTO cliente;

    private String descricao;
    
    private Double valor;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    
    private List<ControleEstoqueDTO> pecas;

    public OrdemServicoDTO() {}

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

    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public FuncionarioDTO getAtendente() { 
        return atendente; 
    }
    
    public void setAtendente(FuncionarioDTO atendente) { 
        this.atendente = atendente; 
    }
    
    public ClienteDTO getCliente() { 
        return cliente; 
    }
    
    public void setCliente(ClienteDTO cliente) { 
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
    
    public List<ControleEstoqueDTO> getPecas() { 
        return pecas; 
    }
    
    public void setPecas(List<ControleEstoqueDTO> pecas) { 
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
		OrdemServicoDTO other = (OrdemServicoDTO) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "OrdemServicoDTO{" +
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
