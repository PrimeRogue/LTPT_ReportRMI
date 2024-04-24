package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Phong")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phong implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maPhong")
	private int maPhong;

	@Column(name = "soPhong")
	private String soPhong;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maTrangThaiPhong")
	private TrangThaiPhong trangThaiPhong;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maTinhTrangPhong")
	private TinhTrangPhong tinhTrangPhong;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maLoaiPhong")
	private LoaiPhong loaiPhong;

	@Column(name = "modifyDate")
	private LocalDateTime modifyDate;

	@OneToMany(mappedBy = "phong", cascade = CascadeType.ALL)
	private List<ChiTietDichVu> chiTietDichVus;

	@OneToMany(mappedBy = "phong", cascade = CascadeType.ALL)
	private List<ChiTietTienNghi> chiTietTienNghis;

	@OneToMany(mappedBy = "phong", cascade = CascadeType.ALL)
	private List<Phong_Booked> phongBookeds;

	@OneToMany(mappedBy = "phong", cascade = CascadeType.ALL)
	private List<HoaDon> hoaDons;

    public Phong(String text, TinhTrangPhong ttp, LoaiPhong lp) {
    }

    public Phong(int i, String text, TinhTrangPhong ttp, LoaiPhong lp) {
    }

    @Override
	public String toString() {
		return "Phong{" +
				"maPhong=" + maPhong +
				", soPhong='" + soPhong + '\'' +
				'}';
	}

}
