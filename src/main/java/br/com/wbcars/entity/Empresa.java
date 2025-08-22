package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "empresa")
@SequenceGenerator(name = "empresa_seq", sequenceName = "empresa_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_seq")
    private Long emp_codigo;

    @Column(name = "emp_razao_social", length = 255, nullable = false)
    private String emp_razao_social;

    @Column(name = "emp_nome_fantasia", length = 255)
    private String emp_nome_fantasia;

    @Column(name = "emp_cnpj", length = 20, unique = true, nullable = false)
    private String emp_cnpj;

    @Column(name = "emp_inscricao_estadual", length = 30)
    private String emp_inscricao_estadual;

    @Column(name = "emp_inscricao_municipal", length = 30)
    private String emp_inscricao_municipal;

    @Column(name = "emp_email", length = 150)
    private String emp_email;

    @Column(name = "emp_telefone", length = 20)
    private String emp_telefone;

    @Column(name = "emp_endereco", length = 255)
    private String emp_endereco;

    @Column(name = "emp_numero", length = 10)
    private String emp_numero;

    @Column(name = "emp_complemento", length = 100)
    private String emp_complemento;

    @Column(name = "emp_bairro", length = 100)
    private String emp_bairro;

    @Column(name = "emp_cep", length = 10)
    private String emp_cep;

    @Column(name = "emp_cidade", length = 100)
    private String emp_cidade;

    @Column(name = "emp_estado", length = 2)
    private String emp_estado;

    @Column(name = "emp_status", length = 20, nullable = false)
    private String emp_status = "ATIVO";

    @Column(name = "emp_data_cadastro", nullable = false)
    private LocalDateTime emp_data_cadastro;

    @Column(name = "emp_data_atualizacao")
    private LocalDateTime emp_data_atualizacao;

    // Construtores
    public Empresa() {
        this.emp_data_cadastro = LocalDateTime.now();
    }

    public Empresa(String razaoSocial, String cnpj) {
        this();
        this.emp_razao_social = razaoSocial;
        this.emp_cnpj = cnpj;
    }

    // Getters e Setters
    public Long getEmp_codigo() {
        return emp_codigo;
    }

    public void setEmp_codigo(Long emp_codigo) {
        this.emp_codigo = emp_codigo;
    }

    public String getEmp_razao_social() {
        return emp_razao_social;
    }

    public void setEmp_razao_social(String emp_razao_social) {
        this.emp_razao_social = emp_razao_social;
    }

    public String getEmp_nome_fantasia() {
        return emp_nome_fantasia;
    }

    public void setEmp_nome_fantasia(String emp_nome_fantasia) {
        this.emp_nome_fantasia = emp_nome_fantasia;
    }

    public String getEmp_cnpj() {
        return emp_cnpj;
    }

    public void setEmp_cnpj(String emp_cnpj) {
        this.emp_cnpj = emp_cnpj;
    }

    public String getEmp_inscricao_estadual() {
        return emp_inscricao_estadual;
    }

    public void setEmp_inscricao_estadual(String emp_inscricao_estadual) {
        this.emp_inscricao_estadual = emp_inscricao_estadual;
    }

    public String getEmp_inscricao_municipal() {
        return emp_inscricao_municipal;
    }

    public void setEmp_inscricao_municipal(String emp_inscricao_municipal) {
        this.emp_inscricao_municipal = emp_inscricao_municipal;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getEmp_telefone() {
        return emp_telefone;
    }

    public void setEmp_telefone(String emp_telefone) {
        this.emp_telefone = emp_telefone;
    }

    public String getEmp_endereco() {
        return emp_endereco;
    }

    public void setEmp_endereco(String emp_endereco) {
        this.emp_endereco = emp_endereco;
    }

    public String getEmp_numero() {
        return emp_numero;
    }

    public void setEmp_numero(String emp_numero) {
        this.emp_numero = emp_numero;
    }

    public String getEmp_complemento() {
        return emp_complemento;
    }

    public void setEmp_complemento(String emp_complemento) {
        this.emp_complemento = emp_complemento;
    }

    public String getEmp_bairro() {
        return emp_bairro;
    }

    public void setEmp_bairro(String emp_bairro) {
        this.emp_bairro = emp_bairro;
    }

    public String getEmp_cep() {
        return emp_cep;
    }

    public void setEmp_cep(String emp_cep) {
        this.emp_cep = emp_cep;
    }

    public String getEmp_cidade() {
        return emp_cidade;
    }

    public void setEmp_cidade(String emp_cidade) {
        this.emp_cidade = emp_cidade;
    }

    public String getEmp_estado() {
        return emp_estado;
    }

    public void setEmp_estado(String emp_estado) {
        this.emp_estado = emp_estado;
    }

    public String getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(String emp_status) {
        this.emp_status = emp_status;
    }

    public LocalDateTime getEmp_data_cadastro() {
        return emp_data_cadastro;
    }

    public void setEmp_data_cadastro(LocalDateTime emp_data_cadastro) {
        this.emp_data_cadastro = emp_data_cadastro;
    }

    public LocalDateTime getEmp_data_atualizacao() {
        return emp_data_atualizacao;
    }

    public void setEmp_data_atualizacao(LocalDateTime emp_data_atualizacao) {
        this.emp_data_atualizacao = emp_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.emp_data_cadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.emp_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(emp_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Empresa empresa = (Empresa) obj;
        return Objects.equals(emp_codigo, empresa.emp_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "Empresa{" +
                "emp_codigo=" + emp_codigo +
                ", emp_razao_social='" + emp_razao_social + '\'' +
                ", emp_nome_fantasia='" + emp_nome_fantasia + '\'' +
                ", emp_cnpj='" + emp_cnpj + '\'' +
                ", emp_status='" + emp_status + '\'' +
                '}';
    }
}
