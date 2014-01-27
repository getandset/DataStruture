/**
 * Created with IntelliJ IDEA.
 * User: lj
 * Date: 13-12-25
 * Time: 下午7:56
 * To change this template use File | Settings | File Templates.
 */
public interface Queue<T> {
	public void enqueue (T e);

	public T dequeue () throws Exception;

	public T head ();

	public boolean isEmpty ();
}
