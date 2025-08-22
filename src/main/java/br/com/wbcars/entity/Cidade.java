package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "cidade")
@SequenceGenerator(name = "cidade_seq", sequenceName = "cidade_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_seq")
    private Long cid_codigo;

    @Column(name = "cid_nome", length = 100, nullable = false)
    private String cid_nome;

    @Column(name = "cid_estado", length = 2, nullable = false)
    private String cid_estado;

    @Column(name = "cid_codigo_ibge", length = 10)
    private String cid_codigo_ibge;

    @Column(name = "cid_cep", length = 10)
    private String cid_cep;

    @Column(name = "cid_status", length = 20, nullable = false)
    private String cid_status = "ATIVO";

    @Column(name = "cid_data_cadastro", nullable = false)
    private LocalDateTime cid_data_cadastro;

    @Column(name = "cid_data_atualizacao")
    private LocalDateTime cid_data_atualizacao;

    // Construtores
    public Cidade() {
        this.cid_data_cadastro = LocalDateTime.now();
    }

    public Cidade(String nome, String estado) {
        this();
        this.cid_nome = nome;
        this.cid_estado = estado;
    }

    // Getters e Setters
    public Long getCid_codigo() {
        return cid_codigo;
    }

    public void setCid_codigo(Long cid_codigo) {
        this.cid_codigo = cid_codigo;
    }

    public String getCid_nome() {
        return cid_nome;
    }

    public void setCid_nome(String cid_nome) {
        this.cid_nome = cid_nome;
    }

    public String getCid_estado() {
        return cid_estado;
    }

    public void setCid_estado(String cid_estado) {
        this.cid_estado = cid_estado;
    }

    public String getCid_codigo_ibge() {
        return cid_codigo_ibge;
    }

    public void setCid_codigo_ibge(String cid_codigo_ibge) {
        this.cid_codigo_ibge = cid_codigo_ibge;
    }

    public String getCid_cep() {
        return cid_cep;
    }

    public void setCid_cep(String cid_cep) {
        this.cid_cep = cid_cep;
    }

    public String getCid_status() {
        return cid_status;
    }

    public void setCid_status(String cid_status) {
        this.cid_status = cid_status;
    }

    public LocalDateTime getCid_data_cadastro() {
        return cid_data_cadastro;
    }

    public void setCid_data_cadastro(LocalDateTime cid_data_cadastro) {
        this.cid_data_cadastro = cid_data_cadastro;
    }

    public LocalDateTime getCid_data_atualizacao() {
        return cid_data_atualizacao;
    }

    public void setCid_data_atualizacao(LocalDateTime cid_data_atualizacao) {
        this.cid_data_atualizacao = cid_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.cid_data_cadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.cid_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(cid_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cidade cidade = (Cidade) obj;
        return Objects.equals(cid_codigo, cidade.cid_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "Cidade{" +
                "cid_codigo=" + cid_codigo +
                ", cid_nome='" + cid_nome + '\'' +
                ", cid_estado='" + cid_estado + '\'' +
                ", cid_status='" + cid_status + '\'' +
                '}';
    }
}
