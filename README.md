# 🎓 Sistema de Gestão de Biblioteca Acadêmica

**Disciplina:** Programação Orientada a Objetos (POO)  
**Professor:** Me. Gleidson Porto Batista

## 📌 Objetivo Geral

Desenvolver um sistema orientado a objetos em Java com foco na gestão de uma biblioteca acadêmica. O sistema deve aplicar os principais conceitos da Programação Orientada a Objetos (POO), oferecendo uma interface textual (console) ou gráfica opcional (Swing ou Web), permitindo que usuários realizem **consultas, empréstimos e devoluções** de livros de forma funcional e organizada.

---

## 🧾 Descrição Geral do Sistema

O sistema simula o funcionamento de uma biblioteca universitária e deverá permitir que:

- O **bibliotecário** cadastre usuários da biblioteca (alunos e professores), gerencie o acervo de livros e realize operações de empréstimo e devolução.
- As informações sejam armazenadas e consultadas em tempo de execução utilizando estruturas como `ArrayList` e `HashMap`.

---

## ✅ Funcionalidades Principais

- **Cadastro de Livros:** título, autor, ISBN, ano e editora.
- **Cadastro de Usuários:** nome, matrícula, tipo (aluno ou professor), CPF e e-mail.
- **Consulta de Disponibilidade de Livros.**
- **Empréstimos:** número do empréstimo, usuário, livro(s), data e status do empréstimo.
- **Devolução de Livros:** atualização do status do empréstimo e da disponibilidade do exemplar.
- **Listagem de Livros:** ISBN, título, autor, editora e status (disponível ou emprestado).

---

## 🧩 Modelagem UML

- **Diagrama de Casos de Uso:** contempla o ator Bibliotecário e suas interações com o sistema.
- **Diagrama de Classes:** inclui as classes:
  - `Livro`
  - `Usuario` (superclasse), `Aluno`, `Professor`
  - `Emprestimo`
- **(Opcional)** Diagrama de Sequência: para operações de empréstimo e devolução.

---

## 💻 Requisitos Técnicos

- **Linguagem:** Java (JDK 8 ou superior)
- **Paradigma:** Programação Orientada a Objetos
- **IDE sugerida:** BlueJ, Eclipse, IntelliJ IDEA ou VS Code
- **Interface:** Console (obrigatória) ou Gráfica com Swing (opcional)
- **Persistência:** Banco de dados é opcional (utilização em tempo de execução com coleções)

### Boas práticas exigidas:

- Encapsulamento com atributos privados e métodos públicos (`getters/setters`)
- Herança: `Aluno` e `Professor` herdam de `Usuario`
- Polimorfismo, se aplicável
- Uso de coleções (`ArrayList`, `HashMap`) para gerenciamento dos dados
- Organização em pacotes
- Comentários explicativos no código

---

## 📝 Critérios de Avaliação (2,0 pontos)

1. **Aplicação da POO:** herança, encapsulamento, polimorfismo, boas práticas.
2. **Modelagem UML:** qualidade dos diagramas de Casos de Uso e Classes.
3. **Funcionalidade do Sistema:** todos os recursos devem funcionar corretamente.
4. **Organização e Clareza do Código:** código limpo, comentado e bem nomeado.
5. **Relatório Técnico e Apresentação:** entrega obrigatória com explicações e diagramas.

---

## 📦 Conteúdo da Entrega

### Arquivos obrigatórios:

- Código-fonte completo (organizado em pastas).
- Relatório técnico em PDF contendo:
  - Capa com nome do(s) integrante(s);
  - Descrição das funcionalidades implementadas;
  - Diagramas UML (Casos de Uso, Classes e Sequência - se houver);
  - Prints ou descrição das interfaces utilizadas;
  - Código-fonte completo das classes.

---

## ⏰ Prazo de Entrega

**Data limite:** 03/06 (última aula antes da prova A1)

---

## 👥 Informações Adicionais

- Projeto pode ser desenvolvido **individualmente ou em duplas**.
- Cada aluno deve enviar seu próprio arquivo na plataforma.
- A apresentação oral é obrigatória.
- Projetos com plágio ou sem funcionalidade podem ser desconsiderados.

---

### 🚀 Desenvolvido por

> Pedro Henrique Sipriano Cavalcante  
> Ciência da Computação - UDF  
> [GitHub](https://github.com/seuusuario) | [LinkedIn](https://www.linkedin.com/in/pedro-henrique-sipriano-cavalcante-9a12732a9)
