package HW;

public class Main {

    public static void main(String[] args) {
        boolean result = Validator.validate("login_12345", "qwerty_123", "qwerty_123");
        if (result) {
            System.out.println("Логин и пароль корректные");
        } else {
            System.out.println("Логин и/или пароль не корректные");
        }
    }
}