# 🚗 WB Cars - Sistema de Gestão Automotiva

## 📋 **Especificações Técnicas**

| Componente | Versão | Status |
}
```

## 📁 **Estrutura de Pacotes (Arquitetura)**

```
src/main/java/br/com/wbcars/
├── bean/              # JSF Managed Beans (Frontend)
│   ├── VeiculoBean.java
│   ├── ClienteBean.java
│   └── UsuarioBean.java
├── facade/            # Singleton - Ponto único de entrada
│   └── SystemFacade.java
├── controller/        # Controllers de negócio (injetados na Facade)
│   ├── VeiculoController.java
│   ├── ClienteController.java
│   └── UsuarioController.java
├── service/           # Services (dentro dos Controllers)
│   ├── VeiculoService.java
│   ├── ClienteService.java
│   └── UsuarioService.java
├── dao/               # Data Access Objects (retornam DTOs)
│   ├── VeiculoDAO.java
│   ├── ClienteDAO.java
│   └── UsuarioDAO.java
├── dto/               # Data Transfer Objects (dados limpos)
│   ├── VeiculoDTO.java
│   ├── ClienteDTO.java
│   └── UsuarioDTO.java
├── entity/            # JPA Entities (só no DAO)
│   ├── Veiculo.java
│   ├── Cliente.java
│   └── Usuario.java
└── config/            # Configurações Spring
    └── AppConfig.java
```

## ⚡ **Princípios da Arquitetura**

### **✅ O que FAZER:**
1. **Bean** sempre chama **Facade** (nunca Controller direto)
2. **Facade** é **Singleton** com Controllers injetados via **@Autowired**
3. **Controller** contém **Service** como atributo/método
4. **Service** faz validações e chama **DAO**
5. **DAO** trabalha com **Entity** mas retorna **DTO**
6. **DTO** circula entre todas as camadas (dados limpos)
7. **Entity** fica isolada no **DAO** (mapeamento JPA)

### **❌ O que NÃO FAZER:**
1. Bean chamar Controller diretamente
2. Passar Entity entre camadas (só DTO)
3. Service acessar banco diretamente
4. DAO retornar Entity (sempre DTO)
5. Criar múltiplas Facades
6. Misturar responsabilidades

### **🔄 Fluxo de Retorno:**
```
Banco → Entity → DAO → DTO → Service → DTO → Controller → DTO → Facade → DTO → Bean → Frontend
```

## 🎯 **Tema PrimeFaces**---------|--------|--------|
| **Java** | `17.0.12` | ✅ Configurado |
| **Jakarta EE** | `10.0` | ✅ Configurado |
| **JSF (Jakarta Faces)** | `4.0.1` | ✅ Funcionando |
| **PrimeFaces** | `15.0.0:jakarta` | ✅ Funcionando |
| **CDI (Weld)** | `5.1.2.Final` | ✅ Funcionando |
| **Hibernate** | `6.4.4.Final` | ✅ Configurado |
| **Spring** | `6.1.6` | ✅ Configurado |
| **PostgreSQL Driver** | `42.7.3` | ✅ Configurado |
| **Maven** | `3.9.9+` | ✅ Requerido |
| **Tomcat** | `10.1.36+` | ✅ Requerido |

## �️ **Arquitetura do Sistema**

### **Fluxo de Dados:**
```
Bean (Frontend) → Facade (Singleton) → Controller → Service → DAO → Entity/DTO
```

### **Detalhamento das Camadas:**

#### **1. Bean (JSF)**
- **Responsabilidade**: Conversa com o frontend (páginas .xhtml)
- **Localização**: `src/main/java/br/com/wbcars/bean/`
- **Exemplo**: `VeiculoBean.java`
- **Anotação**: `@ViewScoped`, `@ManagedBean`

#### **2. Facade (Singleton)**
- **Responsabilidade**: Ponto único de entrada, contém todos os Controllers injetados
- **Localização**: `src/main/java/br/com/wbcars/facade/`
- **Exemplo**: `SystemFacade.java`
- **Pattern**: Singleton + Dependency Injection

#### **3. Controller**
- **Responsabilidade**: Lógica de negócio, orquestração
- **Localização**: `src/main/java/br/com/wbcars/controller/`
- **Exemplo**: `VeiculoController.java`
- **Injeção**: Controllers são injetados na Facade

#### **4. Service**
- **Responsabilidade**: Validações, conversões, regras de negócio
- **Localização**: `src/main/java/br/com/wbcars/service/`
- **Exemplo**: `VeiculoService.java`
- **Escopo**: Existe dentro dos Controllers

#### **5. DAO (Data Access Object)**
- **Responsabilidade**: Acesso ao banco, SQL queries
- **Localização**: `src/main/java/br/com/wbcars/dao/`
- **Exemplo**: `VeiculoDAO.java`
- **Retorno**: Sempre retorna DTOs (nunca Entities diretamente)

#### **6. DTO (Data Transfer Object)**
- **Responsabilidade**: Transferência de dados entre camadas
- **Localização**: `src/main/java/br/com/wbcars/dto/`
- **Exemplo**: `VeiculoDTO.java`
- **Uso**: Dados "limpos" sem dependências JPA

#### **7. Entity/POJO**
- **Responsabilidade**: Mapeamento JPA para banco
- **Localização**: `src/main/java/br/com/wbcars/entity/`
- **Exemplo**: `Veiculo.java`
- **Uso**: Apenas no DAO para conversão DTO ↔ Entity

### **Exemplo de Fluxo Completo:**

```java
// 1. Bean chama Facade
@ManagedBean
public class VeiculoBean {
    public void salvarVeiculo() {
        SystemFacade facade = SystemFacade.getInstance();
        facade.getVeiculoController().salvar(veiculoDTO);
    }
}

