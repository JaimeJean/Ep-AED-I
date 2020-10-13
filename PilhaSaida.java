
package ep1;

public class PilhaSaida extends Ep{
    int []saida = new int [999999];
    int topoDaPilha = 0;
    
   
    void push(int chave){
       saida[topoDaPilha()] = chave;
       topoDaPilha++;
    }
    
    int topoDaPilha(){
    return topoDaPilha;
    }
    
    void imprimePilha(){
    for(int i=0;i<topoDaPilha();i++){
        System.out.println(saida[i]);
    }
    }
}
