package siga;

public class PainelSecretaria implements Painel {
   
    @Override
    public void montar() {
        System.out.println("=== Painel da Secretária ===");
        System.out.println("- Turmas do curso");
        System.out.println("- Listagem das matriculas");
        System.out.println("- Contatos");
    }
}
