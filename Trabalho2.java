import javax.swing.JoptionPane;


public class Trabalho2 {
	
	static class Conta {
		String titular;
		int numConta;
		int tipoConta = 0;
		float saldo = 0;
		
	}
	
	static Conta criaConta(Conta matrizContas){
		matrizContas = JoptionPane.showInputDialog("Informe o nome do Titular da conta : ");
		numConta = Integer.parseInt(JoptionPane.showInputDialog("Informe o numero da conta : "));
		tipoConta = Integer.parseInt(JoptionPane.showInputDialog("Informe 1 - Conta Corrente ou 2 - Conta Poupança : "));
		if(tipoConta == 1){
			static float limite = Float.parseFloat(JoptionPane.showInputDialog("Informe o limite da conta: "));
	}
	
	static float deposito(Conta matrizContas, float valor){
		matrizContas.saldo = matrizContas.saldo + valor;
		return matrizContas.saldo;
	}
	static float saque(){
		matrizContas.saldo = matrizContas.saldo - valor;
		return matrizContas.saldo;
	}
	static float transferencia(Conta matrizContas1, Conta matrizContas2, float valor){
		matrizContas1.saldo = matrizContas1.saldo - valor;
		matrizContas2.saldo = matrizContas2.saldo + valor;
	}
	static void saldo(Conta matrizContas){
		return matrizContas.saldo;
	}
	
	static Conta retornaConta(Conta matrizContas, numConta, n){
		for(i=0; i<n; i++){
			if(numConta == matrizContas.numConta)
				return matrizContas;
	}
	
	public static void main (String[] args) {
		
		
		
	}
}

