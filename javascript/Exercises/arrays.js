// Part 1: Declaring and Accessing Arrays
let fruits = ["apple", "banana", "cherry", "date"];
console.log(fruits);
console.log("The first element is: " + fruits[0]);
console.log("The last element is: " + fruits[fruits.length - 1]);


// Part 2: Modifying Arrays
fruits[1] = "blueberry";
fruits.push("elderberry");
fruits.unshift("apricot");
console.log("Removed first element: " + fruits.shift());
console.log("Removed last element: " + fruits.pop());
console.log(fruits);


// Part 3: Looping Through an Array
for(let i = 0; i < fruits.length; i++){
    console.log(fruits[i]);
}

for(let i = 0; i < fruits.length; i += 2){
    console.log(fruits[i]);
}


// Part 4: Advanced Array Methods
let cherryIndex = fruits.indexOf("cherry");
console.log("The index of 'cherry' is " + cherryIndex);
fruits.splice(cherryIndex, 1);
let newArray = ["fig", "grape", "honeydew"];
fruits = fruits.concat(newArray);
console.log(fruits);

