-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 24, 2022 lúc 11:12 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qldiem`
--
CREATE DATABASE IF NOT EXISTS `qldiem` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `qldiem`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ketqua`
--

CREATE TABLE `ketqua` (
  `MASV` varchar(50) DEFAULT NULL,
  `MAMH` varchar(50) DEFAULT NULL,
  `DIEMTHI` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ketqua`
--

INSERT INTO `ketqua` (`MASV`, `MAMH`, `DIEMTHI`) VALUES
('msv1', 'mmh2', 9),
('msv1', 'mmh2', 10),
('msv1', 'mmh1', 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoa`
--

CREATE TABLE `khoa` (
  `MAK` varchar(50) NOT NULL,
  `TENK` varchar(50) NOT NULL,
  `SDT` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khoa`
--

INSERT INTO `khoa` (`MAK`, `TENK`, `SDT`) VALUES
('mk1', 'Quản lý', '012342784'),
('mk2', 'Vệ Sinh', '0324378974'),
('mk3', 'Tài Chính', '02423784689');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lop`
--

CREATE TABLE `lop` (
  `MALOP` varchar(50) NOT NULL,
  `TENLOP` varchar(50) NOT NULL,
  `MAK` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `lop`
--

INSERT INTO `lop` (`MALOP`, `TENLOP`, `MAK`) VALUES
('ml1', 'Lớp 1', 'mk1'),
('ml2', 'Lớp 2', 'mk2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monhoc`
--

CREATE TABLE `monhoc` (
  `MAMH` varchar(50) NOT NULL,
  `TENMH` varchar(50) NOT NULL,
  `SOTINCHI` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `monhoc`
--

INSERT INTO `monhoc` (`MAMH`, `TENMH`, `SOTINCHI`) VALUES
('mmh1', 'Toán', 4),
('mmh2', 'Văn ', 9),
('mmh3', 'Anh', 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `MASV` varchar(50) NOT NULL,
  `TENSV` varchar(50) DEFAULT NULL,
  `GIOITINH` int(11) DEFAULT NULL,
  `NGAYSINH` varchar(50) DEFAULT NULL,
  `QUEQUAN` varchar(50) DEFAULT NULL,
  `SDT` varchar(50) DEFAULT NULL,
  `MALOP` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`MASV`, `TENSV`, `GIOITINH`, `NGAYSINH`, `QUEQUAN`, `SDT`, `MALOP`) VALUES
('msv1', 'Trần Tiến Huy', 0, '30/04/2001', 'Hà Nam', '0385265170', 'ml2'),
('msv2', 'Trần Văn Toàn', 0, '2/6/2009', 'Hà Nam', '034678332', 'ml1'),
('msv3', 'Bùi Ngọc A', 0, '2/6/2001', 'Nam Định', '0482647446', 'ml2'),
('msv4', 'Trần Thị b', 1, '4/6/1998', 'Hải Dương', '012349832', 'ml2');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ketqua`
--
ALTER TABLE `ketqua`
  ADD KEY `MASV` (`MASV`),
  ADD KEY `MAMH` (`MAMH`);

--
-- Chỉ mục cho bảng `khoa`
--
ALTER TABLE `khoa`
  ADD PRIMARY KEY (`MAK`);

--
-- Chỉ mục cho bảng `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`MALOP`),
  ADD KEY `MAK` (`MAK`);

--
-- Chỉ mục cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`MAMH`);

--
-- Chỉ mục cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`MASV`),
  ADD KEY `MALOP` (`MALOP`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ketqua`
--
ALTER TABLE `ketqua`
  ADD CONSTRAINT `ketqua_ibfk_1` FOREIGN KEY (`MASV`) REFERENCES `sinhvien` (`MASV`),
  ADD CONSTRAINT `ketqua_ibfk_2` FOREIGN KEY (`MAMH`) REFERENCES `monhoc` (`MAMH`);

--
-- Các ràng buộc cho bảng `lop`
--
ALTER TABLE `lop`
  ADD CONSTRAINT `lop_ibfk_1` FOREIGN KEY (`MAK`) REFERENCES `khoa` (`MAK`);

--
-- Các ràng buộc cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD CONSTRAINT `sinhvien_ibfk_1` FOREIGN KEY (`MALOP`) REFERENCES `lop` (`MALOP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
