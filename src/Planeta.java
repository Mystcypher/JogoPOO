public class Planeta {

    private String nome;
    private Evento evento;

    public Planeta(String nome, Evento evento) {
        this.nome = nome;
        this.evento = evento;
    }

    public String getNome() {
        return nome;
    }

    public void visitar(Nave nave) {
        System.out.println("\nVocê chegou ao planeta " + nome + "!");

        if (evento != null) {
            evento.executar(nave);
        }
    }
}