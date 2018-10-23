package Calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 class interesttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		interestcalculator c1=new interestcalculator();
		
		c1.calculate(10000, 20);
		c1.calculate(50, 64);
		c1.calculate(50, 18);
		c1.calculate(100, 18);
		c1.calculate(100, 64);
		c1.calculate(999, 18);
		c1.calculate(999, 64);
		c1.calculate(500, 18);
		c1.calculate(500, 64);
		c1.calculate(1000, 18);
		c1.calculate(1000, 64);
		c1.calculate(4999, 18);
		c1.calculate(4999, 64);
		c1.calculate(2000, 18);
		c1.calculate(2000, 64);
		c1.calculate(5000, 18);
		c1.calculate(5000, 64);
		c1.calculate(9999, 18);
		c1.calculate(9999, 64);
		c1.calculate(7000, 18);
		c1.calculate(7000, 64);
		c1.calculate(5000, 18);
		c1.calculate(5000, 64);
		c1.calculate(15000, 18);
		c1.calculate(15000, 64);		
		c1.calculate(500000000, 18);
		c1.calculate(500000000, 64);
		c1.calculate(-5000, 18);
		c1.calculate(-500000000, 64);

	}

}

public class interestcalculator {
	
	
long  deposit;
int age;
double interestamount;
double anual_interestrate;
String phonenumber;
long otherProductamt;
boolean otherProductFlag;
boolean invalidFlag;
boolean invaliddeposit;

    
	public void calculate(int d,int a)
	{
		deposit=d;
		age=a;
		invalidFlag=false;
		otherProductFlag=false;
		invaliddeposit=false;
		
		if(age>=60 && deposit>=100)
		{
			anual_interestrate=2;
			
			otherProductamt=deposit-9999;
			if(otherProductamt>0)
			{
				phonenumber="required";
				otherProductFlag=true;
				if(otherProductamt>=1000000)
				{
					invaliddeposit=true;
				}
			}
		}
		
		else if(deposit>=100 && deposit<=999)
		{
			anual_interestrate=1;
		}
		else if(deposit>=1000 && deposit<=4999)
		{
			anual_interestrate=1.3;
			
		}
		else if(deposit>=5000 && deposit<=9999)
		{
			anual_interestrate=1.5;
			
		}
		else if(deposit>9999)
		{
			anual_interestrate=1.5;	
			otherProductamt=deposit-9999;
			phonenumber="required";
			otherProductFlag=true;
			if(otherProductamt>=1000000)
			{
				invaliddeposit=true;
			}
		}
		else if(deposit<100)
		{
			invalidFlag=true;
		}
			
		if(invalidFlag==false)
			interestamount=(anual_interestrate*deposit)/100;
		
		publishResult();
		
	}
	public void publishResult()
	{
		if (invaliddeposit==true)
		{
			System.out.println("please check Your Deposit Amount: it is unexpected"+ deposit);
		}
	   else if(invalidFlag==false && otherProductFlag==false )
		{
			System.out.println("Your Deposit Amount: "+ deposit);
			System.out.println("Your anual interest rate: "+ anual_interestrate);
			System.out.println("Your anual interest accumulated: "+ interestamount);
		}
		else if(otherProductFlag==true )
		{
			System.out.println("Your Deposit Amount: "+ deposit);
			System.out.println("Your anual interest rate: "+ anual_interestrate);
			System.out.println("Your anual interest accumulated: "+ interestamount);
			System.out.println("you can invest remaing amount " + otherProductamt + "in other investment. Please share your phone number.Our reperesentative will cantact you. ");
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter Your phonenumber : ");
			String phonenumber = scanner.next();
			Pattern pattern = Pattern.compile("/^((\\+|00)32\\s?|0)4(60|[789]\\d)(\\s?\\d{2}){3}$/");
		      Matcher matcher = pattern.matcher(phonenumber);
		      
		      if (matcher.matches()) {
		    	  System.out.println("Phone Number accepted");
		    	  System.out.println("Your phonenumber is " + phonenumber);
		      }
		      else
		      {
		    	  System.out.println("Enter Valid Phone Number");
		      }
		    
			
		}
		else if(invalidFlag==true)
			
		{
			System.out.println("you can not deposit amount for < 100Euro: ");
		}
	}

}
