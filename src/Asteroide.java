public class Asteroide extends Evento {

    public Asteroide() {
        super("Um campo de asteroides apareceu!");
    }

    @Override
    public void executar(Nave nave) {
        System.out.println(getDescricao());
        nave.receberDano(20);
    }
}