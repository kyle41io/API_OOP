package testpackage;

import model.request.EditAuctionRequest;
import model.request.LoginRequest;
import model.response.EditAuctionResponse;
import model.response.LoginResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class EditAuctionTest {

    public final int numberOfTest = 15;

    public final String[] category_ids = {
            "3",
            "3",
            "3",
            "3",
            "3",
            "4",
            "5",
            "",
            "",
            "3",
            "3",
            "4",
            "4",
            "3",
            "3"
    };


    public final String[] start_dates = {
            "9/6/2022",
            "9/6/2022",
            "9/6/2022",
            "9/6/2022",
            "9/6/2022",
            "9/6/2022",
            "9/6/2022",
            "9/6/2022",
            "9/7/2022",
            "",
            "9/6/2022",
            "9/6/2022",
            "5/6/2022",
            "9/6/2022",
            "9/6/2022"
    };

    public final String[] end_dates = {
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022",
            "10/6/2022"

    };

    public final String[] title_nis = {
            "aaa",
            "aaa",
            "\'ao%20LUOIVUITUOI%20fsdf\'",
            "abc",
            "abc",
            "abc",
            "abc",
            "aaa",
            "aaa",
            "aaa",
            "aaa",
            "aaa",
            "aaa",
            "abc",
            "aaab"
    };

    public final String[] codes = {
            "1000",
            "1004",
            "1005",
            "1005",
            "1005",
            "1006",
            "1006",
            "1000",
            "1000",
            "1000",
            "1000",
            "1000",
            "1001",
            "1001",
            "1000"
    };

    public final String[] messages = {
            "OK",
            "まだログインではありません",
            "Không thể chỉnh sửa",
            "Không thể chỉnh sửa",
            "Không thể chỉnh sửa",
            "Không có quyền chỉnh sửa",
            "Không có quyền chỉnh sửa",
            "OK",
            "OK",
            "OK",
            "OK",
            "OK",
            "category: &start_date: 7009&end_date: &title: ",
            "category: &start_date: &end_date: &title: 7005",
            "OK"
    };

    public final String[] auctionIds = {
            "267",
            "267",
            "162",
            "119",
            "196",
            "323",
            "262",
            "267",
            "267",
            "267",
            "267",
            "267",
            "267",
            "267",
            "350"


    };

    public static final String TOKEN_CST = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU2NzY1MDcyLCJleHAiOjE2NTcxMjUwNzIsIm5iZiI6MTY1Njc2NTA3MiwianRpIjoiYkNLOVJ2NXVBdjJqMGRmRyIsInN1YiI6MzA3LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.G-BSp5adu5vYBCZKez9qhBETn3l1Gid_OlEW-ZXxxuY";
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
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST,
            TOKEN_CST
    };


    public EditAuctionResponse getResult(EditAuctionRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        EditAuctionResponse response = (EditAuctionResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(EditAuctionRequest request, EditAuctionResponse responseExpected) throws IOException {
        EditAuctionResponse response = getResult(request);
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
        EditAuctionRequest request = new EditAuctionRequest();
        request.setCategory_id(category_ids[index]);
        request.setStart_date(start_dates[index]);
        request.setEnd_date(end_dates[index]);
        request.setTitle_ni(title_nis[index]);
        request.setAuctionId(auctionIds[index]);
        String token = tokens[index];
        request.setAccess_token(token);

        EditAuctionResponse response = new EditAuctionResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({
            "0","1","2","3","4","5","6","7","8","9",
            "10", "11", "12", "13", "14"
    })

    public void testAllUnitTest(int index) throws IOException {
        EditAuctionRequest request = new EditAuctionRequest();
        request.setCategory_id(category_ids[index]);
        request.setStart_date(start_dates[index]);
        request.setEnd_date(end_dates[index]);
        request.setTitle_ni(title_nis[index]);

        request.setAuctionId(auctionIds[index]);

        String token = tokens[index];
        request.setAccess_token(token);

        EditAuctionResponse response = new EditAuctionResponse();
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
