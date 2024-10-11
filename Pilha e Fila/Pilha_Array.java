import java.util.NoSuchElementException;
import javax.management.RuntimeErrorException;

public class Pilha {

    private int topo;
    private int[] pilha;

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1; //começa como uma posição inexistente na pilha
    }

    public boolean isEmpty() {
        return this.topo == -1; //se o topo não tiver sido atualizado, a pilha está vazia
    }

    public boolean isFull() {
        return this.topo + 1 == this.pilha.length; //verifica se o topo está no limite do array
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if (isFull()){
            throw new RuntimeException("Pilha Cheia!");
        } 
        this.pilha[++this.topo] = valor; //incrementa o topo primeiro e depois atualiza o valor
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if (isEmpty()){
            throw new NoSuchElementException("Pilha está vazia!");
        }
        return this.pilha[this.topo--]; //decrementa o topo
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pilha está vazia!");
        }
        return this.pilha[this.topo];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        Pilha pilhaAux = new Pilha(this.topo + 1);
        String saida = "";

        while (!this.isEmpty()){
            int valor = this.pop();

            pilhaAux.push(valor);

            if (saida.equals("")){
                saida += valor;
            }else{
                saida += ", " + valor;
            }
         
        }

        while (!pilhaAux.isEmpty()){
            this.push(pilhaAux.pop());
        }

        return saida;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. Note que
    // o topo sempre está na primeira posição (0), abaixo do topo é a posição 1 etc. Não confunda
    // com os índices do array. Interprete os testes para a especificação mais detalhada.
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        Pilha pilhaAux = new Pilha(this.topo + 1);
        int pos = 0;

        while (!this.isEmpty()){
            int valorAtual = this.pop();
            if (valorAtual == valor){
                while (!pilhaAux.isEmpty()) {
                    this.push(pilhaAux.pop());          
                }
                this.push((valorAtual));
                return pos;
            }
            pilhaAux.push(valorAtual);
            pos++;
        }

        while(!pilhaAux.isEmpty()){
            this.push(pilhaAux.pop());
        }
        
        return -1;
    }

    public int size() {
        return this.topo + 1;
    }

}
