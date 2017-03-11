public class Function2 implements Function {
	public Function2(){}
	@Override
	public int h(Object x) {
		return 1 + ((Integer) x % 10);
	}
}
