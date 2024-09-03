package com.restaurant.dao;

import com.restaurant.model.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAO {
    private Connection connection;

    public QueryDAO(Connection connection) {
        this.connection = connection;
    }

    public void saveQuery(Query query) {
        String queryStr = "INSERT INTO queries (user_id, query_text) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(queryStr)) {
            stmt.setInt(1, query.getUserId());
            stmt.setString(2, query.getQueryText());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Query> getQueriesByUserId(int userId) {
        List<Query> queries = new ArrayList<>();
        String queryStr = "SELECT * FROM queries WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(queryStr)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                queries.add(new Query(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("query_text"),
                    rs.getString("response")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queries;
    }
}
