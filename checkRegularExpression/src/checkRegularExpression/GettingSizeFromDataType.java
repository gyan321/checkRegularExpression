package checkRegularExpression;

public class GettingSizeFromDataType {

	public static void main(String[] args) {
		 String givenString="int(11)";
		 
		 int firstIndex=givenString.indexOf('(');
		 int secondIndex=givenString.indexOf(')');
		 
		 String size=givenString.substring(firstIndex+1,secondIndex);
		 
		 System.out.println("size is "+size);
	}

}
