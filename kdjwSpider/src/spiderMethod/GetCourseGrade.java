package spiderMethod;

import infoClass.courseGrade;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetCourseGrade {


    private String url = "http://kdjw.hnust.edu.cn/jsxsd/kscj/cjcx_list?=";
    private Connection con;
    private static Map<String, String> cookies;


    public GetCourseGrade(Map<String, String> cookies) {
        GetCourseGrade.cookies = cookies;
    }

    public List<courseGrade> getData(String item) throws IOException {
//        List<String> Ls = new ArrayList<>();
//        for (int i = 2016; i <= 2022; i++) {
//            for (int j = 1; j <= 2; j++) {
//                Ls.add(i + "-" + (i + 1) + "-" + j);
//            }
//        }
//        System.out.println("cfyuyvibniioyuxcvbn" + item);
        Connection con = Jsoup.connect(url);
        Connection.Response res = con.followRedirects(false)
                .method(Connection.Method.GET)
                .header("ContentType", "application/x-www-form-urlencoded")
                .cookies(cookies)
                .data("kksj", item)
                .execute();
        List<courseGrade> Lg = new ArrayList<>();
        System.out.println(res.statusCode());
        System.out.println(Jsoup.parse(res.body()).select("#dataList > tbody > tr > td"));
        List<Element> d = Jsoup.parse(res.body()).select("#dataList > tbody > tr > td");
        for (int i = 0; i < d.size(); i++) {
            Lg.add(new courseGrade(Integer.parseInt(d.get(i).text()), d.get(i + 1).text(), Integer.parseInt(d.get(i + 2).text()), d.get(i + 3).text(),
                    d.get(i + 4).text(), d.get(i + 5).text(), Double.parseDouble(d.get(i + 6).text()), Integer.parseInt(d.get(i + 7).text()),
                    Double.parseDouble(d.get(i + 8).text()), d.get(i + 9).text(), d.get(i + 10).text(), d.get(i + 11).text(), d.get(i + 12).text()));
            i += 13;
        }
        for (courseGrade cg : Lg) {
            System.out.println(cg.id + " " + cg.name);
        }
        return Lg;
    }

}
