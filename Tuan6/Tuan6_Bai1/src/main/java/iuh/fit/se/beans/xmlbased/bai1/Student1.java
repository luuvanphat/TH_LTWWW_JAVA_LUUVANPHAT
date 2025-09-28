package iuh.fit.se.beans.xmlbased.bai1;

public class Student1 {
    private long id;

    private String name;

    public Student1(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student1() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
