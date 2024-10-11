import java.util.Arrays;

public class QuickSort implements SortingStrategy {

  
    /*
       A mediana de uma sequência de tamanho ímpar é o valor que divide uma sequência ao meio, isto é, 
       metado dos valores são menores que ela, enquanto metade são maiores. Implemente o método abaixo
       que recebe uma sequência de tamanho ímpar e retorna a mediana dessa sequência.
    */
    public int mediana(int[] v) {
        int[] c = Arrays.copyOf(v, v.length);
        Arrays.sort(c);
        return c[c.length/2];
    }

    /**
    * Implemente a versão do quick sort usando o particionamento Hoare, que está descrito
    * neste material: https://joaoarthurbm.github.io/eda/posts/particionamento-hoare/
    */
    public void sort(int[] v, int ini, int fim) {
        if (ini < fim){
            int p = partition(v, ini, fim);
            sort(v, ini, p);
            sort(v, p+1, fim);
        }
    }

    private int partition(int[] v, int ini, int fim){
        int pivot = v[ini];
        int i = ini - 1;
        int j = fim;

        while (true){
            do{
                i++;
            } while (v[i] < pivot);
            do {
                j--;
            } while (v[j] > pivot);
            if (i >= j){
                return j;
            }
            swap(v, i, j);
        }
    }

    private void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }


    /**
    * Nós discutimos em sala de aula que uma tentativa para melhorar a escolha do pivot é
    * decidir usar o valores mediano (não média, cuidado) entre o primeiro elemento do array,
    * o elemento central e o último.

    * Implemente o método abaixo que retorna o valor que seria escolhido como pivot seguindo
    * a abordagem acima.
    * 
    * Interprete os testes para saber qual valor usar como elemento central para calcular a mediana de três.
    */
    public int medianaDeTres(int[] v) {
        int primeiro = v[0];
        int meio = v[v.length/2];
        int ultimo = v[v.length - 1];
        return mediana(new int[]{primeiro, meio, ultimo});
    }

}
