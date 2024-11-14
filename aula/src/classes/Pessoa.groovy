package classes

// O plugin de eclipse de groovy não sabe tratar trait, ele vai pensar que é uma interface
// se vc mandar o eclipse implementar ele vai gerar todas as implementações....
class Pessoa implements Animal, Lutador {
    @Override
    void pular() {
        println "pessoa " + nome + " pulando"
    }

    @Override
    void correr() {
        println "pessoa " + nome + " correndo"
    }
}

