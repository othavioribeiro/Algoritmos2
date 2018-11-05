/**
 * A empresa Tiburciobeer contratou você para desenvolver um software em JAVA para controlar
 * o estoque de diferentes tipos de cerveja em seu armazém.
 * A Tiburciobeer tem sua produção de forma artesanal, ou seja, a quantidade de caixas de
 * cerveja em um pallet (1 pallet = 1 compartimento) depende do dia e disponibilidade da
 * matéria prima.
 * O armazém é composto por 3 prateleiras com 4 compartimentos em cada prateleira.
 * MATRIZ (3x4) ;P
 * Cada compartimento é numerado conforme modelo abaixo(Nesta matriz use STRING):
 * Prateleira 1: 1001, 1002, 1003, 1004
 * Prateleira 2: 2001, 2002, 2003, 2004
 * Prateleira 3: 3001, 3002, 3003, 3004
*/

import java.util.*;
import java.io.*;
import java.lang.*;

public class Trabalho1 {
	
	public static void main (String[] args) {
		
		String[][] prateleiras = {{"1001", "1002", "1003", "1004"}, {"2001", "2002", "2003", "2004"}, {"3001", "3002", "3003", "3004"}};
		Scanner input = new Scanner(System.in);
		
		/**1)Solicite ao usuário a quantidade de caixas de cerveja em cada compartimento, a mensagem
		*que aparece para o usuário deve seguir EXATAMENTE o seguinte modelo:
		*"Olá, insira a quantidade de caixas de cerveja para o compartimento (número do compartimento): "
		*/
		int prateleirasQtde[][] = new int[3][4];
		int vetor[] = new int[12];
		
		
		int i = 0, j = 0, aux = 0, maior = 0, menor = 999999999, linha = 0, coluna = 0, media = 0;
		for(i = 0; i<prateleirasQtde.length; i++) {
			for(j = 0; j<prateleirasQtde[i].length; j++){
				System.out.printf( "Olá, insira a quantidade de caixas de cerveja para o compartimento %s:  ", prateleiras[i][j]);
				prateleirasQtde[i][j] = input.nextInt();
			}
		}
		System.out.printf("\n \n");
		
		/**
		 * 2)Qual é o número total de caixas de cerveja no armazém ?
		 */
		 for(i = 0; i<prateleirasQtde.length; i++) {
			 for(j = 0; j<prateleirasQtde[i].length; j++) {
				 aux += prateleirasQtde[i][j];
			 }
		 }
		 System.out.printf("Número total de cervejas no armazém: %d \n", aux);
		 
		 /**
		  * 3)O armazém está desorganizado, calcule o número ideal de caixas de cerveja que deveriam
		  * estar alocados em cada compartimento. (Calcule a média).
		  */
		  media = aux/12;
		  System.out.printf("Número médio por prateleira: %d \n", media); 
		  
		  /**
		   * 4)Qual é o número do compartimento que MAIS tem caixas de cerveja ?
		   */
		  
		  for(i = 0; i<prateleirasQtde.length; i++) {
			 for(j = 0; j<prateleirasQtde[i].length; j++) {
				 if(maior < prateleirasQtde[i][j]) {
					 maior = prateleirasQtde[i][j];
					 linha = i;
					 coluna = j;
				 }
			 }
		 }
		 
		 System.out.printf("Compartilhamento que mais tem cervejas: %s \n", prateleiras[linha][coluna]);
		 
		 /**
		  * 5)Qual é o número do compartimento que MENOS tem caixas de cerveja ?
		  */
		  
		  for(i = 0; i<prateleirasQtde.length; i++) {
			 for(j = 0; j<prateleirasQtde[i].length; j++) {
				 if(menor > prateleirasQtde[i][j]) {
					 menor = prateleirasQtde[i][j];
					 linha = i;
					 coluna = j;
				 }
			 }
		 }
		 
		 System.out.printf("Compartilhamento que menos tem cervejas: %s \n", prateleiras[linha][coluna]);
		 
		 /**
		  * 6)Peça que o usuário informe o número de um dos compartimentos(exemplo 1003), diga
		  * quantas caixas de cerveja tem neste compartimento.
		  */
		  
		  System.out.print("\n Informe o compartimento que gostaria de saber a quantidade de cervejas dele:");
		  String compara = input.next();
		  for(i=0; i<prateleiras.length; i++){
			  for(j=0; j<prateleiras[i].length; j++) {
				  if(prateleiras[i][j].equals(compara)) {
					  System.out.printf("Possui %d garrafas neste compartimento! \n \n", prateleirasQtde[i][j]);
				  }
			  }
		  }  
			  
		  
		  /**
		   * 7)Mostre todas as quantidades de caixas de cerveja ordenadas em apenas 1 mensagem.
		   * Para isso coloque todas as quantidades em um vetor e ordene com o BubbleSort.
		   */
		   
		   aux = 0;
		   for(i = 0; i<prateleirasQtde.length; i++) {
			   for(j = 0; j<prateleirasQtde[i].length; j++) {
				   vetor[aux] = prateleirasQtde[i][j];
				   aux = aux + 1;
				   }
			}
			boolean trocou = true;
			while(trocou){
				trocou = false;
				for(i = 0; i<vetor.length - 1; i++) {
					if(vetor[i] > vetor[i + 1]) {
						aux = vetor[i];
						vetor[i] = vetor[i +1];
						vetor[i + 1] = aux;
						trocou = true;
					}
				}
			}
			System.out.printf("Quantidade de cervejas dos compartimentos em ordem crescente : ");
			for(i=0; i<vetor.length; i++) {
				System.out.printf(" %d |", vetor[i]);
			}
			System.out.printf("\n");
			
			/**
			 * 8)Mostre a porcentagem do número de compartimentos em relação ao total (12compartimentos)
			 * que possuem mais caixas de cerveja que a média do armazém.
			 */
			 aux = 0;
			 for(i = 0; i<prateleirasQtde.length; i++) {
				 for(j = 0; j<prateleirasQtde[i].length; j++) {
					 if(prateleirasQtde[i][j] > media) {
						 aux++;
					 }
				 }
			 }
			 System.out.printf("Número de compartimentos com mais garrafas do que a média : %d \n" , aux);
			 
			 /**
			  * 9)Mostre o número do compartimento que MENOS tem caixas de cerveja na Prateleira 2.
			  */
			  
			 menor = 9999999;
			 for(j = 0; j<prateleirasQtde[1].length; j++) {
				 if(menor > prateleirasQtde[1][j]) {
					 menor = prateleirasQtde[1][j];
					 coluna = j;
				 }
			 }
			 System.out.printf("Compartilhamento que menos tem cervejas dq prateleira 2: %s \n", prateleiras[1][coluna]);
			 
			 /**
			  * 10)Mostre o número do compartimento que MAIS tem caixas de cerveja na Prateleira 3.
			  */
			 maior = 0;
			 for(j = 0; j<prateleirasQtde[2].length; j++) {
				 if(maior < prateleirasQtde[2][j]) {
					 maior = prateleirasQtde[2][j];
					 coluna = j;
				 }
			 }
			 System.out.printf("Compartilhamento que mais tem cervejas da prateleira 3: %s \n \n", prateleiras[2][coluna]);		  		   
		   		 
		 
	}
}
