package testpackage;

import constant.MessageConstant;
import constant.ResponseCodeConstant;
import model.request.SliderRequest;
import model.request.LoginRequest;

import model.response.SliderResponse;
import model.response.LoginResponse;

import org.junit.jupiter.api.Test;


import java.io.IOException;

public class SliderTest {

    private static String token;
    static {
        try {
            token = getANewToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String EMAIL = "vubl@gmail.com";
    public static final String PASSWORD = "753951";

    public static String getANewToken() throws IOException {
        LoginTest loginTest = new LoginTest();

        LoginRequest request = new LoginRequest();
        request.setEmail(EMAIL);
        request.setPassword(PASSWORD);

        LoginResponse loginResponse = loginTest.getResult(request);
        System.out.println(loginResponse.getData().getAccess_token());

        return loginResponse.getData().getAccess_token();
    }

    public SliderResponse getResult(SliderRequest request) throws IOException {

        System.out.println(request.getUrl_string());

        SliderResponse response = (SliderResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(SliderRequest request, SliderResponse responseExpected) throws IOException {
        SliderResponse response = getResult(request);

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
    public void test_no_token() throws IOException {

        SliderRequest request = new SliderRequest();
        request.setAccess_token(null);

        SliderResponse response = new SliderResponse();
        response.setCode(ResponseCodeConstant.OK_CODE);
        response.setMessage(MessageConstant.OK);

    }

    @Test
    public void test_has_token() throws IOException {
        String token = getANewToken();

        SliderRequest request = new SliderRequest();
        request.setAccess_token(token);

        SliderResponse response = new SliderResponse();
        response.setCode(ResponseCodeConstant.OK_CODE);
        response.setMessage(MessageConstant.OK);

        testAUnitTest(request, response);

    }

}