package aula

import static java.util.Calendar.*
import static javax.swing.JFrame.EXIT_ON_CLOSE as ex

import org.junit.Test

import classes.Cantor
import classes.Cliente
import classes.Cliente as Xu
import classes.Comida
import classes.Comissao
import classes.Conexao
import classes.Fatura
import classes.Funcionario
import classes.Funcionario2
import classes.Nota
import classes.Palco
import classes.Pedido
import classes.Pessoa
import classes.Produto
import classes.Relatorio
import classes.Somar
import classes.Tela
import classes.Teste
import classes.Torcida
import classes.Venda
import classes.Viajar

// Aten��o fer: n�o mude as classes durante as aulas pq vai quebrar outros exerc�cios
// fa�a exatamente o que ta no papel.

class Exercicios {

	@Test
	void exercicio1ponto2() {
		int a = 10
		println a.class // tem atributos e m�todos.
		println a.toString()
		println 12l.class.name

		// muda 2 coisas do java:
		// 1 - coloca "g" no literal para virar BigInteger.
		println 11g.class.name

		// 2 - literal flutuante � considerado BigDecimal por padr�o.
		BigDecimal valor = 200.50
		println valor
	}

	@Test
	void exercicio2() {
		Cliente c = new Cliente()
		c.setNome "Fer" // sem par�nteses.
		c.setData new Date() // sem par�nteses.
		println  c.somar (10, 10)
		println  c.getNome() + " "+ c.getData()
	}

	@Test
	void exercicio3() {
		// veja que n�o fizemos construtor na classe Cliente
		Cliente c = new Cliente()
		println  c.getNome() + " - " + c.getData()

		c = new Cliente(nome: "fernando")
		println  c.getNome() + " - " + c.getData()

		c = new Cliente(data: new Date())
		println  c.getNome() + " - " + c.getData()

		c = new Cliente(nome: "fernando", data: new Date())
		println  c.getNome() + " - " + c.getData()
	}

	@Test
	void exercicio4() {
		Cliente c = new Cliente(nome: "fernando", data: new Date())
		println  c["nome"]
		c["nome"] = "marc�o"
		println  c["nome"]
	}

	@Test
	void exercicio5() {
		Produto p = new Produto("CD", 12.00)
		println p.nome + "-" + p.valor
		p.nome = "CD Calcinha Preta"
		p.valor = 15.00
		println p.nome + "-" + p.valor
	}

	@Test
	void exercicio6() {
		// import classes.Cliente as Xu
		Xu c = new Xu(nome: "fernando", data: new Date())
		println  c.getNome() + " - " + c.getData()

		//import static javax.swing.JFrame.EXIT_ON_CLOSE as ex
		println ex
	}

	@Test
	void exercicio7() {
		Venda v = new Venda()
		println  v.vender(100)
		println  v.vender(100, 15)
	}

	@Test
	void exercicio8() {
		Somar soma = new Somar()
		println  soma.somar(10)
		println  soma.somar(10, 10)
		println  soma.somar(10, 10, 10)
		// depurar dentro da classe somar.
	}

	@Test
	void exercicio9() {
		Cliente c = null
		c?.nome = "Fernando"
		println  c?.getNome()
		// em java geraria null point exception

		Cliente c2 = new Cliente()
		c2?.nome = "Fernando"
		println  c2?.getNome()
	}

	@Test
	void exercicio10() {
		List<String> colecao = new ArrayList<>()
		colecao.add("fernando")
		colecao.add(null)
		colecao.add("anny")
		colecao.add("rita")
		println colecao
		colecao = colecao*.toUpperCase()
		println colecao
		colecao = colecao*.replace("A", "@")
		println colecao
	}

	@Test
	void exercicio11() {
		// Construtor lan�a 2 exception, veja javadoc.
		URL url = new URL("http://www.google.com.br")
		println url
		// depois fa�a dar errado para ver o lancamento da exception
		//URL errado = new URL("hbla blalbal")
	}

	@Test
	void exercicio12() {
		String nome = null
		if (nome) {
			println true
		} else{
			println false
		}
		nome = "Fer"
		if (nome) {
			println true
		} else{
			println false
		}
		int valor = 0
		if (valor) {
			println true
		} else{
			println false
		}
		valor = 1
		if (valor) {
			println true
		} else{
			println false
		}
		List<String> colecao = new ArrayList(0)
		if (colecao) {
			println true
		} else{
			println false
		}
		colecao.add("fer")
		if (colecao) {
			println true
		} else{
			println false
		}
		// nenhum desses funcionam em java.
	}

