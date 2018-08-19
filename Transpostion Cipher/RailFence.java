import java.io.*;
import java.util.*;
class RailFence
{
	public static void main(String[] args) throws IOException
	{
		String plaintxt,ciphertxt;
		int i,j,k;
		System.out.println("Enter the message to be encrypted");
		Scanner sc=new Scanner(System.in);
		plaintxt=sc.nextLine();
		int len=plaintxt.length();
		String s1="",s2="",temp="";
		for(i=0;i<len;i++)
		{
			if(plaintxt.charAt(i)!=' ')
				temp=temp+plaintxt.charAt(i);
		}
		for(i=0;i<temp.length();i++)
		{
			if(i%2==0)
				s1=s1+temp.charAt(i);
			else
				s2=s2+temp.charAt(i);
		}
		ciphertxt=s1.concat(s2);
		System.out.println("Ciphertext : "+ciphertxt);
		plaintxt="";
		if(ciphertxt.length()%2==0)
			j=ciphertxt.length()/2;
		else
			j=ciphertxt.length()/2+1;
		k=j;
		for(i=0;i<k;i++,j++)
		{
			plaintxt+=ciphertxt.charAt(i);
			plaintxt+=ciphertxt.charAt(j);
		}
		System.out.println("Plaintext: "+plaintxt);
	}
}