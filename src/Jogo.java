import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {

    private final Scanner scanner;
    private final Gato gato;
    private final Nave nave;
    private final ArrayList<Planeta> planetas;
    private int planetaAtual;

    public Jogo() {
        scanner = new Scanner(System.in);

        gato = new Gato("Miau");
        nave = new Nave("Bigode Espacial");

        planetas = new ArrayList<>();
        planetas.add(new Planeta("Lua", null));
        planetas.add(new Planeta("Marte", new Asteroide()));
        planetas.add(new Planeta("Jupiter", new Alienigena()));
        planetas.add(new Planeta("Saturno", new Estacao()));
        planetas.add(new Planeta("Terra", null));

        planetaAtual = 0;
    }

    public void iniciar() {

        System.out.println("=================================");
        System.out.println("        SPACE CAT");
        System.out.println("=================================");
        System.out.println();

        System.out.println("Bem-vindo, " + gato.getNome() + "!");
        System.out.println("Sua nave sofreu uma pane na Lua.");
        System.out.println("Você precisa voltar para a Terra.");
        System.out.println();

        try {
            while (true) {

                mostrarStatus();

                if (nave.estaDestruida()) {
                    System.out.println("\nSua nave foi destruída!");
                    System.out.println("GAME OVER!");
                    break;
                }

                if (chegouNaTerra()) {
                    System.out.println("\n=================================");
                    System.out.println("          VITÓRIA!");
                    System.out.println("=================================");
                    System.out.println("Você conseguiu voltar para a Terra!");
                    System.out.println("O gato " + gato.getNome() + " está em casa!");
                    break;
                }

                if (nave.semCombustivel()) {
                    System.out.println("\nVocê ficou sem combustível para continuar!");
                    System.out.println("GAME OVER!");
                    break;
                }

                mostrarMenu();

                int opcao = lerOpcao();

                switch (opcao) {

                    case 1:
                        viajar();
                        break;

                    case 2:
                        nave.repararEmergencia();
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
        } finally {
            scanner.close();
        }
    }

    private boolean chegouNaTerra() {
        return planetaAtual == planetas.size() - 1;
    }

    private int lerOpcao() {
        String entrada = scanner.nextLine().trim();

        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void mostrarStatus() {

        System.out.println("\n---------------------------------");
        System.out.println("Piloto: " + gato.getNome());
        System.out.println("Nave: " + nave.getNome());
        System.out.println("Planeta: " + planetas.get(planetaAtual).getNome());
        System.out.println("Combustível: " + nave.getCombustivel());
        System.out.println("Integridade: " + nave.getIntegridade());
        System.out.println("Reparos de emergência: " + nave.getReparosRestantes());
        System.out.println("---------------------------------");
    }

    private void mostrarMenu() {

        System.out.println("\nO que deseja fazer?");
        System.out.println("1 - Viajar para o próximo planeta");
        System.out.println("2 - Reparar a nave (custa 5 de combustível)");
        System.out.println("3 - Continuar");
        System.out.println("4 - Sair");
        System.out.print("Escolha: ");
    }

    private void viajar() {

        if (!nave.viajar()) {
            return;
        }

        planetaAtual++;
        planetas.get(planetaAtual).visitar(nave);
    }
}