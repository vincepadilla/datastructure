import java.util.*;

public class numboardcipherVer2 {

    static String cipher = null;
    static String decipher = null;
    static String result = "";
    static String result2 = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("NUMBOARD CIPHER VER 2");
        
        boolean validOptions = true;
        boolean validText = true;
        
        while(validOptions) {
           try {
              System.out.print("\nPress[1]-Encrypt/Press[2]-Decrypt: ");
              int choice = scan.nextInt();
              scan.nextLine();
              
              if(choice == 1) {
                  validOptions = false;
                  
                  while(validText) {
                  System.out.print("Enter Plain Text: ");
                  cipher = scan.nextLine();
                  
                     if (cipher.matches(".*\\d.*")) {
                        System.out.println("The text must be letters only\n");
                        
                    } else {
                     validText = false;
                     
                     cipherProcess();
                     System.out.println("Cipher Text: " + result.trim());
                    }
               } 
                     
              } else if(choice == 2) {
                  validOptions = false;
                  System.out.println("Note: The cipher text must be have space");
                  
                  while(validText) {
                   System.out.print("\nEnter Cipher Text: ");
                     decipher = scan.nextLine();
                     
                     if (decipher.matches(".*[a-zA-Z].*")) {
                         System.out.println("Error: The text must not contain letters.");
                         
                      } else {          
                        validText = false;    
                        decipherProcess();
                        System.out.println("Plain Text: " + result2.trim());
                     }
                  }
                                   
               } else {
                  System.out.println("Invalid Options");
               }
               
          } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a numeric option (1 or 2).");
                scan.nextLine(); 
            }
            
      }
}
    
    static void cipherProcess() {
        for (char ch : cipher.toUpperCase().toCharArray()) {
            if (ch == ' ') {
                result += " ";
            } else {
                result += cipher(ch) + " ";
            }
        }
    }

    static void decipherProcess() {
        String[] numbers = decipher.trim().split(" ");
        for (String number : numbers) {
            if (number.equals("")) {
                result2 += " ";
            } else {
                result2 += decipher(number);
            }
        }
    }

    static String cipher(char ch) {
        switch (ch) {
            case 'Q': return "1";
            case 'W': return "2";
            case 'E': return "3";
            case 'R': return "4";
            case 'T': return "5";
            case 'Y': return "6";
            case 'U': return "7";
            case 'I': return "8";
            case 'O': return "9";
            case 'P': return "0";
            case 'A': return "21";
            case 'S': return "22";
            case 'D': return "23";
            case 'F': return "24";
            case 'G': return "25";
            case 'H': return "26";
            case 'J': return "27";
            case 'K': return "28";
            case 'L': return "29";
            case 'Z': return "331";
            case 'X': return "332";
            case 'C': return "333";
            case 'V': return "334";
            case 'B': return "335";
            case 'N': return "336";
            case 'M': return "337";
            default: return "";
        }
    }

    static char decipher(String number) {
        switch (number) {
            case "1": return 'q';
            case "2": return 'w';
            case "3": return 'e';
            case "4": return 'r';
            case "5": return 't';
            case "6": return 'y';
            case "7": return 'u';
            case "8": return 'i';
            case "9": return 'o';
            case "0": return 'p';
            case "21": return 'a';
            case "22": return 's';
            case "23": return 'd';
            case "24": return 'f';
            case "25": return 'g';
            case "26": return 'h';
            case "27": return 'j';
            case "28": return 'k';
            case "29": return 'l';
            case "331": return 'z';
            case "332": return 'x';
            case "333": return 'c';
            case "334": return 'v';
            case "335": return 'b';
            case "336": return 'n';
            case "337": return 'm';
            default: return ' ';
        }
    }
}
