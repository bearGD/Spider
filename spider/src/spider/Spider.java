package spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * HTTP/HTML 爬虫
 * 
 * @author ZX
 *
 */
public class Spider implements Runnable{

	String url;
	List<Film> filmList = new ArrayList<>();

	public Spider(String url, List<Film> filmList){
		this.url = url;
		this.filmList = filmList;
	}

	@Override
	public void run() {
		// 发送HTTP GET 请求,获得HTML文档
		try {
			Document doc = Jsoup.connect(url).timeout(10_000).get();
			
			Elements items = doc.select(".grid_view .item");
//			System.out.println(items.size());
			
			// 遍历
			for (int i = 0; i < items.size(); i++) {
				Film film = new Film();
				// 一部影片
				Element item = items.get(i);
				// 排行号
				String id = item.select("em").first().text();
				film.setId(Integer.parseInt(id));

				// 海报
				String poster = item.select("img").first().attr("src");
				film.setPoster(poster);
				// 标题
				String title = item.select(".info .title").text();
				film.setTitle(title);
				
				String grade = item.select(".star .rating_num").text();
				film.setGrade(Double.parseDouble(grade));
				
				String num = item.select(".star span").last().text();
				String n = num.substring(0, num.indexOf("人"));
				film.setCommentNum(Integer.parseInt(n));
				
				String quote = item.select(".info .quote").text();
				film.setQueto(quote);
				
				
				String a = item.select(".info .hd a[href]").attr("href");
				Document d;
				try {
					d = Jsoup.connect(a).get();
				} catch (Exception e) {
					filmList.add(film);
					continue;
				}
				
				Elements subitem = d.select("#wrapper");
				
				String info = subitem.get(0).select("#wrapper #info").text();
				
				String makePlace = info.substring(info.indexOf("制片") + 8, info.indexOf("语言"));
				film.setMakePlace(makePlace);
				String language = info.substring(info.indexOf("语言") + 3, info.indexOf("上映"));
				film.setLanguage(language);
				
				String director = subitem.get(0).select("#wrapper #info .attrs").get(0).text();
				film.setDirector(director);
				try {
					String scriptwriter = subitem.get(0).select("#wrapper #info .attrs").get(1).text();
					film.setScriptwriter(scriptwriter);
					String actor = subitem.get(0).select("#wrapper #info .attrs").get(2).text();
					film.setActor(actor);
				} catch (Exception e) {
				}
				String type = subitem.get(0).select("#wrapper #info span[property=v:genre]").text();
				film.setType(type);
				String releaseTime = subitem.get(0).select("#wrapper #info span[property=v:initialReleaseDate]").text();
				film.setReleaseTime(releaseTime);
				String movieTime = subitem.get(0).select("#wrapper #info span[property=v:runtime]").text();
				film.setMovieTime(movieTime);
				
				filmList.add(film);
				System.out.println(Thread.currentThread().getName() + "  爬取    排行第" + id + "的电影");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " is over");
	}

}
