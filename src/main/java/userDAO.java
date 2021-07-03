


import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class userDAO {
    private static final String CREATE = "insert into users(email,username, password) VALUES (?, ?, ?);";
    private static final String GET_ID = "select * from users where username = ?";
    private static final String READ = "select * from users where id = ?";
    private static final String UPDATE ="update users set username = ?, email = ?, password = ? where id = ?";
    private static final String DELETE = "delete from users where id = ?";
    private static final String SHOW_ALL = "select * from users";
    public static void main(String[] args) {
        System.out.println();
    }

    public static User create(User user) {
        try (Connection conn = DBUtil.connect()){
            PreparedStatement stmt = conn.prepareStatement(CREATE);
            stmt.setString(1,user.getEMAIL());
            stmt.setString(2,user.getUSER());
            stmt.setString(3,user.getPASSWORD());
            stmt.executeUpdate();
            /*ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                user.setID(rs.getInt(1));
            }
            return user;*/
            PreparedStatement stmt2 = conn.prepareStatement(GET_ID);
            stmt2.setString(1, user.getUSER());
            ResultSet rs = stmt2.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("id");
                user.setID(user_id);
                System.out.println(user);
                return user;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    return null;
    }

    public static User read(int userId) {
        try (Connection conn = DBUtil.connect()) {
            PreparedStatement stmt = conn.prepareStatement(READ);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String pass = rs.getString("password");
                User user = new User(email,username,pass);
                user.setID(user_id);
                System.out.println(user);
                return user;
            }

        }catch (SQLException e){
            e.printStackTrace();

        }
        return null;
    }
    public static void update(User user) {
        try (Connection conn = DBUtil.connect()) {
            PreparedStatement stmt3 = conn.prepareStatement(UPDATE);
            stmt3.setString(1, user.getUSER());
            stmt3.setString(2, user.getEMAIL());
            stmt3.setString(3, user.getPASSWORD());
            stmt3.setInt(4, user.getID());
            stmt3.executeUpdate();
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public static void delete(int userId) {

        try (Connection conn = DBUtil.connect()) {
            PreparedStatement stmt4 = conn.prepareStatement(DELETE);
            stmt4.setInt(1, userId);
            stmt4.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    public  static User[] findAll() {
        try (Connection conn = DBUtil.connect()) {
            User[] users = new User[0];
            PreparedStatement stmt5 = conn.prepareStatement(SHOW_ALL);
            ResultSet rs = stmt5.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String pass = rs.getString("password");
                User user = new User(email, username, pass);
                user.setID(user_id);
                users = addToArray(user, users);

            }

            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }

    }
    private static User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
        tmpUsers[users.length] = u;
        return tmpUsers;

    }
    }

