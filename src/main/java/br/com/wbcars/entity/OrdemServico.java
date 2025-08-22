package br.com.wbcars.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "ordem_servico")
@SequenceGenerator(name = "ordem_servico_seq", sequenceName = "ordem_servico_seq", initialValue = 1, allocationSize = 1)
@Audited
public class OrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordem_servico_seq")
    private Long os_codigo;

    @Column(name = "os_numero", length = 20, unique = true, nullable = false)
    private String os_numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vei_codigo", referencedColumnName = "vei_codigo", nullable = false)
    private Veiculo veiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orc_codigo", referencedColumnName = "orc_codigo")
    private Orcamento orcamento;

    @Column(name = "os_data_abertura", nullable = false)
    private LocalDate os_data_abertura;

    @Column(name = "os_data_prevista_conclusao")
    private LocalDate os_data_prevista_conclusao;

    @Column(name = "os_data_conclusao")
    private LocalDate os_data_conclusao;

    @Column(name = "os_descricao_problema", columnDefinition = "TEXT", nullable = false)
    private String os_descricao_problema;

    @Column(name = "os_descricao_servico", columnDefinition = "TEXT")
    private String os_descricao_servico;

    @Column(name = "os_observacoes", columnDefinition = "TEXT")
    private String os_observacoes;

    @Column(name = "os_defeito_encontrado", columnDefinition = "TEXT")
    private String os_defeito_encontrado;

    @Column(name = "os_solucao_aplicada", columnDefinition = "TEXT")
    private String os_solucao_aplicada;

    @Column(name = "os_valor_mao_obra", precision = 10, scale = 2)
    private BigDecimal os_valor_mao_obra = BigDecimal.ZERO;

    @Column(name = "os_valor_pecas", precision = 10, scale = 2)
    private BigDecimal os_valor_pecas = BigDecimal.ZERO;

    @Column(name = "os_valor_desconto", precision = 10, scale = 2)
    private BigDecimal os_valor_desconto = BigDecimal.ZERO;

    @Column(name = "os_valor_total", precision = 10, scale = 2, nullable = false)
    private BigDecimal os_valor_total = BigDecimal.ZERO;

    @Column(name = "os_status", length = 20, nullable = false)
    private String os_status = "ABERTA"; // ABERTA, EM_ANDAMENTO, AGUARDANDO_PECA, CONCLUIDA, CANCELADA

    @Column(name = "os_prioridade", length = 20)
    private String os_prioridade = "NORMAL"; // BAIXA, NORMAL, ALTA, URGENTE

    @Column(name = "os_tipo", length = 20, nullable = false)
    private String os_tipo = "SERVICO"; // SERVICO, GARANTIA, REVISAO

    @Column(name = "os_quilometragem")
    private Integer os_quilometragem;

    @Column(name = "os_forma_pagamento", length = 50)
    private String os_forma_pagamento;

    @Column(name = "os_condicoes_pagamento", columnDefinition = "TEXT")
    private String os_condicoes_pagamento;

    @Column(name = "os_data_cadastro", nullable = false)
    private LocalDateTime os_data_cadastro;

    @Column(name = "os_data_atualizacao")
    private LocalDateTime os_data_atualizacao;

    // Construtores
    public OrdemServico() {
        this.os_data_cadastro = LocalDateTime.now();
        this.os_data_abertura = LocalDate.now();
    }

    public OrdemServico(String numero, Cliente cliente, Veiculo veiculo, Funcionario funcionario, String descricaoProblema) {
        this();
        this.os_numero = numero;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.funcionario = funcionario;
        this.os_descricao_problema = descricaoProblema;
    }

    // Getters e Setters
    public Long getOs_codigo() {
        return os_codigo;
    }

    public void setOs_codigo(Long os_codigo) {
        this.os_codigo = os_codigo;
    }

    public String getOs_numero() {
        return os_numero;
    }

    public void setOs_numero(String os_numero) {
        this.os_numero = os_numero;
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

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public LocalDate getOs_data_abertura() {
        return os_data_abertura;
    }

    public void setOs_data_abertura(LocalDate os_data_abertura) {
        this.os_data_abertura = os_data_abertura;
    }

    public LocalDate getOs_data_prevista_conclusao() {
        return os_data_prevista_conclusao;
    }

    public void setOs_data_prevista_conclusao(LocalDate os_data_prevista_conclusao) {
        this.os_data_prevista_conclusao = os_data_prevista_conclusao;
    }

    public LocalDate getOs_data_conclusao() {
        return os_data_conclusao;
    }

    public void setOs_data_conclusao(LocalDate os_data_conclusao) {
        this.os_data_conclusao = os_data_conclusao;
    }

    public String getOs_descricao_problema() {
        return os_descricao_problema;
    }

    public void setOs_descricao_problema(String os_descricao_problema) {
        this.os_descricao_problema = os_descricao_problema;
    }

    public String getOs_descricao_servico() {
        return os_descricao_servico;
    }

    public void setOs_descricao_servico(String os_descricao_servico) {
        this.os_descricao_servico = os_descricao_servico;
    }

    public String getOs_observacoes() {
        return os_observacoes;
    }

    public void setOs_observacoes(String os_observacoes) {
        this.os_observacoes = os_observacoes;
    }

    public String getOs_defeito_encontrado() {
        return os_defeito_encontrado;
    }

    public void setOs_defeito_encontrado(String os_defeito_encontrado) {
        this.os_defeito_encontrado = os_defeito_encontrado;
    }

    public String getOs_solucao_aplicada() {
        return os_solucao_aplicada;
    }

    public void setOs_solucao_aplicada(String os_solucao_aplicada) {
        this.os_solucao_aplicada = os_solucao_aplicada;
    }

    public BigDecimal getOs_valor_mao_obra() {
        return os_valor_mao_obra;
    }

    public void setOs_valor_mao_obra(BigDecimal os_valor_mao_obra) {
        this.os_valor_mao_obra = os_valor_mao_obra;
    }

    public BigDecimal getOs_valor_pecas() {
        return os_valor_pecas;
    }

    public void setOs_valor_pecas(BigDecimal os_valor_pecas) {
        this.os_valor_pecas = os_valor_pecas;
    }

    public BigDecimal getOs_valor_desconto() {
        return os_valor_desconto;
    }

    public void setOs_valor_desconto(BigDecimal os_valor_desconto) {
        this.os_valor_desconto = os_valor_desconto;
    }

    public BigDecimal getOs_valor_total() {
        return os_valor_total;
    }

    public void setOs_valor_total(BigDecimal os_valor_total) {
        this.os_valor_total = os_valor_total;
    }

    public String getOs_status() {
        return os_status;
    }

    public void setOs_status(String os_status) {
        this.os_status = os_status;
    }

    public String getOs_prioridade() {
        return os_prioridade;
    }

    public void setOs_prioridade(String os_prioridade) {
        this.os_prioridade = os_prioridade;
    }

    public String getOs_tipo() {
        return os_tipo;
    }

    public void setOs_tipo(String os_tipo) {
        this.os_tipo = os_tipo;
    }

    public Integer getOs_quilometragem() {
        return os_quilometragem;
    }

    public void setOs_quilometragem(Integer os_quilometragem) {
        this.os_quilometragem = os_quilometragem;
    }

    public String getOs_forma_pagamento() {
        return os_forma_pagamento;
    }

    public void setOs_forma_pagamento(String os_forma_pagamento) {
        this.os_forma_pagamento = os_forma_pagamento;
    }

    public String getOs_condicoes_pagamento() {
        return os_condicoes_pagamento;
    }

    public void setOs_condicoes_pagamento(String os_condicoes_pagamento) {
        this.os_condicoes_pagamento = os_condicoes_pagamento;
    }

    public LocalDateTime getOs_data_cadastro() {
        return os_data_cadastro;
    }

    public void setOs_data_cadastro(LocalDateTime os_data_cadastro) {
        this.os_data_cadastro = os_data_cadastro;
    }

    public LocalDateTime getOs_data_atualizacao() {
        return os_data_atualizacao;
    }

    public void setOs_data_atualizacao(LocalDateTime os_data_atualizacao) {
        this.os_data_atualizacao = os_data_atualizacao;
    }

    // PrePersist e PreUpdate
    @PrePersist
    protected void onCreate() {
        this.os_data_cadastro = LocalDateTime.now();
        if (this.os_data_abertura == null) {
            this.os_data_abertura = LocalDate.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.os_data_atualizacao = LocalDateTime.now();
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(os_codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OrdemServico ordemServico = (OrdemServico) obj;
        return Objects.equals(os_codigo, ordemServico.os_codigo);
    }

    // toString
    @Override
    public String toString() {
        return "OrdemServico{" +
                "os_codigo=" + os_codigo +
                ", os_numero='" + os_numero + '\'' +
                ", os_data_abertura=" + os_data_abertura +
                ", os_data_conclusao=" + os_data_conclusao +
                ", os_valor_total=" + os_valor_total +
                ", os_status='" + os_status + '\'' +
                ", os_tipo='" + os_tipo + '\'' +
                '}';
    }
}
