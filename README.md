# Programming course "Programming4you"

Starting with the basics of java, with each subsequent task I had the pleasure of delving deeper into more complex concepts. Some tasks were descriptive, without coding, that's why their numbering is incosistent. 
Every task was reviewed by my mentor, this taught me working with code-review which I think is great thing that prepared me well for real working scenarios.

## Task 3

Create a Java program with two variables firstNumber and secondNumber. Output four lines:

    X plus Y is (X+Y)
    X minus Y is (X-Y)
    X times Y is (X*Y)
    X divided by Y is (X/Y)
    
Example: if firstNumber is 10 and secondNumber is 2, the program should output:

10 plus 2 is 12
10 minus 2 is 8
10 times 2 is 20
10 divided by 2 is 5

## Task 4

Write a Java program with a String variable. Output Your string is not too long if the length of the string is not greater than 7 characters. Otherwise, output Your string is quite long.

Example:

String name = "Wojtek";
System.out.println("Name " + name + " has " + name.length() + " characters.");

## Task 5

Create a Java class Ziomek with a static method printZiomek(int upperBound). 
The method should print numbers from 1 to upperBound. If a number is divisible by 4, print it in one line, followed by a space and "Zio". If it's divisible by 5, print "mek" (without the space at the beginning). 
If it's divisible by 3, do not print it at all.

Example: Ziomek.printZiomek(23) should output:

1
2
4 Zio
5 mek
7
8 Zio
10 mek
11
13
14
16 Zio
17
19
20 Ziomek
22
23

Printing without a newline at the end is done with System.out.print(), and with a newline is done with System.out.println().
Checking if a number is divisible by another is done using the modulo operator %. For example, myNumber % 4 == 0 will be true if myNumber is divisible by 4.

## Task 8

Write a method boolean haveSameElements(List<String> list, String[] array) in Java, which returns true if the elements at the same indices in the list and array are the same. 
If the array or list is longer, the program should ignore the extra part. Compare strings using the equals() method.

Example:

List<String> list = {"a", "b", "c", "d"};
String[] array = {"a", "b"};
// the method should return true

List<String> list = {"jeden", "dwa"};
String[] array = {"raz", "dwa"};
// the method should return false

## Task 9

Create a Java class Guest with fields String name and int age, along with appropriate getters and a constructor.
Create a class Bodyguard with a field String[] allowedGuestNames and a method boolean check(Guest guest) that returns true if the guest is an adult and is on the allowed guest list, and false otherwise.
Compare strings using the equals() method.

Example in class Task8:

public class Task8 {

  public static void main(String[] args) {
    Bodyguard bodyguard = new Bodyguard();
    bodyguard.setAllowedGuestNames(new String[]{"Marek", "Kasia", "Basia"});

    Guest marek1 = new Guest("Marek", 15);
    Guest marek2 = new Guest("Marek", 25);
    Guest kasia = new Guest("Kasia", 30);
    Guest monika = new Guest("Monika", 25);
    Guest[] guests = {marek1, marek2, kasia, monika};
    
    for (Guest guest : guests) {
      System.out.print("Guest " + guest.getName() + " is ");
      System.out.print(bodyguard.check(guest) ? "" : " NOT ");
      System.out.println("allowed!");
    }
  }
}

## Task 10

Write any Java program that utilizes any library. Handle possible errors.

## Task 11

Write a Java program that reads a file specified in the command-line arguments and prints the longest line in that file.

## Task 18

Create an interface Lottery with methods List<Player> getWinners() and void play(Player player). Also, create a class Player with at least one field (and getter) name. 
Players play by calling the play method, and when all players have played, the winners are selected by calling getWinners(). Compare strings using the equals method.

Create three implementations of the Lottery interface:

    "Fair" lottery, where each player has a 1/number_of_players chance of winning (can be more than 1). Use the Random class for drawing.
    "Charity" lottery, where everyone wins.
    "Casino," where no one wins.

In the main class, print the names of the winners or "Sorry, there were no winners this time!" if there are none.

## Task 19

Create an interface HasCpu with methods int getCores() and int getBaseClockMhz().
Create an enum GraphicsCardType with types NONE, DEDICATED, INTEGRATED. Create a class Computer that implements the HasCpu interface and has fields for RAM memory, graphics card type, etc.
Create a class Laptop that extends the Computer class and has an additional method double getBatteryCapacityWh(). 
Implement a method public static Set<Computer> getAirplaneLegalComputers(List<Computer> computers) that returns a Set of all computers from the list that are either not laptops or are laptops with a battery less than 100Wh. 
Ensure that computers with the same parameters do not appear twice in the result set.

## Task 20

Write a Java client for Chat GPT that suggests breakfast ideas based on given products. Read the product data from a file. 
Store the configuration in a gpt.conf file and read parameters such as token, model name, etc., from it. Do not commit this file to the repository. 
Design the program so that it is easy to replace the interaction with ChatGPT (create a suitable interface). Define your exceptions (e.g., CannotAskQuestionException) and handle them in your code. 
Use at least three design patterns, and on a private channel, let me know what patterns you used and why.

## Task 23

Write a Java program that somehow receives information from the user (e.g., reads from the console, file, or command-line arguments) and uses that information to call any REST API and return any response. 
For example, ask for the user's favorite movie and output its release date.

## Task 24 (Java and Python)

Write a Java program that handles GET requests at a specific address (e.g., /books) and prints some objects.
Handle POST requests, where it creates these objects and returns their IDs. Write two Python programs.
The first one reads a list of objects from a file or user input and "uploads" them to the server via POST requests. The second one retrieves objects by ID through GET requests.
