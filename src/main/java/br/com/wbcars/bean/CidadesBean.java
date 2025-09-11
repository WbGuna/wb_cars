package br.com.wbcars.bean;

import br.com.wbcars.dto.CidadeDTO;
import br.com.wbcars.enuns.EstadoBrasil;
import br.com.wbcars.facade.WBCarsFacade;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Named("cidadesBean")
@ViewScoped
public class CidadesBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(CidadesBean.class.getName());

    @Inject
    private WBCarsFacade facade;

    // Listas
    private List<CidadeDTO> cidades;
    private List<EstadoBrasil> estados;
    
    // Objetos para CRUD
    private CidadeDTO novaCidade;
    private CidadeDTO cidadeSelecionada;
    
    // Campos para busca/filtro
    private String campoBusca;
    private String valorBusca;

    @PostConstruct
    public void init() {
        LOGGER.info("Inicializando página de Cidades");
        novaCidade = new CidadeDTO();
        carregarCidades();
        carregarEstados();
        LOGGER.info("Página inicializada com sucesso");
    }
    
    // ========== CARREGAMENTO DE DADOS ==========
    
    public void carregarCidades() {
        try {
            LOGGER.info("Carregando lista de cidades");
            cidades = facade.findAllCidades();
            LOGGER.info("Carregadas " + cidades.size() + " cidades");
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao carregar cidades", e);
            cidades = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar cidades: " + e.getMessage());
        }
    }
    
    public void carregarEstados() {
        estados = List.of(EstadoBrasil.values());
    }
    
    public void buscarCidades() {
        try {
            if (campoBusca == null || campoBusca.trim().isEmpty()) {
                adicionarMensagemAviso("Selecione uma coluna para buscar");
                return;
            }
            
            if (valorBusca == null || valorBusca.trim().isEmpty()) {
                adicionarMensagemAviso("Digite um valor para buscar");
                return;
            }
            
            LOGGER.info("Buscando cidades - Campo: " + campoBusca + ", Valor: " + valorBusca);
            
            switch (campoBusca) {
                case "id":
                    try {
                        Long id = Long.parseLong(valorBusca.trim());
                        CidadeDTO cidade = facade.findCidadeById(id);
                        cidades = cidade != null ? List.of(cidade) : new ArrayList<>();
                    } catch (NumberFormatException e) {
                        adicionarMensagemErro("Erro: Para o campo 'ID' digite apenas números. Exemplo: 1, 2, 3");
                        return;
                    }
                    break;
                    
                case "nome":
                    cidades = facade.findAllCidades().stream()
                            .filter(c -> c.getNome() != null && 
                                       c.getNome().toLowerCase().contains(valorBusca.trim().toLowerCase()))
                            .collect(Collectors.toList());
                    break;
                    
                case "estado":
                    try {
                        EstadoBrasil estado = EstadoBrasil.valueOf(valorBusca.trim().toUpperCase());
                        cidades = facade.findAllCidades().stream()
                                .filter(c -> c.getEstado() == estado)
                                .collect(Collectors.toList());
                    } catch (IllegalArgumentException e) {
                        adicionarMensagemErro("Erro: Para o campo 'Estado' use siglas válidas. Exemplos: SP, RJ, MG, RS, PR");
                        return;
                    }
                    break;
                    
                case "pais":
                    cidades = facade.findAllCidades().stream()
                            .filter(c -> c.getPais() != null && 
                                       c.getPais().toLowerCase().contains(valorBusca.trim().toLowerCase()))
                            .collect(Collectors.toList());
                    break;
                    
                case "dataCadastro":
                    try {
                        LocalDate dataBusca = parseDataBusca(valorBusca.trim());
                        cidades = facade.findAllCidades().stream()
                                .filter(c -> c.getDataCadastro() != null && 
                                           c.getDataCadastro().toLocalDate().equals(dataBusca))
                                .collect(Collectors.toList());
                    } catch (Exception e) {
                        adicionarMensagemErro("Erro: Para 'Data Cadastro' use formato: dd/MM/yyyy. Exemplo: 11/09/2025");
                        return;
                    }
                    break;
                    
                case "dataAlteracao":
                    try {
                        LocalDate dataBusca = parseDataBusca(valorBusca.trim());
                        cidades = facade.findAllCidades().stream()
                                .filter(c -> c.getDataAlteracao() != null && 
                                           c.getDataAlteracao().toLocalDate().equals(dataBusca))
                                .collect(Collectors.toList());
                    } catch (Exception e) {
                        adicionarMensagemErro("Erro: Para 'Data Alteração' use formato: dd/MM/yyyy. Exemplo: 11/09/2025");
                        return;
                    }
                    break;
                    
                default:
                    adicionarMensagemErro("Campo de busca inválido: " + campoBusca);
                    return;
            }
            
            LOGGER.info("Busca concluída - " + cidades.size() + " registros encontrados");
            if (cidades.isEmpty()) {
                adicionarMensagemAviso("Nenhum registro encontrado para os critérios informados");
            } else {
                adicionarMensagemSucesso("Busca realizada com sucesso! " + cidades.size() + " registro(s) encontrado(s)");
            }
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro na busca", e);
            adicionarMensagemErro("Erro ao realizar busca: " + e.getMessage());
        }
    }
    
    public void limparFiltros() {
        campoBusca = null;
        valorBusca = null;
        carregarCidades();
        adicionarMensagemSucesso("Filtros limpos - Exibindo todos os registros");
        LOGGER.info("Filtros limpos pelo usuário");
    }
    
    private LocalDate parseDataBusca(String dataStr) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(dataStr, formatter);
        } catch (DateTimeParseException e) {
            try {
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                return LocalDate.parse(dataStr, formatter2);
            } catch (DateTimeParseException e2) {
                DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return LocalDate.parse(dataStr, formatter3);
            }
        }
    }
    
    // ========== DIALOGS ==========
    
    public void abrirDialogNovaCidade() {
        novaCidade = new CidadeDTO();
        LOGGER.info("Dialog de nova cidade aberto");
    }
    
    public void prepararEdicao(CidadeDTO cidade) {
        this.cidadeSelecionada = cidade;
        LOGGER.info("Preparando edição da cidade: " + cidade.getNome() + " (ID: " + cidade.getId() + ")");
    }
    
    public void prepararExclusao(CidadeDTO cidade) {
        this.cidadeSelecionada = cidade;
        LOGGER.info("Preparando exclusão da cidade: " + cidade.getNome() + " (ID: " + cidade.getId() + ")");
    }
    
    // ========== CRUD ==========
    
    public void salvarCidade() {
        try {
            if (novaCidade.getNome() == null || novaCidade.getNome().trim().isEmpty()) {
                adicionarMensagemErro("Nome da cidade é obrigatório");
                return;
            }
            
            if (novaCidade.getEstado() == null) {
                adicionarMensagemErro("Estado é obrigatório");
                return;
            }
            
            // Setar data de cadastro
            novaCidade.setDataCadastro(LocalDateTime.now());
            
            LOGGER.info("Salvando nova cidade: " + novaCidade.getNome());
            facade.saveCidade(novaCidade);
            
            carregarCidades();
            novaCidade = new CidadeDTO();
            adicionarMensagemSucesso("Cidade cadastrada com sucesso!");
            LOGGER.info("Cidade salva com sucesso!");
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar cidade", e);
            adicionarMensagemErro("Erro ao salvar cidade: " + e.getMessage());
        }
    }
    
    public void editarCidade() {
        try {
            if (cidadeSelecionada == null) {
                LOGGER.warning("Tentativa de edição sem cidade selecionada");
                adicionarMensagemErro("Nenhuma cidade selecionada");
                return;
            }
            
            if (cidadeSelecionada.getNome() == null || cidadeSelecionada.getNome().trim().isEmpty()) {
                LOGGER.warning("Tentativa de edição sem nome");
                adicionarMensagemErro("Nome da cidade é obrigatório");
                return;
            }
            
            if (cidadeSelecionada.getEstado() == null) {
                LOGGER.warning("Tentativa de edição sem estado");
                adicionarMensagemErro("Estado é obrigatório");
                return;
            }
            
            // Setar data de alteração
            cidadeSelecionada.setDataAlteracao(LocalDateTime.now());
            
            LOGGER.info("Editando cidade ID: " + cidadeSelecionada.getId() + " - Nome: " + cidadeSelecionada.getNome());
            facade.updateCidade(cidadeSelecionada);
            
            carregarCidades();
            cidadeSelecionada = null;
            adicionarMensagemSucesso("Cidade atualizada com sucesso!");
            LOGGER.info("Cidade atualizada com sucesso!");
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao editar cidade", e);
            adicionarMensagemErro("Erro ao editar cidade: " + e.getMessage());
        }
    }
    
    public void excluirCidade() {
        try {
            if (cidadeSelecionada == null) {
                LOGGER.warning("Tentativa de exclusão sem cidade selecionada");
                adicionarMensagemErro("Nenhuma cidade selecionada");
                return;
            }
            
            LOGGER.info("Excluindo cidade ID: " + cidadeSelecionada.getId() + " - Nome: " + cidadeSelecionada.getNome());
            facade.deleteCidade(cidadeSelecionada.getId());
            
            carregarCidades();
            cidadeSelecionada = null;
            adicionarMensagemSucesso("Cidade excluída com sucesso!");
            LOGGER.info("Cidade excluída com sucesso!");
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir cidade", e);
            adicionarMensagemErro("Erro ao excluir cidade: " + e.getMessage());
        }
    }
    
    // ========== MENSAGENS ==========
    
    private void adicionarMensagemSucesso(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", mensagem));
    }
    
    private void adicionarMensagemErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", mensagem));
    }
    
    private void adicionarMensagemAviso(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", mensagem));
    }
    
    // ========== GETTERS E SETTERS ==========
    
    public List<CidadeDTO> getCidades() {
        return cidades;
    }
    
    public void setCidades(List<CidadeDTO> cidades) {
        this.cidades = cidades;
    }
    
    public List<EstadoBrasil> getEstados() {
        return estados;
    }
    
    public void setEstados(List<EstadoBrasil> estados) {
        this.estados = estados;
    }
    
    public CidadeDTO getNovaCidade() {
        return novaCidade;
    }
    
    public void setNovaCidade(CidadeDTO novaCidade) {
        this.novaCidade = novaCidade;
    }
    
    public CidadeDTO getCidadeSelecionada() {
        return cidadeSelecionada;
    }
    
    public void setCidadeSelecionada(CidadeDTO cidadeSelecionada) {
        this.cidadeSelecionada = cidadeSelecionada;
    }
    
    public String getCampoBusca() {
        return campoBusca;
    }
    
    public void setCampoBusca(String campoBusca) {
        this.campoBusca = campoBusca;
    }
    
    public String getValorBusca() {
        return valorBusca;
    }
    
    public void setValorBusca(String valorBusca) {
        this.valorBusca = valorBusca;
    }
}
