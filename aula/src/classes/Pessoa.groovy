package classes

// O plugin de eclipse de groovy n�o sabe tratar trait, ele vai pensar que � uma interface
// se vc mandar o eclipse implementar ele vai gerar todas as implementa��es....
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

