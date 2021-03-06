<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="main-content" id="portfolio">
	<h1 class="main-heading">ポートフォリオ用科目設定画面</h1>
	<div class="main-summary portfolio-unit">
		<form:form class="form-horizontal"
			action="${pageContext.request.contextPath}/admin/portfolio/insert_spc"
			method="post" modelAttribute="spcw">
			<div class="form-group">
				<label class="control-label col-sm-2 label_69">現行設定</label>
				<div class="col-sm-5">
					<input type="text" name="spcf.name" class="form-control" value="">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2 label_69">対象グループ</label>
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
									<td class="group_height td_69">
										${objlist.group_secern_name}</td>
									<td class="group_height group_list"><select
										name="pgs[${status.index}].group_id" class="custom_select">
											<c:forEach items="${objlist.groups}" var="objgroup">
												<option value="${objgroup.id}">${objgroup.group_name}</option>
											</c:forEach>
									</select></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2 label_69">対象科目</label>
				<div class="col-sm-3 list_course">
					<select id="SP_Course_Selected" multiple="multiple"
						class="form-control">
						<c:forEach items="${spcwoutput.spcs}" var="objCourse">
							<option value="${objCourse.id}">${objCourse.course_name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-sm-3 loading" style="display: none">
					<div class="center">
						<img alt="loader.gif"
							src="${pageContext.request.contextPath}/templates/admin/images/loader.gif" />
					</div>
				</div>
			</div>
			<!-- xử dụng khi load dữ liệu -->

			<div id="SPCourseForm"></div>
			<div class="btn-management">
				<button class="btn btn-blue-dark btn-w190">作成</button>
				<!-- Tao -->
			</div>

		</form:form>

	</div>
</div>

