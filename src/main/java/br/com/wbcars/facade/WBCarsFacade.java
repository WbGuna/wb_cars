package br.com.wbcars.facade;

import br.com.wbcars.controller.*;
import br.com.wbcars.dto.*;
import br.com.wbcars.enuns.*;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Facade para o sistema WB Cars.
 * Esta classe fornece uma interface única para acesso a todas as controllers do sistema.
 * Implementa o padrão Facade, encapsulando todas as controllers e delegando chamadas a seus métodos.
 * 
 * Objetivo: Simplificar a interface para os clientes do sistema (como beans, servlets, etc),
 * fornecendo um ponto único de acesso para toda a funcionalidade.
 * 
 * @author WB Cars Team
 */
@Named
@ApplicationScoped
public class WBCarsFacade {
    
    // Controllers
    private final AgendamentoServicoController agendamentoServicoController;
    private final CidadeController cidadeController;
    private final ClienteController clienteController;
    private final ContaPagarController contaPagarController;
    private final ControleEstoqueController controleEstoqueController;
    private final FornecedorController fornecedorController;
    private final FuncionarioController funcionarioController;
    private final OrcamentoController orcamentoController;
    private final OrdemServicoController ordemServicoController;
    private final ProdutoController produtoController;
    private final RelatorioFinanceiroController relatorioFinanceiroController;
    private final RelatorioFinanceiroDetalhadoController relatorioFinanceiroDetalhadoController;
    private final UnidadeMedidaController unidadeMedidaController;
    private final VeiculoController veiculoController;
    private final VendaController vendaController;
    
    public WBCarsFacade() {
        // Inicializa todos os controllers usando Singleton
        this.agendamentoServicoController = AgendamentoServicoController.getInstance();
        this.cidadeController = CidadeController.getInstance();
        this.clienteController = ClienteController.getInstance();
        this.contaPagarController = ContaPagarController.getInstance();
        this.controleEstoqueController = ControleEstoqueController.getInstance();
        this.fornecedorController = FornecedorController.getInstance();
        this.funcionarioController = FuncionarioController.getInstance();
        this.orcamentoController = OrcamentoController.getInstance();
        this.ordemServicoController = OrdemServicoController.getInstance();
        this.produtoController = ProdutoController.getInstance();
        this.relatorioFinanceiroController = RelatorioFinanceiroController.getInstance();
        this.relatorioFinanceiroDetalhadoController = RelatorioFinanceiroDetalhadoController.getInstance();
        this.unidadeMedidaController = UnidadeMedidaController.getInstance();
        this.veiculoController = VeiculoController.getInstance();
        this.vendaController = VendaController.getInstance();
    }
    
    // =====================================================================
    // MÉTODOS PARA CLIENTE
    // =====================================================================
    
    public ClienteDTO saveCliente(ClienteDTO dto) {
        return clienteController.save(dto);
    }
    
    public ClienteDTO updateCliente(ClienteDTO dto) {
        return clienteController.update(dto);
    }
    
    public void deleteCliente(Long id) {
        clienteController.delete(id);
    }
    
    public ClienteDTO findClienteById(Long id) {
        return clienteController.findById(id);
    }
    
    public List<ClienteDTO> findAllClientes() {
        return clienteController.findAll();
    }
    
    public List<ClienteDTO> findClienteByNome(String nome) {
        return clienteController.findByNome(nome);
    }
    
    public ClienteDTO findClienteByCpfCnpj(String cpfCnpj) {
        return clienteController.findByCpfCnpj(cpfCnpj);
    }
    
    public List<ClienteDTO> findClienteByEmail(String email) {
        return clienteController.findByEmail(email);
    }
    
    public List<ClienteDTO> findClienteByCelular(String celular) {
        return clienteController.findByCelular(celular);
    }
    
    public List<ClienteDTO> findClienteByCidade(Long cidadeId) {
        return clienteController.findByCidade(cidadeId);
    }
    
    public List<ClienteDTO> findClienteByStatus(StatusGeral status) {
        return clienteController.findByStatus(status);
    }
    
    public List<ClienteDTO> findClienteByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return clienteController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<ClienteDTO> findClienteByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return clienteController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA VEÍCULO
    // =====================================================================
    
