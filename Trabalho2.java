
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
public class Trabalho2 {
    static class Conta {
        String titular;
        int numConta;
        float saldo;
        String extrato;
    }
    static int tam = 0;
    static Conta vetorContas[] = new Conta[10];
    public static void criaConta(String nome, int num) {
        Conta nova = new Conta();
        nova.titular = nome;
        nova.numConta = num;
        vetorContas[tam] = nova;
        tam++;
    }
    static void transferencia(int numContDoador, int numContRecebedor, float valorTran){
        int indiceDoDoador = -1;
        int indiceDoRecebedor = -1;
        for (int i = 0; i < tam; i++) {
            if (numContDoador == vetorContas[i].numConta) {
                indiceDoDoador = i;
            }
        }

        for (int i = 0; i < tam; i++) {
            if (numContRecebedor == vetorContas[i].numConta) {
                indiceDoRecebedor = i;
            }
        }
        
        if(indiceDoDoador!=-1&&indiceDoRecebedor!=-1){
            vetorContas[indiceDoDoador].saldo = vetorContas[indiceDoDoador].saldo - valorTran;
            vetorContas[indiceDoRecebedor].saldo = vetorContas[indiceDoRecebedor].saldo + valorTran;
        }
    }
    static void deposito(int numConta, float valor){
        for (int i =0; i<tam; i++){
            if(numConta == vetorContas[i].numConta){
                vetorContas[i].saldo += valor;
            }
        } 
    }
    static void saque(int numConta, float valor){
        for (int i =0; i<tam; i++){
            if(numConta == vetorContas[i].numConta){
                vetorContas[i].saldo = vetorContas[i].saldo - valor;
            }
        } 
    }
    static float saldo(int numConta){
		float result = 0;
        for (int i=0;i<tam;i++){
			System.out.printf("%d: %d %f\n", i, vetorContas[i].numConta, vetorContas[i].saldo);
            if(numConta == vetorContas[i].numConta){
                result = vetorContas[i].saldo;
            }
        }
        return result;
    }
      public static void escreverArquivo(String nome) {
        FileWriter fileWriter = null;
        BufferedWriter arquivo = null;
        String caminho = "arquivo.txt";
        File file = new File(caminho);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(caminho ,true);
            arquivo = new BufferedWriter(fileWriter);

            for (int i = 0; i < tam; i++) {
                if (vetorContas[i].titular.equals(nome))  {
                    arquivo.write(vetorContas[i].titular + ";" + vetorContas[i].numConta + ";" + vetorContas[i].saldo);
                    arquivo.newLine();
                } else {

                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                fileWriter.close();
                arquivo.close();
            } catch (Exception e) {
            }
        }

    }
       public static String lerArquivo() {
           String retorno = "";
			FileReader fileReader = null;
			BufferedReader arquivo = null;
			try {
            fileReader = new FileReader("arquivo.txt");
            arquivo = new BufferedReader(fileReader);

            String leitura = arquivo.readLine();
            
            while (leitura != null){    

                String vet[] = leitura.split(";");

                for (String v : vet) {

                    retorno += v + " ";
                }
                
                retorno += "\n";

                leitura = arquivo.readLine();
                
            }

            arquivo.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                fileReader.close();
                arquivo.close();
            } catch (Exception e) {
            }
        }
        return retorno;
    }

    public static void main(String[] args) { 
        int op;
        do { 
            op = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opcao: \n"
                    + "1) Criar Conta \n"
                    + "2) Depositar \n"
                    + "3) Sacar \n"
                    + "4) Transferencia \n"
                    + "5) Saldo \n"
                    + "6) Gravar usuario \n"
                    + "7) Ler usuario \n"
                    + "8) Sair"));
            if(op == 1){
                String nome = JOptionPane.showInputDialog("Insira o nome do Titular");
                int num;
                num = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta"));
                criaConta(nome, num);
            }
            if(op == 2){
                int numConta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta"));
                float valor  = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor do depósito"));
                deposito(numConta, valor);
            }
            if(op == 3){
                int numConta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta"));
                float valor  = Float.parseFloat(JOptionPane.showInputDialog("Insira o valor do saque"));
                saque(numConta, valor);
            }
            if(op ==4){
                int numContDoador = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta do Doador"));
                int numContRecebedor = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta do Recebedor"));
                float valorTran = Float.parseFloat(JOptionPane.showInputDialog("Insira o valor da transação"));
                transferencia(numContDoador, numContRecebedor, valorTran);
            }
            if(op ==5){
                float saldo = 0;
                int numConta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta"));
                saldo = saldo(numConta);
                JOptionPane.showMessageDialog(null,saldo);
            }
            if(op ==6){
                String nome = JOptionPane.showInputDialog("Insira o nome do titular da conta a ser gravada");
                int a = 0;
                for (int i = 0; i < tam; i++) {
                    if (nome == vetorContas[i].titular) {
                        a = i;
                    }
                }
                escreverArquivo(vetorContas[a].titular);
            }
            if(op ==7){
                lerArquivo();
            }
        }while(op !=8);
    }
}
