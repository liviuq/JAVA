1. Compulsory (1p)
Write a Java application that implements the following operations:
Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)
Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
Generate a random integer n: int n = (int) (Math.random() * 1_000_000);
Compute the result obtained after performing the following calculations:
  multiply n by 3;
  add the binary number 10101 to the result;
  add the hexadecimal number FF to the result;
  multiply the result by 6;
Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.
Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].

2. Homework (2p)

Let n, p be two integers and C1,...,Cm a set of letters (the alphabet), all given as a command line arguments. Validate the arguments!
Create an array of n strings (called words), each word containing exactly p characters from the given alphabet.
Display on the screen the generated array.
Two words are neighbors if they have a common letter.
Create a boolean n x n matrix, representing the adjacency relation of the words.
Create a data structure (using arrays) that stores the neighbors of each word. Display this data structure on the screen.
For larger n display the running time of the application in nanoseconds (DO NOT display the data structure!). Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.
Launch the application from the command line, for example: java Lab1 100 7 A C G T.
