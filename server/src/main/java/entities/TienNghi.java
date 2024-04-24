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
@Table(name = "TienNghi")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TienNghi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maTienNghi")
    private int maTienNghi;

    @Column(name = "tenTienNghi")
    private String tenTienNghi;

    @Column(name = "modifyDate")
    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "tienNghi", cascade = CascadeType.ALL)
    private List<ChiTietTienNghi> chiTietTienNghis;
}
