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
@Table(name = "DichVu")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DichVu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDichVu")
    private int maDichVu;

    @Column(name = "tenDichVu")
    private String tenDichVu;

    @Column(name = "donGia")
    private double donGia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maLoaiDichVu")
    private LoaiDichVu loaiDichVu;

    @Column(name = "modifyDate")
    private LocalDateTime modifyDate;
}
