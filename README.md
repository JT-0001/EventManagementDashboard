# 🎉 Event Management Dashboard

A full-stack web application to manage and display college events by department and club. Built using Java Spring Boot for the backend and HTML/CSS/JavaScript for the frontend.

---

## 🚀 Tech Stack

- 💻 **Backend**: Java, Spring Boot, MySQL
- 🌐 **Frontend**: HTML, CSS, JavaScript
- 🔐 **Authentication**: JWT
- 🖼️ **Media Handling**: Poster image upload
- 🧪 **API Testing**: Postman

---

## ✨ Features

- 🔐 Admin login with JWT token authentication
- 🏛️ Department-wise and club-wise event listings
- ➕ Add/remove events with:
  - Title, description, date, venue
  - Registration link
  - Poster upload
- 🧭 Navigation between multiple frontend pages
- 🧩 Backend built using RESTful APIs

---

## 📂 Project Structure

EventManagementDashboard/
├── eventdashboard/ # Java Spring Boot app
│ ├── controller/ # API controllers
│ ├── service/ # Business logic
│ ├── dao/ repository/ # Database access
│ ├── model/ # Event and Admin models
│ ├── config/ # CORS, JWT, security configs
│ └── application.properties
├── frontendems/ # HTML/CSS/JS Frontend files
│ ├── index.html
│ ├── admin-login.html
│ ├── admin-dashboard.html
│ ├── clubs.html
│ ├── design.html
│ └── other department pages
├── README.md

 ## ⚙️ How to Run

### 🖥️ Backend (Spring Boot)
1. Open `eventdashboard` in IntelliJ, Eclipse or VS Code
2. Configure your MySQL DB in `application.properties`
3. Run the main class: `EventdashboardApplication.java`

### 🌐 Frontend
1. Open the `frontendems` folder
2. Launch `index.html` in a browser or use Live Server extension in VS Code

### 📬 API Testing
Use [Postman](https://www.postman.com/) to test:
- `POST /api/admin/login`
- `GET /api/events/{department}`
- `POST /api/events` (for adding new events) 
