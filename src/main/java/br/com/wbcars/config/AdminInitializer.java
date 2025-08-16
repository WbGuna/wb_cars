package br.com.wbcars.config;

import br.com.wbcars.dao.UsuarioDAO;
import br.com.wbcars.modelo.Usuario;
import br.com.wbcars.util.CriptografiaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AdminInitializer implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Usuario admin = usuarioDAO.buscarPorLogin("admin");
        if (admin == null) {
            Usuario novoAdmin = new Usuario();
            novoAdmin.setLogin("admin");
            novoAdmin.setSenha(CriptografiaUtil.sha256("admin"));
            usuarioDAO.salvar(novoAdmin);
            System.out.println("Usuário admin criado automaticamente.");
        }
    }
}
