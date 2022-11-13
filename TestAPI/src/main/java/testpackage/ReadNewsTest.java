package testpackage;

import model.request.ReadNewsRequest;
import model.request.LoginRequest;
import model.response.ReadNewsResponse;
import model.response.LoginResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class ReadNewsTest {
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

    public ReadNewsResponse getResult(ReadNewsRequest request) throws IOException {

        System.out.println(request.getUrl_string());

        ReadNewsResponse response = (ReadNewsResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(ReadNewsRequest request, ReadNewsResponse responseExpected) throws IOException {
        ReadNewsResponse response = getResult(request);

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

    public final String[] news_id = {
            "1", "2", "3"
    };
    public final String[] codes = {
            "1000", null, null
    };

    public final String[] messages = {
            "OK", " ", " "
    };

    @ParameterizedTest
    @CsvSource({"0","1","2"
    })
    public void testAllUnitTest(int index) throws IOException {
        ReadNewsRequest request = new ReadNewsRequest();
        request.setAccess_token(token);
        request.setNews_id(news_id[index]);

        ReadNewsResponse response = new ReadNewsResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }
}