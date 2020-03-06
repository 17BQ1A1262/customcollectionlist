import java.util.Arrays;
public class collectionlist<E>
{
    private int Size=0;
    private static final int capability = 10;
    private Object Elements[];
    public collectionlist(){
        Elements = new Object[capability];
    }
    public void addelement(E e)
    {
        if (Size==Elements.length)
        {
            ensureCapacity();
        }

        Elements[Size++]=e;
    }
    public E get(int i)
    {
        if (i>=Size||i<0)
        {
            throw new IndexOutOfBoundsException("Index:"+i+",Size"+i);
        }
        return (E) Elements[i];
    }
    public E removeelement(int i){
        if (i>=Size||i<0){
            throw new IndexOutOfBoundsException("Index:"+i+",Size"+i);
        }
        Object item=Elements[i];
        int numElts=Elements.length-(i+1) ;
        System.arraycopy( Elements,i+1,Elements,i,numElts) ;
        Size--;
        return (E) item;
    }
    public int size() {
        return Size;
    }
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        for(int i=0;i<Size;i++) {
            sb.append(Elements[i].toString());
            if(i<Size-1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private void ensureCapacity() {
        int newSize=Elements.length*2;
        Elements=Arrays.copyOf(Elements, newSize);
    }
}
class Main
{
    public static void main(String[] args)
    {
        collectionlist<Integer> list =new collectionlist<Integer>();
        list.addelement(2);
        list.addelement(2);
        list.addelement(3);
        System.out.println(list);
        list.removeelement(2);
        System.out.println(list);
        System.out.println( list.get(0) );
        System.out.println( list.get(1) );
        System.out.println(list.size());
    }
}
