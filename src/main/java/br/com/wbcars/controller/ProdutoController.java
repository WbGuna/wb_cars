package br.com.wbcars.controller;

import br.com.wbcars.dto.ProdutoDTO;
import br.com.wbcars.service.ProdutoService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Produtos.
 * Implementa todos os métodos disponíveis no ProdutoService.
 */
public class ProdutoController {
    private static final Logger LOGGER = Logger.getLogger(ProdutoController.class.getName());
    private static ProdutoController instance;
    private final ProdutoService produtoService = ProdutoService.getInstance();

    private ProdutoController() {}

    public static ProdutoController getInstance() {
        if (instance == null) {
            synchronized (ProdutoController.class) {
                if (instance == null) {
                    instance = new ProdutoController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva um novo produto
     * @param dto DTO com dados do produto
     * @return DTO do produto salvo
     */
    public ProdutoDTO save(ProdutoDTO dto) {
        try {
            return produtoService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar produto", e);
            throw e;
        }
    }

    /**
     * Atualiza um produto existente
     * @param dto DTO com novos dados do produto
     * @return DTO do produto atualizado
     */
    public ProdutoDTO update(ProdutoDTO dto) {
        try {
            return produtoService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar produto", e);
            throw e;
        }
    }

    /**
     * Exclui um produto por ID
     * @param id ID do produto
     */
    public void delete(Long id) {
        try {
            produtoService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir produto", e);
            throw e;
        }
    }

    /**
     * Busca um produto por ID
     * @param id ID do produto
     * @return DTO do produto encontrado
     */
    public ProdutoDTO findById(Long id) {
        try {
            return produtoService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produto por ID", e);
            throw e;
        }
    }

    /**
     * Busca todos os produtos
     * @return Lista de DTOs de todos os produtos
     */
    public List<ProdutoDTO> findAll() {
        try {
            return produtoService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todos os produtos", e);
            throw e;
        }
    }

    /**
     * Busca produtos por nome
     * @param nome Nome do produto (ou parte dele)
     * @return Lista de DTOs dos produtos encontrados
     */
    public List<ProdutoDTO> findByNome(String nome) {
        try {
            return produtoService.findByNome(nome);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produtos por nome: " + nome, e);
            throw e;
        }
    }

    /**
     * Busca produtos por fornecedor
     * @param fornecedorId ID do fornecedor
     * @return Lista de DTOs dos produtos encontrados
     */
    public List<ProdutoDTO> findByFornecedor(Long fornecedorId) {
        try {
            return produtoService.findByFornecedor(fornecedorId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produtos por fornecedor: " + fornecedorId, e);
            throw e;
        }
    }

    /**
     * Busca produtos por unidade de medida
     * @param unidadeMedidaId ID da unidade de medida
     * @return Lista de DTOs dos produtos encontrados
     */
    public List<ProdutoDTO> findByUnidadeMedida(Long unidadeMedidaId) {
        try {
            return produtoService.findByUnidadeMedida(unidadeMedidaId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produtos por unidade de medida: " + unidadeMedidaId, e);
            throw e;
        }
    }

    /**
     * Busca produtos por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos produtos encontrados
     */
    public List<ProdutoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return produtoService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produtos por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca produtos por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos produtos encontrados
     */
    public List<ProdutoDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return produtoService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produtos por intervalo de data de alteração", e);
            throw e;
        }
    }
}
