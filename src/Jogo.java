import java.util.Scanner;

public class Jogo {

    private Scanner scanner;
    private Gato gato;
    private Nave nave;
    private Planeta[] planetas;
    private int planetaAtual;

    public Jogo() {
        scanner = new Scanner(System.in);

        gato = new Gato("Miau");
        nave = new Nave("Bigode Espacial");

        planetas = new Planeta[4];

        planetas[0] = new Planeta("Marte", new Asteroide());
        planetas[1] = new Planeta("Jupiter", new Alienigena());
        planetas[2] = new Planeta("Saturno", new Estacao());
        planetas[3] = new Planeta("Terra", null);

        planetaAtual = 0;
    }

    public void iniciar() {

        System.out.println("=================================");
        System.out.println("        SPACE CAT");
        System.out.println("=================================");
        System.out.println();

        System.out.println("Bem-vindo, " + gato.getNome() + "!");
        System.out.println("Sua nave sofreu uma pane.");
        System.out.println("Você precisa voltar para a Terra.");
        System.out.println();

        while (true) {

            mostrarStatus();

            if (nave.estaDestruida()) {
                System.out.println("\nSua nave foi destruída!");
                System.out.println("GAME OVER!");
                break;
            }

            if (nave.semCombustivel()) {
                System.out.println("\nVocê ficou sem combustível!");
                System.out.println("GAME OVER!");
                break;
            }

            if (planetaAtual == planetas.length - 1) {
                System.out.println("\n=================================");
                System.out.println("          VITÓRIA!");
                System.out.println("=================================");
                System.out.println("Você conseguiu voltar para a Terra!");
                System.out.println("O gato " + gato.getNome() + " está em casa!");
                break;
            }

            mostrarMenu();

            int opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    viajar();
                    break;

                case 2:
                    nave.reparar();
                    break;

                case 3:
                    System.out.println("Você decidiu continuar a missão.");
                    break;

                case 4:
                    System.out.println("Jogo encerrado.");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    private void mostrarStatus() {

        System.out.println("\n---------------------------------");
        System.out.println("Piloto: " + gato.getNome());
        System.out.println("Nave: " + nave.getNome());
        System.out.println("Planeta: " + planetas[planetaAtual].getNome());
        System.out.println("Combustível: " + nave.getCombustivel());
        System.out.println("Integridade: " + nave.getIntegridade());
        System.out.println("---------------------------------");
    }

    private void mostrarMenu() {

        System.out.println("\nO que deseja fazer?");
        System.out.println("1 - Viajar para o próximo planeta");
        System.out.println("2 - Reparar a nave");
        System.out.println("3 - Continuar");
        System.out.println("4 - Sair");
        System.out.print("Escolha: ");
    }

    private void viajar() {

        if (nave.getCombustivel() < 10) {
            System.out.println("Você não possui combustível suficiente para viajar.");
            return;
        }

        nave.viajar();

        planetaAtual++;

        Planeta planeta = planetas[planetaAtual];

        if (planetaAtual < planetas.length - 1) {
            planeta.visitar(nave);
        }
    }
}