    public VeiculoDTO saveVeiculo(VeiculoDTO dto) {
        return veiculoController.save(dto);
    }
    
    public VeiculoDTO updateVeiculo(VeiculoDTO dto) {
        return veiculoController.update(dto);
    }
    
    public void deleteVeiculo(Long id) {
        veiculoController.delete(id);
    }
    
    public VeiculoDTO findVeiculoById(Long id) {
        return veiculoController.findById(id);
    }
    
    public List<VeiculoDTO> findAllVeiculos() {
        return veiculoController.findAll();
    }
    
    public List<VeiculoDTO> findVeiculoByPlaca(String placa) {
        return veiculoController.findByPlaca(placa);
    }
    
    public List<VeiculoDTO> findVeiculoByModelo(String modelo) {
        return veiculoController.findByModelo(modelo);
    }
    
    public List<VeiculoDTO> findVeiculoByMarca(String marca) {
        return veiculoController.findByMarca(marca);
    }
    
    public List<VeiculoDTO> findVeiculoByKilometragemRange(Integer minKm, Integer maxKm) {
        return veiculoController.findByKilometragemRange(minKm, maxKm);
    }
    
    public List<VeiculoDTO> findVeiculoByCliente(Long clienteId) {
        return veiculoController.findByCliente(clienteId);
    }
    
    public List<VeiculoDTO> findVeiculoByObservacao(String observacao) {
        return veiculoController.findByObservacao(observacao);
    }
    
    public List<VeiculoDTO> findVeiculoByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return veiculoController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<VeiculoDTO> findVeiculoByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return veiculoController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA ORÇAMENTO
    // =====================================================================
    
    public OrcamentoDTO saveOrcamento(OrcamentoDTO dto) {
        return orcamentoController.save(dto);
    }
    
    public OrcamentoDTO updateOrcamento(OrcamentoDTO dto) {
        return orcamentoController.update(dto);
    }
    
    public void deleteOrcamento(Long id) {
        orcamentoController.delete(id);
    }
    
    public OrcamentoDTO findOrcamentoById(Long id) {
        return orcamentoController.findById(id);
    }
    
    public List<OrcamentoDTO> findAllOrcamentos() {
        return orcamentoController.findAll();
    }
    
    public List<OrcamentoDTO> findOrcamentoByCliente(String nomeCliente) {
        return orcamentoController.findByCliente(nomeCliente);
    }
    
    public List<OrcamentoDTO> findOrcamentoByTipo(TipoOrcamento tipo) {
        return orcamentoController.findByTipo(tipo);
    }
    
    public List<OrcamentoDTO> findOrcamentoByProduto(Long produtoId) {
        return orcamentoController.findByProduto(produtoId);
    }
    
    public List<OrcamentoDTO> findOrcamentoByFuncionario(Long funcionarioId) {
        return orcamentoController.findByFuncionario(funcionarioId);
    }
    
    public List<OrcamentoDTO> findOrcamentoByClienteId(Long clienteId) {
        return orcamentoController.findByClienteId(clienteId);
    }
    
    public List<OrcamentoDTO> findOrcamentoByValorRange(Double valorMinimo, Double valorMaximo) {
        return orcamentoController.findByValorRange(valorMinimo, valorMaximo);
    }
    
    public List<OrcamentoDTO> findOrcamentoByDataInicialRange(LocalDateTime inicio, LocalDateTime fim) {
        return orcamentoController.findByDataInicialRange(inicio, fim);
    }
    
    public List<OrcamentoDTO> findOrcamentoByDataEntregaRange(LocalDateTime inicio, LocalDateTime fim) {
        return orcamentoController.findByDataEntregaRange(inicio, fim);
    }
    
    public List<OrcamentoDTO> findOrcamentoByStatus(StatusOrcamento status) {
        return orcamentoController.findByStatus(status);
    }
    
    public List<OrcamentoDTO> findOrcamentoByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return orcamentoController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<OrcamentoDTO> findOrcamentoByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return orcamentoController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA FUNCIONÁRIO
    // =====================================================================
    
