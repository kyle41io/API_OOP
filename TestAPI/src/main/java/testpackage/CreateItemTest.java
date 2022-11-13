package testpackage;

import constant.MessageConstant;
import constant.ResponseCodeConstant;
import model.request.CreateItemRequest;
import model.request.LoginRequest;
import model.response.CreateItemResponse;
import model.response.LoginResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static constant.StringConstant.CHARACTERS_256;
import static constant.StringConstant.CHARACTERS_255;
import static constant.StringConstant.CHARACTERS_254;

public class CreateItemTest {
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


    public final String[] autiond_ids = {
            "346",
            "346",
            "347",
            "347",
            "347",
            "347",
            "347",
            "347",
            "347",
            "347",
            "348",
            "349",
            "349",
            "360",

    };


    public final String[] names = {
            "Chiếu",
            "Chiếu",
            "Quạt",
            "",
            "",
            "",
            "Giày",
            "\'Đồng%20hồ\'",
            "\'Đồng%20hồ\'",
            CHARACTERS_256,
            CHARACTERS_255,
            CHARACTERS_254,
            "Giày",
            "Giày"

};


public final String[]starting_prices={
        "100",
        "100",
        "100",
        "100",
        "",
        "",
        "100",
        "100",
        "abc",
        "100",
        "100",
        "100",
        "100",
        "100"


        };


public final String[]brand_ids={
        "1",
        "1",
        "",
        "",
        "",
        "",
        "1",
        "1",
        "1",
        "1",
        "1",
        "1",
        "1",
        "1"


        };


public final String[]descriptions={
        "Nâu",
        "Nâu",
        "Nâu",
        "Nâu",
        "Nâu",
        "",
        "Jordan",
        "Mỹ",
        "Mỹ",
        "Ảnh",
        "Ảnh",
        "Ảnh",
        "Jordan",
        "Jordan"


        };


public final String[]series={
        "30000",
        "30000",
        "30001",
        "30001",
        "30001",
        "30001",
        "30000",
        "11111111111",
        "30001",
        "30001",
        "30001",
        "30002",
        "30003",
        "30003",


        };


public final String[]images={
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",

        };


public final String[]codes={
        "1004",
        "1000",
        "1001",
        "1001",
        "1001",
        "1001",
        "1001",
        "1001",
        "1001",
        "1001",
        "1000",
        "1000",
        "9995",
        "9996"


        };


public final String[]messages={
        "まだログインではありません",
        "OK",
        "brand: 7000&name: &series: &description: &starting_price: ",
        "brand: 7000&name: 7000&series: &description: &starting_price: ",
        "brand: 7000&name: 7000&series: &description: &starting_price: 7000",
        "brand: 7000&name: 7000&series: &description: 7000&starting_price: 7000",
        "brand: &name: &series: 7004&description: &starting_price: ",
        "brand: &name: &series: 7011&description: &starting_price: ",
        "brand: &name: &series: &description: &starting_price: 7006",
        "brand: &name: 7001&series: &description: &starting_price: ",
        "OK",
        "OK",
        "Không thể thêm item mới với phiên đấu giá này",
        "Id truyền vào không tồn tại"


        };


public final String[]tokens={
        "NO",
        "YES",
        "YES",
        "YES",
        "YES",
        "YES",
        "YES",
        "YES",
        "YES",
        "YES",
        "YES",
        "YES",
        "YES",
        "YES",


        };


public CreateItemResponse getResult(CreateItemRequest request)throws IOException{
        System.out.println(request.getUrl_string());

        CreateItemResponse response=(CreateItemResponse)request.sendRequest();

        return response;
        }

public void testAUnitTest(CreateItemRequest request,CreateItemResponse responseExpected)throws IOException{
        CreateItemResponse response=getResult(request);
        System.out.println("Expected :");
        System.out.println(responseExpected.getCode());
        System.out.println(responseExpected.getMessage());

        System.out.println("Actual :");
        if(response==null)
        System.out.println("null");

        assert(response!=null);

        String code=response.getCode();
        String message=response.getMessage();
        System.out.println(code);
        System.out.println(message);

        assert(code.equals(responseExpected.getCode()));
        assert(message.equals(responseExpected.getMessage()));

        }

@ParameterizedTest
@CsvSource({
        "0"
})
public void testAtIndexOfUnitTest(int index)throws IOException{

        CreateItemRequest request=new CreateItemRequest();

        request.setAuctionId(autiond_ids[index]);
        request.setName(names[index]);
        request.setStarting_price(starting_prices[index]);
        request.setBrand_id(brand_ids[index]);
        request.setDescription(descriptions[index]);

        request.setSeries(series[index]);
        request.setImages(images[index]);

        if(tokens[index].equals("YES")){
        String token=getANewToken();
        request.setAccess_token(token);
        }

        CreateItemResponse response=new CreateItemResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request,response);
        }

@ParameterizedTest
@CsvSource({"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"
})
public void testAllUnitTest(int index)throws IOException{

        CreateItemRequest request=new CreateItemRequest();

        request.setAuctionId(autiond_ids[index]);
        request.setName(names[index]);
        request.setStarting_price(starting_prices[index]);
        request.setBrand_id(brand_ids[index]);
        request.setDescription(descriptions[index]);
        request.setSeries(series[index]);
        request.setImages(images[index]);

        if(tokens[index].equals("YES")){
        String token=getANewToken();
        request.setAccess_token(token);
        }

        CreateItemResponse response=new CreateItemResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request,response);
        }
}

