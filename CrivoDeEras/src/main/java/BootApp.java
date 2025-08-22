import java.util.Scanner;

public class BootApp {
    public static void main(String[] args) {
        System.out.println("Aplicação para encontrar números primos pelo algoritmo\nCrivo de Eratóstenes");

        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite o número até onde deseja descobrir os fatores primos: ");
        int numero = leitura.nextInt();

        Processamento proc = new Processamento(numero);
        proc.setLimite();
        proc.resultadoPrimos();

    }
}
