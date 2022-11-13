package testpackage;

import constant.MessageConstant;
import constant.ResponseCodeConstant;
import model.request.LoginRequest;
import model.request.LogoutRequest;
import model.response.LoginResponse;
import model.response.LogoutResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class LogoutTest {
    public static final String EMAIL = "hoangnt4@gmail.com";
    public static final String PASSWORD = "123456";

    public String getANewToken() throws IOException {
        LoginTest loginTest = new LoginTest();

        LoginRequest request = new LoginRequest();
        request.setEmail(EMAIL);
        request.setPassword(PASSWORD);

        LoginResponse loginResponse = loginTest.getResult(request);
        System.out.println(loginResponse.getData().getAccess_token());

        return loginResponse.getData().getAccess_token();
    }

    public LogoutResponse getResult(LogoutRequest request) throws IOException {

        System.out.println(request.getUrl_string());

        LogoutResponse response = (LogoutResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(LogoutRequest request, LogoutResponse responseExpected) throws IOException {
        LogoutResponse response = getResult(request);

        System.out.println("Expected :");
        System.out.println(responseExpected.getCode());
        System.out.println(responseExpected.getMessage());

        System.out.println("Actual :");
        if (response == null)
            System.out.println("null");

        assert (response != null);

        String code = response.getCode();
        String message = response.getMessage();
        System.out.println(code);
        System.out.println(message);

        assert (code.equals(responseExpected.getCode()));
        assert (message.equals(responseExpected.getMessage()));

    }

    @Test
    public void test1() throws IOException {
        String token = getANewToken();

        LogoutRequest request = new LogoutRequest();
        request.setAccess_token(token);

        LogoutResponse response = new LogoutResponse();
        response.setCode(ResponseCodeConstant.OK_CODE);
        response.setMessage(MessageConstant.OK);

        testAUnitTest(request, response);

    }

    @Test
    public void test2() throws IOException {
        String token = getANewToken();

        LogoutRequest request = new LogoutRequest();
        request.setAccess_token(token);

        LogoutResponse response = new LogoutResponse();
        response.setCode(ResponseCodeConstant.OK_CODE);
        response.setMessage(MessageConstant.OK);

        testAUnitTest(request, response);

        response = new LogoutResponse();
        response.setCode(ResponseCodeConstant.NOT_LOGGED_IN);
        response.setMessage(MessageConstant.NOT_LOGGED_IN);

        testAUnitTest(request, response);
    }

    @Test
    public void test3() throws IOException {

        LogoutRequest request = new LogoutRequest();
        request.setAccess_token("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9uLWFwcDMuaGVyb2t1YXBwLmNvbVwvYXBpXC9sb2dpbiIsImlhdCI6MTY1NjE1NDU2NiwiZXhwIjoxNjU2NTE0NTY2LCJuYmYiOjE2NTYxNTQ1NjYsImp0aSI6IjFHSFdrOUlhc0RFSTFmNUEiLCJzdWIiOjk5LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.OTVe6xIKCLUCLiS2mD_8NYFj1LEAgRBvlUj5vov_02Q");

        LogoutResponse response = new LogoutResponse();
        response.setCode(ResponseCodeConstant.OK_CODE);
        response.setMessage(MessageConstant.OK);

        testAUnitTest(request, response);

    }

    @ParameterizedTest
    @CsvSource({
            "abc,1004,まだログインではありません",
            ",1004,まだログインではありません",
            "\'%20%20\',1004,まだログインではありません",
    })
    public void test(String token, String codeExpected, String messageExpected) throws IOException {

        LogoutRequest request = new LogoutRequest();
        request.setAccess_token(token);

        LogoutResponse response = new LogoutResponse();
        response.setCode(codeExpected);
        response.setMessage(messageExpected);

        testAUnitTest(request, response);

    }
}
