package fr.dauphine.publications_analytics.test;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.FunctionsTask3;

public class TestTask3 {
	/*
	@Test
	public void MMMNumberOfAuhthorsPerPublications()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		//xb.get_number_of_smth_any_level(file_name, "*", 0);
		xb.MMMNumberOfAuhthorsPerSomething(file_name, "*");
	}
	
	@Test
	public void MMMNumberOfAuhthorsPerArticle()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		//xb.get_number_of_smth_any_level(file_name, "*", 0);
		xb.MMMNumberOfAuhthorsPerSomething(file_name, "article");
	}
	
	
	@Test
	public void MMMNumberOfAuhthorsPerInproceeding()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		//xb.get_number_of_smth_any_level(file_name, "*", 0);
		xb.MMMNumberOfAuhthorsPerSomething(file_name, "inproceedings");
	}
	
	
	@Test
	public void MMMNumberOfAuhthorsPerIncollection()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		//xb.get_number_of_smth_any_level(file_name, "*", 0);
		xb.MMMNumberOfAuhthorsPerSomething(file_name, "incollection");
	}
	@Test
	public void MMMNumberOfAuhthorsPerBook()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		//xb.get_number_of_smth_any_level(file_name, "*", 0);
		xb.MMMNumberOfAuhthorsPerSomething(file_name, "book");
	}
	
	
	@Test
	public void MMMNumberOfPublicationsPerAuthors()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumberOfSometingPerAuthor(file_name, "*");
	}
	
	@Test
	public void MMMNumberOfArticlePerAuthors()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumberOfSometingPerAuthor(file_name, "article");
	}
	@Test
	public void MMMNumberOfUnproceedingsPerAuthors()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumberOfSometingPerAuthor(file_name, "inproceedings");
	}
	*/
	@Test
	public void MMMNumberOfBookPerAuthors()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		FunctionsTask3 xb = new FunctionsTask3();
		xb.MMMNumberOfSometingPerAuthor(file_name, "book");
	}
	/*
	@Test
	public void MMMNumberOfIncollectionsPerAuthors()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumberOfSometingPerAuthor(file_name, "incollection");
	}
	
	
	/*
	@Test
	public void MMMNumberOfPublicationsPerYear()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumberOfSometingPerYear(file_name, "*");
	}
	@Test
	public void MMMNumberOfIncollectionsPerYear()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumberOfSometingPerYear(file_name, "incollection");
	}

	@Test
	public void MMMNumberOfBookPerYear()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumberOfSometingPerYear(file_name, "book");
	}
	
	@Test
	public void MMMNumberOfArticlePerYear()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumberOfSometingPerYear(file_name, "article");
	}
	
	@Test
	public void MMMNumberOfUnproceedingsPerYear()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumberOfSometingPerYear(file_name, "inproceedings");
	}
	*/
	/*
	@Test
	public void MMM_publications_for_each_year()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumber_of_authors_wrote_somethings_for_each_year(file_name, "*");
	}
	/*
	@Test
	public void MMM_unproceedings_for_each_year()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumber_of_authors_wrote_somethings_for_each_year(file_name, "inproceedings");
	}
	@Test
	public void MMM_incollecion_for_each_year()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumber_of_authors_wrote_somethings_for_each_year(file_name, "incollection");
	}
	@Test
	public void MMM_book_for_each_year()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumber_of_authors_wrote_somethings_for_each_year(file_name, "book");
	}
	
	@Test
	public void MMM_article_for_each_year()throws Exception{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication2 xb = new XMLPublication2();
		xb.MMMNumber_of_authors_wrote_somethings_for_each_year(file_name, "article");
	}
	
	*/
	
	
}
