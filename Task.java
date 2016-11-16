import java.util.*;
import java.lang.*;
import java.io.*;

public class Task{
	String task_id;
	int[] deadline= new int[3];
	String task_name;
	String task_description;
	String department;
	String supervisor; //contains username of supervisor
	String status;
	ArrayList<String> staff= new ArrayList<String>();   //contains username of staff

	Task(String[] a){
		task_id=a[0];
		deadline[0]=Integer.parseInt(a[1]);
		deadline[1]=Integer.parseInt(a[2]);
		deadline[2]=Integer.parseInt(a[3]);
		task_name=a[4];
		task_description=a[5];
		department=a[6];
		supervisor=a[7];
		status=a[8];
		int i;
		List<String> l = Arrays.<String>asList(a);

		// if List<String> isnt specific enough:
		ArrayList<String> al = new ArrayList<String>(l);
		for(i=9;i<al.size();i++){
			staff.add(al.get(i));
		}	
	}

	public void get_info(String a, int[] b, String c, String d, String e, String f, String g, ArrayList<String> h){
		task_id=a;
		deadline=b;
		task_name=c;
		task_description=d;
		department=e;
		supervisor=f;
		status=g;
		staff=h;	
	}

	public void add_info(Main a){
		
	}
}