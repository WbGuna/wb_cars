package br.com.wbcars.service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wbcars.dao.UsuarioDAO;
import br.com.wbcars.dto.UsuarioDTO;
import br.com.wbcars.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Transactional
    public UsuarioDTO autenticar(String login, String senha) {
        Usuario usuario = usuarioDAO.buscarPorLogin(login);
        if (usuario != null && usuarioDAO.verificarSenha(usuario, senha)) {
            // Atualiza penúltimo e último login
            usuario.setPenultimoLogin(usuario.getUltimoLogin());
            usuario.setUltimoLogin(LocalDateTime.now());
            usuarioDAO.atualizar(usuario);
            return toDTO(usuario);
        }
        return null;
    }

    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioDAO.buscarPorId(id);
        return usuario != null ? toDTO(usuario) : null;
    }

    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setLogin(usuario.getLogin());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setUltimoLogin(usuario.getUltimoLogin());
        dto.setPenultimoLogin(usuario.getPenultimoLogin());
        return dto;
    }
}
