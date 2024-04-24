package entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Proxy;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Booking")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maBooking")
    private int maBooking;

    @Column(name = "ngayDat")
    private LocalDateTime ngayDat;

    @Column(name = "ngayCheckIn")
    private LocalDateTime ngayCheckIn;

    @Column(name = "ngayCheckOut")
    private LocalDateTime ngayCheckOut;

    @Column(name = "soNguoi")
    private int soNguoi;

    @Column(name = "tongTienDat")
    private double tongTienDat;

    @Column(name = "tongPhongDaDat")
    private int tongPhongDaDat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKH")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;

    @Column(name = "modifyDate")
    private LocalDateTime modifyDate;
}
