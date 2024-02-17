
package component;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class DList<E extends Object> extends JList<E>{
    private final DefaultListModel model;
    public DList() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
    }

    @Override
    public ListCellRenderer getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                ModelMenu data;
                if (value instanceof ModelMenu) {
                    data = (ModelMenu) value;
                } else {
                    data = new ModelMenu("No Data", "song");
                }
                ItemMenu item = new ItemMenu(data);
                item.setSelected(isSelected);
                return item;
            }
            
        }; 
    }
    
    public void addItem(ModelMenu data) {
        model.addElement(data);
    }
}
