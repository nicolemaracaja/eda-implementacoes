import java.util.ArrayList;

public class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }

    
    /**
     * Implementação recursiva da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void addRecursivo(int element){
        if (isEmpty()){
            this.root = new Node(element);
        } else {
            addRecursivo(this.root, element);
        }
    }

    private void addRecursivo(Node current, int element){
        if (element < current.value){
            if (current.left == null){
                Node newNode = new Node(element);
                current.left = newNode;
                newNode.parent = current;
                return;
            } else {
                addRecursivo(current.left, element);
            }
        }else {
            if (current.right == null){
                Node newNode = new Node(element);
                current.right = newNode;
                newNode.parent = current;
                return;
            } else {
                addRecursivo(current.right, element);
            }
        }
    }
    
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        if (isEmpty()){
            return null;
        } else {
            Node aux = this.root;

            while (aux != null){
                if (element == aux.value){
                    return aux;
                } else if (element < aux.value){
                    aux = aux.left;
                } else if (element > aux.value){
                    aux = aux.right;
                }
            }
        }
        return null;
    }

    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * recursiva clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node searchRecursivo(int element){
        if (isEmpty()){
            return null;
        } else {
            return searchRecursivo(this.root, element);
        }
    }

    private Node searchRecursivo(Node current, int element){
        if (current == null){
            return null;
        }
        if (current.value == element){
            return current;
        }
        if (element < current.value){
            return searchRecursivo(current.left, element);
        } else {
            return searchRecursivo(current.right, element);
        }
    }
    
      
    /**
     * Retorna a altura da árvore, de forma recursiva.
     */
    public int height() {
        return height(this.root);
    }

    private int height(Node node){
        if (node == null){
            return -1;
        } else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    /**
     * Indica se uma BST é igual a outra
     */
    public boolean equals(BST outra) {
        if (this.size != outra.size){
            return false;
        }
        return equals(this.root, outra.root);
    }

    private boolean equals(Node n1, Node n2){
        
        if (n1 == null && n2 == null){
            return true;
        } 
        if (n1 == null || n2 == null){
            return false;
        }

        return (n1.value == n2.value) && equals(n1.left, n2.left) && equals(n1.right, n2.right);
    }

    /**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        return contaFolhas(this.root);
    }

    private int contaFolhas(Node node){
        if (node == null){
            return 0;
        } else if (node.left == null && node.right == null){
            return 1;
        } else {
            return contaFolhas(node.left) + contaFolhas(node.right);
        }
    }

    /**
     * Retorna o valor mínimo da árvore, de forma recursiva.
     */
    public Node min(){
        if (isEmpty()){
            return null;
        }
        return min(this.root);
    }

    private Node min(Node node){
        if (node.left == null){
            return node;
        } else {
            return min(node.left);
        }
    }

    /**
     * Retorna o valor máximo da árvore, de forma recursiva.
     */
    public Node max(){
        if (isEmpty()){
            return null;
        }
        return max(this.root);
    }

    private Node max(Node node){
        if (node.right == null){
            return node;
        } else {
            return max(node.right);
        }
    }

    public Node maxIterativo(){
        Node aux = this.root;
        if (aux == null){
            return null;
        }
        while (aux.right != null){
            aux = aux.right;
        }
        return aux;
    }

    public Node minIterativo(){
        Node aux = this.root;
        if (aux == null){
            return null;
        }
        while (aux.left != null){
            aux = aux.left;
        }
        return aux;
    }

    /**
     * Retorna o predecessor do nó passado como parâmetro
     */
    public Node predecessor(int k){
        Node node = search(k);

        //árvore vazia retorna null
        if (node == null){
            return null;
        }

        if (node.left != null){
            return max(node.left);
        } else {
            Node aux = node.parent;
            while (aux != null && aux.value > node.value){
                aux = aux.parent;
            }
            return aux;
        }
    }

    /**
     * Retorna o sucessor do nó passado como parâmetro
     */
    public Node sucessor(int k){

        if (isEmpty()){
            return null;
        }
        
        Node node = search(k);

        //árvore vazia retorna null
        if (node == null){
            return null;
        }

        if (node.right != null){
            return min(node.right);
        } else {
            Node aux = node.parent;
            while (aux != null & aux.value < node.value){
                aux = aux.parent;
            }
            return aux;
        }
    }

    public void remove(int k){
        Node toRemove = search(k);
        if (toRemove == null){
            return;
        }

        //Caso quando o nó é uma folha
        if (toRemove.isLeaf()){
            if (toRemove == this.root){
                this.root = null; //se for a raiz, a árvore se torna vazia
            } else {
                if (toRemove.value < toRemove.parent.value){
                    toRemove.parent.left = null;
                } else {
                    toRemove.parent.right = null;
                }
            }

        //O nó tem apenas um filho à esquerda
        } else if (toRemove.hasOnlyLeftChild()){
            if (toRemove == this.root){
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value){
                    toRemove.parent.left = toRemove.left;
                } else {
                    toRemove.parent.right = toRemove.left;
                }
            }

        //O nó tem apenas um filho à direita
        } else if (toRemove.hasOnlyRightChild()){
            if (toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
            } else {
                toRemove.right.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value) {
                    toRemove.parent.left = toRemove.right;
                } else {
                    toRemove.parent.right = toRemove.right;
                }
            }

        //o nó tem dois filhos
        } else {
            Node sucessor = min(toRemove.right); // Encontra o sucessor
            toRemove.value = sucessor.value; // Substitui o valor do nó a ser removido pelo sucessor
            remove(sucessor.value); // Remove o sucessor recursivamente (que terá no máximo um filho)
        }
        
        this.size--;
    }
    
    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }

    public void preOrder(){
        preOrder(this.root);
    }

    /**
     * Nó, esquerda, direita
     * @param current
     */
    private void preOrder(Node current){
        if (current != null){
            System.out.println(current.value + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    public void inOrder(){
        inOrder(this.root);
    }

    /**
     * Esquerda, nó, direita
     * @param current
     */
    private void inOrder(Node current){
        if (current != null){
            preOrder(current.left);
            System.out.println(current.value + " ");
            preOrder(current.right);
        }
    }

    public void posOrder(){
        posOrder(this.root);
    }

    /**
     * Esquerda, direita, nó
     * @param current
     */
    private void posOrder(Node current){
        if (current != null){
            preOrder(current.left);
            preOrder(current.right);
            System.out.println(current.value + " ");
        }
    }

    
}


class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }

    //verifica se o nó tem apenas um filho à esquerda
    public boolean hasOnlyLeftChild(){
        return this.left != null && this.right == null;
    }

    //verifica se o nó tem apenas um filho à direita
    public boolean hasOnlyRightChild(){
        return this.right != null && this.left == null;
    }

    //verifica se o nó é uma folha (não tem filhos)
    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }
    
}
