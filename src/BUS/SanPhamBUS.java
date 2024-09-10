package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Bao Phan
 */
public class SanPhamBUS {

    public final SanPhamDAO spDAO = new SanPhamDAO();

    private ArrayList<SanPhamDTO> listSP = new ArrayList<>();

    public SanPhamBUS() {
        listSP = spDAO.selectAll();
    }

    public ArrayList<SanPhamDTO> getAll() {

        return this.listSP;
    }

    public SanPhamDTO getByIndex(int index) {
        return this.listSP.get(index);
    }

    public SanPhamDTO getByMaSP(int masp) {
        int vitri = -1;
        int i = 0;
        while (i <= this.listSP.size() && vitri == -1) {
            if (this.listSP.get(i).getMasp() == masp) {
                vitri = i;
            } else {
                i++;
            }
        }
        return this.listSP.get(vitri);
    }

    public int getIndexByMaSP(int masanpham) {
        int i = 0;
        int vitri = -1;
        while (i < this.listSP.size() && vitri == -1) {
            if (listSP.get(i).getMasp() == masanpham) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public Boolean add(SanPhamDTO sp) {
        boolean check = spDAO.insert(sp) != 0;
        if (check) {
            this.listSP.add(sp);
        }
        return check;
    }

    public Boolean delete(SanPhamDTO sp) {
        boolean check = spDAO.delete(sp) != 0;
        if (check) {
            this.listSP.remove(sp);
        }
        return check;
    }

    public Boolean update(SanPhamDTO sp) {
        boolean check = spDAO.update(sp) != 0;
        if (check) {
            this.listSP.set(getIndexByMaSP(sp.getMasp()), sp);
        }
        return check;
    }
    
    public Boolean updateSoLuongTon(SanPhamDTO sp) {
        boolean check = spDAO.updateSoLuongTon(sp) != 0;
        if (check) {
            return true;
        }
        return false;
    }

    public ArrayList<SanPhamDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        for (SanPhamDTO i : this.listSP) {
            if (Integer.toString(i.getMasp()).toLowerCase().contains(text) || i.getTensp().toLowerCase().contains(text)) {
                result.add(i);
            }
        }
        return result;
    }

    public int getQuantity() {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        int n = 0;
        for (SanPhamDTO i : this.listSP) {
            if (i.getSoluongton() != 0) {
                n += i.getSoluongton();
            }
        }
        return n;
    }

    public boolean updateQuantity(int masp, int soluong) {
        SanPhamDTO sp = getByMaSP(masp);
        if (sp != null) {
            // Cập nhật số lượng tồn mới bằng cách cộng thêm vào số lượng hiện tại
            int newQuantity = sp.getSoluongton() + soluong;
            sp.setSoluongton(newQuantity);

            // Gọi phương thức update của SanPhamDAO để cập nhật thông tin sản phẩm vào cơ sở dữ liệu
            int updateSuccess = spDAO.updateQuantity(sp);
            return true;
        }
        return false; // Trả về false nếu không tìm thấy sản phẩm
    }
}