    public FuncionarioDTO saveFuncionario(FuncionarioDTO dto) {
        return funcionarioController.save(dto);
    }
    
    public FuncionarioDTO updateFuncionario(FuncionarioDTO dto) {
        return funcionarioController.update(dto);
    }
    
    public void deleteFuncionario(Long id) {
        funcionarioController.delete(id);
    }
    
    public FuncionarioDTO findFuncionarioById(Long id) {
        return funcionarioController.findById(id);
    }
    
    public List<FuncionarioDTO> findAllFuncionarios() {
        return funcionarioController.findAll();
    }
    
    public List<FuncionarioDTO> findFuncionarioByNome(String nome) {
        return funcionarioController.findByNome(nome);
    }
    
    public FuncionarioDTO findFuncionarioByLogin(String login) {
        return funcionarioController.findByLogin(login);
    }
    
    public List<FuncionarioDTO> findFuncionarioBySetor(SetorFuncionario setor) {
        return funcionarioController.findBySetor(setor);
    }
    
    public List<FuncionarioDTO> findFuncionarioByFuncao(String funcao) {
        return funcionarioController.findByFuncao(funcao);
    }
    
    public FuncionarioDTO findFuncionarioByCpfCnpj(String cpfCnpj) {
        return funcionarioController.findByCpfCnpj(cpfCnpj);
    }
    
    public List<FuncionarioDTO> findFuncionarioByTelefone(String telefone) {
        return funcionarioController.findByTelefone(telefone);
    }
    
    public List<FuncionarioDTO> findFuncionarioByEmail(String email) {
        return funcionarioController.findByEmail(email);
    }
    
    public List<FuncionarioDTO> findFuncionarioByEndereco(String endereco) {
        return funcionarioController.findByEndereco(endereco);
    }
    
    public List<FuncionarioDTO> findFuncionarioByCidade(Long cidadeId) {
        return funcionarioController.findByCidade(cidadeId);
    }
    
    public List<FuncionarioDTO> findFuncionarioByStatus(StatusGeral status) {
        return funcionarioController.findByStatus(status);
    }
    
    public List<FuncionarioDTO> findFuncionarioByPerfil(TipoUsuario perfil) {
        return funcionarioController.findByPerfil(perfil);
    }
    
    public FuncionarioDTO findFuncionarioByLoginAndSenha(String login, String senha) {
        return funcionarioController.findByLoginAndSenha(login, senha);
    }
    
    public List<FuncionarioDTO> findFuncionarioByDataRegistroRange(LocalDateTime inicio, LocalDateTime fim) {
        return funcionarioController.findByDataRegistroRange(inicio, fim);
    }
    
    public List<FuncionarioDTO> findFuncionarioByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return funcionarioController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<FuncionarioDTO> findFuncionarioByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return funcionarioController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA PRODUTO
    // =====================================================================
    
    public ProdutoDTO saveProduto(ProdutoDTO dto) {
        return produtoController.save(dto);
    }
    
    public ProdutoDTO updateProduto(ProdutoDTO dto) {
        return produtoController.update(dto);
    }
    
    public void deleteProduto(Long id) {
        produtoController.delete(id);
    }
    
    public ProdutoDTO findProdutoById(Long id) {
        return produtoController.findById(id);
    }
    
    public List<ProdutoDTO> findAllProdutos() {
        return produtoController.findAll();
    }
    
    public List<ProdutoDTO> findProdutoByNome(String nome) {
        return produtoController.findByNome(nome);
    }
    
    public List<ProdutoDTO> findProdutoByFornecedor(Long fornecedorId) {
        return produtoController.findByFornecedor(fornecedorId);
    }
    
    public List<ProdutoDTO> findProdutoByUnidadeMedida(Long unidadeMedidaId) {
        return produtoController.findByUnidadeMedida(unidadeMedidaId);
    }
    
    public List<ProdutoDTO> findProdutoByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return produtoController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<ProdutoDTO> findProdutoByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return produtoController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA ORDEM DE SERVIÇO
    // =====================================================================
    
    public OrdemServicoDTO saveOrdemServico(OrdemServicoDTO dto) {
        return ordemServicoController.save(dto);
    }
    
