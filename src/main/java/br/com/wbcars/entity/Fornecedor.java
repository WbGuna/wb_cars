package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "fornecedor")
@SequenceGenerator(name = "fornecedor_seq", sequenceName = "fornecedor_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor_seq")
    private Long for_codigo;

    @Column(name = "for_nome", length = 255, nullable = false)
    private String for_nome;

    @Column(name = "for_razao_social", length = 255)
    private String for_razao_social;

    @Column(name = "for_cnpj_cpf", length = 20, unique = true)
    private String for_cnpj_cpf;

    @Column(name = "for_tipo_pessoa", length = 10, nullable = false)
    private String for_tipo_pessoa; // FISICA ou JURIDICA

    @Column(name = "for_inscricao_estadual", length = 30)
    private String for_inscricao_estadual;

    @Column(name = "for_email", length = 150)
    private String for_email;

    @Column(name = "for_telefone", length = 20)
    private String for_telefone;

    @Column(name = "for_celular", length = 20)
    private String for_celular;

    @Column(name = "for_endereco", length = 255)
    private String for_endereco;

    @Column(name = "for_numero", length = 10)
    private String for_numero;

    @Column(name = "for_complemento", length = 100)
    private String for_complemento;

    @Column(name = "for_bairro", length = 100)
    private String for_bairro;

    @Column(name = "for_cep", length = 10)
    private String for_cep;

    @Column(name = "for_cidade", length = 100)
    private String for_cidade;

    @Column(name = "for_estado", length = 2)
    private String for_estado;

    @Column(name = "for_observacoes", columnDefinition = "TEXT")
    private String for_observacoes;

    @Column(name = "for_status", length = 20, nullable = false)
    private String for_status = "ATIVO";

    @Column(name = "for_data_cadastro", nullable = false)
    private LocalDateTime for_data_cadastro;

    @Column(name = "for_data_atualizacao")
    private LocalDateTime for_data_atualizacao;

    // Construtores
    public Fornecedor() {
        this.for_data_cadastro = LocalDateTime.now();
    }

    public Fornecedor(String nome, String tipoPessoa) {
        this();
        this.for_nome = nome;
        this.for_tipo_pessoa = tipoPessoa;
    }

    // Getters e Setters
    public Long getFor_codigo() {
        return for_codigo;
    }

    public void setFor_codigo(Long for_codigo) {
        this.for_codigo = for_codigo;
    }

    public String getFor_nome() {
        return for_nome;
    }

    public void setFor_nome(String for_nome) {
        this.for_nome = for_nome;
    }

    public String getFor_razao_social() {
        return for_razao_social;
    }

    public void setFor_razao_social(String for_razao_social) {
        this.for_razao_social = for_razao_social;
    }

    public String getFor_cnpj_cpf() {
        return for_cnpj_cpf;
    }

    public void setFor_cnpj_cpf(String for_cnpj_cpf) {
        this.for_cnpj_cpf = for_cnpj_cpf;
    }

    public String getFor_tipo_pessoa() {
        return for_tipo_pessoa;
    }

    public void setFor_tipo_pessoa(String for_tipo_pessoa) {
        this.for_tipo_pessoa = for_tipo_pessoa;
    }

    public String getFor_inscricao_estadual() {
        return for_inscricao_estadual;
    }

    public void setFor_inscricao_estadual(String for_inscricao_estadual) {
        this.for_inscricao_estadual = for_inscricao_estadual;
    }

    public String getFor_email() {
        return for_email;
    }

    public void setFor_email(String for_email) {
        this.for_email = for_email;
    }

    public String getFor_telefone() {
        return for_telefone;
    }

    public void setFor_telefone(String for_telefone) {
        this.for_telefone = for_telefone;
    }

    public String getFor_celular() {
        return for_celular;
    }

    public void setFor_celular(String for_celular) {
        this.for_celular = for_celular;
    }

    public String getFor_endereco() {
        return for_endereco;
    }

    public void setFor_endereco(String for_endereco) {
        this.for_endereco = for_endereco;
    }

    public String getFor_numero() {
        return for_numero;
    }

    public void setFor_numero(String for_numero) {
        this.for_numero = for_numero;
    }

    public String getFor_complemento() {
        return for_complemento;
    }

    public void setFor_complemento(String for_complemento) {
        this.for_complemento = for_complemento;
    }

    public String getFor_bairro() {
        return for_bairro;
    }

    public void setFor_bairro(String for_bairro) {
        this.for_bairro = for_bairro;
    }

    public String getFor_cep() {
        return for_cep;
    }

    public void setFor_cep(String for_cep) {
        this.for_cep = for_cep;
    }

    public String getFor_cidade() {
        return for_cidade;
    }

    public void setFor_cidade(String for_cidade) {
        this.for_cidade = for_cidade;
    }

    public String getFor_estado() {
        return for_estado;
    }

    public void setFor_estado(String for_estado) {
        this.for_estado = for_estado;
    }

    public String getFor_observacoes() {
        return for_observacoes;
    }

    public void setFor_observacoes(String for_observacoes) {
        this.for_observacoes = for_observacoes;
    }

    public String getFor_status() {
        return for_status;
    }

    public void setFor_status(String for_status) {
        this.for_status = for_status;
    }

    public LocalDateTime getFor_data_cadastro() {
        return for_data_cadastro;
    }

    public void setFor_data_cadastro(LocalDateTime for_data_cadastro) {
        this.for_data_cadastro = for_data_cadastro;
    }

    public LocalDateTime getFor_data_atualizacao() {
        return for_data_atualizacao;
    }

    public void setFor_data_atualizacao(LocalDateTime for_data_atualizacao) {
        this.for_data_atualizacao = for_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.for_data_cadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.for_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(for_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fornecedor fornecedor = (Fornecedor) obj;
        return Objects.equals(for_codigo, fornecedor.for_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "Fornecedor{" +
                "for_codigo=" + for_codigo +
                ", for_nome='" + for_nome + '\'' +
                ", for_razao_social='" + for_razao_social + '\'' +
                ", for_cnpj_cpf='" + for_cnpj_cpf + '\'' +
                ", for_tipo_pessoa='" + for_tipo_pessoa + '\'' +
                ", for_status='" + for_status + '\'' +
                '}';
    }
}
