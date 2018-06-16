package bookStore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class InMemoryCategoryDAOTest {
    @Test
    void shouldReturnCategoriesFromText() {
        //given
        InMemoryCategoryDAO inMemoryCategoryDAO = new InMemoryCategoryDAO();
        Category kat1;
        Category kat2;
        Category kat3;
        Integer expectedParentID1 = null;
        Integer expectedParentID2 = 1;
        Integer expectedParentID3 = 2;
        String expectedNameID1 = "Książki";
        String expectedNameID2 = "Powieści";
        String expectedNameID3 = "Fantastyka";
        //when
        List<Category> list = inMemoryCategoryDAO.initializeCategories();
        kat1 = list.stream()
                .filter(e -> e.getId().equals(1))
                .findFirst()
                .get();
        Integer actualParentID1 = kat1.getParentID();
        String actualName1 = kat1.getName();
        kat2 = list.stream()
                .filter(e -> e.getId().equals(2))
                .findFirst()
                .get();
        Integer actualParentID2 = kat2.getParentID();
        String actualName2 = kat2.getName();
        kat3 = list.stream()
                .filter(e -> e.getId().equals(3))
                .findFirst()
                .get();
        Integer actualParentID3 = kat3.getParentID();
        String actualName3 = kat3.getName();
        //then
        Assertions.assertEquals(actualParentID1, expectedParentID1);
        Assertions.assertEquals(actualParentID2, expectedParentID2);
        Assertions.assertEquals(actualParentID3, expectedParentID3);
        Assertions.assertEquals(actualName1, expectedNameID1);
        Assertions.assertEquals(actualName2, expectedNameID2);
        Assertions.assertEquals(actualName3, expectedNameID3);
    }
}

