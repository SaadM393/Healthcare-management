<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hospital Management Dashboard</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet"
 href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

</head>

<body>

<!-- NAVBAR -->
<header class="navbar">
  <div class="logo">InfaERP</div>
  <nav>
    <a href="dashboard.jsp"><i class="fa-solid fa-chart-line"></i> Dashboard</a>
    <a href="doctors.jsp"><i class="fa-solid fa-user-doctor"></i> Doctors</a>
    <a href="patients.jsp"><i class="fa-solid fa-bed"></i> Patients</a>
    <a href="appointments.jsp"><i class="fa-solid fa-calendar-check"></i> Appointments</a>
    <a href="diagnosis.jsp"><i class="fa-solid fa-stethoscope"></i> Diagnosis</a>
    <a href="prescriptions.jsp"><i class="fa-solid fa-file-prescription"></i> Prescription</a>
    <a href="medicalStore.jsp"><i class="fa-solid fa-pills"></i> Medical Store</a>
    <a href="accounts.jsp"><i class="fa-solid fa-wallet"></i> Accounts</a>
    <a href="reports.jsp"><i class="fa-solid fa-chart-pie"></i> Reports</a>
  </nav>
</header>

<!-- MAIN CONTENT -->
<div class="main">

  <!-- CARDS SECTION (Clickable) -->
  <div class="cards">
    <a href="dashboard.jsp" class="card"><i class="fa-solid fa-chart-line"></i><span>Dashboard</span></a>
    <a href="doctors.jsp" class="card"><i class="fa-solid fa-user-doctor"></i><span>Doctors</span></a>
    <a href="patients.jsp" class="card"><i class="fa-solid fa-bed"></i><span>Patients</span></a>
    <a href="appointments.jsp" class="card"><i class="fa-solid fa-calendar-check"></i><span>Appointments</span></a>
    <a href="diagnosis.jsp" class="card"><i class="fa-solid fa-stethoscope"></i><span>Diagnosis</span></a>
    <a href="prescription.jsp" class="card"><i class="fa-solid fa-file-prescription"></i><span>Prescription</span></a>
    <a href="medicalStore.jsp" class="card"><i class="fa-solid fa-pills"></i><span>Medical Store</span></a>
    <a href="accounts.jsp" class="card"><i class="fa-solid fa-wallet"></i><span>Accounts</span></a>
    <a href="reports.jsp" class="card"><i class="fa-solid fa-chart-pie"></i><span>Reports</span></a>
  </div>

  <!-- QUICK LINKS -->
  <aside class="sidebar">
    <h3>Quick Links</h3>
    <ul>
      <li><i class="fa-solid fa-plus"></i> <a href="quicklinks/newAppointment.jsp">New Appointment</a></li>
      <li><i class="fa-solid fa-user-plus"></i> <a href="newPatient.jsp">New Patient</a></li>
      <li><i class="fa-solid fa-file-prescription"></i> <a href="quicklinks/billing.jsp">Billing</a></li>
    </ul>
  </aside>

</div>

<!-- FOOTER -->
<footer>© 2025 Hospital Management System</footer>

</body>
</html>
