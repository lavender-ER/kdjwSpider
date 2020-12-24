package spiderMethod;

import infoClass.examArrange;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


// 获取考试安排
public class GetExamArrange {



    private static Map<String, String> cookies;

    public GetExamArrange(Map cookies) throws IOException {
        this.cookies = cookies;
    }


    public List<examArrange> getData() throws IOException {
        String url12 = "http://kdjw.hnust.edu.cn/jsxsd/xsks/xsksap_list";
        Connection con12 = Jsoup.connect(url12);
        Connection.Response res12 = con12.followRedirects(false)
                .method(Connection.Method.POST)
                .header("ContentType", "application/x-www-form-urlencoded")
                .cookies(cookies)
                .data("xqlbmc", "期末")
                .data("xnxqid", "2020-2021-1")
                .data("xqlb", "3")
                .execute();
        List<Element> ExamInfo = new ArrayList<>();
        ExamInfo = Jsoup.parse(res12.body()).

                select("#dataList > tbody > tr > td");
        System.out.println(ExamInfo);
        List<examArrange> LE = new ArrayList<>();
        System.out.println(ExamInfo.size());

        for (
                int i = 0; i < ExamInfo.size(); ) {
            LE.add(new examArrange(Integer.parseInt(ExamInfo.get(i).text()), ExamInfo.get(i + 1).text(), ExamInfo.get(i + 2).text(),
                    ExamInfo.get(i + 3).text(), ExamInfo.get(i + 4).text(), ExamInfo.get(i + 5).text(), ExamInfo.get(i + 6).text(),
                    ExamInfo.get(i + 7).text()));
            i += 12;
        }
        for (examArrange cg : LE) {
            System.out.println(cg.id + " " + cg.name);
        }
        return LE;
    }



}
