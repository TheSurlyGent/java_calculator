import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculator {

    

   
    
    

public double result = 0.0;
   
    public static void main(String[] args) {
        
    try {
        System.out.println("Calculator is on.");
        System.out.print("Format of Calculator ");
        System.out.println("operator space number");
        System.out.println("For example: + 5");
        System.out.println("To end, enter the letter e.");
        Calculator c = new Calculator();
        c.doCalculation();
        
        
        
        
    } catch (DivideByZeroException e) {
       ;
    } catch (UnsupportedOperationException e) {
        System.out.println("");
    }
        

   
    }
    public  void reset() {
        result = 0;
    }
    public Calculator(){
        
        
        result = 0.0;
      
        
        
        
        
    }
    public void doCalculation()throws DivideByZeroException, UnsupportedOperationException{
        
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
 
 
        boolean done = false;
        result = 0;
        System.out.println("result = " + result);
        
          while (!done){
                
                char operator = (input1.next()).charAt(0);
                if ((operator == 'e') || (operator == 'E'))
                done = true;
                
                
                else if ((operator == 'r'||operator == 'R'))
                        Calculator.this.reset();
                else if ((operator == 'Y'||operator == 'Y'))        
                        break;
                else if ((operator == 'N'||operator == 'N'))        
                        System.exit(0);
                else{ 
                
                    double number = input1.nextDouble();
                    result = evaluate(operator, result, number);
                 
                    System.out.println("result " + operator + " " + number + " = " + result);
                    System.out.println("updated result = " + result);
                
                System.out.println("would you like to continue");
                System.out.println("press y or n");
                
                char reply = (input2.next()).charAt(0);
                if ((reply == 'Y'||reply == 'Y'))        
                     done = false;
                else if ((reply == 'N'||reply == 'N'))        
                        done = true;   
                
          }  }
    }
           
         

    public double evaluate(char operator, double result, double number)throws UnsupportedOperationException, DivideByZeroException {
    double answer = 0;
        switch(operator){
            case '+' :
                answer = result + number;
                break;
            case '-':
                answer = result - number;
                break;
            case '*':
                answer = result * number;
                break;
            case '/':
                if (number == 0)
                    throw new DivideByZeroException();
                answer = result / number;
                break;
            default:
            throw new UnsupportedOperationException(operator);
}    
        
        
    return answer;
    }

    private static class UnsupportedOperationException extends Exception {

        public UnsupportedOperationException(char operator) {
            System.out.println(operator +" is an unknown operator");
            System.exit(0);
        }
    }
    private static class DivideByZeroException extends Exception {

        public DivideByZeroException() {
            System.out.println("You cannot divide by zero");
            System.exit(0);

        }
    }    
}


    

       
    
    
    

