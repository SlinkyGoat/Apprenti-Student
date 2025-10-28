const book = {
    title: "The Great Gatsby",
    author: "F. Scott Fitzgerald",
    year: 1925,
};

let { title, author, year } = book;

console.log(title);
console.log(author);
console.log(year);

// Challenge

let { title: bookTitle, author: writer } = book;
console.log("renamed values while destructuring:");
console.log(bookTitle);
console.log(writer);
