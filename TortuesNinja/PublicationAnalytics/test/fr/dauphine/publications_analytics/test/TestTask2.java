package fr.dauphine.publications_analytics.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.FunctionsTask2;



public class TestTask2 {

	
		

	@Test
	public void should_support_one_publication() throws Exception {
		String file_name = "dblp_1.xml";
		FunctionsTask2 xb = new FunctionsTask2();
		assertEquals(1,
				xb.get_number_of_publicationsB(file_name));
		
	}


	@Test
	public void sould_support_multiple_publications() throws Exception {
		String file_name = "dblp_2.xml";
		FunctionsTask2 xb = new FunctionsTask2();
		assertEquals(3,
				xb.get_number_of_publicationsC(file_name));
		
	}
	

	@Test
	public void should_support_two_author_appearances() throws Exception {
		String file_name = "dblp_1.xml";
		FunctionsTask2 xb = new FunctionsTask2();
		assertEquals(2,
				xb.get_number_of_author_appearancesC(file_name));
		
	}
	
	
	@Test
	public void should_support_seven_author_appearances() throws Exception {
		String file_name = "dblp_2.xml";
		FunctionsTask2 xb = new FunctionsTask2();
		assertEquals(7,
				xb.get_number_of_author_appearancesC(file_name));
		
	}
	
	@Test
	public void should_have_two_as_a_mean() throws Exception {
		String file_name = "dblp_1.xml";
		double delta = 0.0;
		FunctionsTask2 xb = new FunctionsTask2();
		assertEquals(2.0,
				xb.get_mean_number_of_authors_per_publicationC(file_name),delta);
		
	}
	
	@Test
	public void should_have_two_thirtythree_as_mean() throws Exception {
		String file_name = "dblp_2.xml";
		double delta = 0.004;
		FunctionsTask2 xb = new FunctionsTask2();
		assertEquals(2.33,
				xb.get_mean_number_of_authors_per_publicationC(file_name),delta);
		
	}
	
	


}

