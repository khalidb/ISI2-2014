package fr.dauphine.publications_analytics.test;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.FunctionsTask4;
import fr.dauphine.publications_analytics.src.FunctionsTask3;
public class TestTask4{
	
	@Test
	public void test(){
		FunctionsTask4 xml = new FunctionsTask4();
		String file_name = "file:/C:/Users/Steven/Desktop/dblp_curated_sample.xml";
		//String file_name = "C:/Users/Steven/Desktop/PROJET%20JAVA/PublicationAnalytics/bin/fr/dauphine/publications_analytics/src/dblp_curated_sample.xml";
		/*System.out.println("2002 : "+xml.getListBookAuthors(file_name, "*", 2002, 0));
		System.out.println("2007-2014 : "+xml.getListBookAuthors(file_name, "*", 2007, 2014));
		System.out.println("tout : "+xml.getListBookAuthors(file_name, "*", 0, 0));*/
		//System.out.println(xml.NamesOfCoAuthors(file_name, "*", 0, 0));
		
		//test pour avoir la liste des authors et des co-authors
		//Map<String, ArrayList> authors = xml.NamesOfCoAuthors(file_name, "*", 0, 0);
		//System.out.println(authors.keySet());
		xml.NamesOfCoAuthorsWithoutYearDisplay(file_name, "*", 0, 0);
		
		xml.NamesOfCoAuthorsByYear(file_name, "*", 0, 0);
		
	}
}