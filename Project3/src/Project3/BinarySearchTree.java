package Project3;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
	public void setup1()
	{
	      //     50
	      //    /  \
	      //  25    60
	      //  /\    / \
	      // 20 35 55  67

	      // above tree (not a search tree)
	      BinaryNode leaf1 = new BinaryNode(20, null, null);
	      BinaryNode leaf2 = new BinaryNode(35, null, null);
	      BinaryNode leaf3 = new BinaryNode(55, null, null);
	      BinaryNode leaf4 = new BinaryNode(67, null, null);

	      BinaryNode p1 = new BinaryNode(25, leaf1, leaf2);
	      BinaryNode p2 = new BinaryNode(60, leaf3, leaf4);

	      root = new BinaryNode(50, p1, p2);
	   }
	public void setup2()
	{
	      //     50
	      //    /  \
	      //  25    60
	      //  /\    / \
	      // 20 35 55  67

	      // above tree (not a search tree)
	      BinaryNode leaf1 = new BinaryNode(20, null, null);
	      BinaryNode leaf2 = new BinaryNode(35, null, null);
	      BinaryNode leaf3 = new BinaryNode(55, null, null);
	      BinaryNode leaf4 = new BinaryNode(67, null, null);

	      BinaryNode p1 = new BinaryNode(25, leaf1, leaf2);
	      BinaryNode p2 = new BinaryNode(60, leaf3, leaf4);

	      root = new BinaryNode(50, p1, p2);
	   }
    /**
     * Construct the tree.
     */
    public BinarySearchTree( )
    {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMin( root ).element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public AnyType findMax( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMax( root ).element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
            System.out.print( "\n" );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return new BinaryNode<>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
        	System.out.print( t.element + " " );
        	printTree( t.left );
            printTree( t.right );
        }
    }

    /**
     * Internal method to compute height of a subtree.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }


      /** The tree root. */
    private BinaryNode<AnyType> root;
    
    private int nodeCount(int count, BinaryNode<AnyType> t )
    {
    	if( t != null )
        {
    		count=nodeCount(count, t.left );
            count=nodeCount(count, t.right );
            count++;
        }
    	return count;
    }
    public void nodeCount()
    {
    	System.out.println(nodeCount(0,root));
    }
    
    
    private int isFull(int count, BinaryNode<AnyType> t )
    {
    	if( t != null )
        {
    		count=isFull( count,t.left );
    		if (t.left!=null && t.right!=null)
            {
 
            }
            if (t.left==null && t.right==null)
            {

            }
            if (t.left!=null && t.right==null)
            {
                count++;
            }
            if (t.left==null && t.right!=null)
            {
                count++;
            }
    		
            count=isFull( count,t.right );
        }
    	return count;
    }
    public void isFull()
    {
    	if (isFull(0,root)>0)
        {
    		System.out.println("no full");
        }else{
        	System.out.println("full");
        }
    }
    
    
    private boolean cStructure(BinaryNode<AnyType> t1,BinaryNode<AnyType> t2)
    {
    	if (t1==null && t2 == null)
    	{
    		return true;
    	}
    	if(t1==null && t2!=null) 
    	{
          return false;
    	}
    	if (t1!=null && t2==null)
    	{ 
    		return false;
    	}else{
        	return cStructure(t1.left, t2.left) && cStructure(t1.right, t2.right);
        }
    }  
    public void compareStructure(BinaryNode<AnyType> t1,BinaryNode<AnyType> t2)
    {
    	if (cStructure(t1,t2))
    	{
    		System.out.println("Same structure");
    		
    	}else{
    		System.out.println("Not same structure");
    	}
    }
    
    
    private boolean equal(BinaryNode<AnyType> t1,BinaryNode<AnyType> t2)
    {
        if((t1 == null && t2 != null) || (t1 != null && t2 == null))
        {
            return false;
        }
            if(t1 == null && t2 == null)
        {
            return true;
        }
        if(t1.element.compareTo(t2.element) != 0)
        {
            return false;
        }
        else{
            return equal(t1.left, t2.left) && equal(t1.right, t2.right);
        }
    }
    public void equals(BinaryNode<AnyType> t1,BinaryNode<AnyType> t2)
    {
    	if (equal(t1,t2))
    	{
    		System.out.println("They are identical");
    		
    	}else{
    		System.out.println("They are not identical");
    	}
    	
    }
    
    
    private void copy( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
        	insert(t.element);        	
        	copy( t.left);
            copy( t.right);
        }
    }
    
    
