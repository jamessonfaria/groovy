package classes

import java.awt.FlowLayout

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane

class Tela extends JFrame {
    public Tela() {
        setTitle("Tela")
        setSize(200, 200)
        def botao = new JButton("Clique Aqui")
        getContentPane().setLayout(new FlowLayout())
        add(botao)
        // preenchendo uma interface via clousure = pattern strategy
        botao.addActionListener({e-> JOptionPane.showMessageDialog(null, "Foi via closure")})
    }
}

