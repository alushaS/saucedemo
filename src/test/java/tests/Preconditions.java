package tests;

import entity.User;

public class Preconditions extends BaseTest{

    public static User userWithCorrectCredentials = User.builder()
            .userName(USER_NAME)
            .password(PASSWORD)
            .build();

    public static User userWithEmptyUsername = User.builder()
            .userName("")
            .password(PASSWORD)
            .build();


    public static User userWithEmptyPassword = User.builder()
            .userName(USER_NAME)
            .password("")
            .build();

    public static User userWithEmptyFields = User.builder()
            .userName("")
            .password("")
            .build();

    public static User userWithIncorrectFields = User.builder()
            .userName("gdfgdfg")
            .password("dfgfdg")
            .build();


}
