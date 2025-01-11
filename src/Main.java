import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\nEscolha o exercício a executar (1 a 5) ou 0 para sair:");
            System.out.println("1 - Soma de números");
            System.out.println("2 - Verificar número na sequência de Fibonacci");
            System.out.println("3 - Análise de faturamento diário");
            System.out.println("4 - Percentual de faturamento por estado");
            System.out.println("5 - Inverter uma string");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    executarExercicio1();
                    break;
                case 2:
                    executarExercicio2(scanner);
                    break;
                case 3:
                    executarExercicio3();
                    break;
                case 4:
                    executarExercicio4();
                    break;
                case 5:
                    executarExercicio5(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 0);

        scanner.close();
    }

    private static void executarExercicio1() {
        int INDICE = 13, SOMA = 0, K = 0;
        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }
        System.out.println("Exercício 1 - Valor final de SOMA: " + SOMA);
    }

    private static void executarExercicio2(Scanner scanner) {
        System.out.println("Exercício 2 - Informe um número:");
        int numero = scanner.nextInt();

        if (isFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }
    }

    private static boolean isFibonacci(int num) {
        int a = 0, b = 1, c = 0;
        while (c < num) {
            c = a + b;
            a = b;
            b = c;
        }
        return c == num || num == 0;
    }
    private static void executarExercicio3() {
        double[] faturamento = {22174.1664, 24537.6698, 26139.6134, 0.0, 0.0, 26742.6612, 0.0,
                42889.2258, 46251.174, 11191.4722, 0.0, 0.0, 3847.4823, 373.7838, 2659.7563,
                48924.2448, 18419.2614, 0.0, 0.0, 35240.1826, 43829.1667, 18235.6852, 4355.0662,
                13327.1025, 0.0, 0.0, 25681.8318, 1718.1221, 13220.495, 8414.61};

        double menor = Double.MAX_VALUE;
        double maior = Double.MIN_VALUE;
        double soma = 0.0;
        int diasComFaturamento = 0;

        for (double valor : faturamento) {
            if (valor > 0) {
                soma += valor;
                diasComFaturamento++;
                if (valor < menor) menor = valor;
                if (valor > maior) maior = valor;
            }
        }

        double media = soma / diasComFaturamento;

        int diasAcimaMedia = 0;
        for (double valor : faturamento) {
            if (valor > media) diasAcimaMedia++;
        }

        System.out.println("Exercício 3 - Menor valor: " + menor);
        System.out.println("Exercício 3 - Maior valor: " + maior);
        System.out.println("Exercício 3 - Dias com faturamento acima da média: " + diasAcimaMedia);
    }
    private static void executarExercicio4() {
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double total = sp + rj + mg + es + outros;

        System.out.printf("Exercício 4 - SP: %.2f%%\n", (sp / total) * 100);
        System.out.printf("Exercício 4 - RJ: %.2f%%\n", (rj / total) * 100);
        System.out.printf("Exercício 4 - MG: %.2f%%\n", (mg / total) * 100);
        System.out.printf("Exercício 4 - ES: %.2f%%\n", (es / total) * 100);
        System.out.printf("Exercício 4 - Outros: %.2f%%\n", (outros / total) * 100);
    }

    private static void executarExercicio5(Scanner scanner) {
        System.out.println("Exercício 5 - Digite a string a ser invertida:");
        scanner.nextLine();
        String input = scanner.nextLine();

        String invertida = inverteString(input);
        System.out.println("Exercício 5 - String invertida: " + invertida);
    }

    private static String inverteString(String str) {
        char[] chars = str.toCharArray();
        String resultado = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            resultado += chars[i];
        }
        return resultado;
    }
}