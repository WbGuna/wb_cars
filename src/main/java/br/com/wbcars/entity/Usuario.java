package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    private Long usu_codigo;

    @Column(name = "usu_nome", length = 200, nullable = false)
    private String usu_nome;

    @Column(name = "usu_login", length = 50, unique = true, nullable = false)
    private String usu_login;

    @Column(name = "usu_senha", length = 255, nullable = false)
    private String usu_senha;

    @Column(name = "usu_email", length = 150, unique = true)
    private String usu_email;

    @Column(name = "usu_perfil", length = 30, nullable = false)
    private String usu_perfil = "USUARIO"; // ADMIN, USUARIO, OPERADOR

    @Column(name = "usu_status", length = 20, nullable = false)
    private String usu_status = "ATIVO";

    @Column(name = "usu_data_cadastro", nullable = false)
    private LocalDateTime usu_data_cadastro;

    @Column(name = "usu_data_atualizacao")
    private LocalDateTime usu_data_atualizacao;

    @Column(name = "usu_ultimo_login")
    private LocalDateTime usu_ultimo_login;

    // Construtores
    public Usuario() {
        this.usu_data_cadastro = LocalDateTime.now();
    }

    public Usuario(String nome, String login, String senha, String perfil) {
        this();
        this.usu_nome = nome;
        this.usu_login = login;
        this.usu_senha = senha;
        this.usu_perfil = perfil;
    }

    // Getters e Setters
    public Long getUsu_codigo() {
        return usu_codigo;
    }

    public void setUsu_codigo(Long usu_codigo) {
        this.usu_codigo = usu_codigo;
    }

    public String getUsu_nome() {
        return usu_nome;
    }

    public void setUsu_nome(String usu_nome) {
        this.usu_nome = usu_nome;
    }

    public String getUsu_login() {
        return usu_login;
    }

    public void setUsu_login(String usu_login) {
        this.usu_login = usu_login;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public String getUsu_perfil() {
        return usu_perfil;
    }

    public void setUsu_perfil(String usu_perfil) {
        this.usu_perfil = usu_perfil;
    }

    public String getUsu_status() {
        return usu_status;
    }

    public void setUsu_status(String usu_status) {
        this.usu_status = usu_status;
    }

    public LocalDateTime getUsu_data_cadastro() {
        return usu_data_cadastro;
    }

    public void setUsu_data_cadastro(LocalDateTime usu_data_cadastro) {
        this.usu_data_cadastro = usu_data_cadastro;
    }

    public LocalDateTime getUsu_data_atualizacao() {
        return usu_data_atualizacao;
    }

    public void setUsu_data_atualizacao(LocalDateTime usu_data_atualizacao) {
        this.usu_data_atualizacao = usu_data_atualizacao;
    }

    public LocalDateTime getUsu_ultimo_login() {
        return usu_ultimo_login;
    }

    public void setUsu_ultimo_login(LocalDateTime usu_ultimo_login) {
        this.usu_ultimo_login = usu_ultimo_login;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.usu_data_cadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.usu_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(usu_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(usu_codigo, usuario.usu_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "Usuario{" +
                "usu_codigo=" + usu_codigo +
                ", usu_nome='" + usu_nome + '\'' +
                ", usu_login='" + usu_login + '\'' +
                ", usu_perfil='" + usu_perfil + '\'' +
                ", usu_status='" + usu_status + '\'' +
                '}';
    }
}
