package fms_project;

public class Logistic{
	String equipment;
	int quantity;

	Logistic(String[] a){
		equipment=a[0];
		quantity=Integer.parseInt(a[1]);
	}

	Logistic(){
		
	}

	public void get_info(String a, int b){
		equipment=a;
		quantity=b;
	}
	
	public String toString(){
        return (equipment+quantity);
    }
}