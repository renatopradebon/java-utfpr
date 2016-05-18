package manipulaobjeto;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renato Pradebon
 */
public class JanelaCliente extends javax.swing.JFrame {

    private Cliente cliente = null;
    private ManipulaObjeto manipulaObjeto = null;

    /**
     * Creates new form JanelaCliente
     */
    public JanelaCliente() {
        manipulaObjeto = new ManipulaObjeto();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBtnNovo = new javax.swing.JButton();
        jBtnFechar = new javax.swing.JButton();
        jTFNome = new javax.swing.JTextField();
        jTFFone = new javax.swing.JTextField();
        jSIdade = new javax.swing.JSpinner();
        jBtnGravar = new javax.swing.JButton();
        jBtnProximo = new javax.swing.JButton();
        jBtnAnterior = new javax.swing.JButton();
        jBtnLimparLista = new javax.swing.JButton();
        jBtnCarregarLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Fone:");

        jLabel3.setText("Idade:");

        jBtnNovo.setText("Novo");
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });

        jBtnFechar.setText("Fechar");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecharActionPerformed(evt);
            }
        });

        jBtnGravar.setText("Gravar");
        jBtnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGravarActionPerformed(evt);
            }
        });

        jBtnProximo.setText("Proximo");
        jBtnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnProximoActionPerformed(evt);
            }
        });

        jBtnAnterior.setText("Anterior");
        jBtnAnterior.setActionCommand("");
        jBtnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAnteriorActionPerformed(evt);
            }
        });

        jBtnLimparLista.setLabel("Limpar Lista");
        jBtnLimparLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparListaActionPerformed(evt);
            }
        });

        jBtnCarregarLista.setLabel("Carregar Lista");
        jBtnCarregarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCarregarListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 194, Short.MAX_VALUE))
                            .addComponent(jTFNome)
                            .addComponent(jTFFone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jBtnLimparLista)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBtnAnterior)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnProximo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnCarregarLista))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnGravar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnProximo)
                    .addComponent(jBtnAnterior)
                    .addComponent(jBtnCarregarLista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnLimparLista)
                    .addComponent(jBtnFechar))
                .addGap(6, 6, 6))
        );

        setSize(new java.awt.Dimension(499, 245));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        limparTela();
        jTFNome.requestFocus();
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecharActionPerformed
        if (manipulaObjeto != null) {
            manipulaObjeto.fecharArquivo();
        }
        System.exit(0);
    }//GEN-LAST:event_jBtnFecharActionPerformed

    private void jBtnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGravarActionPerformed
        cliente = new Cliente(jTFNome.getText(), jTFFone.getText(), (Integer) jSIdade.getValue());
        manipulaObjeto.GravaCliente(cliente);
    }//GEN-LAST:event_jBtnGravarActionPerformed

    private void jBtnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnProximoActionPerformed
        leitorBotaoProximo();
    }//GEN-LAST:event_jBtnProximoActionPerformed

    private void jBtnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAnteriorActionPerformed
        try {
            cliente = manipulaObjeto.lerRegistroAnterior();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JanelaCliente.class.getName()).log(Level.SEVERE, null, ex);

        }
        atualizarTela();
    }//GEN-LAST:event_jBtnAnteriorActionPerformed

    private void jBtnLimparListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparListaActionPerformed
        destroiObjetos();
        limparTela();
    }//GEN-LAST:event_jBtnLimparListaActionPerformed

    private void jBtnCarregarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCarregarListaActionPerformed
        leitorBotaoProximo();
    }//GEN-LAST:event_jBtnCarregarListaActionPerformed

    public void limparTela() {
        jTFNome.setText("");
        jTFFone.setText("");
        jSIdade.setValue((Integer) 18);
    }

    public void atualizarTela() {
        if (cliente != null && cliente.getNome() != null) {
            jTFNome.setText(cliente.getNome());
            jTFFone.setText(cliente.getFone());
            jSIdade.setValue((Integer) cliente.getIdade());
        }
    }

    public void destroiObjetos() {
        cliente = null;
        manipulaObjeto = new ManipulaObjeto();
    }

    public void leitorBotaoProximo() {
        try {
            cliente = manipulaObjeto.lerRegistro();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JanelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizarTela();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JanelaCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAnterior;
    private javax.swing.JButton jBtnCarregarLista;
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnGravar;
    private javax.swing.JButton jBtnLimparLista;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnProximo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jSIdade;
    private javax.swing.JTextField jTFFone;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables
}
