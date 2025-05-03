Return Book Use Case
This Java program simulates the Return Book use case for the Book Cafe Library Management System.

✅ Purpose
Allows a user to return a book by entering its Book ID.
It verifies the return, checks for late return fines, and logs the activity.

🛠️ How It Works
User selects "Return Book" from the system.

User enters Book ID.

System verifies:

If the book is issued to the user.

If valid:

Book is marked as returned.

Fine is calculated if book is late.

Return is logged.

If invalid:

Displays error message.

🧾 Files
ReturnBookApp.java – A simple Java file containing:

A dummy list of issued books.

Methods to return the book, check fines, and log return.

Inner Book class for book data.

🧪 Sample Data (Preloaded)
java
Copy
Edit
Book("B101", "Clean Code", "user123", "2024-04-15")
📦 Features
Console-based input for Book ID.

Validates issued books.

Dummy fine calculation logic.

Logs return activity.

📥 How to Run
Open the file in IntelliJ / Eclipse or any Java IDE.

Run the main() method.

Enter the issued Book ID when prompted.

📌 Example
pgsql
Copy
Edit
Enter Book ID to return: B101
Book returned successfully: Clean Code
Book is returned late. Fine: Rs. 50
Return logged for book ID: B101, by user: user123
💡 Notes
This version assumes the return is always late for simplicity.

Fine is fixed (Rs. 50) for demonstration.

You can extend this with actual date checks and dynamic fine calculation.
Video demonstration Link:https://drive.google.com/file/d/15rbO48QC6Lar2I5n_Yhmwora3SvE3IFl/view?usp=sharing
