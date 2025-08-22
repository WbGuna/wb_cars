package br.com.wbcars.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "estoque_peca")
@SequenceGenerator(name = "estoque_peca_seq", sequenceName = "estoque_peca_seq", initialValue = 1, allocationSize = 1)
@Audited
public class EstoquePeca implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_peca_seq")
    private Long est_codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_codigo", referencedColumnName = "pro_codigo", nullable = false)
    private Produto produto;

    @Column(name = "est_quantidade_atual", nullable = false)
    private Integer est_quantidade_atual = 0;

    @Column(name = "est_quantidade_minima")
    private Integer est_quantidade_minima = 0;

    @Column(name = "est_quantidade_maxima")
    private Integer est_quantidade_maxima = 0;

    @Column(name = "est_quantidade_reservada")
    private Integer est_quantidade_reservada = 0;

    @Column(name = "est_localizacao", length = 100)
    private String est_localizacao;

    @Column(name = "est_lote", length = 50)
    private String est_lote;

    @Column(name = "est_data_validade")
    private LocalDate est_data_validade;

    @Column(name = "est_data_fabricacao")
    private LocalDate est_data_fabricacao;

    @Column(name = "est_custo_medio", precision = 10, scale = 2)
    private BigDecimal est_custo_medio = BigDecimal.ZERO;

    @Column(name = "est_custo_ultima_compra", precision = 10, scale = 2)
    private BigDecimal est_custo_ultima_compra = BigDecimal.ZERO;

    @Column(name = "est_preco_venda", precision = 10, scale = 2)
    private BigDecimal est_preco_venda = BigDecimal.ZERO;

    @Column(name = "est_margem_lucro", precision = 5, scale = 2)
    private BigDecimal est_margem_lucro = BigDecimal.ZERO;

    @Column(name = "est_observacoes", columnDefinition = "TEXT")
    private String est_observacoes;

    @Column(name = "est_status", length = 20, nullable = false)
    private String est_status = "ATIVO"; // ATIVO, INATIVO, BLOQUEADO

    @Column(name = "est_tipo_movimentacao", length = 20)
    private String est_tipo_movimentacao; // ENTRADA, SAIDA, AJUSTE, TRANSFERENCIA

    @Column(name = "est_data_ultima_movimentacao")
    private LocalDateTime est_data_ultima_movimentacao;

    @Column(name = "est_data_cadastro", nullable = false)
    private LocalDateTime est_data_cadastro;

    @Column(name = "est_data_atualizacao")
    private LocalDateTime est_data_atualizacao;

    // Construtores
    public EstoquePeca() {
        this.est_data_cadastro = LocalDateTime.now();
    }

    public EstoquePeca(Produto produto, Integer quantidadeAtual) {
        this();
        this.produto = produto;
        this.est_quantidade_atual = quantidadeAtual;
    }

    // Getters e Setters
    public Long getEst_codigo() {
        return est_codigo;
    }

    public void setEst_codigo(Long est_codigo) {
        this.est_codigo = est_codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getEst_quantidade_atual() {
        return est_quantidade_atual;
    }

    public void setEst_quantidade_atual(Integer est_quantidade_atual) {
        this.est_quantidade_atual = est_quantidade_atual;
    }

    public Integer getEst_quantidade_minima() {
        return est_quantidade_minima;
    }

    public void setEst_quantidade_minima(Integer est_quantidade_minima) {
        this.est_quantidade_minima = est_quantidade_minima;
    }

    public Integer getEst_quantidade_maxima() {
        return est_quantidade_maxima;
    }

    public void setEst_quantidade_maxima(Integer est_quantidade_maxima) {
        this.est_quantidade_maxima = est_quantidade_maxima;
    }

    public Integer getEst_quantidade_reservada() {
        return est_quantidade_reservada;
    }

    public void setEst_quantidade_reservada(Integer est_quantidade_reservada) {
        this.est_quantidade_reservada = est_quantidade_reservada;
    }

    public String getEst_localizacao() {
        return est_localizacao;
    }

    public void setEst_localizacao(String est_localizacao) {
        this.est_localizacao = est_localizacao;
    }

    public String getEst_lote() {
        return est_lote;
    }

    public void setEst_lote(String est_lote) {
        this.est_lote = est_lote;
    }

    public LocalDate getEst_data_validade() {
        return est_data_validade;
    }

    public void setEst_data_validade(LocalDate est_data_validade) {
        this.est_data_validade = est_data_validade;
    }

    public LocalDate getEst_data_fabricacao() {
        return est_data_fabricacao;
    }

    public void setEst_data_fabricacao(LocalDate est_data_fabricacao) {
        this.est_data_fabricacao = est_data_fabricacao;
    }

    public BigDecimal getEst_custo_medio() {
        return est_custo_medio;
    }

    public void setEst_custo_medio(BigDecimal est_custo_medio) {
        this.est_custo_medio = est_custo_medio;
    }

    public BigDecimal getEst_custo_ultima_compra() {
        return est_custo_ultima_compra;
    }

    public void setEst_custo_ultima_compra(BigDecimal est_custo_ultima_compra) {
        this.est_custo_ultima_compra = est_custo_ultima_compra;
    }

    public BigDecimal getEst_preco_venda() {
        return est_preco_venda;
    }

    public void setEst_preco_venda(BigDecimal est_preco_venda) {
        this.est_preco_venda = est_preco_venda;
    }

    public BigDecimal getEst_margem_lucro() {
        return est_margem_lucro;
    }

    public void setEst_margem_lucro(BigDecimal est_margem_lucro) {
        this.est_margem_lucro = est_margem_lucro;
    }

    public String getEst_observacoes() {
        return est_observacoes;
    }

    public void setEst_observacoes(String est_observacoes) {
        this.est_observacoes = est_observacoes;
    }

    public String getEst_status() {
        return est_status;
    }

    public void setEst_status(String est_status) {
        this.est_status = est_status;
    }

    public String getEst_tipo_movimentacao() {
        return est_tipo_movimentacao;
    }

    public void setEst_tipo_movimentacao(String est_tipo_movimentacao) {
        this.est_tipo_movimentacao = est_tipo_movimentacao;
    }

    public LocalDateTime getEst_data_ultima_movimentacao() {
        return est_data_ultima_movimentacao;
    }

    public void setEst_data_ultima_movimentacao(LocalDateTime est_data_ultima_movimentacao) {
        this.est_data_ultima_movimentacao = est_data_ultima_movimentacao;
    }

    public LocalDateTime getEst_data_cadastro() {
        return est_data_cadastro;
    }

    public void setEst_data_cadastro(LocalDateTime est_data_cadastro) {
        this.est_data_cadastro = est_data_cadastro;
    }

    public LocalDateTime getEst_data_atualizacao() {
        return est_data_atualizacao;
    }

    public void setEst_data_atualizacao(LocalDateTime est_data_atualizacao) {
        this.est_data_atualizacao = est_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.est_data_cadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.est_data_atualizacao = LocalDateTime.now();
        this.est_data_ultima_movimentacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(est_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EstoquePeca estoquePeca = (EstoquePeca) obj;
        return Objects.equals(est_codigo, estoquePeca.est_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "EstoquePeca{" +
                "est_codigo=" + est_codigo +
                ", est_quantidade_atual=" + est_quantidade_atual +
                ", est_quantidade_minima=" + est_quantidade_minima +
                ", est_quantidade_maxima=" + est_quantidade_maxima +
                ", est_custo_medio=" + est_custo_medio +
                ", est_preco_venda=" + est_preco_venda +
                ", est_status='" + est_status + '\'' +
                '}';
    }
}
