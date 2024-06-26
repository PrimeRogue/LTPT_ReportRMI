INSERT INTO TrangThaiPhong (trangThai, modifyDate)
VALUES
    ('Trống', '2024-04-24 12:00:00'), -- Trạng thái "Trống"
    ('Đã đặt', '2024-04-24 12:00:00'), -- Trạng thái "Đã đặt"
    ('Đang sửa chữa', '2024-04-24 12:00:00'), -- Trạng thái "Đang sửa chữa"
    ('Đang dọn dẹp', '2024-04-24 12:00:00'), -- Trạng thái "Đang dọn dẹp"
    ('Có khách', '2024-04-24 12:00:00'); -- Trạng thái "Có khách"

-- Script chèn dữ liệu vào bảng TinhTrangPhong
INSERT INTO TinhTrangPhong (tinhTrang, modifyDate)
VALUES
    ('Sạch', '2024-04-24 12:00:00'), -- Tình trạng "Sạch"
    ('Bẩn', '2024-04-24 12:00:00'), -- Tình trạng "Bẩn"
    ('Hỏng', '2024-04-24 12:00:00'), -- Tình trạng "Hỏng"
    ('Đang sửa chữa', '2024-04-24 12:00:00'), -- Tình trạng "Đang sửa chữa"
    ('Cần dọn dẹp', '2024-04-24 12:00:00'); -- Tình trạng "Cần dọn dẹp"

-- Script chèn dữ liệu vào bảng LoaiPhong
INSERT INTO LoaiPhong (tenLoaiPhong, soGuong, giaNgay, modifyDate)
VALUES
    ('Phòng đơn', 1, 100, '2024-04-24 12:00:00'), -- Loại phòng "Phòng đơn" có 1 giường, giá 100/ngày
    ('Phòng đôi', 2, 150, '2024-04-24 12:00:00'), -- Loại phòng "Phòng đôi" có 2 giường, giá 150/ngày
    ('Phòng VIP', 1, 200, '2024-04-24 12:00:00'), -- Loại phòng "Phòng VIP" có 1 giường, giá 200/ngày
    ('Phòng gia đình', 3, 250, '2024-04-24 12:00:00'), -- Loại phòng "Phòng gia đình" có 3 giường, giá 250/ngày
    ('Suite', 2, 300, '2024-04-24 12:00:00'); -- Loại phòng "Suite" có 2 giường, giá 300/ngày

-- Script chèn dữ liệu vào bảng Phong
INSERT INTO Phong (soPhong, maTrangThaiPhong, maTinhTrangPhong, maLoaiPhong, modifyDate)
VALUES
    ('101', 1, 1, 1, '2024-04-24 12:00:00'), -- Phòng có số phòng là 101, trạng thái phòng là 1, tình trạng phòng là 1, loại phòng là 1 và ngày chỉnh sửa là '2024-04-24 12:00:00'
    ('102', 2, 1, 2, '2024-04-24 12:00:00'), -- Phòng có số phòng là 102, trạng thái phòng là 2, tình trạng phòng là 1, loại phòng là 2 và ngày chỉnh sửa là '2024-04-24 12:00:00'
    ('103', 1, 2, 1, '2024-04-24 12:00:00'), -- Phòng có số phòng là 103, trạng thái phòng là 1, tình trạng phòng là 2, loại phòng là 1 và ngày chỉnh sửa là '2024-04-24 12:00:00'
    ('104', 3, 3, 3, '2024-04-24 12:00:00'), -- Phòng có số phòng là 104, trạng thái phòng là 3, tình trạng phòng là 3, loại phòng là 3 và ngày chỉnh sửa là '2024-04-24 12:00:00'
    ('105', 1, 2, 2, '2024-04-24 12:00:00'); -- Phòng có số phòng là 105, trạng thái phòng là 1, tình trạng phòng là 2, loại phòng là 2 và ngày chỉnh sửa là '2024-04-24 12:00:00'

-- Insert data into KhachHang table
INSERT INTO KhachHang (tenKH, SDT, CCCD, diaChi, gioiTinh, quocGia, modifyDate)
VALUES
    ('John Doe', '123456789', 'CCCD123', '123 Street, City', 1, 'USA', '2024-04-24 12:00:00'),
    ('Jane Smith', '987654321', 'CCCD456', '456 Avenue, Town', 0, 'Canada', '2024-04-24 12:00:00'),
    ('Alice Johnson', '111222333', 'CCCD789', '789 Road, Village', 0, 'UK', '2024-04-24 12:00:00'),
    ('Bob Brown', '444555666', 'CCCD012', '012 Lane, Hamlet', 1, 'Australia', '2024-04-24 12:00:00'),
    ('Emily Davis', '777888999', 'CCCD345', '345 Boulevard, City', 0, 'Germany', '2024-04-24 12:00:00');

-- Insert data into NhanVien table
INSERT INTO NhanVien (tenNV, SDT, diaChi, CCCD, gioiTinh, chucVu, ngaySinh, luong, modifyDate)
VALUES
    ('John Doe', '123456789', '123 Street, City', 'CCCD123', 1, 'Quản lý', '1990-01-15 00:00:00', 2000.0, '2024-04-24 12:00:00'),
    ('Jane Smith', '987654321', '456 Avenue, Town', 'CCCD456', 0, 'Nhân viên lễ tân', '1992-03-20 00:00:00', 1500.0, '2024-04-24 12:00:00'),
    ('Alice Johnson', '111222333', '789 Road, Village', 'CCCD789', 0, 'Nhân viên phục vụ', '1988-07-10 00:00:00', 1800.0, '2024-04-24 12:00:00'),
    ('Bob Brown', '444555666', '012 Lane, Hamlet', 'CCCD012', 1, 'Kế toán', '1995-05-25 00:00:00', 2200.0, '2024-04-24 12:00:00'),
    ('Emily Davis', '777888999', '345 Boulevard, City', 'CCCD345', 0, 'Bảo vệ', '1993-11-30 00:00:00', 1700.0, '2024-04-24 12:00:00');
