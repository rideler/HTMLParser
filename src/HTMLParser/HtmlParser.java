package HTMLParser;


public interface HtmlParser {
	/**
	 * Function that extracts data from site
	 * @param str the site address
	 * @return array of string that holds the parsed site,if error occurs it will return the exception.
	 * string[0]-holds the Title of the article
	 * string[1]-holds the Author of the article
	 * string[2]-holds the content of the article
	 */
	String[] extractData(String str);
}