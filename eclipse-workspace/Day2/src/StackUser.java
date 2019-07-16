
public class StackUser {
	public void fill(Stack s) {
		for (int i = 0; i < 10; i++) {
			// is instance of fixed array stack
			// if(s.top== s.maxSize)
			// return;
			s.push(i);
			System.out.println("pushed "+i);
		}
		return;		
	}
	public void empty(Stack s) {
		for (int i = 0; i < 10; i++) {
			System.out.println("popped "+s.pop());
		}
	}
}
