package sorting;

public class RadixSort {

	//ordena com base no digito
    private void countingSortPorDigito(int[] array, int posicaoDigito) {
        int tamanhoArray = array.length;
        int[] arraySaida = new int[tamanhoArray];
        int[] arrayContagem = new int[10]; 

        //inicia o array de contagem
        for (int i = 0; i < 10; i++) {
            arrayContagem[i] = 0;
        }

        //frequencia
        for (int i = 0; i < tamanhoArray; i++) {
            int digito = (array[i] / posicaoDigito) % 10;
            arrayContagem[digito]++;
        }

        //pos final dos elementos
        for (int i = 1; i < 10; i++) {
            arrayContagem[i] += arrayContagem[i - 1];
        }

        //saida
        for (int i = tamanhoArray - 1; i >= 0; i--) {
            int digito = (array[i] / posicaoDigito) % 10;
            arraySaida[arrayContagem[digito] - 1] = array[i];
            arrayContagem[digito]--;
        }

        //copia os elementos para o array original
        for (int i = 0; i < tamanhoArray; i++) {
            array[i] = arraySaida[i];
        }
    }

	// Você pode assumir que todos os valores possuem a mesma quantidade de dígitos
	// Caso precise do counting sort, use o que você já implementou na outra classe.
	public int[] radixSort(int[] v) {

        int valorMaximo = getMaximo(v);

        for (int posicaoDigito = 1; valorMaximo / posicaoDigito > 0; posicaoDigito *= 10) {
            countingSortPorDigito(v, posicaoDigito);
        }

        return v;
	}

    private int getMaximo(int[] v){
        int valorMaximo = v[0];
        for (int i = 1; i < v.length; i++) {
            if (v[i] > valorMaximo) {
                valorMaximo = v[i];
            }
        }
        return valorMaximo;
    }

}
