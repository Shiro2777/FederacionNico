-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-05-2022 a las 21:01:05
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbfederacion`
--
CREATE DATABASE IF NOT EXISTS `dbfederacion` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dbfederacion`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `abreviatura` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `nombre`, `abreviatura`) VALUES
(1, 'Junior', 'J'),
(2, 'Senior', 'S'),
(3, 'Especial', 'E');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugares`
--

DROP TABLE IF EXISTS `lugares`;
CREATE TABLE `lugares` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `airelibre` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lugares`
--

INSERT INTO `lugares` (`id`, `nombre`, `ubicacion`, `airelibre`) VALUES
(1, 'Las Mestas', 'Gijon', 1),
(2, 'Centro ciudad', 'Gijon', 1),
(3, 'Parque San Francisco', 'Oviedo', 1),
(4, 'Puerto', 'Aviles', 1),
(5, 'Pabellon deportivo Aviles', 'Aviles', 0),
(6, 'Centro ciudad', 'Oviedo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metales`
--

DROP TABLE IF EXISTS `metales`;
CREATE TABLE `metales` (
  `idMetal` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `asignada` tinyint(1) NOT NULL DEFAULT 0,
  `pureza` float NOT NULL,
  `idOro` int(11) NOT NULL,
  `idPlata` int(11) NOT NULL,
  `idBronce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participantes`
--

DROP TABLE IF EXISTS `participantes`;
CREATE TABLE `participantes` (
  `id` int(11) NOT NULL,
  `dorsal` int(150) NOT NULL,
  `calle` char(1) NOT NULL,
  `penalizacion` tinyint(1) NOT NULL DEFAULT 0,
  `otros` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patrocinadores`
--

DROP TABLE IF EXISTS `patrocinadores`;
CREATE TABLE `patrocinadores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `web` varchar(150) DEFAULT NULL,
  `dotacion` double NOT NULL,
  `idresponsable` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

DROP TABLE IF EXISTS `personas`;
CREATE TABLE `personas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `nifnie` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responsables`
--

DROP TABLE IF EXISTS `responsables`;
CREATE TABLE `responsables` (
  `id` int(11) NOT NULL,
  `telefonoProf` varchar(10) NOT NULL,
  `horarioIni` time NOT NULL,
  `horarioFin` time NOT NULL,
  `idpersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

DROP TABLE IF EXISTS `resultados`;
CREATE TABLE `resultados` (
  `id` int(11) NOT NULL,
  `idOro` int(11) NOT NULL,
  `idPlata` int(11) NOT NULL,
  `idBronce` int(11) NOT NULL,
  `definitivo` tinyint(1) NOT NULL DEFAULT 0,
  `fechahora` datetime DEFAULT NULL,
  `idParticipante1` int(11) DEFAULT NULL,
  `idParticipante2` int(11) DEFAULT NULL,
  `idParticipante3` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `abreviatura` (`abreviatura`);

--
-- Indices de la tabla `lugares`
--
ALTER TABLE `lugares`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `metales`
--
ALTER TABLE `metales`
  ADD PRIMARY KEY (`idMetal`);

--
-- Indices de la tabla `participantes`
--
ALTER TABLE `participantes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `patrocinadores`
--
ALTER TABLE `patrocinadores`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`),
  ADD UNIQUE KEY `idpersona` (`idresponsable`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nifnie` (`nifnie`);

--
-- Indices de la tabla `responsables`
--
ALTER TABLE `responsables`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idresponsable` (`idpersona`);

--
-- Indices de la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
