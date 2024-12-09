import java.util.*;

public class numboardCipher {

    static String cipher = null;
    static String decipher = null;
    static String result = "";
    static String result2 = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("NUMBOARD CIPHER");
        
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
                  System.out.print("\nEnter Plain Text: ");
                  cipher = scan.nextLine();
                  
                     if (cipher.matches(".*\\d.*")) {
                        System.out.println("The text must be letters only");
      
                    } else {
                         validText = false;
                         cipherProcess();
                         System.out.println("Cipher Text: " + result.trim());
                    }
               }
                    
               
              } else if(choice == 2) {
                  validOptions = false;
                  System.out.println("Note: The cipher text must be have space to avoid no output.");
                   
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
            case 'A': return "11";
            case 'S': return "22";
            case 'D': return "33";
            case 'F': return "44";
            case 'G': return "55";
            case 'H': return "66";
            case 'J': return "77";
            case 'K': return "88";
            case 'L': return "99";
            case 'Z': return "111";
            case 'X': return "222";
            case 'C': return "333";
            case 'V': return "444";
            case 'B': return "555";
            case 'N': return "666";
            case 'M': return "777";
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
            case "11": return 'a';
            case "22": return 's';
            case "33": return 'd';
            case "44": return 'f';
            case "55": return 'g';
            case "66": return 'h';
            case "77": return 'j';
            case "88": return 'k';
            case "99": return 'l';
            case "111": return 'z';
            case "222": return 'x';
            case "333": return 'c';
            case "444": return 'v';
            case "555": return 'b';
            case "666": return 'n';
            case "777": return 'm';
            default: return ' ';
        }
    }
}
