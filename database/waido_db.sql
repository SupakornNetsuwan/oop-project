-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2022 at 04:08 AM
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
('BBT', 'Business Management'),
('BMT', 'Business Management'),
('Chemistry', 'Engineer'),
('Computer', 'Engineer'),
('Mechanic', 'Engineer'),
('Nurse', 'Faculty of Medicine'),
('BIT', 'Information Technology'),
('DSBA', 'Information Technology'),
('IT', 'Information Technology');

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
('Business Management'),
('Engineer'),
('Faculty of Medicine'),
('Information Technology');

-- --------------------------------------------------------

--
-- Table structure for table `professor`
--

CREATE TABLE `professor` (
  `fullname` varchar(50) NOT NULL,
  `degree` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `age` int(10) NOT NULL,
  `phone` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `professor`
--

INSERT INTO `professor` (`fullname`, `degree`, `gender`, `age`, `phone`) VALUES
('Ajarn\' Bank', 'ปริญญาเอก', 'ชาย', 32, '085920125'),
('Ajarn\' Get', 'ปริญญาเอก (Oxford)', 'ชาย', 21, '0859591201'),
('Ajarn\' Manp', 'ปริญญาโท', 'ชาย', 55, '0859201925'),
('Ajarn\' Panwith', 'ปริญญาเอก', 'ชาย', 49, '0859210591'),
('Doctor\' x', 'ปริญญาเอก', 'ชาย', 40, '0857271212');

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
('นายเอกอนทร์ สอนทดเลข', 24, 'ชาย', '0859291951', 'Business Management', 'BBT', '61070101'),
('นายเอกอนทร์ สอนทดเลข', 23, 'ชาย', '0859291951', 'Engineer', 'Mechanic', '61070102'),
('นายเกวลี ดอกท้อ', 22, 'ชาย', '0859201295', 'Engineer', 'Computer', '62064112'),
('นายดอกท้อ แสดงดี', 22, 'ชาย', '095819251', 'Engineer', 'Chemistry', '62065107'),
('นายสวัสดิภาพ แสนทรัพย์', 21, 'ชาย', '0895210512', 'Business Management', 'BBT', '63061210'),
('นายกมล เหลี่ยม', 20, 'ชาย', '085910294', 'Information Technology', 'BIT', '64070001'),
('นางสาวศศิธร ศรีจันทร์', 20, 'หญิง', '0859102915', 'Information Technology', 'DSBA', '64070106'),
('นายศุภกร เนตรสุวรรณ', 20, 'ชาย', '0959259515', 'Information Technology', 'IT', '64070108'),
('นายเมธาสิน ทรัพย์โสรี', 20, 'ชาย', '0959259515', 'Information Technology', 'IT', '64070112'),
('นายเสรีนอน สอนศิรินทร์', 20, 'ชาย', '0859201951', 'Engineer', 'Computer', '64070192'),
('นายเสรีนอน สอนศิรินทร์', 22, 'ชาย', '0859281951', 'Business Management', 'BMT', '64070193'),
('นางสาวสุมาศ ชาเนล', 20, 'หญิง', '0857690124', 'Business Management', 'BBT', '64070196'),
('นางสาวxxx uuu', 21, 'หญิง', '0959255151', 'Faculty of Medicine', 'Nurse', '64070198');

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
(46, 41, '64070106'),
(48, 42, '64070108'),
(54, 43, '62064112'),
(57, 41, '62065107'),
(58, 44, '64070192'),
(59, 44, '64070001'),
(61, 41, '64070112'),
(62, 41, '64070192'),
(65, 43, '64070001'),
(68, 43, '64070193'),
(70, 41, '64070193'),
(74, 41, '61070101'),
(76, 44, '61070101'),
(80, 38, '61070101'),
(81, 38, '61070102'),
(82, 38, '62064112'),
(83, 38, '62065107'),
(84, 38, '63061210'),
(85, 38, '64070001'),
(86, 38, '64070106'),
(90, 38, '64070192'),
(91, 38, '64070112'),
(92, 38, '64070108'),
(101, 47, '64070193'),
(102, 47, '64070196'),
(103, 41, '64070196'),
(107, 56, '64070198');

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
('Math for IT', '1', 'Ajarn\' Panwith', 'การศึกษาวิชาคณิตศาสตร์', 38),
('OOP - sec 1', '2', 'Ajarn\' Bank', 'การศึกษาการเขียนโปรแกรมเชิงวัตถุ', 41),
('OOP - sec 2', '2', 'Ajarn\' Bank', 'การศึกษาการเขียนโปรแกรมเชิงวัตถุ', 42),
('Web Technology', '3', 'Ajarn\' Manp', 'การศึกษาการเขียนเว็บ', 43),
('Design Thinking', '21', 'Ajarn\' Panwith', 'การคิด', 44),
('World of Sausage', '41', 'Ajarn\' Get', 'การทำไส้กรอกสุดมหัศจรรย์', 47),
('การทำกายภาพ', '750105', 'Doctor\' x', 'การทำกายภาพพื้นฐาน', 56);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID Database', AUTO_INCREMENT=57;

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
