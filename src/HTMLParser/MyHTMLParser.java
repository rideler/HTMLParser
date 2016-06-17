package HTMLParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/**
 * @author Shay
 *
 */
/**
 * @author Shay
 *
 */
/**
 * @author Shay
 *
 */
public class MyHTMLParser implements HtmlParser {
	protected String title;
	protected String Author;
	protected String content;
	
	/**
	 * Ctor of MyModel
	 * @param siteAdress the site address
	 * While Building MyHTMLParser object, it will already extract the data from the site.
	 */
	public MyHTMLParser(String siteAdress) {
		String[] temp = new String[4];
		//extracting the data from the site given
		temp = extractData(siteAdress);
		//setting the variables 
		setTitle(temp[0]);
		setAuthor(temp[1]);
		setContent(temp[2]);
	}

	

	@Override
	public String[] extractData(String siteAdress) {
		String[] site = new String[4];
		//trying to connect and parse the site, if failed, it prints to the string the error.
			try {
				//connecting to the site
				Document doc = Jsoup.connect(siteAdress).get();
				//getting the title of the article
				site[0]= doc.title();
				//getting the author name
				site[1]= doc.head().select("meta[name=author]").first().attr("content");
				//getting the content of the article
				site[2] = doc.body().select("div[class=zn-body__paragraph]").text();
			} catch (Exception e) {
				site[0]= "Error occured";
				site[1]= "Please check exception";
				site[2]=e.toString();
				return site;
			}
		return site;
	}

	/**
	 * getting the title of site
	 * @return the title of site
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * setting the title of site
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * getting the author of site
	 * @return the author of site
	 */
	public String getAuthor() {
		return Author;
	}

	/**
	 * setting the author of site
	 * @param author
	 */
	public void setAuthor(String author) {
		Author = author;
	}

	/**
	 * getting the content of site
	 * @return the content of site
	 */
	public String getContent() {
		return content;
	}

	/**
	 * setting the content of site
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
