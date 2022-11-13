package testpackage;

import model.request.GetNewsRequest;
import model.request.SearchRequest;
import model.response.GetNewsResponse;
import model.response.SearchResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class SearchTest {
    public final int NumberOfTest = 33;

    public final String[] type = {
            "1", "1", "1", "1", "1", "1", "1",
            "2", "2", "2", "2", "2", "2", "2", "2",
            "3", "3", "3", "3", "3",
            "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4",
    };

    public final String[] key = {
            "20", "55", "-10", "4", "10", "8", "7",
            "55", "30", "56", "8", "-10", "21", "abc", "12",
            "30", "56", "8", "21", "12",
            "30", "abc", "dior", "DIOR", "channel", "title", "hoa", "xe", "Xe", "SONY", "bền", "Nước", "Túi"
    };

    public SearchResponse getResult(SearchRequest request) throws IOException {
        System.out.println(request.getUrl_string());

        SearchResponse response = (SearchResponse) request.sendRequest();

        return response;
    }

    public void testAUnitTest(SearchRequest request, SearchResponse responseExpected) throws IOException {
        SearchResponse response = getResult(request);
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

    public final String[] codes = {
            "1000", "9998", "9998", "1000", "1000", "1000", "1000",
            "9998", "1000", "1000", "1000", "9998", "1000", "9998", "1000", "1000",
            "1000", "1000", "1000", "1000", "9998", "9998", "9998",
            "1000", "1000", "1000", "1000", "1000", "1000", "1000", "9998", "1000", "1000"

    };

    public final String[] messages = {
            "OK", "Khong tim thay", "Khong tim thay", "OK", "OK", "OK", "OK",
            "Khong tim thay", "OK", "OK", "OK", "Khong tim thay", "OK", "Khong tim thay", "OK", "OK",
            "OK", "OK", "OK", "OK", "検索できません", "検索できません", "検索できません", "OK", "OK", "OK", "OK", "OK",
            "OK", "OK", "検索できません", "OK", "OK"

    };

    @ParameterizedTest
    @CsvSource({"0","1", "5", "20", "24", "32"
    })
    public void testSomeUnitTest(int index) throws IOException {
        SearchRequest request = new SearchRequest();
        request.setType(type[index]);
        request.setKey(key[index]);

        SearchResponse response = new SearchResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3","4","5","6","7","8","9",
            "10","11","12","13","14","15","16","17","18","19",
            "20","21","22","23","24","25","26","27","28","29",
            "30","31","32"
    })
    public void testAllUnitTest(int index) throws IOException {
        SearchRequest request = new SearchRequest();
        request.setType(type[index]);
        request.setKey(key[index]);

        SearchResponse response = new SearchResponse();
        response.setCode(codes[index]);
        response.setMessage(messages[index]);

        testAUnitTest(request, response);
    }
}