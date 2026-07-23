import { Component } from '@angular/core';

interface Book {
  title: string;
  author: string;
  releaseYear: number;
}

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  books: Book[] = [
    { title: 'The Great Gatsby', author: 'F. Scott Fitzgerald', releaseYear: 1925 },
    { title: 'To Kill a Mockingbird', author: 'Harper Lee', releaseYear: 1960 },
    { title: '1984', author: 'George Orwell', releaseYear: 1949 },
    { title: 'Pride and Prejudice', author: 'Jane Austen', releaseYear: 1813 },
    { title: 'The Catcher in the Rye', author: 'J.D. Salinger', releaseYear: 1951 },
    { title: 'The Hobbit', author: 'J.R.R. Tolkien', releaseYear: 1937 },
    { title: 'Fahrenheit 451', author: 'Ray Bradbury', releaseYear: 1953 },
    { title: 'The Book Thief', author: 'Markus Zusak', releaseYear: 2005 },
    { title: 'The Chronicles of Narnia', author: 'C.S. Lewis', releaseYear: 1950 },
    { title: 'Animal Farm', author: 'George Orwell', releaseYear: 1945 },
    { title: 'Jane Eyre', author: 'Charlotte Brontë', releaseYear: 1847 },
    { title: 'The Grapes of Wrath', author: 'John Steinbeck', releaseYear: 1939 },
    { title: 'The Lord of the Rings', author: 'J.R.R. Tolkien', releaseYear: 1954 },
    { title: 'The Alchemist', author: 'Paulo Coelho', releaseYear: 1988 },
    { title: 'Harry Potter and the Sorcerer\'s Stone', author: 'J.K. Rowling', releaseYear: 1997 },
    { title: 'The Little Prince', author: 'Antoine de Saint-Exupéry', releaseYear: 1943 },
    { title: 'Brave New World', author: 'Aldous Huxley', releaseYear: 1932 },
    { title: 'Wuthering Heights', author: 'Emily Brontë', releaseYear: 1847 },
    { title: 'Great Expectations', author: 'Charles Dickens', releaseYear: 1861 },
    { title: 'The Hitchhiker\'s Guide to the Galaxy', author: 'Douglas Adams', releaseYear: 1979 }
  ];
}
