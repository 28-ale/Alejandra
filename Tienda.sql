USE [master]
GO
/****** Object:  Database [Tienda]    Script Date: 05/04/2020 15:57:47 ******/
CREATE DATABASE [Tienda]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Tienda', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\Tienda.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Tienda_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\Tienda_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Tienda] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Tienda].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Tienda] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Tienda] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Tienda] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Tienda] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Tienda] SET ARITHABORT OFF 
GO
ALTER DATABASE [Tienda] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Tienda] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Tienda] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Tienda] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Tienda] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Tienda] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Tienda] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Tienda] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Tienda] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Tienda] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Tienda] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Tienda] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Tienda] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Tienda] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Tienda] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Tienda] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Tienda] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Tienda] SET RECOVERY FULL 
GO
ALTER DATABASE [Tienda] SET  MULTI_USER 
GO
ALTER DATABASE [Tienda] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Tienda] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Tienda] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Tienda] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Tienda] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Tienda', N'ON'
GO
ALTER DATABASE [Tienda] SET QUERY_STORE = OFF
GO
USE [Tienda]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 05/04/2020 15:57:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](35) NULL,
	[apellido] [varchar](35) NULL,
	[direccion] [varchar](45) NULL,
	[telefono] [varchar](40) NULL,
	[correo] [varchar](40) NULL,
	[fecha_Ing] [date] NULL,
	[edad] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Empleados]    Script Date: 05/04/2020 15:57:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Empleados](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](35) NULL,
	[apellido] [varchar](35) NULL,
	[direccion] [varchar](40) NULL,
	[telefono] [varchar](40) NULL,
	[fecha_Ing] [varchar](35) NULL,
	[edad] [varchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Productos]    Script Date: 05/04/2020 15:57:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Productos](
	[Codigo] [int] NULL,
	[Nombre_Produc] [varchar](40) NULL,
	[Precio] [varchar](45) NULL,
	[Existencias] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[venta]    Script Date: 05/04/2020 15:57:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[venta](
	[registro_ventas] [int] NULL,
	[codigo_producto] [int] NULL,
	[cantidad] [int] NULL,
	[total] [int] NULL
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [Tienda] SET  READ_WRITE 
GO
