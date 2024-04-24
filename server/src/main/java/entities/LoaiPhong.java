package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "LoaiPhong")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoaiPhong implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maLoaiPhong")
	private int maLoaiPhong;

	@Column(name = "tenLoaiPhong")
	private String tenLoaiPhong;

	@Column(name = "soGuong")
	private int soGuong;

	@Column(name = "giaNgay")
	private double giaNgay;

	@Column(name = "modifyDate")
	private LocalDateTime modifyDate;

	@OneToMany(mappedBy = "loaiPhong", cascade = CascadeType.ALL)
	private List<Phong> phongs;

	public LoaiPhong(String selectedItem) {
	}

    public LoaiPhong(String text, int i, float v) {
    }

	public LoaiPhong(int i, String text, int i1, float v) {
	}
}
