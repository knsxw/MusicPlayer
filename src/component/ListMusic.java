
package component;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ListMusic<E extends Object> extends JList<E>{
    private final DefaultListModel model;
    private int playIndex = -1;
    public ListMusic() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    playIndex = locationToIndex(e.getPoint());
                    repaint();
                }
                
            }
            
        });
    }

    @Override
    public ListCellRenderer getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                ModelMusic data;
                if (value instanceof ModelMusic) {
                    data = (ModelMusic) value;
                } else {
                    data = new ModelMusic("1","No Music", "00:00");
                }
                ItemMusic item = new ItemMusic(data);
                item.setPlay(index == playIndex);
                return item;
            }
            
        }; 
    }
    
    public void addItem(ModelMusic data) {
        model.addElement(data);
    }
}
