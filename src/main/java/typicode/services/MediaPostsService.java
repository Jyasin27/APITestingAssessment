package typicode.services;
import org.junit.Assert;
import typicode.models.MediaPosts;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class MediaPostsService {

    private String _baseUrl;
    private String endpoint ="/posts";
    private MediaPosts media;

    public MediaPostsService(String baseUrl)
    {
        this._baseUrl = baseUrl;
    }

    public void get_listOfAllPostResources()
    {
      var response = given().when().get(_baseUrl+ endpoint);
        response.print();

        Assert.assertEquals(200, response.getStatusCode());

    }

    public void get_returnSinglePost_expectedId11()
    {
        var response = given().when().get(_baseUrl+endpoint+"?id=11");
        response.print();

        Assert.assertEquals(200, response.getStatusCode());


    }
    public void post_createNewPostResource() //check video 47mins
    {
       var  media = new MediaPosts(1,"foo", "bar");
        media.getBody();

        Assert.assertEquals(201, response().getStatusCode());
    }


    public void delete_removesPostResource_id1()
    {

    }
}
