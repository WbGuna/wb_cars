package br.com.wbcars.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import br.com.wbcars.dto.CidadeDTO;
import br.com.wbcars.dto.ClienteDTO;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.facade.WBCarsFacade;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ClientesBean implements Serializable {
   
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ClientesBean.class.getName());

    @Inject
    private HeaderBean headerBean;

    @Inject
    private WBCarsFacade facade;

    private ClienteDTO novoCliente = new ClienteDTO();
    private ClienteDTO clienteSelecionado;
    private List<ClienteDTO> clientes;
    private String campoBusca;
    private String valorBusca;
    
    private List<CidadeDTO> listaCidades;
    private List<StatusGeral> listaStatus;

    public void init() {
        LOGGER.info("Inicializando página de Clientes");
        novoCliente = new ClienteDTO();
        listaCidades = facade.findAllCidades();
        listaStatus = Arrays.asList(br.com.wbcars.enuns.StatusGeral.values());
        buscarClientes();
        LOGGER.info("Página de Clientes inicializada");
    }

    public void buscarClientes() {
        if (campoBusca != null && valorBusca != null && !valorBusca.isEmpty()) {
            String busca = valorBusca.trim().toLowerCase();
            switch (campoBusca) {
                case "id":
                    try {
                        Long id = Long.parseLong(busca);
                        ClienteDTO cliente = facade.findClienteById(id);
                        clientes = cliente != null ? List.of(cliente) : List.of();
                    } catch (NumberFormatException e) {
                        clientes = List.of();
                    }
                    break;
                case "nome":
                    clientes = facade.findAllClientes().stream()
                        .filter(c -> c.getNome() != null && c.getNome().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "cpfCnpj":
                    clientes = facade.findAllClientes().stream()
                        .filter(c -> c.getCpfCnpj() != null && c.getCpfCnpj().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "email":
                    clientes = facade.findAllClientes().stream()
                        .filter(c -> c.getEmail() != null && c.getEmail().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "celular":
                    clientes = facade.findAllClientes().stream()
                        .filter(c -> c.getCelular() != null && c.getCelular().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "rua":
                    clientes = facade.findAllClientes().stream()
                        .filter(c -> c.getRua() != null && c.getRua().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "bairro":
                    clientes = facade.findAllClientes().stream()
                        .filter(c -> c.getBairro() != null && c.getBairro().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "status":
                    clientes = facade.findAllClientes().stream()
                        .filter(c -> c.getStatus() != null && c.getStatus().getDescricao() != null && c.getStatus().getDescricao().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "dataNascimento":
                    clientes = facade.findAllClientes().stream()
                        .filter(c -> c.getDataNascimento() != null && c.getDataNascimento().toString().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "cidade":
                    clientes = facade.findAllClientes().stream()
                        .filter(c -> c.getCidade() != null && c.getCidade().getNome() != null && c.getCidade().getNome().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "dataCadastro":
                    clientes = facade.findAllClientes().stream()
                        .filter(c -> c.getDataCadastro() != null && c.getDataCadastro().toString().toLowerCase().contains(busca))
                        .toList();
                    break;
                case "dataAlteracao":
                    clientes = facade.findAllClientes().stream()
                        .filter(c -> c.getDataAlteracao() != null && c.getDataAlteracao().toString().toLowerCase().contains(busca))
                        .toList();
                    break;
                default:
                    clientes = facade.findAllClientes();
            }
        } else {
            clientes = facade.findAllClientes();
        }
    }

    public void limparFiltros() {
        campoBusca = null;
        valorBusca = null;
        buscarClientes();
    }

    public void abrirDialogNovoCliente() {
        novoCliente = new ClienteDTO();
    }

    public void prepararEdicao(ClienteDTO cliente) {
        LOGGER.info("Chamando prepararEdicao para cliente: " + (cliente != null ? cliente.getId() : "null"));
        clienteSelecionado = cliente;
        if (clienteSelecionado != null) {
            LOGGER.info("clienteSelecionado populado: " + clienteSelecionado.getId() + " - " + clienteSelecionado.getNome());
        } else {
            LOGGER.warning("clienteSelecionado está nulo após prepararEdicao!");
        }
    }

    public void prepararExclusao(ClienteDTO cliente) {
        clienteSelecionado = cliente;
    }

    public void salvarCliente() {
        try {
            if (novoCliente.getNome() == null || novoCliente.getNome().trim().isEmpty()) {
                adicionarMensagemErro("Nome do cliente é obrigatório");
                return;
            }
            if (novoCliente.getCpfCnpj() == null || novoCliente.getCpfCnpj().trim().isEmpty()) {
                adicionarMensagemErro("CPF/CNPJ do cliente é obrigatório");
                return;
            }
            novoCliente.setDataCadastro(java.time.LocalDateTime.now());
            facade.saveCliente(novoCliente);
            buscarClientes();
            novoCliente = new ClienteDTO();
            adicionarMensagemSucesso("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            adicionarMensagemErro("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public void editarCliente() {
        LOGGER.info("Chamando editarCliente");
        try {
            if (clienteSelecionado == null) {
                LOGGER.warning("clienteSelecionado está nulo em editarCliente!");
                adicionarMensagemErro("Nenhum cliente selecionado");
                return;
            }
            LOGGER.info("Editando cliente: " + clienteSelecionado.getId() + " - " + clienteSelecionado.getNome());
            if (clienteSelecionado.getNome() == null || clienteSelecionado.getNome().trim().isEmpty()) {
                adicionarMensagemErro("Nome do cliente é obrigatório");
                return;
            }
            if (clienteSelecionado.getCpfCnpj() == null || clienteSelecionado.getCpfCnpj().trim().isEmpty()) {
                adicionarMensagemErro("CPF/CNPJ do cliente é obrigatório");
                return;
            }
            clienteSelecionado.setDataAlteracao(java.time.LocalDateTime.now());
            facade.updateCliente(clienteSelecionado);
            buscarClientes();
            clienteSelecionado = null;
            adicionarMensagemSucesso("Cliente atualizado com sucesso!");
        } catch (Exception e) {
            LOGGER.severe("Erro ao editar cliente: " + e.getMessage());
            adicionarMensagemErro("Erro ao editar cliente: " + e.getMessage());
        }
    }

    public void excluirCliente() {
        try {
            if (clienteSelecionado != null && clienteSelecionado.getId() != null) {
                facade.deleteCliente(clienteSelecionado.getId());
                buscarClientes();
                clienteSelecionado = null;
                adicionarMensagemSucesso("Cliente excluído com sucesso!");
            } else {
                adicionarMensagemErro("Nenhum cliente selecionado para exclusão");
            }
        } catch (Exception e) {
            adicionarMensagemErro("Erro ao excluir cliente: " + e.getMessage());
        }
    }
    
    public void validarCpfCnpj(jakarta.faces.context.FacesContext context, jakarta.faces.component.UIComponent component, Object value) {
        String doc = (value != null) ? value.toString().replaceAll("\\D", "") : "";
        if (doc.length() == 11) {
            // CPF
            if (!validarCpf(doc)) {
                throw new jakarta.faces.validator.ValidatorException(
                    new jakarta.faces.application.FacesMessage(jakarta.faces.application.FacesMessage.SEVERITY_ERROR, "CPF inválido!", null)
                );
            }
        } else if (doc.length() == 14) {
            // CNPJ
            if (!validarCnpj(doc)) {
                throw new jakarta.faces.validator.ValidatorException(
                    new jakarta.faces.application.FacesMessage(jakarta.faces.application.FacesMessage.SEVERITY_ERROR, "CNPJ inválido!", null)
                );
            }
        } else {
            throw new jakarta.faces.validator.ValidatorException(
                new jakarta.faces.application.FacesMessage(jakarta.faces.application.FacesMessage.SEVERITY_ERROR, "Documento deve ser CPF ou CNPJ válido!", null)
            );
        }
    }

    private boolean validarCpf(String cpf) {
    cpf = cpf.replaceAll("\\D", ""); // Remove tudo que não é número
    if (cpf.length() != 11 || cpf.chars().distinct().count() == 1) return false;
        int d1 = 0, d2 = 0;
        for (int i = 0; i < 9; i++) {
            int digito = cpf.charAt(i) - '0';
            d1 += digito * (10 - i);
            d2 += digito * (11 - i);
        }
        d1 = 11 - (d1 % 11);
        if (d1 >= 10) d1 = 0;
        d2 += d1 * 2;
        d2 = 11 - (d2 % 11);
        if (d2 >= 10) d2 = 0;
        return d1 == (cpf.charAt(9) - '0') && d2 == (cpf.charAt(10) - '0');
    }

    private boolean validarCnpj(String cnpj) {
        if (cnpj.chars().distinct().count() == 1) return false;
        int[] pesos1 = {5,4,3,2,9,8,7,6,5,4,3,2};
        int[] pesos2 = {6,5,4,3,2,9,8,7,6,5,4,3,2};
        int soma1 = 0, soma2 = 0;
        for (int i = 0; i < 12; i++) soma1 += (cnpj.charAt(i) - '0') * pesos1[i];
        int d1 = soma1 % 11;
        d1 = (d1 < 2) ? 0 : 11 - d1;
        for (int i = 0; i < 12; i++) soma2 += (cnpj.charAt(i) - '0') * pesos2[i];
        soma2 += d1 * pesos2[12];
        int d2 = soma2 % 11;
        d2 = (d2 < 2) ? 0 : 11 - d2;
        return d1 == (cnpj.charAt(12) - '0') && d2 == (cnpj.charAt(13) - '0');
    }
    public void validarEmail(jakarta.faces.context.FacesContext context, jakarta.faces.component.UIComponent component, Object value) {
        String email = (value != null) ? value.toString() : "";
        if (!email.contains("@")) {
            throw new jakarta.faces.validator.ValidatorException(
                new jakarta.faces.application.FacesMessage(jakarta.faces.application.FacesMessage.SEVERITY_ERROR, "Email inválido! Deve conter '@'", null)
            );
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
    public ClienteDTO getNovoCliente() { return novoCliente; }
    public void setNovoCliente(ClienteDTO novoCliente) { this.novoCliente = novoCliente; }
    public ClienteDTO getClienteSelecionado() { return clienteSelecionado; }
    public void setClienteSelecionado(ClienteDTO clienteSelecionado) { this.clienteSelecionado = clienteSelecionado; }
    public List<ClienteDTO> getClientes() { return clientes; }
    public void setClientes(List<ClienteDTO> clientes) { this.clientes = clientes; }
    public String getCampoBusca() { return campoBusca; }
    public void setCampoBusca(String campoBusca) { this.campoBusca = campoBusca; }
    public String getValorBusca() { return valorBusca; }
    public void setValorBusca(String valorBusca) { this.valorBusca = valorBusca; }
    public List<CidadeDTO> getListaCidades() { return listaCidades; }
    public List<br.com.wbcars.enuns.StatusGeral> getListaStatus() { return listaStatus; }
}
