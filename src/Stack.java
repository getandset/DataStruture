/**
 * Created with IntelliJ IDEA.
 * User: lj
 * Date: 13-12-24
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
public interface Stack <T>{

	public void push (T e);

	public T pop () throws Exception;

	public boolean isEmpty ();

	public T getTop ();
}
