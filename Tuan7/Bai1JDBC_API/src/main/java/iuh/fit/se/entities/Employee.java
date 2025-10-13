package iuh.fit.se.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    private int id;
    private String role;
    private String name;

    public Employee(String role, String name) {
        this.role = role;
        this.name = name;
    }
}
