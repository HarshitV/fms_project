package fms_project;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Task{
	public static int taskcount=1;
	String task_id;
	int[] deadline= new int[3];
	String task_name;
	String task_description;
	String department;
	String supervisor; //contains username of supervisor
	String status="Not Started";
	ArrayList<String> staff= null;   //contains username of staff

	Task(String[] a){
        staff=new ArrayList<String>();
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

	Task(){

	}
	
	public static int read_id(){
		BufferedReader br=null;
		int r=0;
		try {
			br= new BufferedReader(new FileReader("index.csv"));
			br.readLine();
            String w=br.readLine();
            r=Integer.parseInt(w);
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return r;
	}
	
	public static void write_int(){
		PrintWriter br=null;
		BufferedReader cr=null; 
		try {
			cr= new BufferedReader(new FileReader("index.csv"));
			String q=cr.readLine();
			cr.close();
			br= new PrintWriter(new BufferedWriter(new FileWriter("index.csv")));
			br.println(q);
			br.println(taskcount);
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            if (br != null) {
               br.close();
            }
        }
		
	}
	
	public void get_info(String v, int[] b, String c, String d, String e, String f, String g, ArrayList<String> h, Main a){
		task_id=v;
		deadline=b;
		task_name=c;
		task_description=d;
		department=e;
		supervisor=f;
		status=g;
		staff=h;
		department m= new department();
		if(department.equals("electricity")){
        	m=a.electricity;
        }
        else if(department.equals("av")){
            m=a.av;
        }
        else if(department.equals("housekeeping")){
            m=a.housekeeping;
        }
        else if(department.equals("security")){
            m=a.security;
        }
        else if(department.equals("hvac")){
           m=a.hvac;
        }

	}

	public void add_info(Main a){
		
        String csvfile=null;
		PrintWriter br = null;
        String line = "";
        String cvsSplitBy = ",";
        if(department.equals("electricity")){
        	csvfile="electricity_task.csv";
        }
        else if(department.equals("av")){
            csvfile="av_task.csv";
        }
        else if(department.equals("housekeeping")){
            csvfile="housekeeping_task.csv";
        }
        else if(department.equals("security")){
            csvfile="security_task.csv";
        }
        else if(department.equals("hvac")){
            csvfile="hvac_task.csv";
        }
        try {

            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, true)));
           	br.write(task_id+","+deadline[0]+","+deadline[1]+","+deadline[2]+",");
            br.write(task_name+","+task_description+","+department+",");
            br.write(supervisor+","+status);
            int i;
            if(staff!=null)
            {
            	for(i=0;i<staff.size();i++){
                    br.print(","+staff.get(i));
                }
            }
            
            else
            	br.print(",");
            br.write("\n");
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
        return (task_id+task_name+task_description+department+supervisor+status+staff);
    }
}