package GUI.add;

import BUS.NhaCungCapBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamBUS;
import BUS.KhoHangBUS;
import BUS.NhanVienBUS;
import DTO.ChiTietPhieuNhapDTO;
import DTO.NhaCungCapDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import DTO.KhoHangDTO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class addphieunhap extends javax.swing.JPanel {

    ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
    KhoHangBUS khBUS = new KhoHangBUS();
    SanPhamBUS spBUS = new SanPhamBUS();
    PhieuNhapBUS pnBUS = new PhieuNhapBUS();
    NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    NhanVienBUS nvBUS = new NhanVienBUS();
    int current = 0;

    public addphieunhap() {
        initComponents();
        cbNccDisplay();
        cbkvkDisplay();
        cbnvnhapDisplay();
        txttenncc.setEditable(false);
        txttenkho.setEditable(false);

        list = spBUS.spDAO.selectAll();
        displaytoTable1(list);
        tblphieunhapin.setDefaultEditor(Object.class, null);
        tblphieunhapout.setDefaultEditor(Object.class, null);
        

    }

    public void cbNccDisplay() {
        combonhacc.addItem("Tất cả");
        ArrayList<String> listncc = pnBUS.phieunhapDAO.selectAllMancc();
        int count = listncc.size();
        for (int i = 0; i < count; i++) {
            combonhacc.addItem("" + listncc.get(i));
        }
    }

    public void cbkvkDisplay() {
        combomakhuvuc.addItem("Tất cả");
        ArrayList<String> listncc = pnBUS.phieunhapDAO.selectAllKvkCtpn();
        int count = listncc.size();
        for (int i = 0; i < count; i++) {
            combomakhuvuc.addItem("" + listncc.get(i));
        }
    }
    
    public void cbnvnhapDisplay() {
        String[] listnv = nvBUS.getArrTenNhanVien();
        int count = listnv.length;
        for (int i = 0; i < count; i++) {
            combonvnhap.addItem("" + listnv[i]);
        }
    }

    private void displaytoTable1(ArrayList<SanPhamDTO> list) {
        try {
            DefaultTableModel dt = (DefaultTableModel) tblphieunhapin.getModel();
            dt.setRowCount(0);
            for (SanPhamDTO i : list) {
                dt.addRow(new Object[]{
                    i.getMasp(), i.getTensp(), i.getSoluongton(), i.getGia()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        combonhacc = new javax.swing.JComboBox<>();
        txttenncc = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblphieunhapin = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        btnthemsp = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnnhaphang = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblphieunhapout = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTongcong = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combomakhuvuc = new javax.swing.JComboBox<>();
        txttenkho = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        combonvnhap = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Mã nhà cung cấp");

        jLabel12.setText("Tên nhà cung cấp");

        combonhacc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combonhaccItemStateChanged(evt);
            }
        });

        tblphieunhapin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Giá"
            }
        ));
        jScrollPane3.setViewportView(tblphieunhapin);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Số lượng");

        txtsoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoluongActionPerformed(evt);
            }
        });

        btnthemsp.setBackground(new java.awt.Color(102, 204, 0));
        btnthemsp.setForeground(new java.awt.Color(255, 255, 255));
        btnthemsp.setText("Thêm sản phẩm");
        btnthemsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(combonhacc, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(117, 117, 117))
                                    .addComponent(txttenncc)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)
                        .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combonhacc, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txttenncc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Nhân viên nhập");

        jLabel10.setText("Mã khu vực kho");

        btnnhaphang.setBackground(new java.awt.Color(102, 204, 0));
        btnnhaphang.setForeground(new java.awt.Color(255, 255, 255));
        btnnhaphang.setText("Nhập hàng");
        btnnhaphang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhaphangActionPerformed(evt);
            }
        });

        tblphieunhapout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Giá"
            }
        ));
        jScrollPane2.setViewportView(tblphieunhapout);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tổng cộng:");

        lblTongcong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("đ");

        combomakhuvuc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combomakhuvucItemStateChanged(evt);
            }
        });

        jLabel13.setText("Tên khu vực kho");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(combonvnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txttenkho, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnnhaphang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTongcong, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(combomakhuvuc, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combonvnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txttenkho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combomakhuvuc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTongcong, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(btnnhaphang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtsoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsoluongActionPerformed

    private void updateTotal() {
        DefaultTableModel model = (DefaultTableModel) tblphieunhapout.getModel();
        int rowCount = model.getRowCount();

        int totalQuantity = 0;
        int totalPrice = 0;

        for (int i = 0; i < rowCount; i++) {
            int quantity = (int) model.getValueAt(i, 2);
            int price = (int) model.getValueAt(i, 3);
            totalQuantity += quantity;
            totalPrice += quantity * price;
        }

        // Cập nhật giá trị tổng cộng vào trường văn bản
        lblTongcong.setText(String.valueOf(totalPrice));
    }

    private void btnthemspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemspActionPerformed
        // Lấy dòng được chọn từ bảng 1
        int selectedRow = tblphieunhapin.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm từ bảng 1.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy số lượng nhập
        int soluong;
        try {
            soluong = Integer.parseInt(txtsoluong.getText().trim());
            if (soluong <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy dữ liệu sản phẩm từ dòng được chọn
        Object[] rowData = new Object[4];
        for (int i = 0; i < 4; i++) {
            rowData[i] = tblphieunhapin.getValueAt(selectedRow, i);
        }

        // Thêm thông tin sản phẩm vào bảng 2
        DefaultTableModel dt2 = (DefaultTableModel) tblphieunhapout.getModel();
        rowData[2] = soluong; // Cập nhật số lượng
        dt2.addRow(rowData);

        // Cập nhật tổng cộng và các tính toán khác nếu cần
        updateTotal();

        // Xóa số lượng đã nhập
        txtsoluong.setText("");
    }//GEN-LAST:event_btnthemspActionPerformed

    private void btnnhaphangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhaphangActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tblphieunhapout.getModel();
            ArrayList<NhanVienDTO> listnv = nvBUS.getAll();
            int rowCount = model.getRowCount();

            int mapn = pnBUS.phieunhapDAO.getAutoIncrement();
            int mancc = Integer.parseInt("" + combonhacc.getSelectedItem());
            int manv = 1;
            String tennv = "" + combonvnhap.getSelectedItem();
            for (NhanVienDTO i : listnv) {
                if (tennv.equalsIgnoreCase(i.getHoten())) {
                    manv = i.getManv();
                    break;
                }
            }
            int makhuvuc = Integer.parseInt("" + combomakhuvuc.getSelectedItem());
            Date thoigian = new Date(System.currentTimeMillis());
            java.sql.Date sqlDate = new java.sql.Date(thoigian.getTime());
            long tongtien = 0;

            PhieuNhapDTO pnAll = new PhieuNhapDTO(mapn, mancc, makhuvuc, manv, sqlDate, tongtien);
            pnBUS.phieunhapDAO.insert(pnAll);
            // Lặp qua các dòng trong bảng 2 (tblphieunhapout)
            for (int i = 0; i < rowCount; i++) {
                // Lấy mã sản phẩm và số lượng từ bảng 2
                int masp = (int) model.getValueAt(i, 0);
                int soluong = (int) model.getValueAt(i, 2);
                int dongia = (int) model.getValueAt(i, 3);
                tongtien += soluong * dongia;

                SanPhamDTO sp = spBUS.getByMaSP(masp);
                sp.setSoluongton(sp.getSoluongton() + soluong);
                sp.setMasp(masp);
                spBUS.updateSoLuongTon(sp);
                
                ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(mapn, masp, soluong, dongia);
                pnBUS.ctPhieuNhapDAO.insert(ctpn);
            }

            pnAll = new PhieuNhapDTO(mapn, mancc, makhuvuc, manv, sqlDate, tongtien);
            pnBUS.phieunhapDAO.update(pnAll);
            // Reset bảng 2 (tblphieunhapout)
            model.setRowCount(0);

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Nhập hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật không thành công.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnnhaphangActionPerformed

    private void combonhaccItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combonhaccItemStateChanged
        // TODO add your handling code here:
        ArrayList<NhaCungCapDTO> listncc = nccBUS.nccDAO.selectAll();
        for (NhaCungCapDTO i : listncc) {
            if (("" + i.getMancc()).equalsIgnoreCase((String) combonhacc.getSelectedItem())) {
                txttenncc.setText("" + i.getTenncc());
            }
        }
    }//GEN-LAST:event_combonhaccItemStateChanged

    private void combomakhuvucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combomakhuvucItemStateChanged
        // TODO add your handling code here:
        ArrayList<KhoHangDTO> listkh = khBUS.kvkDAO.selectAll();
        for (KhoHangDTO i : listkh) {
            if (("" + i.getMakhuvuc()).equalsIgnoreCase((String) combomakhuvuc.getSelectedItem())) {
                txttenkho.setText("" + i.getTenkhuvuc());
            }
        }
    }//GEN-LAST:event_combomakhuvucItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnnhaphang;
    private javax.swing.JButton btnthemsp;
    private javax.swing.JComboBox<String> combomakhuvuc;
    private javax.swing.JComboBox<String> combonhacc;
    private javax.swing.JComboBox<String> combonvnhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTongcong;
    private javax.swing.JTable tblphieunhapin;
    private javax.swing.JTable tblphieunhapout;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttenkho;
    private javax.swing.JTextField txttenncc;
    // End of variables declaration//GEN-END:variables
}
