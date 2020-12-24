package infoClass;
// 等级考试 查询结果
public class levelRes {

    public String id;
    public String name;
    public String ScoreWritten;
    public String ScorePC;
    public String ScoreTotal;
    public String LevelWritten;
    public String LevelPC;
    public String LevelTotal;
    public String date;

    public levelRes(String id, String name, String ScoreWritten, String ScorePC, String ScoreTotal,
                    String LevelWritten, String LevelPC, String LevelTotal, String date) {
        this.id = id;
        this.date = date;
        this.LevelPC = LevelPC;
        this.ScorePC = ScorePC;
        this.LevelTotal = LevelTotal;
        this.ScoreTotal = ScoreTotal;
        this.LevelWritten = LevelWritten;
        this.ScoreWritten = ScoreWritten;
        this.name = name;
    }


}
