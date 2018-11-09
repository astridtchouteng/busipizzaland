package be.busi.pizzaland.exception;

public class UserExistsException extends Exception {

    @Override
    public String getMessage() {
        return "Choice un autre username";
    }
}
