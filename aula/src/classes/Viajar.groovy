package classes

class Viajar {
    void viajar(String destino, BigDecimal valor) {
        valor += 0.50 // taxa
        println "Viagem at� $destino custa $valor"
    }
}

