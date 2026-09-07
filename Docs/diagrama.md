``` mermaid
classDiagram
    direction TB

    %% Interface do Produto e Produtos Concretos
    class Painel {
        <<interface>>
        +montar() void
    }

    class PainelAluno {
        +montar() void
    }

    class PainelProfessor {
        +montar() void
    }

    class PainelCoordenador {
        +montar() void
    }

    class PainelSecretaria {
        +montar() void
    }

    Painel <|.. PainelAluno : implementa
    Painel <|.. PainelProfessor : implementa
    Painel <|.. PainelCoordenador : implementa
    Painel <|.. PainelSecretaria : implementa

    %% Criador Abstrato e Criadores Concretos
    class CriadorPainel {
        <<abstract>>
        +criarPainel()* Painel
    }

    class CriadorPainelAluno {
        +criarPainel() Painel
    }

    class CriadorPainelProfessor {
        +criarPainel() Painel
    }

    class CriadorPainelCoordenador {
        +criarPainel() Painel
    }

    class CriadorPainelSecretaria {
        +criarPainel() Painel
    }

    CriadorPainel <|-- CriadorPainelAluno : estende
    CriadorPainel <|-- CriadorPainelProfessor : estende
    CriadorPainel <|-- CriadorPainelCoordenador : estende
    CriadorPainel <|-- CriadorPainelSecretaria : estende

    %% Relações de Criação (Factory Method)
    CriadorPainelAluno ..> PainelAluno : instancia
    CriadorPainelProfessor ..> PainelProfessor : instancia
    CriadorPainelCoordenador ..> PainelCoordenador : instancia
    CriadorPainelSecretaria ..> PainelSecretaria : instancia

    %% Cliente
    class GerenciadorLogin {
        +montarPainel(CriadorPainel criador) Painel
    }

    GerenciadorLogin ..> CriadorPainel : depende de
    GerenciadorLogin ..> Painel : usa
```