package DAO;

import DTO.LoaiSanPhamDTO;
import DTO.SanPhamDTO;
import DTO.ThuongHieuDTO;
import DTO.XuatXuDTO;
import config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Phan
 */
public class SanPhamDAO implements DAOinterface<SanPhamDTO> {

    public static SanPhamDAO getInstance() {
        return new SanPhamDAO();
    }

    @Override
    public int insert(SanPhamDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "insert into sanpham (masp, maloai, tensp, hinhanh, xuatxu, NSX, HSD, thuonghieu, gia, soluongton, trangthai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMasp()); // Nếu 'masp' là một số nguyên
            pst.setInt(2, t.getMaloai());
            pst.setString(3, t.getTensp());
            pst.setString(4, t.getHinhanh());
            pst.setInt(5, t.getMaxuatxu());
            pst.setString(6, "" + t.getNSX());
            pst.setString(7, "" + t.getHSD());
            pst.setInt(8, t.getMathuonghieu());
            pst.setInt(9, t.getGia());
            pst.setInt(10, t.getSoluongton());
            pst.setInt(11, t.getTrangthai());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thêm được sản phẩm " + t.getMasp(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(SanPhamDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE sanpham SET  maloai=?, tensp=?, hinhanh=?, xuatxu=?,NSX=?,HSD=?,thuonghieu=?,gia=? WHERE masp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaloai());
            pst.setString(2, t.getTensp());
            pst.setString(3, t.getHinhanh());
            pst.setInt(4, t.getMaxuatxu());
            pst.setString(5, "" + t.getNSX());
            pst.setString(6, "" + t.getHSD());
            pst.setInt(7, t.getMathuonghieu());
            pst.setString(8, "" + t.getGia());
            pst.setInt(9, t.getMasp());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    // Hàm cập nhật số lượng sản phẩm khi nhập hàng
    public int updateSoLuongTon(SanPhamDTO sp) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE sanpham SET  soluongton=? WHERE masp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, sp.getSoluongton());
            pst.setInt(2, sp.getMasp());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<SanPhamDTO> selectAll() {
        ArrayList<SanPhamDTO> ketQua = new ArrayList<SanPhamDTO>();
        try (Connection con = JDBC.getConnection(); Statement s = con.createStatement(); ResultSet rs = s.executeQuery("SELECT sanpham.masp, sanpham.maloai, sanpham.tensp, sanpham.hinhanh, sanpham.xuatxu,\n"
                + "       sanpham.NSX, sanpham.HSD, sanpham.thuonghieu, sanpham.gia, sanpham.soluongton, sanpham.trangthai,\n"
                + "       loaisanpham.tenloai, thuonghieu.tenthuonghieu, xuatxu.tenxuatxu, loaisanpham.trangthai, xuatxu.trangthai, thuonghieu.mathuonghieu\n"
                + "FROM sanpham\n"
                + "INNER JOIN loaisanpham ON sanpham.maloai = loaisanpham.maloai\n"
                + "INNER JOIN thuonghieu ON sanpham.thuonghieu = thuonghieu.mathuonghieu\n"
                + "INNER JOIN xuatxu ON sanpham.xuatxu = xuatxu.maxuatxu\n"
                + "WHERE sanpham.trangthai = 1\n"
                + "ORDER BY sanpham.masp;")) {

            while (rs.next()) {
                LoaiSanPhamDTO lsp = new LoaiSanPhamDTO(rs.getInt("maloai"), rs.getString("tenloai"));
                XuatXuDTO xx = new XuatXuDTO(rs.getInt("xuatxu"), rs.getString("tenxuatxu"));
                ThuongHieuDTO th = new ThuongHieuDTO(rs.getInt("thuonghieu"), rs.getString("tenthuonghieu"));

                SanPhamDTO sp = new SanPhamDTO();
                sp.setMasp(rs.getInt("masp"));
//                sp.setMaloai(rs.getInt("maloai"));
                sp.setTensp(rs.getString("tensp"));
                sp.setHinhanh(rs.getString("hinhanh"));
//                sp.setMaxuatxu(rs.getInt("xuatxu"));
                sp.setNSX(rs.getDate("NSX"));
                sp.setHSD(rs.getDate("HSD"));
//                sp.setMathuonghieu(rs.getInt("thuonghieu"));
                sp.setGia(rs.getInt("gia"));
                sp.setSoluongton(rs.getInt("soluongton"));
                sp.setTrangthai(rs.getInt("trangthai"));
                sp.setLoaisp(lsp);
                sp.setThuonghieu(th);
                sp.setXuatxu(xx);

                ketQua.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public SanPhamDTO selectById(String t) {
        SanPhamDTO ketQua = null;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM sanpham WHERE masp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int masp = rs.getInt("masp");
                int maloai = rs.getInt("maloai");
                String tensp = rs.getString("tensp");
                String hinhanh = rs.getString("hinhanh");
                int maxuatxu = rs.getInt("xuatxu");
                Date NSX = rs.getDate("NSX");
                Date HSD = rs.getDate("HSD");
                int mathuonghieu = rs.getInt("thuonghieu");
                int gia = rs.getInt("gia");
                int soluongton = rs.getInt("soluongton");
                int trangthai = rs.getInt("trangthai");
                ketQua = new SanPhamDTO(masp, maloai, tensp, hinhanh, NSX, HSD, maxuatxu, mathuonghieu, gia, soluongton, trangthai);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND TABLE_NAME = 'sanpham'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(SanPhamDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "Update sanpham set `trangthai` = 0 WHERE masp = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, "" + t.getMasp());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateQuantity(SanPhamDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE sanpham SET soluongton = ? WHERE masp = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getSoluongton());
            pst.setInt(2, t.getMasp());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