    public OrdemServicoDTO updateOrdemServico(OrdemServicoDTO dto) {
        return ordemServicoController.update(dto);
    }
    
    public void deleteOrdemServico(Long id) {
        ordemServicoController.delete(id);
    }
    
    public OrdemServicoDTO findOrdemServicoById(Long id) {
        return ordemServicoController.findById(id);
    }
    
    public List<OrdemServicoDTO> findAllOrdemServicos() {
        return ordemServicoController.findAll();
    }
    
    public List<OrdemServicoDTO> findOrdemServicoByAtendente(Long atendenteId) {
        return ordemServicoController.findByAtendente(atendenteId);
    }
    
    public List<OrdemServicoDTO> findOrdemServicoByCliente(Long clienteId) {
        return ordemServicoController.findByCliente(clienteId);
    }
    
    public List<OrdemServicoDTO> findOrdemServicoByDescricao(String descricao) {
        return ordemServicoController.findByDescricao(descricao);
    }
    
    public List<OrdemServicoDTO> findOrdemServicoByValorRange(Double valorMinimo, Double valorMaximo) {
        return ordemServicoController.findByValorRange(valorMinimo, valorMaximo);
    }
    
    public List<OrdemServicoDTO> findOrdemServicoByPeca(Long pecaId) {
        return ordemServicoController.findByPeca(pecaId);
    }
    
    public List<OrdemServicoDTO> findOrdemServicoByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return ordemServicoController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<OrdemServicoDTO> findOrdemServicoByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return ordemServicoController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA FORNECEDOR
    // =====================================================================
    
    public FornecedorDTO saveFornecedor(FornecedorDTO dto) {
        return fornecedorController.save(dto);
    }
    
    public FornecedorDTO updateFornecedor(FornecedorDTO dto) {
        return fornecedorController.update(dto);
    }
    
    public void deleteFornecedor(Long id) {
        fornecedorController.delete(id);
    }
    
    public FornecedorDTO findFornecedorById(Long id) {
        return fornecedorController.findById(id);
    }
    
    public List<FornecedorDTO> findAllFornecedores() {
        return fornecedorController.findAll();
    }
    
    public List<FornecedorDTO> findFornecedorByNome(String nome) {
        return fornecedorController.findByNome(nome);
    }
    
    public FornecedorDTO findFornecedorByCpfCnpj(String cpfCnpj) {
        return fornecedorController.findByCpfCnpj(cpfCnpj);
    }
    
    public List<FornecedorDTO> findFornecedorByTelefone(String telefone) {
        return fornecedorController.findByTelefone(telefone);
    }
    
    public List<FornecedorDTO> findFornecedorByEmail(String email) {
        return fornecedorController.findByEmail(email);
    }
    
    public List<FornecedorDTO> findFornecedorByTipoFornecimento(TipoFornecimento tipoFornecimento) {
        return fornecedorController.findByTipoFornecimento(tipoFornecimento);
    }
    
    public List<FornecedorDTO> findFornecedorByStatus(StatusGeral status) {
        return fornecedorController.findByStatus(status);
    }
    
    public List<FornecedorDTO> findFornecedorByEndereco(String endereco) {
        return fornecedorController.findByEndereco(endereco);
    }
    
    public List<FornecedorDTO> findFornecedorByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return fornecedorController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<FornecedorDTO> findFornecedorByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return fornecedorController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA CONTA A PAGAR
    // =====================================================================
    
    public ContaPagarDTO saveContaPagar(ContaPagarDTO dto) {
        return contaPagarController.save(dto);
    }
    
    public ContaPagarDTO updateContaPagar(ContaPagarDTO dto) {
        return contaPagarController.update(dto);
    }
    
    public void deleteContaPagar(Long id) {
        contaPagarController.delete(id);
    }
    
    public ContaPagarDTO findContaPagarById(Long id) {
        return contaPagarController.findById(id);
    }
    
    public List<ContaPagarDTO> findAllContasPagar() {
        return contaPagarController.findAll();
    }
    
