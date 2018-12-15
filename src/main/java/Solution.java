public class Solution {
    private int id;
    private String updatedTime;
    private String createdTime;
    private String description;
    private String exercise_id;
    private String users_id;

    public Solution(int id, String updatedTime, String createdTime, String description, String exercise_id, String users_id) {
        this.id = id;
        this.updatedTime = updatedTime;
        this.createdTime = createdTime;
        this.description = description;
        this.exercise_id = exercise_id;
        this.users_id = users_id;
    }

    public String getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(String exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getUsers_id() {
        return users_id;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}