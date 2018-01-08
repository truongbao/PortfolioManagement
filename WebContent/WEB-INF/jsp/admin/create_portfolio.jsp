<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="main-content" id="portfolio">

	<h1 class="main-heading">ポートフォリオ用科目設定画面</h1>
	<div class="main-summary portfolio-unit">
		<form:form id="spc_insert_form" class="form-horizontal"
			action="${pageContext.request.contextPath}/admin/portfolio/create"
			method="post" modelAttribute="spcw">

			<div class="form-group">
				<label class="control-label col-sm-2 label_align_left">現行設定</label>
				<div class="col-sm-5">
					<input id="spcf_name" type="text" name="spcf.name"
						class="form-control" value="${spcwoutput.spcf.name}">
				</div>
				<div class="col-sm-5 spc_name_error ">

					<label class="control-label label_align_left label_valid_error"
						id="spc_name_error"><form:errors path="spcf" /></label>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2 label_align_left">対象グループ</label>
				<!--tên quản lý-->
				<div class="col-sm-10">
					<table class="table table-blue table_portfolio_groups">
						<thead>
							<tr>
								<th class="group_secern_name">種別</th>
								<th class="group_name">項目</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${spcwoutput.gss}" var="objlist"
								varStatus="status">
								<tr>
									<td class="group_height td_align_left"><input
										type="hidden" name="gss[${status.index}].id"
										value="${objlist.id}" /> <input type="hidden"
										name="gss[${status.index}].group_secern_name"
										value="${objlist.group_secern_name}" />
										${objlist.group_secern_name}</td>
									<td class="group_height group_list"><select
										name="gss[${status.index}].groups[0].id" class="custom_select">
											<c:forEach items="${objlist.groups}" var="objgroup">
												<option value="${objgroup.id}" <c:if test="${objgroup.isSelected==1}"> selected="1" </c:if>>${objgroup.group_name}</option>
											</c:forEach>
									</select></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2 label_align_left ">対象科目</label>
				<div class="col-sm-3 list_course">
					<select id="SP_Course_Selected" multiple="multiple"
						class="form-control">
						<c:forEach items="${spcwoutput.spcs}" var="objSPCourse">
							<option value="${objSPCourse.id}"
								<c:if test="${ objSPCourse.isSelected == 1}">selected="selected"</c:if>>${objSPCourse.course_name}</option>
						</c:forEach>
					</select>
				</div>

				<div class="col-sm-5">
					<div class=" col-sm-12 sp_course_error">
						<label class="control-label label_align_left label_valid_error"
							id="spc_list_error"><form:errors path="pccs" /></label>
					</div>
					<div class="col-sm-3 loading" style="display: none">
						<div class="center">
							<img alt="loader.gif"
								src="${pageContext.request.contextPath}/templates/admin/images/loader.gif" />
						</div>
					</div>
				</div>

			</div>
			<!-- xử dụng khi load dữ liệu -->
			<div id="SPCourseForm" >
				<!--nếu đã chọn từ trước -->
				<c:set var="index" value="-1"></c:set>
				<c:forEach items="${spcwoutput.spcs}" var="objSPCourse">
					<c:if test="${ objSPCourse.isSelected == 1}">
						<c:set var="index" value="${index+1}"></c:set>
						<div id="one_sp_course" class="row">
							<h1 class="one_course_name">${objSPCourse.course_name}</h1>
							<div class="form-group">
								<label class="control-label  col-sm-3 col-sm-offset-1 label_69">単元タグ設定パターン</label>
								<div class="col-sm-4">
									<div class="level_list">
										<select class="custom_select_level"
											name="pccs[${index}].level"
											onchange="list_lv_change(this,${objSPCourse.id});">
											<c:forEach items="${objSPCourse.level_list}" var="one_level">
												<option value="${one_level.level }"
													<c:if test="${one_level.level==objSPCourse.level_selected}"> selected="1" </c:if>>
													パターン${one_level.level}</option>
											</c:forEach>
										</select> <input type="hidden"
											name="pccs[${index}].service_portfolio_course_id"
											value="${objSPCourse.id}">
									</div>
								</div>
								<label id="label_level_error0"
									class="label_level_error control-label col-sm-3 "></label>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2 col-sm-offset-2 label_69">単元タグ</label>
								<div class="col-sm-8">
									<ul class="patern_list "
										id='question_attribute_list_from_spcourse_${objSPCourse.id }'>
										<c:forEach
											items="${objSPCourse.level_list[objSPCourse.level_selected-1].question_attribute_list}"
											var="one_qa">
											<li>${one_qa.question_attribute_name}</li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>

			<div class="btn-management">
				<button id="btnSubmit" class="btn btn-blue-dark btn-w190">作成</button>
				<!-- Tao -->
			</div>

		</form:form>

	</div>
</div>

