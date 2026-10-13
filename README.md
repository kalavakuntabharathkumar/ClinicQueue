# ClinicQueue — Appointment & Role-Based Booking Platform

A local-clinic appointment system with React, Spring Boot, Spring Security, JWT and MySQL.

## Features
- Patient registration/login and appointment booking.
- Doctor schedule and appointment status management.
- Admin, Doctor and Patient role boundaries enforced by Spring Security.
- Slot search with indexed date/doctor queries; seeded demo data.
- 14 REST routes documented below; H2 is available for local tests, MySQL for normal runs.

## Requirements
Java 17+, Maven 3.9+, Node 20+, npm, MySQL 8+.

## Run backend
Create a MySQL database `clinicqueue`, then set environment variables if needed:

```bash
cd backend
# Windows PowerShell: $env:DB_URL="jdbc:mysql://localhost:3306/clinicqueue"
# macOS/Linux: export DB_URL=jdbc:mysql://localhost:3306/clinicqueue
mvn spring-boot:run
```

Default local DB settings: `clinic_user` / `clinic_pass`; override with `DB_USERNAME` and `DB_PASSWORD`. The API listens on `http://localhost:8080`.

## Run frontend
```bash
cd frontend
npm install
npm run dev
```
Open `http://localhost:5173`. Configure `VITE_API_URL` to change the API origin.

## Demo flow
Register a patient from the UI, sign in, then book an appointment. The local development seeder creates `admin@clinicqueue.local` / `AdminPass123!` and `doctor@clinicqueue.local` / `DoctorPass123!` if they do not already exist. Public registration always creates a `PATIENT`; role assignment is not exposed through the public API. Change or remove demo credentials before deployment.

## API overview (14 routes)
- `POST /api/auth/register`, `POST /api/auth/login`
- `GET /api/doctors`, `GET /api/doctors/{id}`, `GET /api/doctors/{id}/slots`
- `POST /api/appointments`, `GET /api/appointments/my`, `GET /api/appointments/{id}`, `DELETE /api/appointments/{id}`
- `GET /api/appointments` (ADMIN/DOCTOR), `PATCH /api/appointments/{id}/status` (ADMIN/DOCTOR)
- `GET /api/admin/summary`, `GET /api/admin/users` (ADMIN)
- `GET /api/health`

## Tests
```bash
cd backend && mvn test
```
The schema includes indexes for doctor/date/status slot lookups and patient appointment history. The project does not include a 5,000-record performance benchmark; measure response times against a locally seeded dataset before reporting performance figures.
