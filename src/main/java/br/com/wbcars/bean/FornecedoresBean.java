package br.com.wbcars.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import br.com.wbcars.dto.CidadeDTO;
import br.com.wbcars.dto.FornecedorDTO;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.facade.WBCarsFacade;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class FornecedoresBean implements Serializable {
   
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(FornecedoresBean.class.getName());

	@Inject
	private HeaderBean headerBean;

	@Inject
	private WBCarsFacade facade;

	private FornecedorDTO novoFornecedor = new FornecedorDTO();
	private FornecedorDTO fornecedorSelecionado;
	private List<FornecedorDTO> fornecedores;
	private String campoBusca;
	private String valorBusca;
    
	private List<CidadeDTO> listaCidades;
	private List<StatusGeral> listaStatus;

	public void init() {
		LOGGER.info("Inicializando página de Fornecedores");
		novoFornecedor = new FornecedorDTO();
		listaCidades = facade.findAllCidades();
		listaStatus = Arrays.asList(br.com.wbcars.enuns.StatusGeral.values());
		buscarFornecedores();
		LOGGER.info("Página de Fornecedores inicializada");
	}

	public void buscarFornecedores() {
		if (campoBusca != null && valorBusca != null && !valorBusca.isEmpty()) {
			String busca = valorBusca.trim().toLowerCase();
			switch (campoBusca) {
				case "id":
					try {
						Long id = Long.parseLong(busca);
						FornecedorDTO fornecedor = facade.findFornecedorById(id);
						fornecedores = fornecedor != null ? List.of(fornecedor) : List.of();
					} catch (NumberFormatException e) {
						fornecedores = List.of();
					}
					break;
				case "nome":
					fornecedores = facade.findAllFornecedores().stream()
						.filter(f -> f.getNome() != null && f.getNome().toLowerCase().contains(busca))
						.toList();
					break;
				case "cpfCnpj":
					fornecedores = facade.findAllFornecedores().stream()
						.filter(f -> f.getCpfCnpj() != null && f.getCpfCnpj().toLowerCase().contains(busca))
						.toList();
					break;
				case "email":
					fornecedores = facade.findAllFornecedores().stream()
						.filter(f -> f.getEmail() != null && f.getEmail().toLowerCase().contains(busca))
						.toList();
					break;
				case "telefone":
					fornecedores = facade.findAllFornecedores().stream()
						.filter(f -> f.getTelefone() != null && f.getTelefone().toLowerCase().contains(busca))
						.toList();
					break;
				case "rua":
					fornecedores = facade.findAllFornecedores().stream()
						.filter(f -> f.getRua() != null && f.getRua().toLowerCase().contains(busca))
						.toList();
					break;
				case "bairro":
					fornecedores = facade.findAllFornecedores().stream()
						.filter(f -> f.getBairro() != null && f.getBairro().toLowerCase().contains(busca))
						.toList();
					break;
				case "status":
					fornecedores = facade.findAllFornecedores().stream()
						.filter(f -> f.getStatus() != null && f.getStatus().getDescricao() != null && f.getStatus().getDescricao().toLowerCase().contains(busca))
						.toList();
					break;
				case "cidade":
					fornecedores = facade.findAllFornecedores().stream()
						.filter(f -> f.getCidade() != null && f.getCidade().getNome() != null && f.getCidade().getNome().toLowerCase().contains(busca))
						.toList();
					break;
				case "dataCadastro":
					fornecedores = facade.findAllFornecedores().stream()
						.filter(f -> f.getDataCadastro() != null && f.getDataCadastro().toString().toLowerCase().contains(busca))
						.toList();
					break;
				case "dataAlteracao":
					fornecedores = facade.findAllFornecedores().stream()
						.filter(f -> f.getDataAlteracao() != null && f.getDataAlteracao().toString().toLowerCase().contains(busca))
						.toList();
					break;
				default:
					fornecedores = facade.findAllFornecedores();
			}
		} else {
			fornecedores = facade.findAllFornecedores();
		}
	}

	public void limparFiltros() {
		campoBusca = null;
		valorBusca = null;
		buscarFornecedores();
	}

	public void abrirDialogNovoFornecedor() {
		novoFornecedor = new FornecedorDTO();
	}

	public void prepararEdicao(FornecedorDTO fornecedor) {
		LOGGER.info("Chamando prepararEdicao para fornecedor: " + (fornecedor != null ? fornecedor.getId() : "null"));
		fornecedorSelecionado = fornecedor;
		if (fornecedorSelecionado != null) {
			LOGGER.info("fornecedorSelecionado populado: " + fornecedorSelecionado.getId() + " - " + fornecedorSelecionado.getNome());
		} else {
			LOGGER.warning("fornecedorSelecionado está nulo após prepararEdicao!");
		}
	}

	public void prepararExclusao(FornecedorDTO fornecedor) {
		fornecedorSelecionado = fornecedor;
	}

	public void salvarFornecedor() {
		try {
			if (novoFornecedor.getNome() == null || novoFornecedor.getNome().trim().isEmpty()) {
				adicionarMensagemErro("Nome do fornecedor é obrigatório");
				return;
			}
			if (novoFornecedor.getCpfCnpj() == null || novoFornecedor.getCpfCnpj().trim().isEmpty()) {
				adicionarMensagemErro("CPF/CNPJ do fornecedor é obrigatório");
				return;
			}
			novoFornecedor.setDataCadastro(java.time.LocalDateTime.now());
			facade.saveFornecedor(novoFornecedor);
			buscarFornecedores();
			novoFornecedor = new FornecedorDTO();
			adicionarMensagemSucesso("Fornecedor cadastrado com sucesso!");
		} catch (Exception e) {
			adicionarMensagemErro("Erro ao salvar fornecedor: " + e.getMessage());
		}
	}

	public void editarFornecedor() {
		LOGGER.info("Chamando editarFornecedor");
		try {
			if (fornecedorSelecionado == null) {
				LOGGER.warning("fornecedorSelecionado está nulo em editarFornecedor!");
				adicionarMensagemErro("Nenhum fornecedor selecionado");
				return;
			}
			LOGGER.info("Editando fornecedor: " + fornecedorSelecionado.getId() + " - " + fornecedorSelecionado.getNome());
			if (fornecedorSelecionado.getNome() == null || fornecedorSelecionado.getNome().trim().isEmpty()) {
				adicionarMensagemErro("Nome do fornecedor é obrigatório");
				return;
			}
			if (fornecedorSelecionado.getCpfCnpj() == null || fornecedorSelecionado.getCpfCnpj().trim().isEmpty()) {
				adicionarMensagemErro("CPF/CNPJ do fornecedor é obrigatório");
				return;
			}
			fornecedorSelecionado.setDataAlteracao(java.time.LocalDateTime.now());
			facade.updateFornecedor(fornecedorSelecionado);
			buscarFornecedores();
			fornecedorSelecionado = null;
			adicionarMensagemSucesso("Fornecedor atualizado com sucesso!");
		} catch (Exception e) {
			LOGGER.severe("Erro ao editar fornecedor: " + e.getMessage());
			adicionarMensagemErro("Erro ao editar fornecedor: " + e.getMessage());
		}
	}

	public void excluirFornecedor() {
		try {
			if (fornecedorSelecionado != null && fornecedorSelecionado.getId() != null) {
				facade.deleteFornecedor(fornecedorSelecionado.getId());
				buscarFornecedores();
				fornecedorSelecionado = null;
				adicionarMensagemSucesso("Fornecedor excluído com sucesso!");
			} else {
				adicionarMensagemErro("Nenhum fornecedor selecionado para exclusão");
			}
		} catch (Exception e) {
			adicionarMensagemErro("Erro ao excluir fornecedor: " + e.getMessage());
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
	public FornecedorDTO getNovoFornecedor() { return novoFornecedor; }
	public void setNovoFornecedor(FornecedorDTO novoFornecedor) { this.novoFornecedor = novoFornecedor; }
	public FornecedorDTO getFornecedorSelecionado() { return fornecedorSelecionado; }
	public void setFornecedorSelecionado(FornecedorDTO fornecedorSelecionado) { this.fornecedorSelecionado = fornecedorSelecionado; }
	public List<FornecedorDTO> getFornecedores() { return fornecedores; }
	public void setFornecedores(List<FornecedorDTO> fornecedores) { this.fornecedores = fornecedores; }
	public String getCampoBusca() { return campoBusca; }
	public void setCampoBusca(String campoBusca) { this.campoBusca = campoBusca; }
	public String getValorBusca() { return valorBusca; }
	public void setValorBusca(String valorBusca) { this.valorBusca = valorBusca; }
	public List<CidadeDTO> getListaCidades() { return listaCidades; }
	public List<br.com.wbcars.enuns.StatusGeral> getListaStatus() { return listaStatus; }
}
