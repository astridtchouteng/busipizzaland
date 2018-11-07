package be.busi.pizzaland.model;

public enum RoleEnum {

    ROLE_1("ROLE_ADMIN"),
    ROLE_2("ROLE_USER");

    private String role;

    private RoleEnum(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
