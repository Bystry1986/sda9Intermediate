package bookStore;

import java.util.List;
import java.util.Optional;

public interface CategorySources {
    void updateCategory(Category category);

    List<Category> findCategoriesByName(String name);
    List<Category> getCategories();
    Optional<Category> findCategoryById(Integer id);
}
