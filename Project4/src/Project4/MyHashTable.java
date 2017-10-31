package Project4;

public class MyHashTable
{
	private static class HashEntry
	{
	    public String  element;  
	    public boolean isActive;  
        public HashEntry( String e )
	    {
	        this( e, true );
	    }
        public HashEntry( String e, boolean i )
	    {
	        element  = e;
	        isActive = i;
	    }
	}
	
	
    public MyHashTable( )
	{
	    this( DEFAULT_TABLE_SIZE );
	}
	
	public MyHashTable( int size )
	{
	    allocateArray( size );
	    doClear( );
	}
	
	public boolean insert( String x )
	{
	    int currentPos = findPos( x );
	    if( isActive( currentPos ) )
	    {
	        return false;
	    }
        if( array[ currentPos ] == null )
	    {
	        ++occupied;
	    }
	    array[ currentPos ] = new HashEntry( x, true );
	    theSize++;
	    if( occupied > array.length / 2 )
	    {
	        rehash( );
	    }
	    return true;
	}
	
	
	
	private void rehash( )
	{
	    HashEntry [ ] oldArray = array;
	    allocateArray( 2 * oldArray.length );
	    occupied = 0;
	    theSize = 0;
	    for( HashEntry entry : oldArray )
	    {
	        if( entry != null && entry.isActive )
	        {
	            insert( entry.element );
	        }
	    }
	}
	
	
	private int findPos( String x )
	{
	    int offset = 1;
	    int currentPos = this.myhash( x, array.length);
	    while( array[ currentPos ] != null && !array[ currentPos ].element.equals( x ) )
	    {
	         currentPos += offset;
	         offset += 2;
	         if( currentPos >= array.length )
	         {
	             currentPos -= array.length;
	         }
	     }
	     return currentPos;
	 }
	
	
	 public int size( )
	 {
	     return theSize;
	 }
	 
	 public int capacity( )
	 {
	     return array.length;
	 }
	 
	 public boolean contains( String x )
	 {
	     int currentPos = findPos( x );
	     return isActive( currentPos );
	 }
	 
	 
	 private boolean isActive( int currentPos )
	 {
	     return array[ currentPos ] != null && array[ currentPos ].isActive;
	 }
	 
	 public void makeEmpty( )
	 {
	     doClear( );
	 }        
	 
	 private void doClear( )
	 {
	     occupied = 0;
	     for( int i = 0; i < array.length; i++ )
	     {
	         array[ i ] = null;
	     }
	 }
	 
	 public int myhash( String key, int tableSize )
	 {
	     int hashVal = 0;
	     for( int i = 0; i < key.length( ); i++ )
	     {
	         hashVal = 37 * hashVal + key.charAt( i );
	     }
	     hashVal %= tableSize;
	     if( hashVal < 0 )
	     {
	         hashVal += tableSize;
	     }
	     return hashVal;
	 }
	 
	 private static final int DEFAULT_TABLE_SIZE = 101;

	 private HashEntry [ ] array; 
	 private int occupied;                
	 private int theSize;
     
     private void allocateArray( int arraySize )
     {
         array = new HashEntry[ nextPrime( arraySize ) ];
     }

     private static int nextPrime( int n )
     {
         if( n % 2 == 0 )
         {
             n++;
         }
         for( ; !isPrime( n ); n += 2 )
         {
             ;
         }
         return n;
     }


     private static boolean isPrime( int n )
     {
         if( n == 2 || n == 3 )
         {
             return true;
         }

         if( n == 1 || n % 2 == 0 )
         {
             return false;
         }

         for( int i = 3; i * i <= n; i += 2 )
         {
             if( n % i == 0 )
             {
                 return false;
             }
         }
         return true;
     }
     
     public static void main( String [ ] args )
     {
    	 ;
     }
}
