
## 📚  Search Book Use Case

This Java program implements the **Search Book** use case for the *Book Cafe* (Library Management System) semester project.

### ✅ Purpose

Allow users to search for books using:

* **Title**
* **Author**
* **ISBN**

It validates the input, searches a dummy catalog, displays matching results, and logs the search activity.

### 🛠️ How It Works

1. The system loads the **search page**.
2. The user enters one or more search fields (title, author, ISBN).
3. Input is validated:

   * At least one field must be filled.
   * ISBN must be 10 or 13 digits (if entered).
4. The system **searches a sample book catalog**.
5. Matching books are **displayed**.
6. Search is **logged** for future reference.

### 🧾 Files

* `SearchBookApp.java` – Main program file that contains all the logic.

  * Includes classes: `SearchData`, `Book`
  * Methods for each step of the use case (search, validate, query, display, log)

### 📦 Sample Catalog (Hardcoded)

The system currently searches in a static book list:

```java
new Book("Effective Java", "Joshua Bloch", "0134685997")
new Book("Clean Code", "Robert Martin", "0132350882")
new Book("Head First Java", "Kathy Sierra", "0596009208")
```

### 🖥️ How to Run

1. Open the file in an IDE like IntelliJ or Eclipse.
2. Run the `main()` method of `SearchBookApp`.
3. Enter search criteria when prompted in the console.

### 📌 Example

```
Enter book title (or leave blank): Clean
Enter author name (or leave blank): Martin
Enter ISBN (or leave blank): 
```

✅ Output:

```
Found 1 result(s).
Book: Clean Code by Robert Martin (ISBN: 0132350882)
Search log: User = user123, Query = [Title: Clean, Author: Martin, ISBN: ]
```

### 📁 Project Details

* **Use Case**: Search Book
* **Project**: Book Cafe (Library Management System)
* **Language**: Java (Console-based)
* **Tools**: IntelliJ / Eclipse / Any Java compiler
Video demonstration Link:https://drive.google.com/file/d/15rbO48QC6Lar2I5n_Yhmwora3SvE3IFl/view?usp=sharing
