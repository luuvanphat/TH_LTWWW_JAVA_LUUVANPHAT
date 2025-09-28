package iuh.fit.se.beans.autowiring;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private String id;
    private String name;
    private Faculty faculty;
}
