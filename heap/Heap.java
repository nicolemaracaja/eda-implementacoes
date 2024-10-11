import java.util.Arrays;

public class Heap {
    
    private int[] heap;
    private int tail;
    
    public Heap(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }
    
    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int left(int i) {
        return (2 * i) + 1;                                  
    }

    public int right(int i) {
        return (2 * i) + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public void add(int n) {
    	if (tail >= (heap.length) - 1){
            resize();
        }

        this.tail++;
        this.heap[tail] = n; //acrescenta o elemento novo na última posição

        int i = tail;
        while (i > 0 && this.heap[parent(i)] < this.heap[i]){
            swap(i, parent(i));
            i = parent(i);
        }

    }

    private void buildHeap() {
        for (int i = parent(this.tail); i >= 0; i--){
            heapify(i);
        }
    }
    
    public int remove() {
        if (isEmpty()) throw new RuntimeException("Empty"); //se tiver vazia, não tem o que remover
        int element = this.heap[0]; //elemento removido é a raiz (sempre o maior)
        this.heap[0] = this.heap[tail]; //a raiz assume o valor do tail
        this.tail -= 1; //tail é atualizado, pois um elemento foi removido

        this.heapify(0); //chama o heapify recursivamente 
        
        return element;
    }
        
    private void heapify(int index) { //pega o máximo entre os três valores e vai trocando
        if (isLeaf(index) || !isValidIndex(index)) 
            return;
        
        // compares index, left and right to find max 
        int index_max = max_index(index, left(index), right(index));
        
        // if current index is not greater than its children, 
        // swap and keep heapifying.
        if (index_max != index) {
                swap(index, index_max);
                heapify(index_max);
        }
    } 
    
    private int max_index(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)) {
                if (this.heap[index] < this.heap[right])
                    return right;
            }
            return index;
        
        } else {
            if (isValidIndex(right)) {
                if (this.heap[left] < this.heap[right])
                    return right;
            } 
            
            return left;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }
    
    //verifica se é uma folha
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail; 
    } 
    
    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private void resize() { //cria um novo array maior que o anterior
        int[] novoHeap = new int[this.heap.length * 2];
        for (int i = 0; i <= tail; i++)
            novoHeap[i] = this.heap[i];
        
        this.heap = novoHeap;
    }
    
    public int size() {
        return this.tail + 1;
    }
    
    public String toString() {
        return Arrays.toString(this.heap);
    }

}