//    private void mirror0(BinaryNode t) 
//    {
//        if (t != null) 
//        {
//            BinaryNode tmp = t.left;
//            t.left = t.right;
//            t.right = tmp;
//            mirror0(t.left);
//            mirror0(t.right);
//        }
//    }
    
    
    private BinaryNode<AnyType> insertM( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return new BinaryNode<>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult > 0 )
            t.left = insertM( x, t.left );
        else if( compareResult < 0 )
            t.right = insertM( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }
    public void insertM( AnyType x )
    {
        root = insertM( x, root );
    }
    
    
    private void mirror( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
        	insertM(t.element);        	
        	mirror( t.left);
            mirror( t.right);
        }
    }
    
//    public BinarySearchTree mirror(BinaryNode t)
//    {
//    	BinarySearchTree tr= new BinarySearchTree();
//    	tr.copy(t);
//    	tr.mirror0(tr.root);
//    	return tr;
//    }
    
    
    public void isMirror(BinaryNode t1,BinaryNode t2)
    {
    	BinarySearchTree Mtree= new BinarySearchTree();
    	Mtree.copy(t2);
    	if(equal(t1,Mtree.root))
    	{
    		System.out.println("They are mirror");
    	}else{
    		System.out.println("They are not mirror");
    	}
    }
    
    
    private void rotateRight( AnyType x, BinaryNode<AnyType> t )
    {
    	if( t == null )
    	{
    		System.out.println("Error");
    	}   
        int compareResult = x.compareTo( t.element );   
        if( compareResult < 0 )
        {
            rotateRight( x, t.left );
        }
        else if( compareResult > 0 )
        {
            rotateRight( x, t.right );
        }
        else
        {
        	BinaryNode tmp=new BinaryNode(x,null,null);
        	tmp.right=t.right;
        	tmp.left=t.left.right;
        	t.element=t.left.element;
            t.right=tmp;
            t.left=t.left.left;
        }
        	
    }
    
    
    private void rotateLeft( AnyType x, BinaryNode<AnyType> t )
    {
    	if( t == null )
    	{
    		System.out.println("Error");
    	}   
        int compareResult = x.compareTo( t.element );   
        if( compareResult < 0 )
        {
            rotateLeft( x, t.left );
        }
        else if( compareResult > 0 )
        {
            rotateLeft( x, t.right );
        }
        else
        {
        	BinaryNode tmp=new BinaryNode(x,null,null);
        	tmp.left=t.left;
        	tmp.right=t.right.left;
        	t.element=t.right.element;
            t.left=tmp;
            t.right=t.right.right;
        }
        	
    }
    
    public void printLevels() 
    {  
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();  
        BinaryNode t;  
        t = root;  
        while ((t != null) || (!queue.isEmpty())) 
        {  
            if (t != null) 
            {  
                System.out.print(t.element + " ");  
                queue.add(t.left);  
                queue.add(t.right);  
                t = queue.poll();  
            } else {  
                t = queue.poll();  
            }  
        }  
    }  
    
 // Test program
    public static void main(String args[])
    {
    	BinarySearchTree tree= new BinarySearchTree();
    	BinarySearchTree tre= new BinarySearchTree();
    	BinarySearchTree treee= new BinarySearchTree();
    	BinarySearchTree treeee= new BinarySearchTree();
    	tree.setup1();
    	tre.setup2();
    	System.out.println("a.test of count node");
    	tree.nodeCount();
    	System.out.println("b.test of whether it is full");
    	tree.isFull();
    	System.out.println("c.test of compare structure");
    	tree.compareStructure(tree.root,tre.root);
    	System.out.println("d.test of equal");
        tree.equals(tree.root,tre.root);
        System.out.println("e.test of copy");
        treee.copy(tree.root);
        tree.printTree();
        treee.printTree();
        tree.equals(tree.root,treee.root);
        System.out.println("f.test of mirror");
        treeee.mirror(tree.root);
        treeee.printTree();
        System.out.println("g.test of whether it is mirror");
        tree.isMirror(tree.root,treeee.root);
        System.out.println("h.test of right rotate");
        tre.rotateRight(25, tre.root);
        tre.printTree();
        System.out.println("i.test of left rotate");
        tree.rotateLeft(25, tree.root);
        tree.printTree();
        System.out.println("j.test of left level print");
        tree.setup1();
        tree.printLevels();
    }  
}