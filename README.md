# 🎵 DoReMi Subscription Manager CLI

A simple Java-based CLI application to manage your recurring subscriptions like Netflix, Prime, Spotify, etc. Easily track due dates, costs, and categories of all your subscriptions!

---

## 💡 Features

- 📌 Add, update, delete subscriptions
- 📅 Track monthly/annual renewal dates
- 💰 View total cost per category
- 🗂 Sort by due date, category, or name
- 🧾 Export subscription details (coming soon)

---

## 🧰 Tech Stack

- **Language:** Java 17  
- **Build Tool:** Maven  
- **Architecture:** OOP-based clean structure  
- **Testing:** JUnit 5 (planned)

---

## 📦 Project Structure

com.doremi
├── manager # Core business logic
├── model # POJOs like Subscription
├── util # Helpers and formatters
├── exception # Custom exceptions
└── Main.java # Entry point


---

## 🚀 How to Run

### 💻 Prerequisites
- Java 17+
- Maven

### ▶️ Run the App

```bash
git clone https://github.com/kk1948/DoReMi-CLI.git
cd DoReMi-CLI
mvn compile
mvn exec:java -Dexec.mainClass="com.doremi.Main"


🛠️ Future Enhancements
🌐 Spring Boot Web version

🗃 Persistent storage using JSON or DB

📤 Export to CSV/Excel

✅ Unit testing coverage

🙋‍♂️ Author
Kishan Rai

🔗 GitHub
📫 Email: rai123vishwa@gmail.com
