package infoClass;
// 课程考核结果
public class courseGrade {
    public int id; // 序号
    public String item;  // 开课学期
    public int courseId; // 课程编号
    public String name; // 课程名称
    public String grade; // 成绩
    public String flag; // 成绩标识
    public double score; // 学分
    public int timeR; // 总学时
    public double point; // 绩点
    public String ReItem; // 补重学期
    public String method; // 考核方式
    public String property; // 考试性质
    public String attribute; // 课程属性

    public courseGrade(int id, String item, int courseId, String name, String grade,
                       String flag, double score, int timeR, double point, String ReItem,
                       String method, String property, String attribute) {
        this.id = id;
        this.item = item;
        this.courseId = courseId;
        this.name = name;
        this.grade = grade;
        this.flag = flag;
        this.score = score;
        this.timeR = timeR;
        this.point = point;
        this.ReItem = ReItem;
        this.method = method;
        this.property = property;
        this.attribute = attribute;
    }

}
