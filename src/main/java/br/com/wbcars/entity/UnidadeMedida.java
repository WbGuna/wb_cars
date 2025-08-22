package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "unidade_medida")
@SequenceGenerator(name = "unidade_medida_seq", sequenceName = "unidade_medida_seq", initialValue = 1, allocationSize = 1)
@Audited
public class UnidadeMedida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidade_medida_seq")
    private Long uni_codigo;

    @Column(name = "uni_nome", length = 100, nullable = false, unique = true)
    private String uni_nome;

    @Column(name = "uni_sigla", length = 10, nullable = false, unique = true)
    private String uni_sigla;

    @Column(name = "uni_descricao", columnDefinition = "TEXT")
    private String uni_descricao;

    @Column(name = "uni_tipo", length = 50)
    private String uni_tipo; // PESO, VOLUME, COMPRIMENTO, AREA, UNIDADE

    @Column(name = "uni_fator_conversao", precision = 10, scale = 6)
    private java.math.BigDecimal uni_fator_conversao;

    @Column(name = "uni_unidade_base", length = 10)
    private String uni_unidade_base;

    @Column(name = "uni_status", length = 20, nullable = false)
    private String uni_status = "ATIVO";

    @Column(name = "uni_data_cadastro", nullable = false)
    private LocalDateTime uni_data_cadastro;

    @Column(name = "uni_data_atualizacao")
    private LocalDateTime uni_data_atualizacao;

    // Construtores
    public UnidadeMedida() {
        this.uni_data_cadastro = LocalDateTime.now();
    }

    public UnidadeMedida(String nome, String sigla) {
        this();
        this.uni_nome = nome;
        this.uni_sigla = sigla;
    }

    // Getters e Setters
    public Long getUni_codigo() {
        return uni_codigo;
    }

    public void setUni_codigo(Long uni_codigo) {
        this.uni_codigo = uni_codigo;
    }

    public String getUni_nome() {
        return uni_nome;
    }

    public void setUni_nome(String uni_nome) {
        this.uni_nome = uni_nome;
    }

    public String getUni_sigla() {
        return uni_sigla;
    }

    public void setUni_sigla(String uni_sigla) {
        this.uni_sigla = uni_sigla;
    }

    public String getUni_descricao() {
        return uni_descricao;
    }

    public void setUni_descricao(String uni_descricao) {
        this.uni_descricao = uni_descricao;
    }

    public String getUni_tipo() {
        return uni_tipo;
    }

    public void setUni_tipo(String uni_tipo) {
        this.uni_tipo = uni_tipo;
    }

    public java.math.BigDecimal getUni_fator_conversao() {
        return uni_fator_conversao;
    }

    public void setUni_fator_conversao(java.math.BigDecimal uni_fator_conversao) {
        this.uni_fator_conversao = uni_fator_conversao;
    }

    public String getUni_unidade_base() {
        return uni_unidade_base;
    }

    public void setUni_unidade_base(String uni_unidade_base) {
        this.uni_unidade_base = uni_unidade_base;
    }

    public String getUni_status() {
        return uni_status;
    }

    public void setUni_status(String uni_status) {
        this.uni_status = uni_status;
    }

    public LocalDateTime getUni_data_cadastro() {
        return uni_data_cadastro;
    }

    public void setUni_data_cadastro(LocalDateTime uni_data_cadastro) {
        this.uni_data_cadastro = uni_data_cadastro;
    }

    public LocalDateTime getUni_data_atualizacao() {
        return uni_data_atualizacao;
    }

    public void setUni_data_atualizacao(LocalDateTime uni_data_atualizacao) {
        this.uni_data_atualizacao = uni_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.uni_data_cadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.uni_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(uni_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UnidadeMedida unidadeMedida = (UnidadeMedida) obj;
        return Objects.equals(uni_codigo, unidadeMedida.uni_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "UnidadeMedida{" +
                "uni_codigo=" + uni_codigo +
                ", uni_nome='" + uni_nome + '\'' +
                ", uni_sigla='" + uni_sigla + '\'' +
                ", uni_tipo='" + uni_tipo + '\'' +
                ", uni_status='" + uni_status + '\'' +
                '}';
    }
}
