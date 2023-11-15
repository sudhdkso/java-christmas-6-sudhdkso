package christmas.domain;

import christmas.domain.enums.MenuType;
import java.util.Objects;

public class Menu {
    private final String name;
    private final MenuType menuType;
    private final int amount;

    public Menu(String name, MenuType menuType, int amount) {
        this.name = name;
        this.menuType = menuType;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public boolean isMenuType(MenuType anotherMenuType) {
        return menuType.equals(anotherMenuType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, menuType, amount);
    }
}
