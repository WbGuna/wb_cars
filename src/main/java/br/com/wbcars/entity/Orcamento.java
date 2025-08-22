package br.com.wbcars.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "orcamento")
@SequenceGenerator(name = "orcamento_seq", sequenceName = "orcamento_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Orcamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamento_seq")
    private Long orc_codigo;

    @Column(name = "orc_numero", length = 20, unique = true, nullable = false)
    private String orc_numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vei_codigo", referencedColumnName = "vei_codigo")
    private Veiculo veiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
    private Funcionario funcionario;

    @Column(name = "orc_data_emissao", nullable = false)
    private LocalDate orc_data_emissao;

    @Column(name = "orc_data_validade", nullable = false)
    private LocalDate orc_data_validade;

    @Column(name = "orc_descricao_servico", columnDefinition = "TEXT", nullable = false)
    private String orc_descricao_servico;

    @Column(name = "orc_observacoes", columnDefinition = "TEXT")
    private String orc_observacoes;

    @Column(name = "orc_valor_mao_obra", precision = 10, scale = 2)
    private BigDecimal orc_valor_mao_obra = BigDecimal.ZERO;

    @Column(name = "orc_valor_pecas", precision = 10, scale = 2)
    private BigDecimal orc_valor_pecas = BigDecimal.ZERO;

    @Column(name = "orc_valor_desconto", precision = 10, scale = 2)
    private BigDecimal orc_valor_desconto = BigDecimal.ZERO;

    @Column(name = "orc_valor_total", precision = 10, scale = 2, nullable = false)
    private BigDecimal orc_valor_total = BigDecimal.ZERO;

    @Column(name = "orc_status", length = 20, nullable = false)
    private String orc_status = "PENDENTE"; // PENDENTE, APROVADO, REJEITADO, CANCELADO

    @Column(name = "orc_forma_pagamento", length = 50)
    private String orc_forma_pagamento;

    @Column(name = "orc_condicoes_pagamento", columnDefinition = "TEXT")
    private String orc_condicoes_pagamento;

    @Column(name = "orc_data_aprovacao")
    private LocalDate orc_data_aprovacao;

    @Column(name = "orc_motivo_rejeicao", columnDefinition = "TEXT")
    private String orc_motivo_rejeicao;

    @Column(name = "orc_data_cadastro", nullable = false)
    private LocalDateTime orc_data_cadastro;

    @Column(name = "orc_data_atualizacao")
    private LocalDateTime orc_data_atualizacao;

    // Construtores
    public Orcamento() {
        this.orc_data_cadastro = LocalDateTime.now();
        this.orc_data_emissao = LocalDate.now();
        this.orc_data_validade = LocalDate.now().plusDays(30);
    }

    public Orcamento(String numero, Cliente cliente, Funcionario funcionario, String descricaoServico) {
        this();
        this.orc_numero = numero;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.orc_descricao_servico = descricaoServico;
    }

    // Getters e Setters
    public Long getOrc_codigo() {
        return orc_codigo;
    }

    public void setOrc_codigo(Long orc_codigo) {
        this.orc_codigo = orc_codigo;
    }

    public String getOrc_numero() {
        return orc_numero;
    }

    public void setOrc_numero(String orc_numero) {
        this.orc_numero = orc_numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getOrc_data_emissao() {
        return orc_data_emissao;
    }

    public void setOrc_data_emissao(LocalDate orc_data_emissao) {
        this.orc_data_emissao = orc_data_emissao;
    }

    public LocalDate getOrc_data_validade() {
        return orc_data_validade;
    }

    public void setOrc_data_validade(LocalDate orc_data_validade) {
        this.orc_data_validade = orc_data_validade;
    }

    public String getOrc_descricao_servico() {
        return orc_descricao_servico;
    }

    public void setOrc_descricao_servico(String orc_descricao_servico) {
        this.orc_descricao_servico = orc_descricao_servico;
    }

    public String getOrc_observacoes() {
        return orc_observacoes;
    }

    public void setOrc_observacoes(String orc_observacoes) {
        this.orc_observacoes = orc_observacoes;
    }

    public BigDecimal getOrc_valor_mao_obra() {
        return orc_valor_mao_obra;
    }

    public void setOrc_valor_mao_obra(BigDecimal orc_valor_mao_obra) {
        this.orc_valor_mao_obra = orc_valor_mao_obra;
    }

    public BigDecimal getOrc_valor_pecas() {
        return orc_valor_pecas;
    }

    public void setOrc_valor_pecas(BigDecimal orc_valor_pecas) {
        this.orc_valor_pecas = orc_valor_pecas;
    }

    public BigDecimal getOrc_valor_desconto() {
        return orc_valor_desconto;
    }

    public void setOrc_valor_desconto(BigDecimal orc_valor_desconto) {
        this.orc_valor_desconto = orc_valor_desconto;
    }

    public BigDecimal getOrc_valor_total() {
        return orc_valor_total;
    }

    public void setOrc_valor_total(BigDecimal orc_valor_total) {
        this.orc_valor_total = orc_valor_total;
    }

    public String getOrc_status() {
        return orc_status;
    }

    public void setOrc_status(String orc_status) {
        this.orc_status = orc_status;
    }

    public String getOrc_forma_pagamento() {
        return orc_forma_pagamento;
    }

    public void setOrc_forma_pagamento(String orc_forma_pagamento) {
        this.orc_forma_pagamento = orc_forma_pagamento;
    }

    public String getOrc_condicoes_pagamento() {
        return orc_condicoes_pagamento;
    }

    public void setOrc_condicoes_pagamento(String orc_condicoes_pagamento) {
        this.orc_condicoes_pagamento = orc_condicoes_pagamento;
    }

    public LocalDate getOrc_data_aprovacao() {
        return orc_data_aprovacao;
    }

    public void setOrc_data_aprovacao(LocalDate orc_data_aprovacao) {
        this.orc_data_aprovacao = orc_data_aprovacao;
    }

    public String getOrc_motivo_rejeicao() {
        return orc_motivo_rejeicao;
    }

    public void setOrc_motivo_rejeicao(String orc_motivo_rejeicao) {
        this.orc_motivo_rejeicao = orc_motivo_rejeicao;
    }

    public LocalDateTime getOrc_data_cadastro() {
        return orc_data_cadastro;
    }

    public void setOrc_data_cadastro(LocalDateTime orc_data_cadastro) {
        this.orc_data_cadastro = orc_data_cadastro;
    }

    public LocalDateTime getOrc_data_atualizacao() {
        return orc_data_atualizacao;
    }

    public void setOrc_data_atualizacao(LocalDateTime orc_data_atualizacao) {
        this.orc_data_atualizacao = orc_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.orc_data_cadastro = LocalDateTime.now();
        if (this.orc_data_emissao == null) {
            this.orc_data_emissao = LocalDate.now();
        }
        if (this.orc_data_validade == null) {
            this.orc_data_validade = LocalDate.now().plusDays(30);
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.orc_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(orc_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Orcamento orcamento = (Orcamento) obj;
        return Objects.equals(orc_codigo, orcamento.orc_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "Orcamento{" +
                "orc_codigo=" + orc_codigo +
                ", orc_numero='" + orc_numero + '\'' +
                ", orc_data_emissao=" + orc_data_emissao +
                ", orc_data_validade=" + orc_data_validade +
                ", orc_valor_total=" + orc_valor_total +
                ", orc_status='" + orc_status + '\'' +
                '}';
    }
}
