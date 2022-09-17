import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ClickHouseJDBC {
    private static final String DB_URL = "jdbc:clickhouse://localhost:8123/";
    private static final String schemaScript = "src/main/resources/clickhouse/shema.sql";
    private static final String initScript = "src/main/resources/clickhouse/input.sql";


    public static void main(String[] args) {
        createAndInitDB();
    }

    private static void createAndInitDB() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             FileInputStream fisSchema = new FileInputStream(schemaScript);
             FileInputStream fisData = new FileInputStream(initScript)
        ) {
            executeScript(conn, fisSchema);
            executeScript(conn, fisData);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeScript(Connection conn, InputStream in) {
        Scanner s = new Scanner(in);
        s.useDelimiter("/\\*[\\s\\S]*?\\*/|--[^\\r\\n]*|;");

        try (Statement st = conn.createStatement()) {
            while (s.hasNext()) {
                String line = s.next().trim();
                if (!line.isEmpty())
                    st.execute(line);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
