package unittests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;



public class APITests {

    @Test
    public void request_listOfAllPostResources() throws UnirestException
    {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get("https://jsonplaceholder.typicode.com/posts")
                    .asString();

            System.out.println(response.getBody());

        }
    @Test
    public void request_returnSinglePost_expectedId11() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://jsonplaceholder.typicode.com/posts?id=11")
                .asString();

        System.out.println(response.getBody());

    }

//    @Test
//    public void
}
