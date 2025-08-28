package br.com.wbcars.controller;

import br.com.wbcars.dto.ControleEstoqueDTO;
import br.com.wbcars.service.ControleEstoqueService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas ao Controle de Estoque.
 * Implementa todos os métodos disponíveis no ControleEstoqueService.
 */
public class ControleEstoqueController {
    private static final Logger LOGGER = Logger.getLogger(ControleEstoqueController.class.getName());
    private static ControleEstoqueController instance;
    private final ControleEstoqueService controleEstoqueService = ControleEstoqueService.getInstance();

    private ControleEstoqueController() {}

    public static ControleEstoqueController getInstance() {
        if (instance == null) {
            synchronized (ControleEstoqueController.class) {
                if (instance == null) {
                    instance = new ControleEstoqueController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva um novo item no controle de estoque
     * @param dto DTO com dados do item
     * @return DTO do item salvo
     */
    public ControleEstoqueDTO save(ControleEstoqueDTO dto) {
        try {
            return controleEstoqueService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar item no controle de estoque", e);
            throw e;
        }
    }

    /**
     * Atualiza um item existente no controle de estoque
     * @param dto DTO com novos dados do item
     * @return DTO do item atualizado
     */
    public ControleEstoqueDTO update(ControleEstoqueDTO dto) {
        try {
            return controleEstoqueService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar item no controle de estoque", e);
            throw e;
        }
    }

    /**
     * Exclui um item do controle de estoque por ID
     * @param id ID do item
     */
    public void delete(Long id) {
        try {
            controleEstoqueService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir item do controle de estoque", e);
            throw e;
        }
    }

    /**
     * Busca um item do controle de estoque por ID
     * @param id ID do item
     * @return DTO do item encontrado
     */
    public ControleEstoqueDTO findById(Long id) {
        try {
            return controleEstoqueService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar item do controle de estoque por ID", e);
            throw e;
        }
    }

    /**
     * Busca todos os itens do controle de estoque
     * @return Lista de DTOs de todos os itens
     */
    public List<ControleEstoqueDTO> findAll() {
        try {
            return controleEstoqueService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todos os itens do controle de estoque", e);
            throw e;
        }
    }

    /**
     * Busca itens do controle de estoque por nome do produto
     * @param nomeProduto Nome do produto (ou parte dele)
     * @return Lista de DTOs dos itens encontrados
     */
    public List<ControleEstoqueDTO> findByProduto(String nomeProduto) {
        try {
            return controleEstoqueService.findByProduto(nomeProduto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar itens do controle de estoque por produto: " + nomeProduto, e);
            throw e;
        }
    }

    /**
     * Busca itens do controle de estoque por faixa de quantidade
     * @param quantidadeMinima Quantidade mínima
     * @param quantidadeMaxima Quantidade máxima
     * @return Lista de DTOs dos itens encontrados
     */
    public List<ControleEstoqueDTO> findByQuantidadeRange(Integer quantidadeMinima, Integer quantidadeMaxima) {
        try {
            return controleEstoqueService.findByQuantidadeRange(quantidadeMinima, quantidadeMaxima);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar itens do controle de estoque por faixa de quantidade", e);
            throw e;
        }
    }

    /**
     * Busca itens do controle de estoque por faixa de valor
     * @param valorMinimo Valor mínimo
     * @param valorMaximo Valor máximo
     * @return Lista de DTOs dos itens encontrados
     */
    public List<ControleEstoqueDTO> findByValorRange(Double valorMinimo, Double valorMaximo) {
        try {
            return controleEstoqueService.findByValorRange(valorMinimo, valorMaximo);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar itens do controle de estoque por faixa de valor", e);
            throw e;
        }
    }

    /**
     * Busca itens do controle de estoque por fornecedor
     * @param fornecedorId ID do fornecedor
     * @return Lista de DTOs dos itens encontrados
     */
    public List<ControleEstoqueDTO> findByFornecedor(Long fornecedorId) {
        try {
            return controleEstoqueService.findByFornecedor(fornecedorId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar itens do controle de estoque por fornecedor: " + fornecedorId, e);
            throw e;
        }
    }

    /**
     * Busca itens do controle de estoque por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos itens encontrados
     */
    public List<ControleEstoqueDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return controleEstoqueService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar itens do controle de estoque por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca itens do controle de estoque por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos itens encontrados
     */
    public List<ControleEstoqueDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return controleEstoqueService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar itens do controle de estoque por intervalo de data de alteração", e);
            throw e;
        }
    }
}
