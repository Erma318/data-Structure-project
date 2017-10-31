package project2;

import java.util.Scanner;
import java.util.ArrayList;

class MyStack4<AnyType>
{
    private ArrayList link;

    public MyStack4(){
        link = new ArrayList();
    }
public int size()
{return link.size();}
    public Object get(int x)
    {
        return link.get(x);
    }

    public boolean empty()
    {
        return link.isEmpty();
    }

    public Object peek() {
        return link.get(link.size() - 1);
    }

    public Object pop()
    {
        Object a = peek();
        link.remove(link.size()-1);
        return a;
    }

    public void push(Object item)
    {
        link.add(item);
    }

    public int search(Object o)
    {
        return link.indexOf(o);
    }


    public static void main(String[] args)
    {
        String str = "a";
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Please input the symbols in order with one blank between every symbol");
        if(scan1.hasNextLine())
        {
            str = scan1.nextLine();
            //System.out.println("The symbols are:"+str);
        }
        System.out.println("The symbols are:"+str);
        Scanner scan2 = new Scanner(str).useDelimiter("");
        MyStack4<String> lst = new MyStack4<>( );
        MyStack4<String> list = new MyStack4<>( );
        while(scan2.hasNext())
        {
            list.push(scan2.next());
        }
        for(int i=0;i<= list.size()-1;i++)
        {
            Object x = list.get(i);
            if (lst.empty())
            {
                lst.push(x);
            }else{
                if (x.equals(")"))
                {
                    if (lst.peek().equals("("))
                    {
                        lst.pop();
                    }
                }
                else if (x.equals("]"))
                {
                    if (lst.peek().equals("["))
                    {
                        lst.pop();
                    }
                }
                else if (x.equals("}"))
                {
                    if (lst.peek().equals("{"))
                    {
                        lst.pop();
                    }
                }
                else
                {
                    lst.push(x);
                }
            }
        }
        if (lst.empty())
        {
            System.out.println("balanced");
        }else {
            System.out.println("not balanced");
        }
    }


}



