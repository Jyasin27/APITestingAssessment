package typicode.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import typicode.services.MediaPostsService;

@Getter
@Setter
@AllArgsConstructor
public class MediaPosts {

    private int userId;
    private int id;
    private String title;
    private String body;


    public MediaPosts(int userId, String title, String body )
    {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }


}
