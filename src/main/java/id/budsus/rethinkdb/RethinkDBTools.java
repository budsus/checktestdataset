package id.budsus.rethinkdb;

import java.util.Map;
import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Result;

public class RethinkDBTools {
    public final RethinkDB r = RethinkDB.r;
    public Connection conn = r.connection().hostname("localhost").port(28015).connect();

    public RethinkDBTools() {
    }

    public boolean findDocByURL(String url) {
        boolean exist = false;
        Result<Map> result = r.db("codesearchnet").table("java").filter(doc -> doc.g("url").match(url))
                .run(conn, Map.class);
        if (result.hasNext()) {
            exist = true;
        }
        return exist;
    }

    public void closeConn() {
        conn.close();
    }
}
