import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Processamento {

    private int numeroN;
    private double limiteRaizDeN;


    public Processamento(){}

    private void setLimite(){
        this.limiteRaizDeN = Math.sqrt(numeroN);
    }

    public ArrayList<Integer> listaInicial(){
        return IntStream.range(1,(numeroN+1))
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<Integer> primosAteARaiz(){

        long limite = (long) limiteRaizDeN + 1;

        ArrayList<Integer> primos = new ArrayList<>();

        var ateRaiz = listaInicial().stream()
                .limit(limite)
                .collect(Collectors.toCollection(ArrayList::new));

        for(Integer num : ateRaiz){
                long count = IntStream.range(1, num + 1)
                                .boxed()
                                .filter(ele -> num % ele == 0)
                                .count();


            if(count==2){
                primos.add(num);
            }
        }
        return primos;
    }

    public ArrayList<Integer> resultadoPrimos(int numeroN){
        this.numeroN = numeroN;
        setLimite();
        ArrayList<Integer> listaDePrimos = primosAteARaiz();
        ArrayList<Integer> listaProcessada = listaInicial();

        for(int crivo : listaDePrimos){
            ArrayList <Integer> multiplosDinamicos = listaProcessada.stream()
                    .filter(ele -> ele % crivo == 0)
                    .filter(ele -> ele != crivo)
                    .distinct()
                    .collect(Collectors.toCollection(ArrayList::new));
            listaProcessada.removeAll(multiplosDinamicos);
        }
        listaProcessada.remove(0);
        return listaProcessada;
     }

    }


