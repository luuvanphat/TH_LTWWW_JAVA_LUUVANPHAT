package iuh.fit.se.bai1jspform;

public class Qualification {
    private String exam;
    private String board;
    private String percentage;
    private String year;

    public Qualification() {}

    public Qualification(String exam, String board, String percentage, String year) {
        this.exam = exam;
        this.board = board;
        this.percentage = percentage;
        this.year = year;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

