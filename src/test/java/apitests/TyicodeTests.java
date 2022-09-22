package apitests;

import org.junit.Test;
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
    public void postRequest_createNewPostResource() {
        MediaPostsService service = new MediaPostsService(baseUrl);
        service.post_createNewPostResource();
    }
}
