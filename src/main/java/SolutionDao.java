import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SolutionDao {
    public static Solution save(Solution solution) {
        if (solution.getId() == 0) {
//            robie insert do bazy
            List<String> params = new ArrayList<>();
            params.add(solution.getCreatedTime());
            params.add(solution.getUpdatedTime());
            params.add(solution.getDescription());
            params.add(solution.getExercise_id());
            params.add(solution.getUsers_id());
            try {
                Integer id = DbService.insertIntoDatabase(
                        "INSERT INTO solution(createdTime, updatedTime, description, exercise_id, users_id) VALUES (?, ?, ?, ?, ?)", params);
                solution.setId(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
//            aktualizuje obiekt
            List<String> params = new ArrayList<>();
            params.add(solution.getCreatedTime());
            params.add(solution.getUpdatedTime());
            params.add(solution.getDescription());
            params.add(solution.getExercise_id());
            params.add(solution.getUsers_id());
            params.add(String.valueOf(solution.getId()));
            try {
                DbService.executeUpdate(
                        "UPDATE solution SET createdTime = ?, updatedTime = ?, description = ?, exercise_id = ?, users_id = ? WHERE id = ?", params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return solution;
    }
    public static boolean delete(Solution group) {
        boolean isDeleted = false;
        try {
            List<String> params = new ArrayList<>();
            params.add(String.valueOf(group.getId()));
            int affectedRows = DbService.executeUpdate("DELETE FROM solution WHERE id = ?", params);
            isDeleted = affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    public static List<Solution> findAll() {
        List<Solution> solutions = new ArrayList<>();
        try {
            List<String[]> rows = DbService.getData("SELECT created, updated, description FROM solution", null);
            for (String[] item : rows) {
                Solution solution = new Solution(Integer.parseInt(item[0]), item[3], item[4], item[5], item[1], item[2]);
                solutions.add(solution);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solutions;
    }

    public static List<Solution> findAll(int limit) {
        List<Solution> solutions = new ArrayList<>();
        try {
            List<String[]> rows = DbService.getData("SELECT created, updated, description FROM solution ORDER BY updated DESC LIMIT " + limit, null);
            for (String[] item : rows) {
                Solution solution = new Solution(Integer.parseInt(item[0]), item[3], item[4], item[5], item[1], item[2]);
                solutions.add(solution);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solutions;
    }

    public static Solution findById(int id) {
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        try {
            List<String[]> rows = DbService.getData("SELECT created, updated, description FROM solution WHERE id=?", params);
            if (rows.size() > 0) {
                Solution solution = new Solution(Integer.parseInt(rows.get(0)[0]), rows.get(0)[3], rows.get(0)[4], rows.get(0)[5], rows.get(0)[1], rows.get(0)[2]);
                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}