package boot;

import HTMLParser.MyHTMLParser;

public class Run {

	public static void main(String[] args) {
		
		//the original site I worked on
		MyHTMLParser htmlParse = new MyHTMLParser("http://edition.cnn.com/2016/06/02/middleeast/syria-aid-delivery/index.html");
		System.out.println("First site: ");
		System.out.println("Title: "+htmlParse.getTitle());
		System.out.println("Author: "+htmlParse.getAuthor());
		System.out.println("Content: "+htmlParse.getContent());
		
		//other site, from other domain with different object names, doesn't work
		String[] sec = htmlParse.extractData("http://finance.yahoo.com/news/senate-line-desperate-gop-turns-191800432.html");
		System.out.println("\nSeconed site: ");
		System.out.println("Title: "+sec[0]);
		System.out.println("Author: "+sec[1]);
		System.out.println("Content: "+sec[2]);
		
		//third site from the same domain with the same object names, works
		String[] thrd =htmlParse.extractData("http://edition.cnn.com/2016/06/12/asia/bangladesh-nationwide-raids/index.html");
		System.out.println("\nThird site: ");
		System.out.println("Title: "+thrd[0]);
		System.out.println("Author: "+thrd[1]);
		System.out.println("Content: "+thrd[2]);
	}

}
