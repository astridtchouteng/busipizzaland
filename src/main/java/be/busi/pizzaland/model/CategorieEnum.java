package be.busi.pizzaland.model;

public enum CategorieEnum {

    VEGETARIENNE("VEGETARIENNE"),
    FROMAGE("FROMAGE"),
    CUSTOMISEE("CUSTOMISEE"),
    EXOTIQUE("EXOTIQUE");

    private String name;

    private CategorieEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategorieEnum{" +
                "name='" + name + '\'' +
                '}';
    }
}
