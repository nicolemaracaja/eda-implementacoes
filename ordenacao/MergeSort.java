public class MergeSort implements SortingStrategy {

    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma crescente
    * e retorna um novo array também ordenado em forma crescente.
    */
    public int[] mergeOrdenadosCrescente(int[] a, int[] b) {
        
        int k = 0;
        int i = 0;
        int j = 0;

        int c[] = new int[a.length + b.length];

        while (i < a.length && j < b.length){
            if (a[i] <= b[j]){
                c[k++] = a[i++];
            }else{
                c[k++] = b[j++];
            } 

        }

        while (i < a.length){
            c[k++] = a[i++];
        }
        while (j < b.length){
            c[k++] = b[j++];
        }

        return c;
    }
    
    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma decrescente
    * e retorna um novo array ordenado em forma crescente.
    */
    public int[] mergeOrdenadosDecrescente(int[] a, int[] b) {
        
        int k = 0;
        int i = 0;
        int j = 0;

        int c[] = new int[a.length + b.length];

        while (i < a.length && j < b.length){
            if (a[i] >= b[j]){
                c[k++] = a[i++];
            }else{
                c[k++] = b[j++];
            } 

        }

        while (i < a.length){
            c[k++] = a[i++];
        }
        while (j < b.length){
            c[k++] = b[j++];
        }

        return c;
    }
   
    /**
    * Implemente o método abaixo, que recebe dois arrays: a, ordenado em forma crescente e b, ordenado
    * em forma descrescente. Seu método deve retornar um array ordenado em forma crescente.
    */
    public int[] mergeOrdenadosDistintos(int[] a, int[] b) {

        int k = 0;
        int i = 0;
        int j = b.length - 1;

        int c[] = new int[a.length + b.length];

        while (i < a.length && j >= 0){
            if (a[i] <= b[j]){
                c[k++] = a[i++];
            }else{
                c[k++] = b[j--];
            }

        }

        while (i < a.length){
            c[k++] = a[i++];
        }
        while (j >= 0){
            c[k++] = b[j--];
        }

        return c;
    }
   
    /**
    * Implemente a versão clássica do merge sort que vimos em sala de aula. Você pode
    * criar métodos auxiliares se precisar.
    */
    public void sort(int[] v, int ini, int fim) {
        
        if (ini >= fim){
            return;
        }else{
            int meio = (ini+fim)/2;
            sort(v, ini, meio);
            sort(v, meio+1, fim);

            merge(v, ini, meio, fim);
        }
    }

    public void merge(int[]v, int ini, int meio, int fim){
        int[] c = new int[v.length];
        for (int i = ini; i <= fim; i++){
            c[i] = v[i];
        }
        
        int i = ini;
        int j = meio + 1;
        int k = ini;

        while (i <= meio && j <= fim){
            if (c[i] <= c[j]){
                v[k++] = c[i++];
            }else{
                v[k++] = c[j++];
            }

        }

        while (i <= meio){
            v[k++] = c[i++];
            
        }
    }

}
