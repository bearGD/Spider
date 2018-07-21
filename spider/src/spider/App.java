package spider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {

		List<Film> filmList = Collections.synchronizedList(new ArrayList<>());

		ExecutorService pool = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++) {
			Spider spider = new Spider("https://movie.douban.com/top250?start=" + i * 25, filmList);
			pool.execute(spider);
		}
		
		pool.shutdown();
		
		while (true) {
			if (pool.isTerminated()) {
				break;
			}else {
				try {
					Thread.sleep(1_000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		pool = Executors.newFixedThreadPool(10);
		for (Film f : filmList) {
			pool.execute(new DownlandImg(f));
		}
		pool.shutdown();
//		for (Film f : filmList) {
//			System.out.println(f);
//		}
		OutXml out = new OutXml(filmList);
		out.outXml();
	}
	
}
