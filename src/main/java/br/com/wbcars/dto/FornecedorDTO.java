
package br.com.wbcars.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoFornecimento;

public class FornecedorDTO implements Serializable {
    public String getCpfCnpjFormatado() {
        if (cpfCnpj == null) return "";
        String value = cpfCnpj.replaceAll("[^0-9]", "");
        if (value.length() == 11) {
            return value.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        } else if (value.length() == 14) {
            return value.replaceFirst("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        }
        return cpfCnpj;
    }

    public String getTelefoneFormatado() {
        if (telefone == null) return "";
        String value = telefone.replaceAll("[^0-9]", "");
        if (value.length() == 11) {
            return value.replaceFirst("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
        } else if (value.length() == 10) {
            return value.replaceFirst("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
        }
        return telefone;
    }
    public String getDataCadastroFormatado() {
        if (dataCadastro == null) return "";
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataCadastro.format(formatter);
    }

    public String getDataAlteracaoFormatado() {
        if (dataAlteracao == null) return "";
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataAlteracao.format(formatter);
    }

	private static final long serialVersionUID = -6729930439773845363L;
	
	private Long id;

    private String nome;
    
    private String cpfCnpj;
    
    private String telefone;
    
    private String email;
    
    private TipoFornecimento tipoFornecimento;
    
    private StatusGeral status;
    
    private String rua;
    
    private String bairro;
    
    private CidadeDTO cidade;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;

    public FornecedorDTO() {}

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
    
    public String getTelefone() { 
        return telefone; 
    }
    
    public void setTelefone(String telefone) { 
        this.telefone = telefone; 
    }
    
    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }
    
    public TipoFornecimento getTipoFornecimento() { 
        return tipoFornecimento; 
    }
    
    public void setTipoFornecimento(TipoFornecimento tipoFornecimento) { 
        this.tipoFornecimento = tipoFornecimento; 
    }
    
    public StatusGeral getStatus() { 
        return status; 
    }
    
    public void setStatus(StatusGeral status) { 
        this.status = status; 
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
		FornecedorDTO other = (FornecedorDTO) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "FornecedorDTO{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", cpfCnpj='" + cpfCnpj + '\'' +
        ", telefone='" + telefone + '\'' +
        ", email='" + email + '\'' +
        ", tipoFornecimento=" + (tipoFornecimento != null ? tipoFornecimento.getDescricao() : null) +
        ", status=" + (status != null ? status.getDescricao() : null) +
        ", rua='" + rua + '\'' +
        ", bairro='" + bairro + '\'' +
        ", cidade=" + (cidade != null ? cidade.getNome() : null) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
