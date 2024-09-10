/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Bao Phan
 */
public class GiamGiaDTO {

    private int magiamgia;
    private String tenctgiamgia;
    private int mocgiamgia;
    private int sotienduocgiam;

    public GiamGiaDTO() {
    }

    public GiamGiaDTO(int magiamgia, String tenctgiamgia, int mocgiamgia, int sotienduocgiam) {
        this.magiamgia = magiamgia;
        this.tenctgiamgia = tenctgiamgia;
        this.mocgiamgia = mocgiamgia;
        this.sotienduocgiam = sotienduocgiam;
    }

    public int getMagiamgia() {
        return magiamgia;
    }

    public void setMagiamgia(int magiamgia) {
        this.magiamgia = magiamgia;
    }

    public String getTenctgiamgia() {
        return tenctgiamgia;
    }

    public void setTenctgiamgia(String tenctgiamgia) {
        this.tenctgiamgia = tenctgiamgia;
    }

    public int getMocgiamgia() {
        return mocgiamgia;
    }

    public void setMocgiamgia(int mocgiamgia) {
        this.mocgiamgia = mocgiamgia;
    }

    public int getSotienduocgiam() {
        return sotienduocgiam;
    }

    public void setSotienduocgiam(int sotienduocgiam) {
        this.sotienduocgiam = sotienduocgiam;
    }

}
