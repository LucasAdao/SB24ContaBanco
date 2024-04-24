package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean passa = false;
		String nome = "iniciada!";
		
		while(passa == false) {
			System.out.println("Digite o seu nome:");
			
			nome = sc.nextLine();
			if(nome.length() < 3) {
				System.out.println("Seu nome precisa ter ao menos 3 caracteres!");
				nome = "";
			}else {
				passa = true;
				System.out.println("Olá "+ nome + " seja bem vindo ao Santander!");
			}
			
		}
		
		passa = false;
		int numeroDaConta = 0;
		
		while(passa == false) {
			try {
			System.out.println("Agora digite o número da sua conta Senhor(a) " + nome +". Precisa ter apenas 4 caracteres!" );
			numeroDaConta = sc.nextInt();
			String numeroDaContaEmStrings = String.valueOf(numeroDaConta);
			if(numeroDaContaEmStrings.length() != 4) {
				System.out.println("A quantidade de números que você deve inserir nesse campo é de 4 números, nem mais nem menos!");
				System.out.println("Peço que por favor escreva 4 números para darmos continuidade com o processo!");
			}else {
				System.out.println("Esse foi o número digitado: " + numeroDaConta + "? Deseja continuar com esse número?1-Sim 2-Não");
				int verificacao = sc.nextInt();
				if(verificacao == 1) {
					System.out.println("Muito bem " + nome + " seu número da conta é "+ numeroDaConta+ ", vamos prosseguir com o seu cadastro!");
					passa = true;
				}else {
					System.out.println("Muito bem " + nome + " vamos tentar novamente!");
				}
			}
			}catch(InputMismatchException e) {
				//precisei limpar o buffer, não sei porquê, estudar isso
				sc.nextLine();
				System.out.println("Digite apenas números para o número da conta!");
				
			}
		}
		passa = false;
		int numeroDaAgencia = 0;
		
		while(passa == false) {
			System.out.println("Agora digite o número da sua agência Senhor(a) " + nome +"." );
			try {
			numeroDaAgencia = sc.nextInt();
			System.out.println("Esse foi o número escolhido: " +numeroDaAgencia + "?1-Sim 2-Não");
			int verificacao = sc.nextInt();
			if(verificacao == 1) {
				System.out.println("Muito bem, vamos continuar com o seu cadastro! Vejo que optou por uma agência bem próxima a sua casa!");
				passa = true;
			}else {
				System.out.println("Okay, tente inserir uma agência mais próxima da sua casa!");
			}
			}catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("Insira somente números para o número de sua agência!");
			}
		}
		passa = false;
		double saldoDaConta = 0;
		System.out.println("Deseja depositar algum saldo inicial na sua conta? 1-Sim 2-Não");
		int verificacao = 0;
		try {
		verificacao = sc.nextInt();
		}catch(InputMismatchException e){
			sc.nextLine();
			System.out.println("Tente inserir posteriormente saldo na sua conta, tivemos um problema!");
		}
		if(verificacao == 1) {
			System.out.println("Digite o valor que deseja depositar na sua conta:");
			saldoDaConta = sc.nextDouble();
		}
		System.out.println("Muito bem " + nome + " seja bem vindo ao nosso banco!!\nO número da sua conta é: " + numeroDaConta +"\nE sua Agência: " + numeroDaAgencia);
		System.out.printf("E você tem um total de R$ %.2f na sua conta! \n", saldoDaConta);
		sc.close();
	}
	
}
