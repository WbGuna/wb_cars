package br.com.wbcars.modelo;

import javax.persistence.*;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "usuario")
public class Usuario {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(name = "ultimo_login")
    private java.time.LocalDateTime ultimoLogin;

    @Column(name = "penultimo_login")
    private java.time.LocalDateTime penultimoLogin;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public java.time.LocalDateTime getUltimoLogin() { return ultimoLogin; }
    public void setUltimoLogin(java.time.LocalDateTime ultimoLogin) { this.ultimoLogin = ultimoLogin; }

    public java.time.LocalDateTime getPenultimoLogin() { return penultimoLogin; }
    public void setPenultimoLogin(java.time.LocalDateTime penultimoLogin) { this.penultimoLogin = penultimoLogin; }
}
