import java.util.LinkedList;
import java.util.List;

public class Test {

	private String Test;

	public Test(String Test) {
		this.Test = Test;
	}

	@Override
	public String toString() {
		return Test.toString();
	}

	public static void main(String[] args) {

		Test n1 = new Test("Pierre");

		Test n2 = new Test("Pierre");

		Test n3 = new Test("Jacques");

		List<Test> map = new LinkedList<Test>();

		map.add(n1);

		map.add(n2);

		map.add(n3);

		Test f1 = new Test("Pierre");

		Test f2 = new Test("Paul");

		Test f3 = n1;

		Test f4 = new Test("Jacques");

		System.out.print(map.contains(f1) + " - ");

		System.out.print(map.contains(f2) + " - ");

		System.out.print(map.contains(f3) + " - ");

		System.out.print(map.contains(f4));

	}

}