
public class FixedArrayStack implements Stack{
	private Object[] stack;
	private int top;
	private int maxSize;
	
	public FixedArrayStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		stack = new Object[maxSize];
		this.top = 0;
	}

	@Override
	public void push(Object obj) {
		// TODO Auto-generated method stub
		if(this.top<this.maxSize) {
			this.stack[this.top] = obj;
			this.top++;
		}
		else {
			System.out.println("stack full. Try later");
		}
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(this.top>0 && this.top<=this.maxSize) {
			top--;
			return this.stack[top];
		}
		return null;
	}
	
}
