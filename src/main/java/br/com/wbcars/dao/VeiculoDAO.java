package br.com.wbcars.dao;

import br.com.wbcars.entity.Veiculo;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeiculoDAO extends GenericDAO<Veiculo> {
    private static final Logger LOGGER = Logger.getLogger(VeiculoDAO.class.getName());
    private static VeiculoDAO instance;

    private VeiculoDAO() {
        super(Veiculo.class);
    }

    public static VeiculoDAO getInstance() {
        if (instance == null) {
            synchronized (VeiculoDAO.class) {
                if (instance == null) {
                    instance = new VeiculoDAO();
                }
            }
        }
        return instance;
    }

    public List<Veiculo> findByPlaca(String placa) {
        try {
            TypedQuery<Veiculo> query = em.createQuery(
                "SELECT v FROM Veiculo v WHERE LOWER(v.placa) LIKE LOWER(:placa)", Veiculo.class);
            query.setParameter("placa", "%" + placa + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por placa: " + placa, e);
            return List.of();
        }
    }

    public List<Veiculo> findByModelo(String modelo) {
        try {
            TypedQuery<Veiculo> query = em.createQuery(
                "SELECT v FROM Veiculo v WHERE LOWER(v.modelo) LIKE LOWER(:modelo)", Veiculo.class);
            query.setParameter("modelo", "%" + modelo + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por modelo: " + modelo, e);
            return List.of();
        }
    }
    
    public List<Veiculo> findByMarca(String marca) {
        try {
            TypedQuery<Veiculo> query = em.createQuery(
                "SELECT v FROM Veiculo v WHERE LOWER(v.marca) LIKE LOWER(:marca)", Veiculo.class);
            query.setParameter("marca", "%" + marca + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por marca: " + marca, e);
            return List.of();
        }
    }
    
    public List<Veiculo> findByKilometragemRange(Integer minKm, Integer maxKm) {
        try {
            TypedQuery<Veiculo> query = em.createQuery(
                "SELECT v FROM Veiculo v WHERE v.kilometragem BETWEEN :minKm AND :maxKm", Veiculo.class);
            query.setParameter("minKm", minKm);
            query.setParameter("maxKm", maxKm);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por faixa de kilometragem", e);
            return List.of();
        }
    }
    
    public List<Veiculo> findByCliente(Long clienteId) {
        try {
            TypedQuery<Veiculo> query = em.createQuery(
                "SELECT v FROM Veiculo v WHERE v.cliente.id = :clienteId", Veiculo.class);
            query.setParameter("clienteId", clienteId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por cliente: " + clienteId, e);
            return List.of();
        }
    }
    
    /**
     * Busca veículos pela observação
     * @param observacao Texto a ser buscado na observação
     * @return Lista de veículos que atendem ao critério
     */
    public List<Veiculo> findByObservacao(String observacao) {
        try {
            TypedQuery<Veiculo> query = em.createQuery(
                "SELECT v FROM Veiculo v WHERE LOWER(v.observacao) LIKE LOWER(:observacao)", Veiculo.class);
            query.setParameter("observacao", "%" + observacao + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por observação: " + observacao, e);
            return List.of();
        }
    }
}
