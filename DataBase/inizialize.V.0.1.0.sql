USE [master]
GO

/****** Object:  Database [Videos]    Script Date: 10-Dec-19 11:39:31 AM ******/
CREATE DATABASE [Videos] ON  PRIMARY 
( NAME = N'Videos', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\Videos.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Videos_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\Videos_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Videos].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO


USE [Videos]
GO

/****** Object:  Table [dbo].[Tbl_user]    Script Date: 10-Dec-19 11:40:58 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tbl_user](
	[user_id] [int] NOT NULL,
	[user_name] [varchar](15) NOT NULL,
	[user_email] [varchar](50) NOT NULL,
	[user_phonenumber] [varchar](8) NOT NULL,
	[user_password] [nchar](10) NOT NULL,
	[user_fullname] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Tbl_user] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

USE [Videos]
GO

/****** Object:  Table [dbo].[Tbl_video]    Script Date: 10-Dec-19 11:41:09 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tbl_video](
	[video_id] [int] NOT NULL,
	[video_name] [varchar](50) NOT NULL,
	[video_url] [varchar](100) NOT NULL,
	[user_id] [int] NOT NULL,
 CONSTRAINT [PK_Tbl_video] PRIMARY KEY CLUSTERED 
(
	[video_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Tbl_video]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_video_Tbl_user] FOREIGN KEY([user_id])
REFERENCES [dbo].[Tbl_user] ([user_id])
GO

ALTER TABLE [dbo].[Tbl_video] CHECK CONSTRAINT [FK_Tbl_video_Tbl_user]
GO

USE [Videos]
GO

/****** Object:  Table [dbo].[Tbl_comentario]    Script Date: 10-Dec-19 11:41:22 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tbl_comentario](
	[comment_id] [int] NOT NULL,
	[comment_body] [varchar](500) NOT NULL,
	[user_id] [int] NOT NULL,
	[video_id] [int] NOT NULL,
 CONSTRAINT [PK_Tbl_comentario] PRIMARY KEY CLUSTERED 
(
	[comment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Tbl_comentario]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_comentario_Tbl_user] FOREIGN KEY([user_id])
REFERENCES [dbo].[Tbl_user] ([user_id])
GO

ALTER TABLE [dbo].[Tbl_comentario] CHECK CONSTRAINT [FK_Tbl_comentario_Tbl_user]
GO

ALTER TABLE [dbo].[Tbl_comentario]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_comentario_Tbl_video] FOREIGN KEY([comment_id])
REFERENCES [dbo].[Tbl_video] ([video_id])
GO

ALTER TABLE [dbo].[Tbl_comentario] CHECK CONSTRAINT [FK_Tbl_comentario_Tbl_video]
GO

USE [Videos]
GO

/****** Object:  Table [dbo].[Tbl_like]    Script Date: 10-Dec-19 11:41:35 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tbl_like](
	[like_id] [int] NOT NULL,
	[video_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
	[like_estatus] [bit], 
 CONSTRAINT [PK_Tbl_like] PRIMARY KEY CLUSTERED 
(
	[like_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Tbl_like]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_like_Tbl_user] FOREIGN KEY([user_id])
REFERENCES [dbo].[Tbl_user] ([user_id])
GO

ALTER TABLE [dbo].[Tbl_like] CHECK CONSTRAINT [FK_Tbl_like_Tbl_user]
GO

ALTER TABLE [dbo].[Tbl_like]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_like_Tbl_video] FOREIGN KEY([video_id])
REFERENCES [dbo].[Tbl_video] ([video_id])
GO

ALTER TABLE [dbo].[Tbl_like] CHECK CONSTRAINT [FK_Tbl_like_Tbl_video]
GO

