import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        String query = "create table solution" +
                "(" +
                "  id          int auto_increment" +
                "    primary key," +
                "  created     datetime     null," +
                "  updated     datetime     null," +
                "  description varchar(255) null," +
                "  exercise_id int          null," +
                "  users_id    int(20)      null," +
                "  constraint solution_ibfk_1" +
                "  foreign key (exercise_id) references exercise (id)," +
                "  constraint solution_ibfk_2" +
                "  foreign key (users_id) references users (id)" +
                ");" +
                "" +
                "create index exercise_id" +
                "  on solution (exercise_id);" +
                "" +
                "create index users_id" +
                "  on solution (users_id);";


        try {
            DbService.insertIntoDatabase(query, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
