package br.com.wbcars.dto;

import java.time.LocalDateTime;

public class UsuarioDTO {
    private Long id;
    private String login;
    private String nome;
    private String email;
    private LocalDateTime ultimoLogin;
    private LocalDateTime penultimoLogin;
    // outros campos necessários

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDateTime getUltimoLogin() { return ultimoLogin; }
    public void setUltimoLogin(LocalDateTime ultimoLogin) { this.ultimoLogin = ultimoLogin; }
    public LocalDateTime getPenultimoLogin() { return penultimoLogin; }
    public void setPenultimoLogin(LocalDateTime penultimoLogin) { this.penultimoLogin = penultimoLogin; }
}
