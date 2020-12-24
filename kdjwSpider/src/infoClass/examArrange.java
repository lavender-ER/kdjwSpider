package infoClass;

// 考试安排

public class examArrange {

    public int id;         // 序号
    public String place;  // 校区
    public String examId;  // 考试场次
    public String CourseId; // 课程编号
    public String name; // 课程名称
    public String teacher; // 授课老师
    public String time; //  考试时间
    public String room; // 考场

    public examArrange(int id, String place, String examId, String CourseId, String name, String teacher, String time, String room) {
        this.id = id;
        this.place = place;
        this.examId = examId;
        this.CourseId = CourseId;
        this.teacher = teacher;
        this.time = time;
        this.room = room;
        this.name = name;
    }

}
