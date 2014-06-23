package fr.dauphine.publications_analytics.src;

import fr.dauphine.publications_analytics.src.FunctionsTask3;


public class Execute {


	public static void main(String args[]) {
		String file_name = "dblp_curated_sample.xml";
		String file_name2 = "dblp_1.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		
		System.out.println("user story 1");
		/*xb.get_number_of_smth_any_level(file_name, "*", 0);
		System.out.println(xb.get_number_of_authors(file_name));	
		xb.get_number_of_smth_any_level(file_name, "inproceedings", 0);
		xb.get_number_of_smth_any_level(file_name, "article", 0);
		xb.get_number_of_smth_any_level(file_name, "book", 0);
		//xb.get_number_of_smth_any_level(file_name, "incollection", 0);*/
		
		/*System.out.println("user story 2");
		xb.get_number_of_sth_per_authors(file_name,null);
		xb.get_number_of_sth_per_authors(file_name, "inproceedings");
		xb.get_number_of_sth_per_authors(file_name, "article");
		xb.get_number_of_sth_per_authors(file_name, "book");
		xb.get_number_of_sth_per_authors(file_name, "incollection");*/
		
		/*System.out.println("user story 3");
		xb.get_number_of_sth_per_year(file_name,null);
		xb.get_number_of_sth_per_year(file_name,"inproceedings");
		xb.get_number_of_sth_per_year(file_name,"article");
		xb.get_number_of_sth_per_year(file_name,"book");
		xb.get_number_of_sth_per_year(file_name,"incollection");
		*/
		
		/*System.out.println("user story 4");*/
		xb.get_number_of_authors_wrote_pblications_for_each_year(file_name,null);/*
		xb.get_number_of_authors_wrote_pblications_for_each_year(file_name,"inproceedings");
		xb.get_number_of_authors_wrote_pblications_for_each_year(file_name,"article");
		xb.get_number_of_authors_wrote_pblications_for_each_year(file_name,"book");
		xb.get_number_of_authors_wrote_pblications_for_each_year(file_name,"incollection");*/
		
	}

	/*
	
	@Test

	
	@Test
	public void should_support_number_of_authors_who_wrotes_publications_for_each_year() throws Exception{
		String file_name = "dblp_3.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.get_number_of_authors_wrote_pblications_for_each_year(file_name);
	}
	
	@Test
	public void should_support_all_years_in_file() throws Exception{
		String file_name = "dblp_3.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.get_all_years_in_file(file_name, "");
	}
	
	@Test
	public void should_support_number_of_authors_who_wrotes_publications_for_each_year() throws Exception{
		String file_name = "dblp_3.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.get_number_of_authors_wrote_pblications_for_each_year(file_name, "");
	}
	
	
	@Test
	public void should_support_all_years_for_inproceedings() throws Exception{
		String file_name = "dblp_3.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.get_all_years_in_file(file_name, "inproceedings");
	}
	
	@Test
	public void should_support_number_of_authors_who_wrotes_inproceedings_for_each_year() throws Exception{
		String file_name = "dblp_3.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.get_number_of_authors_wrote_pblications_for_each_year(file_name, "inproceedings");
	}*/
	
}
