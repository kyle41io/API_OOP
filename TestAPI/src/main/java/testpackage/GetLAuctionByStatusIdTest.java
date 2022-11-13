package testpackage;

import model.request.LoginRequest;
import model.response.LoginResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static constant.StringConstant.*;

public class GetLAuctionByStatusIdTest {
    public final int numberOfTest = 20;






    public final String[] emails = {
            "hoangnt4@gmail.com",
            "",
            "hoangnt4@gmail.com",
            "",
            "hoangnt4",
            "hoangnt4@gmail",
            "\'hoang%20nt4@gmail.com\'",
            "hoang@nt4@gmail.com",
            CHARACTERS_254,
            CHARACTERS_255,
            CHARACTERS_256,
            CHARACTERS_244 + "@gmail.com",
            CHARACTERS_245 + "@gmail.com",
            CHARACTERS_246 + "@gmail.com",
            "hoangnt4@gmail.com",
            "hoangnt4@gmail.com",
            "hoang@gmail.com",
            CHARACTERS_64 + "@gmail.com",
            CHARACTERS_65 + "@gmail.com",
            "@gmail.com"
    };








    public final String[] passwords = {
            "123456",
            "",
            "",
            "123456",
            "",
            "123456",
            "123456",
            "123456",
            CHARACTERS_254,
            CHARACTERS_255,
            CHARACTERS_256,
            CHARACTERS_254,
            CHARACTERS_255,
            CHARACTERS_256,
            CHARACTERS_256,
            "123456",
            "123456",
            CHARACTERS_64,
            CHARACTERS_65,
            "123456"
    };








    public final String[] codes = {
            "1000",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1002",
            "1002",
            "1001",
            "1001",
            "1002",
            "1002",
            "1002",
            "1002",
            "1001"
    };








    public final String[] messages = {
            "OK",
            "email: 7000 &password: 7000",
            "email:  &password: 7000",
            "email: 7000 &password: ",
            "email: 7002 &password: 7000",
            "email: 7002 &password: ",
            "email: 7002 &password: ",
            "email: 7002 &password: ",
            "email: 7002 &password: ",
            "email: 7002 &password: ",
            "email: 7002 &password: 7001",
            "メールとパスワードは違いました",
            "メールとパスワードは違いました",
            "email: 7001 &password: 7001",
            "email:  &password: 7001",
            "メールとパスワードは違いました",
            "メールとパスワードは違いました",
            "メールとパスワードは違いました",
            "メールとパスワードは違いました",
            "email: 7002 &password: "
    };

    public LoginResponse getResult(LoginRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        LoginResponse response = (LoginResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(LoginRequest request, LoginResponse responseExpected) throws IOException {
        LoginResponse response = getResult(request);
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

    @ParameterizedTest
    @CsvSource({
            "17",
            "18",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8"
    })
    public void testAtIndexOfUnitTest(int index) throws IOException {
        LoginRequest request = new LoginRequest();
        request.setEmail(emails[index]);
        request.setPassword(passwords[index]);

        LoginResponse response = new LoginResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3","4","5","6","7","8","9",
            "10","11","12","13","14","15","16","17","18","19"
    })
    public void testAllUnitTest(int index) throws IOException {
        LoginRequest request = new LoginRequest();
        request.setEmail(emails[index]);
        request.setPassword(passwords[index]);

        LoginResponse response = new LoginResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

}
