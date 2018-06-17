package bookStore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminCategoryDTO implements CategoryInfoHolder {
    private String id;
    private String text;

}
