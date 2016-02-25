-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.5.29 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2016-02-08 17:29:09
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for tumilovich
CREATE DATABASE IF NOT EXISTS `tumilovich` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tumilovich`;


-- Dumping structure for table tumilovich.accesslevel
CREATE TABLE IF NOT EXISTS `accesslevel` (
  `idAccessLevel` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`idAccessLevel`),
  KEY `fk_AccessLevel_has_Test_AccessLevel1_idx` (`idAccessLevel`),
  CONSTRAINT `fk_AccessLevel_has_Test_AccessLevel1` FOREIGN KEY (`idAccessLevel`) REFERENCES `accesslevel` (`idAccessLevel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table tumilovich.accesslevel: ~2 rows (approximately)
/*!40000 ALTER TABLE `accesslevel` DISABLE KEYS */;
REPLACE INTO `accesslevel` (`idAccessLevel`, `role`) VALUES
	(1, 'student'),
	(2, 'tutor');
/*!40000 ALTER TABLE `accesslevel` ENABLE KEYS */;


-- Dumping structure for table tumilovich.answer
CREATE TABLE IF NOT EXISTS `answer` (
  `idAnswer` int(11) NOT NULL AUTO_INCREMENT,
  `AnswerText` text NOT NULL,
  `state` tinyint(1) NOT NULL,
  `Question_idQuestion` int(11) NOT NULL,
  PRIMARY KEY (`idAnswer`),
  KEY `fk_Answer_Question1_idx` (`Question_idQuestion`),
  CONSTRAINT `fk_Answer_Question1` FOREIGN KEY (`Question_idQuestion`) REFERENCES `question` (`idQuestion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;

-- Dumping data for table tumilovich.answer: ~60 rows (approximately)
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
REPLACE INTO `answer` (`idAnswer`, `AnswerText`, `state`, `Question_idQuestion`) VALUES
	(1, 'no', 0, 1),
	(17, 'asdfas', 1, 1),
	(28, '1', 0, 6),
	(29, '1', 0, 6),
	(30, '2', 0, 6),
	(31, '2', 1, 6),
	(32, '3', 1, 6),
	(33, '2-2', 1, 7),
	(34, '2-2', 0, 7),
	(35, '2-3', 0, 7),
	(36, '2-3', 0, 7),
	(37, '2-4', 0, 7),
	(38, 'Vash', 1, 8),
	(39, 'Vv', 0, 8),
	(40, 'Minsk', 0, 8),
	(41, 'Minsk', 1, 8),
	(42, 'moscow', 0, 8),
	(43, 'Moscow', 0, 9),
	(44, 'Moscow', 1, 9),
	(45, 'Minsk', 0, 9),
	(46, 'Minsk', 0, 9),
	(47, 'Wash', 0, 9),
	(48, 'asdfasdf', 0, 10),
	(49, 'asdfasdf', 0, 10),
	(50, 'asdfasdfasd', 1, 10),
	(51, 'asdfasdfasd', 0, 10),
	(52, 'fsdfsdfsd', 1, 10),
	(53, '444', 0, 11),
	(54, '444', 0, 11),
	(55, '3333', 1, 11),
	(56, '3333', 1, 11),
	(57, '222', 0, 11),
	(58, 'see', 0, 22),
	(59, 'seeee', 0, 22),
	(60, 'saw', 1, 22),
	(61, 'seen', 1, 22),
	(62, 'weqwe', 0, 22),
	(63, 'went', 1, 23),
	(64, 'go', 1, 23),
	(65, 'gones', 0, 23),
	(66, 'qwe', 0, 23),
	(67, 'ee', 0, 23),
	(68, 'yes', 1, 28),
	(69, 'tomorrow ', 0, 28),
	(70, 'neverday', 0, 28),
	(71, 'no', 0, 28),
	(72, 'tooo toooo', 0, 28),
	(73, 'yesterday', 0, 29),
	(74, 'today', 1, 29),
	(75, 'not today', 0, 29),
	(76, 'too tooo', 0, 29),
	(77, 'invalid', 0, 29),
	(78, 'erwerwer', 0, 30),
	(79, 'werwer', 1, 30),
	(80, '111', 0, 30),
	(81, '222', 0, 30),
	(82, '333', 0, 30),
	(86, 'create answer1', 1, 40),
	(87, 'create answer22', 0, 40),
	(88, 'create answer33', 0, 40);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;


-- Dumping structure for table tumilovich.question
CREATE TABLE IF NOT EXISTS `question` (
  `idQuestion` int(11) NOT NULL AUTO_INCREMENT,
  `Test_idTest` int(11) NOT NULL,
  `Question_text` text NOT NULL,
  PRIMARY KEY (`idQuestion`),
  KEY `fk_Question_Test_idx` (`Test_idTest`),
  CONSTRAINT `fk_Question_Test` FOREIGN KEY (`Test_idTest`) REFERENCES `test` (`idTest`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- Dumping data for table tumilovich.question: ~19 rows (approximately)
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
REPLACE INTO `question` (`idQuestion`, `Test_idTest`, `Question_text`) VALUES
	(1, 1, 'is yesterday - tomorrow'),
	(6, 4, 'Capital ?'),
	(7, 11, 'quest 2'),
	(8, 3, 'capital USA ?'),
	(9, 8, 'capital belarus ?'),
	(10, 8, 'sdjnfgkljasdf\r\nasdfasdf ? '),
	(11, 8, 'fghfdghdfgh'),
	(12, 8, 'irregular webs ? '),
	(13, 8, 'irregular webs ? '),
	(14, 8, 'irregular webs ? '),
	(20, 26, 'irregular web see ? '),
	(22, 27, 'irregular web see ? '),
	(23, 27, 'irregular web go? '),
	(28, 28, 'today is 19 01 ?'),
	(29, 28, 'test 2 19 01 '),
	(30, 29, 'qweqweqwe'),
	(31, 30, 'erert'),
	(39, 2, 'Question new '),
	(40, 2, 'Question new ');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;


-- Dumping structure for table tumilovich.test
CREATE TABLE IF NOT EXISTS `test` (
  `idTest` int(11) NOT NULL AUTO_INCREMENT,
  `nameSubject` varchar(11) NOT NULL,
  `testName` varchar(50) NOT NULL,
  PRIMARY KEY (`idTest`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- Dumping data for table tumilovich.test: ~15 rows (approximately)
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
REPLACE INTO `test` (`idTest`, `nameSubject`, `testName`) VALUES
	(1, 'Chemistry', 'test1'),
	(2, 'Chemistry', 'test2'),
	(3, 'Physics', 'test3'),
	(4, 'Chemistry', 'test test'),
	(8, 'English', 'test test 2'),
	(9, 'English', 'test test 2'),
	(10, 'English', 'capitals'),
	(11, 'Chemistry', 'qeqweqwe'),
	(12, 'Chemistry', 'qeqweqwe'),
	(13, 'Physics', 'my new test'),
	(26, 'English', 'eng test'),
	(27, 'English', 'eng test'),
	(28, 'Chemistry', 'test 19 01 2016'),
	(29, 'Physics', 'meta 1'),
	(30, 'Chemistry', 'qweq');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;


-- Dumping structure for table tumilovich.user
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `AccessLevel_idAccessLevel` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

-- Dumping data for table tumilovich.user: ~16 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`idUser`, `AccessLevel_idAccessLevel`, `name`, `password`) VALUES
	(1, 1, 'Petrov', 'wserwe'),
	(2, 1, 'Pimenov', '34'),
	(3, 1, 'Tarakanov', '234'),
	(4, 1, 'Vanov', '2'),
	(18, 2, 'Prepod1', '1'),
	(19, 2, 'Prepod1', '32'),
	(20, 1, 'uasername', '123qw'),
	(21, 2, 'browser', '231we'),
	(26, 1, 'browser2', '31ea'),
	(27, 1, 'browser23', '123w'),
	(28, 1, 'browser11', 'qwease23'),
	(29, 2, 'prepod', '21'),
	(30, 2, 'prepod2', '2e'),
	(31, 1, 'prepod2', '212'),
	(33, 1, 'petrov', '122'),
	(41, 2, 'prep 3', 'eqwe');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Dumping structure for table tumilovich.user_has_test
CREATE TABLE IF NOT EXISTS `user_has_test` (
  `User_idUser` int(11) NOT NULL,
  `Test_idTest` int(11) NOT NULL,
  `result` int(11) DEFAULT NULL,
  PRIMARY KEY (`User_idUser`,`Test_idTest`),
  KEY `fk_User_has_Test_Test1_idx` (`Test_idTest`),
  KEY `fk_User_has_Test_User1_idx` (`User_idUser`),
  CONSTRAINT `fk_User_has_Test_Test1` FOREIGN KEY (`Test_idTest`) REFERENCES `test` (`idTest`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Test_User1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table tumilovich.user_has_test: ~3 rows (approximately)
/*!40000 ALTER TABLE `user_has_test` DISABLE KEYS */;
REPLACE INTO `user_has_test` (`User_idUser`, `Test_idTest`, `result`) VALUES
	(1, 1, NULL),
	(1, 3, NULL),
	(2, 2, NULL);
/*!40000 ALTER TABLE `user_has_test` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
