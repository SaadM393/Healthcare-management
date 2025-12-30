# Healthcare-management
🏥 Hospital Management System

A Java-based Hospital Management System developed using JSP, Servlets, JDBC, and Apache Tomcat. This project helps manage hospital operations such as patients, doctors, appointments, diagnosis, billing, prescriptions, medical store, accounts, and reports through a centralized dashboard.


---

🚀 Features

📊 Dashboard overview

👨‍⚕ Doctor management

🧑‍🤝‍🧑 Patient management

📅 Appointments scheduling

🩺 Diagnosis records

💊 Prescription management

🏪 Medical store module

💰 Billing & accounts

📑 Reports generation



---

🛠 Tech Stack

Frontend: JSP, HTML5, CSS3

Backend: Java, Servlets (Jakarta Servlet API)

Database: MySQL (via JDBC)

Server: Apache Tomcat 10/11

IDE: Eclipse



---

📂 Project Structure

healthcare-management/
│
├── src/main/java/
│   └── com/hospital/
│       ├── controller/
│       │   ├── AccountsServlet.java
│       │   ├── AppointmentsServlet.java
│       │   ├── BillingServlet.java
│       │   ├── DashboardServlet.java
│       │   ├── DiagnosisServlet.java
│       │   ├── DoctorsServlet.java
│       │   ├── MedicalStoreServlet.java
│       │   ├── NewappointmentServlet.java
│       │   ├── NewpatientServlet.java
│       │   └── PrescriptionServlet.java
│       └── util/
│           └── DBConnection.java
│
├── src/main/webapp/
│   ├── css/
│   ├── quicklinks/
│   │   ├── billing.jsp
│   │   └── newAppointment.jsp
│   ├── WEB-INF/
│   │   ├── accounts.jsp
│   │   ├── appointments.jsp
│   │   ├── dashboard.jsp
│   │   ├── diagnosis.jsp
│   │   ├── doctors.jsp
│   │   ├── index.jsp
│   │   ├── medicalStore.jsp
│   │   ├── newPatient.jsp
│   │   ├── patients.jsp
│   │   ├── prescription.jsp
│   │   └── reports.jsp
│   └── META-INF/
│       └── MANIFEST.MF
│
└── README.md


---

⚙ Setup & Run Instructions

1. Clone the repository

git clone https://github.com/your-username/hospital-management-system.git


2. Open the project in Eclipse IDE


3. Configure Apache Tomcat Server


4. Create MySQL database and update credentials in DBConnection.java


5. Run the project on server


6. Access in browser:

http://localhost:8084/healthcare-management/




---

📸 Screenshots

> available in project-content




---

👨‍💻 Author

Your Name-Saad Mohammad

Java Developer



---

📜 License

This project is for educational purposes.
