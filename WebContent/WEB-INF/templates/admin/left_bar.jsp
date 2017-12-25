<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

      <div class="main-sidebar" >
				<ul class="nav">
					<li>一般ユーザー管理</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/admin/portfolio/index">
							<p class="p_bao"> Show List Portfolio </p>
						</a>
					</li>
					
					 <li>  <!-- class="active" -->
						<a href="${pageContext.request.contextPath}/admin/portfolio/create">
							<p class="p_bao"> Create Portfolio </p>
						</a>
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/admin/portfolio/edit">
							<p class="p_bao"> Edit Portfolio</p>
						</a>
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/admin/portfolio/detail">
							<p class="p_bao"> Detail Portfolio</p>
						</a>
					</li>
					
				</ul>      
	    </div>