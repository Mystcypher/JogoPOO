public class Estacao extends Evento {

    public Estacao() {
        super("Você encontrou uma estação espacial!");
    }

    @Override
    public void executar(Nave nave) {
        System.out.println(getDescricao());

        nave.reparar();
        nave.adicionarCombustivel(20);
    }
}