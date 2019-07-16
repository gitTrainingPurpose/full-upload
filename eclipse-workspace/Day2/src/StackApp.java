
public class StackApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedArrayStack st = new FixedArrayStack(10);
		StackUser user = new StackUser();
		user.fill(st);
		user.empty(st);
	}

}
