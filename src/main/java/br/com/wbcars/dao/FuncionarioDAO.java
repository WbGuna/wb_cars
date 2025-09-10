package br.com.wbcars.dao;

import br.com.wbcars.entity.Funcionario;
import br.com.wbcars.enuns.SetorFuncionario;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoUsuario;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
    private static final Logger LOGGER = Logger.getLogger(FuncionarioDAO.class.getName());
    private static FuncionarioDAO instance;

    private FuncionarioDAO() {
        super(Funcionario.class);
    }

    public static FuncionarioDAO getInstance() {
        if (instance == null) {
            synchronized (FuncionarioDAO.class) {
                if (instance == null) {
                    instance = new FuncionarioDAO();
                }
            }
        }
        return instance;
    }

    public List<Funcionario> findByNome(String nome) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE LOWER(f.nome) LIKE LOWER(:nome)", Funcionario.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por nome: " + nome, e);
            return List.of();
        }
    }

    public Funcionario findByLogin(String login) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.login = :login", Funcionario.class);
            query.setParameter("login", login);
            List<Funcionario> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionário por login: " + login, e);
            return null;
        }
    }

    public List<Funcionario> findBySetor(SetorFuncionario setor) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.setor = :setor", Funcionario.class);
            query.setParameter("setor", setor);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por setor: " + setor, e);
            return List.of();
        }
    }
    
    public List<Funcionario> findByDataRegistroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.dataRegistro BETWEEN :inicio AND :fim", Funcionario.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por intervalo de data de registro", e);
            return List.of();
        }
    }
    
    public List<Funcionario> findByFuncao(String funcao) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE LOWER(f.funcao) LIKE LOWER(:funcao)", Funcionario.class);
            query.setParameter("funcao", "%" + funcao + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por função: " + funcao, e);
            return List.of();
        }
    }
    
    public Funcionario findByCpfCnpj(String cpfCnpj) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.cpfCnpj = :cpfCnpj", Funcionario.class);
            query.setParameter("cpfCnpj", cpfCnpj);
            List<Funcionario> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionário por CPF/CNPJ: " + cpfCnpj, e);
            return null;
        }
    }
    
    public List<Funcionario> findByTelefone(String telefone) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.telefone LIKE :telefone", Funcionario.class);
            query.setParameter("telefone", "%" + telefone + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por telefone: " + telefone, e);
            return List.of();
        }
    }
    
    public List<Funcionario> findByEmail(String email) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE LOWER(f.email) LIKE LOWER(:email)", Funcionario.class);
            query.setParameter("email", "%" + email + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por email: " + email, e);
            return List.of();
        }
    }
    
    public List<Funcionario> findByEndereco(String endereco) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE LOWER(f.rua) LIKE LOWER(:endereco) OR LOWER(f.bairro) LIKE LOWER(:endereco)", 
                Funcionario.class);
            query.setParameter("endereco", "%" + endereco + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por endereço: " + endereco, e);
            return List.of();
        }
    }
    
    public List<Funcionario> findByCidade(Long cidadeId) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.cidade.id = :cidadeId", Funcionario.class);
            query.setParameter("cidadeId", cidadeId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por cidade: " + cidadeId, e);
            return List.of();
        }
    }
    
    public List<Funcionario> findByStatus(StatusGeral status) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.status = :status", Funcionario.class);
            query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por status: " + status, e);
            return List.of();
        }
    }
    
    public List<Funcionario> findByPerfil(TipoUsuario perfil) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.perfil = :perfil", Funcionario.class);
            query.setParameter("perfil", perfil);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por perfil: " + perfil, e);
            return List.of();
        }
    }
    
    public Funcionario findByLoginAndSenha(String login, String senha) {
        try {
            // Primeiro busca o funcionário pelo login
            Funcionario funcionario = findByLogin(login);
            
            // Se encontrou o funcionário, verifica a senha usando o método criptografado
            if (funcionario != null && funcionario.verificarSenha(senha)) {
                return funcionario;
            }
            
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionário por login e senha", e);
            return null;
        }
    }
}
