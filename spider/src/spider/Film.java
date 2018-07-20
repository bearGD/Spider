package spider;

public class Film {
	
	//字段
	/**
	 * 电影排行号
	 */
	int id;
	/**
	 * 海报
	 */
	String poster;
	/**
	 * 电影名
	 */
	String title;
	/**
	 * 导演
	 */
	String director;
	/**
	 * 编剧
	 */
	String scriptwriter;
	/**
	 * 主演
	 */
	String actor;
	
	/**
	 * 类型
	 */
	String type;
	/**
	 * 制片地
	 */
	String makePlace;
	/**
	 * 上映时间
	 */
	String releaseTime;
	/**
	 * 片长
	 */
	String movieTime;
	/**
	 * 评分
	 */
	double grade;
	/**
	 * 评论数
	 */
	int commentNum;
	/**
	 * 电影摘要
	 */
	String queto;
	/**
	 * 语言
	 */
	String language;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the poster
	 */
	public String getPoster() {
		return poster;
	}
	/**
	 * @param poster the poster to set
	 */
	public void setPoster(String poster) {
		this.poster = poster;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the scriptwriter
	 */
	public String getScriptwriter() {
		return scriptwriter;
	}
	/**
	 * @param scriptwriter the scriptwriter to set
	 */
	public void setScriptwriter(String scriptwriter) {
		this.scriptwriter = scriptwriter;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}
	/**
	 * @param actor the actor to set
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}
	/**
	 * @return the grade
	 */
	public double getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(double grade) {
		this.grade = grade;
	}
	/**
	 * @return the commentNum
	 */
	public int getCommentNum() {
		return commentNum;
	}
	/**
	 * @param commentNum the commentNum to set
	 */
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	/**
	 * @return the queto
	 */
	public String getQueto() {
		return queto;
	}
	/**
	 * @param queto the queto to set
	 */
	public void setQueto(String queto) {
		this.queto = queto;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the makePlace
	 */
	public String getMakePlace() {
		return makePlace;
	}
	/**
	 * @param makePlace the makePlace to set
	 */
	public void setMakePlace(String makePlace) {
		this.makePlace = makePlace;
	}
	/**
	 * @return the releaseTime
	 */
	public String getReleaseTime() {
		return releaseTime;
	}
	/**
	 * @param releaseTime the releaseTime to set
	 */
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	/**
	 * @return the movieTime
	 */
	public String getMovieTime() {
		return movieTime;
	}
	/**
	 * @param movieTime the movieTime to set
	 */
	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	public String toString() {
		return "{\nid: " + id 
				+ "\ntitle: " + title 
				+ "\nposter: " + poster 
				+ "\ndirector: " + director 
				+ "\nscriptwriter: " + scriptwriter
				+ "\nactior: " + actor 
				+ "\ngrade: " + grade 
				+ "\ncommentNum: " + commentNum 
				+ "\nqueto: " + queto 
				+ "\ntype: " + type
				+ "\nlanguage :" + language
				+ "\nmakePlace: " + makePlace
				+ "\nreleaseTime: " + releaseTime 
				+ "\nmovieTime: " + movieTime + "\n}";
	}
}
