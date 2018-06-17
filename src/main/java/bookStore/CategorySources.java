package bookStore;

import java.util.List;

public interface CategorySources {
    void updateCategory(Category category);

    List<Category> findCategoriesByName(String name);
    List<Category> getCategories();
    Category findCategoryById(Integer id);
}
