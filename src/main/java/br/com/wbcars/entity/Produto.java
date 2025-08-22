package br.com.wbcars.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    private Long pro_codigo;

    @Column(name = "pro_nome", length = 255, nullable = false)
    private String pro_nome;

    @Column(name = "pro_descricao", columnDefinition = "TEXT")
    private String pro_descricao;

    @Column(name = "pro_codigo_barras", length = 50, unique = true)
    private String pro_codigo_barras;

    @Column(name = "pro_referencia", length = 100)
    private String pro_referencia;

    @Column(name = "pro_categoria", length = 100)
    private String pro_categoria;

    @Column(name = "pro_marca", length = 100)
    private String pro_marca;

    @Column(name = "pro_modelo", length = 100)
    private String pro_modelo;

    @Column(name = "pro_unidade_medida", length = 20, nullable = false)
    private String pro_unidade_medida;

    @Column(name = "pro_preco_custo", precision = 10, scale = 2)
    private BigDecimal pro_preco_custo;

    @Column(name = "pro_preco_venda", precision = 10, scale = 2, nullable = false)
    private BigDecimal pro_preco_venda;

    @Column(name = "pro_margem_lucro", precision = 5, scale = 2)
    private BigDecimal pro_margem_lucro;

    @Column(name = "pro_estoque_minimo")
    private Integer pro_estoque_minimo;

    @Column(name = "pro_estoque_maximo")
    private Integer pro_estoque_maximo;

    @Column(name = "pro_estoque_atual")
    private Integer pro_estoque_atual = 0;

    @Column(name = "pro_peso", precision = 8, scale = 3)
    private BigDecimal pro_peso;

    @Column(name = "pro_dimensoes", length = 100)
    private String pro_dimensoes;

    @Column(name = "pro_ncm", length = 20)
    private String pro_ncm;

    @Column(name = "pro_cst", length = 10)
    private String pro_cst;

    @Column(name = "pro_cfop", length = 10)
    private String pro_cfop;

    @Column(name = "pro_observacoes", columnDefinition = "TEXT")
    private String pro_observacoes;

    @Column(name = "pro_status", length = 20, nullable = false)
    private String pro_status = "ATIVO";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "for_codigo", referencedColumnName = "for_codigo")
    private Fornecedor fornecedor;

    @Column(name = "pro_data_cadastro", nullable = false)
    private LocalDateTime pro_data_cadastro;

    @Column(name = "pro_data_atualizacao")
    private LocalDateTime pro_data_atualizacao;

    // Construtores
    public Produto() {
        this.pro_data_cadastro = LocalDateTime.now();
    }

    public Produto(String nome, String unidadeMedida, BigDecimal precoVenda) {
        this();
        this.pro_nome = nome;
        this.pro_unidade_medida = unidadeMedida;
        this.pro_preco_venda = precoVenda;
    }

    // Getters e Setters
    public Long getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(Long pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public String getPro_nome() {
        return pro_nome;
    }

    public void setPro_nome(String pro_nome) {
        this.pro_nome = pro_nome;
    }

    public String getPro_descricao() {
        return pro_descricao;
    }

    public void setPro_descricao(String pro_descricao) {
        this.pro_descricao = pro_descricao;
    }

    public String getPro_codigo_barras() {
        return pro_codigo_barras;
    }

    public void setPro_codigo_barras(String pro_codigo_barras) {
        this.pro_codigo_barras = pro_codigo_barras;
    }

    public String getPro_referencia() {
        return pro_referencia;
    }

    public void setPro_referencia(String pro_referencia) {
        this.pro_referencia = pro_referencia;
    }

    public String getPro_categoria() {
        return pro_categoria;
    }

    public void setPro_categoria(String pro_categoria) {
        this.pro_categoria = pro_categoria;
    }

    public String getPro_marca() {
        return pro_marca;
    }

    public void setPro_marca(String pro_marca) {
        this.pro_marca = pro_marca;
    }

    public String getPro_modelo() {
        return pro_modelo;
    }

    public void setPro_modelo(String pro_modelo) {
        this.pro_modelo = pro_modelo;
    }

    public String getPro_unidade_medida() {
        return pro_unidade_medida;
    }

    public void setPro_unidade_medida(String pro_unidade_medida) {
        this.pro_unidade_medida = pro_unidade_medida;
    }

    public BigDecimal getPro_preco_custo() {
        return pro_preco_custo;
    }

    public void setPro_preco_custo(BigDecimal pro_preco_custo) {
        this.pro_preco_custo = pro_preco_custo;
    }

    public BigDecimal getPro_preco_venda() {
        return pro_preco_venda;
    }

    public void setPro_preco_venda(BigDecimal pro_preco_venda) {
        this.pro_preco_venda = pro_preco_venda;
    }

    public BigDecimal getPro_margem_lucro() {
        return pro_margem_lucro;
    }

    public void setPro_margem_lucro(BigDecimal pro_margem_lucro) {
        this.pro_margem_lucro = pro_margem_lucro;
    }

    public Integer getPro_estoque_minimo() {
        return pro_estoque_minimo;
    }

    public void setPro_estoque_minimo(Integer pro_estoque_minimo) {
        this.pro_estoque_minimo = pro_estoque_minimo;
    }

    public Integer getPro_estoque_maximo() {
        return pro_estoque_maximo;
    }

    public void setPro_estoque_maximo(Integer pro_estoque_maximo) {
        this.pro_estoque_maximo = pro_estoque_maximo;
    }

    public Integer getPro_estoque_atual() {
        return pro_estoque_atual;
    }

    public void setPro_estoque_atual(Integer pro_estoque_atual) {
        this.pro_estoque_atual = pro_estoque_atual;
    }

    public BigDecimal getPro_peso() {
        return pro_peso;
    }

    public void setPro_peso(BigDecimal pro_peso) {
        this.pro_peso = pro_peso;
    }

    public String getPro_dimensoes() {
        return pro_dimensoes;
    }

    public void setPro_dimensoes(String pro_dimensoes) {
        this.pro_dimensoes = pro_dimensoes;
    }

    public String getPro_ncm() {
        return pro_ncm;
    }

    public void setPro_ncm(String pro_ncm) {
        this.pro_ncm = pro_ncm;
    }

    public String getPro_cst() {
        return pro_cst;
    }

    public void setPro_cst(String pro_cst) {
        this.pro_cst = pro_cst;
    }

    public String getPro_cfop() {
        return pro_cfop;
    }

    public void setPro_cfop(String pro_cfop) {
        this.pro_cfop = pro_cfop;
    }

    public String getPro_observacoes() {
        return pro_observacoes;
    }

    public void setPro_observacoes(String pro_observacoes) {
        this.pro_observacoes = pro_observacoes;
    }

    public String getPro_status() {
        return pro_status;
    }

    public void setPro_status(String pro_status) {
        this.pro_status = pro_status;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDateTime getPro_data_cadastro() {
        return pro_data_cadastro;
    }

    public void setPro_data_cadastro(LocalDateTime pro_data_cadastro) {
        this.pro_data_cadastro = pro_data_cadastro;
    }

    public LocalDateTime getPro_data_atualizacao() {
        return pro_data_atualizacao;
    }

    public void setPro_data_atualizacao(LocalDateTime pro_data_atualizacao) {
        this.pro_data_atualizacao = pro_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.pro_data_cadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.pro_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(pro_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return Objects.equals(pro_codigo, produto.pro_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "Produto{" +
                "pro_codigo=" + pro_codigo +
                ", pro_nome='" + pro_nome + '\'' +
                ", pro_descricao='" + pro_descricao + '\'' +
                ", pro_unidade_medida='" + pro_unidade_medida + '\'' +
                ", pro_preco_venda=" + pro_preco_venda +
                ", pro_estoque_atual=" + pro_estoque_atual +
                ", pro_status='" + pro_status + '\'' +
                '}';
    }
}
