# 🎮 ETS Esports Website

This project is the official web platform for the **ETS Esports Club**.  
It provides a central place for players, admins, and fans to connect — including match schedules, team info, news, and member registration.

---

## 🏗️ Tech Stack

| Layer               | Technology                                            | Description                                                                           |
| ------------------- | ----------------------------------------------------- | ------------------------------------------------------------------------------------- |
| **Frontend**        | [Next.js](https://nextjs.org/)                        | Modern React framework for fast, SEO-friendly UI (Tailwind, Shadcn, Typescript)       |
| **Backend**         | [Spring Boot](https://spring.io/projects/spring-boot) | Java backend handling APIs, authentication, and data persistence (Data JPA, Security) |
| **Database**        | [PostgreSQL](https://www.postgresql.org/)             | Robust relational database for production                                             |
| **Hosting / Cloud** | [AWS](https://aws.amazon.com/)                        | Used for deployment and storage (EC2, RDS, S3, etc.)                                  |

---

## 🧱 Project Structure

```
root/
│
├── frontend/ # Next.js application
│ ├── src/ # Pages, components, and hooks
│ ├── package.json # Frontend dependencies and scripts
│ └── ...
│
├── backend/ # Spring Boot application
│ ├── src/main/java/... # Controllers, Services, Models
│ ├── pom.xml # Maven configuration
│ └── ...
│
└── README.md # This file

Each part of the stack is **fully independent**, making local development and deployment simpler.
```

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/LucasPierru/etsesports.git
cd etsesports
```

### 2. Run the Frontend (Next.js)

```bash
cd frontend
npm install
npm run dev
```

### 3. Run the Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run
```

### 4. Environment Variables

You’ll likely have two .env files:

🖥️ frontend/.env.local

```bash
NEXT_PUBLIC_API_URL=http://localhost:8080/api/v1
```

☕ backend/env.properties

```bash
DB_NAME=
DB_URL=
DB_USER=
DB_PASSWORD=
```

## 🧩 Database Models (Draft)

`User`
| Field | Type | Description |
| --------- | --------------------------------- | --------------- |
| id | UUID | Primary key |
| username | String | Unique username |
| email | String | Unique email |
| password | String | Hashed password |
| role | Enum (`PLAYER`, `ADMIN`, `COACH`) | User role |
| createdAt | Timestamp | Creation Date |
| updatedAt | Timestamp | Auto-generated |
| isActive | Boolean | True |

`Games`
| Field | Type | Description |
| --------- | --------- | ------------------- |
| id | UUID | Primary key |
| name | String | Game name |
| teams | List<Team> | Reference to `Team` |
| createdAt | Timestamp | Creation date |
| updatedAt | Timestamp | Auto-generated |

`Team`
| Field | Type | Description |
| --------- | --------- | ------------------- |
| id | UUID | Primary key |
| name | String | Team name |
| game | UUID | Reference to `Game` |
| players | List<Player> | Reference to `Player` |
| createdAt | Timestamp | Creation date |
| updatedAt | Timestamp | Auto-generated |

`Player`
| Field | Type | Description |
| ------ | ------ | ------------------------------------ |
| id | UUID | Primary key |
| username | String | Player's first name |
| firstName | String | Player's first name |
| lastName | String | Player's last name |
| dob | Timestamp | Player's date of birth |
| degree | String | Player's degree |
| team | UUID | Reference to `Team` |
| role | String | Player role (e.g., “Support”, “ADC”, "Duelist") |
| isActive | Boolean | True |
| createdAt | Timestamp | Creation date |
| updatedAt | Timestamp | Auto-generated |

`Coach`
| Field | Type | Description |
| ------ | ------ | ------------------------------------ |
| id | UUID | Primary key |
| user | UUID | Reference to `User` |
| team | UUID | Reference to `Team` |
| createdAt | Timestamp | Creation date |
| updatedAt | Timestamp | Auto-generated |

`School`
| Field | Type | Description |
| --------- | --------- | ------------------- |
| id | UUID | Primary key |
| name | String | School name |
| createdAt | Timestamp | Creation date |
| updatedAt | Timestamp | Auto-generated |

`Opponent`
| Field | Type | Description |
| --------- | --------- | ------------------- |
| id | UUID | Primary key |
| name | String | Team name |
| school | UUID | Reference to `School` |
| createdAt | Timestamp | Creation date |
| updatedAt | Timestamp | Auto-generated |

`Match`
| Field | Type | Description |
| --------- | --------- | -------------------- |
| id | UUID | Primary key |
| team | UUID | Reference to `Team` |
| opponent | UUID | Reference to `Opponent` |
| game | UUID | Reference to `Game` |
| date | Timestamp | Match date |
| teamScore | Int | Team result |
| opponentScore | Int | Opponent result |
| createdAt | Timestamp | Auto-generated |
| updatedAt | Timestamp | Auto-generated |

`NewsPost`
| Field | Type | Description |
| --------- | --------- | ------------------- |
| id | UUID | Primary key |
| title | String | Article title |
| content | Text | Article content |
| author | UUID | Reference to `User` |
| createdAt | Timestamp | Auto-generated |
| updatedAt | Timestamp | Auto-generated |

`Registration`
| Field | Type | Description |
| --------- | --------- | ------------------- |
| id | UUID | Primary key |
| email | String | Contact's email |
| name | String | Contact's name |
| message | Text | Contact's message |
| game | UUID | Reference to `Game` |
| createdAt | Timestamp | Auto-generated |
| updatedAt | Timestamp | Auto-generated |

## 🚀 Deployment

### Frontend (Next.js)

- Option 1: Deploy to Vercel for easiest setup.
- Option 2: Host on AWS Amplify or S3 + CloudFront for static builds.

### Backend (Spring Boot)

- Package the app:

```bash
./mvnw clean package
```

- Deploy to AWS:
  - EC2 for custom hosting
  - Elastic Beanstalk for managed deployment
  - RDS for PostgreSQL
  - S3 for file uploads

## 🧰 Development Tips

- Keep the backend and frontend running in two terminals.
- Use npm run build and ./mvnw package to prepare for production.
- Configure CORS in Spring Boot so your frontend can call APIs:

```bash
@CrossOrigin(origins = "http://localhost:3000")
```

- Use .env files for secrets; never commit them.

## 🕹️ Features to Build

**1. User Authentication**

- Sign up / Login / Logout
- Role-based access (Admin, Player)
- JWT tokens or NextAuth session

**2. Team Management**

- Create and join teams
- Manage rosters
- Update player's data

**3. Match Scheduling**

- Admins schedule matches
- View upcoming and past matches
- Submit scores and results

**4. News & Updates**

- Admins post updates and announcements
- Players and visitors can view the feed

**5. Profile System**

- Display stats, teams, and match history
- Edit personal details

**6. Media & Gallery**

- Upload tournament photos or highlight clips (S3)

**7. Event Calendar**

- Show upcoming matches and tournaments

## 📄 License

MIT License © Lucas Pierru
ETS Esports — 2025
