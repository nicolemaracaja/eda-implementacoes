import java.util.NoSuchElementException;

public class ArrayList {

    private int[] array;
    private int size;

    public ArrayList(int capacidadeInicial) {
        this.array = new int[capacidadeInicial];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(int valor) {
        assegureCapacidade(size + 1);
        shiftRight(0, size);
        array[0] = valor;
        size++;
    }

    public void addLast(int valor) {
        assegureCapacidade(size + 1);
        array[size++] = valor;
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Índice fora dos limites!");
        }

        assegureCapacidade(size + 1);
        shiftRight(index, size);
        array[index] = valor;
        size++;
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
        int[] novoArray = new int[novaCapacidade];
        for (int i = 0; i < size; i++){
            novoArray[i] = array[i];
        }
        array = novoArray;
    }

    public void assegureCapacidade(int capacidadePretendida) {
        if (capacidadePretendida > array.length){
            resize(capacidadePretendida);
        }
    }

    public int getFirst() {
        if (isEmpty()){
            throw new NoSuchElementException("Lista vazia!");
        }
        return array[0];
    }

    public int getLast() {
        if (isEmpty()){
            throw new NoSuchElementException("Lista vazia!");
        }
        return array[size - 1];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Índice fora dos limites.");
        }

        return array[index];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()){
            throw new NoSuchElementException("Lista vazia!");
        }
        int valor = array[0];
        shiftLeft(0, size - 1);
        size--;
        return valor;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
        if (isEmpty()){
            throw new NoSuchElementException("Lista vazia!");
        }
        size--;
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Índice fora dos limites!");
        }
        shiftLeft(index, size - 1);
        size--;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        int index = indexOf(value);
        if (index != -1){
            remove(index);
        }
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        int index = -1;
        for (int i = 0; i < size; i++){
            if (array[i] == value){
                index = i;
                break;
            }
        }
        return index;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        int ultimaOcorrencia = -1;
        for (int i = 0; i < size; i++){
            if (array[i] == valor){
                ultimaOcorrencia = i;
            }
        }
        return ultimaOcorrencia;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        String saida = "";
        
        for (int i = 0; i < size; i++){
            if (saida.equals("")) {
                saida += array[i];
            }else{
                saida += ", " + array[i];
            }
        }

        return saida;
    }
    
    public int size() {
        return this.size;
    }

    //metodo para mover os elementos a direita
    private void shiftRight(int start, int end){
        for (int i = end; i > start; i--){
            array[i] = array[i-1];
        }
    }

    //metodo para mover os elementos a esquerda
    private void shiftLeft(int start, int end){
        for (int i = start; i < end; i++){
            array[i] = array[i+1];
        }
    }
}

//ta dando erro em lastIndexOf, toString e isEmpty
