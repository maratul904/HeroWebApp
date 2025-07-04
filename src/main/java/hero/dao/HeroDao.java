package com.hero.dao;

import com.hero.model.Hero;
import com.hero.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDao {

    public List<Hero> getAll() {
        List<Hero> list = new ArrayList<>();
        try {
            Connection conn = DatabaseUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tm_hero");

            while (rs.next()) {
                Hero h = new Hero(
                        rs.getInt("id_hero"),
                        rs.getString("nama_hero"),
                        rs.getString("kategori"),
                        rs.getString("gender")
                );
                list.add(h);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Hero hero) {
        try {
            Connection conn = DatabaseUtil.getConnection();
            String sql = "INSERT INTO tm_hero (nama_hero, kategori, gender) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, hero.getNama());
            stmt.setString(2, hero.getKategori());
            stmt.setString(3, hero.getGender());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Hero hero) {
        try {
            Connection conn = DatabaseUtil.getConnection();
            String sql = "UPDATE tm_hero SET nama_hero=?, kategori=?, gender=? WHERE id_hero=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, hero.getNama());
            stmt.setString(2, hero.getKategori());
            stmt.setString(3, hero.getGender());
            stmt.setInt(4, hero.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = DatabaseUtil.getConnection();
            String sql = "DELETE FROM tm_hero WHERE id_hero=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Hero getById(int id) {
        Hero hero = null;
        try {
            Connection conn = DatabaseUtil.getConnection();
            String sql = "SELECT * FROM tm_hero WHERE id_hero=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                hero = new Hero(
                        rs.getInt("id_hero"),
                        rs.getString("nama_hero"),
                        rs.getString("kategori"),
                        rs.getString("gender")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hero;
    }
}