package exemplo6.programa;

public class Programa {

	public static void main(String[] args) {
		
		String c1 = "Bob";
		String c2 = "Bob";
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1.equals(c2));
		System.out.println(c1 == c2);
		
		
	}

}
