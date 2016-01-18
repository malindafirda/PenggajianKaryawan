/*
SQLyog Enterprise - MySQL GUI v7.14 
MySQL - 5.6.27-log : Database - db_penggajian
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_penggajian` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_penggajian`;

/*Table structure for table `tbl_gaji` */

DROP TABLE IF EXISTS `tbl_gaji`;

CREATE TABLE `tbl_gaji` (
  `gaji` int(20) NOT NULL,
  `jabatan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_gaji` */

insert  into `tbl_gaji`(`gaji`,`jabatan`) values (1500000,'Office Boy'),(1500000,'Office Girl'),(3500000,'Manajer Pemasaran'),(3500000,'Manajer Keuangan'),(3500000,'Manajer HRD'),(2500000,'Staff Pemasaran'),(2500000,'Staff Produksi'),(2500000,'Staff HRD');

/*Table structure for table `tbl_gajipegawai` */

DROP TABLE IF EXISTS `tbl_gajipegawai`;

CREATE TABLE `tbl_gajipegawai` (
  `idpegawai` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `jamkerja` varchar(3) NOT NULL,
  `gaji` int(20) NOT NULL,
  PRIMARY KEY (`idpegawai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_gajipegawai` */

insert  into `tbl_gajipegawai`(`idpegawai`,`nama`,`jabatan`,`jamkerja`,`gaji`) values ('A123','Farizal Nur Bahtiar','Manajer Keuangan','3',3500000),('B123','Nina Fatmawati','Manajer HRD','2',1500000),('C123','Tintin Sugesti','Staff HRD','D',2500000);

/*Table structure for table `tbl_jabatan` */

DROP TABLE IF EXISTS `tbl_jabatan`;

CREATE TABLE `tbl_jabatan` (
  `idjabatan` varchar(20) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  PRIMARY KEY (`idjabatan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_jabatan` */

insert  into `tbl_jabatan`(`idjabatan`,`jabatan`) values ('AA1','Manajer Pemasaran'),('AA2','Manajer Keuangan'),('AA3','Manajer HRD'),('BB1','Staff Pemasaran'),('BB2','Staff Produksi'),('BB3','Staff HRD'),('CC1','Office Boy'),('CC2','Office Girl');

/*Table structure for table `tbl_login` */

DROP TABLE IF EXISTS `tbl_login`;

CREATE TABLE `tbl_login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_login` */

insert  into `tbl_login`(`username`,`password`,`status`) values ('firda','12345','admin'),('malinda','malinda','user');

/*Table structure for table `tbl_pegawai` */

DROP TABLE IF EXISTS `tbl_pegawai`;

CREATE TABLE `tbl_pegawai` (
  `idpegawai` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `jamkerja` varchar(3) NOT NULL,
  PRIMARY KEY (`idpegawai`),
  KEY `jabatan` (`jabatan`),
  KEY `jamkerja` (`jamkerja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_pegawai` */

insert  into `tbl_pegawai`(`idpegawai`,`nama`,`jabatan`,`jamkerja`) values ('A123','Farizal Nur Bahtiar','Manajer Keuangan','3'),('B123','Nina Fatmawati','Manajer HRD','2'),('C123','Tintin Sugesti','Staff HRD','D'),('D123','Malinda Firda Z','Manajer Pemasaran','1');

/*Table structure for table `tblabsen` */

DROP TABLE IF EXISTS `tblabsen`;

CREATE TABLE `tblabsen` (
  `no` int(5) NOT NULL AUTO_INCREMENT,
  `idpegawai` varchar(10) NOT NULL,
  `izin` varchar(4) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` varchar(100) NOT NULL,
  PRIMARY KEY (`no`),
  UNIQUE KEY `no` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tblabsen` */

/*Table structure for table `tbljam` */

DROP TABLE IF EXISTS `tbljam`;

CREATE TABLE `tbljam` (
  `jamkerja` varchar(3) NOT NULL,
  `jam_masuk_mulai` time NOT NULL,
  `jam_kerja_mulai` time NOT NULL,
  `jam_kerja_selesai` time NOT NULL,
  `jam_keluar_selesai` time NOT NULL,
  PRIMARY KEY (`jamkerja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbljam` */

insert  into `tbljam`(`jamkerja`,`jam_masuk_mulai`,`jam_kerja_mulai`,`jam_kerja_selesai`,`jam_keluar_selesai`) values ('1','07:30:00','08:00:00','15:30:00','15:59:59'),('2','12:50:00','16:00:00','23:30:00','23:59:59'),('3','23:30:00','00:50:00','07:30:00','07:59:59'),('D','07:30:00','08:00:00','17:30:00','17:59:59');

/*Table structure for table `tblkehadiran` */

DROP TABLE IF EXISTS `tblkehadiran`;

CREATE TABLE `tblkehadiran` (
  `no_rec` mediumint(10) NOT NULL,
  `idpegawai` varchar(10) NOT NULL,
  `tanggal` date NOT NULL,
  `jmasuk` time DEFAULT NULL,
  `jkeluar` time DEFAULT NULL,
  `jamkerja` varchar(3) NOT NULL,
  PRIMARY KEY (`no_rec`),
  KEY `idpegawai` (`idpegawai`),
  KEY `jamkerja` (`jamkerja`),
  CONSTRAINT `FK_tblkehadiran` FOREIGN KEY (`idpegawai`) REFERENCES `tbl_pegawai` (`idpegawai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tblkehadiran` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
