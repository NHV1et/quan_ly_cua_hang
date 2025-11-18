/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo_sung_cac_view;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author admin
 */
public class SaleTableModel extends AbstractTableModel {
    private final String[] cols = {"Chọn","STT","Mã SP","Tên SP","Đơn giá","Số lượng","Tồn","Khuyến mãi","Khấu trừ","Thành tiền"};
    private final Class[] types = {Boolean.class,Integer.class,String.class,String.class,Double.class,Integer.class,Integer.class,String.class,Double.class,Double.class};
    private final List<SaleRow> rows = new ArrayList<>();

    public void addBlankRow() {
        rows.add(new SaleRow(false, rows.size()+1,"","","",1,0,"",0.0,0.0));
        fireTableDataChanged();
    }

    public void addProduct(String code, String name, double price, int stock, String promo) {
        rows.add(new SaleRow(false, rows.size()+1, code, name, promo, 1, stock, "", price, 0.0));
        fireTableDataChanged();
    }

    public List<SaleRow> getRows() { return rows; }

    @Override public int getRowCount() { return rows.size(); }
    @Override public int getColumnCount() { return cols.length; }
    @Override public String getColumnName(int col) { return cols[col]; }
    @Override public Class<?> getColumnClass(int col) { return types[col]; }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 0 || col == 2 || col == 5; // checkbox, mã SP (editable for lookup), số lượng
    }

    @Override
    public Object getValueAt(int r, int c) {
        SaleRow row = rows.get(r);
        switch(c) {
            case 0: return row.selected;
            case 1: return row.stt;
            case 2: return row.code;
            case 3: return row.name;
            case 4: return row.unitPrice;
            case 5: return row.quantity;
            case 6: return row.stock;
            case 7: return row.promo;
            case 8: return row.discount;
            case 9: return row.total;
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int r, int c) {
        SaleRow row = rows.get(r);
        if (c == 0) {
            row.selected = Boolean.TRUE.equals(value);
        } else if (c == 2) { // mã SP nhập trên table -> caller (view) nên gọi controller.findProductByCode và fill giá trị
            row.code = value == null ? "" : value.toString();
        } else if (c == 5) {
            int qty = 1;
            try {
                qty = (value instanceof Number) ? ((Number)value).intValue() : Integer.parseInt(value.toString());
            } catch (Exception ex) { qty = row.quantity; }
            row.quantity = Math.max(0, qty);
        }
        // recalc total
        if (row.selected) {
            row.total = row.unitPrice * row.quantity - row.discount;
        } else {
            row.total = 0.0;
        }
        fireTableRowsUpdated(r, r);
    }

    public static class SaleRow {
        public boolean selected;
        public int stt;
        public String code;
        public String name;
        public double unitPrice;
        public int quantity;
        public int stock;
        public String promo;
        public double discount;
        public double total;
        public SaleRow(boolean sel, int stt, String code, String name, String promo, int qty, int stock, String string3, double price, double disc){
            this.selected=sel;this.stt=stt;this.code=code;this.name=name;this.unitPrice=price;this.quantity=qty;this.stock=stock;this.promo=promo;this.discount=disc;this.total=total;
        }
    }
}