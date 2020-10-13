
package ep1;

public class PilhaArranjo implements Controle{
        
    int topoDaPilha;
    boolean verificacao = false;
    protected final int MAX = 1000000;
    protected Integer[]  pilha;
    long cronometro;    
   
    //int entrada = Integer.parseInt(in.nextLine());
    
    
    PilhaArranjo(){ 
        
        cronometro = System.currentTimeMillis();
        pilha = new Integer [MAX]; 
        //System.out.println("Criou uma arranjo!");
    }

    @Override
    public void add(int newElement){ 
        
        atualizaTopo();
        pilha[topoDaPilha()] = newElement;
    }
    
    @Override
    public int remove(){
    int tmp = pilha[topoDaPilha()];
    pilha[topoDaPilha()] = null;
    topoDaPilha--;
    //System.out.println("Entrou no Arranjo!");
    return tmp;
    }
    
    Integer topoDaPilha(){
    return topoDaPilha;
    }
      
    void atualizaTopo(){
        if(!verificacao){
        topoDaPilha = 0;
        verificacao = true;
        }else{
        topoDaPilha = topoDaPilha + 1;
        }
        
    }
    @Override
     public long getTempo(){
        return this.cronometro;
    }
   
}
