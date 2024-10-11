import java.util.*;

public class CountingSort {
   
    /**
    * Implemente a versão clássica do counting sort que vimos em sala de aula. Você pode
    * criar métodos auxiliares se precisar.
    */
    public int[] classicCountingSort(int[] a, int k) {

        int[] c = new int[k];
        
        //frequencia
        for (int i = 0; i < a.length; i++){
            c[a[i]-1] += 1;
        }

        //cumulativa
        for (int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }

        int[] b = new int[a.length]; //saida ordenada

        //ordenando
        for (int i = a.length -1; i >= 0; i--){ //percorre de tras pra frente
            b[c[a[i]-1]-1] = a[i];
            c[a[i]-1] -= 1;
        }

        return b;
    }

    /**
    * Implemente uma versão do counting sort que aceita valor 0 na coleção original.
    */
    public int[] zeroCountingSort(int[] v, int k) {
        int[] c = new int[k+1];
        
        //frequencia
        for (int i = 0; i < v.length; i++){
            c[v[i]] += 1;
        }

        //cumulativa
        for (int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }

        int[] b = new int[v.length]; //saida ordenada

        //ordenando
        for (int i = v.length - 1; i >= 0; i--){ //percorre de tras pra frente
            b[c[v[i]]-1] = v[i];
            c[v[i]] -= 1;
        }

        return b;
    }

    /**
    * Implemente uma versão do counting sort que aceita valores negativos na coleção original. Você
    * vai precisar identificar o menor elemento do array. FAça isso no início do método.
    */
    public int[] negativosCountingSort(int[] v, int k) {

        int maior = k;
        int menor = pegaMenor(v);

        int[] c = new int[maior - menor + 1];
        
        //frequencia
        for (int i = 0; i < v.length; i++){
            c[v[i] + Math.abs(menor)] += 1;
        }

        //cumulativa
        for (int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }

        int[] b = new int[v.length]; //saida ordenada

        //ordenando
        for (int i = v.length -1; i >= 0; i--){ //percorre de tras pra frente
            b[c[v[i] + Math.abs(menor)]-1] = v[i];
            c[v[i] + Math.abs(menor)] -= 1;
        }

        return b;
    }

    public int pegaMenor(int[]v){
        int menor = v[0];

        for (int i = 0; i < v.length; i++){
            if (v[i] < menor){
                menor = v[i];
            }
        }
        return menor;
    }

}