    public List<ContaPagarDTO> findContaPagarByFornecedor(String nomeFornecedor) {
        return contaPagarController.findByFornecedor(nomeFornecedor);
    }
    
    public List<ContaPagarDTO> findContaPagarByDataVencimentoRange(LocalDateTime inicio, LocalDateTime fim) {
        return contaPagarController.findByDataVencimentoRange(inicio, fim);
    }
    
    public List<ContaPagarDTO> findContaPagarByTipo(TipoContaPagar tipo) {
        return contaPagarController.findByTipo(tipo);
    }
    
    public List<ContaPagarDTO> findContaPagarByPrazoRange(LocalDateTime inicio, LocalDateTime fim) {
        return contaPagarController.findByPrazoRange(inicio, fim);
    }
    
    public List<ContaPagarDTO> findContaPagarByStatus(StatusGeral status) {
        return contaPagarController.findByStatus(status);
    }
    
    public List<ContaPagarDTO> findContaPagarByValorRange(Double valorMinimo, Double valorMaximo) {
        return contaPagarController.findByValorRange(valorMinimo, valorMaximo);
    }
    
    public List<ContaPagarDTO> findContaPagarByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return contaPagarController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<ContaPagarDTO> findContaPagarByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return contaPagarController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA CIDADE
    // =====================================================================
    
    public CidadeDTO saveCidade(CidadeDTO dto) {
        return cidadeController.save(dto);
    }
    
    public CidadeDTO updateCidade(CidadeDTO dto) {
        return cidadeController.update(dto);
    }
    
    public void deleteCidade(Long id) {
        cidadeController.delete(id);
    }
    
    public CidadeDTO findCidadeById(Long id) {
        return cidadeController.findById(id);
    }
    
    public List<CidadeDTO> findAllCidades() {
        return cidadeController.findAll();
    }
    
    public List<CidadeDTO> findCidadeByNome(String nome) {
        return cidadeController.findByNome(nome);
    }
    
    public List<CidadeDTO> findCidadeByEstado(EstadoBrasil estado) {
        return cidadeController.findByEstado(estado);
    }
    
    public List<CidadeDTO> findCidadeByPais(String pais) {
        return cidadeController.findByPais(pais);
    }
    
    public List<CidadeDTO> findCidadeByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return cidadeController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<CidadeDTO> findCidadeByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return cidadeController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA CONTROLE DE ESTOQUE
    // =====================================================================
    
    public ControleEstoqueDTO saveControleEstoque(ControleEstoqueDTO dto) {
        return controleEstoqueController.save(dto);
    }
    
    public ControleEstoqueDTO updateControleEstoque(ControleEstoqueDTO dto) {
        return controleEstoqueController.update(dto);
    }
    
    public void deleteControleEstoque(Long id) {
        controleEstoqueController.delete(id);
    }
    
    public ControleEstoqueDTO findControleEstoqueById(Long id) {
        return controleEstoqueController.findById(id);
    }
    
    public List<ControleEstoqueDTO> findAllControleEstoques() {
        return controleEstoqueController.findAll();
    }
    
    public List<ControleEstoqueDTO> findControleEstoqueByProduto(String nomeProduto) {
        return controleEstoqueController.findByProduto(nomeProduto);
    }
    
    public List<ControleEstoqueDTO> findControleEstoqueByQuantidadeRange(Integer quantidadeMinima, Integer quantidadeMaxima) {
        return controleEstoqueController.findByQuantidadeRange(quantidadeMinima, quantidadeMaxima);
    }
    
    public List<ControleEstoqueDTO> findControleEstoqueByValorRange(Double valorMinimo, Double valorMaximo) {
        return controleEstoqueController.findByValorRange(valorMinimo, valorMaximo);
    }
    
    public List<ControleEstoqueDTO> findControleEstoqueByFornecedor(Long fornecedorId) {
        return controleEstoqueController.findByFornecedor(fornecedorId);
    }
    
    public List<ControleEstoqueDTO> findControleEstoqueByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return controleEstoqueController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<ControleEstoqueDTO> findControleEstoqueByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return controleEstoqueController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA VENDA
    // =====================================================================
    
    public VendaDTO saveVenda(VendaDTO dto) {
        return vendaController.save(dto);
    }
    
