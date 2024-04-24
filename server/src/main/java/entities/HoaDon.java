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
@Table(name = "HoaDon")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HoaDon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maHoaDon")
    private int maHoaDon;

    @Column(name = "ngapLap")
    private LocalDateTime ngapLap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKH")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maPhong")
    private Phong phong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;

    @Column(name = "tongTien")
    private double tongTien;
}

