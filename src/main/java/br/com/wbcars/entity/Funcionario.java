package br.com.wbcars.entity;

import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.SetorFuncionario;
import br.com.wbcars.enuns.TipoUsuario;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "funcionario")
@SequenceGenerator(name = "funcionario_seq", sequenceName = "funcionario_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_seq")
    private Long id;

    private String nome;
    @Enumerated(EnumType.STRING)
    private SetorFuncionario setor;
    private LocalDateTime dataRegistro;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;
    private String funcao;
    private String cpfCnpj;
    private String telefone;
    private String email;
    private String rua;
    private String bairro;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    // campo 'pais' removido (redundante)
    @Enumerated(EnumType.STRING)
    private StatusGeral status;

    @Column(unique = true)
    private String login;
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoUsuario perfil;
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public TipoUsuario getPerfil() { return perfil; }
    public void setPerfil(TipoUsuario perfil) { this.perfil = perfil; }

    public Funcionario() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public SetorFuncionario getSetor() { return setor; }
    public void setSetor(SetorFuncionario setor) { this.setor = setor; }
    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }
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
    public Cidade getCidade() { return cidade; }
    public void setCidade(Cidade cidade) { this.cidade = cidade; }
    // getter/setter de 'pais' removidos
    public StatusGeral getStatus() { return status; }
    public void setStatus(StatusGeral status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", setor=" + (setor != null ? setor.getDescricao() : null) +
                ", dataRegistro=" + dataRegistro +
                ", dataCadastro=" + dataCadastro +
                ", dataAlteracao=" + dataAlteracao +
                ", funcao='" + funcao + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade=" + (cidade != null ? cidade.getNome() : null) +
                // pais removido
                ", status=" + (status != null ? status.getDescricao() : null) +
                ", login='" + login + '\'' +
                ", perfil=" + (perfil != null ? perfil.getDescricao() : null) +
                '}';
    }
}
