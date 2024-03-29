
package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class ItemMenu extends javax.swing.JPanel {

    
    public boolean isSelected() {
        return selected;
    }

    private final ModelMenu data;
    private boolean selected;
    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected){
            lbText.setFont(new java.awt.Font("SansSerif", 1, 14));
            lbText.setForeground(Color.WHITE);
            lbIcon.setIcon(data.toIconSelected());
        } else {
            lbText.setFont(new java.awt.Font("SansSerif", 0, 14));
            lbText.setForeground(new Color(204,204,204));
            lbIcon.setIcon(data.toIcon());
        }
    }
    public ItemMenu(ModelMenu data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        lbIcon.setIcon(data.toIcon());
        lbText.setText(data.getMenuName());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbText = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(300, 40));

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/albums_selected.png"))); // NOI18N

        lbText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbText.setForeground(new java.awt.Color(255, 255, 255));
        lbText.setText("Item Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lbText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(lbText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        if (selected){
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.WHITE);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillRect(0, 0, 2, getHeight());
        }
        super.paintComponent(g); 
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbText;
    // End of variables declaration//GEN-END:variables
}
