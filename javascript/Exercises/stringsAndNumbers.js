// Part 1: If Statements (Even or Odd Checker)
let rand = Math.floor(Math.random() * 50) + 1; // get whole number

if(rand % 2 == 0){
    console.log(rand + " is even");
} else{
    console.log(rand + " is odd");
}


// Part 2: Switch Statement (Day of the Week)
let day = prompt("Enter a number 0-6");

switch(day){
    case "0":
        console.log("It is Sunday!");
        break;
    case "1":
        console.log("It is Monday!");
        break;
    case "2":
        console.log("It is Tuesday!");
        break;
    case "3":
        console.log("It is Wednesday!");
        break;
    case "4":
        console.log("It is Thursday!");
        break;
    case "5":
        console.log("It is Friday!");
        break;
    case "6":
        console.log("It is Saturday!");
        break;
    default:
        console.log("That number is out of range.");
}


// Part 3: While Loop (Rolling a Dice)
let die = -1;
while(die != 6){
    die = Math.floor(Math.random() * 6) + 1;
    console.log("You rolled a " + die);
}


// Part 4: For Loop (Counting Down)
let startingNumber = parseInt(prompt("Enter a number"));
for(let i = startingNumber; i >= 0; i--){
    console.log(i);
}


// Bonus Challenge: Reverse a word
let input = prompt("Enter a word to be reversed");
let output = "";
for(let i = input.length - 1; i >= 0; i--){
    output = output + input.charAt(i);
}
console.log(output);