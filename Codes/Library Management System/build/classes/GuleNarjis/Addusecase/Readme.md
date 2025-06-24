#  Book Management System (Add Book Module)

## 🧱 Code Structure
The system is divided into three Java classes:

### 1. `Book.java`
This class represents a **book object** with the following properties:
- `title`: Name of the book
- `isbn`: Unique identifier for the book
- `author`: Name of the author
- `quantity`: How many copies are available
- `isAvailable`: Boolean flag set to true if quantity > 0

**Key Method:**
- `displayInfo()`: Prints all book details to the console.

---

### 2. `AddBook.java`
This class contains the **core logic** for:
- Adding a new book
- Checking for duplicate ISBNs
- Validating quantity
- Displaying all books in the system

**Key Methods:**
- `addBook()`: Handles input, validation, and creation of new books.
- `viewBooks()`: Lists all added books with their details.
- `findBookByIsbn()`: Checks if a book with the same ISBN already exists.

---

### 3. `MainAddBook.java`
This is the **entry point** of the application and provides a **simple menu** to the user.

**Menu Options:**
1. Add Book
2. View Books
3. Exit

User selects an option using a number input.

---

## 🧑‍💻 How a User Adds a Book
1. Run the `MainAddBook` class.
2. From the menu, choose **option 1** (`Add Book`).
3. The system will prompt:
   - Title of the book
   - ISBN (must be unique)
   - Author name
   - Quantity (must be a valid, non-negative number)
4. After all inputs are validated:
   - The book is added to the list.
   - A confirmation message and book details are displayed.

---

## ✅ Validation Checks
- ISBN must not already exist in the system.
- Quantity must be a valid integer and **not negative**.
- Any invalid input shows an error message and cancels the process.

---

## 💡 Output Example


https://drive.google.com/file/d/1-FcaN1oGKh5tO-3gkzZQXguv5q3SIIJe/view?usp=drive_link