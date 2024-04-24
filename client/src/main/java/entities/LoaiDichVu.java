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
@Table(name = "LoaiDichVu")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoaiDichVu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLoaiDichVu")
    private int maLoaiDichVu;

    @Column(name = "tenLoaiDichVu")
    private String tenLoaiDichVu;

    @Column(name = "modifyDate")
    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "loaiDichVu", cascade = CascadeType.ALL)
    private List<DichVu> dichVus;
}
