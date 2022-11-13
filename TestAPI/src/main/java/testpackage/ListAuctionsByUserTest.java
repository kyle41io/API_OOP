package testpackage;

import model.request.ListAuctionsByUserRequest;
import model.request.LoginRequest;
import model.response.ListAuctionsByUserResponse;
import model.response.LoginResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class ListAuctionsByUserTest {
    public final int numberOfTest = 21;

    public final String[] statusIds = {
            "3",
            "3",
            "4",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2"
    };
    public static final String TOKEN_CST = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU2Njk3MzY3LCJleHAiOjE2NTcwNTczNjcsIm5iZiI6MTY1NjY5NzM2NywianRpIjoiaW9BOTFTMzBYeGdXa2cwZiIsInN1YiI6MzA3LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.oCb3YpXF6Y0xYQJbJVt7_To3zXM3SoDxHZIDk0Btdbw";
    public final String[] access_tokens = {
            "",
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            "",
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST
    };

    public final String[] indexs = {
            "1",
            "0",
            "1",
            "",
            "1",
            "",
            "5",
            "2",
            "2",
            "3",
            "3",
            "1",
            "0",
            "1",
            "",
            "1",
            "",
            "5",
            "2",
            "2",
            "3",
            "3"
    };

    public final String[] counts = {
            "2",
            "1",
            "1",
            "1",
            "",
            "3",
            "",
            "8",
            "2",
            "1",
            "3",
            "2",
            "1",
            "1",
            "1",
            "",
            "3",
            "",
            "8",
            "2",
            "1",
            "3"
    };

    public final String[] codes = {
            "1004",
            "1000",
            "1000",
            "1001",
            "1001",
            "1001",
            "1001",
            "1000",
            "1000",
            "1000",
            "1000",
            "1004",
            "1000",
            "1000",
            "1001",
            "1001",
            "1001",
            "1001",
            "1000",
            "1000",
            "1000",
            "1000"
    };

    public final String[] messages = {
            "まだログインではありません",
            "OK",
            "OK",
            "index: 7000&count: ",
            "index: &count: 7000 ",
            "index: 7000&count: ",
            "index: &count: 7000 ",
            "OK",
            "OK",
            "OK",
            "OK",
            "まだログインではありません",
            "OK",
            "OK",
            "index: 7000&count: ",
            "index: &count: 7000 ",
            "index: 7000&count: ",
            "index: &count: 7000 ",
            "OK",
            "OK",
            "OK",
            "OK"

};

    public final String[] sttIds = {
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2"

    };


    public ListAuctionsByUserResponse getResult(ListAuctionsByUserRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        ListAuctionsByUserResponse response = (ListAuctionsByUserResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(ListAuctionsByUserRequest request, ListAuctionsByUserResponse responseExpected) throws IOException {
        ListAuctionsByUserResponse response = getResult(request);
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
        ListAuctionsByUserRequest request = new ListAuctionsByUserRequest();
        request.setIndex(indexs[index]);
        request.setCount(counts[index]);
        request.setAuctionsId(sttIds[index]);

        String token = access_tokens[index];
        request.setAccess_token(token);

        ListAuctionsByUserResponse response = new ListAuctionsByUserResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3","4","5","6","7","8","9", "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21"

    })

    public void testAllUnitTest(int index) throws IOException {
        ListAuctionsByUserRequest request = new ListAuctionsByUserRequest();
        request.setIndex(indexs[index]);
        request.setCount(counts[index]);
        request.setAuctionsId(sttIds[index]);
        String token = access_tokens[index];
        request.setAccess_token(token);

        ListAuctionsByUserResponse response = new ListAuctionsByUserResponse();
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