	@Test
	void exercicio13() {
		Nota n1 = new Nota(itens: 2, valor: 20)
		Nota n2 = new Nota(itens: 2, valor: 20)
		Nota n3 = n1+ n2
		println n3.valor + " - "+ n3.itens
		n1++
		println n1.valor + " - "+ n1.itens
	}

	@Test
	void exercicio13ponto2() {
		BigDecimal vl = 10
		println vl
		vl = vl + 1
		println vl
		vl++
		println vl

		int a = 2
		vl = vl + a;
		println vl
		println vl - 5

		Date data = new Date()
		println  data
		data++
		println data
		data++
		println data + 10
		// consulte o documenta��o do groovy para saber detalhes das sobrecargas.
		// se caso n�o existir, vc pode implementar.
	}

	@Test
	void exercicio13ponto3() {
		Pessoa p = new Pessoa()
		// O plugin de eclipse de groovy n�o sabe tratar trait, ele n�o vai ver os atributos no code completion.
		p.nome  = "Fernando"
		p.arma = "Espada"
		p.pular()
		p.falar()
		p.correr()
		p.lutar()
	}

	@Test
	void exercicio14() {
		Funcionario f = new Funcionario(nome: "Fer", idade: 10, salario: 1500.59)
		println f
	}

	@Test
	void exercicio15() {
		Funcionario2 f1 = new Funcionario2(nome: "Fer", idade: 10, salario: 10)
		Funcionario2 f2 = new Funcionario2(nome: "Fer", idade: 10, salario: 10)
		// 1) execute na 1 sem a anota��o para dar false.
		println  f1.equals(f2)

		// 2) Acrescente a nota��o e depois executa denovo para dar true.
		println  f1.equals(f2)
	}

	@Test
	void exercicio16() {
		//1) Parte
		Pedido p = new Pedido(cliente:"fernando", numero: 10)
		println p.cliente + "-" + p.numero
		println p

		//2) Parte - tenta alterar alguns atributo e vera erro de propriedade readOnly.
		//p.cliente = "fer"
	}

	@Test
	void exercicio17() {
		//1) Parte
		Conexao.instance.valor = 10
		println Conexao.instance.valor
		Conexao con =  Conexao.instance
		con.valor = 11
		println Conexao.instance.valor

		//2) Parte - tente criar uma instancia e vera o erro q n�o pode instanciar uma classe singleton.
		//Conexao x = new Conexao()
	}

	@Test
	void exercicio18() {
		Comida comida = Comida.builder().fruta("maca").bebida("coca cola").doce("casadinho").build()
		println comida.fruta
		println comida.bebida
		println comida.doce
	}

	@Test
	void exercicio19() {
		def objeto = "texto"
		println objeto.getClass()

		objeto = 10
		println objeto.getClass()

		objeto = 10.00
		println objeto.getClass()

		objeto = new Nota(itens: 2, valor: 20)
		println objeto.getClass()
		println objeto.valor

		objeto = new Pedido(cliente:"fernando", numero: 10)
		println objeto.getClass()
		println objeto.cliente
	}

	@Test
	void exercicio20() {
		def teste = new Teste()
		def v1 = teste.metodo("fer")
		println v1.getClass()
		println v1

		v1 = teste.metodo(5)
		println v1.getClass()
		println v1

		v1 = teste.metodo(new BigDecimal(5))
		println v1.getClass()
		println v1

		def data = new Date()
		println data
		v1 = teste.metodo(data)
		println v1.getClass()
		println v1
	}

	@Test
	void exercicio21() {
		def colecao = new ArrayList<String>()
		colecao.add("fer")
		colecao.add("anny")
		// executando tipo string
		for (item in colecao) {
			println item
		}

		colecao = new ArrayList<Integer>()
		colecao.add(1)
		colecao.add(2)
		// executando tipo integer
		for (item in colecao) {
			println item
		}

		colecao  = "fernando esta aqui parado"
		// executando tipo carater
		for (item in colecao) {
			println item
		}

		colecao  = 10
		// executando tipo inteiro unico
		for (item in colecao) {
			println item
		}
	}

