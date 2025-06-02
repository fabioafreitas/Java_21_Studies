# Project Setup Instructions

## 1. Create `.env` Files

Create a `.env` file in **both**:
- `src/main/resources/`
- the project **root directory (`/`)**

Use `template.env` as a reference.

These `.env` files serve two purposes:
- The root `.env` is used by `docker-compose.yml` to build and run the **local PostgreSQL container**.
- The `.env` inside `src/main/resources` is packaged into the `.war` and made accessible to the application at runtime by `DBUtil.java`.

## 2. Configure Tomcat 9 (Development)

- Download **Tomcat 9** locally.
- In IntelliJ, configure a **Tomcat Run Configuration** using **WAR exploded** deployment.
- Set the **context path to `/`** for clean local URLs (e.g., `http://localhost:8080/login`).

## 3. Run the Application with Docker Compose

To start the application environment (including PostgreSQL), run:

```bash
docker-compose up --build
```

Access the application at:  
`http://localhost:8080/`
