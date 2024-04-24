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
@Table(name = "TaiKhoan")
@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaiKhoan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userID;

    @Column(name = "userName")
    private String userName;

    @Column(name = "passWord")
    private String passWord;

    @Column(name = "capDoQuyen")
    private int capDoQuyen;

    @Column(name = "modifyDate")
    private LocalDateTime modifyDate;

    @OneToOne(mappedBy = "taiKhoan", cascade = CascadeType.ALL)
    private NhanVien nhanVien;

    public TaiKhoan(String text, String text1, Integer selectedItem) {
    }
}
