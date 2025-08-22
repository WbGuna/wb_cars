package br.com.wbcars;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.LifecycleException;
import java.io.File;

public class Application {
    
    public static void main(String[] args) {
        try {
            System.out.println("========================================");
            System.out.println("🚀 INICIANDO WB CARS - JAVA 17 + JAKARTA EE");
            System.out.println("✅ PrimeFaces 13.0.0 Jakarta");
            System.out.println("✅ Tomcat 10.1.36 Embedded");
            System.out.println("✅ CDI + JSF 4.0.1");
            System.out.println("========================================");
            
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8081);
            
            // Diretório base
            File baseDir = new File("tomcat-work");
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }
            tomcat.setBaseDir(baseDir.getAbsolutePath());
            
            // Configurar webapp
            String webappDirLocation = "src/main/webapp/";
            Context context = tomcat.addWebapp("/wb_cars", new File(webappDirLocation).getAbsolutePath());
            
            // Adicionar classes compiladas ao classpath
            context.setDocBase(new File(webappDirLocation).getAbsolutePath());
            
            System.out.println("🌐 Servidor iniciando na porta 8081...");
            System.out.println("📁 Webapp: " + webappDirLocation);
            System.out.println("🎯 URL: http://localhost:8081/wb_cars/");
            
            tomcat.start();
            
            System.out.println("========================================");
            System.out.println("✅ SERVIDOR INICIADO COM SUCESSO!");
            System.out.println("🔥 Acesse: http://localhost:8081/wb_cars/");
            System.out.println("========================================");
            
            tomcat.getServer().await();
            
        } catch (LifecycleException e) {
            System.err.println("❌ Erro ao iniciar Tomcat: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("❌ Erro geral: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
