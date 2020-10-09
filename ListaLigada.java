
package ep_1_aed_1;

public class ListaLigada implements Controle{
    Node cabeca, cauda;
    long chave;
    long tamanhoDaLista;
    long cronometro;
    
    ListaLigada(){
        cabeca = cauda = null;
        tamanhoDaLista = 0;
        cronometro = System.currentTimeMillis();
    }

    @Override 
    public void add(int newElement) {
        Node no = new Node(newElement,cabeca);
        
        adicionaNoInicio(no);
        
        
    }

    @Override
    public int remove() {
       return remover();    
    }
    
    public void adicionaNoInicio(Node n){
    n.setNext(cabeca);
    cabeca = n;
    if(tamanhoDaLista == 0){ 
        cauda = n; 
    }
    tamanhoDaLista++;
  }
    
    public void adicionaNoFinal(Node n){
    n.setNext(null);
    cauda.setNext(n);
    cauda = n;
    if(tamanhoDaLista == 0){
        cabeca = n; 
    }
    tamanhoDaLista++;
  }
    
   public int remover() throws IllegalStateException{
    if(tamanhoDaLista == 0){ 
        throw new IllegalStateException("Lista vazia"); 
    }
    Node tmp = cabeca;
    cabeca = cabeca.getNext();
    tmp.setNext(null);
    tamanhoDaLista--;
    if(tamanhoDaLista == 0){ 
        cauda = null; 
    }
    return tmp.getElement();
  } 
    
    @Override
    public long getTempo(){
        return this.cronometro;
    }
    
    public long tamanho(){
        return tamanhoDaLista;
    }
}
