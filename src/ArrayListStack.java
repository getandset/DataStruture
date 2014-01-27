import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: lj
 * Date: 13-12-25
 * Time: 下午8:04
 * To change this template use File | Settings | File Templates.
 */
public class ArrayListStack<T> implements Stack<T> {
	int defaultSize = 10;
	Object[] array;
	int top;

	public ArrayListStack (){
		 array = new Object[defaultSize];
	}

	public ArrayListStack (int size) {
		array = new Object[size];
	}

	@Override
	public void push(T e) {
		int length = array.length;
		if (top==length) {
			Object[] newArray = new Object[length>>2];
			System.arraycopy(array,0,newArray,0,length);
			array = newArray;
		}
		array[top] = e;
		top++;
	}

	@Override
	public T pop() throws Exception{
		if (isEmpty())
			throw new Exception("stack is no element");
		return (T)array[--top];
	}

	@Override
	public boolean isEmpty() {
		return top==0? true : false;
	}

	@Override
	public T getTop() {
		if (isEmpty())
			return null;
		return (T)array[top-1];
	}

}
