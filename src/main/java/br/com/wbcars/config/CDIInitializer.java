package br.com.wbcars.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import java.util.logging.Logger;

@ApplicationScoped
public class CDIInitializer {
    
    private static final Logger logger = Logger.getLogger(CDIInitializer.class.getName());
    
    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        logger.info("CDI Container inicializado com sucesso!");
        System.out.println("========================================");
        System.out.println("CDI Container está funcionando!");
        System.out.println("Jakarta EE 10 + PrimeFaces 13 + Java 17");
        System.out.println("========================================");
    }
}
