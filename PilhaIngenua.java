package ep_1_aed_1;

public class PilhaIngenua implements Controle{
    
    
    protected final int MAX = 1000000;
    protected Integer[]  pilha;
    long cronometro;
   
    PilhaIngenua(){ 
        cronometro = System.currentTimeMillis();
        pilha = new Integer [MAX];  
        //System.out.println("Criou uma ingenua!");
    }

   
    @Override
    public void add(int newElement){
        int i;
        for(i=0; pilha[i] != null; i++);
            pilha[i] = newElement;       
    }
    
    @Override
    public int remove (){
    int i;
    for(i=0;pilha[i] != null; i++);
    int tmp = pilha[i-1];
    pilha[i-1] = null;
    
    return tmp;
    }
    
    @Override
    public long getTempo(){
        return this.cronometro;
    }
  
    
 }


