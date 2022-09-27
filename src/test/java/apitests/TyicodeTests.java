package apitests;

import groovy.json.JsonException;
import org.junit.Assert;
import org.junit.Test;
import typicode.models.MediaPosts;
import typicode.services.MediaPostsService;


public class TyicodeTests {

    private String baseUrl = "https://jsonplaceholder.typicode.com";


    @Test
    public void getRequest_listOfAllPostResources()
    {
        MediaPostsService service = new MediaPostsService(baseUrl);
        service.get_listOfAllPostResources();

    }

    @Test
    public void getRequest_returnSinglePost_expectedId11()
    {
        MediaPostsService service = new MediaPostsService(baseUrl);
        service.get_returnSinglePost_expectedId11();
    }

    @Test
    public void postRequest_createNewPostResource() throws JsonException
    {
        MediaPosts postToSend = new MediaPosts(1, "foo", "bar");

        MediaPostsService service = new MediaPostsService(baseUrl);
        service.post_createNewPostResource(postToSend);

        Assert.assertEquals(postToSend.getUserId(), 1);
        Assert.assertEquals(postToSend.getTitle(),"foo");
        Assert.assertEquals(postToSend.getBody(), "bar");

        System.out.println("User 1 has been created");
    }

    @Test
    public void deleteRequest_removesPostResource_id1()
    {
        MediaPostsService service = new MediaPostsService(baseUrl);
        service.delete_removesPostResource_id1(1);

        System.out.println("User with ID 1 has been deleted");

    }


}
