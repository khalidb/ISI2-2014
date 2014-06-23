package fr.dauphine.publications_analytics.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import fr.dauphine.publications_analytics.src.*;
import javax.xml.transform.Result;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQItem;
import javax.xml.xquery.XQResultSequence;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class FunctionsTask4{

	public ArrayList<Integer> get_all_years_between(int yearMin, int yearMax){
		ArrayList<Integer> years = new ArrayList<Integer>();
		for (int i = yearMin; i <= yearMax; i++)
			years.add(i);
		return years;
	}

	public ArrayList<ArrayList> getListBookAuthors(String file_name, String balise_name, int yearMin, int yearMax){
		//String xml_file = getClass().getResource(file_name).toExternalForm();
		String xml_file = file_name;
		String name = balise_name;
		if (balise_name==null || balise_name.isEmpty()){
			balise_name ="*";
			name ="publications";
		}
		else name = balise_name;

		//creation du tableau d'arraylist
		ArrayList<ArrayList> donnees =  new ArrayList<ArrayList>();

		String query = "for $x in doc(\"" +xml_file+ "\")/dblp/" +balise_name;	
		if (yearMin != 0 && yearMax == 0){ query += " where $x/year = "+yearMin;}
		else if (yearMin != 0 && yearMax != 0){ query += " where $x/year >= "+yearMin+" and $x/year <= "+yearMax;}
		query += " return (data($x/@key), $x/year/text(), $x/author/text())";

		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			XQResultSequence seq =exp.executeQuery(query);

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
		return donnees;		
	}

	public void NamesOfCoAuthorsByYear(String file_name, String balise_name, int yearMin, int yearMax){
		if(yearMin != 0 && yearMax !=0){
			for(int i =yearMin; i <= yearMax; i++){
				System.out.println(i+" :\n"+AffichageNameOfCoAuthorsByYears(NamesOfCoAuthors(file_name, balise_name, i, 0)));
			}
		} else if(yearMin == 0 && yearMax ==0){
			FunctionsTask3 x = new FunctionsTask3();
			ArrayList<String> yearsString =  x.get_all_years_in_file(file_name, balise_name);
			ArrayList<Integer> years = new ArrayList<Integer>();
			for (int j=0;j<yearsString.size();j++){
				years.add(Integer.parseInt(yearsString.get(j)));
			}
			Collections.sort(years);
			for(int i =years.get(0); i <= years.get(years.size()-1); i++){
				System.out.println(i+" : \n"+AffichageNameOfCoAuthorsByYears(NamesOfCoAuthors(file_name, balise_name, i, 0)));
				//NamesOfCoAuthors(file_name, balise_name, i, 0));
			}
		} else if ((yearMin != 0 && yearMax == 0)||(yearMin == 0 && yearMax != 0)){
			int i = yearMin != 0 ? yearMin : yearMax; 
			System.out.println(i+" : \n"+AffichageNameOfCoAuthorsByYears(NamesOfCoAuthors(file_name, balise_name, i, 0)));
			//NamesOfCoAuthors(file_name, balise_name, i, 0));
		}
	}
	
	public void NamesOfCoAuthorsWithoutYearDisplay(String file_name, String balise_name, int yearMin, int yearMax){
		System.out.println(AffichageNameOfCoAuthorsByYears(NamesOfCoAuthors(file_name, balise_name, yearMin, yearMax)));
	}

	public Map<String, ArrayList> NamesOfCoAuthors(String file_name, String balise_name, int yearMin, int yearMax){
		ArrayList<ArrayList> result = getListBookAuthors( file_name,balise_name, yearMin, yearMax);
		Map<String, ArrayList> authors= new HashMap<String, ArrayList>();
		for(int i =0;i<result.size();i++){
			for(int l=2;l<result.get(i).size();l++){
				String key = result.get(i).get(l).toString();
				if (!authors.containsKey(key))
					//on crée l'entre pour l'autheur 
					authors.put(key, new ArrayList());
				//on ajoute tous les voisins 
				for (int j = 2; j< result.get(i).size(); j++){
					//si l'autheur n'appartient pas encore à la liste des coautheurs pour cette année la
					if (!authors.get(key).contains(result.get(i).get(j))&&(!key.equals(result.get(i).get(j))))
						authors.get(key).add(result.get(i).get(j));
				}
			}
		}
		return authors;
	}

	public String AfficherAuthors(String author, ArrayList<String> coauthors){
		return author+"("+coauthors.size()+")";
		
	}
	public String AffichageNameOfCoAuthorsByYears(Map<String, ArrayList> list){
		ArrayList<String> authors= new ArrayList<String>();
		String res = "";
		for (String key : list.keySet()){
			ArrayList<String> coAuthors = list.get(key);
			String coath = "";
			for (int j= 0; j < coAuthors.size(); j++){
				coath+=AfficherAuthors(coAuthors.get(j), list.get(coAuthors.get(j)))+ ";";
			}
			res += AfficherAuthors(key, coAuthors)+" : "+coath+"\n";
		}
		return res;
	}
}