	@Test
	void exercicio22() {
		def metodo = {int v1, int v2-> v1 + v2}
		println metodo(1, 2)
		println metodo(2, 3)
	}

	@Test
	void exercicio23() {
		def imprimir = {String v->
			String temp = v.trim().replace("a", "@")
			temp = temp.toUpperCase()
			return temp // return � opcional
		}
		println imprimir("  fernando   ")
		println imprimir("marta")
	}

	@Test
	void exercicio24() {
		def funcao = {v1, v2-> v1 + v2}
		def  r1 = funcao(5, 5)
		println  r1.class
		println r1
		def  r2 = funcao("fer", "nando")
		println r2.class
		println r2
		def  r3 = funcao(10.50, 5.50)
		println r3.class
		println r3
	}

	@Test
	void exercicio25() {
		def limpeza = {texto-> texto.trim().replace("a", "@").replace(" ", "").capitalize() }
		def rel = new Relatorio()
		rel.emitir("     f e r n a n d o  ", limpeza)
		rel.emitir("    J a n a  ", limpeza)
	}

	@Test
	void exercicio26() {
		def rel = new Relatorio()
		rel.emitir("FERNANDO") { v-> v +" DA SILVA" }
		rel.emitir("FERNANDO") { a-> a.replace("N", "#") }
	}

	@Test
	void exercicio27() {
		def rel = new Relatorio()
		rel.emitir("FERNANDO") { it +" DA SILVA" }
		rel.emitir("FERNANDO") { it.reverse() }
	}

	@Test
	// implementa��o de interface funcionais - 1 m�todo.
	void exercicio28() {
		Palco palco = new Palco()
		Cantor cantor = null

		def imp = {println "vou cantar"}
		cantor = imp
		cantor.cantar()
		palco.show(cantor)

		cantor = {println "agora vou chorar"}
		cantor.cantar()

		palco.show({println "clousure cantanto como se fosse cantor"})
	}

	@Test
	// implementa��o de interface funcionais - v�rios metodos.
	void exercicio29() {
		Torcida t = null
		def corintiano  = [
			pular: {println  "curintia pulando"},
			gritar: {p ->
				println  "curintia - "+ p
			}
		] as Torcida
		// quando uma interface com varios metodos, use o operado "as"
		//para converter a clousure na interface polimorfica

		t = corintiano
		t.pular()
		t.gritar("vai ae")

		def porcada  = [
			pular: {println  "porco eooo"},
			gritar: {p ->
				println  "poorrcooooooooooo - "+ p
			}
		] as Torcida

		t = porcada
		t.pular()
		t.gritar("verd�o")
	}

	//exercicio30
	static main_exercicio30(arg) {
		def tela = new Tela()
		tela.setVisible(true)
	}

	@Test
	void exercicio31ponto1() {
		def fat = new Fatura()
		// 1) tente executar a 1 vez, n�o vai dar pq n�o existe.
		//fat.vender(10.00)

		// 2) Adicionando m�todo din�mico no objeto.
		fat.metaClass.vender = {valor -> println " venda no valor="+ valor}

		fat.vender(10.00)
		fat.vender(1052.98)
	}

	@Test
	void exercicio31ponto2() {
		def f1 = new Fatura()
		// 1) tente executar a 1 vez, n�o vai dar pq n�o existe.
		//f1.faturar(10)

		// 2) Adicionando m�todo din�mico na classe.
		Fatura.metaClass.faturar = {valor -> println " faturar no valor="+ valor}

		def f2 = new Fatura()
		f2.faturar(10)
		def f3 = new Fatura()
		f3.faturar(22)
	}

	@Test
	void exercicio32ponto1() {
		def fat = new Fatura()
		// 1) tente executar a 1 vez, n�o vai dar pq n�o existe.
		//fat.cliente = "Fernando"

		// 2) Adicionando atributo din�mico no objeto.
		fat.metaClass.cliente = "Fernando"
		println  fat.cliente
		fat.cliente = "outra pessoa"
		println fat.cliente
	}

	@Test
	void exercicio32ponto2() {
		def f1 = new Fatura()
		// 1) tente executar a 1 vez, n�o vai dar pq n�o existe.
		//f1.cliente = "teste"

		// 2) Adicionando atributo din�mico na classe.
		Fatura.metaClass.cliente = ""

		def fat = new Fatura()
		fat.cliente = "Luana"
		println  fat.cliente
	}

