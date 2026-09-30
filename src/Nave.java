public class Nave implements Reparavel {

    private String nome;
    private int combustivel;
    private int integridade;

    public Nave(String nome) {
        this.nome = nome;
        this.combustivel = 50;
        this.integridade = 100;
    }

    public String getNome() {
        return nome;
    }

    public int getCombustivel() {
        return combustivel;
    }

    public int getIntegridade() {
        return integridade;
    }

    public void viajar() {
        if (combustivel >= 10) {
            combustivel -= 10;
            System.out.println("A nave viajou para outro planeta.");
        } else {
            System.out.println("Combustível insuficiente!");
        }
    }

    public void adicionarCombustivel(int quantidade) {
        combustivel += quantidade;

        if (combustivel > 100) {
            combustivel = 100;
        }

        System.out.println("Combustível atual: " + combustivel);
    }

    public void receberDano(int dano) {
        integridade -= dano;

        if (integridade < 0) {
            integridade = 0;
        }

        System.out.println("A nave sofreu " + dano + " de dano.");
    }

    @Override
    public void reparar() {
        integridade += 30;

        if (integridade > 100) {
            integridade = 100;
        }

        System.out.println("A nave foi reparada!");
    }

    public boolean estaDestruida() {
        return integridade <= 0;
    }

    public boolean semCombustivel() {
        return combustivel <= 0;
    }
}