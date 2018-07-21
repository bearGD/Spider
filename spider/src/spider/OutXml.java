package spider;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class OutXml {

	List<Film> filmList;

	public OutXml() {
	}

	public OutXml(List<Film> filmList) {
		this.filmList = filmList;
	}

	public void outXml() {
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

			Element list = doc.createElement("film-list");

			for (Film f : filmList) {
				Element film = doc.createElement("film");
				// 排行号
				Element id = doc.createElement("id");
				Text textId = doc.createTextNode(String.valueOf(f.getId()));
				id.appendChild(textId);
				film.appendChild(id);
				// 电影名
				Element title = doc.createElement("title");
				Text textTitle = doc.createTextNode(f.getTitle());
				title.appendChild(textTitle);
				film.appendChild(title);
				// 电影海报
				Element poster = doc.createElement("poster");
				Text textPoster = doc.createTextNode(f.getPoster());
				poster.appendChild(textPoster);
				film.appendChild(poster);
				// 导演
				Element director = doc.createElement("director");
				Text textDirector = doc.createTextNode(f.getDirector());
				director.appendChild(textDirector);
				film.appendChild(director);
				// 编剧
				Element scriptwriter = doc.createElement("scriptwriter");
				Text textScriptwriter = doc.createTextNode(f.getScriptwriter());
				scriptwriter.appendChild(textScriptwriter);
				film.appendChild(scriptwriter);
				// 演员
				Element actor = doc.createElement("actor");
				Text textActor = doc.createTextNode(f.getActor());
				actor.appendChild(textActor);
				film.appendChild(actor);
				// 类型
				Element type = doc.createElement("type");
				Text textType = doc.createTextNode(f.getType());
				type.appendChild(textType);
				film.appendChild(type);
				// 发布地
				Element makePlace = doc.createElement("makePlace");
				Text textMakePlace = doc.createTextNode(f.getMakePlace());
				makePlace.appendChild(textMakePlace);
				film.appendChild(makePlace);
				// 语言
				Element language = doc.createElement("language");
				Text textLanguage = doc.createTextNode(f.getLanguage());
				language.appendChild(textLanguage);
				film.appendChild(language);
				// 上映时间
				Element releaseTime = doc.createElement("releaseTime");
				Text textReleaseTime = doc.createTextNode(f.getReleaseTime());
				releaseTime.appendChild(textReleaseTime);
				film.appendChild(releaseTime);
				// 片长
				Element movieTime = doc.createElement("movieTime");
				Text textMovieTime = doc.createTextNode(f.getMakePlace());
				movieTime.appendChild(textMovieTime);
				film.appendChild(movieTime);
				// 评分
				Element grade = doc.createElement("grade");
				Text textGrade = doc.createTextNode(String.valueOf(f.getGrade()));
				grade.appendChild(textGrade);
				film.appendChild(grade);
				// 评论数
				Element commentNum = doc.createElement("commentNum");
				Text textCommentNum = doc.createTextNode(String.valueOf(f.getCommentNum()));
				commentNum.appendChild(textCommentNum);
				film.appendChild(commentNum);
				// 摘要
				Element queto = doc.createElement("queto");
				Text textQueto = doc.createTextNode(f.getQueto());
				queto.appendChild(textQueto);
				film.appendChild(queto);

				list.appendChild(film);
			}

			doc.appendChild(list);

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(new DOMSource(doc), new StreamResult(new File("film.xml")));

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}
}
