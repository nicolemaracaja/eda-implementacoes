public class LRUEvictionStrategy {

    private LRUCache cache;

    // deve ter uma linkedlist como atributo
    public LRUEvictionStrategy(int capacidade) {
        this.cache = new LRUCache(capacidade);
    }

    /*
    * retorna "hit" se estiver no cache.
    * retorna "miss" se não estiver no cache e adiciona no mesmo.
    * Note que essa é uma simplificação. Idealmente, esse método retornaria o
    * objeto com a chave passada como parâmetro.
    **/
    public String get(String chave) {
        String resultado = cache.get(chave);
        if (resultado != null){
            return "hit";
        } else {
            cache.addLast(chave);
            return "miss";
        }
    }

    /*
    * retorna o próximo que deve sair do cache caso entre mais alguém e ele esteja cheio.
    * se não for sair ninguém, ou seja, se ainda não estiver cheio, retorna null.
    * esse método não altera o estado da fila.
    **/
    public String getNextEviction() {
        if (cache.isFull()){
            return cache.getFirst();
        } else {
            return null;
        }
    }    

    //retorna a quantidade de elementos no cache.
    public int size() {
        return cache.size();
    }

}
