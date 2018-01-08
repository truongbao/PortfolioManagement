<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<div class="main-content" id="portfolio">
	<h1 class="main-heading">ポートフォリオ設定一覧</h1>
	<!-- List setting portfolio -->

	<div class="main-summary portfolio-unit">
		<form class="form-create">

			<div class="form-group">

				<div class="csv-setting-bao">
					<!-- thông báo thành công hay thất bại -->
					<!--ERROR = 1;SUCCESS = 2; WARNING = 3;  -->
					<c:if test="${not empty msg }">
						<c:if test="${msg.status == 2}">
							<div class="alert alert-success">
								<div class="block-infor">
									<i class="fa fa-info-circle" aria-hidden="true"></i> <label>
										<strong>Success!</strong>${msg.message}</label>
								</div>
							</div>
						</c:if>
						<c:if test="${msg.status == 1} ">
							<div class="alert alert-warning">
								<div class="block-error">
									<i class="fa fa-exclamation" aria-hidden="true"></i> <label>
										<strong>Warning!</strong>${msg.message}</label>
								</div>
							</div>
						</c:if>

					</c:if>

					<c:choose>
						<c:when test="${objUQS !=null && objUQS.state == 'booking' }">
							<div class="alert alert-danger">
								<div class="block-error">
									<i class="fa fa-exclamation" aria-hidden="true"></i> <label>
										Là trạng thái update booking. Hãy chờ 1 lát... </label>
									<!-- thong bao -->
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<c:if test="${objUQS !=null && objUQS.state == 'is_executing' }">
								<div class="alert alert-danger">
									<div class="block-error">
										<i class="fa fa-exclamation" aria-hidden="true"></i> <label>
											Đang thực thi.Vui lòng chờ một lát... </label>
										<!-- thong bao -->
									</div>
								</div>
							</c:if>
						</c:otherwise>
					</c:choose>


					<div class="row">
						<div class="col-md-3"></div>

						<div class="col-md-3 text-center">
							<!--<button class="btn btn-blue-dark btn-csv "> 問 題 情 報 更 新  </button> </br> </br>-->
							<a
								href="${pageContext.request.contextPath}/admin/portfolio/update-exercise-information"
								class="btn btn-blue-dark btn-csv"> 問 題 情 報 更 新 </a> </br> </br>
							<!-- Update thông tin bài tập -->
						</div>

						<div class="col-md-3 text-center">
							<c:set var="refresh" value="refresh-infomation"></c:set>
							<a
								href=" ${pageContext.request.contextPath}/admin/portfolio/index/${refresh}"
								class="btn btn-blue-dark btn-csv"> 更 新 </a> </br> </br>
							<!-- Update -->
						</div>

						<div class="col-md-3"></div>
					</div>

					<fmt:formatDate var="fmtDateUpdate" value="${objUQS.updated_at}"
						pattern="yyyy.MM.dd hh:mm:ss" />
					<c:if test="${objUQS !=null && objUQS.state == 'finished' }">
						<div class="row">
							<h4 class="h4_bao" style="text-align: center;">問題情報更新日時 :
								${fmtDateUpdate}</h4>
						</div>
					</c:if>

					<div class="table-responsive">

						<table class="table table-blue table_portfolio_groups">
							<thead>
								<tr>
									<th class="th_bao">ID</th>
									<th class="th_bao">管理名</th>
									<!--ten quan ly-->
									<th class="th_bao">作成日時</th>
									<!-- Ngày giờ tạo -->
									<th class="th_bao">更新日時</th>
									<!-- Ngày giờ update -->
									<th class="th_bao">最終集計完了日時</th>
									<!-- Ngày giờ hoàn thành thống kê cuối cùng -->
									<th class="th_bao">操作</th>
									<!-- Thao tác-->
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${listSPConfiguration}" var="objSPCF">
									<c:set var="urlDetail"
										value="${pageContext.request.contextPath}/admin/portfolio/detail/${objSPCF.id}"></c:set>
									<fmt:formatDate var="fmtDateCreate"
										value="${objSPCF.created_at}" pattern="yyyy.MM.dd hh:mm" />
									<fmt:formatDate var="fmtDateUpdate"
										value="${objSPCF.updated_at}" pattern="yyyy.MM.dd hh:mm" />
									<fmt:formatDate var="fmtDateAggregationFinished"
										value="${objSPCF.aggregation_finished_at}"
										pattern="yyyy.MM.dd hh:mm" />

									<tr>
										<td class="td_bao">${objSPCF.id}</td>
										<td class="td_bao">${objSPCF.name}</td>
										<td class="td_bao">${fmtDateCreate}</td>
										<td class="td_bao">${fmtDateUpdate}</td>
										<td class="td_bao">${fmtDateAggregationFinished}</td>
										<td class="td_bao"><a href="${urlDetail}"
											class="btn btn-blue-dark-detail-b btn-w190-bao"> 詳細 </a> <!-- Chi tiet-->
										</td>
									</tr>

								</c:forEach>


							</tbody>
						</table>

					</div>


					<div style="margin-bottom: 180px;"></div>
				</div>

			</div>

		</form>
	</div>
</div>



