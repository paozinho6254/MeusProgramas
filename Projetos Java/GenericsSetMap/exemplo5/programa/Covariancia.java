package exemplo5.programa;

import java.util.ArrayList;
import java.util.List;

public class Covariancia {

	public static void main(String[] args) {
		 List<Integer> intList = new ArrayList<Integer>();
		 intList.add(10);
		 intList.add(5);
		
		 List<? extends Number> list = intList;
		 Number x = list.get(0);
		 list.add(20);

	}

}
