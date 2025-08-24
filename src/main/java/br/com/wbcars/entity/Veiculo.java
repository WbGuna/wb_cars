package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculo")
@SequenceGenerator(name = "veiculo_seq", sequenceName = "veiculo_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo_seq")
    private Long id;

    private String modelo;
    private String marca;
    private String placa;
    private Integer kilometragem;
    private String observacao;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Veiculo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public Integer getKilometragem() { return kilometragem; }
    public void setKilometragem(Integer kilometragem) { this.kilometragem = kilometragem; }
    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return id != null && id.equals(veiculo.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "Veiculo{" +
        "id=" + id +
        ", modelo='" + modelo + '\'' +
        ", marca='" + marca + '\'' +
        ", placa='" + placa + '\'' +
        ", kilometragem=" + kilometragem +
        ", observacao='" + observacao + '\'' +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        ", cliente=" + (cliente != null ? cliente.getNome() : null) +
        '}';
    }
}
