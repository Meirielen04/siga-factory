# SIGA — Atividade Factory: painéis por perfil (código inicial)

**Técnicas de Programação II (TP2) · Aula 5** — CST em Desenvolvimento de Software Multiplataforma · Fatec de Porto Ferreira

Este é o **código final** da atividade prática da Aula 5. Ele corrige o problema da criação direta de objetos com `if/else` e `new`, que deve encapsular aplicando a **Simple Factory** e o padrão **Factory Method**. O programa compilava e executava — mas o problema não era o funcionamento, e sim a resistência do código à mudança.

## Estrutura do projeto

```
siga-factory/
├── Docs/
│   ├── diagrama.md                 (diagrama de classes UML em Mermaid)
│   └── violacoes.md                (diagnóstico das violações OCP e acoplamento)
├── README.md
└── src/
    └── siga/
        ├── CriadorPainel.java            (criador abstrato — Factory Method)
        ├── CriadorPainelAluno.java       (criador concreto)
        ├── CriadorPainelCoordenador.java (criador concreto)
        ├── CriadorPainelProfessor.java   (criador concreto)
        ├── CriadorPainelSecretaria.java  (criador concreto — novo perfil OCP)
        ├── FabricaPainel.java            (Simple Factory — etapa anterior)
        ├── GerenciadorLogin.java         (cliente refatorado para receber o criador)
        ├── Main.java                     (demonstração do Factory Method em execução)
        ├── Painel.java                   (interface — o "Produto")
        ├── PainelAluno.java              (produto concreto)
        ├── PainelCoordenador.java        (produto concreto)
        ├── PainelProfessor.java          (produto concreto)
        └── PainelSecretaria.java         (produto concreto — novo perfil OCP)
```

## Como compilar e executar

Pré-requisito: JDK 17 ou superior (`java -version` para verificar).

```bash
# 1. Compilar (a saída vai para a pasta "bin")
javac -d bin src/siga/*.java

# 2. Executar
java -cp bin siga.Main
```

## O problema proposital

| Arquivo | O que estava errado |
|---|---|
| `GerenciadorLogin.java` | `montarPainel` usa `if/else` com `new` das classes concretas. Cada novo perfil exige modificar o método, violando o **OCP** e acoplando a classe a todos os painéis concretos. |

### Como foi resolvido
Para tirar o monte de `if/else` do `GerenciadorLogin`, usamos o Factory Method criando uma classe criadora para cada perfil. Com isso, o gerenciador não precisa mais saber qual painel está criando e nem usar `new`. Quando adicionamos a `Secretaria`, só precisamos criar as classes novas dela, sem mexer em nada do código que já estava funcionando.

## Tarefas realizadas

Etapas da ficha de atividade prática:

1. **Identificar** o acoplamento causado pelo `if/else` com `new` em `GerenciadorLogin`.
2. **Simple Factory:** criar uma classe `FabricaPainel` com um método `criar(String tipo)` que centralize a criação e devolva um `Painel`. O `GerenciadorLogin` passa a pedir o painel à fábrica, sem usar `new` das classes concretas.
3. **Factory Method:** refatorar para um criador abstrato (por exemplo, `CriadorPainel`) com um método `criarPainel()`, e uma subclasse por perfil (`CriadorPainelAluno`, `CriadorPainelProfessor`, `CriadorPainelCoordenador`) que sobrescreve esse método. A escolha do painel passa a ser resolvida por polimorfismo.
4. **Adicionar** um novo perfil (por exemplo, `SECRETARIA`, com um `PainelSecretaria`) **sem modificar** o código existente — criando apenas as novas classes. Isso comprova o respeito ao OCP.
5. **Desenhar** o diagrama de classes da solução final (interface do produto, produtos concretos, criador e criadores concretos).
[Diagrama de classes](Docs/diagrama.md)

## Critério de sucesso

Ao final, foi possível **adicionar um novo perfil de usuário** criando apenas novas classes, **sem alterar** `GerenciadorLogin` nem os criadores existentes. Esse é o teste prático de que o Factory Method foi aplicado corretamente.

## Padrão de entrega

Conforme a ficha de atividade prática: identificadores em português, código formatado, entrega no repositório Git com README e commits descritivos. O uso de IA para gerar o código é proibido nesta atividade (ver seção 5.3 da ficha).
