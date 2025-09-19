package iuh.fit.se.dao;

import iuh.fit.se.model.TinTuc;
import iuh.fit.se.util.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TinTucDAO {
    public List<TinTuc> getAllTinTuc() {
        List<TinTuc> list = new ArrayList<>();
        String sql = "SELECT * FROM TinTuc";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TinTuc t = new TinTuc(
                        rs.getInt("MaTT"),
                        rs.getString("TieuDe"),
                        rs.getString("NoiDungTT"),
                        rs.getString("LienKet"),
                        rs.getInt("MaDM")
                );
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertTinTuc(TinTuc t) {
        String sql = "INSERT INTO TinTuc (TieuDe, NoiDungTT, LienKet, MaDM) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getTieuDe());
            ps.setString(2, t.getNoiDungTT());
            ps.setString(3, t.getLienKet());
            ps.setInt(4, t.getMaDM());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTinTuc(int maTT) {
        String sql = "DELETE FROM TinTuc WHERE MaTT=?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maTT);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
