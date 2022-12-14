-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2022 at 08:58 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `waido_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `name` varchar(50) NOT NULL,
  `in_faculty` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`name`, `in_faculty`) VALUES
('BUIAM', 'Business Management '),
('BUSIM', 'Business Management '),
('Computer', 'Engineer'),
('Electronic', 'Engineer'),
('Enviroment', 'Engineer'),
('Material', 'Engineer'),
('Enviroment Analytic', 'Enviomental Product Design'),
('Enviroment Investor', 'Enviomental Product Design'),
('BIT', 'Information Technology'),
('DSBA', 'Information Technology'),
('IT', 'Information Technology'),
('Health Technology', 'Medical Technology'),
('Health Wellness', 'Medical Technology');

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`name`) VALUES
('Business Management '),
('Engineer'),
('Enviomental Product Design'),
('Information Technology'),
('Medical Technology');

-- --------------------------------------------------------

--
-- Table structure for table `professor`
--

CREATE TABLE `professor` (
  `fullname` varchar(50) NOT NULL,
  `degree` varchar(50) NOT NULL,
  `own_subject` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `age` int(10) NOT NULL,
  `phone` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `professor`
--

INSERT INTO `professor` (`fullname`, `degree`, `own_subject`, `gender`, `age`, `phone`) VALUES
('Ajarn\' Bank', 'Ph.D.', 'OOP', 'Male', 31, '0959259515'),
('lnwza', 'ป.2', '-', 'lnwza', 5, '9999966666'),
('อาจารย์เอิร์ท', 'ปริญญาประถม', '-', 'ชาย', 20, '0959259515'),
('อาจารย์ไหม', 'ปริญญาพันเอก', '-', 'หญิง', 22, '0858129214');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `fullname` varchar(50) NOT NULL,
  `age` int(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `faculty` varchar(50) DEFAULT NULL,
  `branch` varchar(50) DEFAULT NULL,
  `student_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`fullname`, `age`, `gender`, `phone`, `faculty`, `branch`, `student_id`) VALUES
('นายวชิรพล กลิ่นเกษร', 20, 'ชาย', '0909xxxxx', '-', '-', '64070096'),
('ศศิธร ศรีจันทร์', 20, 'หญิง', '0857122912', 'Engineer', 'Computer', '64070106'),
('นายศุภกร เนตรสุวรรณ', 20, 'ชาย', '0959259515', 'Engineer', 'Electronic', '64070108');

-- --------------------------------------------------------

--
-- Table structure for table `student_in_subject`
--

CREATE TABLE `student_in_subject` (
  `id` int(11) NOT NULL,
  `subject` int(11) NOT NULL,
  `student` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางนักเรียนที่เรียนในแต่ละวิชา';

--
-- Dumping data for table `student_in_subject`
--

INSERT INTO `student_in_subject` (`id`, `subject`, `student`) VALUES
(12, 7, '64070106'),
(13, 9, '64070106'),
(14, 9, '64070096'),
(18, 1, '64070108'),
(20, 8, '64070106'),
(21, 8, '64070096');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `name` varchar(50) NOT NULL COMMENT 'ชื่อวิชา',
  `subject_id` varchar(20) NOT NULL COMMENT 'รหัสวิชา',
  `professor_fullname` varchar(50) NOT NULL COMMENT 'ชื่ออาจารย์',
  `details` varchar(300) DEFAULT NULL COMMENT 'รายละเอียดวิชา',
  `id` int(11) NOT NULL COMMENT 'ID Database'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางวิชา';

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`name`, `subject_id`, `professor_fullname`, `details`, `id`) VALUES
('OOP', '15', 'Ajarn\' Bank', 'GG', 1),
('Project', '55500', 'อาจารย์เอิร์ท', '', 7),
('Waido', '100', 'lnwza', '', 8),
('Happiness school', '55600', 'อาจารย์ไหม', 'ทดสอบรายการ', 9),
('xxxxxxx', '1412', 'lnwza', 'saasf', 11),
('Project', '55500', 'อาจารย์ไหม', 'asesa', 12);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Level` int(10) NOT NULL DEFAULT 5
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Username`, `Password`, `Level`) VALUES
('Admin', 'password', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`name`),
  ADD KEY `map_faculty` (`in_faculty`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`fullname`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `student_in_subject`
--
ALTER TABLE `student_in_subject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `map_student_id` (`student`),
  ADD KEY `map_subject_id` (`subject`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `subject_map_professor` (`professor_fullname`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student_in_subject`
--
ALTER TABLE `student_in_subject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID Database', AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `branch`
--
ALTER TABLE `branch`
  ADD CONSTRAINT `map_faculty` FOREIGN KEY (`in_faculty`) REFERENCES `faculty` (`name`);

--
-- Constraints for table `student_in_subject`
--
ALTER TABLE `student_in_subject`
  ADD CONSTRAINT `map_student_id` FOREIGN KEY (`student`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `map_subject_id` FOREIGN KEY (`subject`) REFERENCES `subject` (`id`);

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_map_professor` FOREIGN KEY (`professor_fullname`) REFERENCES `professor` (`fullname`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
