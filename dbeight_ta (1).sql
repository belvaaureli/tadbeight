-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2026 at 06:41 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbeight_ta`
--

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `id_jadwal` int(11) NOT NULL,
  `hari` varchar(20) DEFAULT NULL,
  `jam` varchar(20) DEFAULT NULL,
  `id_pengajar` int(11) DEFAULT NULL,
  `id_ruangan` int(11) DEFAULT NULL,
  `id_siswa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`id_jadwal`, `hari`, `jam`, `id_pengajar`, `id_ruangan`, `id_siswa`) VALUES
(1, 'Senin', '18.00', 3, 2, NULL),
(2, 'Rabu', '18.00', 2, 1, NULL),
(3, 'Jumat', '18.00', 1, 3, NULL),
(4, 'Rabu', '18.00', 4, NULL, NULL),
(5, 'Rabu', '18.00', 5, NULL, NULL),
(6, 'Jumat', '18.00', 5, 3, NULL),
(7, 'Senin', '18.00', 6, 4, NULL),
(8, 'Senin', '18.00', 1, 1, NULL),
(9, 'Senin', '08.00', 1, 1, 1),
(10, 'Senin', '08.00', 2, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `kehadiran`
--

CREATE TABLE `kehadiran` (
  `id_kehadiran` int(11) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `id_siswa` int(11) DEFAULT NULL,
  `id_jadwal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kehadiran`
--

INSERT INTO `kehadiran` (`id_kehadiran`, `tanggal`, `status`, `id_siswa`, `id_jadwal`) VALUES
(2, '2026-04-05', 'Hadir', NULL, NULL),
(3, '2026-04-05', 'Hadir', NULL, NULL),
(12, '2026-04-05', 'Hadir', NULL, NULL),
(13, '2026-04-05', 'Hadir', 2, NULL),
(14, '2026-04-05', 'Izin', 6, NULL),
(15, '2026-04-06', 'Hadir', 7, NULL),
(16, NULL, 'Hadir', 16, NULL);

--
-- Triggers `kehadiran`
--
DELIMITER $$
CREATE TRIGGER `cek_status_kehadiran` BEFORE INSERT ON `kehadiran` FOR EACH ROW BEGIN
    IF NEW.status NOT IN ('Hadir','Izin','Alpha') THEN
        SET NEW.status = 'Alpha';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `log_siswa`
--

CREATE TABLE `log_siswa` (
  `nama` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `log_siswa`
--

INSERT INTO `log_siswa` (`nama`) VALUES
('Rendra'),
('Zacky');

-- --------------------------------------------------------

--
-- Table structure for table `pengajar`
--

CREATE TABLE `pengajar` (
  `id_pengajar` int(11) NOT NULL,
  `nama_pengajar` varchar(100) DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengajar`
--

INSERT INTO `pengajar` (`id_pengajar`, `nama_pengajar`, `no_hp`) VALUES
(1, 'Mr. Jake', '089721746917'),
(2, 'Ms. Cala', '082372974375'),
(3, 'Ms. Lily', '089437472372'),
(4, 'Mr. Yanto', '085435687658'),
(5, 'Ms. Nona', '085678325689'),
(6, 'Mr. Jay', '084628107354'),
(7, 'Ibu Putri', '9812');

-- --------------------------------------------------------

--
-- Table structure for table `peserta`
--

CREATE TABLE `peserta` (
  `id_peserta` int(11) NOT NULL,
  `id_siswa` int(11) DEFAULT NULL,
  `id_jadwal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peserta`
--

INSERT INTO `peserta` (`id_peserta`, `id_siswa`, `id_jadwal`) VALUES
(1, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE `ruangan` (
  `id_ruangan` int(11) NOT NULL,
  `nama_ruangan` varchar(50) DEFAULT NULL,
  `kapasitas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`id_ruangan`, `nama_ruangan`, `kapasitas`) VALUES
(1, 'A', 12),
(2, 'B', 12),
(3, 'C', 10),
(4, 'D', 10),
(5, 'E', 15),
(6, 'F', 15);

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `id_siswa` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`id_siswa`, `nama`, `no_hp`, `alamat`, `email`, `id_user`) VALUES
(1, 'Alyssa', '081234567891', 'Jl. Sigura-gura', NULL, NULL),
(2, 'Belva', '089876543219', 'Jl. Soekarno Hatta', NULL, NULL),
(3, 'Intan', '082345678918', 'Jl. Surabaya', NULL, NULL),
(4, 'Eka', '083456789124', 'Jl. Surabaya', NULL, NULL),
(5, 'Alexa', '085332681234', 'Jl. Ambarawa', NULL, NULL),
(6, 'Azizah', '089273745923', 'Jl. Singosari', NULL, NULL),
(7, 'Arsyl', '086573029863', 'Jl. Bondowoso', NULL, NULL),
(15, 'Rendra', '089767564534', 'Jl. Lili', 'bnarendra@gmail.com', 10),
(16, 'Zacky', '085434231234', 'Batu', 'zacky@gmail.com', 11);

--
-- Triggers `siswa`
--
DELIMITER $$
CREATE TRIGGER `after_insert_siswa` AFTER INSERT ON `siswa` FOR EACH ROW INSERT INTO log_siswa VALUES (NEW.nama)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` enum('admin','pengajar','siswa') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `email`, `password`, `role`) VALUES
(1, 'admin@gmail.com', 'admin123', 'admin'),
(2, 'pengajar@gmail.com', 'pengajar123', 'pengajar'),
(3, 'siswa@gmail.com', 'siswa123', 'siswa'),
(4, 'shifa@gmail.com', 'bnashifa', 'siswa'),
(5, 'bnashifa@gmail.com', 'bnashifa', 'siswa'),
(8, 'nova@gmail.com', 'nova123', 'siswa'),
(9, 'dicky@gmail.com', 'bnadicky', 'siswa'),
(10, 'bnarendra@gmail.com', 'bnarendra', 'siswa'),
(11, 'zacky@gmail.com', 'bnazacky', 'siswa');

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_siswa`
-- (See below for the actual view)
--
CREATE TABLE `view_siswa` (
);

-- --------------------------------------------------------

--
-- Structure for view `view_siswa`
--
DROP TABLE IF EXISTS `view_siswa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_siswa`  AS SELECT `siswa`.`id_siswa` AS `id_siswa`, `siswa`.`nama_siswa` AS `nama_siswa` FROM `siswa` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id_jadwal`),
  ADD KEY `id_pengajar` (`id_pengajar`),
  ADD KEY `id_ruangan` (`id_ruangan`);

--
-- Indexes for table `kehadiran`
--
ALTER TABLE `kehadiran`
  ADD PRIMARY KEY (`id_kehadiran`);

--
-- Indexes for table `pengajar`
--
ALTER TABLE `pengajar`
  ADD PRIMARY KEY (`id_pengajar`);

--
-- Indexes for table `peserta`
--
ALTER TABLE `peserta`
  ADD PRIMARY KEY (`id_peserta`),
  ADD KEY `id_siswa` (`id_siswa`),
  ADD KEY `id_jadwal` (`id_jadwal`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`id_ruangan`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`id_siswa`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `kehadiran`
--
ALTER TABLE `kehadiran`
  MODIFY `id_kehadiran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `pengajar`
--
ALTER TABLE `pengajar`
  MODIFY `id_pengajar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `peserta`
--
ALTER TABLE `peserta`
  MODIFY `id_peserta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ruangan`
--
ALTER TABLE `ruangan`
  MODIFY `id_ruangan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `siswa`
--
ALTER TABLE `siswa`
  MODIFY `id_siswa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `jadwal_ibfk_1` FOREIGN KEY (`id_pengajar`) REFERENCES `pengajar` (`id_pengajar`),
  ADD CONSTRAINT `jadwal_ibfk_2` FOREIGN KEY (`id_ruangan`) REFERENCES `ruangan` (`id_ruangan`);

--
-- Constraints for table `peserta`
--
ALTER TABLE `peserta`
  ADD CONSTRAINT `peserta_ibfk_1` FOREIGN KEY (`id_siswa`) REFERENCES `siswa` (`id_siswa`),
  ADD CONSTRAINT `peserta_ibfk_2` FOREIGN KEY (`id_jadwal`) REFERENCES `jadwal` (`id_jadwal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
