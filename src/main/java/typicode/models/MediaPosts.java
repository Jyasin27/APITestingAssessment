package typicode.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MediaPosts {

    private int userId;
    private String title;
    private String body;

}
