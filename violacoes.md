Em `GerenciadorLogin` temos violação de OCP e acoplamento.

**Acoplamento:** acontece porque a classe conhece diretamente as classes concretas (`PainelAluno`, `PainelProfessor` e `PainelCoordenador`) e usa `new` para criá-las. Isso aumenta a dependência e dificulta alterações.

**OCP:** é violado porque, ao adicionar um novo perfil, precisamos modificar o `if/else` da classe. O ideal é poder adicionar novos perfis sem modificar o código que já existe.
