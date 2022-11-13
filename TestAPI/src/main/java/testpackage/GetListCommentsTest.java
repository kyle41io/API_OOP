package testpackage;

import constant.MessageConstant;
import constant.ResponseCodeConstant;
import model.request.GetListCommentsRequest;
import model.request.LoginRequest;
import model.response.GetListCommentsResponse;
import model.response.LoginResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static constant.StringConstant.CHARACTERS_64;
import static constant.StringConstant.CHARACTERS_65;
import static constant.StringConstant.CHARACTERS_244;
import static constant.StringConstant.CHARACTERS_245;
import static constant.StringConstant.CHARACTERS_246;
import static constant.StringConstant.CHARACTERS_254;
import static constant.StringConstant.CHARACTERS_255;
import static constant.StringConstant.CHARACTERS_256;

public class GetListCommentsTest {
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

    public final int numberOfTest = 14;






    public final String[] auctionIds = {
            "1",
            "100",
            "121",
            "3",
            "5",
            "7",
            "8",
            "9",
            "12",
            "15",
            "17",
            "18",
            "19",
            "20"

    };




    public final String[] indexs = {
            "2",
            "3",
            "8",
            "7",
            "17",
            "4",
            "19",
            "16",
            "14",
            "98",
            "70",
            "65",
            "11",
            "13"

    };








    public final String[] counts = {
            "1",
            "3",
            "9",
            "15",
            "23",
            "20",
            "5",
            "6",
            "19",
            "100",
            "31",
            "46",
            "22",
            "24"

    };








    public final String[] codes = {
            "1000",
            "1000",
            "1000",
            "1000",
            "1000",
            "1000",
            "1000",
            "1000",
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
            "OK",
            "OK",
            "OK",
            "OK",
            "OK",
            "OK",
            "OK",
            "OK",
            "OK",


    };

    public GetListCommentsResponse getResult(GetListCommentsRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        GetListCommentsResponse response = (GetListCommentsResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(GetListCommentsRequest request, GetListCommentsResponse responseExpected) throws IOException {
        GetListCommentsResponse response = getResult(request);
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
            "7","5","9","2","4"
    })
    public void testAtIndexOfUnitTest(int index) throws IOException {
        String token = getANewToken();
        GetListCommentsRequest request = new GetListCommentsRequest();
        request.setAuctionId(auctionIds[index]);
        request.setAccess_token(token);
        request.setIndex(indexs[index]);
        request.setCount(counts[index]);

        GetListCommentsResponse response = new GetListCommentsResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3","4","5","6","7","8","9","10","11","12","13"
    })
    public void testAllUnitTest(int index) throws IOException {
        String token = getANewToken();
        GetListCommentsRequest request = new GetListCommentsRequest();
        request.setAuctionId(auctionIds[index]);
        request.setAccess_token(token);
        request.setIndex(indexs[index]);
        request.setCount(counts[index]);

        GetListCommentsResponse response = new GetListCommentsResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

}
