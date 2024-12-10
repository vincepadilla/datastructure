import java.util.*;

public class Polybus {

    // Global Variables
    static String text = null;
    static String result = "";
    static String ciphertext = null;
    static String result2 = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("POLYBUS SQUARE CIPHER");
        
        System.out.println("-------------------------");
        System.out.println("|   | 1 | 2 | 3 | 4 | 5 |");
        System.out.println("-------------------------");
        System.out.println("| 1 | A | B | C | D | E |");
        System.out.println("-------------------------");
        System.out.println("| 2 | F | G | H | I | K |");
        System.out.println("-------------------------");
        System.out.println("| 3 | L | M | N | O | P |");
        System.out.println("-------------------------");
        System.out.println("| 4 | Q | R | S | T | U |");
        System.out.println("-------------------------");
        System.out.println("| 5 | V | W | X | Y | Z |");
        System.out.println("-------------------------");
        
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
                   text = scan.nextLine().toUpperCase(); 
                   
                    if (text.matches(".*\\d.*")) {
                        System.out.println("The text must be letters only.");
                        
                    } else {
                    validText = false;
                    
                    cipherProcess();
                    System.out.println("Cipher Text: " + result);
                  }  
                
               }         
                       
           } else if(choice == 2 ) {
               validOptions = false;
               
               while(validText) {
                  System.out.print("\nEnter Cipher Text: ");
                  ciphertext = scan.nextLine();
                  
                  ciphertext = ciphertext.replace(" ", "");
                  
                  if(ciphertext.matches("[0-9]+")) {
                     validText = false;
                     decipherProcess();
                     System.out.println("Plain text: " + result2);
                     
                  } else {
                     System.out.println("Error: The text must be a number.");
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
        for (char c : text.toCharArray()) { 
            if (c == ' ') {
                result += " "; 
            } else {
                switch (c) {
                    case 'A': result += "11"; break;
                    case 'B': result += "12"; break;
                    case 'C': result += "13"; break;
                    case 'D': result += "14"; break;
                    case 'E': result += "15"; break;
                    case 'F': result += "21"; break;
                    case 'G': result += "22"; break;
                    case 'H': result += "23"; break;
                    case 'I': result += "24"; break;
                    case 'J': result += "24"; break; 
                    case 'K': result += "25"; break;
                    case 'L': result += "31"; break;
                    case 'M': result += "32"; break;
                    case 'N': result += "33"; break;
                    case 'O': result += "34"; break;
                    case 'P': result += "35"; break;
                    case 'Q': result += "41"; break;
                    case 'R': result += "42"; break;
                    case 'S': result += "43"; break;
                    case 'T': result += "44"; break;
                    case 'U': result += "45"; break;
                    case 'V': result += "51"; break;
                    case 'W': result += "52"; break;
                    case 'X': result += "53"; break;
                    case 'Y': result += "54"; break;
                    case 'Z': result += "55"; break;
                    default: result += ""; break; 
                }
            }
        }
    }
    
    
    //Decipher Process
    static void decipherProcess() {
      String code = "";
        
        for (char d : ciphertext.toCharArray()) {
            if (d == ' ') {
                result2 += " "; // Preserve spaces if any (though no spaces expected in input)
            } else {
                code += d; // Append the current character to the code
                if (code.length() == 2) { // Once we have two characters, process the cipher
                    switch (code) {
                        case "11": result2 += 'a'; break;
                        case "12": result2 += 'b'; break;
                        case "13": result2 += 'c'; break;
                        case "14": result2 += 'd'; break;
                        case "15": result2 += 'e'; break;
                        case "21": result2 += 'f'; break;
                        case "22": result2 += 'g'; break;
                        case "23": result2 += 'h'; break;
                        case "24": result2 += 'i'; break;
                        case "25": result2 += 'k'; break;
                        case "31": result2 += 'l'; break;
                        case "32": result2 += 'm'; break;
                        case "33": result2 += 'n'; break;
                        case "34": result2 += 'o'; break;
                        case "35": result2 += 'p'; break;
                        case "41": result2 += 'q'; break;
                        case "42": result2 += 'r'; break;
                        case "43": result2 += 's'; break;
                        case "44": result2 += 't'; break;
                        case "45": result2 += 'u'; break;
                        case "51": result2 += 'v'; break;
                        case "52": result2 += 'w'; break;
                        case "53": result2 += 'x'; break;
                        case "54": result2 += 'y'; break;
                        case "55": result2 += 'z'; break;
                        default: result2 += ' '; break; // Handle unknown codes
                    }
                    code = ""; // Reset the code for the next pair
                }                      
                
            }
            
         }
         
         if(code.length() == 1) {
                     result2 = "The number must be 2 or more digits";
         }
    }
}
