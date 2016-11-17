import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
	department electricity;
	department hvac;
	department security;
	department housekeeping;
	department av;
	gm admin;
	//register reg= new register();
	//login log= new log();

	public void read_database(){
		electricity=new department("electricity");
		hvac= new department("hvac");
		security=new department("security");
		housekeeping=new department("housekeeping");
		av=new department("av");
		String csvfile;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
        	csvfile=("Supervisor.csv");
            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
    			Supervisor g = new Supervisor(data);
    			if(g.department.equals("electricity")){
    				electricity.supervisor = g; 
    			}
    			else if(g.department.equals("housekeeping")){
    				housekeeping.supervisor = g; 
    			}
    			else if(g.department.equals("av")){
    				av.supervisor = g; 
    			}
    			else if(g.department.equals("hvac")){
    				hvac.supervisor = g; 
    			}
    			else if(g.department.equals("security")){
    				security.supervisor = g; 
    			}
         	}
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
        try {
        	csvfile=("GM.csv");
            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
    			admin= new gm(data);
         	}
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

        try {
        	csvfile=("GM_leave.csv");
            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
    			Leave g= new Leave(data);
    			admin.leave_list.add(g);
         	}
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

        try {
        	csvfile=("GM_log_req.csv");
            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Logistic_request ed= new Logistic_request(data);
    			admin.req_list.add(ed);
         	}
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

        try {
            csvfile=("new_Supervisor.csv");
            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Supervisor ed = new Supervisor(data);
                admin.new_Supervisor.add(ed);
            }
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
	} 
    /*
	public void print(){
		System.out.println(admin.username+admin.name+admin.passwd+admin.type+admin.dob+admin.address);
        Staff adm= new Staff();
        adm=electricity.staff.get(0);
        System.out.println(adm.username+adm.name+adm.passwd+adm.type+adm.dob+adm.address+adm.department);
        System.out.println("sakjdfhlakshdf");
	}
    */
	//public void disp_homepage(){

	//}
    /*
	public static void main(String[] args){
		Main a= new Main();
		a.read_database();
		//a.print();
	}
    */
}