	@Test
	void exercicio32ponto3() {
		// metodo
		Fatura.metaClass.static.impressao = {println "metodo estatico ok"}
		Fatura.impressao()
		def f = new Fatura()
		f.impressao()
	}

	@Test
	void exercicio32ponto4() {
		Viajar v = new Viajar()
		v.viajar("Curitiva", 10)
		def novoMetodo = {String lugar, BigDecimal valor ->
			valor += 3.50
			println "Novo pre�o $lugar ser� $valor"
		}
		v.metaClass.viajar = novoMetodo
		v.viajar("Curitiva", 10)
	}

	@Test
	void exercicioExpando32ponto5() {
		//1) Cria um objeto e adicione atributos e comportamentos.
		Expando cliente = new Expando()
		cliente.nome = "Fernando"
		cliente.idade = 37
		cliente.impressao = {println "nome $nome idade � $idade"}
		cliente.impressao()

		// 2) Crie um objeto e j� no pr�prio construtor crie os campos
		Expando livro = new Expando(autor: "Jonas", paginas: 100)
		println livro.autor
		println livro.paginas
	}

	@Test
	void exercicio33() {
		def v1 = new BigDecimal("10.50")
		def v2 = 10.50
		println v2.getClass().name
		println v1 == v2

		def v3 = v1 + v2
		println v3.getClass()
		println v3

		v3 = v1 - v2
		println v3

		v3 = v1 * v2
		println v3
	}

	@Test
	void exercicio34() {
		// compara��o
		def v1 = "Fernando "
		def v2 = "Fernando "
		println v1 == v2

		// sobrecarag de operador -
		def v3 = v1 - "nando"
		println  v3

		// novos m�todos e closures
		String texto = "fernando"
		println texto.capitalize()
		println  texto.findIndexOf ({it == "o"})

		// multiline
		String textoGrande = '''
        Meu texto grande
        � muto grande
        e n�o precisa ficar usado + toda hora
        '''
		// string el, q evita dry "+ var +"
		def nome = "fernando"
		def idade = 35
		def salario = 1555.90

		def sql = "insert into cliente (nome, idade, salario) values(${nome}, ${idade}, ${salario})"
		println sql
		println textoGrande
	}

	@Test
	void exercicio35() {
		def data1 = new Date()
		// setar valores usando constantes do import static java.util.Calendar.*
		data1[YEAR] = 2010
		data1[MONTH] = 1 // 0 JANEIRO, 1 FEV
		data1[DATE] = 14
		println data1

		def data2 = new Date()
		data2[YEAR] = 2015
		data2[MONTH] = DECEMBER
		data2[DATE] = 1
		println data2

		// compara��o entre datas com > sobrecarga
		if (data2 >= data1) {
			println "maior"
		}

		// operadores sobrecarregados
		Date data = new Date()
		println  data
		data +=  1
		println data
		data -= 2
		println data
		data++
		println data
		data--
		println data

		// formata��o na mesma classe
		println data.format("dd/MM/yyyy hh:mm:ss")
	}

	@Test
	void exercicio36() {
		// numero s�o objetos e eles tem closures da GDK.
		10.times { println it }
		1.upto(10) { println it }
		5.downto(1) {println  it }
	}

	@Test
	void exercicio37() {
		// criar e escrever
		def x = new FileWriter("D:/1.txt").withWriter { e -> e.write("fernando franzini")}
		def a = new File("D:/2.txt")
		a.write("outro")

		def b = new File("D:/3.txt")
		b.text = "Linha 1"
		5.times { b << "\r\nnova linha usando sobrecarga de operador" }

		// ler
		def c = new File("D:/3.txt")
		println c.text

		// lendo todas as linhas e usando spread para colocar tudo maisc.
		println c.readLines()*.toUpperCase()

		new File("D:/3.txt").eachLine { linha-> println linha}

		// Esse n�o precisa passar na aula.
		a.delete()
		b.delete()
		c.delete()
		new File("D:/1.txt").delete()

		// lendo todos os diretorios
		new File("C:/").eachFile { println it.name }
	}

	@Test
	void exercicio38() {
		Thread.start {10.times { println "rodando na outra thread"
			} }
	}


