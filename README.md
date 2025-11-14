
# Testes Automatizados - AGI Blog Web (Selenium + Java)


![Tests](https://img.shields.io/badge/tests-passing-brightgreen)

![Java](https://img.shields.io/badge/Java-17-red)

![JUnit](https://img.shields.io/badge/JUnit-5-blue)

![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green)

![Maven](https://img.shields.io/badge/Maven-Automation-orange)

![Last Commit](https://img.shields.io/github/last-commit/fernandaksprado/Teste-WEB-automatizado)


Documento elaborado por: **Fernanda Prado**  
Execução realizada em macOS – **Novembro/2025**

---

## 1. Objetivo

Este repositório contém uma suíte de testes automatizados para validar funcionalidades principais do **Blog do Agi**, com foco na experiência de navegação e na busca de artigos.

A automação foi desenvolvida utilizando:

- Java 17  
- Selenium WebDriver 4  
- JUnit 5  
- Maven  
- WebDriverManager  

---

## 2. Status da Última Execução

- **Data:** 13/11/2025  
- **Resultado:** ✅ **SUCESSO**  
- **Total de testes:** 2  
- **Falhas:** 0  
- **Erros:** 0  
- **Tempo total:** 7,937s  
- **Ambiente:** macOS 15.6.1 + Java 17 + Chrome 142

---

## 3. Badge Automático (CI/CD)

*(Será atualizado quando o GitHub Actions for habilitado)*

![Status](https://img.shields.io/badge/tests-passing-brightgreen)

---

## 4. Estrutura do Projeto

```
/src
 ├── main
 │    └── java
 │         └── br/com/agi/pages
 │              ├── BasePage.java
 │              ├── HomePage.java
 │              └── SearchResultsPage.java
 └── test
      └── java
           └── br/com/agi/tests
                └── SearchBlogTests.java
```

Modelo baseado em **Page Object Model (POM)** para garantir organização e fácil manutenção.

---

## 5. Requisitos

- Java 17  
- Maven 3.9+  
- Google Chrome  
- Selenium WebDriver 4.24  
- WebDriverManager

---

## 6. Como Executar

### Com navegador visível:
```
mvn clean test -Dheadless=false
```

### Headless:
```
mvn clean test
```

---

## 7. Cenários Implementados

### 🔎 Cenário 1 — Buscar por “empréstimo”
- Acessa o blog  
- Abre o campo de busca  
- Digita "empréstimo"  
- Valida que resultados são exibidos  

### 🔎 Cenário 2 — Busca com termo aleatório (“renda”)
- Acessa o blog  
- Abre a busca  
- Pesquisa por "renda"  
- Confirma que artigos retornaram  

---

## 8. Observação Importante (Requisito da Lupa)

O teste pedia explicitamente:

> “Validar que a lupa funciona e abre o campo de busca.”

Durante o desenvolvimento, foi identificado que:

- O botão da lupa é composto por vários elementos internos dinâmicos.  
- O SVG é re-renderizado no DOM em determinadas transições.  
- Em determinados momentos o Selenium encontrava o elemento, mas ele ficava **stale** segundos depois.  
- Isso gerava erros como:  
  - `element not clickable`  
  - `stale element reference`

### ✔ Solução aplicada
Para garantir estabilidade:

- Implementação de **WebDriverWait** aguardando:
  - visibilidade  
  - clicabilidade  
- Re-busca do elemento antes de clicar  
- Fallback clicando no **container pai**, mais estável no DOM  

Resultado:  
**A lupa está sendo clicada com sucesso e o requisito foi atendido.**

---

## 9. Possíveis Evoluções

- Pipeline GitHub Actions com geração automática de relatórios  
- Relatórios Allure  
- Execução paralela  
- Suporte multi-browser  
- Testes com dados externos  

---

## 10. Autor

Desenvolvido por **Fernanda Prado**  

---


### Execução (14/11/2025 01:13:42)
- Teste: **testSearchLoan()**
- Evidência: `evidence_testSearchLoan()_1763093622033.png`

### Execução (14/11/2025 01:13:44)
- Teste: **testSearchRandom()**
- Evidência: `evidence_testSearchRandom()_1763093624067.png`
