import java.util.NoSuchElementException;

public class Fila {

    private int[] fila;
    private int head;
    private int tail;
    private int size;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.head = -1; //head e tail delimitam o tamanho do array
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.fila.length;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if (isFull()){
            throw new RuntimeException("Fila Cheia!");
        }
        tail = (tail + 1) % fila.length;
        fila[tail] = valor;
        size++;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()){
            throw new NoSuchElementException("Fila Vazia!");
        }
        int valor = fila[head];
        head = (head + 1) % fila.length;
        size--;
        return valor;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        if (isEmpty()){
            throw new NoSuchElementException("Fila Vazia!");
        }
        return fila[head]; //primeiro elemento da fila
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
        if (isEmpty()){
            throw new NoSuchElementException("Fila Vazia!");
        }
        return fila[tail]; //último elemento da fila
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        StringBuffer sb = new StringBuffer();

        if (isEmpty()){
            return sb.toString(); //string vazia 
        }

        int i = head;

        for (int j = 0; j < size; j++){
            if (j > 0) sb.append(", ");
            sb.append(fila[i]);
            i = (i + 1) % fila.length;
        }
        
        return sb.toString();
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
        int i = head;
        for (int j = 0; j < size; j++){
            if (fila[i] == valor){
                return j;
            }
            i = (i + 1) % fila.length;
        }
        return -1;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        int i = (head + size - 1) % fila.length;

        for (int j = size - 1; j >= 0; j--){
            if (fila[i] == valor){
                return j;
            }
            i = (i - 1 + fila.length) % fila.length;
        }
        return -1;
    }
    
    public int size() {
        return this.size;
    }

}
