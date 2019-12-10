-- =============================================
-- Author:		FLAVIA VEIZAGA
-- Create date: 10/12/2019 
-- Description:	CREACION DEL PROCEDIMIENTO ALMACENADO PARA LA OBTENCION DE LISTA DE USUARIOS
-- =============================================
CREATE PROCEDURE GetListUser
AS
BEGIN
	SET NOCOUNT ON;
	SELECT USER_FULLNAME AS 'FULL NAME', USER_NAME AS NAME, USER_EMAIL AS EMAIL
	FROM TBL_USER;
END
GO


-- ================================================
-- Template generated from Template Explorer using:
-- Create Procedure (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- This block of comments will not be included in
-- the definition of the procedure.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		FLAVIA VEIZAGA
-- Create date: 10/12/2019 
-- Description:	CREACION DEL PROCEDIMIENTO ALMACENADO PARA LA OBTENCION DE LISTA DE COMENTARIOS POR USUARIO
-- =============================================
ALTER PROCEDURE getListCommentByUser
	@USER_ID INT
AS
BEGIN
	SET NOCOUNT ON;
	SELECT v.video_name AS 'VIDEO NAME', U.user_name AS 'USER NAME', C.comment_body AS 'COMMENT'  
	FROM TBL_USER U, TBL_VIDEO V, TBL_COMENTARIO C
	WHERE V.video_id = C.video_id AND C.user_id = @USER_ID AND U.USER_ID = @USER_ID
	ORDER BY V.video_name;
END
GO