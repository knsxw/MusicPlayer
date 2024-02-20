
package component;


public class MostPopular extends javax.swing.JPanel {

    
    public MostPopular() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sPane = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        sBar = new javax.swing.JScrollBar();

        setBackground(new java.awt.Color(255, 255, 255));

        sPane.setBorder(null);
        sPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sPane.setHorizontalScrollBar(sBar);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        sPane.setViewportView(panel);

        sBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sBar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(sPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addImage(ModelPopular data) {
        ItemImage item = new ItemImage();
        item.setData(data);
        panel.add(item);
        panel.repaint();
        panel.revalidate();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private javax.swing.JScrollBar sBar;
    private javax.swing.JScrollPane sPane;
    // End of variables declaration//GEN-END:variables
}
