package br.com.wbcars.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "relatorio_financeiro")
@SequenceGenerator(name = "relatorio_financeiro_seq", sequenceName = "relatorio_financeiro_seq", initialValue = 1, allocationSize = 1)
@Audited
public class RelatorioFinanceiro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relatorio_financeiro_seq")
    private Long rel_codigo;

    @Column(name = "rel_titulo", length = 255, nullable = false)
    private String rel_titulo;

    @Column(name = "rel_tipo", length = 50, nullable = false)
    private String rel_tipo; // RECEITA, DESPESA, FLUXO_CAIXA, BALANCETE, DRE

    @Column(name = "rel_periodo", length = 20, nullable = false)
    private String rel_periodo; // DIARIO, SEMANAL, MENSAL, ANUAL, PERSONALIZADO

    @Column(name = "rel_data_inicio", nullable = false)
    private LocalDate rel_data_inicio;

    @Column(name = "rel_data_fim", nullable = false)
    private LocalDate rel_data_fim;

    @Column(name = "rel_valor_total_receitas", precision = 15, scale = 2)
    private BigDecimal rel_valor_total_receitas = BigDecimal.ZERO;

    @Column(name = "rel_valor_total_despesas", precision = 15, scale = 2)
    private BigDecimal rel_valor_total_despesas = BigDecimal.ZERO;

    @Column(name = "rel_valor_saldo", precision = 15, scale = 2)
    private BigDecimal rel_valor_saldo = BigDecimal.ZERO;

    @Column(name = "rel_valor_vendas", precision = 15, scale = 2)
    private BigDecimal rel_valor_vendas = BigDecimal.ZERO;

    @Column(name = "rel_valor_servicos", precision = 15, scale = 2)
    private BigDecimal rel_valor_servicos = BigDecimal.ZERO;

    @Column(name = "rel_valor_produtos", precision = 15, scale = 2)
    private BigDecimal rel_valor_produtos = BigDecimal.ZERO;

    @Column(name = "rel_quantidade_vendas")
    private Integer rel_quantidade_vendas = 0;

    @Column(name = "rel_quantidade_servicos")
    private Integer rel_quantidade_servicos = 0;

    @Column(name = "rel_quantidade_os")
    private Integer rel_quantidade_os = 0;

    @Column(name = "rel_ticket_medio", precision = 10, scale = 2)
    private BigDecimal rel_ticket_medio = BigDecimal.ZERO;

    @Column(name = "rel_observacoes", columnDefinition = "TEXT")
    private String rel_observacoes;

    @Column(name = "rel_parametros", columnDefinition = "TEXT")
    private String rel_parametros;

    @Column(name = "rel_status", length = 20, nullable = false)
    private String rel_status = "GERADO"; // GERADO, PROCESSANDO, ERRO

    @Column(name = "usu_codigo", nullable = false)
    private Long usuarioId;

    @Column(name = "rel_data_geracao", nullable = false)
    private LocalDateTime rel_data_geracao;

    @Column(name = "rel_data_cadastro", nullable = false)
    private LocalDateTime rel_data_cadastro;

    @Column(name = "rel_data_atualizacao")
    private LocalDateTime rel_data_atualizacao;

    // Construtores
    public RelatorioFinanceiro() {
        this.rel_data_cadastro = LocalDateTime.now();
        this.rel_data_geracao = LocalDateTime.now();
    }

    public RelatorioFinanceiro(String titulo, String tipo, String periodo, LocalDate dataInicio, LocalDate dataFim, Long usuarioId) {
        this();
        this.rel_titulo = titulo;
        this.rel_tipo = tipo;
        this.rel_periodo = periodo;
        this.rel_data_inicio = dataInicio;
        this.rel_data_fim = dataFim;
        this.usuarioId = usuarioId;
    }

    // Getters e Setters
    public Long getRel_codigo() {
        return rel_codigo;
    }

    public void setRel_codigo(Long rel_codigo) {
        this.rel_codigo = rel_codigo;
    }

    public String getRel_titulo() {
        return rel_titulo;
    }

    public void setRel_titulo(String rel_titulo) {
        this.rel_titulo = rel_titulo;
    }

    public String getRel_tipo() {
        return rel_tipo;
    }

    public void setRel_tipo(String rel_tipo) {
        this.rel_tipo = rel_tipo;
    }

    public String getRel_periodo() {
        return rel_periodo;
    }

    public void setRel_periodo(String rel_periodo) {
        this.rel_periodo = rel_periodo;
    }

    public LocalDate getRel_data_inicio() {
        return rel_data_inicio;
    }

    public void setRel_data_inicio(LocalDate rel_data_inicio) {
        this.rel_data_inicio = rel_data_inicio;
    }

    public LocalDate getRel_data_fim() {
        return rel_data_fim;
    }

    public void setRel_data_fim(LocalDate rel_data_fim) {
        this.rel_data_fim = rel_data_fim;
    }

    public BigDecimal getRel_valor_total_receitas() {
        return rel_valor_total_receitas;
    }

    public void setRel_valor_total_receitas(BigDecimal rel_valor_total_receitas) {
        this.rel_valor_total_receitas = rel_valor_total_receitas;
    }

    public BigDecimal getRel_valor_total_despesas() {
        return rel_valor_total_despesas;
    }

    public void setRel_valor_total_despesas(BigDecimal rel_valor_total_despesas) {
        this.rel_valor_total_despesas = rel_valor_total_despesas;
    }

    public BigDecimal getRel_valor_saldo() {
        return rel_valor_saldo;
    }

    public void setRel_valor_saldo(BigDecimal rel_valor_saldo) {
        this.rel_valor_saldo = rel_valor_saldo;
    }

    public BigDecimal getRel_valor_vendas() {
        return rel_valor_vendas;
    }

    public void setRel_valor_vendas(BigDecimal rel_valor_vendas) {
        this.rel_valor_vendas = rel_valor_vendas;
    }

    public BigDecimal getRel_valor_servicos() {
        return rel_valor_servicos;
    }

    public void setRel_valor_servicos(BigDecimal rel_valor_servicos) {
        this.rel_valor_servicos = rel_valor_servicos;
    }

    public BigDecimal getRel_valor_produtos() {
        return rel_valor_produtos;
    }

    public void setRel_valor_produtos(BigDecimal rel_valor_produtos) {
        this.rel_valor_produtos = rel_valor_produtos;
    }

    public Integer getRel_quantidade_vendas() {
        return rel_quantidade_vendas;
    }

    public void setRel_quantidade_vendas(Integer rel_quantidade_vendas) {
        this.rel_quantidade_vendas = rel_quantidade_vendas;
    }

    public Integer getRel_quantidade_servicos() {
        return rel_quantidade_servicos;
    }

    public void setRel_quantidade_servicos(Integer rel_quantidade_servicos) {
        this.rel_quantidade_servicos = rel_quantidade_servicos;
    }

    public Integer getRel_quantidade_os() {
        return rel_quantidade_os;
    }

    public void setRel_quantidade_os(Integer rel_quantidade_os) {
        this.rel_quantidade_os = rel_quantidade_os;
    }

    public BigDecimal getRel_ticket_medio() {
        return rel_ticket_medio;
    }

    public void setRel_ticket_medio(BigDecimal rel_ticket_medio) {
        this.rel_ticket_medio = rel_ticket_medio;
    }

    public String getRel_observacoes() {
        return rel_observacoes;
    }

    public void setRel_observacoes(String rel_observacoes) {
        this.rel_observacoes = rel_observacoes;
    }

    public String getRel_parametros() {
        return rel_parametros;
    }

    public void setRel_parametros(String rel_parametros) {
        this.rel_parametros = rel_parametros;
    }

    public String getRel_status() {
        return rel_status;
    }

    public void setRel_status(String rel_status) {
        this.rel_status = rel_status;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getRel_data_geracao() {
        return rel_data_geracao;
    }

    public void setRel_data_geracao(LocalDateTime rel_data_geracao) {
        this.rel_data_geracao = rel_data_geracao;
    }

    public LocalDateTime getRel_data_cadastro() {
        return rel_data_cadastro;
    }

    public void setRel_data_cadastro(LocalDateTime rel_data_cadastro) {
        this.rel_data_cadastro = rel_data_cadastro;
    }

    public LocalDateTime getRel_data_atualizacao() {
        return rel_data_atualizacao;
    }

    public void setRel_data_atualizacao(LocalDateTime rel_data_atualizacao) {
        this.rel_data_atualizacao = rel_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.rel_data_cadastro = LocalDateTime.now();
        if (this.rel_data_geracao == null) {
            this.rel_data_geracao = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.rel_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(rel_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RelatorioFinanceiro relatorio = (RelatorioFinanceiro) obj;
        return Objects.equals(rel_codigo, relatorio.rel_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "RelatorioFinanceiro{" +
                "rel_codigo=" + rel_codigo +
                ", rel_titulo='" + rel_titulo + '\'' +
                ", rel_tipo='" + rel_tipo + '\'' +
                ", rel_periodo='" + rel_periodo + '\'' +
                ", rel_data_inicio=" + rel_data_inicio +
                ", rel_data_fim=" + rel_data_fim +
                ", rel_valor_saldo=" + rel_valor_saldo +
                ", rel_status='" + rel_status + '\'' +
                '}';
    }
}
