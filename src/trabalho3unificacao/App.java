package trabalho3unificacao;

import javax.swing.JOptionPane;

public class App extends javax.swing.JFrame {

    AlgRecorteLinhas algRecorteLinhas;
    AlgRecortePoligonos algRecortePoligonos;
    AlgCurvaBezier algCurvaBezier;
    AlgCurvaBSpline algCurvaBSpline;
    AlgTransformacaoTranslacao algTransformacaoTranslacao;
    AlgTransformacaoEscala algTransformacaoEscala;
    AlgTransformacaoRotacao algTransformacaoRotacao;
    private javax.swing.JMenu Limpar;
    private javax.swing.JMenuItem curvasBezier;
    private javax.swing.JMenuItem curvasSpilne;
    private javax.swing.JMenuItem limparFechar;
    private javax.swing.JMenuItem recortesPoli;
    private javax.swing.JMenuItem recortesRetas;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCurvas;
    private javax.swing.JMenu menuRecortes;
    private javax.swing.JMenu menuTransf;
    private javax.swing.JMenuItem transformacaoEscala;
    private javax.swing.JMenuItem transformacaoRota;
    private javax.swing.JMenuItem transformacaoTransl;

    int valor;

    public App() {
        menuBar = new javax.swing.JMenuBar();
        menuRecortes = new javax.swing.JMenu();
        recortesRetas = new javax.swing.JMenuItem();
        recortesPoli = new javax.swing.JMenuItem();
        menuCurvas = new javax.swing.JMenu();
        curvasBezier = new javax.swing.JMenuItem();
        curvasSpilne = new javax.swing.JMenuItem();
        menuTransf = new javax.swing.JMenu();
        transformacaoTransl = new javax.swing.JMenuItem();
        transformacaoEscala = new javax.swing.JMenuItem();
        transformacaoRota = new javax.swing.JMenuItem();
        Limpar = new javax.swing.JMenu();
        limparFechar = new javax.swing.JMenuItem();

        setTitle("Trabalho 3 CG - Unificação de Algoritmos");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        menuRecortes.setText("Recortes");

        recortesRetas.setText("Linhas Retas");
        recortesRetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linhasRetasActionPerformed(evt);
            }
        });
        menuRecortes.add(recortesRetas);

        recortesPoli.setText("Polígonos");
        recortesPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linhasPoliActionPerformed(evt);
            }
        });
        menuRecortes.add(recortesPoli);

        menuBar.add(menuRecortes);

        menuCurvas.setText("Curvas");

        curvasBezier.setText("Bézier");
        curvasBezier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curvasBezierActionPerformed(evt);
            }
        });
        menuCurvas.add(curvasBezier);

        curvasSpilne.setText("B-Spilne");
        curvasSpilne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curvasSpilneActionPerformed(evt);
            }
        });
        menuCurvas.add(curvasSpilne);

        menuBar.add(menuCurvas);

        menuTransf.setText("Transformações");

        transformacaoTransl.setText("Translação");
        transformacaoTransl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transfTranslActionPerformed(evt);
            }
        });
        menuTransf.add(transformacaoTransl);

        transformacaoEscala.setText("Escala");
        transformacaoEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transfEscalaActionPerformed(evt);
            }
        });
        menuTransf.add(transformacaoEscala);

        transformacaoRota.setText("Rotação");
        transformacaoRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transfRotActionPerformed(evt);
            }
        });
        menuTransf.add(transformacaoRota);

        menuBar.add(menuTransf);

        Limpar.setText("Limpar");

        limparFechar.setText("Fechar janelas");
        limparFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFecharActionPerformed(evt);
            }
        });
        Limpar.add(limparFechar);

        menuBar.add(Limpar);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 497, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 288, Short.MAX_VALUE)
        );
    }

    public void fecharTodasJanelas() {
        for (java.awt.Window window : java.awt.Window.getWindows()) {
            if (window instanceof javax.swing.JFrame && window != this) {
                window.dispose();
            }
        }
    }

    private void linhasRetasActionPerformed(java.awt.event.ActionEvent evt) {
        algRecorteLinhas = new AlgRecorteLinhas();
    }

    private void linhasPoliActionPerformed(java.awt.event.ActionEvent evt) {
        algRecortePoligonos = new AlgRecortePoligonos();
    }

    private void curvasBezierActionPerformed(java.awt.event.ActionEvent evt) {
        valor = Integer.parseInt(JOptionPane.showInputDialog("Infome quantos pontos de controles:"));
        algCurvaBezier = new AlgCurvaBezier(valor);

    }

    private void curvasSpilneActionPerformed(java.awt.event.ActionEvent evt) {

        valor = Integer.parseInt(JOptionPane.showInputDialog("Informe quantos pontos de controles:"));
        algCurvaBSpline = new AlgCurvaBSpline(valor);
    }

    private void transfTranslActionPerformed(java.awt.event.ActionEvent evt) {
        algTransformacaoTranslacao = new AlgTransformacaoTranslacao();
    }

    private void transfEscalaActionPerformed(java.awt.event.ActionEvent evt) {
        algTransformacaoEscala = new AlgTransformacaoEscala();
    }

    private void transfRotActionPerformed(java.awt.event.ActionEvent evt) {
        algTransformacaoRotacao = new AlgTransformacaoRotacao();
    }

    private void limparFecharActionPerformed(java.awt.event.ActionEvent evt) {
        fecharTodasJanelas();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }
}
