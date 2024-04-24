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
@Table(name = "TrangThaiPhong")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrangThaiPhong implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maTrangThaiPhong")
	private int maTrangThaiPhong;

	@Column(name = "trangThai")
	private String trangThai;

	@Column(name = "modifyDate")
	private LocalDateTime modifyDate;

	@OneToMany(mappedBy = "trangThaiPhong", cascade = CascadeType.ALL)
	private List<Phong> phongs;

	@Override
	public String toString() {
		return "TrangThaiPhong{" +
				"maTrangThaiPhong=" + maTrangThaiPhong +
				", trangThai='" + trangThai + '\'' +
				", modifyDate=" + modifyDate +
				", phongs=" + phongs +
				", " + super.toString() +
				'}';
	}

}
