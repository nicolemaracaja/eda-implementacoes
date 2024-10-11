public class FIFOEvictionStrategy {

    private FIFOCache fifoCache;

    // deve ter uma FIFOCache como atributo
    public FIFOEvictionStrategy(int capacidade) {
        this.fifoCache = new FIFOCache(capacidade);
    }
    
    /*
    * retorna "hit" se estiver no cache.
    * retorna "miss" se não estiver no cache e adiciona no mesmo.
    * Note que essa é uma simplificação. Idealmente, esse método retornaria o
    * objeto com a chave passada como parâmetro.
    **/
    public String get(String chave) {
        if (fifoCache.contains(chave)){
            return "hit"; //a chave está no cache
        }else{
            if (fifoCache.isFull()){
                fifoCache.removeFirst();
            }
            fifoCache.addLast(chave);
            return "miss"; //a chave não estava no cache
        }
    }

    /*
    * retorna o próximo que deve sair do cache caso entre mais alguém e ele esteja cheio.
    * se não for sair ninguém, ou seja, se ainda não estiver cheio, retorna null.
    **/
    public String getNextEviction() {
        if (!fifoCache.isFull()){
            return null;
        }
        return fifoCache.getFirst();
    }   

    public int size(){
        return fifoCache.size();
    }

}
