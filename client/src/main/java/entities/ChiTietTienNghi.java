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
@Table(name = "ChiTietTienNghi")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChiTietTienNghi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maChiTietTienNghi")
    private int maChiTietTienNghi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maPhong")
    private Phong phong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTienNghi")
    private TienNghi tienNghi;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "modifyDate")
    private LocalDateTime modifyDate;
}
