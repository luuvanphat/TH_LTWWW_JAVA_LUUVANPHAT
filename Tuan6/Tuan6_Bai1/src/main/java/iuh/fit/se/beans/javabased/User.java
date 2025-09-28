package iuh.fit.se.beans.javabased;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String password;
    private String userName;
    private Group group;

}
