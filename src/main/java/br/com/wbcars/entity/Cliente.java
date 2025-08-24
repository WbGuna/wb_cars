package br.com.wbcars.entity;

import br.com.wbcars.enuns.StatusGeral;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    private Long id;

    private String nome;
    private String cpfCnpj;
    private String email;
    private String celular;
    private String rua;
    private String bairro;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    @Enumerated(EnumType.STRING)
    private StatusGeral status;
    private LocalDateTime dataNascimento;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;

    public Cliente() {}

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
    public Cidade getCidade() { return cidade; }
    public void setCidade(Cidade cidade) { this.cidade = cidade; }
    public StatusGeral getStatus() { return status; }
    public void setStatus(StatusGeral status) { this.status = status; }
    public LocalDateTime getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDateTime dataNascimento) { this.dataNascimento = dataNascimento; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id != null && id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Cliente{" +
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
