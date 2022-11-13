package testpackage;

import model.request.GetNewsRequest;
import model.request.GetNotificationsRequest;
import model.request.LoginRequest;
import model.response.GetNewsResponse;
import model.response.GetNotificationsResponse;
import model.response.LoginResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class GetNotificationsTest {
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

    public GetNotificationsResponse getResult(GetNotificationsRequest request) throws IOException {

        System.out.println(request.getUrl_string());

        GetNotificationsResponse response = (GetNotificationsResponse)  request.sendRequest();

        return response;
    }

    public void testAUnitTest(GetNotificationsRequest request, GetNotificationsResponse responseExpected) throws IOException {
        GetNotificationsResponse response = getResult(request);

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
            "1", "1", "5", "-1"
    };

    public final String[] count = {
            "1", "100",
            "8.5", "3"
    };

    public final String[] codes = {
            "1000", "1000", "1000", "1000"
    };

    public final String[] messages = {
            "OK", "OK", "OK", "OK"
    };

    @ParameterizedTest
    @CsvSource({"0","1"
    })
    public void testSomeUnitTest(int index) throws IOException {
        GetNotificationsRequest request = new GetNotificationsRequest();
        request.setIndex(indexx[index]);
        request.setCount(count[index]);
        request.setIs_not_read(null);
        request.setAccess_token(token);

        GetNotificationsResponse response = new GetNotificationsResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3"
    })
    public void testAllUnitTest(int index) throws IOException {
        GetNotificationsRequest request = new GetNotificationsRequest();
        request.setIndex(indexx[index]);
        request.setCount(count[index]);
        request.setIs_not_read(null);
        request.setAccess_token(token);

        GetNotificationsResponse response = new GetNotificationsResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }
}