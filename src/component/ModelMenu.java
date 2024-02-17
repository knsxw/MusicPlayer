
package component;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class ModelMenu {
    private String menuName;
    private String icon;

    public ModelMenu(String menuName, String icon) {
        this.menuName = menuName;
        this.icon = icon;
    }
    
    

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/icons/"+icon+".png"));
    }
    
    public Icon toIconSelected() {
        return new ImageIcon(getClass().getResource("/icons/"+icon+"_selected.png"));
    }
}
