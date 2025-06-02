package org.example.project_02_jsp_servlets.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static final String URL;
    public static final String USER;
    public static final String PASS;

    static {
//         if .env file doesn't exists, catch error and load it by OS env vars
//         this is useful with docker, preventing .env sensible information to
//         in container image and later be published in container regs. out there
        Dotenv dotenv;
        try {
            dotenv = Dotenv.configure().load();
        } catch (Exception e) {
            dotenv = null; // fallback to only system env vars
        }
        String pgHost = (dotenv == null) ? System.getenv("POSTGRES_HOST") : dotenv.get("POSTGRES_HOST");
        String pgPort = (dotenv == null) ? System.getenv("POSTGRES_PORT") : dotenv.get("POSTGRES_PORT");
        String pgName = (dotenv == null) ? System.getenv("POSTGRES_DB") : dotenv.get("POSTGRES_DB");
        String pgUser = (dotenv == null) ? System.getenv("POSTGRES_USER") : dotenv.get("POSTGRES_USER");
        String pgPass = (dotenv == null) ? System.getenv("POSTGRES_PASSWORD") : dotenv.get("POSTGRES_PASSWORD");

        URL = "jdbc:postgresql://" + pgHost + ":" + pgPort + "/" + pgName;
        USER = pgUser;
        PASS = pgPass;
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}