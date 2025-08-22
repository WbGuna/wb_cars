package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "cliente")
@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    private Long cli_codigo;

    @Column(name = "cli_nome", length = 200, nullable = false)
    private String cli_nome;

    @Column(name = "cli_cpf_cnpj", length = 20, unique = true)
    private String cli_cpf_cnpj;

    @Column(name = "cli_rg", length = 20)
    private String cli_rg;

    @Column(name = "cli_data_nascimento")
    private LocalDate cli_data_nascimento;

    @Column(name = "cli_email", length = 150)
    private String cli_email;

    @Column(name = "cli_telefone", length = 20)
    private String cli_telefone;

    @Column(name = "cli_celular", length = 20)
    private String cli_celular;

    @Column(name = "cli_endereco", length = 255)
    private String cli_endereco;

    @Column(name = "cli_numero", length = 10)
    private String cli_numero;

    @Column(name = "cli_complemento", length = 100)
    private String cli_complemento;

    @Column(name = "cli_bairro", length = 100)
    private String cli_bairro;

    @Column(name = "cli_cep", length = 10)
    private String cli_cep;

    @Column(name = "cli_cidade", length = 100)
    private String cli_cidade;

    @Column(name = "cli_estado", length = 2)
    private String cli_estado;

    @Column(name = "cli_tipo", length = 20, nullable = false)
    private String cli_tipo = "PESSOA_FISICA"; // PESSOA_FISICA, PESSOA_JURIDICA

    @Column(name = "cli_status", length = 20, nullable = false)
    private String cli_status = "ATIVO";

    @Column(name = "cli_data_cadastro", nullable = false)
    private LocalDateTime cli_data_cadastro;

    @Column(name = "cli_data_atualizacao")
    private LocalDateTime cli_data_atualizacao;

    @Column(name = "cli_observacoes", columnDefinition = "TEXT")
    private String cli_observacoes;

    // Construtores
    public Cliente() {
        this.cli_data_cadastro = LocalDateTime.now();
    }

    public Cliente(String nome, String cpfCnpj, String tipo) {
        this();
        this.cli_nome = nome;
        this.cli_cpf_cnpj = cpfCnpj;
        this.cli_tipo = tipo;
    }

    // Getters e Setters
    public Long getCli_codigo() {
        return cli_codigo;
    }

    public void setCli_codigo(Long cli_codigo) {
        this.cli_codigo = cli_codigo;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public String getCli_cpf_cnpj() {
        return cli_cpf_cnpj;
    }

    public void setCli_cpf_cnpj(String cli_cpf_cnpj) {
        this.cli_cpf_cnpj = cli_cpf_cnpj;
    }

    public String getCli_rg() {
        return cli_rg;
    }

    public void setCli_rg(String cli_rg) {
        this.cli_rg = cli_rg;
    }

    public LocalDate getCli_data_nascimento() {
        return cli_data_nascimento;
    }

    public void setCli_data_nascimento(LocalDate cli_data_nascimento) {
        this.cli_data_nascimento = cli_data_nascimento;
    }

    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }

    public String getCli_telefone() {
        return cli_telefone;
    }

    public void setCli_telefone(String cli_telefone) {
        this.cli_telefone = cli_telefone;
    }

    public String getCli_celular() {
        return cli_celular;
    }

    public void setCli_celular(String cli_celular) {
        this.cli_celular = cli_celular;
    }

    public String getCli_endereco() {
        return cli_endereco;
    }

    public void setCli_endereco(String cli_endereco) {
        this.cli_endereco = cli_endereco;
    }

    public String getCli_numero() {
        return cli_numero;
    }

    public void setCli_numero(String cli_numero) {
        this.cli_numero = cli_numero;
    }

    public String getCli_complemento() {
        return cli_complemento;
    }

    public void setCli_complemento(String cli_complemento) {
        this.cli_complemento = cli_complemento;
    }

    public String getCli_bairro() {
        return cli_bairro;
    }

    public void setCli_bairro(String cli_bairro) {
        this.cli_bairro = cli_bairro;
    }

    public String getCli_cep() {
        return cli_cep;
    }

    public void setCli_cep(String cli_cep) {
        this.cli_cep = cli_cep;
    }

    public String getCli_cidade() {
        return cli_cidade;
    }

    public void setCli_cidade(String cli_cidade) {
        this.cli_cidade = cli_cidade;
    }

    public String getCli_estado() {
        return cli_estado;
    }

    public void setCli_estado(String cli_estado) {
        this.cli_estado = cli_estado;
    }

    public String getCli_tipo() {
        return cli_tipo;
    }

    public void setCli_tipo(String cli_tipo) {
        this.cli_tipo = cli_tipo;
    }

    public String getCli_status() {
        return cli_status;
    }

    public void setCli_status(String cli_status) {
        this.cli_status = cli_status;
    }

    public LocalDateTime getCli_data_cadastro() {
        return cli_data_cadastro;
    }

    public void setCli_data_cadastro(LocalDateTime cli_data_cadastro) {
        this.cli_data_cadastro = cli_data_cadastro;
    }

    public LocalDateTime getCli_data_atualizacao() {
        return cli_data_atualizacao;
    }

    public void setCli_data_atualizacao(LocalDateTime cli_data_atualizacao) {
        this.cli_data_atualizacao = cli_data_atualizacao;
    }

    public String getCli_observacoes() {
        return cli_observacoes;
    }

    public void setCli_observacoes(String cli_observacoes) {
        this.cli_observacoes = cli_observacoes;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.cli_data_cadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.cli_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(cli_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return Objects.equals(cli_codigo, cliente.cli_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "Cliente{" +
                "cli_codigo=" + cli_codigo +
                ", cli_nome='" + cli_nome + '\'' +
                ", cli_cpf_cnpj='" + cli_cpf_cnpj + '\'' +
                ", cli_tipo='" + cli_tipo + '\'' +
                ", cli_status='" + cli_status + '\'' +
                '}';
    }
}
