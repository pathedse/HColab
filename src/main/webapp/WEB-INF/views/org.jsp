<%@ page contentType="text/html;charset=UTF-8" language="java" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="orgApp">
<head>
	<title>Organisations</title>
	
	<%@include file="includes/commonresources.jsp"  %>
	
	<script src="/resources/jslib/angular.js"></script>
	
	<script>
	window.dataObject = {
			organisation : {
				name : 'BurgarKedjan',
				company : [
					{
						companyId : 'bk01',
						name : 'Kalles färska burgare',
						location : 'Gamla stan'},
					{
						companyId : 'bk02',
						name : 'Bennys Burger',
						location : 'Vasastan'
					}
				]
		}
	};

	angular.module('orgApp',[])
		.controller('OrganisationListController', function(){
			var orgList = this;
			orgList.name = window.dataObject.organisation.name
			orgList.companies = window.dataObject.organisation.company;
		});
	</script>
</head>
<body>

	<%@include file="includes/headermenu.jsp" %>
	
	<!-- Main Content -->
	
	<div class="container" style="padding-top: 150px">
	
		<div ng-controller="OrganisationListController as orgList">
			<h1>Organisation {{orgList.name}}</h1>
			
			<div>
				<div ng-repeat="company in orgList.companies">
					<h2 data-id="{{company.companyId}}" >{{company.name}}</h2>
					<span>Located at {{company.location}}</span>
				</div>
			</div>			
			<input type="text" ng-model="stuff" placeholder="Enter stuff" /><br>
			{{stuff}}
		</div> 	
	</div>


	<%@include file="includes/commonfoot.jsp" %>
	<script>
		var dataObj = ${org};	
	</script>
</body>
</html>