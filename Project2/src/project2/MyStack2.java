package project2;

import java.util.Scanner;
import java.util.Iterator;

public class MyStack2<AnyType> implements Iterable<AnyType>
{
    /**
     * Construct an empty ArrayList.
     */
    public MyStack2( )
    {
        doClear( );
    }
    
    /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        return theSize;
    }
    
    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
        return size( ) == 0;
    }
    
    /**
     * Returns the item at position idx.
     * @param idx the index to search in.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public AnyType get( int idx )
    {
        if( idx < 0 || idx >= size( ) )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + size( ) );
        return theItems[ idx ];    
    }
        
    /**
     * Changes the item at position idx.
     * @param idx the index to change.
     * @param newVal the new value.
     * @return the old value.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public AnyType set( int idx, AnyType newVal )
    {
        if( idx < 0 || idx >= size( ) )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + size( ) );
        AnyType old = theItems[ idx ];    
        theItems[ idx ] = newVal;
        
        return old;    
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity( int newCapacity )
    {
        if( newCapacity < theSize )
            return;

        AnyType [ ] old = theItems;
        theItems = (AnyType []) new Object[ newCapacity ];
        for( int i = 0; i < size( ); i++ )
            theItems[ i ] = old[ i ];
    }
    
    /**
     * Adds an item to this collection, at the end.
     * @param x any object.
     * @return true.
     */
    
    
    public boolean add( AnyType x )
    {
    add( size( ), x );
        return true;            
    }
    
    /**
     * Adds an item to this collection, at the specified index.
     * @param x any object.
     * @return true.
     */
    public void add( int idx, AnyType x )
    {
        if( theItems.length == size( ) )
            ensureCapacity( size( ) * 2 + 1 );

        for( int i = theSize; i > idx; i-- )
            theItems[ i ] = theItems[ i - 1 ];

        theItems[ idx ] = x;
        theSize++;  
    }
      
    /**
     * Removes an item from this collection.
     * @param idx the index of the object.
     * @return the item was removed from the collection.
     */
    
    
    public AnyType remove( int idx )
    {
        AnyType removedItem = theItems[ idx ];
        
        for( int i = idx; i < size( ) - 1; i++ )
            theItems[ i ] = theItems[ i + 1 ];
        theSize--;    
        
        return removedItem;
    }
    
    /**
     * Change the size of this collection to zero.
     */
    public void clear( )
    {
        doClear( );
    }
    
    private void doClear( )
    {
        theSize = 0;
        ensureCapacity( DEFAULT_CAPACITY );
    }
    
    /**
     * Obtains an Iterator object used to traverse the collection.
     * @return an iterator positioned prior to the first element.
     */
    public java.util.Iterator<AnyType> iterator( )
    {
        return new ArrayListIterator( );
    }

    /**
     * Returns a String representation of this collection.
     */
    public String toString( )
    {
            StringBuilder sb = new StringBuilder( "[ " );

            for( AnyType x : this )
                sb.append( x + " " );
            sb.append( "]" );

            return new String( sb );
    }
    
    /**
     * This is the implementation of the ArrayListIterator.
     * It maintains a notion of a current position and of
     * course the implicit reference to the MyArrayList.
     */
    private class ArrayListIterator implements java.util.Iterator<AnyType>
    {
        private int current = 0;
        private boolean okToRemove = false;
        
        public boolean hasNext( )
        {
            return current < size( );
        }
        
        
        public AnyType next( )
        {
            if( !hasNext( ) ) 
                throw new java.util.NoSuchElementException( ); 
                  
            okToRemove = true;    
            return theItems[ current++ ];
        }
        
        public void remove( )
        {
            if( !okToRemove )
                throw new IllegalStateException( );
                
            MyStack2.this.remove( --current );
            okToRemove = false;
        }
    }
    
    private static final int DEFAULT_CAPACITY = 10;
    
    private AnyType [ ] theItems;
    private int theSize;
    
    public AnyType peek() 
    {
        int    len = size();
        return get(len - 1);
    }
    
    public AnyType pop() 
    {
        AnyType  obj;
    	int len = size();
    	obj = peek();
        remove(len-1);
        return obj;
    }
    public AnyType push(AnyType x)
    {
    	add(x);
    	return x;
    }
}

class Nested
{
	 public static void main( String [ ] args )
	 {
		 String str = "a";
		 Scanner scan1 = new Scanner(System.in); 
	     System.out.println("Please input the symbols in order with one blank between every symbol");
	     if(scan1.hasNextLine())
	     {   
	         str = scan1.nextLine();  
	         System.out.println("The symbols are:"+str);
	     }
	     Scanner scan2 = new Scanner(str).useDelimiter(" ");
	     MyStack2<String> lst = new MyStack2<>( );
	     while(scan2.hasNext())
		 {
		     if (lst.isEmpty())
		     {
		    	 lst.push(scan2.next());
		     }else{
		    	 String a = scan2.next();
		    	 if (a.equals(")")) 
		    	 {
		    		 if (lst.get(lst.size()-1).equals("("))
		    		 {
		    			 lst.pop();
		    		 }
		    	 }
		    	 else if (a.equals("]"))
		    	 {
		    		 if (lst.get(lst.size()-1).equals("["))
		    		 {
		    			 lst.pop();
		    		 }
		    	 }
		    	 else if (a.equals("}")) 
		    	 {
		    		 if (lst.get(lst.size()-1).equals("{"))
		    		 {
		    			 lst.pop();
		    		 }
		    	 }
		    	 else
		    	 {
		    		 lst.push(scan2.next());
		    	 }
		     }
		 }
		 if (lst.isEmpty())
		 {
			 System.out.println("balanced");
	     }else {
	    	 System.out.println("not balanced");
	     }
	 }
}
/*class TestMyStack
{
    public static void main( String [ ] args )
    {
        MyStack<Integer> lst = new MyStack<>( );

        for( int i = 0; i < 10; i++ )
                lst.add( i );
        for( int i = 20; i < 30; i++ )
                lst.add( 0, i );

        lst.remove( 0 );
        lst.remove( lst.size( ) - 1 );

        System.out.println( lst );
        
        lst.push(10000);
        System.out.println( lst );
        System.out.println( lst.peek());
        lst.pop();
        System.out.println( lst );
    }
}*/