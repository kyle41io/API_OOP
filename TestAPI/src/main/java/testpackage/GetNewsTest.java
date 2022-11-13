package testpackage;

import model.request.GetNewsRequest;
import model.request.LoginRequest;
import model.request.LogoutRequest;
import model.response.GetNewsResponse;
import model.response.LoginResponse;
import model.response.LogoutResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static constant.StringConstant.*;
import static constant.StringConstant.CHARACTERS_65;

public class GetNewsTest {

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

    public GetNewsResponse getResult(GetNewsRequest request) throws IOException {

        System.out.println(request.getUrl_string());

        GetNewsResponse response = (GetNewsResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(GetNewsRequest request, GetNewsResponse responseExpected) throws IOException {
        GetNewsResponse response = getResult(request);

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

    public final String[] indexx = {
            "1", "1", "ab", "2",
            "-10", "ab", "-500", "0", "0.7", "10", "10.5"

    };

    public final String[] count = {
            "1", "100", "cd",
            "100", "100", "10", "100", "50", "10.5", "-10", "10"

    };

    public final String[] codes = {
            "1000", "1000", " ",
            "1000", "1000", " ",
            "1000", "1000", "1000", "1000", "1000"
    };

    public final String[] messages = {
            "OK", "OK",
            " ", "OK", "OK", " ",
            "OK", "OK", "OK", "OK", "OK"
    };

    @ParameterizedTest
    @CsvSource({"0","1", "3", "5"
    })
    public void testSomeUnitTest(int index) throws IOException {
        GetNewsRequest request = new GetNewsRequest();
        request.setIndex(indexx[index]);
        request.setCount(count[index]);
        request.setAccess_token(token);

        GetNewsResponse response = new GetNewsResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3","4","5","6","7","8","9", "10"
    })
    public void testAllUnitTest(int index) throws IOException {
        GetNewsRequest request = new GetNewsRequest();
        request.setIndex(indexx[index]);
        request.setCount(count[index]);
        request.setAccess_token(token);

        GetNewsResponse response = new GetNewsResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }
}