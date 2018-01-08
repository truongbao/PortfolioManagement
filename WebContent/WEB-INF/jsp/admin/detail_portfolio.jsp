<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="main-content" id="portfolio">
	<h1 class="main-heading">ポートフォリオ設定詳細表示 (Detail)</h1>
	<div class="main-summary portfolio-unit">

		<form class="form-create" action="" method="">


			<div class="csv-setting">
				<p class="p1_le">
					<strong> 管理名 </strong> &nbsp;&nbsp;&nbsp; <span>
						${listname.name}</span>
				</p>
			</div>


			<div class="csv-setting">
				<p class="p2_le">
					<strong> グループ種別 </strong>
				</p>
			</div>

			<%-- <c:forEach items="${listGroup }" var="obj">
				<div class="csv-setting" style="margin-left: 46px;">
					<p class="p3_le">
						<strong> ${obj.group_secern_name } </strong> &nbsp;&nbsp;&nbsp; <span>
							${obj.group_name } </span>
					</p>
				</div>
			</c:forEach> --%>

			<c:forEach items="${listPortfolioGroup }" var="obj">
				<div class="csv-setting" style="margin-left: 46px;">
					<p class="p4_le">
						<strong> ${obj.group_secern_name } </strong> &nbsp;&nbsp;&nbsp; <span>
							${obj.group_name } </span>
					</p>
				</div>
			</c:forEach>


			<div class="csv-setting">
				<p class="p5_le">
					<strong> 対象科目 </strong>
				</p>
			</div>

	<c:forEach items="${listPortfolioCourse }" var="obj">
			<div class="csv-setting" style="margin-left: 46px;">
				<p class="p6_le">
					<strong> ${obj.course_name } </strong>
				</p>
			</div>


			<div class="csv-setting" style="margin-left: 46px;">
				<p class="p7_le">
					<strong>  パターン${obj.level } </strong>
				</p>
			</div>


			<div class="csv-setting" style="margin-left: 46px;">
				<div class="mar_top">
					<div class="left_le" style="float: left;">
						<p class="p8_le">
							<strong> 対象属性 </strong>
						</p>
					</div>
					<div class="right_le" style="float: left; margin-left: 15px;">
						<ul style="list-style: none;">
						<c:forEach
									items="${obj.level_list[0].question_attribute_list}"
									var="obj1">
							<li>${obj1.question_attribute_name}</li>
							</c:forEach>
						</ul>

					</div>
				</div>

				<div class="clr" style="clear: both;"></div>
			</div>
			</c:forEach>

<!-- 
			<div class="csv-setting" style="margin-left: 46px;">
				<p class="p9_le">
					<strong> 数学コース </strong>
				</p>
			</div>

			<div class="csv-setting" style="margin-left: 46px;">
				<p class="p10_le">
					<strong> 単元パターン1 </strong>
				</p>
			</div>

			<div class="csv-setting" style="margin-left: 46px;">

				<div class="mar_top">
					<div class="left_le" style="float: left;">
						<p class="p11_le">
							<strong> 対象属性 </strong>
						</p>
					</div>

					<div class="right_le" style="float: left; margin-left: 15px;">
						<ul style="list-style: none;">
							<li>...</li>
							<li>...</li>
							<li>...</li>
						</ul>
					</div>
				</div>
			</div>
 -->
			<div class="clr" style="clear: both;"></div>

			<div class="csv-setting"></div>




			<div class="btn-management ">
				<div class="row">


					<div class="col-md-4 text-center">
						<!--  <button class="btn btn-blue-dark btn-w190">Delete</button> </br> </br> -->
						<a
							href="${pageContext.request.contextPath}/admin/portfolio/delete/${id_spcf }"
							onclick="return confirm('Bạn có chắc chắn muốn xóa !')"
							class="btn btn-blue-dark btn-w190"> Delete </a> </br> </br>
					</div>
					<div class="col-md-4 text-center">
						<a href="${pageContext.request.contextPath}/admin/portfolio/edit/${id_spcf}"
							class="btn btn-blue-dark btn-w190"> Edit </a> </br> </br>
					</div>
					<div class="col-md-4 text-center">
						<a href="${pageContext.request.contextPath}/admin/portfolio/index"
							class="btn btn-blue-dark btn-w190"> Back </a> </br> </br>
					</div>


				</div>

			</div>

		</form>

	</div>
</div>



