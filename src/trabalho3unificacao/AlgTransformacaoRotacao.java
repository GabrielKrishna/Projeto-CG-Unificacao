package trabalho3unificacao;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class AlgTransformacaoRotacao extends JFrame {

    AlgTransformacaoRotacao() {
        this.setTitle("Transformações - Rotação");
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
                        sentidoHorario();
                        repaint();
                    } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                        sentidoAntiHorario();
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

        public void sentidoHorario() {
            lt = 2;
            ct = 2;
            mr = new double[li][ct];

            double cos = Math.cos(ang);
            double sen = Math.sin(ang);

            // Encontre o centro do polígono
            double cx = 0, cy = 0;
            for (int i = 0; i < li; i++) {
                cx += mi[i][0];
                cy += mi[i][1];
            }
            cx /= li;
            cy /= li;

            for (int i = 0; i < li; i++) {
                double dx = mi[i][0] - cx;
                double dy = mi[i][1] - cy;

                // Rotacione as coordenadas
                mr[i][0] = cx + (dx * cos - dy * sen);
                mr[i][1] = cy + (dx * sen + dy * cos);
            }

            pushMatrix();
        }

        public void sentidoAntiHorario() {
            lt = 2;
            ct = 2;
            mr = new double[li][ct];

            double cos = Math.cos(ang);
            double sen = -Math.sin(ang);

            // Encontre o centro do polígono
            double cx = 0, cy = 0;
            for (int i = 0; i < li; i++) {
                cx += mi[i][0];
                cy += mi[i][1];
            }
            cx /= li;
            cy /= li;

            for (int i = 0; i < li; i++) {
                double dx = mi[i][0] - cx;
                double dy = mi[i][1] - cy;

                // Rotacione as coordenadas
                mr[i][0] = cx + (dx * cos - dy * sen);
                mr[i][1] = cy + (dx * sen + dy * cos);
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
            g.setColor(Color.orange);
            poly = new Polygon();
            for (int i = 0; i < mi.length; i++) {
                poly.addPoint((int) mi[i][0], (int) mi[i][1]);
            }
            g.fillPolygon(poly);

        }

    }

}
