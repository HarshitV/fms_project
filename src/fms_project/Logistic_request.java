package fms_project;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Logistic_request{
	String id;
	ArrayList<Logistic> list_logistic= null;
	String task_id;
	String department;

	Logistic_request(String[] a){
		id=a[0];
        list_logistic=new ArrayList<Logistic>();
		int i;
		List<String> l = Arrays.<String>asList(a);

		// if List<String> isnt specific enough:
		ArrayList<String> al = new ArrayList<String>(l);
		for(i=1;i<al.size()-2;i+=2){
			Logistic b= new Logistic();
			b.equipment=al.get(i);
			b.quantity=Integer.parseInt(al.get(i+1));
			list_logistic.add(b);
		}
		task_id=al.get(al.size()-2);
		department=al.get(al.size()-1);
	}

	Logistic_request(){

	}

	public void get_info(String i, ArrayList<Logistic> a, String t, String d){
		id=i;
		list_logistic=a;
		task_id=t;
		department=d;
	}

	public void add_info(Main a){
        String csvfile=null;
		PrintWriter br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        
        if(department.equals("electricity")){
        	csvfile="electricity_log_req.csv";
        }
        else if(department.equals("av")){
            csvfile="av_log_req.csv";
        }
        else if(department.equals("housekeeping")){
            csvfile="housekeeping_log_req.csv";
        }
        else if(department.equals("security")){
            csvfile="security_log_req.csv";
        }
        else if(department.equals("hvac")){
            csvfile="hvac_log_req.csv";
        }
        else{
            csvfile="GM_log_req.csv";
        }

        try {

            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, true)));
           	br.print(id+",");
            int i;
            for(i=0;i<list_logistic.size();i++){
                br.print(list_logistic.get(i).equipment+","+list_logistic.get(i).quantity+",");
            }
            br.println(task_id+","+department);
           	//br=null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        a.read_database();
	}

    public String toString(){
        return (id+task_id+department);
    }
}