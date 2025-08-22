import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class BootApp {
    public static void main(String[] args) {
        System.out.println("Aplicação para encontrar números primos pelo algoritmo\nCrivo de Eratóstenes");

        Scanner leitura = new Scanner(System.in);


        try {
            System.out.print("Digite o número até onde deseja descobrir os fatores primos: ");
            int numero = leitura.nextInt();

            Instant inicio = Instant.now();

            Processamento proc = new Processamento();
            ArrayList<Integer> lista = proc.resultadoPrimos(numero);

            Instant fim = Instant.now();

            Duration duracao = Duration.between(inicio,fim);
            long segundos = duracao.getSeconds() % 60;
            long milis = duracao.toMillis() % 1000;

            System.out.printf("\n%02d Segundos e %3d Milisegundos",segundos,milis );
        }catch (Exception e){
            System.out.println("Erro , número inserido inválido");
        }
    }
}
