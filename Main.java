import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String separator = "=".repeat(50);
        String header = separator + "\n" +
                        "               GERENCIADOR BANCÁRIO\n" +
                        separator + "\n";
        char option = ' ';

        do {
            System.out.println(header +
                    "1 - CADASTRAR CONTA\n" +
                    "2 - REALIZAR DEPÓSITO\n" +
                    "3 - REALIZAR SAQUE\n" +
                    "4 - CONSULTAR SALDO\n" +
                    "5 - CONSULTAR HISTÓRICO DE MOVIMENTAÇÕES\n" +
                    "6 - TRANSFERIR\n" +
                    separator);

            System.out.println("Deseja realizar mais alguma operação  (s/n)?");
            option = console.next().charAt(0);
        } while (option != 'n');

    }
}
