# UNiDAYS-Discount-Challenge

## Running my Code

My code is built to run in Command Prompt or Terminal. To run the program, download the four provided .class files to a folder, navigate to it using the terminal and enter 'java Main'

## My Approach

I chose to complete the challenge in Java as this is the primary language I have learnt since starting university. My first step was to create the Enum Class for the items, to store the cost of each item and to make my life slightly easier when coding the Main class. I gave this class an accessor method for the price to keep the field Private. I tried to do so with as many fields as I felt was possible.

I next moved on to the UnidaysDiscountChallenge Class. I started with an ArrayList for the basket to keep things simple. I made my addToBasket method with two parameters, item and quantity. I did this so that when running the programming repeated items do not need to be added one at a time. I used a do-while loop to add the item into the basket as many times as the user input.

For my calculateTotalPrice method, I started by creating 5 ints to store how many times each item appears in the basket, while also initialising a double value for the total price and a double value to show the price without the discounts, as I wanted to include a 'total savings' line in the final output. I used a switch statement nested in a for loop which iterated over the contents of the basket, create the necessary value for each item it found. I then calculated the 'pre-discount' total using the prices from the item enum (using the accessor method) multiplied by that item's total number of occurrences.

I then calculated the accumulative price of each items occurrences using different maths for each item to represent the discounts (I have added comments to show what discount is being represented by the following maths). I then used an if-statement to decide if there would be a delivery charge or not depending on the total price calculated above. Finally, I created a new total variable combining the total calculated earlier and the delivery cost. I returned the total, pre-discount total, delivery charge and overall total in an array of doubles.

I then moved onto my Main class. I wrote the main method, followed by three methods to display a welcome message, the 'item catalogue' and a list of available options. The first of these methods also has a while loop to determine if the program is still running (while(!finished)). There is a quit method at the end which sets 'finished' to true, which can be called by the user.

I wrote a getCommand method and a parse method which work together using a Scanner class from the java.util library to accept a typed user input and read it word by word to generate an output. The getCommand method prints success or error messages based on the user input.


