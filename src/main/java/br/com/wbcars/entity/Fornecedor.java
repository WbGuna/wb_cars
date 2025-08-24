package br.com.wbcars.entity;

import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoFornecimento;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import java.io.Serializable;

@Entity
@Table(name = "fornecedor")
@SequenceGenerator(name = "fornecedor_seq", sequenceName = "fornecedor_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor_seq")
    private Long id;

    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String email;
    @Enumerated(EnumType.STRING)
    private TipoFornecimento tipoFornecimento;
    @Enumerated(EnumType.STRING)
    private StatusGeral status;
    private String rua;
    private String bairro;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    // campo 'pais' removido (redundante)
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;

    public Fornecedor() {}
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
    public Cidade getCidade() { return cidade; }
    public void setCidade(Cidade cidade) { this.cidade = cidade; }
    // getter/setter de 'pais' removidos

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "Fornecedor{" +
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
