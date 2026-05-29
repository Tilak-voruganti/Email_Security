# 🔐 Secure Cloud Email Filtering & Search System

A privacy-preserving email security system built in Java that enables spam and malware filtering on **encrypted emails** — without ever decrypting the full message content.

---

## 💡 The Problem It Solves

Traditional email filters need to read your emails in plain text to detect spam or malware — a major privacy risk. This project solves that by allowing a filtering server to screen message content **without requiring full decryption**, keeping user data private while still blocking threats.

---

## ✨ Key Features

- 🔒 Server-side email filtering without full message decryption
- 🔍 Keyword-based search on encrypted email content
- 🚫 Spam and malware detection layer
- 🗄️ MySQL database for user and email management
- 🌐 Web interface (HTML/CSS/JavaScript frontend)

---

## 🛠️ Tech Stack

| Layer      | Technology              |
|------------|-------------------------|
| Backend    | Java (Servlets / JSP)   |
| Frontend   | HTML5, CSS3, JavaScript |
| Database   | MySQL                   |
| IDE        | Eclipse                 |
| Server     | Apache Tomcat           |

---

## 🗂️ Project Structure

```
Email_Security/
├── src/com/          # Java source files (servlets, logic)
├── WebContent/       # Frontend (HTML, CSS, JS, JSP pages)
├── vtjcc04db.sql     # MySQL database schema & seed data
└── VTJCC04.pdf       # Project report / documentation
```

---

## ⚙️ How to Run Locally

### Prerequisites
- Java JDK 8+
- Apache Tomcat 9+
- MySQL Server
- Eclipse IDE (or any Java IDE)

### Steps

1. **Clone the repository**
```bash
   git clone https://github.com/Tilak-voruganti/Email_Security.git
```

2. **Set up the database**
   - Open MySQL Workbench or CLI
   - Run the SQL script:
```sql
     source vtjcc04db.sql;
```

3. **Import into Eclipse**
   - File → Import → Existing Projects into Workspace
   - Select the cloned folder

4. **Configure DB connection**
   - Update database credentials in the relevant Java config/servlet file

5. **Deploy to Tomcat**
   - Right-click project → Run As → Run on Server
   - Open `http://localhost:8080/Email_Security`

---

## 📄 Documentation

Full project report is available: [VTJCC04.pdf](./VTJCC04.pdf)

---

## 👤 Author

**Tilak Voruganti**  
B.Tech CSE — Guru Nanak Institutions Technical Campus, Hyderabad  
📧 tilakvoruganti@gmail.com  
🔗 [LinkedIn](https://linkedin.com/in/voruganti-tilak)

---

## 📌 Note

This project was developed as part of academic coursework focused on applied cryptography and cloud security concepts in Java.

