package aula

class Exercicio1 {

	// Ola mundo 1
	static main (args) {
		// Exer1
		println "Ola mundo groovy"

		// Exer2
		// interpola��o de string -  cancatena automaticamente - $variavel ou $objeto.atributo
		String nome = "James"
		int idade = 45

		String frase = "O $nome tem $idade anos."
		println frase
	}
}
