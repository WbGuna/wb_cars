package br.com.wbcars.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "conta_pagar")
@SequenceGenerator(name = "conta_pagar_seq", sequenceName = "conta_pagar_seq", initialValue = 1, allocationSize = 1)
@Audited
public class ContaPagar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_pagar_seq")
    private Long cp_codigo;

    @Column(name = "cp_numero_documento", length = 50, nullable = false)
    private String cp_numero_documento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "for_codigo", referencedColumnName = "for_codigo", nullable = false)
    private Fornecedor fornecedor;

    @Column(name = "cp_descricao", columnDefinition = "TEXT", nullable = false)
    private String cp_descricao;

    @Column(name = "cp_categoria", length = 100)
    private String cp_categoria;

    @Column(name = "cp_data_emissao", nullable = false)
    private LocalDate cp_data_emissao;

    @Column(name = "cp_data_vencimento", nullable = false)
    private LocalDate cp_data_vencimento;

    @Column(name = "cp_data_pagamento")
    private LocalDate cp_data_pagamento;

    @Column(name = "cp_valor_original", precision = 10, scale = 2, nullable = false)
    private BigDecimal cp_valor_original;

    @Column(name = "cp_valor_desconto", precision = 10, scale = 2)
    private BigDecimal cp_valor_desconto = BigDecimal.ZERO;

    @Column(name = "cp_valor_juros", precision = 10, scale = 2)
    private BigDecimal cp_valor_juros = BigDecimal.ZERO;

    @Column(name = "cp_valor_multa", precision = 10, scale = 2)
    private BigDecimal cp_valor_multa = BigDecimal.ZERO;

    @Column(name = "cp_valor_pago", precision = 10, scale = 2)
    private BigDecimal cp_valor_pago = BigDecimal.ZERO;

    @Column(name = "cp_valor_saldo", precision = 10, scale = 2)
    private BigDecimal cp_valor_saldo;

    @Column(name = "cp_status", length = 20, nullable = false)
    private String cp_status = "PENDENTE"; // PENDENTE, PAGO, VENCIDO, CANCELADO

    @Column(name = "cp_tipo", length = 30, nullable = false)
    private String cp_tipo; // FORNECEDOR, SERVICO, IMPOSTO, FINANCIAMENTO, OUTROS

    @Column(name = "cp_forma_pagamento", length = 50)
    private String cp_forma_pagamento;

    @Column(name = "cp_numero_cheque", length = 20)
    private String cp_numero_cheque;

    @Column(name = "cp_banco", length = 100)
    private String cp_banco;

    @Column(name = "cp_agencia", length = 20)
    private String cp_agencia;

    @Column(name = "cp_conta", length = 20)
    private String cp_conta;

    @Column(name = "cp_observacoes", columnDefinition = "TEXT")
    private String cp_observacoes;

    @Column(name = "cp_numero_parcela")
    private Integer cp_numero_parcela;

    @Column(name = "cp_total_parcelas")
    private Integer cp_total_parcelas;

    @Column(name = "cp_data_cadastro", nullable = false)
    private LocalDateTime cp_data_cadastro;

    @Column(name = "cp_data_atualizacao")
    private LocalDateTime cp_data_atualizacao;

    // Construtores
    public ContaPagar() {
        this.cp_data_cadastro = LocalDateTime.now();
        this.cp_data_emissao = LocalDate.now();
    }

    public ContaPagar(String numeroDocumento, Fornecedor fornecedor, String descricao, LocalDate dataVencimento, BigDecimal valorOriginal, String tipo) {
        this();
        this.cp_numero_documento = numeroDocumento;
        this.fornecedor = fornecedor;
        this.cp_descricao = descricao;
        this.cp_data_vencimento = dataVencimento;
        this.cp_valor_original = valorOriginal;
        this.cp_valor_saldo = valorOriginal;
        this.cp_tipo = tipo;
    }

    // Getters e Setters
    public Long getCp_codigo() {
        return cp_codigo;
    }

    public void setCp_codigo(Long cp_codigo) {
        this.cp_codigo = cp_codigo;
    }

    public String getCp_numero_documento() {
        return cp_numero_documento;
    }

    public void setCp_numero_documento(String cp_numero_documento) {
        this.cp_numero_documento = cp_numero_documento;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCp_descricao() {
        return cp_descricao;
    }

    public void setCp_descricao(String cp_descricao) {
        this.cp_descricao = cp_descricao;
    }

    public String getCp_categoria() {
        return cp_categoria;
    }

    public void setCp_categoria(String cp_categoria) {
        this.cp_categoria = cp_categoria;
    }

    public LocalDate getCp_data_emissao() {
        return cp_data_emissao;
    }

    public void setCp_data_emissao(LocalDate cp_data_emissao) {
        this.cp_data_emissao = cp_data_emissao;
    }

    public LocalDate getCp_data_vencimento() {
        return cp_data_vencimento;
    }

    public void setCp_data_vencimento(LocalDate cp_data_vencimento) {
        this.cp_data_vencimento = cp_data_vencimento;
    }

    public LocalDate getCp_data_pagamento() {
        return cp_data_pagamento;
    }

    public void setCp_data_pagamento(LocalDate cp_data_pagamento) {
        this.cp_data_pagamento = cp_data_pagamento;
    }

    public BigDecimal getCp_valor_original() {
        return cp_valor_original;
    }

    public void setCp_valor_original(BigDecimal cp_valor_original) {
        this.cp_valor_original = cp_valor_original;
    }

    public BigDecimal getCp_valor_desconto() {
        return cp_valor_desconto;
    }

    public void setCp_valor_desconto(BigDecimal cp_valor_desconto) {
        this.cp_valor_desconto = cp_valor_desconto;
    }

    public BigDecimal getCp_valor_juros() {
        return cp_valor_juros;
    }

    public void setCp_valor_juros(BigDecimal cp_valor_juros) {
        this.cp_valor_juros = cp_valor_juros;
    }

    public BigDecimal getCp_valor_multa() {
        return cp_valor_multa;
    }

    public void setCp_valor_multa(BigDecimal cp_valor_multa) {
        this.cp_valor_multa = cp_valor_multa;
    }

    public BigDecimal getCp_valor_pago() {
        return cp_valor_pago;
    }

    public void setCp_valor_pago(BigDecimal cp_valor_pago) {
        this.cp_valor_pago = cp_valor_pago;
    }

    public BigDecimal getCp_valor_saldo() {
        return cp_valor_saldo;
    }

    public void setCp_valor_saldo(BigDecimal cp_valor_saldo) {
        this.cp_valor_saldo = cp_valor_saldo;
    }

    public String getCp_status() {
        return cp_status;
    }

    public void setCp_status(String cp_status) {
        this.cp_status = cp_status;
    }

    public String getCp_tipo() {
        return cp_tipo;
    }

    public void setCp_tipo(String cp_tipo) {
        this.cp_tipo = cp_tipo;
    }

    public String getCp_forma_pagamento() {
        return cp_forma_pagamento;
    }

    public void setCp_forma_pagamento(String cp_forma_pagamento) {
        this.cp_forma_pagamento = cp_forma_pagamento;
    }

    public String getCp_numero_cheque() {
        return cp_numero_cheque;
    }

    public void setCp_numero_cheque(String cp_numero_cheque) {
        this.cp_numero_cheque = cp_numero_cheque;
    }

    public String getCp_banco() {
        return cp_banco;
    }

    public void setCp_banco(String cp_banco) {
        this.cp_banco = cp_banco;
    }

    public String getCp_agencia() {
        return cp_agencia;
    }

    public void setCp_agencia(String cp_agencia) {
        this.cp_agencia = cp_agencia;
    }

    public String getCp_conta() {
        return cp_conta;
    }

    public void setCp_conta(String cp_conta) {
        this.cp_conta = cp_conta;
    }

    public String getCp_observacoes() {
        return cp_observacoes;
    }

    public void setCp_observacoes(String cp_observacoes) {
        this.cp_observacoes = cp_observacoes;
    }

    public Integer getCp_numero_parcela() {
        return cp_numero_parcela;
    }

    public void setCp_numero_parcela(Integer cp_numero_parcela) {
        this.cp_numero_parcela = cp_numero_parcela;
    }

    public Integer getCp_total_parcelas() {
        return cp_total_parcelas;
    }

    public void setCp_total_parcelas(Integer cp_total_parcelas) {
        this.cp_total_parcelas = cp_total_parcelas;
    }

    public LocalDateTime getCp_data_cadastro() {
        return cp_data_cadastro;
    }

    public void setCp_data_cadastro(LocalDateTime cp_data_cadastro) {
        this.cp_data_cadastro = cp_data_cadastro;
    }

    public LocalDateTime getCp_data_atualizacao() {
        return cp_data_atualizacao;
    }

    public void setCp_data_atualizacao(LocalDateTime cp_data_atualizacao) {
        this.cp_data_atualizacao = cp_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.cp_data_cadastro = LocalDateTime.now();
        if (this.cp_data_emissao == null) {
            this.cp_data_emissao = LocalDate.now();
        }
        if (this.cp_valor_saldo == null && this.cp_valor_original != null) {
            this.cp_valor_saldo = this.cp_valor_original;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.cp_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(cp_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ContaPagar contaPagar = (ContaPagar) obj;
        return Objects.equals(cp_codigo, contaPagar.cp_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "ContaPagar{" +
                "cp_codigo=" + cp_codigo +
                ", cp_numero_documento='" + cp_numero_documento + '\'' +
                ", cp_descricao='" + cp_descricao + '\'' +
                ", cp_data_vencimento=" + cp_data_vencimento +
                ", cp_valor_original=" + cp_valor_original +
                ", cp_valor_saldo=" + cp_valor_saldo +
                ", cp_status='" + cp_status + '\'' +
                ", cp_tipo='" + cp_tipo + '\'' +
                '}';
    }
}
