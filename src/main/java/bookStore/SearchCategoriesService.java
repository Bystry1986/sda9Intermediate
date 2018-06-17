package bookStore;

import java.util.List;

public class SearchCategoriesService {
    CategorySources source = InMemoryCategoryDAO.getInstance();

    public List<Category> filterCategories(){
        source.getCategories();
    }
}
