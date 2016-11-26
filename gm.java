import java.util.*;
import java.lang.*;
import java.io.*;

public class gm extends User{
	ArrayList<Logistic_request> req_list= new ArrayList<Logistic_request>();
	ArrayList<Leave> leave_list= new ArrayList<Leave>();
	ArrayList<Supervisor> new_Supervisor= new ArrayList<Supervisor>();

	gm(String[] a){
		username=a[0];
		name=a[1];
		passwd=a[2];
		userid=a[3];
		type=a[4];
		dob=a[5];
		address=a[6];
		//department=a[7];
	}

	public void approve_user_supervisor(Main a, int i){
		Supervisor b= new_Supervisor.get(i);
		new_Supervisor.remove(i);
		if(b.department.equals("electricity")){
			a.electricity.add_supervisor(b);
		}
		else if(b.department.equals("hvac")){
			a.hvac.add_supervisor(b);
		}
		else if(b.department.equals("av")){
			a.av.add_supervisor(b);
		}
		else if(b.department.equals("security")){
			a.security.add_supervisor(b);
		}
		else if(b.department.equals("housekeeping")){
			a.housekeeping.add_supervisor(b);
		}

		String csvfile=null;
		PrintWriter br = null;
        String line = "";
        String cvsSplitBy = ",";

		try {
			csvfile="Supervisor.csv";
            br = new PrintWriter(new BufferedWriter(new FileWriter(csvfile,true)));
           	br.append(b.username+","+b.name+","+b.passwd+","+b.userid+","+b.type+","+b.dob+","+b.address+","+b.department);
           	//br=null;
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
        /*

        try {
			csvfile="new_Supervisor.csv";
            br = new BufferedWriter(new FileWriter(csvfile, false));
           	br.write(a.electricity.supervisor.username+","+a.electricity.supervisor.name+","+a.electricity.supervisor.passwd+","+a.electricity.supervisor.userid+","+a.electricity.supervisor.type+","+a.electricity.supervisor.dob+","+a.electricity.supervisor.address+","+a.electricity.supervisor.department);
            br.write(a.hvac.supervisor.username+","+a.hvac.supervisor.name+","+a.hvac.supervisor.passwd+","+a.hvac.supervisor.userid+","+a.hvac.supervisor.type+","+a.hvac.supervisor.dob+","+a.hvac.supervisor.address+","+a.hvac.supervisor.department);
           	br.write(a.housekeeping.supervisor.username+","+a.housekeeping.supervisor.name+","+a.housekeeping.supervisor.passwd+","+a.housekeeping.supervisor.userid+","+a.housekeeping.supervisor.type+","+a.housekeeping.supervisor.dob+","+a.housekeeping.supervisor.address+","+a.housekeeping.supervisor.department);
           	br.write(a.security.supervisor.username+","+a.security.supervisor.name+","+a.security.supervisor.passwd+","+a.security.supervisor.userid+","+a.security.supervisor.type+","+a.security.supervisor.dob+","+a.security.supervisor.address+","+a.security.supervisor.department);
           	br.write(a.av.supervisor.username+","+a.av.supervisor.name+","+a.av.supervisor.passwd+","+a.av.supervisor.userid+","+a.av.supervisor.type+","+a.av.supervisor.dob+","+a.av.supervisor.address+","+a.av.supervisor.department);
           	//br=null;
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
        */

        try {
        	int j;
			csvfile="new_Supervisor.csv";
            br = new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
            for(j=0;j<new_Supervisor.size();j++){
           		br.write(new_Supervisor.get(j).username+","+new_Supervisor.get(j).name+","+new_Supervisor.get(j).passwd+","+new_Supervisor.get(j).userid+","+new_Supervisor.get(j).type+","+new_Supervisor.get(j).dob+","+new_Supervisor.get(j).address+","+new_Supervisor.get(j).department);
           	}
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

    public void approve_user_staff(Main a, String v){
        PrintWriter br;
        String csvfile;
        int flag=0,i;
        if(flag==0){
            for(i=0;i<((a.electricity).new_staff).size();i++){
                Staff g=((a.electricity).new_staff).get(i);
                if(g.username.equals(v)){
                    ((a.electricity).new_staff).remove(i);
                    int j;
                    try{
                        for(j=0;j<((a.electricity).new_staff).size();j++){
                            Staff y=((a.electricity).new_staff).get(j);
                            csvfile=a.electricity.type+"_new_staff.csv";
                            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
                            br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status);
                        } 
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (br != null) {
                            br.close();
                        }
                    }
                    flag=1;
                    a.electricity.add_staff(g);
                    break;
                }
            }
        }
        else if(flag==0){
            for(i=0;i<((a.hvac).new_staff).size();i++){
                Staff g=((a.hvac).new_staff).get(i);
                if(g.username.equals(v)){
                    ((a.hvac).new_staff).remove(i);
                    int j;
                    try{
                        for(j=0;j<((a.hvac).new_staff).size();j++){
                            Staff y=((a.hvac).new_staff).get(j);
                            csvfile=a.hvac.type+"_new_staff.csv";
                            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
                            br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status);
                        } 
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (br != null) {
                            br.close();
                        }
                    }
                    flag=1;
                    a.hvac.add_staff(g);
                    break;
                }
            }   
        }
        else if(flag==0){
            for(i=0;i<((a.av).new_staff).size();i++){
                Staff g=((a.av).new_staff).get(i);
                if(g.username.equals(v)){
                    ((a.av).new_staff).remove(i);
                    int j;
                    try{
                        for(j=0;j<((a.av).new_staff).size();j++){
                            Staff y=((a.av).new_staff).get(j);
                            csvfile=a.av.type+"_new_staff.csv";
                            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
                            br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status);
                        } 
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (br != null) {
                            br.close();
                        }
                    }
                    flag=1;
                    a.av.add_staff(g);
                    break;
                }
            }   
        }
        else if(flag==0){
            for(i=0;i<((a.security).new_staff).size();i++){
                Staff g=((a.security).new_staff).get(i);
                if(g.username.equals(v)){
                    ((a.security).new_staff).remove(i);
                    int j;
                    try{
                        for(j=0;j<((a.security).new_staff).size();j++){
                            Staff y=((a.security).new_staff).get(j);
                            csvfile=a.security.type+"_new_staff.csv";
                            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
                            br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status);
                        } 
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (br != null) {
                            br.close();
                        }
                    }
                    flag=1;
                    a.security.add_staff(g);
                    break;
                }
            }   
        }
        else if(flag==0){
            for(i=0;i<((a.housekeeping).new_staff).size();i++){
                Staff g=((a.housekeeping).new_staff).get(i);
                if(g.username.equals(v)){
                    ((a.housekeeping).new_staff).remove(i);
                    int j;
                    try{
                        for(j=0;j<((a.housekeeping).new_staff).size();j++){
                            Staff y=((a.housekeeping).new_staff).get(j);
                            csvfile=a.housekeeping.type+"_new_staff.csv";
                            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
                            br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status);
                        } 
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (br != null) {
                            br.close();
                        }
                    }
                    flag=1;
                    a.housekeeping.add_staff(g);
                    break;
                }
            }   
        }
    }

	public void reject_user_supervisor(Main a, int i){
        Supervisor b= new_Supervisor.get(i);
        new_Supervisor.remove(i);
         PrintWriter br;
         String csvfile;
         try {
            int j;
            csvfile="new_Supervisor.csv";
            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
            for(j=0;j<new_Supervisor.size();j++){
                br.write(new_Supervisor.get(j).username+","+new_Supervisor.get(j).name+","+new_Supervisor.get(j).passwd+","+new_Supervisor.get(j).userid+","+new_Supervisor.get(j).type+","+new_Supervisor.get(j).dob+","+new_Supervisor.get(j).address+","+new_Supervisor.get(j).department);
            }
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

    public void reject_user_staff(Main a, String v){
         String csvfile;
          PrintWriter br;
        int flag=0, i;
        if(flag==0){
            for(i=0;i<((a.electricity).new_staff).size();i++){
                Staff g=((a.electricity).new_staff).get(i);
                if(g.username.equals(v)){
                    ((a.electricity).new_staff).remove(i);
                    int j;
                    try{
                        for(j=0;j<((a.electricity).new_staff).size();j++){
                            Staff y=((a.electricity).new_staff).get(j);
                            csvfile=a.electricity.type+"_new_staff.csv";
                            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
                            br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status);
                        } 
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (br != null) {
                            br.close();
                        }
                    }
                    flag=1;
                    //a.electricity.add_staff(g);
                    break;
                }
            }
        }
        else if(flag==0){
            for(i=0;i<((a.hvac).new_staff).size();i++){
                Staff g=((a.hvac).new_staff).get(i);
                if(g.username.equals(v)){
                    ((a.hvac).new_staff).remove(i);
                    int j;
                    try{
                        for(j=0;j<((a.hvac).new_staff).size();j++){
                            Staff y=((a.hvac).new_staff).get(j);
                            csvfile=a.hvac.type+"_new_staff.csv";
                            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
                            br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status);
                        } 
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (br != null) {
                            br.close();
                        }
                    }
                    flag=1;
                    //a.hvac.add_staff(g);
                    break;
                }
            }   
        }
        else if(flag==0){
            for(i=0;i<((a.av).new_staff).size();i++){
                Staff g=((a.av).new_staff).get(i);
                if(g.username.equals(v)){
                    ((a.av).new_staff).remove(i);
                    int j;
                    try{
                        for(j=0;j<((a.av).new_staff).size();j++){
                            Staff y=((a.av).new_staff).get(j);
                            csvfile=a.av.type+"_new_staff.csv";
                            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
                            br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status);
                        } 
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (br != null) {
                            br.close();
                        }
                    }
                    flag=1;
                    //a.av.add_staff(g);
                    break;
                }
            }   
        }
        else if(flag==0){
            for(i=0;i<((a.security).new_staff).size();i++){
                Staff g=((a.security).new_staff).get(i);
                if(g.username.equals(v)){
                    ((a.security).new_staff).remove(i);
                    int j;
                    try{
                        for(j=0;j<((a.security).new_staff).size();j++){
                            Staff y=((a.security).new_staff).get(j);
                            csvfile=a.security.type+"_new_staff.csv";
                            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
                            br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status);
                        } 
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (br != null) {
                            br.close();
                        }
                    }
                    flag=1;
                    //a.security.add_staff(g);
                    break;
                }
            }   
        }
        else if(flag==0){
            for(i=0;i<((a.housekeeping).new_staff).size();i++){
                Staff g=((a.housekeeping).new_staff).get(i);
                if(g.username.equals(v)){
                    ((a.housekeeping).new_staff).remove(i);
                    int j;
                    try{
                        for(j=0;j<((a.housekeeping).new_staff).size();j++){
                            Staff y=((a.housekeeping).new_staff).get(j);
                            csvfile=a.housekeeping.type+"_new_staff.csv";
                            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile, false)));
                            br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status);
                        } 
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (br != null) {
                            br.close();
                        }
                    }
                    flag=1;
                    //a.housekeeping.add_staff(g);
                    break;
                }
            }   
        }
    }

	public void view_user(Main a, User v){

	}

	public void delete_user(){

	}

	public void assign_task(){

	}

	public void accept(){

	}

	public void reject(){
		
	}

    public void printkar(){
        System.out.println(username+name+passwd+userid+type+dob+address);
    }
}