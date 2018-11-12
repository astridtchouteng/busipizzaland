package be.busi.pizzaland.model;

public enum CategorieEnum {

    MAGHERITA("MAGHERITA"),
    TRADIZIONALE("TRADIZIONALE"),
    NAPOLITAINE("NAPOLITAINE"),
    MARINARA("MARINARA"),
    QUATRES_SAISONS("QUATRES_SAISONS"),
    HAWAIENNE("HAWAIENNE");

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
