package apitests;

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
        var posts = service.get_listOfAllPostResources();

    }

    @Test
    public void getRequest_returnSinglePost_expectedId11()
    {
        MediaPostsService service = new MediaPostsService(baseUrl);
        service.get_returnSinglePost_expectedId11();
    }

    @Test
    public void postRequest_createNewPostResource() {
        MediaPosts postToSend = new MediaPosts(1, "foo", "bar");

        MediaPostsService service = new MediaPostsService(baseUrl);
        var returnedPost = service.post_createNewPostResource(postToSend);

        Assert.assertEquals(postToSend.getUserId(), returnedPost.getUserId());
        Assert.assertEquals(postToSend.getTitle(), returnedPost.getTitle());
        Assert.assertEquals(postToSend.getBody(), returnedPost.getBody());

    }
}
