package br.com.wbcars.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "veiculo")
@SequenceGenerator(name = "veiculo_seq", sequenceName = "veiculo_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo_seq")
    private Long vei_codigo;

    @Column(name = "vei_marca", length = 100, nullable = false)
    private String vei_marca;

    @Column(name = "vei_modelo", length = 100, nullable = false)
    private String vei_modelo;

    @Column(name = "vei_ano", nullable = false)
    private Integer vei_ano;

    @Column(name = "vei_placa", length = 10, unique = true)
    private String vei_placa;

    @Column(name = "vei_chassi", length = 50, unique = true)
    private String vei_chassi;

    @Column(name = "vei_cor", length = 50)
    private String vei_cor;

    @Column(name = "vei_combustivel", length = 30)
    private String vei_combustivel;

    @Column(name = "vei_kilometragem", precision = 10, scale = 2)
    private BigDecimal vei_kilometragem;

    @Column(name = "vei_preco", precision = 15, scale = 2)
    private BigDecimal vei_preco;

    @Column(name = "vei_status", length = 20, nullable = false)
    private String vei_status = "ATIVO";

    @Column(name = "vei_data_cadastro", nullable = false)
    private LocalDateTime vei_data_cadastro;

    @Column(name = "vei_data_atualizacao")
    private LocalDateTime vei_data_atualizacao;

    @Column(name = "vei_observacoes", columnDefinition = "TEXT")
    private String vei_observacoes;

    // Construtores
    public Veiculo() {
        this.vei_data_cadastro = LocalDateTime.now();
    }

    public Veiculo(String marca, String modelo, Integer ano) {
        this();
        this.vei_marca = marca;
        this.vei_modelo = modelo;
        this.vei_ano = ano;
    }

    // Getters e Setters
    public Long getVei_codigo() {
        return vei_codigo;
    }

    public void setVei_codigo(Long vei_codigo) {
        this.vei_codigo = vei_codigo;
    }

    public String getVei_marca() {
        return vei_marca;
    }

    public void setVei_marca(String vei_marca) {
        this.vei_marca = vei_marca;
    }

    public String getVei_modelo() {
        return vei_modelo;
    }

    public void setVei_modelo(String vei_modelo) {
        this.vei_modelo = vei_modelo;
    }

    public Integer getVei_ano() {
        return vei_ano;
    }

    public void setVei_ano(Integer vei_ano) {
        this.vei_ano = vei_ano;
    }

    public String getVei_placa() {
        return vei_placa;
    }

    public void setVei_placa(String vei_placa) {
        this.vei_placa = vei_placa;
    }

    public String getVei_chassi() {
        return vei_chassi;
    }

    public void setVei_chassi(String vei_chassi) {
        this.vei_chassi = vei_chassi;
    }

    public String getVei_cor() {
        return vei_cor;
    }

    public void setVei_cor(String vei_cor) {
        this.vei_cor = vei_cor;
    }

    public String getVei_combustivel() {
        return vei_combustivel;
    }

    public void setVei_combustivel(String vei_combustivel) {
        this.vei_combustivel = vei_combustivel;
    }

    public BigDecimal getVei_kilometragem() {
        return vei_kilometragem;
    }

    public void setVei_kilometragem(BigDecimal vei_kilometragem) {
        this.vei_kilometragem = vei_kilometragem;
    }

    public BigDecimal getVei_preco() {
        return vei_preco;
    }

    public void setVei_preco(BigDecimal vei_preco) {
        this.vei_preco = vei_preco;
    }

    public String getVei_status() {
        return vei_status;
    }

    public void setVei_status(String vei_status) {
        this.vei_status = vei_status;
    }

    public LocalDateTime getVei_data_cadastro() {
        return vei_data_cadastro;
    }

    public void setVei_data_cadastro(LocalDateTime vei_data_cadastro) {
        this.vei_data_cadastro = vei_data_cadastro;
    }

    public LocalDateTime getVei_data_atualizacao() {
        return vei_data_atualizacao;
    }

    public void setVei_data_atualizacao(LocalDateTime vei_data_atualizacao) {
        this.vei_data_atualizacao = vei_data_atualizacao;
    }

    public String getVei_observacoes() {
        return vei_observacoes;
    }

    public void setVei_observacoes(String vei_observacoes) {
        this.vei_observacoes = vei_observacoes;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.vei_data_cadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.vei_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(vei_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Veiculo veiculo = (Veiculo) obj;
        return Objects.equals(vei_codigo, veiculo.vei_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "Veiculo{" +
                "vei_codigo=" + vei_codigo +
                ", vei_marca='" + vei_marca + '\'' +
                ", vei_modelo='" + vei_modelo + '\'' +
                ", vei_ano=" + vei_ano +
                ", vei_placa='" + vei_placa + '\'' +
                ", vei_status='" + vei_status + '\'' +
                '}';
    }
}
