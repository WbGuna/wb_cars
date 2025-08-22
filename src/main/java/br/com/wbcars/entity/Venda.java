package br.com.wbcars.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "venda")
@SequenceGenerator(name = "venda_seq", sequenceName = "venda_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
    private Long ven_codigo;

    @Column(name = "ven_numero", length = 20, unique = true, nullable = false)
    private String ven_numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "os_codigo", referencedColumnName = "os_codigo")
    private OrdemServico ordemServico;

    @Column(name = "ven_data_venda", nullable = false)
    private LocalDate ven_data_venda;

    @Column(name = "ven_data_entrega")
    private LocalDate ven_data_entrega;

    @Column(name = "ven_observacoes", columnDefinition = "TEXT")
    private String ven_observacoes;

    @Column(name = "ven_valor_produtos", precision = 10, scale = 2)
    private BigDecimal ven_valor_produtos = BigDecimal.ZERO;

    @Column(name = "ven_valor_servicos", precision = 10, scale = 2)
    private BigDecimal ven_valor_servicos = BigDecimal.ZERO;

    @Column(name = "ven_valor_desconto", precision = 10, scale = 2)
    private BigDecimal ven_valor_desconto = BigDecimal.ZERO;

    @Column(name = "ven_valor_acrescimo", precision = 10, scale = 2)
    private BigDecimal ven_valor_acrescimo = BigDecimal.ZERO;

    @Column(name = "ven_valor_total", precision = 10, scale = 2, nullable = false)
    private BigDecimal ven_valor_total = BigDecimal.ZERO;

    @Column(name = "ven_status", length = 20, nullable = false)
    private String ven_status = "PENDENTE"; // PENDENTE, FINALIZADA, CANCELADA, ENTREGUE

    @Column(name = "ven_tipo", length = 20, nullable = false)
    private String ven_tipo = "VENDA"; // VENDA, SERVICO, MISTA

    @Column(name = "ven_forma_pagamento", length = 50)
    private String ven_forma_pagamento;

    @Column(name = "ven_condicoes_pagamento", columnDefinition = "TEXT")
    private String ven_condicoes_pagamento;

    @Column(name = "ven_numero_parcelas")
    private Integer ven_numero_parcelas = 1;

    @Column(name = "ven_valor_entrada", precision = 10, scale = 2)
    private BigDecimal ven_valor_entrada = BigDecimal.ZERO;

    @Column(name = "ven_valor_financiado", precision = 10, scale = 2)
    private BigDecimal ven_valor_financiado = BigDecimal.ZERO;

    @Column(name = "ven_percentual_comissao", precision = 5, scale = 2)
    private BigDecimal ven_percentual_comissao = BigDecimal.ZERO;

    @Column(name = "ven_valor_comissao", precision = 10, scale = 2)
    private BigDecimal ven_valor_comissao = BigDecimal.ZERO;

    @Column(name = "ven_data_cadastro", nullable = false)
    private LocalDateTime ven_data_cadastro;

    @Column(name = "ven_data_atualizacao")
    private LocalDateTime ven_data_atualizacao;

    // Construtores
    public Venda() {
        this.ven_data_cadastro = LocalDateTime.now();
        this.ven_data_venda = LocalDate.now();
    }

    public Venda(String numero, Cliente cliente, Funcionario funcionario) {
        this();
        this.ven_numero = numero;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    // Getters e Setters
    public Long getVen_codigo() {
        return ven_codigo;
    }

    public void setVen_codigo(Long ven_codigo) {
        this.ven_codigo = ven_codigo;
    }

    public String getVen_numero() {
        return ven_numero;
    }

    public void setVen_numero(String ven_numero) {
        this.ven_numero = ven_numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public LocalDate getVen_data_venda() {
        return ven_data_venda;
    }

    public void setVen_data_venda(LocalDate ven_data_venda) {
        this.ven_data_venda = ven_data_venda;
    }

    public LocalDate getVen_data_entrega() {
        return ven_data_entrega;
    }

    public void setVen_data_entrega(LocalDate ven_data_entrega) {
        this.ven_data_entrega = ven_data_entrega;
    }

    public String getVen_observacoes() {
        return ven_observacoes;
    }

    public void setVen_observacoes(String ven_observacoes) {
        this.ven_observacoes = ven_observacoes;
    }

    public BigDecimal getVen_valor_produtos() {
        return ven_valor_produtos;
    }

    public void setVen_valor_produtos(BigDecimal ven_valor_produtos) {
        this.ven_valor_produtos = ven_valor_produtos;
    }

    public BigDecimal getVen_valor_servicos() {
        return ven_valor_servicos;
    }

    public void setVen_valor_servicos(BigDecimal ven_valor_servicos) {
        this.ven_valor_servicos = ven_valor_servicos;
    }

    public BigDecimal getVen_valor_desconto() {
        return ven_valor_desconto;
    }

    public void setVen_valor_desconto(BigDecimal ven_valor_desconto) {
        this.ven_valor_desconto = ven_valor_desconto;
    }

    public BigDecimal getVen_valor_acrescimo() {
        return ven_valor_acrescimo;
    }

    public void setVen_valor_acrescimo(BigDecimal ven_valor_acrescimo) {
        this.ven_valor_acrescimo = ven_valor_acrescimo;
    }

    public BigDecimal getVen_valor_total() {
        return ven_valor_total;
    }

    public void setVen_valor_total(BigDecimal ven_valor_total) {
        this.ven_valor_total = ven_valor_total;
    }

    public String getVen_status() {
        return ven_status;
    }

    public void setVen_status(String ven_status) {
        this.ven_status = ven_status;
    }

    public String getVen_tipo() {
        return ven_tipo;
    }

    public void setVen_tipo(String ven_tipo) {
        this.ven_tipo = ven_tipo;
    }

    public String getVen_forma_pagamento() {
        return ven_forma_pagamento;
    }

    public void setVen_forma_pagamento(String ven_forma_pagamento) {
        this.ven_forma_pagamento = ven_forma_pagamento;
    }

    public String getVen_condicoes_pagamento() {
        return ven_condicoes_pagamento;
    }

    public void setVen_condicoes_pagamento(String ven_condicoes_pagamento) {
        this.ven_condicoes_pagamento = ven_condicoes_pagamento;
    }

    public Integer getVen_numero_parcelas() {
        return ven_numero_parcelas;
    }

    public void setVen_numero_parcelas(Integer ven_numero_parcelas) {
        this.ven_numero_parcelas = ven_numero_parcelas;
    }

    public BigDecimal getVen_valor_entrada() {
        return ven_valor_entrada;
    }

    public void setVen_valor_entrada(BigDecimal ven_valor_entrada) {
        this.ven_valor_entrada = ven_valor_entrada;
    }

    public BigDecimal getVen_valor_financiado() {
        return ven_valor_financiado;
    }

    public void setVen_valor_financiado(BigDecimal ven_valor_financiado) {
        this.ven_valor_financiado = ven_valor_financiado;
    }

    public BigDecimal getVen_percentual_comissao() {
        return ven_percentual_comissao;
    }

    public void setVen_percentual_comissao(BigDecimal ven_percentual_comissao) {
        this.ven_percentual_comissao = ven_percentual_comissao;
    }

    public BigDecimal getVen_valor_comissao() {
        return ven_valor_comissao;
    }

    public void setVen_valor_comissao(BigDecimal ven_valor_comissao) {
        this.ven_valor_comissao = ven_valor_comissao;
    }

    public LocalDateTime getVen_data_cadastro() {
        return ven_data_cadastro;
    }

    public void setVen_data_cadastro(LocalDateTime ven_data_cadastro) {
        this.ven_data_cadastro = ven_data_cadastro;
    }

    public LocalDateTime getVen_data_atualizacao() {
        return ven_data_atualizacao;
    }

    public void setVen_data_atualizacao(LocalDateTime ven_data_atualizacao) {
        this.ven_data_atualizacao = ven_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.ven_data_cadastro = LocalDateTime.now();
        if (this.ven_data_venda == null) {
            this.ven_data_venda = LocalDate.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.ven_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(ven_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Venda venda = (Venda) obj;
        return Objects.equals(ven_codigo, venda.ven_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "Venda{" +
                "ven_codigo=" + ven_codigo +
                ", ven_numero='" + ven_numero + '\'' +
                ", ven_data_venda=" + ven_data_venda +
                ", ven_valor_total=" + ven_valor_total +
                ", ven_status='" + ven_status + '\'' +
                ", ven_tipo='" + ven_tipo + '\'' +
                '}';
    }
}
