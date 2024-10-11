import java.util.NoSuchElementException;

public class FIFOCache {

    private String[] cache;
    private int head;
    private int tail;
    private int size;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public FIFOCache(int capacidade) {
        this.cache = new String[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cache.length;
    }

    // deve sobrescerver o mais antigo caso a fila esteja cheia.
    public void addLast(String chave) {
        if (isFull()){
            removeFirst();
        }

        if (isEmpty()){
            head = 0;
            tail = 0;
        } else{
            tail = (tail + 1) % cache.length;
        }
        
        cache[tail] = chave;
        size++;

    }

    // deve lançar exceção caso a fila esteja vazia.
    public String removeFirst() {
        if (isEmpty()){
            throw new NoSuchElementException("Fila Vazia!");
        }
        
        String chave = cache[head];

        if (this.head == this.tail){
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % cache.length;
        }

        size--;
        return chave;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public String getFirst() {
        if (isEmpty()){
            throw new NoSuchElementException("Fila Vazia!");
        }
        return cache[head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public String getLast() {
        if (isEmpty()){
            throw new NoSuchElementException("Fila Vazia!");
        }
        return cache[tail];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        if (this.isEmpty()){
            return "";
        }

        FIFOCache fifoAux = new FIFOCache(this.size);
        String saida = "";

        while (!this.isEmpty()){
            String elementoRemovido = removeFirst();
            fifoAux.addLast(elementoRemovido);

            if (saida.equals("")){
                saida += elementoRemovido;
            }else{
                saida += ", " + elementoRemovido;
            }
        }

        while (!fifoAux.isEmpty()){
            this.addLast(fifoAux.removeFirst());
        }

        return saida;
    }
    
    public int size() {
        return this.size;
    }

    //retorna a quantidade de elementos no cache
    public boolean contains(String chave){
        FIFOCache cacheAux = new FIFOCache(this.size);
        boolean achou = false;

        while (!this.isEmpty()){
            String elementoRemovido = removeFirst();
            cacheAux.addLast(elementoRemovido);

            if (elementoRemovido.equals(chave)){
                achou = true;
            }
        }

        while (!cacheAux.isEmpty()){
            this.addLast(cacheAux.removeFirst());
        }

        return achou;
    }
}
