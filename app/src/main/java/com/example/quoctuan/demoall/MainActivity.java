package com.example.quoctuan.demoall;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quoctuan.demoall.model.DanhSachKachHang;
import com.example.quoctuan.demoall.model.KhachHang;

public class MainActivity extends AppCompatActivity {

    EditText txtTen,txtSach,txtTongKH,txtTongKHVip,txtDoanhThu;

    TextView txtTT;

    CheckBox chkVip;

    Button btnTinhTT,btnTiep,btnThongKe;

    ImageButton btnExit;

    DanhSachKachHang danhSachKachHang=new DanhSachKachHang();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

        btnTinhTT.setOnClickListener(new proocessMyEvents());
        btnThongKe.setOnClickListener(new proocessMyEvents());
        btnTiep.setOnClickListener(new proocessMyEvents());
        btnExit.setOnClickListener(new proocessMyEvents());

    }


    private void doExit() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Bạn Muốn Thoát Chương Trình");
        builder.setMessage("Bạn có chắc muốn thoát chương trình ?");
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.create().show();
    }

    private void doThongKe() {

        txtTongKH.setText(danhSachKachHang.tongKH()+"");
        txtTongKHVip.setText(danhSachKachHang.tongKHVip()+"");
        txtDoanhThu.setText(danhSachKachHang.tongDoanhThu()+"");


    }

    private void doTiep() {

        txtTen.setText("");
        txtSach.setText("");
        txtTT.setText("");
        txtTen.requestFocus();

    }

    private void doTinhTien() {

        KhachHang kh=new KhachHang();
        kh.setTen(txtTen.getText()+"");
        kh.setSoLuong(Integer.parseInt(txtSach.getText()+""));
        kh.setVip(chkVip.isChecked());
        txtTT.setText(kh.tinhThanhTien()+"");
        danhSachKachHang.addKH(kh);
        
    }
    private class proocessMyEvents implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnTinhTT:
                    doTinhTien();
                    break;
                case R.id.btnTiep:
                    doTiep();
                    break;
                case R.id.btnThongKe:
                    doThongKe();
                    break;
                case R.id.btnExit:
                    doExit();
                    break;
            }

        }
    }

    private void addControls() {

        txtTen= (EditText) findViewById(R.id.txtTen);
        txtDoanhThu= (EditText) findViewById(R.id.txtDoanhThu);
        txtSach= (EditText) findViewById(R.id.txtSach);
        txtTongKH= (EditText) findViewById(R.id.txtTongKH);
        txtTongKHVip= (EditText) findViewById(R.id.txtTongKHVip);

        txtTT= (TextView) findViewById(R.id.txtTT);

        chkVip= (CheckBox) findViewById(R.id.chkVip);

        btnTinhTT= (Button) findViewById(R.id.btnTinhTT);
        btnTiep= (Button) findViewById(R.id.btnTiep);
        btnThongKe= (Button) findViewById(R.id.btnThongKe);

        btnExit= (ImageButton) findViewById(R.id.btnExit);



    }
}
