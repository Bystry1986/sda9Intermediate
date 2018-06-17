package bookStore;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchCategoriesService {
    CategorySources source = InMemoryCategoryDAO.getInstance();

    public List<AdminCategoryDTO> filterCategories(String searchCategoryText) {
        return source.getCategories().stream()
                .map(category -> buildAdminCategoryDTO(category))
                .peek(e -> e
                        .setParent(buildParent(e).map(m -> buildAdminCategoryDTO(m)).orElse(null)))
                .peek(e -> {
                    if (e.getText().equals(searchCategoryText)) {
                        e.getState().setSelected(true);
                        e.getState().setOpen(true);
                        openParents(e);
                    }
                })
                .collect(Collectors.toList());
    }

    private Optional<Category> buildParent(AdminCategoryDTO child) {
        if(child.getParentCategoryId() == null){
            return Optional.empty();
        }
        return source.findCategoryById(Integer.valueOf(child.getId()));
    }

    private AdminCategoryDTO buildAdminCategoryDTO(Category category) {
        return AdminCategoryDTO.builder()
                .id(category.getId().toString())
                .parentCategoryId(category.getParentID().toString())
                .text(category.getName())
                .state(new CategoryState())
                .build();
    }

    private void openParents(AdminCategoryDTO child) {
        AdminCategoryDTO parent = child.getParent();
        if (parent == null) {
            return;
        }
        parent.getState().setOpen(true);
        openParents(parent);
    }
}
