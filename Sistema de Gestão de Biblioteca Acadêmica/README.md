## Primeiros Passos

Bem-vindo ao mundo Java no Visual Studio Code! Este guia ajudará você a começar a escrever código Java utilizando o VS Code.

## Estrutura de Pastas

O workspace contém duas pastas por padrão, onde:

* `src`: pasta onde ficam os arquivos-fonte do projeto (código Java).
* `lib`: pasta onde devem ser colocadas as dependências externas (bibliotecas JAR).

Os arquivos compilados (bytecode `.class`) serão gerados automaticamente na pasta `bin`.

> Se você quiser personalizar a estrutura de pastas, abra o arquivo `.vscode/settings.json` e altere as configurações correspondentes.

## Gerenciamento de Dependências

A visualização `JAVA PROJECTS` no lado esquerdo do VS Code permite gerenciar facilmente suas dependências. Mais informações podem ser encontradas [neste link](https://github.com/microsoft/vscode-java-dependency#manage-dependencies) (em inglês).

## Executando o Projeto

Para compilar e executar o projeto, siga estas instruções:

1. Certifique-se de que o Java JDK está instalado (versão 11 ou superior recomendada).
2. Abra o projeto no VS Code.
3. Use a opção de execução (`Run`) diretamente no VS Code ou abra um terminal integrado e execute os seguintes comandos:

```bash
javac -d bin src/main/App.java
java -cp bin main.App
```

> Substitua `App.java` pelo nome da sua classe principal, se for diferente.

### Observação sobre limpeza do terminal

O código a seguir é utilizado para limpar o terminal no início do programa:

```java
System.out.print("\033[H\033[J");
```

> **Atenção:** Essa linha usa códigos ANSI para limpar o terminal e pode **não funcionar** corretamente em todos os sistemas ou terminais, como no terminal padrão do Windows. Se estiver vendo caracteres estranhos ou o terminal não estiver limpando como esperado, você pode comentar ou remover essa linha sem prejuízo ao funcionamento do programa.

---
