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
@Table(name = "KhachHang")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KhachHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maKH")
    private int maKH;

    @Column(name = "tenKH")
    private String tenKH;

    @Column(name = "SDT")
    private String SDT;

    @Column(name = "CCCD")
    private String CCCD;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "gioiTinh")
    private boolean gioiTinh;

    @Column(name = "quocGia")
    private String quocGia;

    @Column(name = "modifyDate")
    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public KhachHang(String text, boolean gt, String text1, String text2, String text3, String text4) {
    }

    public KhachHang(int i, String text, boolean gt, String text1, String text2, String text3, String text4) {
    }
}
