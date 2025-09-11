package br.com.wbcars.bean;

import java.io.Serializable;
import java.util.logging.Logger;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean responsável pela navegação e controle do header do sistema
 */
@Named
@ViewScoped
public class HeaderBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(HeaderBean.class.getName());
    
    @Inject
    private LoginBean loginBean;
    
    // Constantes para navegação - Cadastros
    private static final String VEICULOS = "paginas/veiculos?faces-redirect=true";
    private static final String CLIENTES = "paginas/clientes?faces-redirect=true";
    private static final String FUNCIONARIOS = "paginas/funcionarios?faces-redirect=true";
    private static final String FORNECEDORES = "paginas/fornecedores?faces-redirect=true";
    private static final String PRODUTOS = "paginas/produtos?faces-redirect=true";
    private static final String CIDADES = "paginas/cidades?faces-redirect=true";
    private static final String UNIDADES = "paginas/unidades?faces-redirect=true";
    private static final String USUARIOS = "paginas/usuarios?faces-redirect=true";
    
    // Constantes para navegação - Operações
    private static final String DASHBOARD = "dashboard?faces-redirect=true";
    private static final String AGENDAMENTOS = "paginas/agendamentos?faces-redirect=true";
    private static final String ORDEM_SERVICO = "paginas/ordemDeServico?faces-redirect=true";
    private static final String ORCAMENTOS = "paginas/orcamentos?faces-redirect=true";
    private static final String VENDAS = "paginas/vendas?faces-redirect=true";
    private static final String ESTOQUE = "paginas/estoque?faces-redirect=true";
    
    // Constantes para navegação - Financeiro
    private static final String CONTAS_PAGAR = "paginas/contasPagar?faces-redirect=true";
    private static final String RELATORIOS = "paginas/relatorios?faces-redirect=true";
    private static final String REL_DETALHADOS = "paginas/relDetalhados?faces-redirect=true";
    
    // Métodos de navegação - Cadastros
    public String navegarVeiculos() {
        LOGGER.info("Navegando para Veículos");
        return VEICULOS;
    }
    
    public String navegarClientes() {
        LOGGER.info("Navegando para Clientes");
        return CLIENTES;
    }
    
    public String navegarFuncionarios() {
        LOGGER.info("Navegando para Funcionários");
        return FUNCIONARIOS;
    }
    
    public String navegarFornecedores() {
        LOGGER.info("Navegando para Fornecedores");
        return FORNECEDORES;
    }
    
    public String navegarProdutos() {
        LOGGER.info("Navegando para Produtos");
        return PRODUTOS;
    }
    
    public String navegarCidades() {
        LOGGER.info("Navegando para Cidades");
        return CIDADES;
    }
    
    public String navegarUnidades() {
        LOGGER.info("Navegando para Unidades");
        return UNIDADES;
    }
    
    public String navegarUsuarios() {
        LOGGER.info("Navegando para Usuários");
        return USUARIOS;
    }
    
    // Métodos de navegação - Operações
    public String navegarInicio() {
        LOGGER.info("Navegando para Dashboard");
        return DASHBOARD;
    }
    
    public String navegarAgendamentos() {
        LOGGER.info("Navegando para Agendamentos");
        return AGENDAMENTOS;
    }
    
    public String navegarOS() {
        LOGGER.info("Navegando para Ordens de Serviço");
        return ORDEM_SERVICO;
    }
    
    public String navegarOrcamentos() {
        LOGGER.info("Navegando para Orçamentos");
        return ORCAMENTOS;
    }
    
    public String navegarVendas() {
        LOGGER.info("Navegando para Vendas");
        return VENDAS;
    }
    
    public String navegarEstoque() {
        LOGGER.info("Navegando para Estoque");
        return ESTOQUE;
    }
    
    // Métodos de navegação - Financeiro
    public String navegarContasPagar() {
        LOGGER.info("Navegando para Contas a Pagar");
        return CONTAS_PAGAR;
    }
    
    public String navegarRelatorios() {
        LOGGER.info("Navegando para Relatórios");
        return RELATORIOS;
    }
    
    public String navegarRelDetalhados() {
        LOGGER.info("Navegando para Relatórios Detalhados");
        return REL_DETALHADOS;
    }
    
    // Métodos para acessar informações do LoginBean
    public String getNomeFuncionario() {
        return loginBean.getNomeFuncionario();
    }
    
    public String getPerfilFuncionario() {
        return loginBean.getPerfilFuncionario();
    }
    
    public String logout() {
        LOGGER.info("Executando logout via HeaderBean");
        return loginBean.logout();
    }
    
    // Método para verificar login (delegando para LoginBean)
    public void verificarLogin() {
        loginBean.verificarLogin();
    }
}
