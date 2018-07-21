package spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class DownlandImg implements Runnable{

	Film film;
	
	public DownlandImg(Film film) {
		this.film = film;
	}
	
	@Override
	public void run() {
			File path = new File("D:\\豆瓣电影IMG");
			if(!path.exists())
				path.mkdir();
			
			try (FileOutputStream fout = new FileOutputStream(new File(path,film.getTitle().split(" ") + ".jpg"))){
				byte[] data = new OkHttpClient.Builder().build()
					.newCall(new Request.Builder().url(film.getPoster()).build())
					.execute()
					.body()
					.bytes();
				fout.write(data);
				fout.flush();
				fout.close();
				System.out.println(Thread.currentThread().getName() + " 下载了  " + film.getTitle() + "的海报");
			} catch (IOException e) {
				e.printStackTrace();
			}
//			System.out.println(Thread.currentThread().getName() + " is over");	
	}
	
}
