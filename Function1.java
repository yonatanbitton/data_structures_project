public class Function1 implements Function {

	public Function1() {}

	@Override
	public int h(Object x) {
		return (Integer) x % 11;
	}

}
