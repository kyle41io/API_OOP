package testpackage;

import model.request.CreateAuctionRequest;
import model.request.LoginRequest;
import model.response.CreateAuctionResponse;
import model.response.LoginResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class CreateAuctionTest {

    public final int numberOfTest = 11;

    public final String[] category_ids = {
            "3",
            "3",
            "",
            "",
            "3",
            "3",
            "3",
            "",
            "",
            "3",
            "3"
    };


    public final String[] start_dates = {
            "9/6/2022",
            "10/6/2022",
            "10/6/2022",
            "",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "",
            "10/6/2022"
    };

    public final String[] end_dates = {
            "9/7/2022",
            "11/6/2022",
            "11/6/2022",
            "",
            "9/6/2022",
            "11/6/2022",
            "9/6/2022",
            "9/6/2022",
            "11/6/2022",
            "11/6/2022",
            "9/6/2022"
    };

    public final String[] title_nis = {
            "abc4",
            "abcd4",
            "abcde4",
            "",
            "abcde4",
            "abc4",
            "",
            "",
            "",
            "aaa4",
            "",
            "abc4",
            "abcd4",
            "abcde4",
            "",
            "abcde4",
            "abc4",
            "",
            "",
            "",
            "aaa4",
            "",
    };

    public final String[] codes = {
            "1000",
            "1004",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001"

    };

    public final String[] messages = {
            "OK",
            "まだログインではありません",
           "category: 7000&start_date: &end_date: &title: ",
            "category: 7000&start_date: 7000&end_date: 7000&title: 7000",
            "category: &start_date: &end_date: 7010&title: ",
            "category: &start_date: &end_date: &title: 7005",
            "category: &start_date: &end_date: 7010&title: 7000",
            "category: 7000&start_date: &end_date: 7010&title: 7000",
           "category: 7000&start_date: &end_date: &title: 7000",
            "category: &start_date: 7000&end_date: &title: ",
           "category: &start_date: &end_date: 7010&title: 7000"
};

    public static final String TOKEN_CST = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU2NzQ5OTM2LCJleHAiOjE2NTcxMDk5MzYsIm5iZiI6MTY1Njc0OTkzNiwianRpIjoiN01FVHZGTzFwUmZQQXRiNiIsInN1YiI6MzA3LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.TskK_4wh6K06VdEphX2Y8ozJCNuB4cYsR9nfvhCG5HE";
    public final String[] tokens = {
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
            TOKEN_CST
    };


    public CreateAuctionResponse getResult(CreateAuctionRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        CreateAuctionResponse response = (CreateAuctionResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(CreateAuctionRequest request, CreateAuctionResponse responseExpected) throws IOException {
        CreateAuctionResponse response = getResult(request);
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
        CreateAuctionRequest request = new CreateAuctionRequest();
        request.setCategory_id(category_ids[index]);
        request.setStart_date(start_dates[index]);
        request.setEnd_date(end_dates[index]);
        request.setTitle_ni(title_nis[index]);

        String token = tokens[index];
        request.setAccess_token(token);

        CreateAuctionResponse response = new CreateAuctionResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({
            "0","1","2","3","4","5","6","7","8","9","10"

    })

    public void testAllUnitTest(int index) throws IOException {
        CreateAuctionRequest request = new CreateAuctionRequest();
        request.setCategory_id(category_ids[index]);
        request.setStart_date(start_dates[index]);
        request.setEnd_date(end_dates[index]);
        request.setTitle_ni(title_nis[index]);

        String token = tokens[index];
        request.setAccess_token(token);

        CreateAuctionResponse response = new CreateAuctionResponse();
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