    public VendaDTO updateVenda(VendaDTO dto) {
        return vendaController.update(dto);
    }
    
    public void deleteVenda(Long id) {
        vendaController.delete(id);
    }
    
    public VendaDTO findVendaById(Long id) {
        return vendaController.findById(id);
    }
    
    public List<VendaDTO> findAllVendas() {
        return vendaController.findAll();
    }
    
    public List<VendaDTO> findVendaByCliente(String nomeCliente) {
        return vendaController.findByCliente(nomeCliente);
    }
    
    public List<VendaDTO> findVendaByDataVendaRange(LocalDateTime inicio, LocalDateTime fim) {
        return vendaController.findByDataVendaRange(inicio, fim);
    }
    
    public List<VendaDTO> findVendaByOrcamento(Long orcamentoId) {
        return vendaController.findByOrcamento(orcamentoId);
    }
    
    public List<VendaDTO> findVendaByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return vendaController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<VendaDTO> findVendaByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return vendaController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA AGENDAMENTO DE SERVIÇO
    // =====================================================================
    
    public AgendamentoServicoDTO saveAgendamentoServico(AgendamentoServicoDTO dto) {
        return agendamentoServicoController.save(dto);
    }
    
    public AgendamentoServicoDTO updateAgendamentoServico(AgendamentoServicoDTO dto) {
        return agendamentoServicoController.update(dto);
    }
    
    public void deleteAgendamentoServico(Long id) {
        agendamentoServicoController.delete(id);
    }
    
    public AgendamentoServicoDTO findAgendamentoServicoById(Long id) {
        return agendamentoServicoController.findById(id);
    }
    
    public List<AgendamentoServicoDTO> findAllAgendamentoServicos() {
        return agendamentoServicoController.findAll();
    }
    
    public List<AgendamentoServicoDTO> findAgendamentoServicoByCliente(String nomeCliente) {
        return agendamentoServicoController.findByCliente(nomeCliente);
    }
    
    public List<AgendamentoServicoDTO> findAgendamentoServicoByClienteId(Long clienteId) {
        return agendamentoServicoController.findByClienteId(clienteId);
    }
    
    public List<AgendamentoServicoDTO> findAgendamentoServicoByDataAgendadaRange(LocalDateTime inicio, LocalDateTime fim) {
        return agendamentoServicoController.findByDataAgendadaRange(inicio, fim);
    }
    
    public List<AgendamentoServicoDTO> findAgendamentoServicoByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return agendamentoServicoController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<AgendamentoServicoDTO> findAgendamentoServicoByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return agendamentoServicoController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA UNIDADE DE MEDIDA
    // =====================================================================
    
    public UnidadeMedidaDTO saveUnidadeMedida(UnidadeMedidaDTO dto) {
        return unidadeMedidaController.save(dto);
    }
    
    public UnidadeMedidaDTO updateUnidadeMedida(UnidadeMedidaDTO dto) {
        return unidadeMedidaController.update(dto);
    }
    
    public void deleteUnidadeMedida(Long id) {
        unidadeMedidaController.delete(id);
    }
    
    public UnidadeMedidaDTO findUnidadeMedidaById(Long id) {
        return unidadeMedidaController.findById(id);
    }
    
    public List<UnidadeMedidaDTO> findAllUnidadeMedidas() {
        return unidadeMedidaController.findAll();
    }
    
    public UnidadeMedidaDTO findUnidadeMedidaBySigla(String sigla) {
        return unidadeMedidaController.findBySigla(sigla);
    }
    
    public List<UnidadeMedidaDTO> findUnidadeMedidaByDescricao(String descricao) {
        // Alteração para chamar o método correto, já que findByDescricao não existe no UnidadeMedidaController
        return unidadeMedidaController.findByNome(descricao);
    }
    
    public List<UnidadeMedidaDTO> findUnidadeMedidaByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return unidadeMedidaController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<UnidadeMedidaDTO> findUnidadeMedidaByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return unidadeMedidaController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA RELATÓRIO FINANCEIRO
    // =====================================================================
    
