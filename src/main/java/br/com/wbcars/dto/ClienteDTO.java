package br.com.wbcars.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import br.com.wbcars.enuns.StatusGeral;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 8517649629564222273L;
	
	private Long id;

    private String nome;
    
    private String cpfCnpj;
    
    private String email;
    
    private String celular;
    
    private String rua;
    
    private String bairro;
    
    private CidadeDTO cidade;
    
    private StatusGeral status;
    
    private LocalDateTime dataNascimento;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;

    public ClienteDTO() {}

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
    
    public String getCpfCnpj() { 
        return cpfCnpj; 
    }
    
    public void setCpfCnpj(String cpfCnpj) { 
        this.cpfCnpj = cpfCnpj; 
    }
    
    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }
    
    public String getCelular() { 
        return celular; 
    }
    
    public void setCelular(String celular) { 
        this.celular = celular; 
    }
    
    public String getRua() { 
        return rua; 
    }
    
    public void setRua(String rua) { 
        this.rua = rua; 
    }
    
    public String getBairro() { 
        return bairro; 
    }
    
    public void setBairro(String bairro) { 
        this.bairro = bairro; 
    }
    
    public CidadeDTO getCidade() { 
        return cidade; 
    }
    
    public void setCidade(CidadeDTO cidade) { 
        this.cidade = cidade; 
    }
    
    public StatusGeral getStatus() { 
        return status; 
    }
    
    public void setStatus(StatusGeral status) { 
        this.status = status; 
    }
    
    public LocalDateTime getDataNascimento() { 
        return dataNascimento; 
    }
    
    public void setDataNascimento(LocalDateTime dataNascimento) { 
        this.dataNascimento = dataNascimento; 
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
		ClienteDTO other = (ClienteDTO) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "ClienteDTO{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", cpfCnpj='" + cpfCnpj + '\'' +
        ", email='" + email + '\'' +
        ", celular='" + celular + '\'' +
        ", rua='" + rua + '\'' +
        ", bairro='" + bairro + '\'' +
        ", cidade=" + (cidade != null ? cidade.getNome() : null) +
        ", status=" + (status != null ? status.getDescricao() : null) +
        ", dataNascimento=" + dataNascimento +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
