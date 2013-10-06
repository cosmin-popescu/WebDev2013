import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.String;

public class Main {

	private static ArrayList<String> list = new ArrayList<String>();				//Method names.
	private static ArrayList<Integer> results = new ArrayList<Integer>();			//Result list.

	public static void invokeMethod(Method m, Object object, Object... args)		//Used to invoke / call the method.
			throws IllegalAccessException, InvocationTargetException {				//using the given parameter.

		m.invoke(object, args);																

	}

	public static void addMethods() {										//Adding the methods to the list.

		list.add("add_two");
		list.add("multiply_by_three");
		list.add("substract_four");
		list.add("multiply_by_five");

	}

	public static void main(String[] args) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {

		Functii object  = new Functii();
		int x = 4;
		addMethods();

		System.out.println("Initial list : " + list);

		try {														// For each of the methods in the list
			for (String name : list) {								// a call is made with the parameter
																	// and the result is added in the result list.
				results.add((Integer) object.getClass()
						.getDeclaredMethod(name, Integer.class)
						.invoke(object, x));
			}

		} catch (Exception e) {

			System.out.println("Nu exista metoda / functia respectiva!!!");

		}

		System.out.println("Result list : " + results);
	}
}

class Functii {																// Random functions / methods
	public int add_two(Integer x) {
		return x + 2;
	}

	public int multiply_by_three(Integer x) {
		return x * 3;
	}

	public int substract_four(Integer x) {
		return x - 4;
	}

	public int multiply_by_five(Integer x) {
		return x * 5;
	}

}
