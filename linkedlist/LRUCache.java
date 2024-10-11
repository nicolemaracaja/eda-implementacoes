public class LRUCache {

    private LinkedList linkedList;
    private int capacidade;

    // o tamanho da sua linkedlist não pode passar de `capacidade`.
    public LRUCache(int capacidade) {
        this.capacidade = capacidade;
        this.linkedList = new LinkedList();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public boolean isFull() {
        return linkedList.size() == capacidade;
    }

    // deve ser O(1)
    public void addLast(String chave) {
        if (isFull()){
            linkedList.removeFirst();
        }
        linkedList.addLast(chave);
    }

    // deve ser O(n)
    // retorna o próprio valor se encontrar ou null.
    // Encontrando ou não, o elemento deve ser movido para o final da lista
    public String get(String value) {
        int index = linkedList.indexOf(value);
        if (index != -1){
            String val = linkedList.get(index);
            linkedList.remove(index);
            linkedList.addLast(val);
            return val;
        }
        return null;
    }

    // O(1)
    public String getFirst() {
        return linkedList.getFirst();
    }

    // O(1)
    public String getLast() {
        return linkedList.getLast();
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        return linkedList.toString();
    }
    
    public int size() {
        return linkedList.size();
    }
}
