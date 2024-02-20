
package component;

import javax.swing.Icon;


public class ModelPopular {
    private Icon image;
    private String title;
    private String description;

    public ModelPopular(Icon image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
