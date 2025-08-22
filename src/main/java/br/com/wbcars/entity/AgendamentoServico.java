package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "agendamento_servico")
@SequenceGenerator(name = "agendamento_seq", sequenceName = "agendamento_seq", initialValue = 1, allocationSize = 1)
@Audited
public class AgendamentoServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendamento_seq")
    private Long age_codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vei_codigo", referencedColumnName = "vei_codigo", nullable = false)
    private Veiculo veiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fun_codigo", referencedColumnName = "fun_codigo")
    private Funcionario funcionario;

    @Column(name = "age_data_agendamento", nullable = false)
    private LocalDate age_data_agendamento;

    @Column(name = "age_hora_inicio", length = 10, nullable = false)
    private String age_hora_inicio;

    @Column(name = "age_hora_fim", length = 10)
    private String age_hora_fim;

    @Column(name = "age_descricao_servico", columnDefinition = "TEXT", nullable = false)
    private String age_descricao_servico;

    @Column(name = "age_tipo_servico", length = 100)
    private String age_tipo_servico;

    @Column(name = "age_observacoes", columnDefinition = "TEXT")
    private String age_observacoes;

    @Column(name = "age_status", length = 20, nullable = false)
    private String age_status = "AGENDADO"; // AGENDADO, CONFIRMADO, EM_ANDAMENTO, CONCLUIDO, CANCELADO

    @Column(name = "age_prioridade", length = 20)
    private String age_prioridade = "NORMAL"; // BAIXA, NORMAL, ALTA, URGENTE

    @Column(name = "age_telefone_contato", length = 20)
    private String age_telefone_contato;

    @Column(name = "age_email_contato", length = 150)
    private String age_email_contato;

    @Column(name = "age_data_cadastro", nullable = false)
    private LocalDateTime age_data_cadastro;

    @Column(name = "age_data_atualizacao")
    private LocalDateTime age_data_atualizacao;

    // Construtores
    public AgendamentoServico() {
        this.age_data_cadastro = LocalDateTime.now();
    }

    public AgendamentoServico(Cliente cliente, Veiculo veiculo, LocalDate dataAgendamento, String horaInicio, String descricaoServico) {
        this();
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.age_data_agendamento = dataAgendamento;
        this.age_hora_inicio = horaInicio;
        this.age_descricao_servico = descricaoServico;
    }

    // Getters e Setters
    public Long getAge_codigo() {
        return age_codigo;
    }

    public void setAge_codigo(Long age_codigo) {
        this.age_codigo = age_codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getAge_data_agendamento() {
        return age_data_agendamento;
    }

    public void setAge_data_agendamento(LocalDate age_data_agendamento) {
        this.age_data_agendamento = age_data_agendamento;
    }

    public String getAge_hora_inicio() {
        return age_hora_inicio;
    }

    public void setAge_hora_inicio(String age_hora_inicio) {
        this.age_hora_inicio = age_hora_inicio;
    }

    public String getAge_hora_fim() {
        return age_hora_fim;
    }

    public void setAge_hora_fim(String age_hora_fim) {
        this.age_hora_fim = age_hora_fim;
    }

    public String getAge_descricao_servico() {
        return age_descricao_servico;
    }

    public void setAge_descricao_servico(String age_descricao_servico) {
        this.age_descricao_servico = age_descricao_servico;
    }

    public String getAge_tipo_servico() {
        return age_tipo_servico;
    }

    public void setAge_tipo_servico(String age_tipo_servico) {
        this.age_tipo_servico = age_tipo_servico;
    }

    public String getAge_observacoes() {
        return age_observacoes;
    }

    public void setAge_observacoes(String age_observacoes) {
        this.age_observacoes = age_observacoes;
    }

    public String getAge_status() {
        return age_status;
    }

    public void setAge_status(String age_status) {
        this.age_status = age_status;
    }

    public String getAge_prioridade() {
        return age_prioridade;
    }

    public void setAge_prioridade(String age_prioridade) {
        this.age_prioridade = age_prioridade;
    }

    public String getAge_telefone_contato() {
        return age_telefone_contato;
    }

    public void setAge_telefone_contato(String age_telefone_contato) {
        this.age_telefone_contato = age_telefone_contato;
    }

    public String getAge_email_contato() {
        return age_email_contato;
    }

    public void setAge_email_contato(String age_email_contato) {
        this.age_email_contato = age_email_contato;
    }

    public LocalDateTime getAge_data_cadastro() {
        return age_data_cadastro;
    }

    public void setAge_data_cadastro(LocalDateTime age_data_cadastro) {
        this.age_data_cadastro = age_data_cadastro;
    }

    public LocalDateTime getAge_data_atualizacao() {
        return age_data_atualizacao;
    }

    public void setAge_data_atualizacao(LocalDateTime age_data_atualizacao) {
        this.age_data_atualizacao = age_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.age_data_cadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.age_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(age_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AgendamentoServico agendamento = (AgendamentoServico) obj;
        return Objects.equals(age_codigo, agendamento.age_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "AgendamentoServico{" +
                "age_codigo=" + age_codigo +
                ", age_data_agendamento=" + age_data_agendamento +
                ", age_hora_inicio='" + age_hora_inicio + '\'' +
                ", age_descricao_servico='" + age_descricao_servico + '\'' +
                ", age_status='" + age_status + '\'' +
                ", age_prioridade='" + age_prioridade + '\'' +
                '}';
    }
}
