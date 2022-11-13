package testpackage;

import constant.MessageConstant;
import constant.ResponseCodeConstant;
import model.request.GetListBidRequest;
import model.request.LoginRequest;
import model.response.GetListBidResponse;
import model.response.LoginResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class GetListBidsTest {
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
            "2",
            "3",
            "5",
            "7",
            "9",
            "12",
            "15",
            "15",
            "17"

    };




    public final String[] indexs = {
            "2",
            "1",
            "4",
            "10",
            "",
            "15",
            "",
            "",
            "20",
            ""



    };








    public final String[] counts = {
            "1",
            "5",
            "6",
            "7",
            "10",
            "",
            "",
            "",
            "30",
            "43"

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


    };

    public GetListBidResponse getResult(GetListBidRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        GetListBidResponse response = (GetListBidResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(GetListBidRequest request, GetListBidResponse responseExpected) throws IOException {
        GetListBidResponse response = getResult(request);
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
            "1","3","5","7"
    })
    public void testAtIndexOfUnitTest(int index) throws IOException {
        String token = getANewToken();
        GetListBidRequest request = new GetListBidRequest();
        request.setAuctionId(auctionIds[index]);
        request.setAccess_token(token);
        request.setIndex(indexs[index]);
        request.setCount(counts[index]);

        GetListBidResponse response = new GetListBidResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3","4","5","6","7","8","9"
    })
    public void testAllUnitTest(int index) throws IOException {
        String token = getANewToken();
        GetListBidRequest request = new GetListBidRequest();
        request.setAuctionId(auctionIds[index]);
        request.setAccess_token(token);
        request.setIndex(indexs[index]);
        request.setCount(counts[index]);

        GetListBidResponse response = new GetListBidResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }
}
