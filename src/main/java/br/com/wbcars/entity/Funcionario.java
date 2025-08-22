package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "funcionario")
@SequenceGenerator(name = "funcionario_seq", sequenceName = "funcionario_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_seq")
    private Long fun_codigo;

    @Column(name = "fun_nome", length = 200, nullable = false)
    private String fun_nome;

    @Column(name = "fun_cpf", length = 14, unique = true, nullable = false)
    private String fun_cpf;

    @Column(name = "fun_rg", length = 20)
    private String fun_rg;

    @Column(name = "fun_data_nascimento")
    private LocalDate fun_data_nascimento;

    @Column(name = "fun_email", length = 150)
    private String fun_email;

    @Column(name = "fun_telefone", length = 20)
    private String fun_telefone;

    @Column(name = "fun_celular", length = 20)
    private String fun_celular;

    @Column(name = "fun_endereco", length = 255)
    private String fun_endereco;

    @Column(name = "fun_numero", length = 10)
    private String fun_numero;

    @Column(name = "fun_bairro", length = 100)
    private String fun_bairro;

    @Column(name = "fun_cep", length = 10)
    private String fun_cep;

    @Column(name = "fun_cidade", length = 100)
    private String fun_cidade;

    @Column(name = "fun_estado", length = 2)
    private String fun_estado;

    @Column(name = "fun_cargo", length = 100, nullable = false)
    private String fun_cargo;

    @Column(name = "fun_setor", length = 100)
    private String fun_setor;

    @Column(name = "fun_data_admissao", nullable = false)
    private LocalDate fun_data_admissao;

    @Column(name = "fun_data_demissao")
    private LocalDate fun_data_demissao;

    @Column(name = "fun_status", length = 20, nullable = false)
    private String fun_status = "ATIVO";

    @Column(name = "fun_data_cadastro", nullable = false)
    private LocalDateTime fun_data_cadastro;

    @Column(name = "fun_data_atualizacao")
    private LocalDateTime fun_data_atualizacao;

    // Construtores
    public Funcionario() {
        this.fun_data_cadastro = LocalDateTime.now();
    }

    public Funcionario(String nome, String cpf, String cargo, LocalDate dataAdmissao) {
        this();
        this.fun_nome = nome;
        this.fun_cpf = cpf;
        this.fun_cargo = cargo;
        this.fun_data_admissao = dataAdmissao;
    }

    // Getters e Setters
    public Long getFun_codigo() {
        return fun_codigo;
    }

    public void setFun_codigo(Long fun_codigo) {
        this.fun_codigo = fun_codigo;
    }

    public String getFun_nome() {
        return fun_nome;
    }

    public void setFun_nome(String fun_nome) {
        this.fun_nome = fun_nome;
    }

    public String getFun_cpf() {
        return fun_cpf;
    }

    public void setFun_cpf(String fun_cpf) {
        this.fun_cpf = fun_cpf;
    }

    public String getFun_rg() {
        return fun_rg;
    }

    public void setFun_rg(String fun_rg) {
        this.fun_rg = fun_rg;
    }

    public LocalDate getFun_data_nascimento() {
        return fun_data_nascimento;
    }

    public void setFun_data_nascimento(LocalDate fun_data_nascimento) {
        this.fun_data_nascimento = fun_data_nascimento;
    }

    public String getFun_email() {
        return fun_email;
    }

    public void setFun_email(String fun_email) {
        this.fun_email = fun_email;
    }

    public String getFun_telefone() {
        return fun_telefone;
    }

    public void setFun_telefone(String fun_telefone) {
        this.fun_telefone = fun_telefone;
    }

    public String getFun_celular() {
        return fun_celular;
    }

    public void setFun_celular(String fun_celular) {
        this.fun_celular = fun_celular;
    }

    public String getFun_endereco() {
        return fun_endereco;
    }

    public void setFun_endereco(String fun_endereco) {
        this.fun_endereco = fun_endereco;
    }

    public String getFun_numero() {
        return fun_numero;
    }

    public void setFun_numero(String fun_numero) {
        this.fun_numero = fun_numero;
    }

    public String getFun_bairro() {
        return fun_bairro;
    }

    public void setFun_bairro(String fun_bairro) {
        this.fun_bairro = fun_bairro;
    }

    public String getFun_cep() {
        return fun_cep;
    }

    public void setFun_cep(String fun_cep) {
        this.fun_cep = fun_cep;
    }

    public String getFun_cidade() {
        return fun_cidade;
    }

    public void setFun_cidade(String fun_cidade) {
        this.fun_cidade = fun_cidade;
    }

    public String getFun_estado() {
        return fun_estado;
    }

    public void setFun_estado(String fun_estado) {
        this.fun_estado = fun_estado;
    }

    public String getFun_cargo() {
        return fun_cargo;
    }

    public void setFun_cargo(String fun_cargo) {
        this.fun_cargo = fun_cargo;
    }

    public String getFun_setor() {
        return fun_setor;
    }

    public void setFun_setor(String fun_setor) {
        this.fun_setor = fun_setor;
    }

    public LocalDate getFun_data_admissao() {
        return fun_data_admissao;
    }

    public void setFun_data_admissao(LocalDate fun_data_admissao) {
        this.fun_data_admissao = fun_data_admissao;
    }

    public LocalDate getFun_data_demissao() {
        return fun_data_demissao;
    }

    public void setFun_data_demissao(LocalDate fun_data_demissao) {
        this.fun_data_demissao = fun_data_demissao;
    }

    public String getFun_status() {
        return fun_status;
    }

    public void setFun_status(String fun_status) {
        this.fun_status = fun_status;
    }

    public LocalDateTime getFun_data_cadastro() {
        return fun_data_cadastro;
    }

    public void setFun_data_cadastro(LocalDateTime fun_data_cadastro) {
        this.fun_data_cadastro = fun_data_cadastro;
    }

    public LocalDateTime getFun_data_atualizacao() {
        return fun_data_atualizacao;
    }

    public void setFun_data_atualizacao(LocalDateTime fun_data_atualizacao) {
        this.fun_data_atualizacao = fun_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.fun_data_cadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.fun_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(fun_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Funcionario funcionario = (Funcionario) obj;
        return Objects.equals(fun_codigo, funcionario.fun_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "Funcionario{" +
                "fun_codigo=" + fun_codigo +
                ", fun_nome='" + fun_nome + '\'' +
                ", fun_cpf='" + fun_cpf + '\'' +
                ", fun_cargo='" + fun_cargo + '\'' +
                ", fun_status='" + fun_status + '\'' +
                '}';
    }
}
