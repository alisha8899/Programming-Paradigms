package number5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class bird implements Comparable<bird>{
	private String type;
	private int height;
	private String color; 
	
	public bird(String color, int height) {
		this.color = color;
		this.height = height;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void set(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	public String getType() {
		return type;
	}
	
	public int compareTo(bird b) {
		if(this.height > b.height) {
			return 1;
		}
		else if (this.height == b.height) {
			return 0; 
		}
		else {
			return -1;
		}
	}

	public static bird minimum(ArrayList<bird> answer) {
		for(int i = 0; i < answer.size(); i++) {
		}
		Collections.sort(answer);
		
		bird small = answer.get(0);
		return small;
	}
	
		public static void main(String[] args){
			bird m = new bird("Daisy", 10);
			bird n = new bird("Tullip", 30);
			bird o = new bird("Sunflower", 5);
			
			ArrayList<bird> height = new ArrayList<bird>(); 

			height.add(m);
			height.add(n);
			height.add(o);
			
			System.out.println("Smallest height:" + minimum(height).getHeight());
		}
	}

