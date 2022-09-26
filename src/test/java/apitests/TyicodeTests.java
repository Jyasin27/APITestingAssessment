package apitests;

import groovy.json.JsonException;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import typicode.models.MediaPosts;
import typicode.services.MediaPostsService;

import javax.sound.midi.Soundbank;
import java.util.HashMap;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TyicodeTests {

    private String baseUrl = "https://jsonplaceholder.typicode.com";
    SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void getRequest_listOfAllPostResources() //pass
    {
        MediaPostsService service = new MediaPostsService(baseUrl);
        service.get_listOfAllPostResources();

    }

    @Test
    public void getRequest_returnSinglePost_expectedId11() //pass
    {
        MediaPostsService service = new MediaPostsService(baseUrl);
        service.get_returnSinglePost_expectedId11();
    }

    @Test
    public void postRequest_createNewPostResource() throws JsonException {
        MediaPosts postToSend = new MediaPosts(1, "foo", "bar");

        MediaPostsService service = new MediaPostsService(baseUrl);
        var returnedPost = service.post_createNewPostResource(postToSend);

         Assert.assertEquals(postToSend.getUserId(), returnedPost.getUserId());
//        Assert.assertEquals(postToSend.getTitle(), returnedPost.getTitle());
//        Assert.assertEquals(postToSend.getBody(), (returnedPost.getBody()));


    }

    @Test
    public void deleteRequest_removesPostResource_id1()
    {
        MediaPostsService service = new MediaPostsService(baseUrl);
        service.delete_removesPostResource_id1(1);

        System.out.println("User with ID 1 has been deleted");

    }


}
