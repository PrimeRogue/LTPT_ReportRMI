package entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Proxy;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "NhanVien")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NhanVien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maNV")
    private int maNV;

    @Column(name = "tenNV")
    private String tenNV;

    @Column(name = "SDT")
    private String SDT;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "CCCD")
    private String CCCD;

    @Column(name = "gioiTinh")
    private boolean gioiTinh;

    @Column(name = "chucVu")
    private String chucVu;

    @Column(name = "ngaySinh")
    private LocalDateTime ngaySinh;

    @Column(name = "Luong")
    private double luong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    private TaiKhoan taiKhoan;

    @Column(name = "modifyDate")
    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public NhanVien(int count, String text, String text1, String text2, String text3, boolean gt, String text4, Date ngaySinh, float v) {
    }
}
