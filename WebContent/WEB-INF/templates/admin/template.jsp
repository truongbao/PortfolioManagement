<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portfolio Management</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
		
        <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/admin/css/vendor.css">
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/admin/css/style.css">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/templates/admin/css/style_69.css">
       
        <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/admin/css/select_style.css">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/templates/admin/css/style_72.css">
		
		
    </head>
    <body class="">        
     <div class="wrapper ">
		
        <div class="container-fluid container-body-fixed">
		
		  <div class="col-12"> 
		   
				<tiles:insertAttribute name="left_bar"></tiles:insertAttribute>
				
                <div class="gap"></div>
    
                <tiles:insertAttribute name="content"></tiles:insertAttribute>
				
		       </div>   <!-- col-12-->
				
            </div>
        </div>
		
		<script src='${pageContext.request.contextPath}/templates/admin/js/jquery.min.js'></script>
        <script  src="${pageContext.request.contextPath}/templates/admin/js/select_change.js"></script>
        <script  src="${pageContext.request.contextPath}/templates/admin/js/AjaxAPI.js"></script>
        
    </body>
</html>

