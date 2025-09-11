package br.com.wbcars.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import java.time.format.DateTimeFormatter;

public class VeiculoDTO implements Serializable {
    public String getDataCadastroFormatado() {
        if (dataCadastro == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataCadastro.format(formatter);
    }

    public String getDataAlteracaoFormatado() {
        if (dataAlteracao == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataAlteracao.format(formatter);
    }

	private static final long serialVersionUID = 6833651539591464563L;
	
	private Long id;

    private String modelo;
    
    private String marca;
    
    private String placa;
    
    private Integer kilometragem;
    
    private String observacao;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    
    private ClienteDTO cliente;

    public VeiculoDTO() {}
    
    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }
    
    public String getModelo() { 
    	return modelo; 
    }
    
    public void setModelo(String modelo) { 
    	this.modelo = modelo; 
    }
    
    public String getMarca() { 
    	return marca; 
    }
    
    public void setMarca(String marca) { 
    	this.marca = marca; 
    }
    
    public String getPlaca() { 
    	return placa; 
    }
    
    public void setPlaca(String placa) { 
    	this.placa = placa; 
    }
    
    public Integer getKilometragem() { 
    	return kilometragem; 
    }
    
    public void setKilometragem(Integer kilometragem) { 
    	this.kilometragem = kilometragem; 
    }
    
    public String getObservacao() { 
    	return observacao; 
    }
    
    public void setObservacao(String observacao) { 
    	this.observacao = observacao; 
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
    
    public ClienteDTO getCliente() { 
    	return cliente; 
    }
    
    public void setCliente(ClienteDTO cliente) { 
    	this.cliente = cliente; 
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
		VeiculoDTO other = (VeiculoDTO) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "VeiculoDTO{" +
        "id=" + id +
        ", modelo='" + modelo + '\'' +
        ", marca='" + marca + '\'' +
        ", placa='" + placa + '\'' +
        ", kilometragem=" + kilometragem +
        ", observacao='" + observacao + '\'' +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        ", cliente=" + (cliente != null ? cliente.getNome() : null) +
        '}';
    }
}
