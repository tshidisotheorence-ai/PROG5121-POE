/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.logindetails;

/**
 *
 * @author tshid
 */
import java.util.Scanner;

public class Logindetails {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login login = new Login();  

        // Declare variables
        String username;
        String password;
        String cellPhoneNumber;
        String firstName;
        String lastName;
        
            //REGISTRATION
        System.out.println("--- Registration ---");

        // FIRST AND LAST NAME OF THE USER
        System.out.print("First Name: ");
        firstName = input.nextLine();

        System.out.print("Last Name: ");
        lastName = input.nextLine();

        //LOOP FOR USERNAME
        do {
            System.out.print("Enter Username: ");
            username = input.nextLine();
            if (login.checkUsername(username))
            {
                System.out.println("Username captured");
            }

            else 
              {  
                  System.out.println("Username is incorrect. Must contain '_' and be no more than 5 characters.");
              }

            } while (!login.checkUsername(username));
        
              //LOOP FOR PASSWORD
            do
            {
                System.out.print("Enter password: ");
                password = input.nextLine();
                if (login.checkPasswordComplexity(password))
                
                {
                   System.out.println("password captured"); 
                }
                else
                {
                    System.out.println("Password is not correctly formatted; ensure that...");
                }
                
            }
             while (!login.checkPasswordComplexity(password));
    
                 // LOOP FOR CELL PHONE NUMBER
            do {
            System.out.print("Enter Cellphone Number: ");
            cellPhoneNumber = input.nextLine();

            if (login.checkCellPhoneNumber(cellPhoneNumber)) 
            {
                System.out.println("Cellphone number captured.");
            }
            else
            {
                System.out.println("CellphoneNumber incorrect formatted or does not contain international code.");
            }

        } while (!login.checkCellPhoneNumber(cellPhoneNumber));
        
        login.registerUser(username,  password, firstName, lastName);
        
        boolean successfulLogin;
        successfulLogin=false;
        
             
        while (!successfulLogin) 
        {
             System.out.println("\n");
            
             System.out.println("LOGING");
             System.out.print("Enter user:");
             username= input.nextLine();
        
             System.out.print("Enter password:");
             password= input.nextLine();
        
             successfulLogin=login.loginUser(username, password);
             if(login.loginUser(username, password))
             {
                System.out.println("A successful login");
             }
             else
             {
                System.out.println("A failed login");
             }
             if(successfulLogin)
             {
                 System.out.println("Welcome back " + firstName + " , " + lastName + " nice to see you again");
             }
             else
             {
                 System.out.print("Try again");
             }
        } 
    }
}

// LOGIN CLASS
class Login {

    
    private String saveUser;
    private String savePass;
    private String fName;
    private String lName;

    // METHOD CALL CHECK INPUT
    public boolean checkUsername(String username) 
    {
        return username.contains("_") && username.length() <= 5;
    }

            //METHOD FOR CHECKPASSWORDCOMPLEXITY
    public boolean checkPasswordComplexity(String password) {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char anyLetter : password.toCharArray()) {
            if (Character.isUpperCase(anyLetter)) hasCapital = true;
            else if (Character.isDigit(anyLetter)) hasNumber =true;
            else if (!Character.isLetterOrDigit(anyLetter)) hasSpecial = true;
        }

        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

           //METHOD FOR CHECKCELLPHONENUMBER
    public boolean checkCellPhoneNumber(String phone) {
        return phone.startsWith("+27") && phone.length() >= 12;
    }

    
    public void registerUser(String username, String password, String firstName, String lastName) {
        this.saveUser = username;
        this.savePass = password;
        this.fName = firstName;
        this.lName = lastName;
    }

    //Method check username and password if match
    public boolean loginUser(String username, String password) 
    {
        return username.equals(saveUser) && password.equals(savePass);
    }
    public static String returnLoginStatus( boolean loginSuccess)
    {
        if(loginSuccess)
            
        {
            return "Wellcome";
        }
        else
        {
            return "Try Again";
        }
        
    }
  }

