package br.com.wbcars.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ControleEstoqueDTO implements Serializable {

	private static final long serialVersionUID = 6485160437313514221L;
	
	private Long id;
	
    private ProdutoDTO produto;
    
    private Integer quantidade;
    
    private Double valor;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    
    private FornecedorDTO fornecedor;

    public ControleEstoqueDTO() {}

    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }
    
    public ProdutoDTO getProduto() { 
    	return produto; 
    }
    
    public void setProduto(ProdutoDTO produto) { 
    	this.produto = produto; 
    }
    
    public Integer getQuantidade() { 
    	return quantidade; 
    }
    
    public void setQuantidade(Integer quantidade) { 
    	this.quantidade = quantidade; 
    }
    
    public Double getValor() { 
    	return valor; 
    }
    
    public void setValor(Double valor) { 
    	this.valor = valor; 
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
    
    public FornecedorDTO getFornecedor() { 
    	return fornecedor; 
    }
    
    public void setFornecedor(FornecedorDTO fornecedor) { 
    	this.fornecedor = fornecedor; 
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
		ControleEstoqueDTO other = (ControleEstoqueDTO) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "ControleEstoqueDTO{" +
        "id=" + id +
        ", produto=" + (produto != null ? produto.getNome() : null) +
        ", quantidade=" + quantidade +
        ", valor=" + valor +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        ", fornecedor=" + (fornecedor != null ? fornecedor.getNome() : null) +
        '}';
    }
}
