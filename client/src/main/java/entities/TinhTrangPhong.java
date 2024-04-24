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
@Table(name = "TinhTrangPhong")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TinhTrangPhong implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maTinhTrangPhong")
	private int maTinhTrangPhong;

	@Column(name = "tinhTrang")
	private String tinhTrang;

	@Column(name = "modifyDate")
	private LocalDateTime modifyDate;

	@OneToMany(mappedBy = "tinhTrangPhong", cascade = CascadeType.ALL)
	private List<Phong> phongs;

    public TinhTrangPhong(String selectedItem) {
    }

    @Override
	public String toString() {
		return "TinhTrangPhong{" +
				"maTinhTrangPhong=" + maTinhTrangPhong +
				", tinhTrang='" + tinhTrang + '\'' +
				", modifyDate=" + modifyDate +
				", phongs=" + phongs +
				", " + super.toString() +
				'}';
	}

}
