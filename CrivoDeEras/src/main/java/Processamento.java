import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Processamento {

    private int numeroN;
    private double limiteRaizDeN;


    public Processamento(int numeroN){
        this.numeroN =  numeroN;
    }

    public void setLimite(){
        this.limiteRaizDeN = Math.sqrt(numeroN);
    }

    public ArrayList<Integer> listaInicial(){
        return IntStream.range(0,(numeroN+1))
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
    }

    public void primosAteARaiz(){

        long limite = (long) limiteRaizDeN;

        ArrayList<Integer> primos = new ArrayList<>();

        listaInicial().stream()
                .limit(limite)
                .forEach(num -> {
                    long primo = IntStream.range(num,0)
                                        .boxed()
                                        .filter(ele -> num % ele == 0)
                                        .count();
                    System.out.println("Contagem : " + primo);
                    if(primo<3){
                        primos.add(num);
                    }
                });
        primos.stream().forEach(e-> System.out.println(e));
    }

}
