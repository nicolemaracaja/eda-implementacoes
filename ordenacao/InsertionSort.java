public class InsertionSort implements SortingStrategy {

    /**
    * O array  está ordenado exceto pelo último elemento. Esse método
    * deve colocar o último elemento em sua posição.
    * Importante: seu algoritmo deve ser O(n).
    */
    public void insereUltimoOrdenado(int[] v) {
        int n = v.length;
        int ultimo = v[n-1]; //ultimo elemento
        int i = n - 2; //penultimo elemento
        while (i >= 0 && v[i] > ultimo){
            int aux = v[i+1];
            v[i+1] = v[i];
            v[i] = aux;
            i--;
        }
    }
   
    /**
    * O array  está ordenado exceto pelo primeiro elemento. Esse método
    * deve colocar o primeiro elemento em sua posição. Ao final da execução,
    * v deve estar ordenado.
    * Importante: seu algoritmo deve ser O(n);
    */
    public void inserePrimeiroOrdenado(int[] v) {
        int n = v.length;
        int primeiro = v[0]; //primeiro elemento
        int i = 1; //segundo elemento
        while (i < n && v[i] < primeiro){
            int aux = v[i-1];
            v[i-1] = v[i];
            v[i] = aux;
            i++;
        }
    }

    /**
    * Ordena um array de inteiros utilizando o insertion sort.
    */
    public void sort(int[] v) {
        for (int i = 1; i < v.length; i++){
            int j = i;
            while (j > 0 && v[j] < v[j-1]){
                int aux = v[j];
                v[j] = v[j-1];
                v[j-1] = aux;
                j--;
            }
        }
    }

    /**
    * Ordena um array de inteiros utilizando o insertion sort de maneira recursiva.
    * Pense que insertion sort são várias execuções da inserção ordenada e use
    * essa estratégia chamando recursivamente. 
    * Você não pode mudar a assinatura desse método, mas pode/deve criar outros
    * métodos para te auxiliar na recursão.
    */
    public void sortRecursivo(int[] v) {
        for(int i = 1; i < v.length; i++){
            sortRecursivo(v, i);
        }
    }

    private void sortRecursivo(int[] v, int index){
        if (index <= 0){
            return;
        }
        if(v[index-1] > v[index]){
            int aux = v[index];
            v[index] = v[index-1];
            v[index-1] = aux;
            sortRecursivo(v, index-1);
        }
        return;
    }

}
