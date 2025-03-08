package tests;

import entity.User;

public class Preconditions extends BaseTest{

    protected final User userWithCorrectCredentials = User.builder()
            .userName(USER_NAME)
            .password(PASSWORD)
            .build();

    protected final User userWithEmptyUsername = User.builder()
            .userName("")
            .password(PASSWORD)
            .build();


    protected final User userWithEmptyPassword = User.builder()
            .userName(USER_NAME)
            .password("")
            .build();

    protected final User userWithEmptyFields = User.builder()
            .userName("")
            .password("")
            .build();

    protected final User userWithIncorrectFields = User.builder()
            .userName("gdfgdfg")
            .password("dfgfdg")
            .build();


}
