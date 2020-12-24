package spiderMethod;

import infoClass.levelRes;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// 获取等级考试成绩
public class GetLevelRes {

    private String url = "http://kdjw.hnust.edu.cn/jsxsd/kscj/djkscj_list";
    private Connection con;
    private Connection.Response res;

    private static Map<String ,String > cookies;

    public GetLevelRes(Map cookies){
        this.cookies = cookies;
    }


    public List<levelRes> getData() throws IOException {
        con = Jsoup.connect(url);
         res = con.followRedirects(false)
                .method(Connection.Method.GET)
                .header("ContentType", "application/x-www-form-urlencoded")
                .cookies(this.cookies)
                .execute();
        List<levelRes> TR = new ArrayList<>();
//        System.out.println(res.statusCode());
//        System.out.println(Jsoup.parse(res.body()).select("#dataList > tbody > tr > td"));
        List<Element> d = Jsoup.parse(res.body()).select("#dataList > tbody > tr > td");
        for (int i = 0; i < d.size(); i++) {
            System.out.println(Integer.parseInt(d.get(i).text()) + " " + i);
            TR.add(new levelRes(d.get(i).text(), d.get(i + 1).text().substring(d.get(i + 1).text().length()-5,d.get(i + 1).text().length()-1), d.get(i + 2).text(), d.get(i + 3).text(),
                    d.get(i + 4).text(), d.get(i + 5).text(), d.get(i + 6).text(), d.get(i + 7).text(), d.get(i + 8).text()));
            i += 8;
//            System.out.println(d.get(i).text() + " " + i);

        }
        for (levelRes cg : TR) {
//            System.out.println(cg.id + " " + cg.name + " " + cg.ScoreWritten + " " + cg.ScorePC + " " + cg.ScoreTotal + " " + cg.LevelWritten + " " + cg.LevelPC + " " + cg.LevelTotal + " " + cg.date);
        }
        return TR;
    }


}
