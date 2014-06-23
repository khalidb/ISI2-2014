package fr.dauphine.publications_analytics.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQItem;
import javax.xml.xquery.XQResultSequence;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class FunctionsTask3 {

	/*Nombre de balise et le niveau*/
	public int get_number_of_smth_any_level(String file_name, String balise_name,int number_lvl) {
		StringBuffer sb = new StringBuffer();
		for (int i =0;i<number_lvl;i++)
			sb.append("*/");

		int number_of_smth = 0;
		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/"+sb.toString()+balise_name+" return 1)";

		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();


			XQSequence seq = exp.executeQuery(query);			

			seq.next();

			number_of_smth = seq.getInt();

			if(balise_name.equals("*"))
				balise_name = "publication";
			System.out.println("Number of "+balise_name +" of is "+number_of_smth);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_smth;
	}

	public int get_number_of_authors(String file_name) {
			String xml_file = getClass().getResource(file_name).toExternalForm();
			String yearQuery = "for $x in doc(\"" +xml_file+ "\")/dblp" +
					" return $x/*/author/text()";
			ArrayList<String> authors = new ArrayList<String>();
			
			try{
				XQDataSource ds = new SaxonXQDataSource();
				XQConnection conn = ds.getConnection();
				XQExpression exp = conn.createExpression();
				XQResultSequence seq =exp.executeQuery(yearQuery);
				
				
				String author;
				while(seq.next()){
					author= seq.getItemAsString(null);
					// si ma clé existe deja
					if (!authors.contains(author)){
						authors.add(author);
					}
				}
				seq.close();	
			} catch (XQException err) {
				System.out.println("Failed as expected: " + err.getMessage());
			}
			return authors.size();
	}
	
	public void get_number_of_sth_per_authors(String file_name,String balise_name){
		String xml_file = getClass().getResource(file_name).toExternalForm();
		String name = balise_name;
		if (balise_name==null || balise_name.isEmpty()){
			balise_name ="*";
			name ="publications";
		}
		else name = balise_name;
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return $x/"+balise_name+"/author/text()";
		System.out.println("XQuery query:"+query);
		System.out.println("Number of "+name +" for each autor:");
		Map<String, Integer> authors = new HashMap<String, Integer>();
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression(); 
			String author = new String();
			XQResultSequence seq =exp.executeQuery(query);;


			while(seq.next()){
				author= seq.getItemAsString(null);
				// si ma clé existe deja
				if (authors.containsKey(author)){
					authors.put(author, authors.get(author)+1);
				}
				else //sinon ajouter nouveau
					authors.put(author,(Integer) 1);
			}
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		Iterator iterator = authors.keySet().iterator();  

		while (iterator.hasNext()) {
			String key = iterator.next().toString();  
			String value = authors.get(key).toString();  
			System.out.println("Number of "+name+" for " +key + " is " + value);  
		}  
	}


	public void get_number_of_sth_per_year(String file_name,String balise_name){
		String xml_file = getClass().getResource(file_name).toExternalForm();
		String name = balise_name;
		if (balise_name==null || balise_name.isEmpty()){
			balise_name ="*";
			name ="publications";
		}
		else name = balise_name;
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return $x/"+balise_name+"/year/text()";
		System.out.println("XQuery query:"+query);
		System.out.println("Number of "+name +" for each year:");
		Map<String, Integer> authors = new HashMap<String, Integer>();
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			//XQSequence seq = 
			String author = new String();
			XQResultSequence seq =exp.executeQuery(query);;


			while(seq.next()){
				author= seq.getItemAsString(null);
				// si ma clé existe deja
				if (authors.containsKey(author)){
					authors.put(author, authors.get(author)+1);
				}
				else //sinon ajouter nouveau
					authors.put(author,(Integer) 1);
			}
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		Iterator iterator = authors.keySet().iterator();  

		while (iterator.hasNext()) {
			String key = iterator.next().toString();  
			String value = authors.get(key).toString();  
			System.out.println("Number of "+name+" for " +key + " is " + value);  
		}  
	}
	
	public ArrayList<String> get_all_years_in_file(String file_name, String balise_name){
		if (balise_name==null || balise_name.isEmpty()){
			balise_name ="*";
		}
		
		//String xml_file = getClass().getResource(file_name).toExternalForm();
		String xml_file = file_name;
		String yearQuery = "for $x in doc(\"" +xml_file+ "\")/dblp" +
				" return $x/"+balise_name+"/year/text()";
		ArrayList<String> years = new ArrayList<String>();
		
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			XQResultSequence seq =exp.executeQuery(yearQuery);
			
			
			String year;
			while(seq.next()){
				year= seq.getItemAsString(null);
				// si ma clé existe deja
				if (!years.contains(year)){
					years.add(year);
				}
			}
			seq.close();	
			System.out.println(years);
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		return years;
	}

	public void get_number_of_authors_wrote_pblications_for_each_year(String file_name, String balise_name){
		String xml_file = getClass().getResource(file_name).toExternalForm();
		String name = balise_name;
		if (balise_name==null || balise_name.isEmpty()){
			balise_name ="*";
			name ="publications";
		}
		else name = balise_name;
		
		ArrayList<String> years = get_all_years_in_file(file_name, balise_name);
		for(int i =0; i< years.size(); i++){
			String year = years.get(i);
			String query = "for $x in doc(\"" +xml_file+ "\")/dblp/"+balise_name +
					" where $x/year = "+year+" return $x/author/text()";	
			Map<String, Integer> authors = new HashMap<String, Integer>();
			try{
				XQDataSource ds = new SaxonXQDataSource();
				XQConnection conn = ds.getConnection();
				XQExpression exp = conn.createExpression();
				String author = new String();
				XQResultSequence seq =exp.executeQuery(query);
				
				while(seq.next()){
					author= seq.getItemAsString(null);
					// si ma clé existe deja
					if (authors.containsKey(author)){
						authors.put(author, authors.get(author)+1);
					}
					else //sinon ajouter nouveau
						authors.put(author,(Integer) 1);
				}
				seq.close();
				System.out.println("In "+year+" "+authors.size()+" authors wrote " +name);
			} catch (XQException err) {
				System.out.println("Failed as expected: " + err.getMessage());
			}			
		}
	}

	public void MMMNumberOfAuhthorsPerSomething(String file_name, String balise_name) {
		String xml_file = getClass().getResource(file_name).toExternalForm();
		String name = balise_name;
		if (balise_name==null || balise_name.isEmpty()){
			balise_name ="*";
			name ="publication";
		}
		else name = balise_name;
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp/"+balise_name+
				" return count(for $y in $x/author return 1)";
		
		System.out.println("XQuery query:"+query);
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression(); 
			String author = new String();
			XQResultSequence seq =exp.executeQuery(query);
			
			while(seq.next()){
				result.add(seq.getInt());
			}
			seq.close();
			if(result.size()>0)
			  this.getMMM(result);
			else System.out.println("No result for "+balise_name);
			
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}		
	}
	public int getNumberOfAuthor(String file_name){
		String xml_file = getClass().getResource(file_name).toExternalForm();
		String balise_name ="*";
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return $x/"+balise_name+"/author/text()";
		Map<String, Integer> authors = new HashMap<String, Integer>();
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression(); 
			String author = new String();
			XQResultSequence seq =exp.executeQuery(query);;


			while(seq.next()){
				author= seq.getItemAsString(null);
				// si ma clé existe deja
				if (authors.containsKey(author)){
					authors.put(author, authors.get(author)+1);
				}
				else //sinon ajouter nouveau
					authors.put(author,(Integer) 1);
			}
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());	
		}
		return (authors.size());
	}
	public void getMMM(ArrayList<Integer> result){
		double moyenne = 0;
		double mediane = 0;
		int mode = 0;
		//ordonner la arraylist
		Collections.sort(result);
		
		//moyenne
		for (int i = 0; i < result.size(); i++)
			moyenne += result.get(i);
		moyenne = moyenne/ result.size();
		//mediane
		//pair
		if (result.size() % 2 == 0){
			mediane = (result.get((result.size()/2)-1) + result.get(result.size()/2));
			mediane /=2;
		}
		//impair
		else {
			mediane = result.get(result.size()/2);
		}
		
		//mode
		Map<Integer, Integer> effectifs = new HashMap<Integer, Integer>();
		for (int i = 0; i < result.size(); i++){
			// si ma clé existe deja
			if (effectifs.containsKey(result.get(i)))
				effectifs.put(result.get(i), effectifs.get(result.get(i))+1);
			else 
				effectifs.put(result.get(i),(Integer)1);
		}

		mode = result.get(0);
		int maxmode = effectifs.get(mode);
		int max = Collections.max(effectifs.values());
		Iterator iterator = effectifs.keySet().iterator();  
		System.out.print("mode: ");
		while (iterator.hasNext()) {
			Integer key = (Integer)iterator.next(); 
			if(effectifs.get(key) == max)
				System.out.print(key +";");
		} 
		System.out.println();
		System.out.println("moyenne : "+ moyenne);
		System.out.println("mediane : "+ mediane);
	}	
	
	
	public void MMMNumberOfSometingPerAuthor(String file_name, String balise_name) {
		int nombre_author = getNumberOfAuthor(file_name);
		//System.out.println("nombre d'auteurs" +nombre_author);
		String xml_file = getClass().getResource(file_name).toExternalForm();
		String name = balise_name;
		if (balise_name==null || balise_name.isEmpty()){
			balise_name ="*";
			name ="publication";
		}
		else name = balise_name;
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return $x/"+balise_name+"/author/text()";
		
		System.out.println("XQuery query:"+query);
		System.out.println("Number of "+name +" for each autor:");
		Map<String, Integer> authors = new HashMap<String, Integer>();
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression(); 
			String author = new String();
			XQResultSequence seq =exp.executeQuery(query);;


			while(seq.next()){
				author= seq.getItemAsString(null);
				// si ma clé existe deja
				if (authors.containsKey(author)){
					authors.put(author, authors.get(author)+1);
				}
				else //sinon ajouter nouveau
					authors.put(author,(Integer) 1);
			}
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());	
		}
		
		System.out.println(authors.toString());
		System.out.println(authors.values());
		if(authors.size()>0){
			ArrayList<Integer> liste= new ArrayList<Integer>(authors.values());
			int difference = nombre_author - authors.size();
			for(int y =0;y<difference;y++)
				liste.add(0);
			this.getMMM(liste);
		}
			else System.out.println("No result for "+balise_name);
		
	}
	
	public void MMMNumberOfSometingPerYear(String file_name, String balise_name){
		String xml_file = getClass().getResource(file_name).toExternalForm();
		String name = balise_name;
		if (balise_name==null || balise_name.isEmpty()){
			balise_name ="*";
			name ="publications";
		}
		else name = balise_name;
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return $x/"+balise_name+"/year/text()";
		System.out.println("XQuery query:"+query);
		System.out.println("Number of "+name +" for each year:");
		Map<String, Integer> authors = new HashMap<String, Integer>();
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			//XQSequence seq = 
			String author = new String();
			XQResultSequence seq =exp.executeQuery(query);;


			while(seq.next()){
				author= seq.getItemAsString(null);
				// si ma clé existe deja
				if (authors.containsKey(author)){
					authors.put(author, authors.get(author)+1);
				}
				else //sinon ajouter nouveau
					authors.put(author,(Integer) 1);
			}
			seq.close();
			System.out.println(authors);

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}  
		
		ArrayList<String> years = get_all_years_in_file(file_name, balise_name);
		if(years.size() >0){
		int yearmin = Integer.parseInt(years.get(0));
		int yearmax = yearmin;
		
		for (int i = 0; i < years.size(); i++){
			int currentyear = Integer.parseInt(years.get(i));
			if (currentyear < yearmin)
				yearmin = currentyear;
			if (currentyear > yearmax)
				yearmax = currentyear;
		}
		System.out.println("year max:" +yearmax);
		System.out.println("year min:" +yearmin);
		
		if(authors.size()>0){
			ArrayList<Integer> liste= new ArrayList<Integer>(authors.values());
			int difference = yearmax - yearmin - authors.size() + 1;
			for(int y =0;y<difference;y++)
				liste.add(0);
			System.out.println(liste);
			this.getMMM(liste);
		}
			else System.out.println("No result for "+balise_name);
		
		}
		else System.out.println("No result for "+balise_name);
	}
	public boolean estEntier(String chaine){
		try{
			Integer.parseInt(chaine);
		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	public void MMMNumber_of_authors_wrote_somethings_for_each_year(String file_name, String balise_name){
		String xml_file = getClass().getResource(file_name).toExternalForm();
		String name = balise_name;
		if (balise_name==null || balise_name.isEmpty()){
			balise_name ="*";
			name ="publications";
		}
		else name = balise_name;
		
		ArrayList<String> years = get_all_years_in_file(file_name, balise_name);
		int yearmin = Integer.parseInt(years.get(0));
		int yearmax = yearmin;
		
		for (int i = 0; i < years.size(); i++){
			int currentyear = Integer.parseInt(years.get(i));
			if (currentyear < yearmin)
				yearmin = currentyear;
			if (currentyear > yearmax)
				yearmax = currentyear;
		}
		System.out.println("year max:" +yearmax);
		System.out.println("year min:" +yearmin);
		//creation du tableau d'arraylist
		ArrayList<ArrayList> donnees =  new ArrayList<ArrayList>();
		for(int i = yearmin;i<yearmax;i++){
			ArrayList a = new ArrayList();
			a.add(i);
			donnees.add(a);
		}
		//,data($x/@key) pour récupérer un attribut
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp/" +balise_name+
				" return ($x/year/text(), $x/author/text())";
		
		System.out.println("XQuery query:"+query);
		
		ArrayList<String> publications = new ArrayList<String>();
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			String author = new String();
			XQResultSequence seq =exp.executeQuery(query);
			
			int currentList = 0;
			while(seq.next()){
				String element = seq.getItemAsString(null);
				if(estEntier(element)){
					for(int i = 0; i < donnees.size(); i ++){
						if((Integer)donnees.get(i).get(0) == Integer.parseInt(element)){
							currentList = i;
						}
					}
				}else{
					if (!donnees.get(currentList).contains(element))
					donnees.get(currentList).add(element);
				}
			}
			seq.close();
			
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}  
		System.out.println(donnees);
		ArrayList<Integer>result = new ArrayList<Integer>();
		for(int j=0;j< donnees.size();j++){
			result.add(donnees.get(j).size()-1);
		}
		System.out.println(result);
		getMMM(result);
	}
	
	public void NamesOfCoAuthors(String file_name, String balise_name){
		System.out.println("ici");
		String xml_file = getClass().getResource(file_name).toExternalForm();
		String name = balise_name;
		if (balise_name==null || balise_name.isEmpty()){
			balise_name ="*";
			name ="publications";
		}
		else name = balise_name;
		System.out.println("ici");
		//creation du tableau d'arraylist
		ArrayList<ArrayList> donnees =  new ArrayList<ArrayList>();
		//,data($x/@key) pour récupérer un attribut
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp/" +balise_name+
				" return (data($x/@key), $x/author/text())";
		
		System.out.println("XQuery query:"+query);
		
		//ArrayList<String> publications = new ArrayList<String>();
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			String author = new String();
			XQResultSequence seq =exp.executeQuery(query);
			
			int currentList = 0;
			while(seq.next()){
				String element = seq.getItemAsString(null);
				if(element.contains("/")){
					ArrayList book = new ArrayList();
					book.add(element);
					donnees.add(book);
				}else{
					donnees.get(donnees.size()-1).add(element);
				}
			}
			seq.close();
			
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}  
		System.out.println(donnees);
	/*	ArrayList<Integer>result = new ArrayList<Integer>();
		for(int j=0;j< donnees.size();j++){
			result.add(donnees.get(j).size()-1);
		}
		System.out.println(result);
		getMMM(result);*/
		
	}
			
}
