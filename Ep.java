
package ep1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Ep{

    public static void main(String[] args) throws IOException{
      
    int x = 1;
    Scanner in = new Scanner(System.in);
    PilhaSaida pilhaResultado = null;
    Controle tipoEscolhido = null;
    
    
    String metodoEscolhido = " ";
    String path = " ";
     
    while(x>0){   
        System.out.printf("Para fazer um novo teste pressione qualquer tecla e aperte enter! Para sair da execução aperte 'S' e pressione enter.\n");
        switch(in.nextLine()){
            case "S":
            System.exit(0);    
            break;    
            default: 
                String nomeDoArquivo = arquivoNome();
                
                path = "Saida" + "_" + nomeDoArquivo ;
        
            pilhaResultado = new PilhaSaida();


            try{
                FileReader arquivo = new FileReader(nomeDoArquivo);
                BufferedReader leArquivo = new BufferedReader(arquivo);


                String entrada = leArquivo.readLine();
                metodoEscolhido = escolha();

                tipoEscolhido = criacaoObjeto(metodoEscolhido);
                        
                while (entrada != null){
                    

                    if(!entrada.isEmpty()){
                        int linha = Integer.parseInt(entrada);

                        tipoEscolhido.add(linha);
                    }else{

                        int processado = tipoEscolhido.remove();
                        pilhaResultado.push(processado);

                    }

                    entrada = leArquivo.readLine();

                }

                arquivo.close();

                //pilhaResultado.imprimePilha();

            }

            catch (IOException e){
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                e.getMessage());
            }
       }
           // break; 
         
         BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        
        

     
        System.out.println("Tempo gasto na operação para a escolha: " + (System.currentTimeMillis() - tipoEscolhido.getTempo()));
       
        
        //buffWrite.append( "Tempo gasto na operação para a escolha: " + (System.currentTimeMillis() - tipoEscolhido.getTempo()) + "\n\n");
        
        for(int p=0;p<pilhaResultado.topoDaPilha;p++){
            int entrada;
            entrada = pilhaResultado.saida[p];
            buffWrite.append(entrada + "\n");  
        }   
        buffWrite.close();    
        }
              
    }
    
       
    static String arquivoNome(){
        Scanner in = new Scanner(System.in);
        System.out.printf("Digite o nome do arquivo e em seguida aperte enter: ");
    
        String nomeDoArquivo = in.nextLine();
        return nomeDoArquivo;
    }
    
    
    
     static String escolha(){
        Scanner in = new Scanner(System.in);
        System.out.printf("Digite a letra correspondente ao método escolhido para realização do processamento e pressione enter: \n"
        + "Pilha Ingenua = A\n" + "Pilha Arranjo = B\n" + "Lista Ligada = C\n");
        
        String escolhido = in.nextLine();
        return escolhido;
    }

     static Controle criacaoObjeto(String escolhido){
         
         Controle tipoEscolhido = null;

        switch (escolhido) {
            case "A":
                tipoEscolhido = new PilhaIngenua();
                break;
            case "B":
                tipoEscolhido = new PilhaArranjo();
                break;
            case "C":
                tipoEscolhido = new ListaLigada();
                break;
            default:
                break;
        }
         
        return tipoEscolhido;
     
     }
     
     
}
