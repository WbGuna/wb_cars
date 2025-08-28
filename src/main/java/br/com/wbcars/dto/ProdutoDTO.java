
package br.com.wbcars.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 6323987066812599152L;
	
	private Long id;
	
    private String nome;
    
    private FornecedorDTO fornecedor;
    
    private UnidadeMedidaDTO unidadeMedida;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    
    public ProdutoDTO() {}

    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }
    
    public String getNome() { 
    	return nome; 
    }
    
    public void setNome(String nome) { 
    	this.nome = nome; 
    }
    
    public FornecedorDTO getFornecedor() { 
    	return fornecedor; 
    }
    
    public void setFornecedor(FornecedorDTO fornecedor) { 
    	this.fornecedor = fornecedor; 
    }
    
    public UnidadeMedidaDTO getUnidadeMedida() { 
    	return unidadeMedida; 
    }
    
    public void setUnidadeMedida(UnidadeMedidaDTO unidadeMedida) { 
    	this.unidadeMedida = unidadeMedida; 
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
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "ProdutoDTO{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", fornecedor=" + (fornecedor != null ? fornecedor.getNome() : null) +
        ", unidadeMedida=" + (unidadeMedida != null ? unidadeMedida.getTipo() : null) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
