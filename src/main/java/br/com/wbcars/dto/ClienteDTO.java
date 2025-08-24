package br.com.wbcars.dto;

import br.com.wbcars.enuns.StatusGeral;
import java.io.Serializable;

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
    // campo 'pais' removido (redundante)
    private StatusGeral status;
    private java.time.LocalDateTime dataNascimento;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;

    public ClienteDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpfCnpj() { return cpfCnpj; }
    public void setCpfCnpj(String cpfCnpj) { this.cpfCnpj = cpfCnpj; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public CidadeDTO getCidade() { return cidade; }
    public void setCidade(CidadeDTO cidade) { this.cidade = cidade; }
    // getter/setter de 'pais' removidos
    public StatusGeral getStatus() { return status; }
    public void setStatus(StatusGeral status) { this.status = status; }
    public java.time.LocalDateTime getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(java.time.LocalDateTime dataNascimento) { this.dataNascimento = dataNascimento; }
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDTO cliente = (ClienteDTO) o;
        return id != null && id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return 31;
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
    // pais removido
        ", status=" + (status != null ? status.getDescricao() : null) +
        ", dataNascimento=" + dataNascimento +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
