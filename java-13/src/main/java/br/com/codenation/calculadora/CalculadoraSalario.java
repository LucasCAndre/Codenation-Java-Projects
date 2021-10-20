package br.com.codenation.calculadora;


public class CalculadoraSalario {
	public static void main(String[] args) {
		CalculadoraSalario test = new CalculadoraSalario();
		System.out.println(test.calcularSalarioLiquido(6000));
	}

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		double inssDescount = this.calcularInss(salarioBase);
		if (inssDescount == 1){
			return Math.round(0.0);
		}else if (inssDescount <= 3000){
			return Math.round(inssDescount);
		}else if (inssDescount <= 6000){
			return Math.round(inssDescount * 0.925);
		}else{
			return Math.round(inssDescount * 0.85);
		}
	}

	private double calcularInss(double salarioBase) {
		if (salarioBase < 1039) {
			return 1;
		}else if (salarioBase <= 1500){
			return salarioBase * 0.92;
		}else if (salarioBase <= 4000){
			return salarioBase * 0.91;
		}else{
			return salarioBase * 0.89;
		}
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/