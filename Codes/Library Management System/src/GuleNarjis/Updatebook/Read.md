# Code Explanation for "Update Book" Use Case

## Classes Overview:

1. **Book.java**:
   - This class represents a book in the system.
   - It contains fields like `bookId`, `title`, `author`, `genre`, `price`, and `isAvailable`.
   - Methods include getters, setters, and a `display()` method to show book details.

2. **UpdateBook.java**:
   - This class contains the method `updateBook(List<Book> books)`, which allows an admin/librarian to update book details.
   - The method checks for existing books using their ID and prompts the user to modify various attributes (title, author, genre, price, availability).
   - After editing, it validates the price and updates the book’s information.

3. **Main.java**:
   - This is the entry point of the program.
   - It contains a menu to select options like "Update Book" or "Exit".
   - It initializes some sample books and calls the `updateBook()` method from `UpdateBook.java` to update book details.

## Workflow:

1. **User Interaction**:
   - The program presents the user with options to either update a book or exit.
   - Upon selecting "Update Book", the program asks for a `bookId`, then fetches the book details if the ID matches an existing book.

2. **Updating Book Details**:
   - The user can modify any of the fields like title, author, genre, price, and availability.
   - It validates if the price is a positive number and ensures that the updated information is valid.

3. **Success or Error**:
   - If the book ID is found, the details are updated and the new information is displayed.
   - If the book ID is not found, an error message is shown.

## Assumptions:

- The book's price must always be a positive value.
- The availability status is a boolean (`true` for available, `false` for unavailable).
- The system does not handle concurrency issues (i.e., two users updating the same book simultaneously).

