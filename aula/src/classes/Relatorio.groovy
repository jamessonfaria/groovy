package classes

class Relatorio {
	void emitir(cliente, cabecalho) {
		def rel = cabecalho(cliente)
		println "Relatório de vendas: " + rel + " ****"
	}
}

