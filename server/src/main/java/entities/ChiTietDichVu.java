package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;

@Entity
@Table(name = "ChiTietDichVu")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDichVu implements Serializable {
    @Id
    @Column(name = "maDichVu")
    private int maDichVu;

    @Id
    @Column(name = "maPhong")
    private int maPhong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDichVu")
    private DichVu dichVu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maPhong")
    private Phong phong;

    @Column(name = "soLuong")
    private int soLuong;
}
