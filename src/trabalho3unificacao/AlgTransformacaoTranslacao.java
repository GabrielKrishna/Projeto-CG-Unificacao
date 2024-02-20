package trabalho3unificacao;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class AlgTransformacaoTranslacao extends JFrame {

    AlgTransformacaoTranslacao() {
        this.setTitle("Transformações - Translação");
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
                        transformaTranslada();
                        repaint();
                    } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                        transformaTransladaInversa();
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

        public void transformaTranslada() {
            mr = new double[li][ci];

            mr[0][0] = (mi[0][0] + tx);
            mr[0][1] = (mi[0][1] + ty);

            mr[1][0] = (mi[1][0] + tx);
            mr[1][1] = (mi[1][1] + ty);

            mr[2][0] = (mi[2][0] + tx);
            mr[2][1] = (mi[2][1] + ty);

            pushMatrix();

        }

        public void transformaTransladaInversa() {
            mr = new double[li][ci];

            mr[0][0] = (mi[0][0] - tx); // subtraindo tx ao invés de somar
            mr[0][1] = (mi[0][1] - ty); // subtraindo ty ao invés de somar

            mr[1][0] = (mi[1][0] - tx); // subtraindo tx ao invés de somar
            mr[1][1] = (mi[1][1] - ty); // subtraindo ty ao invés de somar

            mr[2][0] = (mi[2][0] - tx); // subtraindo tx ao invés de somar
            mr[2][1] = (mi[2][1] - ty); // subtraindo ty ao invés de somar

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
            g.setColor(Color.cyan);
            poly = new Polygon();
            for (int i = 0; i < mi.length; i++) {
                poly.addPoint((int) mi[i][0], (int) mi[i][1]);
            }
            g.fillPolygon(poly);

        }

    }

}
