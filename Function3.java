public class Function3 implements Function {

    public Function3() {}

    @Override
    public int h(Object x) {
        return (int) (((Long)x) % 11);
    }

}
