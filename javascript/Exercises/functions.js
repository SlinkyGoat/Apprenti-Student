// Part 1: Function Basics
function greetUser(name){
    console.log(`Hello, ${name}!`);
}
greetUser("Adam");
greetUser("Anthony");


// Part 2: Returning Values
function squareNumber(num){
    return num * num;
}
fourSquared = squareNumber(4);
sevenSquared = squareNumber(7);
console.log(fourSquared);
console.log(sevenSquared);


// Part 3: Multiple Parameters
function addNumbers(num1, num2){
    return num1 + num2;
}
console.log(addNumbers(10, 5));
console.log(addNumbers(3, 8));


// Part 4: Random Color Generator
function getRandomColor(){
    let colors = ["red", "blue", "green", "yellow", "purple", "orange"];
    return colors[Math.floor(Math.random() * 6)];
}
console.log(getRandomColor());
console.log(getRandomColor());
console.log(getRandomColor());


// Part 5: Random Fortune Teller
function tellFortune(){
     let fortunes = [ 
        "You will have a great day!", 
        "A surprise is waiting for you.", 
        "Something exciting is coming soon.", 
        "Be cautious with your decisions today.", 
        "Happiness is around the corner." 
    ]; 
    return fortunes[Math.floor(Math.random() * 5)];
}
console.log(tellFortune());
