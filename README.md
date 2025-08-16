
# wb_cars

## Requisitos Funcionais Implementados

| Status | Tela                                                        | Código |
|:------:|:------------------------------------------------------------|:------:|
| ✅     | Tela de Cadastro de Veículos                                | RF1    |
| ✅     | Tela de Cadastro de Clientes                                | RF2    |
| ✅     | Tela de Agendamento de Serviços                             | RF3    |
| ✅     | Tela de Controle de Estoque e Peças                         | RF4    |
| ✅     | Tela de Emissão de Ordens de Serviço (OS)                   | RF5    |
| ✅     | Tela de Relatórios Financeiros                              | RF6    |
| ✅     | Tela de Cadastro de Usuários                                | RF7    |
| ✅     | Tela de Cadastro de Funcionários                            | RF8    |
| ✅     | Tela de Cadastro de Cidades                                 | RF9    |
| ✅     | Tela de Cadastro de Empresas                                | RF10   |
| ✅     | Tela de Cadastro de Fornecedores                            | RF11   |
| ✅     | Tela de Cadastro de Produtos                                | RF12   |
| ✅     | Tela de Cadastro de Unidade de Medidas                      | RF13   |
| ✅     | Tela de Orçamentos                                         | RF14   |
| ✅     | Tela de Contas a Pagar                                      | RF15   |
| ✅     | Tela de Vendas                                             | RF16   |
| ✅     | Tela de Relatórios Financeiros Detalhados                   | RF17   |

## Sobre o Projeto

O **wb_cars** é um sistema web robusto para gestão automotiva, desenvolvido com foco em segurança, auditoria e boas práticas modernas.

---

## Funcionalidades e Recursos

- Autenticação de usuários com senha criptografada (BCrypt)
- Criação automática do usuário admin na primeira execução
- Login seguro com limitação de tentativas e bloqueio temporário
- Logout seguro e proteção contra session fixation
- Timeout de sessão configurado (20 minutos)
- Proteção contra CSRF (Cross-Site Request Forgery) ativada
- Auditoria avançada: todas as tentativas de login, logout e bloqueios são registradas em arquivo (`logs/auditoria.log`)
- Auditoria automática de entidades com Hibernate Envers
- Geração automática de tabelas e auditoria no banco (Hibernate)
- Filtro para forçar uso de HTTPS em produção
- Proteção contra XSS e SQL Injection (uso de JSF, JPA e validação)
- Diretório para imagens front-end: `src/main/webapp/resources/imagens`
- Favicon e logo personalizados nas telas
- Estrutura de pacotes organizada: modelo, dao, controle, util, filtro, config

---

## Tecnologias Utilizadas

- **Java 8**
- **Maven**
- **JSF 2.2 (Mojarra)**
- **PrimeFaces 6.2**
- **Spring Framework**
- **Hibernate + Envers**
- **PostgreSQL**
- **Apache Tomcat 9.x**
- **SLF4J + Logback** (logs de auditoria)

---

## Segurança

- Senhas armazenadas com BCrypt (não reversível)
- Limite de 5 tentativas de login por sessão (bloqueio por 5 minutos)
- Proteção CSRF nativa do JSF 2.2
- Auditoria de login/logout/bloqueio em arquivo
- Session fixation protection: sessão é invalidada ao logar
- Timeout de sessão: 20 minutos
- Filtro HTTPS: redireciona todo acesso HTTP para HTTPS
- Proteção XSS e SQL Injection por padrão dos frameworks

---

## Auditoria

- Todas as tentativas de login, logout e bloqueios são registradas em `logs/auditoria.log` (padrão SLF4J/Logback)
- Auditoria automática de alterações nas entidades com Hibernate Envers

---

## Imagens e Favicon

- Imagens para uso no front devem ser colocadas em `src/main/webapp/resources/imagens`
- O favicon da aplicação é `logo_2.png` e o logo principal é `logo.png`, ambos neste diretório

---

## Como acessar a aplicação

Acesse no navegador:

	http://localhost:8081/wb_cars/

Usuário admin padrão: `admin` / senha: `admin` (recomendado trocar após o primeiro acesso)

---

## Ambiente de Desenvolvimento Recomendado

- **Eclipse IDE for Enterprise Java and Web Developers** (ou VS Code)
- **Apache Tomcat 9.x** (porta 8081)
- **Java 8**

---

## Observações

- Para produção, configure o Tomcat com HTTPS e mantenha o filtro ativo
- O sistema está pronto para evoluir com controle de permissões, políticas de senha forte e outros recursos avançados

---

> Projeto em constante evolução, com foco em segurança, auditoria e boas práticas!