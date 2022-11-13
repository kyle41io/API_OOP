package testpackage;

import model.request.GetListAuctionRequest;
import model.response.GetListAuctionResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;


public class GetListAuctionTest {
    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU2Nzk4Nzg1LCJleHAiOjE2NTcxNTg3ODUsIm5iZiI6MTY1Njc5ODc4NSwianRpIjoiUVZZSzBDVXppSHRXekpaayIsInN1YiI6NDc4LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.OY0qmZDZQOBQVLo3rNtH9FYHGUDnji6MJErg28Zrw1k";
    public final int numberOfTest = 3;






    public final String[] indexs = {
            "1",
            "1",
            "1"
    };








    public final String[] counts = {
            "10",
            "10",
            "10"
    };








    public final String[] codes = {
            "1000",
            "1004",
            "1004"

    };








    public final String[] messages = {
            "OK",
            "まだログインではありません",
            "まだログインではありません"
    };

    public GetListAuctionResponse getResult(GetListAuctionRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        GetListAuctionResponse response = (GetListAuctionResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(GetListAuctionRequest request, GetListAuctionResponse responseExpected) throws IOException {
        GetListAuctionResponse response = getResult(request);
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
            "0",
            "1",
            "2"
    })
    public void testAtIndexOfUnitTest(int index) throws IOException {
        GetListAuctionRequest request = new GetListAuctionRequest();
        request.setIndex(indexs[index]);
        request.setCount(counts[index]);

        if (index == 0){
            request.setAccess_token(TOKEN);
        }

        if (index == 2){
            request.setAccess_token("askjdhakhsd");
        }

        GetListAuctionResponse response = new GetListAuctionResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }


}