    public RelatorioFinanceiroDTO saveRelatorioFinanceiro(RelatorioFinanceiroDTO dto) {
        return relatorioFinanceiroController.save(dto);
    }
    
    public RelatorioFinanceiroDTO updateRelatorioFinanceiro(RelatorioFinanceiroDTO dto) {
        return relatorioFinanceiroController.update(dto);
    }
    
    public void deleteRelatorioFinanceiro(Long id) {
        relatorioFinanceiroController.delete(id);
    }
    
    public RelatorioFinanceiroDTO findRelatorioFinanceiroById(Long id) {
        return relatorioFinanceiroController.findById(id);
    }
    
    public List<RelatorioFinanceiroDTO> findAllRelatoriosFinanceiros() {
        return relatorioFinanceiroController.findAll();
    }
    
    public List<RelatorioFinanceiroDTO> findRelatorioFinanceiroByPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return relatorioFinanceiroController.findByPeriodo(inicio, fim);
    }
    
    public List<RelatorioFinanceiroDTO> findRelatorioFinanceiroByTotalVendasRange(Double valorMinimo, Double valorMaximo) {
        return relatorioFinanceiroController.findByTotalVendasRange(valorMinimo, valorMaximo);
    }
    
    public List<RelatorioFinanceiroDTO> findRelatorioFinanceiroByTotalOrcamentosRange(Double valorMinimo, Double valorMaximo) {
        return relatorioFinanceiroController.findByTotalOrcamentosRange(valorMinimo, valorMaximo);
    }
    
    public List<RelatorioFinanceiroDTO> findRelatorioFinanceiroByTotalGastosRange(Double valorMinimo, Double valorMaximo) {
        return relatorioFinanceiroController.findByTotalGastosRange(valorMinimo, valorMaximo);
    }
    
    public List<RelatorioFinanceiroDTO> findRelatorioFinanceiroByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return relatorioFinanceiroController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<RelatorioFinanceiroDTO> findRelatorioFinanceiroByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return relatorioFinanceiroController.findByDataAlteracaoRange(inicio, fim);
    }
    
    // =====================================================================
    // MÉTODOS PARA RELATÓRIO FINANCEIRO DETALHADO
    // =====================================================================
    
    public RelatorioFinanceiroDetalhadoDTO saveRelatorioFinanceiroDetalhado(RelatorioFinanceiroDetalhadoDTO dto) {
        return relatorioFinanceiroDetalhadoController.save(dto);
    }
    
    public RelatorioFinanceiroDetalhadoDTO updateRelatorioFinanceiroDetalhado(RelatorioFinanceiroDetalhadoDTO dto) {
        return relatorioFinanceiroDetalhadoController.update(dto);
    }
    
    public void deleteRelatorioFinanceiroDetalhado(Long id) {
        relatorioFinanceiroDetalhadoController.delete(id);
    }
    
    public RelatorioFinanceiroDetalhadoDTO findRelatorioFinanceiroDetalhadoById(Long id) {
        return relatorioFinanceiroDetalhadoController.findById(id);
    }
    
    public List<RelatorioFinanceiroDetalhadoDTO> findAllRelatoriosFinanceirosDetalhados() {
        return relatorioFinanceiroDetalhadoController.findAll();
    }
    
    public List<RelatorioFinanceiroDetalhadoDTO> findRelatorioFinanceiroDetalhadoByValorTotalEntrada(Double valor) {
        return relatorioFinanceiroDetalhadoController.findByValorTotalEntrada(valor);
    }
    
    public List<RelatorioFinanceiroDetalhadoDTO> findRelatorioFinanceiroDetalhadoByPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return relatorioFinanceiroDetalhadoController.findByPeriodo(inicio, fim);
    }
    
    public List<RelatorioFinanceiroDetalhadoDTO> findRelatorioFinanceiroDetalhadoByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return relatorioFinanceiroDetalhadoController.findByDataCadastroRange(inicio, fim);
    }
    
    public List<RelatorioFinanceiroDetalhadoDTO> findRelatorioFinanceiroDetalhadoByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return relatorioFinanceiroDetalhadoController.findByDataAlteracaoRange(inicio, fim);
    }
}
