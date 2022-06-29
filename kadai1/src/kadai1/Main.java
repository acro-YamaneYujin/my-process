package kadai1;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Question q = new Question();
		System.out.println(q.question);
	    System.out.println(String.join(" ", q.choices));
	    System.out.println("A～Dの選択肢から選んでください");
	    
	    
	    
	    while (true)  {
	    	
		    String response = new java.util.Scanner(System.in).nextLine();
	    	
	    	if (q.answer.equalsIgnoreCase(response)) {
	    		System.out.println("正解");
	    		break;
	    	} else if("B".equalsIgnoreCase(response)||"C".equalsIgnoreCase(response)||"D".equalsIgnoreCase(response)) {
	    		System.out.println("不正解");
	    		break;
	    		
	    	} else {
	    		System.out.println("A～Dの中から選んでください");
	    	}
	    }	    	
	}
}

