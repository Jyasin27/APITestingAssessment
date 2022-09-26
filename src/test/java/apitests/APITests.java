package apitests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

import static com.mashape.unirest.http.Unirest.*;


public class APITests {

    @Test
    public void getRequest_listOfAllPostResources() throws UnirestException
    {
            setTimeouts(0, 0);
            HttpResponse<String> response = get("https://jsonplaceholder.typicode.com/posts")
                    .asString();

            Assert.assertEquals("200", response.getStatus());
            System.out.println(response.getBody());

    }
    @Test
    public void getRequest_returnSinglePost_expectedId11() throws UnirestException {
        setTimeouts(0, 0);
        HttpResponse<String> response = get("https://jsonplaceholder.typicode.com/posts?id=11")
                .asString();

        Assert.assertEquals("200", response.getStatus());
        System.out.println(response.getBody());

    }

    @Test
    public void postRequest_createNewPostResource() throws UnirestException {
        setTimeouts(0, 0);
        HttpResponse<String> response = post("https://jsonplaceholder.typicode.com/posts")
                .field("userId", "1")
                .field("title", "foo")
                .field("body", "bar")
                .asString();

        Assert.assertEquals("201", response.getStatus());
        System.out.println(response.getBody());

    }

    @Test
    public void deleteRequest_removesPostResource_id1() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.delete("https://jsonplaceholder.typicode.com/posts")
                .field("Id", "1")
                .asString();

        Assert.assertEquals(404, response.getStatus());

        System.out.println(response.getBody());
    }

}
