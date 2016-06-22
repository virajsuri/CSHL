package normalWork;

import java.util.ArrayList;

public class finalExamMethods {
	public String searchName(ArrayList name, ArrayList candidates, String searchToken) {
		System.out.println("Search by Name");
		String results="";
		for(int i=0;i<=name.size()-1;i++) {
			if(name.get(i).equals(searchToken)) {
				results+=name.get(i)+ " voted for "+candidates.get(i)+"\n";
			}
		}
		System.out.println(results);
		return results;
	}
	
	public String searchGender(ArrayList gender, ArrayList candidates, String searchToken) {
		System.out.println("Search by Gender");
		String results="";
		for(int i=0;i<=gender.size()-1;i++) {
			if(gender.get(i).equals(searchToken)) {
				results+=gender.get(i)+ " voted for "+candidates.get(i)+"\n";
			}
		}
		System.out.println(results);
		return results;
	}
	
	public String searchAge(ArrayList age, ArrayList candidates, String searchToken) {
		System.out.println("Search by Age"+ " searching for age"+searchToken);
		System.out.println(age);
		String results="";
		for(int i=0;i<=age.size()-1;i++) {
			if(age.get(i).equals(Integer.parseInt(searchToken))) {
				System.out.println("MATCH");
				results+=age.get(i)+ " voted for "+candidates.get(i)+"\n";
			}
		}
		System.out.println(results);
		return results;
	}

	public String analyze(ArrayList name, ArrayList age, ArrayList gender, ArrayList candidates,int amountOfCandidates ) {
		ArrayList totalPeople = new ArrayList<Integer>();
		
		System.out.println("PRINTINT ARRAYLISTS");
		System.out.println(name);
		System.out.println(age);
		System.out.println(gender);
		System.out.println(candidates);
		
		String results = "";
		int maleCount=0;
		
		int [] voters = new int[amountOfCandidates];
		for(int i=0;i<gender.size()-1;i++) {
			if(gender.get(i).equals("Male")){
				for(int j=0; j<amountOfCandidates;i++) {
//					if(candidates.get(i).equals(""))
				}
			}
		}
		System.out.println(maleCount);

		
		
		
		
		return results;
		
	}
}
