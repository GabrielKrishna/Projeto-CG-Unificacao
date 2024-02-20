package trabalho3unificacao;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class AlgTransformacaoEscala extends JFrame {

    AlgTransformacaoEscala() {
        this.setTitle("Transformações - Escala");
        this.setSize(500, 300);
        this.add("Center", new TransformaGeo());
        this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setAlwaysOnTop(true);
    }

    private static class TransformaGeo extends JComponent {

        Polygon poly;
        double tx = 1, ty = 1, ang = 0.1;
        double mi[][];
        double mt[][];
        double mr[][];
        int li, ci, lt, ct;

        public TransformaGeo() {
            iniciaMatrizes();
            setFocusable(true);
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent evt) {
                    if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                        aumentaEscala();
                        repaint();
                    } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                        diminuiEscala();
                        repaint();
                    }
                }
            });
            requestFocusInWindow();
        }

        private void iniciaMatrizes() {
            poly = new Polygon();

            li = 3;
            ci = 2;
            mi = new double[li][ci];
            mi[0][0] = 250;
            mi[0][1] = 70;
            mi[1][0] = 175;
            mi[1][1] = 200;
            mi[2][0] = 325;
            mi[2][1] = 200;

        }

        public void aumentaEscala() {
            // Calcular o centro do polígono
            double cx = 0, cy = 0;
            for (int i = 0; i < li; i++) {
                cx += mi[i][0];
                cy += mi[i][1];
            }
            cx /= li;
            cy /= li;

            // Subtrair as coordenadas do centro do polígono
            for (int i = 0; i < li; i++) {
                mi[i][0] -= cx;
                mi[i][1] -= cy;
            }

            // Aplicar a transformação de escala
            lt = 2;
            ct = 2;
            mt = new double[lt][ct];
            mt[0][0] = 1.5;
            mt[0][1] = 0;
            mt[1][0] = 0;
            mt[1][1] = 1.5;

            mr = new double[li][ct];
            for (int i = 0; i < li; i++) {
                mr[i][0] = (mi[i][0] * mt[0][0]) + (mi[i][1] * mt[0][1]);
                mr[i][1] = (mi[i][0] * mt[1][0]) + (mi[i][1] * mt[1][1]);
            }

            // Adicionar as coordenadas do centro de volta
            for (int i = 0; i < li; i++) {
                mr[i][0] += cx;
                mr[i][1] += cy;
            }

            pushMatrix();
        }

        public void diminuiEscala() {
            // Calcular o centro do polígono
            double cx = 0, cy = 0;
            for (int i = 0; i < li; i++) {
                cx += mi[i][0];
                cy += mi[i][1];
            }
            cx /= li;
            cy /= li;

            // Subtrair as coordenadas do centro do polígono
            for (int i = 0; i < li; i++) {
                mi[i][0] -= cx;
                mi[i][1] -= cy;
            }

            // Aplicar a transformação de escala
            lt = 2;
            ct = 2;
            mt = new double[lt][ct];
            mt[0][0] = 0.5;
            mt[0][1] = 0;
            mt[1][0] = 0;
            mt[1][1] = 0.5;

            mr = new double[li][ct];
            for (int i = 0; i < li; i++) {
                mr[i][0] = (mi[i][0] * mt[0][0]) + (mi[i][1] * mt[0][1]);
                mr[i][1] = (mi[i][0] * mt[1][0]) + (mi[i][1] * mt[1][1]);
            }

            // Adicionar as coordenadas do centro de volta
            for (int i = 0; i < li; i++) {
                mr[i][0] += cx;
                mr[i][1] += cy;
            }

            pushMatrix();
        }


        public void pushMatrix() {
            for (int i = 0; i < li; i++) {
                for (int j = 0; j < ci; j++) {
                    mi[i][j] = mr[i][j];
                }
            }
        }

        @Override
        public void paint(Graphics g) {
            g.setColor(Color.magenta);
            poly = new Polygon();
            for (int i = 0; i < mi.length; i++) {
                poly.addPoint((int) mi[i][0], (int) mi[i][1]);
            }
            g.fillPolygon(poly);
        }

    }

}
