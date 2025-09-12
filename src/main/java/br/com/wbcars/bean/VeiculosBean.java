package br.com.wbcars.bean;

import br.com.wbcars.dto.ClienteDTO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import br.com.wbcars.dto.VeiculoDTO;
import br.com.wbcars.facade.WBCarsFacade;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.context.FacesContext;
import jakarta.faces.application.FacesMessage;

@Named
@ViewScoped
public class VeiculosBean implements Serializable {
    private List<ClienteDTO> clientes;

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(VeiculosBean.class.getName());

    @Inject
    private HeaderBean headerBean;

    private VeiculoDTO novoVeiculo = new VeiculoDTO();
    private VeiculoDTO veiculoSelecionado;
    private List<VeiculoDTO> veiculos;
    private String campoBusca;
    private String valorBusca;

    @Inject
    private WBCarsFacade facade;

    public void init() {
        LOGGER.info("Inicializando página de Veículos");
        novoVeiculo = new VeiculoDTO();
        clientes = facade.findAllClientes();
        buscarVeiculos();
        LOGGER.info("Página inicializada com sucesso");
    }

    public void buscarVeiculos() {
        if (campoBusca != null && valorBusca != null && !valorBusca.isEmpty()) {
            switch (campoBusca) {
                case "id":
                    try {
                        Long id = Long.parseLong(valorBusca.trim());
                        VeiculoDTO veiculo = facade.findVeiculoById(id);
                        veiculos = veiculo != null ? List.of(veiculo) : List.of();
                    } catch (NumberFormatException e) {
                        // Adicione mensagem de erro se quiser
                        veiculos = List.of();
                    }
                    break;
                case "placa":
                    veiculos = facade.findAllVeiculos().stream()
                        .filter(v -> v.getPlaca() != null && v.getPlaca().toLowerCase().contains(valorBusca.trim().toLowerCase()))
                        .toList();
                    break;
                case "modelo":
                    veiculos = facade.findAllVeiculos().stream()
                        .filter(v -> v.getModelo() != null && v.getModelo().toLowerCase().contains(valorBusca.trim().toLowerCase()))
                        .toList();
                    break;
                case "marca":
                    veiculos = facade.findAllVeiculos().stream()
                        .filter(v -> v.getMarca() != null && v.getMarca().toLowerCase().contains(valorBusca.trim().toLowerCase()))
                        .toList();
                    break;
                default:
                    veiculos = facade.findAllVeiculos();
            }
        } else {
            veiculos = facade.findAllVeiculos();
        }
    }

    public void limparFiltros() {
        campoBusca = null;
        valorBusca = null;
        buscarVeiculos();
    }

    public void abrirDialogNovoVeiculo() {
        novoVeiculo = new VeiculoDTO();
    }

    public void prepararEdicao(VeiculoDTO veiculo) {
        veiculoSelecionado = veiculo;
    }

    public void prepararExclusao(VeiculoDTO veiculo) {
        veiculoSelecionado = veiculo;
    }

    public void salvarVeiculo() {
        try {
            if (novoVeiculo.getModelo() == null || novoVeiculo.getModelo().trim().isEmpty()) {
                adicionarMensagemErro("Modelo do veículo é obrigatório");
                return;
            }
            if (novoVeiculo.getMarca() == null || novoVeiculo.getMarca().trim().isEmpty()) {
                adicionarMensagemErro("Marca do veículo é obrigatória");
                return;
            }
            if (novoVeiculo.getPlaca() == null || novoVeiculo.getPlaca().trim().isEmpty()) {
                adicionarMensagemErro("Placa do veículo é obrigatória");
                return;
            }
            if (novoVeiculo.getCliente() == null) {
                adicionarMensagemErro("Selecione o cliente do veículo");
                return;
            }
            novoVeiculo.setDataCadastro(java.time.LocalDateTime.now());
            facade.saveVeiculo(novoVeiculo);
            buscarVeiculos();
            novoVeiculo = new VeiculoDTO();
            adicionarMensagemSucesso("Veículo cadastrado com sucesso!");
        } catch (Exception e) {
            adicionarMensagemErro("Erro ao salvar veículo: " + e.getMessage());
        }
    }

    public void editarVeiculo() {
        try {
            if (veiculoSelecionado == null) {
                adicionarMensagemErro("Nenhum veículo selecionado");
                return;
            }
            if (veiculoSelecionado.getModelo() == null || veiculoSelecionado.getModelo().trim().isEmpty()) {
                adicionarMensagemErro("Modelo do veículo é obrigatório");
                return;
            }
            if (veiculoSelecionado.getMarca() == null || veiculoSelecionado.getMarca().trim().isEmpty()) {
                adicionarMensagemErro("Marca do veículo é obrigatória");
                return;
            }
            if (veiculoSelecionado.getPlaca() == null || veiculoSelecionado.getPlaca().trim().isEmpty()) {
                adicionarMensagemErro("Placa do veículo é obrigatória");
                return;
            }
            if (veiculoSelecionado.getCliente() == null) {
                adicionarMensagemErro("Selecione o cliente do veículo");
                return;
            }
            veiculoSelecionado.setDataAlteracao(java.time.LocalDateTime.now());
            facade.updateVeiculo(veiculoSelecionado);
            buscarVeiculos();
            veiculoSelecionado = null;
            adicionarMensagemSucesso("Veículo atualizado com sucesso!");
        } catch (Exception e) {
            adicionarMensagemErro("Erro ao editar veículo: " + e.getMessage());
        }
    }
    public List<ClienteDTO> getClientes() { return clientes; }
    public void setClientes(List<ClienteDTO> clientes) { this.clientes = clientes; }

    public void excluirVeiculo() {
        try {
            if (veiculoSelecionado != null && veiculoSelecionado.getId() != null) {
                facade.deleteVeiculo(veiculoSelecionado.getId());
                buscarVeiculos();
                veiculoSelecionado = null;
                adicionarMensagemSucesso("Veículo excluído com sucesso!");
            } else {
                adicionarMensagemErro("Nenhum veículo selecionado para exclusão");
            }
        } catch (Exception e) {
            adicionarMensagemErro("Erro ao excluir veículo: " + e.getMessage());
        }
    }
    // Métodos de mensagem (igual Cidade)
    private void adicionarMensagemSucesso(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
    }

    private void adicionarMensagemErro(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
    }

    // Getters e Setters
    public HeaderBean getHeaderBean() { return headerBean; }
    public VeiculoDTO getNovoVeiculo() { return novoVeiculo; }
    public void setNovoVeiculo(VeiculoDTO novoVeiculo) { this.novoVeiculo = novoVeiculo; }
    public VeiculoDTO getVeiculoSelecionado() { return veiculoSelecionado; }
    public void setVeiculoSelecionado(VeiculoDTO veiculoSelecionado) { this.veiculoSelecionado = veiculoSelecionado; }
    public List<VeiculoDTO> getVeiculos() { return veiculos; }
    public void setVeiculos(List<VeiculoDTO> veiculos) { this.veiculos = veiculos; }
    public String getCampoBusca() { return campoBusca; }
    public void setCampoBusca(String campoBusca) { this.campoBusca = campoBusca; }
    public String getValorBusca() { return valorBusca; }
    public void setValorBusca(String valorBusca) { this.valorBusca = valorBusca; }
}