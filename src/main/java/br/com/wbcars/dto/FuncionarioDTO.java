package br.com.wbcars.dto;

import br.com.wbcars.enuns.SetorFuncionario;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoUsuario;
import java.io.Serializable;

public class FuncionarioDTO implements Serializable {

	private static final long serialVersionUID = -6259332748960600505L;
	private Long id;
    private String nome;
    private SetorFuncionario setor;
    private java.time.LocalDateTime dataRegistro;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    private String funcao;
    private String cpfCnpj;
    private String telefone;
    private String email;
    private String rua;
    private String bairro;
    private CidadeDTO cidade;
    // campo 'pais' removido (redundante)
    private StatusGeral status;
    private String login;
    private String senha;
    private TipoUsuario perfil;
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public TipoUsuario getPerfil() { return perfil; }
    public void setPerfil(TipoUsuario perfil) { this.perfil = perfil; }

    public FuncionarioDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public SetorFuncionario getSetor() { return setor; }
    public void setSetor(SetorFuncionario setor) { this.setor = setor; }
    public java.time.LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(java.time.LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }
    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }
    public String getCpfCnpj() { return cpfCnpj; }
    public void setCpfCnpj(String cpfCnpj) { this.cpfCnpj = cpfCnpj; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public CidadeDTO getCidade() { return cidade; }
    public void setCidade(CidadeDTO cidade) { this.cidade = cidade; }
    // getter/setter de 'pais' removidos
    public StatusGeral getStatus() { return status; }
    public void setStatus(StatusGeral status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuncionarioDTO that = (FuncionarioDTO) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "FuncionarioDTO{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", setor=" + (setor != null ? setor.getDescricao() : null) +
        ", dataRegistro=" + dataRegistro +
        ", funcao='" + funcao + '\'' +
        ", cpfCnpj='" + cpfCnpj + '\'' +
        ", telefone='" + telefone + '\'' +
        ", email='" + email + '\'' +
        ", rua='" + rua + '\'' +
        ", bairro='" + bairro + '\'' +
        ", cidade=" + (cidade != null ? cidade.getNome() : null) +
    // pais removido
        ", status=" + (status != null ? status.getDescricao() : null) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
