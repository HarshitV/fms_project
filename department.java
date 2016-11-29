package fms_project;

import java.util.*;
import java.lang.*;
import java.io.*;

public class department{
	ArrayList<Logistic> logistic_list= new ArrayList<Logistic>();
	Supervisor supervisor=null;
	ArrayList<Staff> staff= new ArrayList<Staff>();
	ArrayList<Logistic_request> req_list= new ArrayList<Logistic_request>();
	ArrayList<Task> task_list= new ArrayList<Task>();
	String type=null;
	ArrayList<Leave> leave_list= new ArrayList<Leave>();
    ArrayList<Staff> new_staff=new ArrayList<Staff>();

	department(String a){
        type=a;
		String csvfile;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
        	csvfile=(a+".csv");
            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
    			Staff ed = new Staff(data);
    			staff.add(ed);
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
            csvfile=(a+"_new_staff.csv");
            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Staff ed = new Staff(data);
                new_staff.add(ed);
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
        	csvfile=(a+"_log_req.csv");
            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
    			Logistic_request ed = new Logistic_request(data);
    			req_list.add(ed);         // as per logistic request
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
        	csvfile=(a+"_log.csv");
            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
    			Logistic ed = new Logistic(data);
    			logistic_list.add(ed);         // as per logistic request
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
        	csvfile=(a+"_task.csv");
            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
    			Task ed = new Task(data);
    			task_list.add(ed);         // as per logistic request
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
        	csvfile=(a+"_leave.csv");
            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
    			Leave ed = new Leave(data);
    			leave_list.add(ed);         // as per logistic request
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

    department(){

    }

	public void add_staff(Staff y){
        staff.add(y);
        String csvfile= y.department+".csv";
        PrintWriter br=null;
        String line = "";
        String cvsSplitBy = ",";
        try{
            br = new PrintWriter(new BufferedWriter(new FileWriter(csvfile, true)));
            br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status+"\n");
                        
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                br.close();
            }
        }
	}

	public void set_type(String c){
        type=c;
	}

	public void add_supervisor(Supervisor a){
		supervisor=a;
	}

    public void printkar(){
        System.out.println(logistic_list);
        System.out.println("Supervisor"+supervisor);
        System.out.println("Staff"+staff);
        System.out.println(req_list);
        System.out.println(task_list);
        System.out.println(type);
        System.out.println(leave_list);
        System.out.println(new_staff);
    }
}