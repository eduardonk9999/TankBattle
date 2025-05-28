package org.example;

import javax.swing.*;
import java.awt.*;

public class AnimacaoTela extends JFrame {
    private JPanel tela;
    private int fps = 1000 / 20; //50
    private int ct; //contador
    private boolean anima = true;

    public void iniciaAnimacao() {
        long prxAtualizacao = 0;

        while (anima) {
            if (System.currentTimeMillis() >= prxAtualizacao) {
                ct++;
                tela.repaint();

                prxAtualizacao = System.currentTimeMillis() + fps;

                if (ct == 100) {
                    anima = false;
                }
            }
        }
    }

    public AnimacaoTela() {
        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                // Limpando os desenhos anteriores
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, tela.getWidth(), tela.getWidth());

            }
        };
    }
}
