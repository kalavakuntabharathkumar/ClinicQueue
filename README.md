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
Register a patient from the UI, sign in, then book an appointment. Admin and doctor accounts can be created through `/api/auth/register` with the corresponding role only in a trusted local demo; production deployments must restrict role assignment to admins. For safety, the public registration route forces `PATIENT` regardless of submitted role.

## API overview (14 routes)
- `POST /api/auth/register`, `POST /api/auth/login`
- `GET /api/doctors`, `GET /api/doctors/{id}/slots`
- `POST /api/appointments`, `GET /api/appointments/my`
- `GET /api/appointments` (ADMIN/DOCTOR), `PATCH /api/appointments/{id}/status` (ADMIN/DOCTOR)
- `GET /api/admin/summary` (ADMIN)
- `GET /api/health`

## Tests
```bash
cd backend && mvn test
```
The slot-search performance claim in the project brief is a target measurement, not a benchmark guaranteed on every machine. Use the included seed runner and Postman collection to reproduce timings locally.
