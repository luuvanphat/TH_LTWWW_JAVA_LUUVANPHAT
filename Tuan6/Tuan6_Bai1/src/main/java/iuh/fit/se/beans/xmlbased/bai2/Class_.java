package iuh.fit.se.beans.xmlbased.bai2;

public class Class_ {
    private String classId;

    private String className;

    public Class_(String classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public Class_() {
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
