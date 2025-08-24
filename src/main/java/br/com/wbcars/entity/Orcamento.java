package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.envers.Audited;

import br.com.wbcars.enuns.StatusOrcamento;
import br.com.wbcars.enuns.TipoOrcamento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "orcamento")
@SequenceGenerator(name = "orcamento_seq", sequenceName = "orcamento_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Orcamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamento_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoOrcamento tipo;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Double valorTotal;
    private LocalDateTime dataInicial;
    private LocalDateTime dataEntrega;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;
    @Enumerated(EnumType.STRING)
    private StatusOrcamento status;

    public Orcamento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TipoOrcamento getTipo() { return tipo; }
    public void setTipo(TipoOrcamento tipo) { this.tipo = tipo; }
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
    public LocalDateTime getDataInicial() { return dataInicial; }
    public void setDataInicial(LocalDateTime dataInicial) { this.dataInicial = dataInicial; }
    public LocalDateTime getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(LocalDateTime dataEntrega) { this.dataEntrega = dataEntrega; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }
    public StatusOrcamento getStatus() { return status; }
    public void setStatus(StatusOrcamento status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orcamento that = (Orcamento) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Orcamento{" +
                "id=" + id +
                ", tipo=" + (tipo != null ? tipo.getDescricao() : null) +
                ", produto=" + (produto != null ? produto.getNome() : null) +
                ", funcionario=" + (funcionario != null ? funcionario.getNome() : null) +
                ", cliente=" + (cliente != null ? cliente.getNome() : null) +
                ", valorTotal=" + valorTotal +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataEntrega='" + dataEntrega + '\'' +
                ", status=" + (status != null ? status.getDescricao() : null) +
                '}';
    }
}
