
package br.com.wbcars.bean;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import br.com.wbcars.dto.ProdutoDTO;
import br.com.wbcars.dto.FornecedorDTO;
import br.com.wbcars.dto.UnidadeMedidaDTO;
import br.com.wbcars.facade.WBCarsFacade;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ProdutosBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ProdutosBean.class.getName());

    @Inject
    private HeaderBean headerBean;

    @Inject
    private WBCarsFacade facade;

    private ProdutoDTO novoProduto = new ProdutoDTO();
    private ProdutoDTO produtoSelecionado;
    private List<ProdutoDTO> produtos;
    private String campoBusca;
    private String valorBusca;

    private List<FornecedorDTO> listaFornecedores;
    private List<UnidadeMedidaDTO> listaUnidades;

    public void init() {
        LOGGER.info("Inicializando página de Produtos");
        novoProduto = new ProdutoDTO();
        listaFornecedores = facade.findAllFornecedores();
    listaUnidades = facade.findAllUnidadeMedidas();
        buscarProdutos();
        LOGGER.info("Página de Produtos inicializada");
    }

    public void buscarProdutos() {
        if (campoBusca != null && valorBusca != null && !valorBusca.isEmpty()) {
            String busca = valorBusca.trim().toLowerCase();
            switch (campoBusca) {
                case "id":
                    try {
                        Long id = Long.parseLong(busca);
                        ProdutoDTO produto = facade.findProdutoById(id);
                        produtos = produto != null ? List.of(produto) : List.of();
                    } catch (NumberFormatException e) {
                        produtos = List.of();
                    }
                    break;
                case "nome":
                    produtos = facade.findAllProdutos().stream()
                        .filter(p -> p.getNome() != null && p.getNome().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "fornecedor":
                    produtos = facade.findAllProdutos().stream()
                        .filter(p -> p.getFornecedor() != null && p.getFornecedor().getNome() != null && p.getFornecedor().getNome().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "unidadeMedida":
                    produtos = facade.findAllProdutos().stream()
                        .filter(p -> p.getUnidadeMedida() != null && p.getUnidadeMedida().getTipo() != null && p.getUnidadeMedida().getTipo().toString().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "dataCadastro":
                    produtos = facade.findAllProdutos().stream()
                        .filter(p -> p.getDataCadastro() != null && p.getDataCadastro().toString().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "dataAlteracao":
                    produtos = facade.findAllProdutos().stream()
                        .filter(p -> p.getDataAlteracao() != null && p.getDataAlteracao().toString().toLowerCase().contains(busca))
                        .toList();
                    break;
                default:
                    produtos = facade.findAllProdutos();
            }
        } else {
            produtos = facade.findAllProdutos();
        }
    }

    public void limparFiltros() {
        campoBusca = null;
        valorBusca = null;
        buscarProdutos();
    }

    public void abrirDialogNovoProduto() {
        novoProduto = new ProdutoDTO();
    }

    public void prepararEdicao(ProdutoDTO produto) {
        LOGGER.info("Chamando prepararEdicao para produto: " + (produto != null ? produto.getId() : "null"));
        produtoSelecionado = produto;
        if (produtoSelecionado != null) {
            LOGGER.info("produtoSelecionado populado: " + produtoSelecionado.getId() + " - " + produtoSelecionado.getNome());
        } else {
            LOGGER.warning("produtoSelecionado está nulo após prepararEdicao!");
        }
    }

    public void prepararExclusao(ProdutoDTO produto) {
        produtoSelecionado = produto;
    }

    public void salvarProduto() {
        try {
            if (novoProduto.getNome() == null || novoProduto.getNome().trim().isEmpty()) {
                adicionarMensagemErro("Nome do produto é obrigatório");
                return;
            }
            if (novoProduto.getFornecedor() == null) {
                adicionarMensagemErro("Fornecedor é obrigatório");
                return;
            }
            if (novoProduto.getUnidadeMedida() == null) {
                adicionarMensagemErro("Unidade de medida é obrigatória");
                return;
            }
            novoProduto.setDataCadastro(java.time.LocalDateTime.now());
            facade.saveProduto(novoProduto);
            buscarProdutos();
            novoProduto = new ProdutoDTO();
            adicionarMensagemSucesso("Produto cadastrado com sucesso!");
        } catch (Exception e) {
            adicionarMensagemErro("Erro ao salvar produto: " + e.getMessage());
        }
    }

    public void editarProduto() {
        LOGGER.info("Chamando editarProduto");
        try {
            if (produtoSelecionado == null) {
                LOGGER.warning("produtoSelecionado está nulo em editarProduto!");
                adicionarMensagemErro("Nenhum produto selecionado");
                return;
            }
            LOGGER.info("Editando produto: " + produtoSelecionado.getId() + " - " + produtoSelecionado.getNome());
            if (produtoSelecionado.getNome() == null || produtoSelecionado.getNome().trim().isEmpty()) {
                adicionarMensagemErro("Nome do produto é obrigatório");
                return;
            }
            if (produtoSelecionado.getFornecedor() == null) {
                adicionarMensagemErro("Fornecedor é obrigatório");
                return;
            }
            if (produtoSelecionado.getUnidadeMedida() == null) {
                adicionarMensagemErro("Unidade de medida é obrigatória");
                return;
            }
            produtoSelecionado.setDataAlteracao(java.time.LocalDateTime.now());
            facade.updateProduto(produtoSelecionado);
            buscarProdutos();
            produtoSelecionado = null;
            adicionarMensagemSucesso("Produto atualizado com sucesso!");
        } catch (Exception e) {
            LOGGER.severe("Erro ao editar produto: " + e.getMessage());
            adicionarMensagemErro("Erro ao editar produto: " + e.getMessage());
        }
    }

    public void excluirProduto() {
        try {
            if (produtoSelecionado != null && produtoSelecionado.getId() != null) {
                facade.deleteProduto(produtoSelecionado.getId());
                buscarProdutos();
                produtoSelecionado = null;
                adicionarMensagemSucesso("Produto excluído com sucesso!");
            } else {
                adicionarMensagemErro("Nenhum produto selecionado para exclusão");
            }
        } catch (Exception e) {
            adicionarMensagemErro("Erro ao excluir produto: " + e.getMessage());
        }
    }

    private void adicionarMensagemSucesso(String msg) {
        jakarta.faces.context.FacesContext.getCurrentInstance().addMessage(null, new jakarta.faces.application.FacesMessage(jakarta.faces.application.FacesMessage.SEVERITY_INFO, msg, null));
    }

    private void adicionarMensagemErro(String msg) {
        jakarta.faces.context.FacesContext.getCurrentInstance().addMessage(null, new jakarta.faces.application.FacesMessage(jakarta.faces.application.FacesMessage.SEVERITY_ERROR, msg, null));
    }

    // Getters e Setters
    public HeaderBean getHeaderBean() { return headerBean; }
    public ProdutoDTO getNovoProduto() { return novoProduto; }
    public void setNovoProduto(ProdutoDTO novoProduto) { this.novoProduto = novoProduto; }
    public ProdutoDTO getProdutoSelecionado() { return produtoSelecionado; }
    public void setProdutoSelecionado(ProdutoDTO produtoSelecionado) { this.produtoSelecionado = produtoSelecionado; }
    public List<ProdutoDTO> getProdutos() { return produtos; }
    public void setProdutos(List<ProdutoDTO> produtos) { this.produtos = produtos; }
    public String getCampoBusca() { return campoBusca; }
    public void setCampoBusca(String campoBusca) { this.campoBusca = campoBusca; }
    public String getValorBusca() { return valorBusca; }
    public void setValorBusca(String valorBusca) { this.valorBusca = valorBusca; }
    public List<FornecedorDTO> getListaFornecedores() { return listaFornecedores; }
    public List<UnidadeMedidaDTO> getListaUnidades() { return listaUnidades; }
}
