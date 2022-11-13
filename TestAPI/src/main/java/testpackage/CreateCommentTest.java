package testpackage;

import constant.MessageConstant;
import constant.ResponseCodeConstant;
import model.request.CreateCommentRequest;
import model.request.LoginRequest;
import model.response.CreateCommentResponse;
import model.response.LoginResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;



public class CreateCommentTest {
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

    public final int numberOfTest = 10;






    public final String[] auctionIds = {
            "1",
            "1",
            "2",
            "3",
            "5",
            "9",
            "12",
            "2",
            "100",
            "55"

    };




    public final String[] contents = {
            "Tốt",
            "Tốt",
            "Tốt",
            "\'Tuyệt%20vời\'",
            "\'Mượt%20mà\'",
            "\'Chính%20xác\'",
            "\'Chính%20xác\'",
            "\'Trời%20mưa\'",
            "\'Trời%20mưa\'",
            "\'Trời%20mưa\'"

    };








    public final String[] comment_last_ids = {
            "11",
            "11",
            "11",
            "20",
            "5",
            "7",
            "7",
            "8",
            "21",
            "21"

    };








    public final String[] codes = {
            "1000",
            "1004",
            "1008",
            "1000",
            "1000",
            "1000",
            "1000",
            "1008",
            "1008",
            "1000"


    };

    public final String[] tokens = {
            "YES",
            "NO",
            "YES",
            "YES",
            "YES",
            "YES",
            "YES",
            "YES",
            "YES",
            "YES"


    };








    public final String[] messages = {
            "OK",
            "まだログインではありません",
            "Không thể bình luận",
            "OK",
            "OK",
            "OK",
            "OK",
            "Không thể bình luận",
            "Không thể bình luận",
            "OK"


};

    public CreateCommentResponse getResult(CreateCommentRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        CreateCommentResponse response = (CreateCommentResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(CreateCommentRequest request, CreateCommentResponse responseExpected) throws IOException {
        CreateCommentResponse response = getResult(request);
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
        CreateCommentRequest request = new CreateCommentRequest();
        request.setAuctionId(auctionIds[index]);

        request.setContent(contents[index]);
        request.setComment_last_id(comment_last_ids[index]);

        if(tokens[index].equals("YES")){
            String token = getANewToken();
            request.setAccess_token(token);
        }

        CreateCommentResponse response = new CreateCommentResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3","4","5","6","7","8","9"
    })
    public void testAllUnitTest(int index) throws IOException {

        CreateCommentRequest request = new CreateCommentRequest();

        request.setAuctionId(auctionIds[index]);

        request.setContent(contents[index]);
        request.setComment_last_id(comment_last_ids[index]);

        if(tokens[index].equals("YES")){
            String token = getANewToken();
            request.setAccess_token(token);
        }

        CreateCommentResponse response = new CreateCommentResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

}

