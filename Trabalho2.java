import javax.swing.*;


public class Trabalho2 {
	
	static class Conta {
		String titular;
		int numConta;
		float saldo;
	}
		
	public static void criarVetor(){
		int n = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero de contas a serem cadastradas: "));
		Conta vetorContas[] = new Conta[n];
		
        for(int i=0; i<n; i++){
            vetorContas[i].titular = JOptionPane.showInputDialog(null, "Nome do titular: ");
            
            vetorContas[i].numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da conta: "));
            
            vetorContas[i].saldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o saldo inicial da conta: "));
        }
    }
	
	public static void main (String[] args) {
		criarVetor();
		
	}
}
