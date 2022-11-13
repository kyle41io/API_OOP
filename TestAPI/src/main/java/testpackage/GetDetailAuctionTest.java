package testpackage;

import model.request.GetDetailAuctionRequest;
import model.request.LoginRequest;
import model.response.GetDetailAuctionResponse;
import model.response.LoginResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class GetDetailAuctionTest {
    public final int numberOfTest = 2;

    public final String[] auctionId = {
            "1",
            "1",
            "2",
            "3",
            "4",
            "5"

    };
    public static final String TOKEN_CST = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU2Njk3MzY3LCJleHAiOjE2NTcwNTczNjcsIm5iZiI6MTY1NjY5NzM2NywianRpIjoiaW9BOTFTMzBYeGdXa2cwZiIsInN1YiI6MzA3LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.oCb3YpXF6Y0xYQJbJVt7_To3zXM3SoDxHZIDk0Btdbw";
    public final String[] access_tokens = {
            "",
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,

    };


    public final String[] codes = {
            "1000",
            "1000",
            "1000",
            "1000",
            "1000",
            "1000"
    };

    public final String[] messages = {
            "OK",
            "OK",
            "OK",
            "OK",
            "OK",
            "OK"

};


    public GetDetailAuctionResponse getResult(GetDetailAuctionRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        GetDetailAuctionResponse response = (GetDetailAuctionResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(GetDetailAuctionRequest request, GetDetailAuctionResponse responseExpected) throws IOException {
        GetDetailAuctionResponse response = getResult(request);
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
            "0"
    })
    public void testAtIndexOfUnitTest(int index) throws IOException {
        GetDetailAuctionRequest request = new GetDetailAuctionRequest();
        request.setAuctionsId(auctionId[index]);

        String token = access_tokens[index];
        request.setAccess_token(token);

        GetDetailAuctionResponse response = new GetDetailAuctionResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3","4","5"

    })

    public void testAllUnitTest(int index) throws IOException {
        GetDetailAuctionRequest request = new GetDetailAuctionRequest();
        request.setAuctionsId(auctionId[index]);

        String token = access_tokens[index];
        request.setAccess_token(token);

        GetDetailAuctionResponse response = new GetDetailAuctionResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    public static final String EMAIL = "quyetpm@gmail.com";
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
}
