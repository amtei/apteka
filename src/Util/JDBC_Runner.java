package Util;

import java.sql.SQLException;

public class JDBC_Runner {
    public static void main(String[] args) throws SQLException {
        checkMetaData();
    }
        private static void checkMetaData() throws SQLException {
            try (var connection = ConnectionManager.get()) {
                var metaData = connection.getMetaData();
                var catalogs = metaData.getCatalogs();
                while (catalogs.next()) {
                    var catalog = catalogs.getString(1);
                    var schemas = metaData.getSchemas();
                    while (schemas.next()) {
                        var schema = schemas.getString("TABLE_SCHEM");
                        var tables = metaData.getTables(catalog, schema, "%", new String[] {"TABLE"});
                        if (schema.equals("public")) {
                            while (tables.next()) {
                                System.out.println(tables.getString("TABLE_NAME"));
                            }
                        }
                    }
                }
            }
    }
}
