package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.envers.Audited;

import br.com.wbcars.enuns.EstadoBrasil;
import jakarta.persistence.*;

@Entity
@Table(name = "cidade")
@SequenceGenerator(name = "cidade_seq", sequenceName = "cidade_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_seq")
    private Long id;

    private String nome;
    
    @Enumerated(EnumType.STRING)
    private EstadoBrasil estado;
    
    private String pais;
    
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    
    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;

    public Cidade() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoBrasil getEstado() {
        return estado;
    }

    public void setEstado(EstadoBrasil estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
    
    
    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(id, other.id);
	}

	@Override
    public String toString() {
        return "Cidade{" +
            "id=" + getId() +
            ", nome='" + nome + '\'' +
            ", estado=" + (estado != null ? estado.getNome() : null) +
            ", pais='" + pais + '\'' +
            ", dataCadastro=" + getDataCadastro() +
            ", dataAlteracao=" + getDataAlteracao() +
        '}';
    }
}
