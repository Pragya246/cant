package WOLF;
import java.util.*;
public class Node {
	int coef,exp;
	Node next;
}
 class AddPoli {
	Scanner sc=new Scanner(System.in);
	Node head1=null;
	Node head2=null;
	Node n1=new Node();
	Node n2=new Node();
	public void Create()
	{	
		System.out.println("Enter the first polynomial( enter the coefficient first then the exponent and the order should be from higher to lower value of the exponent and the coefficient should be with sign)  : ");
		n1.coef=sc.nextInt();
		n1.exp=sc.nextInt();
		n1.next=null;
		head1=n1;
		System.out.println("Is there more component in the polynomial?(press 'y' if yes)");
		char ch=sc.next().charAt(0);
		while(ch=='y')
		{	Node p=new Node();
			System.out.println("Enter the component in the same order as previous : ");
			p.coef=sc.nextInt();
			p.exp=sc.nextInt();
			n1.next=p;
			n1=p;
			System.out.println("Do you want to add more components?(press 'y' if yes)");
			ch=sc.next().charAt(0);
		}
		System.out.println("Enter the second polynomial( enter the coefficient first then the exponent and the order should be from higher to lower value of the exponent and the coefficient should be with sign)  : ");
		n2.coef=sc.nextInt();
		n2.exp=sc.nextInt();
		n2.next=null;
		head2=n2;
		System.out.println("Is there more component of the polynomial?(press 'y' if yes)");
		char nm=sc.next().charAt(0);
		while(nm=='y')
		{
			Node p=new Node();
			System.out.println("Enter the component in the same order as previous : ");
			p.coef=sc.nextInt();
			p.exp=sc.nextInt();
			n2.next=p;
			n2=p;
			System.out.println("Do you want to add more components?(press 'y' if yes)");
			nm=sc.next().charAt(0);
		}
	}
	public void display()
	{
		Node n1=head1;
		Node n2=head2;
		System.out.println("Before addition the polynomials were : ");
		while(n1!=null)
		{
			System.out.print(n1.coef+"x^"+n1.exp+"  ");
			n1=n1.next;
		}
		System.out.println();
		while(n2!=null)
		{
			System.out.print(n2.coef+"x^"+n2.exp+"  ");
			n2=n2.next;
		}
		System.out.println();
		System.out.println("After adding the polynomials the result is : ");
		Node heads=Add_Polynomial();
		while(heads!=null)
		{
			System.out.print(heads.coef+"x^"+heads.exp+"  ");
			heads=heads.next;
		}
	}
	public Node Add_Polynomial()
	{
		Node result=new Node();
		Node n1=head1,n2=head2;
		if(n1!=null && n2!=null) {
		if(n1.exp>n2.exp)
		{
			result.exp=n1.exp;
			result.coef=n1.coef;
			n1=n1.next;
		}
		else if(head2.exp>n1.exp)
		{
			result.exp=n2.exp;
			result.coef=n2.coef;
			n2=n2.next;
		}
		else
		{
			result.exp=n1.exp;
			result.coef=n1.coef+n2.coef;
			n1=n1.next;
			n2=n2.next;
			
		}
	}
	result.next=null;
		Node head=result;
		while(n1!=null&&n2!=null)
		{
			Node temp=new Node();
			if(n1.exp>n2.exp)
			{
				temp.exp=n1.exp;
				temp.coef=n1.coef;
				n1=n1.next;
			}
			else if(n2.exp>n1.exp)
			{
				temp.exp=n2.exp;
				temp.coef=n2.coef;
				n2=n2.next;
			}
			else
			{
				temp.exp=n1.exp;
				temp.coef=n1.coef+n2.coef;
				n1=n1.next;
				n2=n2.next;
				
			}
			temp.next=null;
			head.next=temp;
			head=head.next;
			//head.next=null;
			
		}
		if(n1==null) {
			head.next=n2;
		}
		else {
			head.next=n1;
		}
		return result;
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddPoli ap=new AddPoli();
		ap.Create();
		ap.display();
	}

}
