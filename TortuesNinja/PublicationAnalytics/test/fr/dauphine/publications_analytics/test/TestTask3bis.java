package fr.dauphine.publications_analytics.test;


import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.FunctionsTask3;


public class TestTask3bis {


	@Test
	public void should_support_three_total_publications() throws Exception {
		String file_name = "dblp_2.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		assertEquals(4,
				xb.get_number_of_smth_any_level(file_name, "*", 0));
		
	}
	
	@Test
	public void should_support_five_total_authors() throws Exception {
		String file_name = "dblp_2.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		assertEquals(5,
				xb.get_number_of_authors(file_name));
		
	}
	
	@Test
	public void should_support_two_inproceedings() throws Exception {
		String file_name = "dblp_3.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		assertEquals(2,
				xb.get_number_of_smth_any_level(file_name, "inproceedings", 0));
		
	}
	
	@Test
	public void should_support_one_article() throws Exception {
		String file_name = "dblp_3.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		assertEquals(1,
				xb.get_number_of_smth_any_level(file_name, "article", 0));
		
	}
	
	@Test
	public void should_support_three_books() throws Exception {
		String file_name = "dblp_2.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		assertEquals(3,
				xb.get_number_of_smth_any_level(file_name, "book", 0));
		
	}
	
	@Test
	public void should_support_one_incollection() throws Exception {
		String file_name = "dblp_3.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		assertEquals(1,
				xb.get_number_of_smth_any_level(file_name, "incollection", 0));
		
	}
	
	/*@Test
	public void should_support_threeForCeri_oneForOthers() throws Exception {
		String file_name = "dblp_2.xml";
		XMLPublication2 xb = new XMLPublication2();
		assertEquals(1,
				xb.get_number_of_publications_for_each_author(file_name));
			}
	*/
	@Test
	public void should_support_number_publications_for_each_author()throws Exception {
		String file_name = "dblp_2.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_sth_per_authors(file_name,null);
		
	}
	
	@Test
	public void should_support_conference_proceedings_for_each_author()throws Exception {
		String file_name = "dblp_3.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_sth_per_authors(file_name,"inproceedings");
		
	}
	
	@Test
	public void should_articles_for_each_author()throws Exception {
		String file_name = "dblp_3.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_sth_per_authors(file_name,"article");
		
	}
	@Test
	public void should_support_books_for_each_author()throws Exception {
		String file_name = "dblp_2.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_sth_per_authors(file_name,"book");
	}
	
	@Test
	public void should_support_uncollection_for_each_author()throws Exception {
		String file_name = "dblp_2.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_sth_per_authors(file_name,"incollection");
}
	@Test
	public void should_support_number_publications_for_each_year()throws Exception {
		String file_name = "dblp_2.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_sth_per_year(file_name,null);
		
	}
	
	@Test
	public void should_support_conference_proceedings_for_each_year()throws Exception {
		String file_name = "dblp_3.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_sth_per_year(file_name,"inproceedings");
		
	}
	
	@Test
	public void should_articles_for_each_year()throws Exception {
		String file_name = "dblp_3.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_sth_per_year(file_name,"article");
		
	}
	@Test
	public void should_support_books_for_each_year()throws Exception {
		String file_name = "dblp_2.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_sth_per_year(file_name,"book");
	}
	
	@Test
	public void should_support_uncollection_for_each_year()throws Exception {
		String file_name = "dblp_2.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_sth_per_year(file_name,"incollection");
	}
	
	@Test
	public void should_support_all_years_in_file() throws Exception{
		String file_name = "dblp_3.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_all_years_in_file(file_name, "");
	}
	
	@Test
	public void should_support_number_of_authors_who_wrotes_publications_for_each_year() throws Exception{
		String file_name = "dblp_3.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_authors_wrote_pblications_for_each_year(file_name, "");
	}
	
	
	@Test
	public void should_support_all_years_for_inproceedings() throws Exception{
		String file_name = "dblp_3.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_all_years_in_file(file_name, "inproceedings");
	}
	
	@Test
	public void should_support_number_of_authors_who_wrotes_inproceedings_for_each_year() throws Exception{
		String file_name = "dblp_3.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.get_number_of_authors_wrote_pblications_for_each_year(file_name, "inproceedings");
	}
	
}
