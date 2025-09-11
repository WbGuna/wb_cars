
package br.com.wbcars.dto;

import br.com.wbcars.enuns.EstadoBrasil;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class CidadeDTO implements Serializable {

	private static final long serialVersionUID = -5472585569386278692L;
	
	private Long id;
	
    private String nome;
    
    private EstadoBrasil estado;
    
    private String pais;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;

    public CidadeDTO() {}

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
    
    public EstadoBrasil getEstado() { 
    	return estado; 
    }
    
    public void setEstado(EstadoBrasil estado) { 
    	this.estado = estado; 
    }
    
    public String getPais() { 
    	return pais; 
    }
    
    public void setPais(String pais) { 
    	this.pais = pais; 
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
    
    // Métodos para formatação de data
    public String getDataCadastroFormatada() {
        return dataCadastro != null ? 
            dataCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) : 
            "-";
    }
    
    public String getDataAlteracaoFormatada() {
        return dataAlteracao != null ? 
            dataAlteracao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) : 
            "-";
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
		CidadeDTO other = (CidadeDTO) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "CidadeDTO{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", estado=" + (estado != null ? estado.getNome() : null) +
        ", pais='" + pais + '\'' +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
