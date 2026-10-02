public class Nave implements Reparavel {

    private static final int CUSTO_VIAGEM = 10;
    private static final int CUSTO_REPARO_EMERGENCIA = 5;
    private static final int MAXIMO = 100;
    private static final int REPAROS_INICIAIS = 3;

    private String nome;
    private int combustivel;
    private int integridade;
    private int reparosRestantes;

    public Nave(String nome) {
        this.nome = nome;
        this.combustivel = 50;
        this.integridade = 100;
        this.reparosRestantes = REPAROS_INICIAIS;
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

    public int getReparosRestantes() {
        return reparosRestantes;
    }

    public boolean viajar() {
        if (combustivel >= CUSTO_VIAGEM) {
            combustivel -= CUSTO_VIAGEM;
            System.out.println("A nave viajou para outro planeta.");
            return true;
        }
        System.out.println("Combustível insuficiente!");
        return false;
    }

    public void adicionarCombustivel(int quantidade) {
        combustivel += quantidade;

        if (combustivel > MAXIMO) {
            combustivel = MAXIMO;
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

        if (integridade > MAXIMO) {
            integridade = MAXIMO;
        }

        System.out.println("A nave foi reparada!");
    }

    public void repararEmergencia() {
        if (reparosRestantes <= 0) {
            System.out.println("Você não tem mais reparos de emergência!");
            return;
        }

        if (combustivel < CUSTO_REPARO_EMERGENCIA) {
            System.out.println("Combustível insuficiente para o reparo!");
            return;
        }

        combustivel -= CUSTO_REPARO_EMERGENCIA;
        reparosRestantes--;
        reparar();
        System.out.println("(Custou " + CUSTO_REPARO_EMERGENCIA
                + " de combustível. Reparos restantes: " + reparosRestantes + ")");
    }

    public boolean estaDestruida() {
        return integridade <= 0;
    }

    public boolean semCombustivel() {
        return combustivel < CUSTO_VIAGEM;
    }

}