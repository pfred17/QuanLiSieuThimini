/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import BUS.SanPhamBUS;
import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Bao Phan
 */
public class SearchSanPham {

    SanPhamBUS spbus = new SanPhamBUS();

    public static SearchSanPham getInstance() {
        return new SearchSanPham();
    }

    public ArrayList<SanPhamDTO> searchTatCa(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        ArrayList<SanPhamDTO> armt = SanPhamDAO.getInstance().selectAll();
        for (var sp : armt) {
            if (("" + sp.getMasp()).toLowerCase().contains(text.toLowerCase())
                    || sp.getTensp().toLowerCase().contains(text.toLowerCase())
                    || ("" + sp.getMaloai()).toLowerCase().contains(text.toLowerCase())
                    || ("" + sp.getNSX()).toLowerCase().contains(text.toLowerCase())
                    || ("" + sp.getHSD()).toLowerCase().contains(text.toLowerCase())
                    || ("" + sp.getThuonghieu()).toLowerCase().contains(text.toLowerCase())
                    || ("" + sp.getXuatxu()).toLowerCase().contains(text.toLowerCase())
                    || ("" + sp.getSoluongton()).toLowerCase().contains(text.toLowerCase())
                    || ("" + sp.getGia()).toLowerCase().contains(text.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

    public ArrayList<SanPhamDTO> searchTenSP(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        ArrayList<SanPhamDTO> armt = SanPhamDAO.getInstance().selectAll();
        for (var sp : armt) {
            if (sp.getTensp().toLowerCase().contains(text.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

    public ArrayList<SanPhamDTO> searchMaSP(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        ArrayList<SanPhamDTO> armt = SanPhamDAO.getInstance().selectAll();
        for (var sp : armt) {
            if (("" + sp.getMasp()).toLowerCase().contains(text.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

    public ArrayList<SanPhamDTO> searchMaLoai(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        ArrayList<SanPhamDTO> armt = SanPhamDAO.getInstance().selectAll();
        for (var sp : armt) {
            if (("" + sp.getLoaisp().getTenloai()).toLowerCase().contains(text.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

    public ArrayList<SanPhamDTO> searchXuatxu(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        ArrayList<SanPhamDTO> armt = SanPhamDAO.getInstance().selectAll();
        for (var sp : armt) {
            if (("" + sp.getXuatxu().getTenxuatxu()).toLowerCase().contains(text.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

    public ArrayList<SanPhamDTO> searchThuongHieu(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        ArrayList<SanPhamDTO> armt = SanPhamDAO.getInstance().selectAll();
        for (var sp : armt) {
            if (("" + sp.getThuonghieu().getTenthuonghieu()).toLowerCase().contains(text.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

    public ArrayList<SanPhamDTO> searchNSX(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        ArrayList<SanPhamDTO> armt = SanPhamDAO.getInstance().selectAll();
        for (var sp : armt) {
            if (("" + sp.getNSX()).toLowerCase().contains(text.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

    public ArrayList<SanPhamDTO> searchHSD(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        ArrayList<SanPhamDTO> armt = SanPhamDAO.getInstance().selectAll();
        for (var sp : armt) {
            if (("" + sp.getHSD()).toLowerCase().contains(text.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

    public ArrayList<SanPhamDTO> searchSoluongton(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        ArrayList<SanPhamDTO> armt = SanPhamDAO.getInstance().selectAll();
        for (var sp : armt) {
            if (("" + sp.getSoluongton()).toLowerCase().contains(text.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }
    public ArrayList<SanPhamDTO> searchGia(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        ArrayList<SanPhamDTO> armt = SanPhamDAO.getInstance().selectAll();
        for (var sp : armt) {
            if (("" + sp.getGia()).toLowerCase().contains(text.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }
}
