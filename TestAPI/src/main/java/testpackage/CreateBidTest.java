package testpackage;

import constant.MessageConstant;
import constant.ResponseCodeConstant;
import model.request.CreateBidRequest;
import model.request.LoginRequest;
import model.response.CreateBidResponse;
import model.response.LoginResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class CreateBidTest {
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

    public final int numberOfTest = 11;






    public final String[] auctionIds = {
            "1",
            "1",
            "1",
            "1",
            "3",
            "5",
            "7",
            "5",
            "5",
            "5",
            "9"

    };




    public final String[] prices = {
            "20",
            "abc",
            "",
            "999999999",
            "def",
            "",
            "12",
            "30",
            "45",
            "80",
            "gh"


    };








    public final String[] bid_last_ids = {
            "10",
            "10",
            "10",
            "10",
            "10",
            "20",
            "24",
            "24",
            "24",
            "12",
            "12"

    };








    public final String[] codes = {
            "1001",
            "1001",
            "1001",
            "1008",
            "1001",
            "1001",
            "1008",
            "1001",
            "1001",
            "1001",
            "1001"


    };








    public final String[] messages = {
            "price: 7014",
            "price: 7006",
            "price: 7000",
            "Không thể nhập bid",
            "price: 7006",
            "price: 7000",
            "Không thể nhập bid",
            "price: 7014",
            "price: 7014",
            "price: 7014",
            "price: 7006"



};

    public CreateBidResponse getResult(CreateBidRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        CreateBidResponse response = (CreateBidResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(CreateBidRequest request, CreateBidResponse responseExpected) throws IOException {
        CreateBidResponse response = getResult(request);
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
            "1"
    })
    public void testAtIndexOfUnitTest(int index) throws IOException {
        String token = getANewToken();
        CreateBidRequest request = new CreateBidRequest();
        request.setAuctionId(auctionIds[index]);
        request.setAccess_token(token);
        request.setPrice(prices[index]);
        request.setBid_last_id(bid_last_ids[index]);

        CreateBidResponse response = new CreateBidResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3","4","5","6","7","8","9","10"
    })
    public void testAllUnitTest(int index) throws IOException {
        String token = getANewToken();
        CreateBidRequest request = new CreateBidRequest();
        request.setAuctionId(auctionIds[index]);
        request.setAccess_token(token);
        request.setPrice(prices[index]);
        request.setBid_last_id(bid_last_ids[index]);

        CreateBidResponse response = new CreateBidResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }
}
