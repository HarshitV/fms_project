import java.util.*;
import java.lang.*;
import java.io.*;

public class Logistic_request{
	String id;
	ArrayList<Logistic> list_logistic= new ArrayList<Logistic>();
	String task_id;
	String department;

	Logistic_request(String[] a){
		id=a[0];
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
		BufferedWriter br = null;
        String line = "";
        String cvsSplitBy = ",";
        if(id.equals(a.electricty.supervisor.userid) || id.equals(a.av.supervisor.userid) || id.equals(a.security.supervisor.userid) || id.equals(a.hvac.supervisor.userid) || id.equals(a.housekeeping.supervisor.userid)){
        	csvfile="GM_log_req.csv";
        }
        else if(department.equals("electricity")){
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
        try {

            br = new BufferedWriter(new FileWriter(csvfile));
           	br.append(reason+","+date+","+start_date+","+range+","+end_date+","+user+","+recipient);
           	br=null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}