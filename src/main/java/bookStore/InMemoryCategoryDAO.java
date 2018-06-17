package bookStore;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

//Data Acess Object - DAO
//Data Transfer Object - DTO

public class InMemoryCategoryDAO {

    public List<Category> initializeCategories() {
        List<String> linesFromFile = null;
        try {
            linesFromFile = Files.readAllLines(Paths.get("/home/bystry/IdeaProjects/sda9intermediate/src/main/resources/kategorie.txt"), Charset.forName(("UTF-16")));
        } catch (IOException e) {
            e.printStackTrace();
        }
      return   populateCategories(linesFromFile);
    }

    private List<Category> populateCategories(List<String> linesFromFile) {
        AtomicInteger idCounter = new AtomicInteger(1);
        List<Category> categoryList = linesFromFile.stream()
                .map(e -> new Category(idCounter.getAndIncrement(), e))
                .collect(Collectors.toList());
        Map<Integer, List<Category>> categoryMap = categoryList.stream()
                .collect(Collectors.groupingBy(e -> countSpaces(e)));
        populateRecursive(0, categoryMap);
        categoryList.forEach(category -> category.setName(category.getName().trim()));
        return categoryList;
    }

    private void populateRecursive(int level, Map<Integer, List<Category>> categoryMap) {
        List<Category> categories = categoryMap.get(level);
        if (categories == null) {
            return;
        } else {
            for (Category category : categories) {
                if (level == 0) {
                    category.setParentID(null);
                } else {
                    Integer parentID = categoryMap.get(level - 1).stream()
                            .map(e -> e.getId())
                            .filter(e -> e < category.getId())
                            .sorted(Comparator.reverseOrder())
                            .findFirst()
                            .get();
                    category.setParentID(parentID);
                }
            }
            populateRecursive(level + 1, categoryMap);
        }
    }

    private int countSpaces(Category category) {
        return category.getName().startsWith(" ") ?
                category.getName().split("\\S")[0].length() : 0;
    }
}
