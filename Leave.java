import java.util.*;
import java.lang.*;
import java.io.*;

public class Leave{
	String reason;
	String date;
	String start_date;
	int range;
	String end_date;
	String user;
	String recipient;

	Leave(String[] a){
		reason=a[0];
		date=a[1];
		start_date=a[2];
		range=Integer.parseInt(a[3]);
		end_date=a[4];
		user=a[5];  //contains userid
		recipient=a[6]; //contains userid
	}

	Leave(){
		
	}

	public void get_info(String a, String b, String c, String d, String e, String f, String g){
		reason=a;
		date=b;
		start_date=c;
		range=Integer.parseInt(d);
		end_date=e;
		user=f;  //contains username
		recipient=g;

	}

	public void add_info(Main a){
        BufferedWriter br = null;
        String line = "";
        String cvsSplitBy = ",";
        String csvfile=null;
        if(recipient.equals(a.admin.username)){
        	csvfile="GM_leave.csv";
        }
        else if(recipient.equals(a.electricity.supervisor.username)){
        	csvfile="electricity_leave.csv";
        }
        else if(recipient.equals(a.av.supervisor.username)){
        	csvfile="av_leave.csv";
        }
        else if(recipient.equals(a.hvac.supervisor.username)){
        	csvfile="hvac_leave.csv";
        }
        else if(recipient.equals(a.security.supervisor.username)){
        	csvfile="security_leave.csv";
        }
        else if(recipient.equals(a.housekeeping.supervisor.username)){
        	csvfile="housekeeping_leave.csv";
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