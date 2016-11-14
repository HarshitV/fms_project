import java.util.*;
import java.lang.*;
import java.io.*;

public class department{
	ArrayList<Logistic> logistic_list= new ArrayList<Logistic>();
	Supervisor supervisor;
	ArrayList<Staff> staff= new ArrayList<Staff>();
	ArrayList<Logistic_request> req_list= new ArrayList<Logistic_request>();
	ArrayList<Task> task_list= new ArrayList<Task>();
	String type;
	ArrayList<Leave> leave_list= new ArrayList<Leave>();

	department(String a){
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



	public void add_staff(Staff b){
        staff.add(b);
        String csvfile;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
	}

	public void set_type(String c){
        type=c;
	}

	public void add_supervisor(Supervisor a){
		supervisor=a;
	}
}