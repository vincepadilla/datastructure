import java.util.*;

public class keywordCipher {

    static String plaintext = "";
    static String keyword = "";
    static String ciphertext = ""; 
    static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static String cipherAlphabet = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("KEYWORD CIPHER\n");
        
        boolean validKeyword = true;
        boolean validOptions = true;
        boolean validText = true;
        
        
        while(validKeyword) {
        System.out.print("Enter a Keyword: ");
        keyword = scan.nextLine();  
            if (keyword.matches(".*\\d.*") || keyword.matches(".*[^a-zA-Z\\s].*")) {
                System.out.println("Input should not contain numbers or special symbols!");
                System.out.println();
            } else {
              validKeyword = false;
              keyword = keyword.toLowerCase();
              keyword = keyword.replace(" ", "");
              
              
              // Create the cipher alphabet
              createCipherAlphabet();
      
              System.out.println("\nKeyword: " + keyword);
        }
        
   }     
      while(validOptions) {
         try {
           System.out.print("Press[1]-Encypt/Press[2]-Decrypt: ");
           int choice = scan.nextInt();
           scan.nextLine();
           
           if(choice == 1) {
             validOptions = false;
             
             while(validText) {
   
                 System.out.print("\nEnter PlainText: ");
                 plaintext = scan.nextLine().toLowerCase(); 
                 
                  if (plaintext.matches(".*\\d.*")) { 
                     System.out.println("Input should not contain numbers!");
                } else {
                  validText = false;
                  encrypt();
            
                  System.out.println("\nCipherText: " + ciphertext);
               }
               
            }
   
           } else if (choice == 2) {
               validOptions = false;
                  
                 while(validText) {
                    System.out.print("\nEnter Cipher Text: ");
                    ciphertext = scan.nextLine();
                    
                    if (ciphertext.matches(".*\\d.*")) { 
                        System.out.println("Input should not contain numbers!");
                   } else {
                       validText = false;
                       decrypt();
           
                       System.out.println("\nPlainText: " + plaintext);
                    }
                    
                 }
            
           } else {
               System.out.println("Invalid Options\n");
           }
        
      } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a numeric option (1 or 2).\n");
                scan.nextLine(); 
            }

   }     
     
}

    // Method to create the cipher alphabet including the keyword
    public static void createCipherAlphabet() {
        for (int i = 0; i < keyword.length(); i++) {
            if (cipherAlphabet.indexOf(keyword.charAt(i)) == -1) {
                cipherAlphabet += keyword.charAt(i);
            }
        }
        for (int i = 0; i < alphabet.length(); i++) {
            if (cipherAlphabet.indexOf(alphabet.charAt(i)) == -1) {
                cipherAlphabet += alphabet.charAt(i);
            }
        }
    }

    // Method to encrypt plaintext
    public static void encrypt() {
          ciphertext = "";
        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            switch (ch) {
                case 'a': ciphertext += cipherAlphabet.charAt(0); break;
                case 'b': ciphertext += cipherAlphabet.charAt(1); break;
                case 'c': ciphertext += cipherAlphabet.charAt(2); break;
                case 'd': ciphertext += cipherAlphabet.charAt(3); break;
                case 'e': ciphertext += cipherAlphabet.charAt(4); break;
                case 'f': ciphertext += cipherAlphabet.charAt(5); break;
                case 'g': ciphertext += cipherAlphabet.charAt(6); break;
                case 'h': ciphertext += cipherAlphabet.charAt(7); break;
                case 'i': ciphertext += cipherAlphabet.charAt(8); break;
                case 'j': ciphertext += cipherAlphabet.charAt(9); break;
                case 'k': ciphertext += cipherAlphabet.charAt(10); break;
                case 'l': ciphertext += cipherAlphabet.charAt(11); break;
                case 'm': ciphertext += cipherAlphabet.charAt(12); break;
                case 'n': ciphertext += cipherAlphabet.charAt(13); break;
                case 'o': ciphertext += cipherAlphabet.charAt(14); break;
                case 'p': ciphertext += cipherAlphabet.charAt(15); break;
                case 'q': ciphertext += cipherAlphabet.charAt(16); break;
                case 'r': ciphertext += cipherAlphabet.charAt(17); break;
                case 's': ciphertext += cipherAlphabet.charAt(18); break;
                case 't': ciphertext += cipherAlphabet.charAt(19); break;
                case 'u': ciphertext += cipherAlphabet.charAt(20); break;
                case 'v': ciphertext += cipherAlphabet.charAt(21); break;
                case 'w': ciphertext += cipherAlphabet.charAt(22); break;
                case 'x': ciphertext += cipherAlphabet.charAt(23); break;
                case 'y': ciphertext += cipherAlphabet.charAt(24); break;
                case 'z': ciphertext += cipherAlphabet.charAt(25); break;
                default: ciphertext += ""; 
            }
        }
    }

    // Method to decrypt ciphertext
    public static void decrypt() {
        plaintext = ""; 
        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);
            int index = cipherAlphabet.indexOf(ch);
            if (index != -1) {
                plaintext += alphabet.charAt(index);
            } else {
                plaintext += ""; 
            }
        }
    }
}
