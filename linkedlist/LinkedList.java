import java.util.NoSuchElementException;

public class LinkedList {

    private Node head; //inicio da lista
    private Node tail; //final da lista
    private int size; //tamanho
    
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
   
    public boolean isEmpty() {
        return this.head == null; //significa que o inicio da lista não foi atualizado
    }

    public void addFirst(int valor) {
        Node newNode = new Node (valor);

        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else{
            newNode.next = this.head; //newNode é acrescentado antes do inicio da lista
            this.head.prev = newNode; //o head atual aponta para o newNode, que estara anterior a ele
            this.head = newNode; //aualiza o head
        }

        this.size++;
    }

    public void addLast(int valor) {
        Node newNode = new Node(valor);

        if (isEmpty()){ //se a lista tiver vazia, head e tail apontam pra o newNode
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode; //acrescenta ao final da lista
            newNode.prev = tail; //aponta o elem adicionado para o final da lista
            this.tail = newNode; //atualiza o final da lista
        }

        this.size++;
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {

        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index fora dos limites!");
        }

        if (index == 0){
            this.addFirst(valor);
        }
        else if (index == size){
            this.addLast(valor);
        }
        else{
            Node newNode = new Node(valor);
            Node aux = this.head;

            for (int i = 0; i < index - 1; i++){
                aux = aux.next; //atualiza para o proximo
            } //ao final desse for, aux estará apontado para o nó anterior do novo nó

            newNode.next = aux.next; //o next do novo nó aponta para o next do aux
            aux.next = newNode; //o proximo de aux será o newNome
            newNode.next.prev = newNode; 
            newNode.prev = aux; //o anterior do newNode será o aux

            size++;
        }
    }

    public int getFirst() {
        if (isEmpty()){
            throw new RuntimeException("Lista Vazia!");
        }

        return this.head.value;
    }

    public int getLast() {
        if (isEmpty()){
            throw new RuntimeException("Lista Vazia!");
        }

        return this.tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {

        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index fora dos limites!");
        }

        Node aux = this.head;

        for (int i = 0; i < index; i++){
            aux = aux.next;
        }

        return aux.value; //pega o valor do valor no indice desejado
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()){
            throw new RuntimeException("Lista Vazia!");
        }

        int value = this.head.value; //primeiro elemento

        if (this.head.next == null){ //se houver apenas um elemento, remove ele
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.next; //atualiza o head para o prox elemento
            this.head.prev = null; //remove o primeiro elemento
        }

        size--;
        return value; //retorna o valor removido
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        if (isEmpty()){
            throw new RuntimeException("Lista Vazia!");
        }

        int value = this.tail.value; //último elemento

        if (this.head.next == null){ //se houver apenas um elemento, remove ele
            this.head = null;
            this.tail = null;
        }else{
            this.tail = this.tail.prev; //atualiza o tail para o elemento anterior
            this.tail.next = null; //remove o último elemento
        }

        size--;
        return value;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index fora dos limites!");
        }

        if (index == 0){
            this.removeFirst();
        }
        else if (index == size - 1){
            this.removeLast();
        }
        else{
            Node aux = this.head;
            for (int i = 0; i < index; i++){
                aux = aux.next; //ponteiro para o nó que será percorrido
            }
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            size--;
            return aux.value;
        }

        return -1;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        Node aux = this.head;
        for (int i = 0; i < this.size; i++){
            if (aux.value == value){
                if (i == 0){
                    removeFirst();
                }else if(i == size - 1){
                    removeLast();
                }else{
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    size--;
                }
                return true;
            }
            aux = aux.next;
        }

        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        Node aux = this.head;
        int index = 0;

        while (aux != null){
            if (aux.value == value){ //se o valor do aux for o mesmo do solicitado, retorna o indice
                return index;
            }
            aux = aux.next; //enquanto não for, atualiza o aux
            index++; //incrementa o índice
        }

        return -1;
    }

    public boolean contain(int v) {
        if (indexOf(v) != -1){
            return true;
        }
        return false;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Node aux = this.head;
        int index = 0;
        int ultimoIndex = -1;

        while (aux != null){
            if (aux.value == valor){
                ultimoIndex = index;
            }
            aux = aux.next;
            index++;
        }
        
        return ultimoIndex;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }
    
    public int size() {
        return this.size;
    }

    // Esse método move o elemento que está em index para a cabeça da fila.
    //Ele é O(n) para procurar o elemento, mas para mover, você deve fazer em O(1), ou seja, apenas manipulando referências.
    public void moveToHead(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index fora dos limites!");
        }

        Node aux = this.head;
        for (int i = 0; i < index; i++){
            aux = aux.next;
        }

        if (aux == this.tail){
            this.tail = aux.prev;
            this.tail.next = null;
        }else{
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
        }

        aux.next = this.head;
        this.head.prev = aux;
        aux.prev = null;
        this.head = aux;
    }

    //Dada uma lista já em ordem crescente, insere o valor passado como parâmetro 
    //no seu devido lugar para que a lista continue ordenada após a sua inserção.
    public void insereOrdenado(int v){
        if (isEmpty() || this.head.value >= v){ //se a lista for vazia ou o head for um valor maior que v
            addFirst(v);
            return;
        }

        if (this.tail.value <= v){
            addLast(v);
            return;
        }

        Node aux = this.head;
        while (aux.next != null && aux.next.value < v){
            aux = aux.next;
        }

        Node newNode = new Node(v);
        newNode.next = aux.next;
        newNode.prev = aux;
        aux.next.prev = newNode;
        aux.next = newNode;

        size++;     
    }

    //Troca n1 e n2. Não é permitido trocar os valores. 
    //Você tem que manipular as referências. 
    //Esse algoritmo deve ser O(1), pois já recebe os nós a serem trocados.
    public void swap(Node n1, Node n2){
        if (n1 == n2){
            return;
        }

        Node prev1 = n1.prev;
        Node next1 = n1.next;
        Node prev2 = n2.prev;
        Node next2 = n2.next;

        if (next1 == n2){ //n1 e n2 são adjacentes, com n1 antes de n2
            n1.next = next2;
            n1.prev = n2;
            n2.next = n1;
            n2.prev = prev1;
        } else if (next2 == n1){ //n1 e n2 são adjacentes, com n2 antes de n1
            n2.next = next1;
            n2.prev = n1;
            n1.prev = n2;
            n1.prev = prev2;
        } else{
            n1.next = next2;
            n1.prev = prev2;
            n2.next = next1;
            n2.prev = prev1;

            if (next1 != null){
                next1.prev = n2;
            }
            if (prev1 != null){
                next1.next = n2;
            }
            if (next2 != null){
                next2.prev = n1;
            }
            if (prev2 != null){
                next2.next = n1;
            }
        }

        if (n1 == this.head){
            this.head = n2;
        } else if (n2 == this.head){
            this.head = n1;
        }

        if (n1 == this.tail){
            this.tail = n2;
        }else if(n2 == this.tail){
            this.tail = n1;
        }
    }

    //Esse método deve inverter uma lista. Isto é, tail passa a ser head,
    //o elemento anterior a tail passa a ser o segundo da lista e assim por diante, 
    //até chegar em head, que será o último elemento da lista (tail). Não é permitido utilizar estrutura auxiliar.
    public void inverte(){
        Node atual = this.head;
        Node prev = null;
        Node next = null;

        while (atual != null){
            next = atual.next;
            atual.next = prev;
            atual.prev = next;
            prev = atual;
            atual = next;
        }

        Node temporario = this.head;
        this.head = this.tail;
        this.tail = temporario;
    }

}

class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
    }

}
