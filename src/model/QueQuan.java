package model;

import java.io.Serializable;
import java.util.ArrayList;

public class QueQuan implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String tenTinh;

	public QueQuan(int i, String tenTinh) {
		this.tenTinh = tenTinh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	@Override
	public String toString() {
		return "" + tenTinh;
	}
	
	public static ArrayList<QueQuan> getDSTinh(){
		
		String[] arr_tinh = {"An Giang",
							"Bà Rịa – Vũng Tàu",
							"Bạc Liêu",
							"Bắc Giang",
							"Bắc Kạn",
							"Bắc Ninh",
							"Bến Tre",
							"Bình Dương",
							"Bình Định",
							"Bình Phước",
							"Bình Thuận",
							"Cà Mau",
							"Cao Bằng",
							"Cần Thơ",
							"Đà Nẵng",
							"Đắk Lắk",
							"Đắk Nông",
							"Điện Biên",
							"Đồng Nai",
							"Đồng Tháp",
							"Gia Lai",
							"Hà Giang",
							"Hà Nam",
							"Hà Nội",
							"Hà Tĩnh",
							"Hải Dương",
							"Hải Phòng",
							"Hậu Giang",
							"Hòa Bình",
							"Thành phố Hồ Chí Minh",
							"Hưng Yên",
							"Khánh Hòa",
							"Kiên Giang",
							"Kon Tum",
							"Lai Châu",
							"Lạng Sơn",
							"Lào Cai",
							"Lâm Đồng",
							"Long An",
							"Nam Định",
							"Nghệ An",
							"Ninh Bình",
							"Ninh Thuận",
							"Phú Thọ",
							"Phú Yên",
							"Quảng Bình",
							"Quảng Nam",
							"Quảng Ngãi",
							"Quảng Ninh",
							"Quảng Trị",
							"Sóc Trăng",
							"Sơn La",
							"Tây Ninh",
							"Thái Bình",
							"Thái Nguyên",
							"Thanh Hóa",
							"Thừa Thiên Huế",
							"Tiền Giang",
							"Trà Vinh",
							"Tuyên Quang",
							"Vĩnh Long",
							"Vĩnh Phúc",
							"Yên Bái"};
		
		ArrayList<QueQuan> listTinh = new ArrayList<QueQuan>();
		int i = 0;
		for (String tenTinh : arr_tinh) {
			QueQuan q = new QueQuan(i, tenTinh);
			listTinh.add(q);
		}
		return listTinh;
	}

	public static QueQuan getTinhById(int queQuan) {
		return QueQuan.getDSTinh().get(queQuan);
	}

	public static QueQuan getTinhByTen(String tenTinh) {
		ArrayList<QueQuan> listTinh = QueQuan.getDSTinh();
		for (QueQuan tinh : listTinh) {
			if(tinh.tenTinh.equals(tenTinh))
				return tinh;
		}
		return null;
	}
	
}
