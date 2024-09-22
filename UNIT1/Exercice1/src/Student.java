public class Student {
    private String name;
    private int mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if (mark < 0 || mark > 10)
            return;
        this.mark = mark;
    }

    public Boolean isOver5(){
        return mark >= 5;
    }
}
