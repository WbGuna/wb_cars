
package br.com.wbcars.dto;

import br.com.wbcars.enuns.TipoFornecimento;
import br.com.wbcars.enuns.StatusGeral;
import java.io.Serializable;

public class FornecedorDTO implements Serializable {

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
    // campo 'pais' removido (redundante)
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;

    public FornecedorDTO() {}
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpfCnpj() { return cpfCnpj; }
    public void setCpfCnpj(String cpfCnpj) { this.cpfCnpj = cpfCnpj; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public TipoFornecimento getTipoFornecimento() { return tipoFornecimento; }
    public void setTipoFornecimento(TipoFornecimento tipoFornecimento) { this.tipoFornecimento = tipoFornecimento; }
    public StatusGeral getStatus() { return status; }
    public void setStatus(StatusGeral status) { this.status = status; }
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public CidadeDTO getCidade() { return cidade; }
    public void setCidade(CidadeDTO cidade) { this.cidade = cidade; }
    // getter/setter de 'pais' removidos

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FornecedorDTO that = (FornecedorDTO) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
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
    // pais removido
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
