public class Function4 implements Function {

    public Function4() {}

    @Override
    public int h(Object x) {
        return (int) (((Long)x) % 10)+1;
    }

}
