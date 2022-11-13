package testpackage;

import model.request.ReadNotificationsRequest;
import model.request.ReadNotificationsRequest;
import model.request.LoginRequest;
import model.response.ReadNotificationsResponse;
import model.response.ReadNotificationsResponse;
import model.response.LoginResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class ReadNotificationsTest {
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

    public ReadNotificationsResponse getResult(ReadNotificationsRequest request) throws IOException {

        System.out.println(request.getUrl_string());

        ReadNotificationsResponse response = (ReadNotificationsResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(ReadNotificationsRequest request, ReadNotificationsResponse responseExpected) throws IOException {
        ReadNotificationsResponse response = getResult(request);

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

    public final String[] auction_id = {
            "1", "2", "3", "20",
            "21", "22", "52", "62", "72", "83", "90",
            "92", "93", "91", "100", "160", "164"

    };
    public final String[] codes = {
            "1000", "1000", "1000", "1000", "1000",
            " ", " ", "1000", "1000", "1000", "1000",
            "1000", "1000", "1000", "1000", "1000", "1000"
    };

    public final String[] messages = {
            "OK", "OK", "OK", "OK", "OK", " ",
            " ", "OK", "OK", "OK", "OK", "OK",
            "OK", "OK", "OK", "OK", "OK"
    };

    @ParameterizedTest
    @CsvSource({"0","1","3","5","6","7"
    })
    public void testAUnitTest(int index) throws IOException {
        ReadNotificationsRequest request = new ReadNotificationsRequest();
        request.setAccess_token(token);
        request.setAuction_id(auction_id[index]);

        ReadNotificationsResponse response = new ReadNotificationsResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3","4","5","6","7","8","9", "10",
            "11", "12", "13", "14", "15", "16"
    })
    public void testAllUnitTest(int index) throws IOException {
        ReadNotificationsRequest request = new ReadNotificationsRequest();
        request.setAccess_token(token);
        request.setAuction_id(auction_id[index]);

        ReadNotificationsResponse response = new ReadNotificationsResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }
}