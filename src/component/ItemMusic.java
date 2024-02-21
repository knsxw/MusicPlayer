
package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;


public class ItemMusic extends javax.swing.JPanel {

    public boolean isPlay() {
        return play;
    }


    private final ModelMusic data;
    private boolean play;
    public void setPlay(boolean play) {
        this.play = play;
        if (play){
            lbIcon.setText("");
            lbIcon.setIcon(new ImageIcon(getClass().getResource("/icons/playing.png")));
            lbText.setFont(new java.awt.Font("SansSerif", 1, 14));
            lbText.setForeground(new Color(203, 30, 148));
            lbTime.setFont(new java.awt.Font("SansSerif", 1, 14));
            lbTime.setForeground(new Color(203, 30, 148));
        } else {
            lbIcon.setIcon(null);
            lbIcon.setText(data.getNo());
            lbText.setFont(new java.awt.Font("SansSerif", 0, 14));
            lbText.setForeground(new Color(51, 51, 51));
            lbTime.setFont(new java.awt.Font("SansSerif", 0, 14));
            lbTime.setForeground(new Color(51, 51, 51));
        }
    }
    public ItemMusic(ModelMusic data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        lbText.setText(data.getName());
        lbTime.setText(data.getTime());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbText = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(300, 40));

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbText.setForeground(new java.awt.Color(51, 51, 51));
        lbText.setText("Music Name");

        lbTime.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbTime.setForeground(new java.awt.Color(51, 51, 51));
        lbTime.setText("03:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lbText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTime)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(lbText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        if (play){
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(246,246,246));
            g2.fillRect(0, getHeight() -2, getWidth(), getHeight());
        }
        super.paintComponent(g); 
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbTime;
    // End of variables declaration//GEN-END:variables
}
