package testpackage;

import model.request.SignUpRequest;
import model.response.SignUpResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static constant.StringConstant.*;
import static constant.StringConstant.CHARACTERS_65;

public class SignUpTest {
    public final int numberOfTest = 37;





    public final String[] emails = {
            "hoangnt12@gmail.com",
            "hoangnt22@gmail.com",
            "hoangnt32@gmail.com",
            "hoangnt42@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt@gmail.com",
            "hoangnt52",
            "hoangnt52@gmail",
            "\'hoang%20nt52@gmail.com\'",
            "hoang@nt52@gmail.com",
            CHARACTERS_255 + "gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            "hoangnt52@gmail.com",
            CHARACTERS_254,
            CHARACTERS_255,
            CHARACTERS_256,
            CHARACTERS_254 + "gmail.com",
            CHARACTERS_255 + "gmail.com",
            CHARACTERS_256 + "gmail.com",
            CHARACTERS_64 + "gmail.com",
            CHARACTERS_65 + "gmail.com"

    };
    public final String[] passwords = {
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "",
            "123456",
            "",
            "123456",
            "123456",
            CHARACTERS_256,
            CHARACTERS_256,
            "\'%20\'",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            CHARACTERS_254,
            CHARACTERS_255,
            CHARACTERS_256,
            CHARACTERS_254,
            CHARACTERS_255,
            CHARACTERS_256,
            CHARACTERS_64,
            CHARACTERS_65
    };

    public final String[] re_passes = {
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "",
            "",
            "123456",
            "123",
            CHARACTERS_256,
            "123456",
            CHARACTERS_256,
            "\'%20\'",
            "\'%20\'",
            "\'%20123456%20\'",
            "\'%20123%20456%20\'",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            "123456",
            CHARACTERS_254,
            CHARACTERS_255,
            CHARACTERS_256,
            CHARACTERS_254,
            CHARACTERS_255,
            CHARACTERS_256,
            CHARACTERS_64,
            CHARACTERS_65
    };

    public final String[] addresses = {
            "BKHN",
            "BKHN",
            "",
            "",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            CHARACTERS_256,
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN",
            "BKHN"
    };

    public final String[] names = {
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            CHARACTERS_256,
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
            "hoang",
    };

    public final String[] phones = {
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            CHARACTERS_256,
            "abcashg",
            "123564!@##$a342",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789",
            "0123456789"
    };

    public final String[] avatars = {
            "link",
            "",
            "link",
            "",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link",
            "link"
    };

    public final String[] codes = {
            "1000",
            "1000",
            "1000",
            "1000",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
            "1001",
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
            "1001",
            "1000",
            "1000"
    };

    public final String[] messages = {
            "OK",
            "OK",
            "OK",
            "OK",
            "name: &phone: &address: &email: &password: &re_pass:  &avatar: ",
            "name: &phone: 7000&address: &email: &password: &re_pass:  &avatar: ",
            "name: &phone: &address: &email: 7000&password: &re_pass:  &avatar: ",
            "name: &phone: &address: &email: &password: 7000&re_pass:  &avatar: ",
            "name: &phone: &address: &email: &password: &re_pass: 7000 &avatar: ",
            "name: &phone: &address: &email: &password: 7000&re_pass: 7003 &avatar: ",
            "name: &phone: &address: &email: &password: &re_pass: 7003 &avatar: ",
            "name: &phone: &address: &email: &password: &re_pass: 7003 &avatar: ",
            "name: &phone: &address: &email: &password: 7001&re_pass: 7003 &avatar: ",
            "name: &phone: &address: &email: &password: 7001&re_pass: 7001 &avatar: ",
            "name: &phone: &address: &email: &password: 7000&re_pass:  &avatar: ",
            "name: &phone: &address: &email: &password: &re_pass: 7000 &avatar: ",
            "name: &phone: &address: &email: &password: &re_pass: 7003 &avatar: ",
            "name: &phone: &address: &email: &password: &re_pass: 7003 &avatar: ",
            "name: &phone: &address: &email: 7004&password: &re_pass:  &avatar: ",
            "name: &phone: &address: &email: 7002&password: &re_pass:  &avatar: ",
            "name: &phone: &address: &email: 7002&password: &re_pass:  &avatar: ",
            "name: &phone: &address: &email: 7002&password: &re_pass:  &avatar: ",
            "name: &phone: &address: &email: 7002&password: &re_pass:  &avatar: ",
            "name: &phone: &address: &email: 7001&password: &re_pass:  &avatar: ",
            "name: &phone: &address: 7001 &email: &password: &re_pass:  &avatar: ",
            "name: &phone: 7013&address: &email: &password: &re_pass:  &avatar: ",
            "name: &phone: 7002&address: &email: &password: &re_pass:  &avatar: ",
            "name: &phone: 7002&address: &email: &password: &re_pass:  &avatar: ",
            "name: 7001&phone: &address: &email: &password: &re_pass:  &avatar: ",
            "name: &phone: &address: &email: 7002&password: &re_pass:  &avatar: ",
            "name: &phone: &address: &email: 7002&password: &re_pass:  &avatar: ",
            "name: &phone: &address: &email: 7002&password: 7001&re_pass: 7001 &avatar: ",
            "OK",
            "OK",
            "name: &phone: &address: &email: 7002&password: 7001&re_pass: 7001 &avatar: ",
            "OK",
            "OK"
    };

    public SignUpResponse getResult(SignUpRequest request) throws IOException {

        System.out.println(request.getUrl_string());

        SignUpResponse response = (SignUpResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(SignUpRequest request, SignUpResponse responseExpected) throws IOException {
        SignUpResponse response = getResult(request);
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
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8"
    })
    public void testAtIndexOfUnitTest(int index) throws IOException {

        SignUpRequest request = new SignUpRequest();
        request.setEmail(emails[index]);
        request.setPassword(passwords[index]);
        request.setRe_pass(re_passes[index]);
        request.setName(names[index]);
        request.setAddress(addresses[index]);
        request.setPhone(phones[index]);
        request.setAvatar(avatars[index]);

        SignUpResponse response = new SignUpResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({
            "0","1","2","3","4","5","6","7","8","9",
            "10","11","12","13","14","15","16","17","18","19",
            "20","21","22","23","24","25","26","27","28","29",
            "30","31","32","33","34","35","36"
    })
    public void testAllUnitTest(int index) throws IOException {

        SignUpRequest request = new SignUpRequest();
        request.setEmail(emails[index]);
        request.setPassword(passwords[index]);
        request.setRe_pass(re_passes[index]);
        request.setName(names[index]);
        request.setAddress(addresses[index]);
        request.setPhone(phones[index]);
        request.setAvatar(avatars[index]);

        SignUpResponse response = new SignUpResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);

    }
}
