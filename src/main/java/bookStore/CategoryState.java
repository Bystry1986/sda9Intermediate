package bookStore;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryState {
    private boolean open;
    private boolean selected;
    private boolean disabled;

    public CategoryState(boolean open, boolean selected, boolean disabled) {
        this.open = open;
        this.selected = selected;
        this.disabled = disabled;
    }
}
