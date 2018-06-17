package bookStore;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AdminCategoryDTO implements CategoryInfoHolder {
    private String id;
    private String text;
    private AdminCategoryDTO parent;
    private String parentCategoryId;
    private CategoryState state;

}
