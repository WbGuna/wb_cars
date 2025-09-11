package br.com.wbcars.bean;

import br.com.wbcars.dto.UnidadeMedidaDTO;
import br.com.wbcars.enuns.TipoUnidadeMedida;
import br.com.wbcars.facade.WBCarsFacade;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("unidadesBean")
@ViewScoped
public class UnidadesBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(UnidadesBean.class.getName());
    
    @Inject
    private WBCarsFacade facade;
    
    // Listas
    private List<UnidadeMedidaDTO> unidades;
    private List<TipoUnidadeMedida> tiposUnidade;
    
    // Objetos para CRUD
    private UnidadeMedidaDTO novaUnidade;
    private UnidadeMedidaDTO unidadeSelecionada;

    @PostConstruct
    public void init() {
        LOGGER.info("Inicializando página de Unidades de Medida");
        novaUnidade = new UnidadeMedidaDTO();
        carregarUnidades();
        carregarTiposUnidade();
        LOGGER.info("Página inicializada com sucesso");
    }
    
    // ========== CARREGAMENTO DE DADOS ==========
    
    public void carregarUnidades() {
        try {
            LOGGER.info("Carregando lista de unidades de medida");
            unidades = facade.findAllUnidadeMedidas();
            LOGGER.info("Carregadas " + (unidades != null ? unidades.size() : 0) + " unidades de medida");
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao carregar unidades de medida", e);
            unidades = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar unidades de medida: " + e.getMessage());
        }
    }
    
    public void carregarTiposUnidade() {
        tiposUnidade = List.of(TipoUnidadeMedida.values());
    }
    
    // ========== DIALOGS ==========
    
    public void abrirDialogNovaUnidade() {
        novaUnidade = new UnidadeMedidaDTO();
        LOGGER.info("Dialog de nova unidade aberto");
    }
    
    public void abrirDialogEditarUnidade() {
        if (unidadeSelecionada == null) {
            adicionarMensagemAviso("Selecione uma unidade para editar");
            return;
        }
        LOGGER.info("Dialog de edição aberto para unidade ID: " + unidadeSelecionada.getId());
    }
    
    public void prepararEdicao(UnidadeMedidaDTO unidade) {
        this.unidadeSelecionada = unidade;
        LOGGER.info("Preparando edição da unidade: " + unidade.getTipo().getDescricao() + " (ID: " + unidade.getId() + ")");
    }
    
    public void prepararExclusao(UnidadeMedidaDTO unidade) {
        this.unidadeSelecionada = unidade;
        LOGGER.info("Preparando exclusão da unidade: " + unidade.getTipo().getDescricao() + " (ID: " + unidade.getId() + ")");
    }
    
    // ========== CRUD OPERATIONS ==========
    
    public void salvarUnidade() {
        try {
            if (novaUnidade.getTipo() == null) {
                adicionarMensagemErro("Tipo da unidade é obrigatório");
                return;
            }
            
            // Setar data de criação
            novaUnidade.setDataCadastro(LocalDateTime.now());
            
            LOGGER.info("Salvando nova unidade: " + novaUnidade.getTipo());
            facade.saveUnidadeMedida(novaUnidade);
            
            carregarUnidades();
            adicionarMensagemSucesso("Unidade salva com sucesso!");
            
            // Limpar e fechar
            novaUnidade = new UnidadeMedidaDTO();
            PrimeFaces.current().executeScript("PF('dialogCadastro').hide();");
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar unidade", e);
            adicionarMensagemErro("Erro ao salvar unidade: " + e.getMessage());
        }
    }
    
    public void editarUnidade() {
        try {
            if (unidadeSelecionada == null) {
                LOGGER.warning("Tentativa de edição sem unidade selecionada");
                adicionarMensagemErro("Nenhuma unidade selecionada");
                return;
            }
            
            if (unidadeSelecionada.getTipo() == null) {
                LOGGER.warning("Tentativa de edição sem tipo selecionado");
                adicionarMensagemErro("Tipo da unidade é obrigatório");
                return;
            }
            
            // Setar data de alteração
            unidadeSelecionada.setDataAlteracao(LocalDateTime.now());
            
            LOGGER.info("Editando unidade ID: " + unidadeSelecionada.getId() + " - Tipo: " + unidadeSelecionada.getTipo().getDescricao());
            facade.updateUnidadeMedida(unidadeSelecionada);
            
            carregarUnidades();
            unidadeSelecionada = null; // Limpar seleção
            adicionarMensagemSucesso("Unidade atualizada com sucesso!");
            LOGGER.info("Unidade atualizada com sucesso!");
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao editar unidade", e);
            adicionarMensagemErro("Erro ao editar unidade: " + e.getMessage());
        }
    }
    
    public void excluirUnidade() {
        try {
            if (unidadeSelecionada == null) {
                LOGGER.warning("Tentativa de exclusão sem unidade selecionada");
                adicionarMensagemErro("Nenhuma unidade selecionada");
                return;
            }
            
            LOGGER.info("Excluindo unidade ID: " + unidadeSelecionada.getId() + " - Tipo: " + unidadeSelecionada.getTipo().getDescricao());
            facade.deleteUnidadeMedida(unidadeSelecionada.getId());
            
            carregarUnidades();
            unidadeSelecionada = null; // Limpar seleção
            adicionarMensagemSucesso("Unidade excluída com sucesso!");
            LOGGER.info("Unidade excluída com sucesso!");
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir unidade", e);
            adicionarMensagemErro("Erro ao excluir unidade: " + e.getMessage());
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
    
    public List<UnidadeMedidaDTO> getUnidades() {
        return unidades;
    }
    
    public void setUnidades(List<UnidadeMedidaDTO> unidades) {
        this.unidades = unidades;
    }
    
    public List<TipoUnidadeMedida> getTiposUnidade() {
        return tiposUnidade;
    }
    
    public void setTiposUnidade(List<TipoUnidadeMedida> tiposUnidade) {
        this.tiposUnidade = tiposUnidade;
    }
    
    public UnidadeMedidaDTO getNovaUnidade() {
        return novaUnidade;
    }
    
    public void setNovaUnidade(UnidadeMedidaDTO novaUnidade) {
        this.novaUnidade = novaUnidade;
    }
    
    public UnidadeMedidaDTO getUnidadeSelecionada() {
        return unidadeSelecionada;
    }
    
    public void setUnidadeSelecionada(UnidadeMedidaDTO unidadeSelecionada) {
        this.unidadeSelecionada = unidadeSelecionada;
    }
}