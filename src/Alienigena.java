public class Alienigena extends Evento {

    public Alienigena() {
        super("Um alienígena apareceu!");
    }

    @Override
    public void executar(Nave nave) {
        System.out.println(getDescricao());
        System.out.println("O alienígena entregou combustível para você!");

        nave.adicionarCombustivel(20);
    }
}
