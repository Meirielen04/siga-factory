package siga;

public class FabricaPainel {

  public Painel criar(String tipoUsuario) {
    switch (tipoUsuario) {
      case "ALUNO":
        return new PainelAluno();
      case "PROFESSOR":
        return new PainelProfessor();
      case "COORDENADOR":
        return new PainelCoordenador();
      default:
        throw new IllegalArgumentException("Painel não existente: " + tipoUsuario);
    }
  }
}