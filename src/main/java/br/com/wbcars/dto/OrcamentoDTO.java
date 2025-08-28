package br.com.wbcars.dto;

import br.com.wbcars.enuns.TipoOrcamento;
import br.com.wbcars.enuns.StatusOrcamento;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class OrcamentoDTO implements Serializable {

	private static final long serialVersionUID = 5845989520742398040L;
	
	private Long id;
	
    private TipoOrcamento tipo;
    
    private ProdutoDTO produto;
    
    private FuncionarioDTO funcionario;
    
    private ClienteDTO cliente;
    
    private Double valorTotal;
    
    private LocalDateTime dataInicial;
    
    private LocalDateTime dataEntrega;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    
    private StatusOrcamento status;

    public OrcamentoDTO() {}

    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }
    
    public TipoOrcamento getTipo() { 
    	return tipo; 
    }
    
    public void setTipo(TipoOrcamento tipo) { 
    	this.tipo = tipo; 
    }
    
    public ProdutoDTO getProduto() { 
    	return produto; 
    }
    
    public void setProduto(ProdutoDTO produto) { 
    	this.produto = produto; 
    }
    
    public FuncionarioDTO getFuncionario() { 
    	return funcionario; 
    }
    
    public void setFuncionario(FuncionarioDTO funcionario) { 
    	this.funcionario = funcionario; 
    }
    
    public ClienteDTO getCliente() { 
    	return cliente; 
    }
    
    public void setCliente(ClienteDTO cliente) { 
    	this.cliente = cliente; 
    }
    
    public Double getValorTotal() { 
    	return valorTotal; 
    }
    
    public void setValorTotal(Double valorTotal) { 
    	this.valorTotal = valorTotal; 
    }
    
    public LocalDateTime getDataInicial() { 
    	return dataInicial; 
    }
    
    public void setDataInicial(LocalDateTime dataInicial) { 
    	this.dataInicial = dataInicial; 
    }
    
    public LocalDateTime getDataEntrega() { 
    	return dataEntrega; 
    }
    
    public void setDataEntrega(LocalDateTime dataEntrega) { 
    	this.dataEntrega = dataEntrega; 
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
    
    public StatusOrcamento getStatus() { 
    	return status; 
    }
    
    public void setStatus(StatusOrcamento status) { 
    	this.status = status; 
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
		OrcamentoDTO other = (OrcamentoDTO) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "OrcamentoDTO{" +
        "id=" + id +
        ", tipo=" + (tipo != null ? tipo.getDescricao() : null) +
        ", produto=" + (produto != null ? produto.getNome() : null) +
        ", funcionario=" + (funcionario != null ? funcionario.getNome() : null) +
        ", cliente=" + (cliente != null ? cliente.getNome() : null) +
        ", valorTotal=" + valorTotal +
        ", dataInicial=" + dataInicial +
        ", dataEntrega=" + dataEntrega +
        ", status=" + (status != null ? status.getDescricao() : null) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
