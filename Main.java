import javax.naming.PartialResultException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random gerador = new Random();
        Scanner console = new Scanner(System.in);
        String separator = "=".repeat(50);
        String header = separator + "\n" +
                        "               GERENCIADOR BANCÁRIO\n" +
                        separator + "\n";
        char option = ' ';
        int taksID = 0;
        ArrayList<String> clients = new ArrayList<>();
        ArrayList<Double> accountBalance = new ArrayList<>();
        ArrayList<Integer> accountsId = new ArrayList<>();
        int accountId = 0;

        do {
            System.out.println(header +
                    "1 - CADASTRAR CONTA\n" +
                    "2 - REALIZAR DEPÓSITO\n" +
                    "3 - REALIZAR SAQUE\n" +
                    "4 - CONSULTAR SALDO\n" +
                    "5 - CONSULTAR HISTÓRICO DE MOVIMENTAÇÕES\n" +
                    "6 - TRANSFERIR\n" +
                    separator);
            System.out.print("Digite a operação desejada: ");
            taksID = console.nextInt();
            console.nextLine();
            switch (taksID) {
                case 1:
                    System.out.print(header);
                    System.out.println("CADASTRO DE NOVA CONTA:\n");
                    System.out.print("Informe seu nome: ");
                    String name = console.nextLine();
                    System.out.println("Deseja adicionar um saldo inicial? (s/n)");
                    char optionInitialBalance = console.next().charAt(0);
                    double initialBalance = 0.00;
                    if (optionInitialBalance == 's') {
                        System.out.print("Informe o saldo desejado: ");
                        initialBalance = console.nextDouble();
                    }
                    accountId = gerador.nextInt(1000, 2000);
                    clients.add(name);
                    accountsId.add(accountId);
                    // Criar validação se o ID já não existe
                    accountBalance.add(initialBalance);
                    System.out.print(header);
                    System.out.println("Seja bem vindo ao Banco Azul, Sr. " + new ArrayList<>(List.of(name.split(" "))).getLast() + "\n\n"+
                            "ID: " + accountId + "\n" +
                            "Nome: " + name + "\n" +
                            "Saldo inicial: " + initialBalance + "\n"
                    );
                break;
                case 2:
                    accountId = 0;
                    System.out.println(header);
                    System.out.print("Informe o número da sua conta: ");
                    accountId = console.nextInt();
                    if (accountId > 1000) {
                        for (int i = 0; i < accountsId.size();i++) {
                            if (accountsId.get(i) == accountId) {
                                System.out.println(header);
                                String clientName = clients.get(i);
                                System.out.println("Olá novamente Sr. " + new ArrayList<>(List.of(clientName.split(" "))).getLast() + "\n");
                                System.out.print("Qual o valor que deseja depositar: ");
                                double deposit = console.nextDouble();
                                double actualBalance = accountBalance.get(i);
                                actualBalance += deposit;
                                System.out.println("Depósito realizado.\n" +
                                        "Seu novo saldo é de: " + actualBalance + "\n");
                                accountBalance.set(i,actualBalance);
                            } else {
                                System.out.println("Conta não localizada.");
                            }
                        }
                    }
                break;
                default:
                    System.out.println("Operação: "+ taksID + " não reconhecida.");
                break;
            }
            System.out.println("Deseja realizar mais alguma operação ? (s/n)");
            option = console.next().charAt(0);
        } while (option != 'n');

    }
}
