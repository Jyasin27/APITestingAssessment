package typicode.services;
import com.mashape.unirest.http.ObjectMapper;
import groovy.json.JsonException;
import org.junit.Assert;
import typicode.models.MediaPosts;


import static io.restassured.RestAssured.given;

public class MediaPostsService {

    private String _baseUrl;
    private String endpoint ="/posts";

    ObjectMapper mapper = new ObjectMapper() {
        @Override
        public <T> T readValue(String s, Class<T> aClass) {
            return null;
        }

        @Override
        public String writeValue(Object o) {
            return null;
        }
    };

    public MediaPostsService(String baseUrl)
    {
        this._baseUrl = baseUrl;

    }


    public MediaPostsService[] get_listOfAllPostResources()
    {
      var response = given().when().get(_baseUrl+ endpoint);
        response.then().statusCode(200);
        response.print();
                                                                                //What it will return
        MediaPostsService[] posts = mapper.readValue(response.body().asString(), MediaPostsService[].class);

        return posts;
    }

    public void get_returnSinglePost_expectedId11()
    {
        var response = given().when().get(_baseUrl+endpoint+"?id=11");
        response.print();

        Assert.assertEquals(200, response.getStatusCode());


    }

    public MediaPosts post_createNewPostResource(MediaPosts media) throws JsonException
    {
       var  response = given().baseUri(_baseUrl).body(media).contentType("application/json").post(endpoint);
       response.body().print();

       Assert.assertEquals(201, response.getStatusCode());
       return mapper.readValue(response.body().asString(), MediaPosts.class);

    }


    public void delete_removesPostResource_id1(int id)
    {
        var response = given().when().delete(_baseUrl+ endpoint+"/"+id);
        response.getStatusCode();
        response.print();

        Assert.assertEquals(200, response.getStatusCode());
    }
}
