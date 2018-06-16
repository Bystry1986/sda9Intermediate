package bookStore;

import lombok.Getter;
import lombok.Setter;

//Dzięki temu nie musimy generować getterów i setterów
//robi to kompilator w trakcie kompilacji
//naależy wcześniej dodać bibliotekę lombok w pom (maven)
@Getter
@Setter

public class Category {
    private Integer id;
    private String name;
    private Integer parentID;

}
