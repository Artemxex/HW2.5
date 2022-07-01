package HW;

public class Validator {
    private static final String VALID_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";


    private Validator() {

    }

    public static boolean validate(String login,
                                   String password,
                                   String confirmPassword) {
        try {
            checkUsingLoop(login, password, confirmPassword);
            return true;
        } catch (WrongLoginExeption | WrongPasswordExeption e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void checkUsingLoop(String login,
                                       String password,
                                       String confirmPassword) throws WrongLoginExeption, WrongPasswordExeption {
        if (login == null || login.length() > 20) {
            throw new WrongLoginExeption("Длинна логина должна быть меньше или равной 20 символов!");
        }
        if (password == null || !password.equals(confirmPassword)) {
            throw new WrongPasswordExeption("Пароли должны совпадать!");
        }
        if (password.length() > 20) {
            throw new WrongPasswordExeption("Длинна пароля должна быть меньше 20 символов!");
        }
        checkCharacters(login,"Логин");
        checkCharacters(password,"Пароль");
        }


    private static void checkCharacters(String s, String what) throws WrongLoginExeption {
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {
                throw new WrongLoginExeption(String.format("%s содержит неверный символ %c!", what, s.charAt(i)));
            }
        }
    }
}

