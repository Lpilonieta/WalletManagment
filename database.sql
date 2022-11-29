-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 30, 2022 at 12:05 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `registros`
--

-- --------------------------------------------------------

--
-- Table structure for table `tablacashflow`
--

CREATE TABLE `tablacashflow` (
  `Fecha` varchar(15) NOT NULL,
  `Id` varchar(15) NOT NULL,
  `Valor` text NOT NULL,
  `Saldo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tablacashflow`
--

INSERT INTO `tablacashflow` (`Fecha`, `Id`, `Valor`, `Saldo`) VALUES
('1-21-11-22', '12345', '10', '5'),
('1-21-11-22', '1235', '10', '15'),
('1-21-11-22', '1245', '-5', '10'),
('0-20-11-22', '545', '54', '466'),
('0-20-11-22', '6541', '162', '564');

-- --------------------------------------------------------

--
-- Table structure for table `tablaEspaciosfinancieros`
--

CREATE TABLE `tablaEspaciosfinancieros` (
  `Id` varchar(15) NOT NULL,
  `Nombre` text NOT NULL,
  `Grupo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tablaEspaciosfinancieros`
--

INSERT INTO `tablaEspaciosfinancieros` (`Id`, `Nombre`, `Grupo`) VALUES
('0', 'Área personal', 'default');

-- --------------------------------------------------------

--
-- Table structure for table `tablaregistros`
--

CREATE TABLE `tablaregistros` (
  `Fecha` text NOT NULL,
  `Id` varchar(15) NOT NULL,
  `Valor` text NOT NULL,
  `Fuente` text NOT NULL DEFAULT 'null',
  `Motivo` text NOT NULL DEFAULT 'null',
  `Nombre` text NOT NULL DEFAULT 'null',
  `Descripcion` text NOT NULL DEFAULT 'null',
  `Tipo` text NOT NULL DEFAULT 'null',
  `SaldoDeuda` text NOT NULL DEFAULT '\'null\'',
  `PorcentajeInteres` text NOT NULL DEFAULT 'null',
  `NumeroCuotas` text NOT NULL DEFAULT 'null',
  `ValorSiguienteCuota` text NOT NULL DEFAULT 'null',
  `Periodicidad` text NOT NULL DEFAULT 'null',
  `PeriodicidadEspecifica` text NOT NULL DEFAULT 'null',
  `PorcentajeRentabilidad` text NOT NULL DEFAULT 'null',
  `NumeroStock` text NOT NULL DEFAULT 'null',
  `VentasTotales` text NOT NULL DEFAULT 'null',
  `ValorUnidad` text NOT NULL DEFAULT 'null',
  `Categoria` text NOT NULL DEFAULT 'null',
  `IVA` text NOT NULL DEFAULT 'false',
  `isPasive` text NOT NULL DEFAULT 'false',
  `isAsset` text NOT NULL DEFAULT 'false',
  `isInventory` text NOT NULL DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tablaregistros`
--

INSERT INTO `tablaregistros` (`Fecha`, `Id`, `Valor`, `Fuente`, `Motivo`, `Nombre`, `Descripcion`, `Tipo`, `SaldoDeuda`, `PorcentajeInteres`, `NumeroCuotas`, `ValorSiguienteCuota`, `Periodicidad`, `PeriodicidadEspecifica`, `PorcentajeRentabilidad`, `NumeroStock`, `VentasTotales`, `ValorUnidad`, `Categoria`, `IVA`, `isPasive`, `isAsset`, `isInventory`) VALUES
('2-29-11-2022', '8-0-0', '909', '1', '6', 'null', 'null', 'null', '\'null\'', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'false', 'false', 'false', 'false'),
('2-29-11-2022', '8-1-0', '99009', '1', '7', 'null', 'null', 'null', '\'null\'', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'false', 'false', 'false', 'false'),
('2-29-11-2022', '8-4-0', '987', '1', '7', 'null', 'null', 'null', '\'null\'', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'false', 'false', 'false', 'false'),
('2-29-11-2022', '8-5-0', '987', '1', '1', 'uiyj ', 'hjg ', '1', '\'null\'', 'null', 'null', 'null', 'null', 'null', '0', 'null', 'null', 'null', 'null', 'false', 'false', 'false', 'false'),
('2-29-11-2022', '8-6-0', '100', '1', '6', 'null', 'null', 'null', '\'null\'', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'false', 'false', 'false', 'false'),
('2-29-11-2022', '8-7-0', '9876', '1', '1', 'dshfon ', 'kjngkjsnd ', '1', '\'null\'', 'null', 'null', 'null', 'null', 'null', '5', 'null', 'null', 'null', 'null', 'false', 'false', 'false', 'false'),
('2-29-11-2022', '9-0-0', '0', 'source', 'motive', 'df ', 'fds ', '1', '\'null\'', 'null', 'null', 'null', 'null', 'null', '0', '65.0', '0.0', '100.0', '0', 'false', 'false', 'false', 'false'),
('2-29-11-2022', '9-1-0', '0', 'source', 'motive', 'df ', 'fds ', '1', '\'null\'', 'null', 'null', 'null', 'null', 'null', '0', '65.0', '0.0', '100.0', '0', 'false', 'false', 'false', 'true'),
('2-29-11-2022', '9-2-0', '656', '1', '5', 'null', 'null', 'null', '\'null\'', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'false', 'false', 'false', 'false'),
('2-29-11-2022', '9-3-0', '98', '1', '5', 'null', 'null', 'null', '\'null\'', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'false', 'false', 'false', 'false'),
('2-29-11-2022', '9-4-0', '0', 'source', 'motive', '-0987 ', ' 0987', '1', '\'null\'', 'null', 'null', 'null', 'null', 'null', '0', '98.0', '0.0', '100.0', '0', 'false', 'false', 'false', 'true'),
('2-29-11-2022', '9-6-0', '999', '1', '5', ' sdf', 'kljhgb ', '1', '999', '0.0', '1', '0.0', '2', '1', 'null', 'null', 'null', 'null', 'null', 'false', 'false', 'false', 'false');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tablacashflow`
--
ALTER TABLE `tablacashflow`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `tablaEspaciosfinancieros`
--
ALTER TABLE `tablaEspaciosfinancieros`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `tablaregistros`
--
ALTER TABLE `tablaregistros`
  ADD PRIMARY KEY (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