// 2. Facade retorna Controller injetado
@Component
public class SystemFacade {
    @Autowired
    private VeiculoController veiculoController;
    
    public VeiculoController getVeiculoController() {
        return veiculoController;
    }
}

// 3. Controller chama Service
@Service
public class VeiculoController {
    private VeiculoService veiculoService = new VeiculoService();
    
    public void salvar(VeiculoDTO dto) {
        veiculoService.validarESalvar(dto);
    }
}

// 4. Service chama DAO
public class VeiculoService {
    private VeiculoDAO veiculoDAO = new VeiculoDAO();
    
    public void validarESalvar(VeiculoDTO dto) {
        // Validações
        veiculoDAO.salvar(dto);
    }
}

// 5. DAO converte DTO → Entity → Banco → DTO
public class VeiculoDAO {
    public VeiculoDTO salvar(VeiculoDTO dto) {
        Veiculo entity = dtoParaEntity(dto);
        // Salvar no banco
        return entityParaDto(entity);
    }
}
```

## �🎯 **Tema PrimeFaces**
- **Tema Ativo**: `saga` (moderno e colorido)
- **Ícones**: PrimeIcons + Font Awesome habilitado
- **Upload**: Commons FileUpload configurado

## 🚀 **Como Executar**

### **1. Pré-requisitos**
```bash
# Verificar Java 17
java -version
# Deve mostrar: openjdk version "17.0.x"

# Verificar Maven
mvn -version
# Deve mostrar: Apache Maven 3.9.x

# Verificar se tem Tomcat 10.1+ disponível
# (Eclipse com Tomcat 10 ou Tomcat standalone)
```

### **2. Compilar Projeto**
```bash
cd wb_cars
mvn clean package -DskipTests
```

### **3. Deploy Eclipse**
1. **File > Import > Existing Maven Projects**
2. **Selecionar pasta wb_cars**
3. **Right-click projeto > Run As > Run on Server**
4. **Escolher Tomcat 10.x**
5. **Acessar**: http://localhost:8080/wb_cars/

### **4. Deploy Manual (Opcional)**
```bash
# Copiar WAR para Tomcat
cp target/wb_cars.war $TOMCAT_HOME/webapps/

# Iniciar Tomcat
$TOMCAT_HOME/bin/startup.sh
```

## 🧪 **Páginas de Teste**

| URL | Descrição |
|-----|-----------|
| `/index.xhtml` | Página inicial com menu |
| `/teste-oficial.xhtml` | **Demo PrimeFaces 15.0.0** (recomendado) |
| `/teste-direto.xhtml` | Teste básico de componentes |
| `/teste-primefaces.xhtml` | Teste completo |

## ⚠️ **Importante**

### **✅ USAR SEMPRE:**
- **Java 17** (não Java 8)
- **Tomcat 10.1+** (não Tomcat 9)
- **PrimeFaces 15.0.0:jakarta** (não versão javax)
- **Jakarta EE 10** (não Java EE)

### **❌ NÃO USAR:**
- Java 8 ou 11
- Tomcat 9 ou anterior
- PrimeFaces sem classifier jakarta
- Dependências javax.*

## 🔧 **Estrutura do Projeto**

```
wb_cars/
├── src/main/java/br/com/wbcars/
│   └── controller/IndexController.java
├── src/main/webapp/
│   ├── WEB-INF/
│   │   ├── web.xml (Jakarta EE 10)
│   │   └── faces-config.xml (JSF 4.0)
│   ├── index.xhtml
│   ├── teste-oficial.xhtml ← **Principal para teste**
│   └── teste-direto.xhtml
├── pom.xml (Maven dependencies)
└── README.md (este arquivo)
```

## 🎨 **Status Visual**

Se os componentes PrimeFaces estão aparecendo **coloridos** (azul, verde, vermelho), está funcionando corretamente.

Se estão aparecendo **cinza/sem estilo**, verificar:
1. Reiniciar servidor
2. Limpar cache do navegador
3. Verificar se o tema 'saga' está carregando

## ✅ **Confirmação de Funcionamento**

Acesse: http://localhost:8080/wb_cars/teste-oficial.xhtml

Você deve ver:
- ✅ Spinner animado
- ✅ Botões coloridos (Primary azul, Success verde, Danger vermelho)
- ✅ Ícones carregando
- ✅ Tema moderno aplicado

## 📞 **Próximos Passos**

1. Confirmar que PrimeFaces está funcionando
2. Implementar entidades do sistema
3. Criar páginas de CRUD
4. Integrar com banco PostgreSQL

---

**🎯 Projeto configurado e funcionando com Java 17 + Jakarta EE 10 + PrimeFaces 15.0.0**
