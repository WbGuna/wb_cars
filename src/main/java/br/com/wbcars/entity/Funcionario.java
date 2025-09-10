package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.envers.Audited;

import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.SetorFuncionario;
import br.com.wbcars.enuns.TipoUsuario;
import br.com.wbcars.utils.CriptografiaUtil;
import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
@SequenceGenerator(name = "funcionario_seq", sequenceName = "funcionario_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_seq")
    private Long id;

    private String nome;
    
    @Enumerated(EnumType.STRING)
    private SetorFuncionario setor;
    
    private LocalDateTime dataRegistro;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    
    private String funcao;
    
    private String cpfCnpj;
    
    private String telefone;
    
    private String email;
    
    private String rua;
    
    private String bairro;
    
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    
    @Enumerated(EnumType.STRING)
    private StatusGeral status;

    @Column(unique = true)
    private String login;
    
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private TipoUsuario perfil;
    
    public Funcionario() {}
    
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
    
    public SetorFuncionario getSetor() { 
        return setor; 
    }
    
    public void setSetor(SetorFuncionario setor) { 
        this.setor = setor; 
    }
    
    public LocalDateTime getDataRegistro() { 
        return dataRegistro; 
    }
    
    public void setDataRegistro(LocalDateTime dataRegistro) { 
        this.dataRegistro = dataRegistro; 
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
    
    public String getFuncao() { 
        return funcao; 
    }
    
    public void setFuncao(String funcao) { 
        this.funcao = funcao; 
    }
    
    /**
     * Retorna o CPF/CNPJ descriptografado
     * @return CPF/CNPJ em texto plano
     */
    public String getCpfCnpj() { 
        if (cpfCnpj != null && isBase64(cpfCnpj)) {
            try {
                return CriptografiaUtil.descriptografarDocumento(cpfCnpj);
            } catch (Exception e) {
                return cpfCnpj; // Se falhar, retorna como está
            }
        }
        return cpfCnpj; 
    }
    
    /**
     * Define o CPF/CNPJ com criptografia automática
     * @param cpfCnpj CPF/CNPJ em texto plano que será automaticamente criptografado
     */
    public void setCpfCnpj(String cpfCnpj) { 
        if (cpfCnpj != null && !cpfCnpj.trim().isEmpty()) {
            // Só criptografa se não estiver já criptografado (não é Base64)
            if (!isBase64(cpfCnpj.trim())) {
                this.cpfCnpj = CriptografiaUtil.criptografarDocumento(cpfCnpj.trim());
            } else {
                this.cpfCnpj = cpfCnpj; // Já está criptografado
            }
        } else {
            this.cpfCnpj = null;
        }
    }
    
    public String getTelefone() { 
        return telefone; 
    }
    
    public void setTelefone(String telefone) { 
        this.telefone = telefone; 
    }
    
    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }
    
    public String getRua() { 
        return rua; 
    }
    
    public void setRua(String rua) { 
        this.rua = rua; 
    }
    
    public String getBairro() { 
        return bairro; 
    }
    
    public void setBairro(String bairro) { 
        this.bairro = bairro; 
    }
    
    public Cidade getCidade() { 
        return cidade; 
    }
    
    public void setCidade(Cidade cidade) { 
        this.cidade = cidade; 
    }
    
    public StatusGeral getStatus() { 
        return status; 
    }
    
    public void setStatus(StatusGeral status) { 
        this.status = status; 
    }
    
    public String getLogin() { 
        return login; 
    }
    
    public void setLogin(String login) { 
        this.login = login; 
    }
    
    public String getSenha() { 
        return senha; 
    }
    
    /**
     * Define a senha do funcionário com criptografia automática
     * @param senha Senha em texto plano que será automaticamente criptografada
     */
    public void setSenha(String senha) { 
        if (senha != null && !senha.trim().isEmpty()) {
            // Só criptografa se a senha não estiver já criptografada (não é Base64)
            if (!isBase64(senha)) {
                this.senha = CriptografiaUtil.hashSenha(senha.trim());
            } else {
                this.senha = senha; // Já está criptografada
            }
        } else {
            this.senha = null;
        }
    }
    
    /**
     * Verifica se uma senha em texto plano corresponde à senha armazenada
     * @param senhaPlana Senha em texto plano para verificação
     * @return true se a senha corresponde, false caso contrário
     */
    public boolean verificarSenha(String senhaPlana) {
        if (senha == null || senhaPlana == null || senhaPlana.trim().isEmpty()) {
            return false;
        }
        return CriptografiaUtil.verificarSenha(senhaPlana.trim(), senha);
    }
    
    public TipoUsuario getPerfil() { 
        return perfil; 
    }
    
    public void setPerfil(TipoUsuario perfil) { 
        this.perfil = perfil; 
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", setor=" + (setor != null ? setor.getDescricao() : null) +
                ", dataRegistro=" + dataRegistro +
                ", dataCadastro=" + dataCadastro +
                ", dataAlteracao=" + dataAlteracao +
                ", funcao='" + funcao + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade=" + (cidade != null ? cidade.getNome() : null) +
                ", status=" + (status != null ? status.getDescricao() : null) +
                ", login='" + login + '\'' +
                ", perfil=" + (perfil != null ? perfil.getDescricao() : null) +
                '}';
    }
    
    /**
     * Método utilitário para verificar se uma string está em formato Base64
     * @param str String para verificar
     * @return true se estiver em Base64, false caso contrário
     */
    private boolean isBase64(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            // Verifica se tem caracteres Base64 válidos e tamanho apropriado
            return str.matches("^[A-Za-z0-9+/]*={0,2}$") && str.length() % 4 == 0 && str.length() > 20;
        } catch (Exception e) {
            return false;
        }
    }
}
