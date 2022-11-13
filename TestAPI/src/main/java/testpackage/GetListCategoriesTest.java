package testpackage;

import constant.MessageConstant;
import constant.ResponseCodeConstant;
import model.request.GetListCategoriesRequest;
import model.request.LoginRequest;
import model.response.GetListCategoriesResponse;
import model.response.LoginResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class GetListCategoriesTest {

    public static final String EMAIL = "sangnt@gmail.com";
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


    public GetListCategoriesResponse getResult(GetListCategoriesRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        GetListCategoriesResponse response = (GetListCategoriesResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(GetListCategoriesRequest request, GetListCategoriesResponse responseExpected) throws IOException {
        GetListCategoriesResponse response = getResult(request);
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
    public void test() throws IOException {
        String token = getANewToken();
        GetListCategoriesRequest request = new GetListCategoriesRequest();
        request.setAccess_token(token);

        GetListCategoriesResponse response = new GetListCategoriesResponse();
        response.setCode(ResponseCodeConstant.OK_CODE);
        response.setMessage(MessageConstant.OK);

        testAUnitTest(request,response);
    }

}
