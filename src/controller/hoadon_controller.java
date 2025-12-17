/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import model.HoaDon;
import model.hoa_don_DAO;
/**
 *
 * @author admin
 */
public class hoadon_controller {
    
    private final hoa_don_DAO hd_dao = new hoa_don_DAO();
    public ArrayList<HoaDon> tim_hoadon(String ma_kh)
    {
        return hd_dao.tim_hoadon(ma_kh);
    }
                  
}
