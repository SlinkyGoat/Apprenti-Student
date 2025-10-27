const book = {
    title: "JavaScript Basics",
    author: {
        name: "John Doe",
        social: {
            twitter: "@johndoe"
        }
    },
    edition: {
        year: 2025,
        volume: 7
    }
};

// Use optional chaining to access the Twitter handle 
console.log(book.author?.social?.twitter);

// Try accessing a non-existent property using optional 
console.log(book.publisher?.name); 


// QUESTIONS
// 1. What happens when you try to access book.publisher?.name?
//      It keeps going into each object parameter if it exists and returns the final result "@johndoe"
//
// 2. How does optional chaining prevent error in this scenario?
//      If either author or social did not exist and we did not use optional chaining then it would error
//      because it is trying to access a parameter that does not exist. Optional chaining allows us to
//      return undefined instead of erroring.
//
// 3. What would happen if we removed ?. in book.publisher?.name?
//      If would give us a TypeError because it is trying to read an element from "undefined" which
//      you cannot do.


// Challenge
if (book.edition?.year) {
    console.log(`Edition year: ${book.edition.year}`);
} else {
    console.log("Edition information not available");
}