	@Test
	void exercicio40() {
		//ArrayList<String> lista = new ArrayList()

		// Nova sintaxe otimizada []
		def lista1 = [1, 2, 3, 4]
		println lista1.getClass().name
		def lista2 = [
			"Fer",
			"Anny",
			"Lucas",
			"Cida"
		]
		println lista2.getClass().name

		def lista3 = new ArrayList<BigDecimal>()
		lista3.add(1.50)

		// List tem operador sobrecarregado para adicionar
		lista3 << 10.50
		lista3 << 20.50

		// closures de conveniencias gerais

		// itera��o rapida
		lista1.each {println it}
		lista2.each {println it}
		lista3.each {println it}

		// itera��o com soma
		def total = 0
		lista3.each {total += it}
		println total

		// cria��o de um lista de clientes
		// Fazer o toString no Cliente
		def clientes = []
		clientes << new Cliente(nome: "Xico", data: new Date())
		clientes << new Cliente(nome: "Luana", data: new Date())
		clientes << new Cliente(nome: "Fernando", data: new Date())
		clientes << new Cliente(nome: "Anny", data: new Date())
		clientes << new Cliente(nome: "Luciano", data: new Date())

		// Facilidade para procurar um elemento.
		def achou = clientes.find {c -> c.nome.contains("Lu")}
		println achou

		// Facilidade para procurar varios elementos.
		def encontrandos = clientes.findAll {c -> c.nome.contains("Lu")}
		encontrandos.each {c -> println c}

		// Facilidade ordenar com regras customizadas
		clientes.sort {c1, c2 -> c1.nome.compareTo(c2.nome)}
		println clientes

		// convers�o de list para set
		def set = clientes as Set
		println set.getClass().name
		set.each{c -> println c}

		// convers�o de set para list
		def lista4 = set as List

		// lista e set imutaveis
		def listaImutavel = lista4.asImmutable()
		def setImmutavel = set.asImmutable()

		// lista e set sincronizadas
		def listaSyn = lista4.asSynchronized()
		def setSyn = set.asSynchronized()

		// transforma��es entre cole��es
		def func = clientes.collect {c -> new Funcionario(nome: c.nome)}
		println func
	}

	@Test
	void exercicio40ponto2() {
		def mapa = [:]
		println mapa.getClass().name

		// Adicionando um chave /valor
		mapa["pai"] = "Fernando"
		mapa["mae"] = "Anny"
		println mapa

		// Acessando uma chave
		println mapa["pai"]
		println mapa["filha"]

		// Removendo
		mapa.remove("pai")
		println mapa

		// Cria��o via mapa com construtor
		def pessoas = ["jonas": 10, "pedro":11, "rebeca": 12]
		println pessoas

		// iterando nos valores
		pessoas.values().each { println it}
		// iterando nas chaves
		pessoas.keySet().each { println it}
	}



	@Test
	void exercicio44Digitado() {
		//Savar isso no arquivo
		String arquivo = '''
            import classes.Comissao 
            def vlComissao = 1.00
            comissoes.each { c -> 
               c.comissao = c.valor * vlComissao / 10 
            } 
         comissoes'''
		def lista = [
			new Comissao(valor: 100.50),
			new Comissao(valor: 200.50),
			new Comissao(valor: 300.50)
		]
		def variaveis = new Binding()
		variaveis.setVariable("comissoes", lista)
		def shell = new GroovyShell(variaveis)
		def retorno = shell.evaluate(arquivo)
		retorno.each { println it }
	}

	//@Test
	void exercicio44Arquivo() {
		// digitar esse aqui
		def lista = [
			new Comissao(valor: 100.50),
			new Comissao(valor: 200.50),
			new Comissao(valor: 300.50)
		]
		def variaveis = new Binding()
		variaveis.setVariable("comissoes", lista)
		def shell = new GroovyShell(variaveis)
		def retorno = shell.evaluate(new File("E:/regra.txt").text)
		retorno.each { println it }
		//depois altera o valor da comiss�o e executa denovo
	}

	@Test
	void testePendentaFAzerSobreTipos() {
		int a = 1
		println  a.getClass().name

		float b = 10.10
		println  b.getClass().name

		long c = 10
		println  c.getClass().name

		BigDecimal d = 10.10
		println  d.getClass().name
	}
}